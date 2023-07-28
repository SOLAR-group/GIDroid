package acr.browser.lightning.browser.search;

import java.lang.System;

/**
 * Listens for actions on the search bar.
 *
 * @param onConfirm Invoked when the user has confirmed what they are searching for.
 * @param inputMethodManager Used to manage keyboard visibility.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J \u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lacr/browser/lightning/browser/search/SearchListener;", "Landroid/view/View$OnKeyListener;", "Landroid/widget/TextView$OnEditorActionListener;", "onConfirm", "Lkotlin/Function0;", "", "inputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "(Lkotlin/jvm/functions/Function0;Landroid/view/inputmethod/InputMethodManager;)V", "onEditorAction", "", "view", "Landroid/widget/TextView;", "actionId", "", "event", "Landroid/view/KeyEvent;", "onKey", "Landroid/view/View;", "keyCode", "keyEvent", "app_lightningLiteDebug"})
public final class SearchListener implements android.view.View.OnKeyListener, android.widget.TextView.OnEditorActionListener {
    private final kotlin.jvm.functions.Function0<kotlin.Unit> onConfirm = null;
    private final android.view.inputmethod.InputMethodManager inputMethodManager = null;
    
    @java.lang.Override()
    public boolean onKey(@org.jetbrains.annotations.NotNull()
    android.view.View view, int keyCode, @org.jetbrains.annotations.NotNull()
    android.view.KeyEvent keyEvent) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onEditorAction(@org.jetbrains.annotations.NotNull()
    android.widget.TextView view, int actionId, @org.jetbrains.annotations.Nullable()
    android.view.KeyEvent event) {
        return false;
    }
    
    public SearchListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onConfirm, @org.jetbrains.annotations.NotNull()
    android.view.inputmethod.InputMethodManager inputMethodManager) {
        super();
    }
}