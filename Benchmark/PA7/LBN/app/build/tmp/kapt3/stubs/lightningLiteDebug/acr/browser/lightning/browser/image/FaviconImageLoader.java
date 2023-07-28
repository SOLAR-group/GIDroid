package acr.browser.lightning.browser.image;

import java.lang.System;

/**
 * An image loader implementation that caches icons in memory after reading them from the disk
 * cache.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lacr/browser/lightning/browser/image/FaviconImageLoader;", "Lacr/browser/lightning/browser/image/ImageLoader;", "faviconModel", "Lacr/browser/lightning/favicon/FaviconModel;", "application", "Landroid/app/Application;", "networkScheduler", "Lio/reactivex/Scheduler;", "mainScheduler", "(Lacr/browser/lightning/favicon/FaviconModel;Landroid/app/Application;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "folderIcon", "Landroid/graphics/drawable/Drawable;", "lruCache", "Landroid/util/LruCache;", "", "", "webPageIcon", "loadImage", "", "imageView", "Landroid/widget/ImageView;", "bookmark", "Lacr/browser/lightning/database/Bookmark;", "app_lightningLiteDebug"})
public final class FaviconImageLoader implements acr.browser.lightning.browser.image.ImageLoader {
    private final android.util.LruCache<java.lang.String, java.lang.Object> lruCache = null;
    private final android.graphics.drawable.Drawable folderIcon = null;
    private final android.graphics.drawable.Drawable webPageIcon = null;
    private final io.reactivex.disposables.CompositeDisposable compositeDisposable = null;
    private final acr.browser.lightning.favicon.FaviconModel faviconModel = null;
    private final io.reactivex.Scheduler networkScheduler = null;
    private final io.reactivex.Scheduler mainScheduler = null;
    
    @java.lang.Override()
    public void loadImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.Bookmark bookmark) {
    }
    
    @javax.inject.Inject()
    public FaviconImageLoader(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.favicon.FaviconModel faviconModel, @org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.NetworkScheduler()
    io.reactivex.Scheduler networkScheduler, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.MainScheduler()
    io.reactivex.Scheduler mainScheduler) {
        super();
    }
}