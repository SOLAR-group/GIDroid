package org.fdroid.fdroid.views.apps;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import org.fdroid.fdroid.R;
import java.util.Random;

@SuppressWarnings("LineLength")
public class FeatureImage extends AppCompatImageView {

    private static final int NUM_SQUARES_WIDE = 4;

    private static final int NUM_SQUARES_HIGH = 2;

    private final Path[] triangles = new Path[NUM_SQUARES_HIGH * NUM_SQUARES_WIDE * 2];

    @Nullable
    public Paint[] trianglePaints;

    @ColorInt
    private int baseColour;

    public FeatureImage(Context context) {
        super(context);
        init(context);
    }

    public FeatureImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FeatureImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        float[] hsv = new float[3];
        Color.colorToHSV(ContextCompat.getColor(context, R.color.fdroid_blue), hsv);
        hsv[1] *= 0.5f;
        hsv[2] *= 0.7f;
        baseColour = Color.HSVToColor(hsv);
    }

    public void setColour(@ColorInt int colour) {
        float[] hsv = new float[3];
        Color.colorToHSV(colour, hsv);
        hsv[1] *= 0.5f;
        hsv[2] *= 0.7f;
        int colourOne = Color.HSVToColor(hsv);
        hsv[2] *= 0.9f;
        int colourTwo = Color.HSVToColor(hsv);
        Paint paintOne = new Paint();
        paintOne.setColor(colourOne);
        paintOne.setAntiAlias(true);
        paintOne.setStrokeWidth(2);
        paintOne.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paintTwo = new Paint();
        paintTwo.setColor(colourTwo);
        paintTwo.setAntiAlias(true);
        paintTwo.setStrokeWidth(2);
        paintTwo.setStyle(Paint.Style.FILL_AND_STROKE);
        Random random = new Random(colourOne);
        trianglePaints = new Paint[triangles.length];
        for (int i = 0; i < trianglePaints.length; i++) {
            trianglePaints[i] = random.nextBoolean() ? paintOne : paintTwo;
        }
    }

    public void setColorAndAnimateChange(@ColorInt int colour) {
        setColour(colour);
        animateColourChange();
    }

    private int currentAlpha = 255;

    public ValueAnimator alphaAnimator;

    private void animateColourChange() {
        if (alphaAnimator != null) {
            alphaAnimator.cancel();
        }
        alphaAnimator = ValueAnimator.ofInt(0, 255).setDuration(150);
        alphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentAlpha = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        currentAlpha = 0;
        invalidate();
        alphaAnimator.start();
    }

    @Override
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int triangleWidth = w / NUM_SQUARES_WIDE;
        int triangleHeight = h / NUM_SQUARES_HIGH;
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,0);
        Point point3 = new Point(0,0);
        Point point4 = new Point(0,0);
        for (int x = 0; x < NUM_SQUARES_WIDE; x++) {
            for (int y = 0; y < NUM_SQUARES_HIGH; y++) {
                int startX = x * triangleWidth;
                int startY = y * triangleHeight;
                int endX = startX + triangleWidth;
                int endY = startY + triangleHeight;
                Path firstTriangle;
                Path secondTriangle;
                point1.x = startX;
                point1.y = startY;
                point2.x = endX;
                point2.y = startY;
                point3.x = startX;
                point3.y = endY;
                point4.x = endX;
                point4.y = endY;
                if (x % 2 == 0) {
                    firstTriangle = createTriangle(point1, point2, point4);
                    secondTriangle = createTriangle(point1, point4, point3);
                } else {
                    firstTriangle = createTriangle(point1, point2, point3);
                    secondTriangle = createTriangle(point3, point2, point4);
                }
                triangles[y * (NUM_SQUARES_WIDE * 2) + (x * 2)] = firstTriangle;
                triangles[y * (NUM_SQUARES_WIDE * 2) + (x * 2) + 1] = secondTriangle;
            }
        }
    }

    @Override
    public void onDraw(Canvas canvas) {
        if (getDrawable() != null) {
            super.onDraw(canvas);
        } else if (trianglePaints != null) {
            for (Paint paint : trianglePaints) {
                paint.setAlpha(currentAlpha);
            }
            canvas.drawColor(baseColour);
            for (int i = 0; i < triangles.length; i++) {
                canvas.drawPath(triangles[i], trianglePaints[i]);
            }
        } else {
            canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        }
    }

    private static Path createTriangle(Point start, Point middle, Point end) {
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(start.x, start.y);
        path.lineTo(middle.x, middle.y);
        path.lineTo(end.x, end.y);
        path.close();
        return path;
    }

    public void loadImageAndDisplay(@NonNull ImageLoader loader, @NonNull DisplayImageOptions imageOptions, @Nullable String featureImageToShow, @Nullable String fallbackImageToExtractColours) {
        setColour(ContextCompat.getColor(getContext(), R.color.fdroid_blue));
        if (!TextUtils.isEmpty(featureImageToShow)) {
            loadImageAndDisplay(loader, imageOptions, featureImageToShow);
        } else if (!TextUtils.isEmpty(fallbackImageToExtractColours)) {
            loadImageAndExtractColour(loader, imageOptions, fallbackImageToExtractColours);
        }
    }

    private void loadImageAndExtractColour(@NonNull ImageLoader loader, @NonNull DisplayImageOptions imageOptions, String url) {
        loader.loadImage(url, imageOptions, new ImageLoadingAdapter() {

            @Override
            public void onLoadingComplete(String imageUri, View view, final Bitmap loadedImage) {
                if (loadedImage != null) {
                    new Palette.Builder(loadedImage).generate(new Palette.PaletteAsyncListener() {

                        @Override
                        public void onGenerated(Palette palette) {
                            if (palette != null) {
                                setColorAndAnimateChange(palette.getDominantColor(Color.LTGRAY));
                            }
                        }
                    });
                }
            }
        });
    }

    public void loadImageAndDisplay(@NonNull ImageLoader loader, @NonNull DisplayImageOptions imageOptions, String url) {
        loader.loadImage(url, imageOptions, new ImageLoadingAdapter() {

            @Override
            public void onLoadingComplete(String imageUri, View view, final Bitmap loadedImage) {
                if (loadedImage != null) {
                    setImageBitmap(loadedImage);
                }
            }
        });
    }

    private abstract static class ImageLoadingAdapter implements ImageLoadingListener {

        @Override
        public void onLoadingStarted(String imageUri, View view) {
        }

        @Override
        public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
        }

        @Override
        public void onLoadingCancelled(String imageUri, View view) {
        }
    }
}
