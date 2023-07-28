package acr.browser.lightning.utils;

import java.lang.System;

/**
 * Utils used to access information about the device.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\b"}, d2 = {"Lacr/browser/lightning/utils/DeviceUtils;", "", "()V", "getAvailableScreenWidth", "", "context", "Landroid/content/Context;", "getScreenWidth", "app_lightningLiteDebug"})
public final class DeviceUtils {
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.utils.DeviceUtils INSTANCE = null;
    
    /**
     * Gets the width of the device's screen.
     *
     * @param context the context used to access the [WindowManager].
     */
    public static final int getScreenWidth(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return 0;
    }
    
    /**
     * Gets the width of the screen space currently available to the app.
     *
     * @param context the context used to access the [WindowManager].
     */
    public static final int getAvailableScreenWidth(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return 0;
    }
    
    private DeviceUtils() {
        super();
    }
}