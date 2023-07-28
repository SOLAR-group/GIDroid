package acr.browser.lightning.browser.di;

import java.lang.System;

/**
 * The component for the browser scope.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lacr/browser/lightning/browser/di/Browser2Component;", "", "inject", "", "browserActivity", "Lacr/browser/lightning/browser/BrowserActivity;", "Builder", "app_lightningPlusDebug"})
@dagger.Subcomponent(modules = {acr.browser.lightning.browser.di.Browser2Module.class, acr.browser.lightning.browser.di.Browser2BindsModule.class})
@Browser2Scope()
public abstract interface Browser2Component {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.BrowserActivity browserActivity);
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\'J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\'J\b\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\nH\'J\u0012\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\f\u001a\u00020\rH\'J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\'J\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\'\u00a8\u0006\u0013"}, d2 = {"Lacr/browser/lightning/browser/di/Browser2Component$Builder;", "", "activity", "Landroid/app/Activity;", "browserFrame", "frameLayout", "Landroid/widget/FrameLayout;", "build", "Lacr/browser/lightning/browser/di/Browser2Component;", "incognitoMode", "", "initialIntent", "intent", "Landroid/content/Intent;", "toolbar", "Landroid/view/View;", "toolbarRoot", "linearLayout", "Landroid/widget/LinearLayout;", "app_lightningPlusDebug"})
    @dagger.Subcomponent.Builder()
    public static abstract interface Builder {
        
        @org.jetbrains.annotations.NotNull()
        @dagger.BindsInstance()
        public abstract acr.browser.lightning.browser.di.Browser2Component.Builder activity(@org.jetbrains.annotations.NotNull()
        android.app.Activity activity);
        
        @org.jetbrains.annotations.NotNull()
        @dagger.BindsInstance()
        public abstract acr.browser.lightning.browser.di.Browser2Component.Builder browserFrame(@org.jetbrains.annotations.NotNull()
        android.widget.FrameLayout frameLayout);
        
        @org.jetbrains.annotations.NotNull()
        @dagger.BindsInstance()
        public abstract acr.browser.lightning.browser.di.Browser2Component.Builder toolbarRoot(@org.jetbrains.annotations.NotNull()
        android.widget.LinearLayout linearLayout);
        
        @org.jetbrains.annotations.NotNull()
        @dagger.BindsInstance()
        public abstract acr.browser.lightning.browser.di.Browser2Component.Builder toolbar(@org.jetbrains.annotations.NotNull()
        android.view.View toolbar);
        
        @org.jetbrains.annotations.NotNull()
        @dagger.BindsInstance()
        public abstract acr.browser.lightning.browser.di.Browser2Component.Builder initialIntent(@org.jetbrains.annotations.NotNull()
        @InitialIntent()
        android.content.Intent intent);
        
        @org.jetbrains.annotations.NotNull()
        @dagger.BindsInstance()
        public abstract acr.browser.lightning.browser.di.Browser2Component.Builder incognitoMode(@IncognitoMode()
        boolean incognitoMode);
        
        @org.jetbrains.annotations.NotNull()
        public abstract acr.browser.lightning.browser.di.Browser2Component build();
    }
}