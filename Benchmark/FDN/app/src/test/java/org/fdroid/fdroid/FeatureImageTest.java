package org.fdroid.fdroid;

import static org.junit.Assert.*;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.fdroid.fdroid.views.apps.FeatureImage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;


@RunWith(RobolectricTestRunner.class)
@Config(shadows={ShadowUtils.class})
public class FeatureImageTest {

    @Test
    public void test1() {
        FeatureImage image = new FeatureImage(ApplicationProvider.getApplicationContext());
        image.onSizeChanged(10,10,10,10);
        image.setColour(0);
        //assert image.trianglePaints==null;
        image.setColour(10);
        assert image.trianglePaints.length== 16;

        float[] hsv = new float[3];
        Color.colorToHSV(10, hsv);
        hsv[1] *= 0.5f;
        hsv[2] *= 0.7f;
        int colourOne = Color.HSVToColor(hsv);

        hsv[2] *= 0.9f;
        int colourTwo = Color.HSVToColor(hsv);

        for (Paint paint : image.trianglePaints){
            assert paint.isAntiAlias();
            assert paint.getColor() == colourOne || paint.getColor() == colourTwo;
            assert paint.getStrokeWidth() == 2;
            assert paint.getStyle() == Paint.Style.FILL_AND_STROKE;
        }

        image.setColorAndAnimateChange(19);
        image.setColorAndAnimateChange(21);

        hsv = new float[3];
        Color.colorToHSV(21, hsv);
        hsv[1] *= 0.5f;
        hsv[2] *= 0.7f;
        colourOne = Color.HSVToColor(hsv);

        hsv[2] *= 0.9f;
        colourTwo = Color.HSVToColor(hsv);

        for (Paint paint : image.trianglePaints){
            assert paint.isAntiAlias();
            assert paint.getColor() == colourOne || paint.getColor() == colourTwo;
            assert paint.getStrokeWidth() == 2;
            assert paint.getStyle() == Paint.Style.FILL_AND_STROKE;
        }
        assert image.alphaAnimator.isRunning();
        assert image.alphaAnimator.isStarted();
        PropertyValuesHolder[] values = image.alphaAnimator.getValues();
        assert values[0].toString().equals(":  0  255  ");
        System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }

}
