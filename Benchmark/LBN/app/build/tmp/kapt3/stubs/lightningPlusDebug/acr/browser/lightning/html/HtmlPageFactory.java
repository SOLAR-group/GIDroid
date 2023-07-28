package acr.browser.lightning.html;

import java.lang.System;

/**
 * A factory that builds an HTML page.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/html/HtmlPageFactory;", "", "buildPage", "Lio/reactivex/Single;", "", "app_lightningPlusDebug"})
public abstract interface HtmlPageFactory {
    
    /**
     * Build the HTML page and emit the URL.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.lang.String> buildPage();
}