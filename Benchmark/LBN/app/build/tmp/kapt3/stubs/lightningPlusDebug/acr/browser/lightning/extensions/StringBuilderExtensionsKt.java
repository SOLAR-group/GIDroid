package acr.browser.lightning.extensions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u001a\u0016\u0010\u0004\u001a\u00020\u0005*\u00060\u0006j\u0002`\u00072\u0006\u0010\b\u001a\u00020\u0003\u001a\u0016\u0010\t\u001a\u00020\n*\u00060\u0006j\u0002`\u00072\u0006\u0010\b\u001a\u00020\u0003\u001a\u001e\u0010\u000b\u001a\u00020\f*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001\u001a\u001e\u0010\u000f\u001a\u00020\f*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003\u001a\u000e\u0010\u0010\u001a\u00020\f*\u00060\u0006j\u0002`\u0007\u001a\u0016\u0010\u0011\u001a\u00020\u0005*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0012\u001a\u00020\u0001\u001a\"\u0010\u0013\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"EMPTY", "", "SPACE", "", "containsChar", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "char", "indexOfChar", "", "inlineReplace", "", "toReplace", "replacement", "inlineReplaceChar", "inlineTrim", "stringEquals", "equal", "substringToBuilder", "start", "end", "app_lightningPlusDebug"})
public final class StringBuilderExtensionsKt {
    private static final char SPACE = ' ';
    private static final java.lang.String EMPTY = "";
    
    /**
     * Replace the first string found in a string builder with another string.
     *
     * @param toReplace The string to replace.
     * @param replacement The replacement string.
     */
    public static final void inlineReplace(@org.jetbrains.annotations.NotNull()
    java.lang.StringBuilder $this$inlineReplace, @org.jetbrains.annotations.NotNull()
    java.lang.String toReplace, @org.jetbrains.annotations.NotNull()
    java.lang.String replacement) {
    }
    
    /**
     * Replace the first char wound in a string builder with another char.
     *
     * @param toReplace The char to replace.
     * @param replacement The replacement char.
     */
    public static final void inlineReplaceChar(@org.jetbrains.annotations.NotNull()
    java.lang.StringBuilder $this$inlineReplaceChar, char toReplace, char replacement) {
    }
    
    /**
     * Returns the index of the provided [char] in the string or -1 if it cannot be found.
     */
    public static final int indexOfChar(@org.jetbrains.annotations.NotNull()
    java.lang.StringBuilder $this$indexOfChar, char p1_1526187) {
        return 0;
    }
    
    /**
     * Returns true if the string contains the [char], false otherwise.
     */
    public static final boolean containsChar(@org.jetbrains.annotations.NotNull()
    java.lang.StringBuilder $this$containsChar, char p1_1526187) {
        return false;
    }
    
    /**
     * Trims a string builder of any spaces at the beginning and end.
     */
    public static final void inlineTrim(@org.jetbrains.annotations.NotNull()
    java.lang.StringBuilder $this$inlineTrim) {
    }
    
    /**
     * Determines equality between a string builder and a string.
     *
     * @param equal the string.
     * @return true if the string represented by the string builder is equal to the string.
     */
    public static final boolean stringEquals(@org.jetbrains.annotations.NotNull()
    java.lang.StringBuilder $this$stringEquals, @org.jetbrains.annotations.NotNull()
    java.lang.String equal) {
        return false;
    }
    
    /**
     * Creates a sub-string builder from the current string builder.
     *
     * @param start the starting index.
     * @param end the ending index, must be greater than [start].
     * @return a string builder that contains the characters between the indices.
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.StringBuilder substringToBuilder(@org.jetbrains.annotations.NotNull()
    java.lang.StringBuilder $this$substringToBuilder, int start, int end) {
        return null;
    }
}