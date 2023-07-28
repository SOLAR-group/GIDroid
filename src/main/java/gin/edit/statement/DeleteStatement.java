package gin.edit.statement;

import gin.SourceFile;
import gin.SourceFileTree;
import gin.edit.Edit;
import gin.misc.BlockedByJavaParserException;

import java.util.Random;

public class DeleteStatement extends StatementEdit {

    private final String sourceFilename;
    private final int statementToDelete;

    /**
     * create a random deletestatement for the given sourcefile, using the provided RNG
     *
     * @param sourceFile to create an edit for
     * @param rng        random number generator, used to choose the target statements
     */
    public DeleteStatement(SourceFile sourceFile, Random rng) {
        this(sourceFile.getFilename(), ((SourceFileTree) sourceFile).getRandomStatementID(true, rng));
    }

    public DeleteStatement(String filename, int statementToDelete) {
        this.sourceFilename = filename;
        this.statementToDelete = statementToDelete;
    }

    @Override
    public SourceFile apply(SourceFile sourceFile) {
        SourceFileTree sf = (SourceFileTree) sourceFile;
        try {
            return sf.removeStatement(statementToDelete);
        } catch (BlockedByJavaParserException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName() + " " + sourceFilename + ":" + statementToDelete;
    }

    public static Edit fromString(String description) {
        String[] tokens = description.split("\\s+");
        String[] tokens2 = tokens[1].split(":");
        String filename = tokens2[0];
        int statement = Integer.parseInt(tokens2[1]);
        return new DeleteStatement(filename, statement);
    }

}
