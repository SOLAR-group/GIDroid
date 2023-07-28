package acr.browser.lightning.device;

import java.lang.System;

/**
 * A model used to determine the screen size info.
 *
 * Created by anthonycr on 2/19/18.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lacr/browser/lightning/device/ScreenSize;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isTablet", "", "app_lightningPlusDebug"})
@dagger.Reusable()
public final class ScreenSize {
    private final android.content.Context context = null;
    
    public final boolean isTablet() {
        return false;
    }
    
    @javax.inject.Inject()
    public ScreenSize(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}