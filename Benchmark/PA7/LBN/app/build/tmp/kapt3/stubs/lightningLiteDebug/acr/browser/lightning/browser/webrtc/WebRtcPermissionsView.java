package acr.browser.lightning.browser.webrtc;

import java.lang.System;

/**
 * A view which specializes in requesting device permissions and resources from the user.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\bH&J7\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\bH&\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lacr/browser/lightning/browser/webrtc/WebRtcPermissionsView;", "", "requestPermissions", "", "permissions", "", "", "onGrant", "Lkotlin/Function1;", "", "requestResources", "source", "resources", "", "(Ljava/lang/String;[Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "app_lightningLiteDebug"})
public abstract interface WebRtcPermissionsView {
    
    /**
     * Request the provided permissions from the user, and call back to [onGrant] with true when all
     * the permissions have been granted, or false if one or more was denied.
     *
     * @param permissions the permissions to request.
     * @param onGrant the callback to invoke when the user indicates their intent to grant or deny.
     */
    public abstract void requestPermissions(@org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> permissions, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onGrant);
    
    /**
     * Request the provided device resources from the user, and call back to [onGrant] with true
     * when all the permissions have been granted, or false if one or more was denied.
     *
     * @param source the domain from which the request originated.
     * @param resources the device resources being requested.
     * @param onGrant the callback to invoke when the user indicates their intent to grant or deny.
     */
    public abstract void requestResources(@org.jetbrains.annotations.NotNull()
    java.lang.String source, @org.jetbrains.annotations.NotNull()
    java.lang.String[] resources, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onGrant);
}