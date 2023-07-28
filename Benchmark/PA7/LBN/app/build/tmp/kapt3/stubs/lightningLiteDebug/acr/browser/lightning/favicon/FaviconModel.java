package acr.browser.lightning.favicon;

import java.lang.System;

/**
 * Reactive model that can fetch favicons
 * from URLs and also cache them.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000bJ\u0010\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bJ\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u00192\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lacr/browser/lightning/favicon/FaviconModel;", "", "application", "Landroid/app/Application;", "logger", "Lacr/browser/lightning/log/Logger;", "(Landroid/app/Application;Lacr/browser/lightning/log/Logger;)V", "bookmarkIconSize", "", "faviconCache", "Landroid/util/LruCache;", "", "Landroid/graphics/Bitmap;", "loaderOptions", "Landroid/graphics/BitmapFactory$Options;", "addFaviconToMemCache", "", "url", "bitmap", "cacheFaviconForUrl", "Lio/reactivex/Completable;", "favicon", "createDefaultBitmapForTitle", "title", "faviconForUrl", "Lio/reactivex/Maybe;", "getFaviconFromMemCache", "Companion", "app_lightningLiteDebug"})
@javax.inject.Singleton()
public final class FaviconModel {
    private final android.graphics.BitmapFactory.Options loaderOptions = null;
    private final int bookmarkIconSize = 0;
    private final android.util.LruCache<java.lang.String, android.graphics.Bitmap> faviconCache = null;
    private final android.app.Application application = null;
    private final acr.browser.lightning.log.Logger logger = null;
    private static final java.lang.String TAG = "FaviconModel";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.favicon.FaviconModel.Companion Companion = null;
    
    /**
     * Retrieves a favicon from the memory cache.Bitmap may not be present if no bitmap has been
     * added for the URL or if it has been evicted from the memory cache.
     *
     * @param url the URL to retrieve the bitmap for.
     * @return the bitmap associated with the URL, may be null.
     */
    private final android.graphics.Bitmap getFaviconFromMemCache(java.lang.String url) {
        return null;
    }
    
    /**
     * Create the default favicon for a bookmark with the provided [title].
     */
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.Bitmap createDefaultBitmapForTitle(@org.jetbrains.annotations.Nullable()
    java.lang.String title) {
        return null;
    }
    
    /**
     * Adds a bitmap to the memory cache for the given URL.
     *
     * @param url    the URL to map the bitmap to.
     * @param bitmap the bitmap to store.
     */
    private final void addFaviconToMemCache(java.lang.String url, android.graphics.Bitmap bitmap) {
    }
    
    /**
     * Retrieves the favicon for a URL, may be from network or cache.
     *
     * @param url   The URL that we should retrieve the favicon for.
     * @param title The title for the web page.
     */
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Maybe<android.graphics.Bitmap> faviconForUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
        return null;
    }
    
    /**
     * Caches a favicon for a particular URL.
     *
     * @param favicon the favicon to cache.
     * @param url     the URL to cache the favicon for.
     * @return an observable that notifies the consumer when it is complete.
     */
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Completable cacheFaviconForUrl(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap favicon, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    @javax.inject.Inject()
    public FaviconModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.log.Logger logger) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lacr/browser/lightning/favicon/FaviconModel$Companion;", "", "()V", "TAG", "", "getFaviconCacheFile", "Ljava/io/File;", "app", "Landroid/app/Application;", "validUri", "Lacr/browser/lightning/favicon/ValidUri;", "app_lightningLiteDebug"})
    public static final class Companion {
        
        /**
         * Creates the cache file for the favicon image. File name will be in the form of "hash of URI host".png
         *
         * @param app the context needed to retrieve the cache directory.
         * @param validUri the URI to use as a unique identifier.
         * @return a valid cache file.
         */
        @org.jetbrains.annotations.NotNull()
        @androidx.annotation.WorkerThread()
        public final java.io.File getFaviconCacheFile(@org.jetbrains.annotations.NotNull()
        android.app.Application app, @org.jetbrains.annotations.NotNull()
        acr.browser.lightning.favicon.ValidUri validUri) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}