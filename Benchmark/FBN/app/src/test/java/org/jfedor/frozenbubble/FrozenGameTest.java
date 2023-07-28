package org.jfedor.frozenbubble;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;

import androidx.test.core.app.ApplicationProvider;

import com.efortin.frozenbubble.HighscoreManager;
import com.efortin.frozenbubble.VirtualInput;


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
        BmpWrap mPlayButton = NewBmpWrap();
        BmpWrap mPauseButton    = NewBmpWrap();
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

        MalusBar malusBar2 = new MalusBar(GameView.GAMEFIELD_WIDTH + 134, 40,
                NewBmpWrap(), NewBmpWrap());

        HighscoreManager mHighScoreManager =
                new HighscoreManager(ApplicationProvider.getApplicationContext(),
                        HighscoreManager.PUZZLE_DATABASE_NAME);

        LevelManager mLevelManager = new LevelManager(5, 1);
        PlayerInput mPlayer1 = new PlayerInput(VirtualInput.PLAYER1, false, false);
        FrozenGame game = new FrozenGame(mBubbles, mBubblesBlind,
                mFrozenBubbles, mTargetedBubbles,
                mBubbleBlink, mGameWon, mGameLost,
                mGamePaused, mHurry,
                mPauseButton, mPlayButton, mPenguins,
                mCompressorHead, mCompressor,
                malusBar2, mLauncher,
                mSoundManager, mLevelManager,
                mHighScoreManager, null,
                mPlayer1);
        int sprites = game.falling.size();
        game.addFallingBubble(game.getGrid()[0][0]);
        assert game.falling.size() == sprites+1;
        assert game.sprites.get(game.sprites.size()-1) == game.getGrid()[0][0];
        sprites = game.jumping.size();
        game.addJumpingBubble(game.getGrid()[0][0]);
        assert game.jumping.size() == sprites+1;
        assert game.sprites.get(game.sprites.size()-1) == game.getGrid()[0][0];
        game.addScrollRow();
        assert game.sprites.size()==50;
        game.checkLost();
        assert   game.playResult != GameScreen.gameEnum.LOST;
        game.pause();
        game.play(false,false,false,false,0,true,0,0,false,0);
        game.pause();
        game.getGrid();
        game.resume();
    }

    @After
    public void tearDown(){
        System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }

    private BmpWrap NewBmpWrap() {

        int new_img_id = mImageList.size();
        BmpWrap new_img = new BmpWrap(new_img_id);
        mImageList.addElement(new_img);
        return new_img;
    }


    class PlayerInput extends VirtualInput {
        private boolean mCenter        = false;
        private boolean mDown          = false;
        private boolean mLeft          = false;
        private boolean mRight         = false;
        private boolean mUp            = false;
        private double  mTrackballDx   = 0;
        private boolean mTouchSwap     = false;
        private double  mTouchX;
        private double  mTouchY;
        private boolean mTouchFireATS  = false;
        private double  mTouchDxATS    = 0;
        private double  mTouchLastX    = 0;

        /**
         * Construct and configure this player input instance.
         * @param id - the player ID, e.g.,
         * <code>VirtualInput.PLAYER1</code>.
         * @param type - <code>true</code> if the player is a simulation.
         * @param remote - <code>true</code> if this player is playing on a
         * remote machine, <code>false</code> if this player is local.
         * @see VirtualInput
         */
        public PlayerInput(int id, boolean type, boolean remote) {
            init();
            configure(id, type, remote);
        }

        /**
         * Check if a center button press action is active.
         * @return True if the player pressed the center button.
         */
        public boolean actionCenter() {
            boolean tempCenter = mWasCenter;
            mWasCenter = false;
            return tempCenter;
        }

        /**
         * Check if a bubble launch action is active.
         * @return True if the player is launching a bubble.
         */
        public boolean actionUp() {
            boolean tempFire = mWasCenter || mWasUp;
            mWasCenter = false;
            mWasUp = false;
            return mCenter || mUp || tempFire;
        }

        /**
         * Check if a move left action is active.
         * @return True if the player is moving left.
         */
        public boolean actionLeft() {
            boolean tempLeft = mWasLeft;
            mWasLeft = false;
            return mLeft || tempLeft;
        }

        /**
         * Check if a move right action is active.
         * @return True if the player is moving right.
         */
        public boolean actionRight() {
            boolean tempRight = mWasRight;
            mWasRight = false;
            return mRight || tempRight;
        }

        /**
         * Check if a bubble swap action is active.
         * @return True if the player is swapping the launch bubble.
         */
        public boolean actionDown() {
            boolean tempSwap = mWasDown || mTouchSwap;
            mWasDown = false;
            mTouchSwap = false;
            return mDown || tempSwap;
        }

        /**
         * Check if a touchscreen initiated bubble launch is active.
         * @return True if the player is launching a bubble.
         */
        public boolean actionTouchFire() {
            boolean tempFire = mTouchFire;
            mTouchFire = false;
            return tempFire;
        }

        /**
         * Check if an ATS (aim-then-shoot) touchscreen initiated bubble
         * launch is active.
         * @return True if the player is launching a bubble.
         */
        public boolean actionTouchFireATS() {
            boolean tempFire = mTouchFireATS;
            mTouchFireATS = false;
            return tempFire;
        }

        /**
         * Based on the provided keypress, check if it corresponds to a new
         * player action.
         * @param keyCode
         * @return True if the current keypress indicates a new player action.
         */
        public boolean checkNewActionKeyPress(int keyCode) {
            return (!mLeft && !mRight && !mCenter && !mUp && !mDown) &&
                    ((keyCode == KeyEvent.KEYCODE_DPAD_LEFT) ||
                            (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) ||
                            (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
                            (keyCode == KeyEvent.KEYCODE_DPAD_UP) ||
                            (keyCode == KeyEvent.KEYCODE_DPAD_DOWN));
        }

        public int getLastKeyCode() {
            int keyCode = KeyEvent.KEYCODE_UNKNOWN;

            if (mLeft) {
                keyCode = KeyEvent.KEYCODE_DPAD_LEFT;
            }
            else if (mRight) {
                keyCode = KeyEvent.KEYCODE_DPAD_RIGHT;
            }
            else if (mCenter) {
                keyCode = KeyEvent.KEYCODE_DPAD_CENTER;
            }
            else if (mUp) {
                keyCode = KeyEvent.KEYCODE_DPAD_UP;
            }
            else if (mDown) {
                keyCode = KeyEvent.KEYCODE_DPAD_DOWN;
            }

            return keyCode;
        }

        /**
         * Obtain the ATS (aim-then-shoot) touch horizontal position change.
         * @return The horizontal touch change in position.
         */
        public double getTouchDxATS() {
            double tempDx = mTouchDxATS;
            mTouchDxATS = 0;
            return tempDx;
        }

        /**
         * Obtain the horizontal touch position.
         * @return The horizontal touch position.
         */
        public double getTouchX() {
            return mTouchX;
        }

        /**
         * Obtain the vertical touch position.
         * @return The vertical touch position.
         */
        public double getTouchY() {
            return mTouchY;
        }

        /**
         * Obtain the trackball position change.
         * @return The trackball position change.
         */
        public double getTrackBallDx() {
            double tempDx = mTrackballDx;
            mTrackballDx = 0;
            return tempDx;
        }

        public void init() {
            this.init_vars();
            mTrackballDx  = 0;
            mTouchFire    = false;
            mTouchSwap    = false;
            mTouchFireATS = false;
            mTouchDxATS   = 0;
        }

        /**
         * Process key presses.
         * @param keyCode
         * @return <code>true</code> if the key press was processed,
         * <code>false</code> if not.
         */
        public boolean setKeyDown(int keyCode) {
            boolean handled = false;
            switch(keyCode) {
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    mLeft    = true;
                    mWasLeft = true;
                    handled  = true;
                    break;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    mRight    = true;
                    mWasRight = true;
                    handled   = true;
                    break;
                case KeyEvent.KEYCODE_DPAD_CENTER:
                    mCenter    = true;
                    mWasCenter = true;
                    handled    = true;
                    break;
                case KeyEvent.KEYCODE_DPAD_UP:
                    mUp     = true;
                    mWasUp  = true;
                    handled = true;
                    break;
                case KeyEvent.KEYCODE_DPAD_DOWN:
                    mDown    = true;
                    mWasDown = true;
                    handled  = true;
                    break;
                default:
                    break;
            }
            return handled;
        }

        /**
         * Process key releases.
         * @param keyCode
         * @return True if the key release was processed, false if not.
         */
        public boolean setKeyUp(int keyCode) {
            boolean handled = false;
            switch(keyCode) {
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    mLeft   = false;
                    handled = true;
                    break;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    mRight  = false;
                    handled = true;
                    break;
                case KeyEvent.KEYCODE_DPAD_CENTER:
                    mCenter = false;
                    handled = true;
                    break;
                case KeyEvent.KEYCODE_DPAD_UP:
                    mUp     = false;
                    handled = true;
                    break;
                case KeyEvent.KEYCODE_DPAD_DOWN:
                    mDown   = false;
                    handled = true;
                    break;
                default:
                    break;
            }
            return handled;
        }

        public boolean setTouchEvent(int event, double x, double y) {
            boolean handled = false;
            if (GameScreen.stateEnum.RUNNING == GameScreen.stateEnum.RUNNING) {
                // Set the values used when Point To Shoot is on.
                if (event == MotionEvent.ACTION_DOWN) {
                    if (y < GameView.GameThread.TOUCH_FIRE_Y_THRESHOLD) {
                        mTouchFire = true;
                        mTouchX = x;
                        mTouchY = y;
                    }
                    else if (Math.abs(x - 318) <= GameView.GameThread.TOUCH_SWAP_X_THRESHOLD) {
                        mTouchSwap = true;
                    }
                }

                // Set the values used when Aim Then Shoot is on.
                if (event == MotionEvent.ACTION_DOWN) {
                    if (y < GameView.GameThread.ATS_TOUCH_FIRE_Y_THRESHOLD) {
                        mTouchFireATS = true;
                    }
                    mTouchLastX = x;
                }
                else if (event == MotionEvent.ACTION_MOVE) {
                    if (y >= GameView.GameThread.ATS_TOUCH_FIRE_Y_THRESHOLD) {
                        mTouchDxATS = (x - mTouchLastX) * GameView.GameThread.ATS_TOUCH_COEFFICIENT;
                    }
                    mTouchLastX = x;
                }
                handled = true;
            }
            return handled;
        }

        /**
         * Accumulate the change in trackball horizontal position.
         * @param trackBallDX
         */
        public void setTrackBallDx(double trackBallDX) {
            mTrackballDx += trackBallDX;
        }
    }
}