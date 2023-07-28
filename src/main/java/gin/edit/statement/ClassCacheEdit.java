package gin.edit.statement;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.PrimitiveType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.resolution.types.ResolvedType;
import gin.SourceFile;
import gin.SourceFileTree;
import gin.edit.Edit;

import java.time.Instant;
import java.util.*;

import static com.google.common.primitives.Ints.max;

public class ClassCacheEdit extends StatementEdit {

    public String sourceFile;
    private final List<Integer> toCache;
    private final String method;
    private ResolvedType type;


    public ClassCacheEdit(SourceFile sf, Random rng) {
        toCache = new ArrayList<>();
        SourceFileTree sourceFile = (SourceFileTree) sf;
        this.sourceFile = sourceFile.getFilename();
        int len = sourceFile.classCachePoints.size();
        if (len == 0) {
            throw new IllegalArgumentException("not cachable");
        }
        SourceFileTree.CachePoint point = sourceFile.classCachePoints.get(rng.nextInt(len));
        method = point.method;
        type = point.type;
        Integer points = point.count;
        Integer noCaches = max(1, rng.nextInt(points));
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

    public ClassCacheEdit(String sourceFile, String methodCall, ArrayList<Integer> toCache) {
        this.sourceFile = sourceFile;
        this.method = methodCall;
        this.toCache = toCache;
    }

    @Override
    public SourceFile apply(SourceFile sourceFile) {
        Integer cacheNo = Math.toIntExact(Instant.now().getEpochSecond());
        SourceFileTree sft = (SourceFileTree) sourceFile;
        sft = sft.addObjectsImport();


        int bid = 0;
        List<Integer> parentNodeIDs = sft.getNodeIDsByClass(true, MethodDeclaration.class);

        MethodCallExpr methodClone = null;
        for (Integer i : parentNodeIDs) {
            Node parentNode = sft.getNode(i);
            for (MethodCallExpr methodNode : parentNode.findAll(MethodCallExpr.class)) {
                if (!methodNode.toString().equals(method)) {
                    continue;
                }
                methodClone = methodNode.clone();
            }
        }
        if (methodClone == null) {
            return sft;
        }
        Type ttype;
        if (type == null) {
            type = sft.getType(methodClone);
        }
        if (type.isPrimitive()) {
            ttype = new PrimitiveType(PrimitiveType.Primitive.valueOf(type.describe().toUpperCase()));
        } else if (type.isReferenceType()) {
            ttype = new ClassOrInterfaceType(type.describe());
        } else if (type.isTypeVariable()) {
            ttype = new ClassOrInterfaceType(type.describe());
        } else {
            return sourceFile;
        }
        sft = sft.addFieldDeclaration(ttype, "ginCache" + cacheNo, Modifier.Keyword.PRIVATE);

        int ind = 0;
        for (Integer i : sft.allNodes.keySet()) {
            Node node = sft.allNodes.get(i);
            if (node == null) {
                continue;
            }
            if (node.getClass().equals(MethodCallExpr.class)) {
                if (node.toString().equals(method)) {
                    if (!node.getParentNode().get().toString().contains(cacheNo.toString())) {
                        if (toCache.contains(ind)) {
                            sft = sft.replaceNode(i, new NameExpr("ginCache" + cacheNo));
                        }
                        ind++;
                    }
                }
            }
        }

        //If null assign

        IfStmt ifStmt = new IfStmt();
        NameExpr left = new NameExpr("ginCache" + cacheNo);
        NodeList<Expression> args = new NodeList<>();
        args.add(left);
        //BinaryExpr condition =  new BinaryExpr(left,new NullLiteralExpr(), BinaryExpr.Operator.EQUALS);
        MethodCallExpr condition = new MethodCallExpr(new NameExpr("Objects"), new SimpleName("isNull"), args);
        AssignExpr assignExpr = new AssignExpr();
        ExpressionStmt thenStmt = new ExpressionStmt();

        assignExpr.setTarget(left);
        assignExpr.setValue(methodClone);
        thenStmt.setExpression(assignExpr);
        ifStmt.setThenStmt(thenStmt);
        ifStmt.setCondition(condition);
        ifStmt = ifStmt.clone();

        // add if statement replace method calls
        ind = 0;


        for (Integer i : parentNodeIDs) {
            Node parentNode = sft.getNode(i);
            for (Node node : parentNode.getChildNodesByType(NameExpr.class)) {
                if (node.toString().contains(cacheNo.toString())) {
                    if (toCache.contains(ind)) {
                        Node ancestor = node.getParentNode().get();
                        while (!(ancestor instanceof BlockStmt)) {
                            ancestor = ancestor.getParentNode().get();
                        }
                        BlockStmt insert = (BlockStmt) ancestor;
                        int insertionPoint = 0;
                        for (Statement statement : insert.getStatements()) {
                            if (statement.isAncestorOf(node)) {
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

                        sft = sft.insertStatement(bid, insertionPoint, ifStmt);

                        sft = (SourceFileTree) sft.copyOf();
                    }
                    ind++;
                }
            }
        }

        return sft;

    }


    public String toString() {
        String out = this.getClass().getCanonicalName() + " " + sourceFile + " " + method;
        for (int call : toCache) {
            out += " " + call;
        }
        return out;
    }

    public static Edit fromString(String description) {
        String[] tokens = description.split("\\s+");
        String sourceFile = tokens[1];
        ArrayList<Integer> toCache = new ArrayList<>();
        int ind = tokens.length - 1;
        while (!tokens[ind].contains(")")) {
            toCache.add(Integer.valueOf(tokens[ind]));
            ind--;
        }
        String method = String.join(" ", Arrays.copyOfRange(tokens, 2, ind + 1));
        return new ClassCacheEdit(sourceFile, method, toCache);
    }


}
