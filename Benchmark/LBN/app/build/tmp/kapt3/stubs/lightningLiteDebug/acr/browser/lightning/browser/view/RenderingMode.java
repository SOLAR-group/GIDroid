package acr.browser.lightning.browser.view;

import java.lang.System;

/**
 * An enum representing the browser's available rendering modes.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lacr/browser/lightning/browser/view/RenderingMode;", "", "Lacr/browser/lightning/preference/IntEnum;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "NORMAL", "INVERTED", "GRAYSCALE", "INVERTED_GRAYSCALE", "INCREASE_CONTRAST", "app_lightningLiteDebug"})
public enum RenderingMode implements acr.browser.lightning.preference.IntEnum {
    /*public static final*/ NORMAL /* = new NORMAL(0) */,
    /*public static final*/ INVERTED /* = new INVERTED(0) */,
    /*public static final*/ GRAYSCALE /* = new GRAYSCALE(0) */,
    /*public static final*/ INVERTED_GRAYSCALE /* = new INVERTED_GRAYSCALE(0) */,
    /*public static final*/ INCREASE_CONTRAST /* = new INCREASE_CONTRAST(0) */;
    private final int value = 0;
    
    @java.lang.Override()
    public int getValue() {
        return 0;
    }
    
    RenderingMode(int value) {
    }
}