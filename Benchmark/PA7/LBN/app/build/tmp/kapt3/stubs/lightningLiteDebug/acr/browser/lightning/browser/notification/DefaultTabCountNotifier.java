package acr.browser.lightning.browser.notification;

import java.lang.System;

/**
 * Do nothing when notified about the new tab count.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lacr/browser/lightning/browser/notification/DefaultTabCountNotifier;", "Lacr/browser/lightning/browser/notification/TabCountNotifier;", "()V", "notifyTabCountChange", "", "total", "", "app_lightningLiteDebug"})
public final class DefaultTabCountNotifier implements acr.browser.lightning.browser.notification.TabCountNotifier {
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.browser.notification.DefaultTabCountNotifier INSTANCE = null;
    
    @java.lang.Override()
    public void notifyTabCountChange(int total) {
    }
    
    private DefaultTabCountNotifier() {
        super();
    }
}