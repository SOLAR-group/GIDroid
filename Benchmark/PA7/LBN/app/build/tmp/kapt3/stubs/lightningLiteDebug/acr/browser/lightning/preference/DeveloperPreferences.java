package acr.browser.lightning.preference;

import java.lang.System;

/**
 * Preferences related to development debugging.
 *
 * Created by anthonycr on 2/19/18.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR+\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lacr/browser/lightning/preference/DeveloperPreferences;", "", "preferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "<set-?>", "", "checkedForI2P", "getCheckedForI2P", "()Z", "setCheckedForI2P", "(Z)V", "checkedForI2P$delegate", "Lkotlin/properties/ReadWriteProperty;", "checkedForTor", "getCheckedForTor", "setCheckedForTor", "checkedForTor$delegate", "useLeakCanary", "getUseLeakCanary", "setUseLeakCanary", "useLeakCanary$delegate", "app_lightningLiteDebug"})
@javax.inject.Singleton()
public final class DeveloperPreferences {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty useLeakCanary$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty checkedForTor$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty checkedForI2P$delegate = null;
    
    public final boolean getUseLeakCanary() {
        return false;
    }
    
    public final void setUseLeakCanary(boolean p0) {
    }
    
    public final boolean getCheckedForTor() {
        return false;
    }
    
    public final void setCheckedForTor(boolean p0) {
    }
    
    public final boolean getCheckedForI2P() {
        return false;
    }
    
    public final void setCheckedForI2P(boolean p0) {
    }
    
    @javax.inject.Inject()
    public DeveloperPreferences(@org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.DevPrefs()
    android.content.SharedPreferences preferences) {
        super();
    }
}