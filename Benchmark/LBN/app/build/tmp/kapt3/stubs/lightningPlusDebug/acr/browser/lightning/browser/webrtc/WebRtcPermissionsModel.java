package acr.browser.lightning.browser.webrtc;

import java.lang.System;

/**
 * The model that manages permission requests originating from a web page.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lacr/browser/lightning/browser/webrtc/WebRtcPermissionsModel;", "", "()V", "resourceGrantMap", "", "", "Ljava/util/HashSet;", "requestPermission", "", "permissionRequest", "Landroid/webkit/PermissionRequest;", "view", "Lacr/browser/lightning/browser/webrtc/WebRtcPermissionsView;", "app_lightningPlusDebug"})
@javax.inject.Singleton()
public final class WebRtcPermissionsModel {
    private final java.util.Map<java.lang.String, java.util.HashSet<java.lang.String>> resourceGrantMap = null;
    
    /**
     * Request a permission from the user to use certain device resources. Will call either
     * [PermissionRequest.grant] or [PermissionRequest.deny] based on the response received from the
     * user.
     *
     * @param permissionRequest the request being made.
     * @param view the view that will delegate requesting permissions or resources from the user.
     */
    public final void requestPermission(@org.jetbrains.annotations.NotNull()
    android.webkit.PermissionRequest permissionRequest, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.webrtc.WebRtcPermissionsView view) {
    }
    
    @javax.inject.Inject()
    public WebRtcPermissionsModel() {
        super();
    }
}