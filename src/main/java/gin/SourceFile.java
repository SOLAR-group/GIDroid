package gin;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import gin.edit.Edit;
import gin.edit.line.LineEdit;
import gin.misc.FullyQualifiedNames;
import org.apache.commons.lang3.StringUtils;
import org.pmw.tinylog.Logger;

import java.io.File;
import java.util.*;

/**
 * In practice SourceFile can be viewed as immutable. The only way it can be changed
 * is via the insert/delete line/statement/node or replaceNode methods, which
 * create and return a new SourceFile as part of their signature
 */
public abstract class SourceFile {

    protected final String filename;

    /**
     * high-level representation of the target methods
     */
    protected Set<TargetMethod> targetMethods;

    public SourceFile(String filename, Set<TargetMethod> targetMethods) {

        this.filename = filename;
        this.targetMethods = targetMethods;

    }

    public SourceFile(String filename, List<String> targetMethodNames) {

        this.filename = filename;

        if (targetMethodNames != null) {
            this.targetMethods = parseTargetMethods(targetMethodNames);
        }

    }

    public SourceFile(File file, String method) {
        this(file.getPath(), Arrays.asList(method));
    }


    public static SourceFile makeSourceFileForEditType(Class<? extends Edit> type, String filename, String targetMethodName) {
        return makeSourceFileForEditTypes(Collections.singletonList(type), filename, Arrays.asList(targetMethodName));
    }

    public static SourceFile makeSourceFileForEditType(Class<? extends Edit> type, String filename, List<String> targetMethodNames) {
        return makeSourceFileForEditTypes(Collections.singletonList(type), filename, targetMethodNames);
    }

    public static SourceFile makeSourceFileForEditTypes(List<Class<? extends Edit>> types, String filename, List<String> targetMethodNames, String cp) {
        boolean containsLines = false;
        boolean containsStatements = false;
        for (Class<? extends Edit> et : types) {
            if (LineEdit.class.isAssignableFrom(et)) {
                containsLines = true;
            } else {
                containsStatements = true;
            }
        }

        if (containsLines && containsStatements) {
            throw new IllegalArgumentException("Mixed line/statement edits not supported.");
        } else if (containsLines) {
            return new SourceFileLine(filename, targetMethodNames);
        } else {
            return new SourceFileTree(filename, targetMethodNames, cp);
        }
    }

    public static SourceFile makeSourceFileForEditTypes(List<Class<? extends Edit>> types, String filename, List<String> targetMethodNames) {
        return makeSourceFileForEditTypes(types, filename, targetMethodNames, "");
    }


    /**
     * @return a copy (clone) of this SourceFile object
     */
    public abstract SourceFile copyOf();


    /*================= the following are general purpose getters =====================*/

    public String getFilename() {
        String base = (new File(".")).getAbsolutePath();
        base = StringUtils.chop(base);
        String filePath = (new File(this.filename)).getAbsolutePath();
        String result = StringUtils.substringAfter(filePath, base);
        return result;
    }

    /**
     * @return the source - that is, a string of Java source ready for compilation
     */
    public abstract String getSource();


    public String toString() {
        return this.getSource();
    }

    /*============== the following are some helper methods and classes ==============*/

    private static Set<TargetMethod> parseTargetMethods(List<String> targetMethodNames) {
        Set<TargetMethod> methods = new HashSet<TargetMethod>();
        for (String method : targetMethodNames) {
            // Remove all spaces
            method = method.replaceAll("\\s", "");
            TargetMethod targetMethod = new TargetMethod(method);
            methods.add(targetMethod);
        }
        return methods;
    }

    private static class TargetMethod {

        TargetMethod(String name) {
            methodName = name;
            fullyQualifiedMethodName = name;
        }

        String methodName;
        String fullyQualifiedMethodName;

        @Override
        public String toString() {
            return methodName;
        }

        @Override
        public boolean equals(Object obj) {
            return (obj instanceof TargetMethod) &&
                    methodName.equals(((TargetMethod) obj).methodName);
        }

        @Override
        public int hashCode() {
            return methodName.hashCode();
        }

    }


    /**
     * @param cu            the compilation unit
     * @param targetMethods the target methods to get root nodes for
     * @return a list of nodes from the given compilation unit for
     * the target methods for this sourceFile
     * (assumes that the compilationUnit is for the same class)
     */
    protected static List<Node> getTargetMethodRootNodesFromCU(CompilationUnit cu, Set<TargetMethod> targetMethods) {

        if (targetMethods == null || targetMethods.size() == 0 ||
                (targetMethods.size() == 1 && targetMethods.contains(new TargetMethod("")))) {
            return Collections.singletonList(cu);
        }

        for (TargetMethod tm : targetMethods) {
            tm.fullyQualifiedMethodName = FullyQualifiedNames.makeMethodNameFullyQualified(tm.methodName, cu);
        }

        FullyQualifiedNames.annotateCompilationUnit(cu);

        Set<TargetMethod> notFound = new HashSet<>(targetMethods);

        List<Node> targetMethodNodes = new ArrayList<>();

        // first, the named nodes
        List<MethodDeclaration> nodes = cu.findAll(MethodDeclaration.class);

        for (MethodDeclaration m : nodes) {

            String methodName = m.getData(FullyQualifiedNames.NODEKEY_FQ_METHOD_NAME);

            if (methodName != null) {
                for (TargetMethod targetMethod : targetMethods) {

                    if (methodName.equals(targetMethod.fullyQualifiedMethodName)) {
                        targetMethodNodes.add(m);
                        notFound.remove(targetMethod);
                    }

                }
            }

        }

        if (!notFound.isEmpty()) {
            Logger.error("Couldn't find these methods: " + notFound);
            System.exit(-1);
        }

        return targetMethodNodes;

    }

}
