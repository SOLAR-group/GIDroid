package acr.browser.lightning.browser.proxy;

import java.lang.System;

/**
 * The available proxy choices.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lacr/browser/lightning/browser/proxy/ProxyChoice;", "", "Lacr/browser/lightning/preference/IntEnum;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "NONE", "ORBOT", "I2P", "MANUAL", "app_lightningLiteDebug"})
public enum ProxyChoice implements acr.browser.lightning.preference.IntEnum {
    /*public static final*/ NONE /* = new NONE(0) */,
    /*public static final*/ ORBOT /* = new ORBOT(0) */,
    /*public static final*/ I2P /* = new I2P(0) */,
    /*public static final*/ MANUAL /* = new MANUAL(0) */;
    private final int value = 0;
    
    @java.lang.Override()
    public int getValue() {
        return 0;
    }
    
    ProxyChoice(int value) {
    }
}