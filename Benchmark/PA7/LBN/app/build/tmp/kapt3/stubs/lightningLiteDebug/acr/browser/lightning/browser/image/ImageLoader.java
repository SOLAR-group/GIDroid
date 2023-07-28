package acr.browser.lightning.browser.image;

import java.lang.System;

/**
 * Loads images for bookmark entries.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lacr/browser/lightning/browser/image/ImageLoader;", "", "loadImage", "", "imageView", "Landroid/widget/ImageView;", "bookmark", "Lacr/browser/lightning/database/Bookmark;", "app_lightningLiteDebug"})
public abstract interface ImageLoader {
    
    /**
     * Load a the favicon into the [imageView] for the provided [bookmark].
     */
    public abstract void loadImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.Bookmark bookmark);
}