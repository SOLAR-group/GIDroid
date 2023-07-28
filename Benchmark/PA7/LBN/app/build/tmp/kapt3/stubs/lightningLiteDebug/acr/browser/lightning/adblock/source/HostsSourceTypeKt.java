package acr.browser.lightning.adblock.source;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"selectedHostsSource", "Lacr/browser/lightning/adblock/source/HostsSourceType;", "Lacr/browser/lightning/preference/UserPreferences;", "toPreferenceIndex", "", "app_lightningLiteDebug"})
public final class HostsSourceTypeKt {
    
    /**
     * Extract the user's chosen [HostsSourceType] from the preferences. If either the file chosen is
     * invalid or the remote URL chosen is invalid, we will fall back to the [HostsSourceType.Default].
     */
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.adblock.source.HostsSourceType selectedHostsSource(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences $this$selectedHostsSource) {
        return null;
    }
    
    /**
     * Convert the [HostsSourceType] to the index stored in preferences.
     */
    public static final int toPreferenceIndex(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.adblock.source.HostsSourceType $this$toPreferenceIndex) {
        return 0;
    }
}