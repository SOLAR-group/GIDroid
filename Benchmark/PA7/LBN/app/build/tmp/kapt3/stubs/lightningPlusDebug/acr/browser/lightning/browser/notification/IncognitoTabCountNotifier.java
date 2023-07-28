package acr.browser.lightning.browser.notification;

import java.lang.System;

/**
 * Shows a notification about the number of incognito tabs currently open.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lacr/browser/lightning/browser/notification/IncognitoTabCountNotifier;", "Lacr/browser/lightning/browser/notification/TabCountNotifier;", "incognitoNotification", "Lacr/browser/lightning/browser/notification/IncognitoNotification;", "(Lacr/browser/lightning/browser/notification/IncognitoNotification;)V", "notifyTabCountChange", "", "total", "", "app_lightningPlusDebug"})
public final class IncognitoTabCountNotifier implements acr.browser.lightning.browser.notification.TabCountNotifier {
    private final acr.browser.lightning.browser.notification.IncognitoNotification incognitoNotification = null;
    
    @java.lang.Override()
    public void notifyTabCountChange(int total) {
    }
    
    @javax.inject.Inject()
    public IncognitoTabCountNotifier(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.notification.IncognitoNotification incognitoNotification) {
        super();
    }
}