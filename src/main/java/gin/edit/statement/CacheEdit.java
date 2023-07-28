package gin.edit.statement;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.PrimitiveType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.resolution.types.ResolvedType;
import gin.SourceFile;
import gin.SourceFileTree;

import java.time.Instant;
import java.util.*;

import static com.google.common.primitives.Ints.max;

public class CacheEdit extends StatementEdit {


    public String sourceFile;
    private final List<Integer> toCache;
    private final String parentMethod;
    private final String method;
    private ResolvedType type;

    public CacheEdit(SourceFile sf, Random rng) {
        toCache = new ArrayList<>();
        SourceFileTree sourceFile = (SourceFileTree) sf;
        this.sourceFile = sourceFile.getFilename();
        int len = sourceFile.cachePoints.size();
        if (len == 0) {
            throw new IllegalArgumentException("not cachable");
        }
        SourceFileTree.CachePoint point = sourceFile.cachePoints.get(rng.nextInt(len));
        parentMethod = point.targetMethod.findAll(MethodDeclaration.class).get(0).getNameAsString();
        method = point.method;
        type = point.type;
        Integer points = point.count;
        Integer noCaches = max(2, rng.nextInt(points));
        for (int i = 0; i < noCaches; i++) {
            Integer cpoint = rng.nextInt(points);
            while (toCache.contains(cpoint)) {
                cpoint = rng.nextInt(points);
            }
            toCache.add(cpoint);
        }
        Collections.sort(toCache);
        return;
    }

    public CacheEdit(String sourceFile, String methodDec, String methodCall, ArrayList<Integer> toCache) {
        this.sourceFile = sourceFile;
        this.method = methodCall;
        this.parentMethod = methodDec;
        this.toCache = toCache;
    }

    @Override
    public SourceFile apply(SourceFile sourceFile) {
        Integer cacheNo = Math.toIntExact(Instant.now().getEpochSecond());
        SourceFileTree sft = (SourceFileTree) sourceFile;
        int bid = 0;
        List<Integer> parentNodeIDs = sft.getNodeIDsByClass(true, MethodDeclaration.class);
        Node parentNode = sft.getNode(0);
        for (Integer i : parentNodeIDs) {
            parentNode = sft.getNode(i);
            String name = ((MethodDeclaration) parentNode).getName().asString();
            if (name.equals(parentMethod)) {
                break;
            }
        }
        for (MethodCallExpr methodNode : parentNode.findAll(MethodCallExpr.class)) {
            if (!methodNode.toString().equals(method)) {
                continue;
            }
            Type ttype;
            if (type == null) {
                type = sft.getType(methodNode);
            }
            if (type.isPrimitive()) {
                ttype = new PrimitiveType(PrimitiveType.Primitive.valueOf(type.describe().toUpperCase()));
            } else if (type.isReferenceType()) {
                ttype = new ClassOrInterfaceType(type.describe());
            } else if (type.isTypeVariable()) {
                ttype = new ClassOrInterfaceType(type.describe());
            } else if (type.isArray()) {
                ttype = new ClassOrInterfaceType(type.describe());
            } else {
                return sourceFile;
            }
            BlockStmt insert;
            Node ancestor = methodNode;
            while (ancestor.getParentNode().get().getClass() != BlockStmt.class) {
                ancestor = ancestor.getParentNode().get();
            }
            insert = (BlockStmt) ancestor.getParentNode().get();

            int insertionPoint = 0;
            for (Statement statement : insert.getStatements()) {
                if (statement.isAncestorOf(methodNode)) {
                    break;
                }
                insertionPoint += 1;
            }

            for (int id : sft.getAllBlockIDs()) {
                if (sft.getNode(id).equals(insert)) {
                    insert = (BlockStmt) sft.getNode(id);
                    bid = id;
                }
            }

            List<Integer> inserts = sft.getInsertionPointsInBlock(bid);
            insertionPoint = inserts.get(insertionPoint);


            AssignExpr assignExpr = new AssignExpr(
                    new VariableDeclarationExpr(ttype, "ginCache" + cacheNo),
                    methodNode,
                    AssignExpr.Operator.ASSIGN);

            sft = sft.insertExpression(bid, insertionPoint, assignExpr);
            break;
        }
        int ind = -1;
        for (int i : sft.getNodeIDsByClass(true, MethodCallExpr.class)) {
            Node node = sft.getNode(i);
            if (node.toString().equals(method)) {
                if (toCache.contains(ind)) {
                    sft = sft.replaceNode(i, new NameExpr("ginCache" + cacheNo));
                }
                ind++;
            }
        }
        return sft;
    }

    public String toString() {
        String methodName = parentMethod;
        String out = this.getClass().getCanonicalName() + " " + sourceFile + " " + methodName + " " + method;
        for (int call : toCache) {
            out += " " + call;
        }
        return out;
    }

    public static CacheEdit fromString(String str) {
        String[] tokens = str.split(" ");
        String fileName = tokens[1];
        String parentMethod = tokens[2];
        ArrayList<Integer> toCache = new ArrayList<>();
        int ind = tokens.length - 1;
        while (!tokens[ind].contains(")")) {
            toCache.add(Integer.valueOf(tokens[ind]));
            ind--;
        }
        String method = String.join(" ", Arrays.copyOfRange(tokens, 3, ind + 1));

        return new CacheEdit(fileName, parentMethod, method, toCache);

    }
}
