package acr.browser.lightning;

import java.lang.System;

/**
 * The incognito browsing experience.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\r\u0010\b\u001a\u00020\u0004H\u0014\u00a2\u0006\u0002\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lacr/browser/lightning/IncognitoBrowserActivity;", "Lacr/browser/lightning/browser/BrowserActivity;", "()V", "homeIcon", "", "isIncognito", "", "menu", "provideThemeOverride", "()Ljava/lang/Integer;", "Companion", "app_lightningPlusDebug"})
public final class IncognitoBrowserActivity extends acr.browser.lightning.browser.BrowserActivity {
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.IncognitoBrowserActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected java.lang.Integer provideThemeOverride() {
        return null;
    }
    
    @java.lang.Override()
    public boolean isIncognito() {
        return false;
    }
    
    @java.lang.Override()
    public int menu() {
        return 0;
    }
    
    @java.lang.Override()
    public int homeIcon() {
        return 0;
    }
    
    public IncognitoBrowserActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a8\u0006\u000b"}, d2 = {"Lacr/browser/lightning/IncognitoBrowserActivity$Companion;", "", "()V", "intent", "Landroid/content/Intent;", "activity", "Landroid/app/Activity;", "url", "", "launch", "", "app_lightningPlusDebug"})
    public static final class Companion {
        
        /**
         * Creates an intent to launch the browser with an optional [url] to load.
         */
        @org.jetbrains.annotations.NotNull()
        public final android.content.Intent intent(@org.jetbrains.annotations.NotNull()
        android.app.Activity activity, @org.jetbrains.annotations.Nullable()
        java.lang.String url) {
            return null;
        }
        
        /**
         * Launch the browser with an optional [url] to load.
         */
        public final void launch(@org.jetbrains.annotations.NotNull()
        android.app.Activity activity, @org.jetbrains.annotations.Nullable()
        java.lang.String url) {
        }
        
        private Companion() {
            super();
        }
    }
}