package gin.edit.statement;

import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.type.PrimitiveType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.resolution.types.ResolvedType;
import gin.SourceFile;
import gin.SourceFileTree;
import gin.edit.Edit;
import gin.misc.BlockedByJavaParserException;

import javax.xml.transform.Source;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class addIfStatementEdit extends StatementEdit{


    public String destinationFilename;
    public int destinationBlock;
    public int destinationChildInBlock;
    private Expression condition;

    public addIfStatementEdit(SourceFile sourceFile, Random rng) {
        SourceFileTree sf = (SourceFileTree) sourceFile;
        List<Integer> targetMethodBlocks = sf.getBlockIDsInTargetMethod();
        int insertBlock = targetMethodBlocks.get(rng.nextInt(targetMethodBlocks.size()));
//        int insertBlock = 335;
//        int insertStatementID = 336;
        int insertStatementID = sf.getRandomInsertPointInBlock(insertBlock, rng);
        if (insertStatementID < 0) {
            insertStatementID = 0; // insert at start of empty block
        }

        this.destinationFilename = sourceFile.getFilename();
        this.destinationBlock = insertBlock;
        this.destinationChildInBlock = insertStatementID;

        Statement stmt = sf.getStatement(insertStatementID);
        // get vars in scope
        if (false) {
            List<SourceFileTree.VariableTypeAndName> vds = sf.getPrimitiveVariablesInScopeForStatement(insertStatementID);
            if (!vds.isEmpty()) {
                HashMap<SourceFileTree.VariableTypeAndName, Float> distances = new HashMap<>();
                float total = 0;
                for (SourceFileTree.VariableTypeAndName v : vds) {
                    float distance = 1/( (float) Math.abs(insertStatementID - v.id));
                    distances.put(v, distance);
                    total += distance;

                }

                for (SourceFileTree.VariableTypeAndName v : distances.keySet()) {
                    distances.put(v, distances.get(v) / total);
                }
                // choose one
                float prob = rng.nextFloat();
                float progress = 0;

                SourceFileTree.VariableTypeAndName v = null;
                for (SourceFileTree.VariableTypeAndName potential : distances.keySet()){
                    progress += distances.get(potential);
                    if (progress >=prob){
                        v = potential;
                    }
                }
                // build a comparison
                if (v.getType().asPrimitiveType().getType() == PrimitiveType.Primitive.BOOLEAN) {
                    // if a boolean, decide whether we want true or false
                    if (rng.nextBoolean()) {
                        condition = new NameExpr(v.getName());
                    } else {
                        condition = new UnaryExpr(new NameExpr(v.getName()), com.github.javaparser.ast.expr.UnaryExpr.Operator.LOGICAL_COMPLEMENT);
                    }
                } else {
                    // otherwise, for now, we just want to compare to zero
                    BinaryExpr.Operator operator = new BinaryExpr.Operator[]{BinaryExpr.Operator.LESS,
                            BinaryExpr.Operator.LESS_EQUALS,
                            BinaryExpr.Operator.EQUALS,
                            BinaryExpr.Operator.GREATER_EQUALS,
                            BinaryExpr.Operator.GREATER,
                    }[rng.nextInt(5)];
                    condition = new BinaryExpr(new NameExpr(v.getName()), new IntegerLiteralExpr(0), operator);
                }
            }
        }
        // codition based on method or field
        else {
            List<SourceFileTree.VariableTypeAndName> vds = sf.getNonePrimitiveVariablesInScopeForStatement(insertStatementID);

            if (!vds.isEmpty()) {
                HashMap<SourceFileTree.VariableTypeAndName, Float> distances = new HashMap<>();
                int total = 0;
                for (SourceFileTree.VariableTypeAndName v : vds) {
                    distances.put(v, (float) Math.abs(insertStatementID - v.id));
                    total += Math.abs(insertStatementID - v.id);

                }

                for (SourceFileTree.VariableTypeAndName v : distances.keySet()) {
                    distances.put(v, distances.get(v) / total);
                }
                // choose one
                float prob = rng.nextFloat();
                float progress = 0;

                SourceFileTree.VariableTypeAndName v = null;
                for (SourceFileTree.VariableTypeAndName potential : distances.keySet()){
                    progress += distances.get(potential);
                    if (progress >=prob){
                        v = potential;
                    }
                }
//                SourceFileTree.VariableTypeAndName v= vds.get(5);
                Type type = v.getType();
                ResolvedType resolvedType = type.resolve();
                List<ResolvedMethodDeclaration> methods = resolvedType.asReferenceType().getAllMethods();
                if (methods.size() > 0){
//                    ResolvedMethodDeclaration method = methods.get(50);
                    ResolvedMethodDeclaration method = methods.get(rng.nextInt(methods.size()));
                    if (method.getReturnType().isPrimitive() && method.getNumberOfParams() == 0){
                        if (PrimitiveType.Primitive.valueOf(method.getReturnType().describe().toUpperCase()) == PrimitiveType.Primitive.BOOLEAN) {
                            // if a boolean, decide whether we want true or false
                            if (false) {
                                condition = new MethodCallExpr(new NameExpr(v.getName()), new SimpleName(method.getName()), new NodeList<>());
                            } else {
                                condition = new UnaryExpr(new MethodCallExpr(new NameExpr(v.getName()), new SimpleName(method.getName()), new NodeList<>()), com.github.javaparser.ast.expr.UnaryExpr.Operator.LOGICAL_COMPLEMENT);
                            }
                        } else {
                            // otherwise, for now, we just want to compare to zero
                            BinaryExpr.Operator operator = new BinaryExpr.Operator[]{BinaryExpr.Operator.LESS,
                                    BinaryExpr.Operator.LESS_EQUALS,
                                    BinaryExpr.Operator.EQUALS,
                                    BinaryExpr.Operator.GREATER_EQUALS,
                                    BinaryExpr.Operator.GREATER,
                            }[rng.nextInt(5)];
                            condition = new BinaryExpr(new MethodCallExpr(new NameExpr(v.getName()), new SimpleName(method.getName()), new NodeList<>()), new IntegerLiteralExpr(0), operator);
                        }
                    }
                }


            }
        }
    }


    public addIfStatementEdit( String  destinationFilename, int destinationBlock, int destinationChildInBlock, Expression condition){
        this.destinationBlock = destinationBlock;
        this.destinationFilename = destinationFilename;
        this.destinationChildInBlock = destinationChildInBlock;
        this.condition = condition;
    }


    static Pattern p = Pattern.compile("\\[(.*?)\\]");

    public static Edit fromString(String string){
        String[] tokens = string.split(" ");
        String[] sfTokens = tokens[1].split(":");
        Expression condition = null;
        Matcher m = p.matcher(string);

        if (m.find()) { // i.e. an "if", not a plain break;
            String strStatement = m.group(1);

            if (strStatement.startsWith("!")) {
                strStatement = strStatement.substring(1);
                condition = new UnaryExpr(new NameExpr(strStatement), com.github.javaparser.ast.expr.UnaryExpr.Operator.LOGICAL_COMPLEMENT);
            } else if (!strStatement.matches("\\s+")) { // no whitespace
                // if the statement contains only a variable name, we've got a if (var)
                condition = new NameExpr(strStatement);
            } else {
                String[] condSplit = strStatement.split("\\s+");
                BinaryExpr.Operator o = BinaryExpr.Operator.valueOf(condSplit[1]);
                condition = new BinaryExpr(new NameExpr(condSplit[0]), new IntegerLiteralExpr(0), o);
            }
            return new addIfStatementEdit(sfTokens[0], Integer.parseInt(sfTokens[1]), Integer.parseInt(sfTokens[2]), condition);
        }
        return new addIfStatementEdit(sfTokens[0], Integer.parseInt(sfTokens[1]), Integer.parseInt(sfTokens[2]), new NameExpr("true"));
    }



    @Override
    public SourceFile apply(SourceFile sourceFile) {
        if (condition == null){
            return sourceFile;
        }
        SourceFileTree sf = (SourceFileTree) sourceFile;
        Statement stmt = sf.getStatement(destinationChildInBlock);
        IfStmt toInsert = new IfStmt();
        toInsert.setCondition(condition);
        toInsert.setThenStmt(stmt);
        sf = sf.replaceNode(destinationChildInBlock, toInsert);


        return sf;
    }


    public String toString() {
        if (condition == null){
            return "";
        }
        return this.getClass().getCanonicalName() + " " + destinationFilename + ":" + destinationBlock + ":" + destinationChildInBlock + " [" + condition.toString().replace("\n", "") +"]";
    }
}
