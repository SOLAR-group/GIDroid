package org.jfedor.frozenbubble;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import androidx.test.core.app.ApplicationProvider;

import com.efortin.frozenbubble.HighscoreManager;


import org.gsanson.frozenbubble.MalusBar;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.security.PublicKey;
import java.util.Vector;

@RunWith(RobolectricTestRunner.class)
public class FrozenGameTest {
    Vector<Object> mImageList;

    @Before
    public void setUp() {
        mImageList = new Vector<>();
    }


    @Test
    public void testPause() {
        BmpWrap mBackground = NewBmpWrap();
        BmpWrap mBubbleBlink    = NewBmpWrap();
        BmpWrap mGameWon        = NewBmpWrap();
        BmpWrap mGameLost       = NewBmpWrap();
        BmpWrap mGamePaused     = NewBmpWrap();
        BmpWrap mHurry          = NewBmpWrap();
        BmpWrap mPenguins       = NewBmpWrap();
        BmpWrap mCompressorHead = NewBmpWrap();
        BmpWrap mCompressor     = NewBmpWrap();
        BmpWrap mLife           = NewBmpWrap();
        BmpWrap mFontImage      = NewBmpWrap();

        BubbleFont mFont = new BubbleFont(mFontImage);
        Context mContext = ApplicationProvider.getApplicationContext();
        Drawable mLauncher = mContext.getResources().getDrawable(R.drawable.launcher);
        SoundManager mSoundManager = new SoundManager(mContext);
        HighscoreManager mHighscoreManager = new HighscoreManager(mContext,
                HighscoreManager.
                        PUZZLE_DATABASE_NAME);

        BmpWrap[] mBubbles = new BmpWrap[8];
        for (int i = 0; i < mBubbles.length; i++) {
            mBubbles[i] = NewBmpWrap();
        }

        BmpWrap[] mBubblesBlind = new BmpWrap[8];
        for (int i = 0; i < mBubblesBlind.length; i++) {
            mBubblesBlind[i] = NewBmpWrap();
        }

        BmpWrap[] mFrozenBubbles = new BmpWrap[8];
        for (int i = 0; i < mFrozenBubbles.length; i++) {
            mFrozenBubbles[i] = NewBmpWrap();
        }

        BmpWrap[] mTargetedBubbles = new BmpWrap[6];
        for (int i = 0; i < mTargetedBubbles.length; i++) {
            mTargetedBubbles[i] = NewBmpWrap();
        }

        LevelManager mLevelManager = new LevelManager(5, 1);
        FrozenGame game = new FrozenGame(mBackground, mBubbles, mBubblesBlind,
                mFrozenBubbles, mTargetedBubbles,
                mBubbleBlink, mGameWon, mGameLost,
                mGamePaused, mHurry, mPenguins, NewBmpWrap(), NewBmpWrap(),
                mCompressorHead, mCompressor, new MalusBar(0,0,NewBmpWrap(),NewBmpWrap()), mLauncher,
                mSoundManager, mLevelManager,
                mHighscoreManager,1);

        game.pause();
        assert game.sprites.size() == 44;
        game.pause();
        assert game.sprites.size() == 44;
        game.resume();
        assert game.sprites.size() == 43;
    }

    private BmpWrap NewBmpWrap() {

        int new_img_id = mImageList.size();
        BmpWrap new_img = new BmpWrap(new_img_id);
        mImageList.addElement(new_img);
        return new_img;
    }

    @After
    public void tearDown() {
        System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }
}