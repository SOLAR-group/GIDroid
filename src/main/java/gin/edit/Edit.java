package gin.edit;

import gin.SourceFile;
import gin.edit.insert.InsertBreakWithIf;
import gin.edit.insert.InsertContinue;
import gin.edit.insert.InsertContinueWithIf;
import gin.edit.insert.InsertReturnWithIf;
import gin.edit.line.CopyLine;
import gin.edit.line.DeleteLine;
import gin.edit.line.ReplaceLine;
import gin.edit.line.SwapLine;
import gin.edit.matched.MatchedCopyStatement;
import gin.edit.matched.MatchedDeleteStatement;
import gin.edit.matched.MatchedReplaceStatement;
import gin.edit.matched.MatchedSwapStatement;
import gin.edit.modifynode.BinaryOperatorReplacement;
import gin.edit.modifynode.UnaryOperatorReplacement;
import gin.edit.statement.*;
import org.pmw.tinylog.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Abstract class representing an Edit.
 * <p>
 * Java fail: can't be abstract and static.
 * If you want to be able to parse your patches from a
 * string, you'll need to implement this method
 * public static Edit fromString(String description);
 * <p>
 * (this is needed for at least PatchAnalyser)
 *
 * <p>
 * Furthermore, every edit needs a (SourceFile,Random) constructor for the places that
 * a new edit is created
 */
public abstract class Edit {

    public enum EditType {LINE, STATEMENT, MODIFY_STATEMENT, MATCHED_STATEMENT, INSERT_STATEMENT, ADD}

    public abstract EditType getEditType();

    /**
     * @param sourceFile on which to apply the edit
     * @return updated copy of the sourceFile; or null if the edit couldn't be applied for some reason
     */
    public abstract SourceFile apply(SourceFile sourceFile);

    /**
     * @param editType
     * @return edit classes for a given edit type; for line/statement/matched these are delete/copy/replace/swap (move is excluded)
     */
    public static List<Class<? extends Edit>> getEditClassesOfType(EditType editType) {
        switch (editType) {
            case LINE:
                return Arrays.asList(DeleteLine.class, CopyLine.class, ReplaceLine.class, SwapLine.class);
            case STATEMENT:
                return Arrays.asList(DeleteStatement.class, CopyStatement.class, ReplaceStatement.class, SwapStatement.class, CacheEdit.class, ClassCacheEdit.class, addIfStatementEdit.class);
            case MATCHED_STATEMENT:
                return Arrays.asList(MatchedDeleteStatement.class, MatchedCopyStatement.class, MatchedReplaceStatement.class, MatchedSwapStatement.class);
            case MODIFY_STATEMENT:
                return Arrays.asList(BinaryOperatorReplacement.class, UnaryOperatorReplacement.class);

            case ADD:
                return Arrays.asList(addIfStatementEdit.class, DeleteStatement.class, InsertBreakWithIf.class, InsertContinueWithIf.class, InsertReturnWithIf.class);
            default:
                return Collections.emptyList();
        }
    }

    public static List<Class<? extends Edit>> getEditClassesOfTypes(List<EditType> editTypes) {
        List<Class<? extends Edit>> l = new ArrayList<>();
        for (EditType editType : editTypes) {
            l.addAll(getEditClassesOfType(editType));
        }
        return l;
    }

    /**
     * string is comma separated
     */
    public static List<Class<? extends Edit>> parseEditClassesFromString(String s) {
        String[] classNames = s.split(",");
        List<Class<? extends Edit>> l = new ArrayList<>();
        for (String className : classNames) {
            // for each of these, see if it's an edit type first!
            try {
                l.addAll(Edit.getEditClassesOfType(EditType.valueOf(className)));
            } catch (IllegalArgumentException e) {
                // not an edit type? well, look for class names instead.
                try {
                    l.add(Class.forName(className).asSubclass(Edit.class));
                } catch (ClassNotFoundException e2) {
                    Logger.warn("Edit type / class not found: " + className);
                }
            }
        }

        return l;
    }
}
