package gin.misc;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.DataKey;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * This class provides utility methods to annotate JavaParser method AST nodes
 * with their fully qualified names. Call annotateCompilationUnit() to do the
 * grunt work.
 */
public class FullyQualifiedNames {

    /**
     * the key used to track fully qualified names for methods in JavaParser nodes
     */
    public static final DataKey<String> NODEKEY_FQ_METHOD_NAME = new DataKey<String>() {
    };

    /**
     * the key used to track numbers of anon inner classes in JavaParser nodes
     */
    public static final DataKey<Integer> NODEKEY_ANON_INNER_CLASS_NUM = new DataKey<Integer>() {
    };

    // general approach was suggested here:
    // https://github.com/javaparser/javaparser/issues/222
    // to find the class containing the field or the method
    // to find if a class is contained in another class
    // to find the package definition of the file hosting the class
    public static void annotateCompilationUnit(CompilationUnit cu) {

        // add a reference number to each anon inner class
        preProcessAnonInnerClasses(cu);

        // now, for every node in the CU, annotate with fully qualified name
        List<MethodDeclaration> nodes = cu.getChildNodesByType(MethodDeclaration.class);

        for (MethodDeclaration m : nodes) {
            m.setData(NODEKEY_FQ_METHOD_NAME, getFQName(m));
        }
    }

    /**
     * @param m - MethodDeclaration
     * @return the fully qualified name and signature for the specified method;
     * e.g. containing.package.TopLevelClass$InnerClass.myMethod(Foo,Bar)
     */
    public static String getFQName(MethodDeclaration m) {
        Node current = m;
        Node parent = m.getParentNode().orElse(null);

        // Get signature...
        String signature = m.getDeclarationAsString(false, false, false); // we don't use getSignature() as that doesn't include generics; this does.
        // Strip out return type if provided
        String prefix = signature.substring(0, signature.indexOf("("));
        if (prefix.contains(" ")) {
            String returnType = prefix.split("\\s")[0];
            signature = StringUtils.replaceOnce(signature, returnType, "").trim();
        }
        // Remove all spaces
        signature = signature.replaceAll("\\s", "");


        String name = "." + signature;

        while ((parent = current.getParentNode().orElse(null)) != null) {

            if ((current instanceof ClassOrInterfaceDeclaration) && (parent instanceof CompilationUnit)) { // top level class
                PackageDeclaration p = ((CompilationUnit) parent).getPackageDeclaration().orElse(null);

                if (p != null) {
                    name = p.getNameAsString() + "." + ((ClassOrInterfaceDeclaration) current).getNameAsString() + name;
                } else {
                    name = ((ClassOrInterfaceDeclaration) current).getNameAsString() + name;
                }
            } else if ((current instanceof EnumDeclaration) && (parent instanceof CompilationUnit)) { // top level enum
                PackageDeclaration p = ((CompilationUnit) parent).getPackageDeclaration().orElse(null);

                if (p != null) {
                    name = p.getNameAsString() + "." + ((EnumDeclaration) current).getNameAsString() + name;
                } else {
                    name = ((EnumDeclaration) current).getNameAsString() + name;
                }
            } else if (current instanceof ClassOrInterfaceDeclaration) { // non-top-level class with a name
                String curName = ((ClassOrInterfaceDeclaration) current).getNameAsString();
                name = "$" + curName + name;
            } else if ((current instanceof ObjectCreationExpr) && ((ObjectCreationExpr) current).getAnonymousClassBody().isPresent()) { // what we've seen so far is contained in an object creation expression, so an anonymous inner class
                int num = current.getData(NODEKEY_ANON_INNER_CLASS_NUM);
                name = "$" + num + name;
            }

            // ignore any methods other than the bottom-level one!
            current = parent;

        }

        return name;
    }

    /**
     * Annotate all anon inner classes with a number like javac would allocate
     * https://github.com/javaparser/javaparser/issues/138
     *
     * @param root - CompilationUnit
     */
    public static void preProcessAnonInnerClasses(CompilationUnit root) {
        preProcessAnonInnerClasses(root, 0, 1);
    }

    private static int preProcessAnonInnerClasses(Node currentNode, int level, int nextNumberAtThisLevel) {

        // look at all child nodes of this level:
        // (depth first search)
        for (Node childNode : currentNode.getChildNodes()) {

            // is the child an anon inner class?
            // (ObjectCreationExpr with an anon class body)
            // if so, annotate with a number
            if ((childNode instanceof ObjectCreationExpr) && (((ObjectCreationExpr) childNode).getAnonymousClassBody().isPresent())) {
                childNode.setData(NODEKEY_ANON_INNER_CLASS_NUM, nextNumberAtThisLevel);
                nextNumberAtThisLevel++;
            }

            // recursive call to look at the child nodes of this child
            if ((childNode instanceof ClassOrInterfaceDeclaration) || // named inner class
                    ((childNode instanceof ObjectCreationExpr) && (((ObjectCreationExpr) childNode).getAnonymousClassBody().isPresent()))) {   // anon inner class

                // if we're exploring child nodes of an inner class - any type -
                // then increment level and reset counter to 1
                preProcessAnonInnerClasses(childNode, level + 1, 1);

            } else {

                // otherwise continue with counter as it is at current level
                nextNumberAtThisLevel = preProcessAnonInnerClasses(childNode, level, nextNumberAtThisLevel);

            }
        }

        return nextNumberAtThisLevel;
    }

    /**
     * This will take the supplied method name, and:
     * if it appears to be fully qualified, return it unchanged
     * if it appears to be missing the package or top-level class name, it will add those, retrieved from the supplied CompilationUnit
     * <p>
     * This will not make any assumptions about inner classes:
     * the supplied method name must be relative to the top-level class
     *
     * @param methodName - String
     * @param cu         - CompilationUnit
     * @return methodName
     */
    public static String makeMethodNameFullyQualified(String methodName, CompilationUnit cu) {
        String className = getClassName(cu);
        PackageDeclaration p = cu.getPackageDeclaration().orElse(null);
        String packageName = p != null ? p.getNameAsString() + "." : "";

        if (!methodName.startsWith(packageName) || packageName.isEmpty()) {
            if (!methodName.startsWith(className)) {
                methodName = className + methodName;
            }
            methodName = packageName + methodName;
        }

        return methodName;
    }

    private static String getClassName(CompilationUnit cu) {
        List<ClassOrInterfaceDeclaration> l = cu.getChildNodesByType(ClassOrInterfaceDeclaration.class);
        if (!l.isEmpty()) {
            return l.get(0).getNameAsString() + ".";
        } else { // no top level class; maybe an enum instead?
            List<EnumDeclaration> l2 = cu.getChildNodesByType(EnumDeclaration.class);
            if (!l2.isEmpty()) {
                return l2.get(0).getNameAsString() + ".";
            }
        }

        // otherwise... no class name? shouldn't get here
        return "";
    }

}
