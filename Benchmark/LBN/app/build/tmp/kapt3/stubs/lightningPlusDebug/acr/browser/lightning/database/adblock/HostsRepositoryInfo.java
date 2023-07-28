package acr.browser.lightning.database.adblock;

import java.lang.System;

/**
 * Information about the contents of the hosts repository.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R/\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lacr/browser/lightning/database/adblock/HostsRepositoryInfo;", "", "preferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "<set-?>", "", "identity", "getIdentity", "()Ljava/lang/String;", "setIdentity", "(Ljava/lang/String;)V", "identity$delegate", "Lkotlin/properties/ReadWriteProperty;", "Companion", "app_lightningPlusDebug"})
public final class HostsRepositoryInfo {
    
    /**
     * The identity of the contents of the hosts repository as a [String] or `null`.
     */
    @org.jetbrains.annotations.Nullable()
    private final kotlin.properties.ReadWriteProperty identity$delegate = null;
    private static final java.lang.String IDENTITY = "identity";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.database.adblock.HostsRepositoryInfo.Companion Companion = null;
    
    /**
     * The identity of the contents of the hosts repository as a [String] or `null`.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getIdentity() {
        return null;
    }
    
    /**
     * The identity of the contents of the hosts repository as a [String] or `null`.
     */
    public final void setIdentity(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @javax.inject.Inject()
    public HostsRepositoryInfo(@org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.AdBlockPrefs()
    android.content.SharedPreferences preferences) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/database/adblock/HostsRepositoryInfo$Companion;", "", "()V", "IDENTITY", "", "app_lightningPlusDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}