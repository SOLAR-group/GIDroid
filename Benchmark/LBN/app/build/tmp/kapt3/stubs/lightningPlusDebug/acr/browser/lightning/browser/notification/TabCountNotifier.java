package acr.browser.lightning.browser.notification;

import java.lang.System;

/**
 * Notify the browser outside of the regular view that the tab count has changed.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lacr/browser/lightning/browser/notification/TabCountNotifier;", "", "notifyTabCountChange", "", "total", "", "app_lightningPlusDebug"})
public abstract interface TabCountNotifier {
    
    /**
     * The open tab count has changed to the new [total].
     */
    public abstract void notifyTabCountChange(int total);
}