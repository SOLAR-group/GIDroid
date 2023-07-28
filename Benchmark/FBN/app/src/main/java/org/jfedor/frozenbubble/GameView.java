/*
 *                 [[ Frozen-Bubble ]]
 *
 * Copyright (c) 2000-2003 Guillaume Cottenceau.
 * Java sourcecode - Copyright (c) 2003 Glenn Sanson.
 * Additional source - Copyright (c) 2013 Eric Fortin.
 *
 * This code is distributed under the GNU General Public License
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 2 or 3, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to:
 * Free Software Foundation, Inc.
 * 675 Mass Ave
 * Cambridge, MA 02139, USA
 *
 * Artwork:
 *    Alexis Younes <73lab at free.fr>
 *      (everything but the bubbles)
 *    Amaury Amblard-Ladurantie <amaury at linuxfr.org>
 *      (the bubbles)
 *
 * Soundtrack:
 *    Matthias Le Bidan <matthias.le_bidan at caramail.com>
 *      (the three musics and all the sound effects)
 *
 * Design & Programming:
 *    Guillaume Cottenceau <guillaume.cottenceau at free.fr>
 *      (design and manage the project, whole Perl sourcecode)
 *
 * Java version:
 *    Glenn Sanson <glenn.sanson at free.fr>
 *      (whole Java sourcecode, including JIGA classes
 *             http://glenn.sanson.free.fr/jiga/)
 *
 * Android port:
 *    Pawel Aleksander Fedorynski <pfedor@fuw.edu.pl>
 *    Eric Fortin <videogameboy76 at yahoo.com>
 *    Copyright (c) Google Inc.
 *
 *          [[ http://glenn.sanson.free.fr/fb/ ]]
 *          [[ http://www.frozen-bubble.org/   ]]
 */

/* This file is derived from the LunarView.java file which is part of
 * the Lunar Lander game included with Android documentation.  The
 * copyright notice for the Lunar Lander is reproduced below.
 */

/*
 * Copyright (c) 2007 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 *
 */

package org.jfedor.frozenbubble;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import org.gsanson.frozenbubble.MalusBar;
import org.jfedor.frozenbubble.GameScreen.eventEnum;
import org.jfedor.frozenbubble.GameScreen.gameEnum;
import org.jfedor.frozenbubble.GameScreen.stateEnum;
import org.jfedor.frozenbubble.GameView.NetGameInterface.NetworkStatus;
import org.jfedor.frozenbubble.GameView.NetGameInterface.RemoteInterface;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.efortin.frozenbubble.ComputerAI;
import com.efortin.frozenbubble.HighscoreDO;
import com.efortin.frozenbubble.HighscoreManager;
import com.efortin.frozenbubble.NetworkManager;
import com.efortin.frozenbubble.NetworkManager.GameFieldData;
import com.efortin.frozenbubble.NetworkManager.PlayerAction;
import com.efortin.frozenbubble.NetworkManager.connectEnum;
import com.efortin.frozenbubble.VirtualInput;

public class GameView extends SurfaceView
  implements SurfaceHolder.Callback {

  public static final int  GAMEFIELD_WIDTH          = 320;
  public static final int  GAMEFIELD_HEIGHT         = 480;
  public static final int  EXTENDED_GAMEFIELD_WIDTH = 640;

  private boolean         levelStarted   = false;
  private boolean         mBlankScreen   = false;
  private boolean         muteKeyToggle  = false;
  private boolean         pauseKeyToggle = false;
  private int             gameLocale;
  private int             numPlayers;
  private int             numPlayer1GamesWon;
  private int             numPlayer2GamesWon;
  private ComputerAI      mOpponent;
  private Context         mContext;
  private gameEnum        game1Status;
  private GameThread      mGameThread;
  private NetworkManager  mNetworkManager;
  private Object          input1Lock;
  private Object          input2Lock;
  private PlayerInput     mPlayer1;
  private PlayerInput     mPlayer2;
  private RemoteInterface remoteInterface;
  private VirtualInput    mLocalInput;
  private VirtualInput    mRemoteInput;

  //********************************************************************
  // Listener interface for various events
  //********************************************************************

  /**
   * Game event listener user set.
   * @author Eric Fortin
   *
   */
  public interface GameListener {
    public abstract void onGameEvent(eventEnum event);
  }

  GameListener mGameListener;

  public void setGameListener(GameListener gl) {
    mGameListener = gl;
  }

  /**
   * Network game interface.  This interface declares methods that must
   * be implemented by the network management class to implement a
   * distributed network multiplayer game.
   * @author Eric Fortin
   *
   */
  public interface NetGameInterface {
    /**
     * A class to encapsulate all network status variables used in
     * drawing the network status screen.
     * @author efortin
     *
     */
    public class NetworkStatus {
      public int     localPlayerId;
      public int     remotePlayerId;
      public boolean isConnected;
      public boolean playerJoined;
      public boolean gotFieldData;
      public boolean gotPrefsData;
      public boolean readyToPlay;
      public String  localIpAddress;
      public String  remoteIpAddress;

      public NetworkStatus() {
        isConnected     = false;
        playerJoined    = false;
        gotFieldData    = false;
        gotPrefsData    = false;
        readyToPlay     = false;
        localIpAddress  = null;
        remoteIpAddress = null;
      }
    };

    /**
     * This class encapsulates player action and game field storage for
     * use by the game thread to determine when to process remote player
     * actions and game field bubble grid synchronization tasks.
     * @author Eric Fortin
     *
     */
    public class RemoteInterface {
      public boolean       gotAction;
      public boolean       gotFieldData;
      public boolean       gotPrefsData;
      public PlayerAction  playerAction;
      public GameFieldData gameFieldData;

      public RemoteInterface(PlayerAction action, GameFieldData fieldData) {
        gotAction     = false;
        gotFieldData  = false;
        gotPrefsData  = false;
        playerAction  = action;
        gameFieldData = fieldData;
      }

      public void cleanUp() {
        gotAction     = false;
        gotFieldData  = false;
        gotPrefsData  = false;
        playerAction  = null;
        gameFieldData = null;
      }
    };

    /*
     * Force the implementer to supply the following methods.
     */
    public abstract void checkRemoteChecksum();
    public abstract void cleanUp();
    public abstract boolean gameIsReadyForAction();
    public abstract boolean getGameIsFinished();
    public abstract short getLatestRemoteActionId();
    public abstract boolean getRemoteAction();
    public abstract PlayerAction getRemoteActionPreview();
    public abstract RemoteInterface getRemoteInterface();
    public abstract void newGame();
    public abstract void pause();
    public abstract void sendLocalPlayerAction(int playerId,
                                               boolean compress,
                                               boolean launch,
                                               boolean swap,
                                               int keyCode,
                                               int launchColor,
                                               int nextColor,
                                               int newNextColor,
                                               int attackBarBubbles,
                                               byte attackBubbles[],
                                               double aimPosition);
    public abstract void setGameIsFinished();
    public abstract void setLocalChecksum(short checksum);
    public abstract void setRemoteChecksum(short checksum);
    public abstract void unPause();
    public abstract void updateNetworkStatus(NetworkStatus status);
  }

  /**
   * This class encapsulates player input action variables and methods.
   * <p>This is to provide a common interface to the game independent
   * of the input source.
   * @author Eric Fortin
   *
   */
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
      if (mGameThread.mMode == stateEnum.RUNNING) {
        // Set the values used when Point To Shoot is on.
        if (event == MotionEvent.ACTION_DOWN) {
          if (y < GameThread.TOUCH_FIRE_Y_THRESHOLD) {
            mTouchFire = true;
            mTouchX = x;
            mTouchY = y;
          }
          else if (Math.abs(x - 318) <= GameThread.TOUCH_SWAP_X_THRESHOLD) {
            mTouchSwap = true;
          }
        }

        // Set the values used when Aim Then Shoot is on.
        if (event == MotionEvent.ACTION_DOWN) {
          if (y < GameThread.ATS_TOUCH_FIRE_Y_THRESHOLD) {
            mTouchFireATS = true;
          }
          mTouchLastX = x;
        }
        else if (event == MotionEvent.ACTION_MOVE) {
          if (y >= GameThread.ATS_TOUCH_FIRE_Y_THRESHOLD) {
            mTouchDxATS = (x - mTouchLastX) * GameThread.ATS_TOUCH_COEFFICIENT;
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

  class GameThread extends Thread {

    private static final int FRAME_DELAY = 40;

    public static final int    BACK_1P_X                  = 447;
    public static final int    BACK_1P_Y                  = 0;
    public static final int    BACK_2P_X                  = 287;
    public static final int    BACK_2P_Y                  = 0;
    public static final int    BACK_TOUCH_X               = 463;
    public static final int    BACK_TOUCH_Y               = 15;
    public static final int    PAUSE_TOUCH_X              = 183;
    public static final int    PAUSE_TOUCH_Y              = 460;
    public static final double TRACKBALL_COEFFICIENT      = 5;
    public static final double TOUCH_BUTTON_THRESHOLD     = 16;
    public static final double TOUCH_FIRE_Y_THRESHOLD     = 380;
    public static final double TOUCH_SWAP_X_THRESHOLD     = 14;
    public static final double ATS_TOUCH_COEFFICIENT      = 0.2;
    public static final double ATS_TOUCH_FIRE_Y_THRESHOLD = 350;

    private boolean mImagesReady = false;
    private boolean mRun         = false;
    private boolean mShowNetwork = false;
    private boolean mShowScores  = false;
    private boolean mSurfaceOK   = false;

    private int    mDisplayDX;
    private int    mDisplayDY;
    private double mDisplayScale;
    private long   mLastTime;
    private int    mPlayer1DX;
    private int    mPlayer2DX;

    private stateEnum mMode;
    private stateEnum mModeWas;

    private Bitmap mBackButtonOrig;
    private Bitmap mBackgroundOrig;
    private Bitmap[] mBubblesOrig;
    private Bitmap[] mBubblesBlindOrig;
    private Bitmap[] mFrozenBubblesOrig;
    private Bitmap[] mTargetedBubblesOrig;
    private Bitmap mBubbleBlinkOrig;
    private Bitmap mGameWonOrig;
    private Bitmap mGameLostOrig;
    private Bitmap mGamePausedOrig;
    private Bitmap mHurryOrig;
    private Bitmap mPauseButtonOrig;
    private Bitmap mPlayButtonOrig;
    private Bitmap mPenguinsOrig;
    private Bitmap mPenguins2Orig;
    private Bitmap mCompressorHeadOrig;
    private Bitmap mCompressorOrig;
    private Bitmap mLifeOrig;
    private Bitmap mFontImageOrig;
    private Bitmap mBananaOrig;
    private Bitmap mTomatoOrig;
    private BmpWrap mBackButton;
    private BmpWrap mBackground;
    private BmpWrap[] mBubbles;
    private BmpWrap[] mBubblesBlind;
    private BmpWrap[] mFrozenBubbles;
    private BmpWrap[] mTargetedBubbles;
    private BmpWrap mBubbleBlink;
    private BmpWrap mGameWon;
    private BmpWrap mGameLost;
    private BmpWrap mGamePaused;
    private BmpWrap mHurry;
    private BmpWrap mPauseButton;
    private BmpWrap mPlayButton;
    private BmpWrap mPenguins;
    private BmpWrap mPenguins2;
    private BmpWrap mCompressorHead;
    private BmpWrap mCompressor;
    private BmpWrap mLife;
    private BmpWrap mFontImage;
    private BmpWrap mBanana;
    private BmpWrap mTomato;

    private BubbleFont    mFont;
    private Drawable      mLauncher;  // drawable because we rotate it
    private FrozenGame    mFrozenGame1;
    private FrozenGame    mFrozenGame2;
    private LevelManager  mLevelManager;
    private MalusBar      malusBar1;
    private MalusBar      malusBar2;
    private SoundManager  mSoundManager;
    private SurfaceHolder mSurfaceHolder;

    private final HighscoreManager mHighScoreManager;

    Vector<BmpWrap> mImageList;

    public GameThread(SurfaceHolder surfaceHolder) {
      //Log.i("frozen-bubble", "GameThread()");
      mSurfaceHolder = surfaceHolder;
      Resources res = mContext.getResources();
      setState(stateEnum.PAUSED);

      BitmapFactory.Options options = new BitmapFactory.Options();

      /*
       * The Options.inScaled field is only available starting at API 4.
       */
      try {
        Field f = options.getClass().getField("inScaled");
        f.set(options, Boolean.FALSE);
      } catch (Exception ignore) {}

      mBackButtonOrig = BitmapFactory.decodeResource(
          res, R.drawable.back_button, options);
      mBackgroundOrig = BitmapFactory.decodeResource(
        res, R.drawable.background2, options);
      mBubblesOrig = new Bitmap[8];
      mBubblesOrig[0] = BitmapFactory.decodeResource(
        res, R.drawable.bubble_1, options);
      mBubblesOrig[1] = BitmapFactory.decodeResource(
        res, R.drawable.bubble_2, options);
      mBubblesOrig[2] = BitmapFactory.decodeResource(
        res, R.drawable.bubble_3, options);
      mBubblesOrig[3] = BitmapFactory.decodeResource(
        res, R.drawable.bubble_4, options);
      mBubblesOrig[4] = BitmapFactory.decodeResource(
        res, R.drawable.bubble_5, options);
      mBubblesOrig[5] = BitmapFactory.decodeResource(
        res, R.drawable.bubble_6, options);
      mBubblesOrig[6] = BitmapFactory.decodeResource(
        res, R.drawable.bubble_7, options);
      mBubblesOrig[7] = BitmapFactory.decodeResource(
        res, R.drawable.bubble_8, options);
      mBubblesBlindOrig = new Bitmap[8];
      mBubblesBlindOrig[0] = BitmapFactory.decodeResource(
        res, R.drawable.bubble_colourblind_1, options);
      mBubblesBlindOrig[1] = BitmapFactory.decodeResource(
        res, R.drawable.bubble_colourblind_2, options);
      mBubblesBlindOrig[2] = BitmapFactory.decodeResource(
        res, R.drawable.bubble_colourblind_3, options);
      mBubblesBlindOrig[3] = BitmapFactory.decodeResource(
        res, R.drawable.bubble_colourblind_4, options);
      mBubblesBlindOrig[4] = BitmapFactory.decodeResource(
        res, R.drawable.bubble_colourblind_5, options);
      mBubblesBlindOrig[5] = BitmapFactory.decodeResource(
        res, R.drawable.bubble_colourblind_6, options);
      mBubblesBlindOrig[6] = BitmapFactory.decodeResource(
        res, R.drawable.bubble_colourblind_7, options);
      mBubblesBlindOrig[7] = BitmapFactory.decodeResource(
        res, R.drawable.bubble_colourblind_8, options);
      mFrozenBubblesOrig = new Bitmap[8];
      mFrozenBubblesOrig[0] = BitmapFactory.decodeResource(
        res, R.drawable.frozen_1, options);
      mFrozenBubblesOrig[1] = BitmapFactory.decodeResource(
        res, R.drawable.frozen_2, options);
      mFrozenBubblesOrig[2] = BitmapFactory.decodeResource(
        res, R.drawable.frozen_3, options);
      mFrozenBubblesOrig[3] = BitmapFactory.decodeResource(
        res, R.drawable.frozen_4, options);
      mFrozenBubblesOrig[4] = BitmapFactory.decodeResource(
        res, R.drawable.frozen_5, options);
      mFrozenBubblesOrig[5] = BitmapFactory.decodeResource(
        res, R.drawable.frozen_6, options);
      mFrozenBubblesOrig[6] = BitmapFactory.decodeResource(
        res, R.drawable.frozen_7, options);
      mFrozenBubblesOrig[7] = BitmapFactory.decodeResource(
        res, R.drawable.frozen_8, options);
      mTargetedBubblesOrig = new Bitmap[6];
      mTargetedBubblesOrig[0] = BitmapFactory.decodeResource(
        res, R.drawable.fixed_1, options);
      mTargetedBubblesOrig[1] = BitmapFactory.decodeResource(
        res, R.drawable.fixed_2, options);
      mTargetedBubblesOrig[2] = BitmapFactory.decodeResource(
        res, R.drawable.fixed_3, options);
      mTargetedBubblesOrig[3] = BitmapFactory.decodeResource(
        res, R.drawable.fixed_4, options);
      mTargetedBubblesOrig[4] = BitmapFactory.decodeResource(
        res, R.drawable.fixed_5, options);
      mTargetedBubblesOrig[5] = BitmapFactory.decodeResource(
        res, R.drawable.fixed_6, options);
      mBubbleBlinkOrig = BitmapFactory.decodeResource(
        res, R.drawable.bubble_blink, options);
      mGameWonOrig = BitmapFactory.decodeResource(
        res, R.drawable.win_panel, options);
      mGameLostOrig = BitmapFactory.decodeResource(
        res, R.drawable.lose_panel, options);
      mGamePausedOrig = BitmapFactory.decodeResource(
        res, R.drawable.pause_panel, options);
      mHurryOrig = BitmapFactory.decodeResource(
        res, R.drawable.hurry, options);
      mPauseButtonOrig = BitmapFactory.decodeResource(
        res, R.drawable.pause_button, options);
      mPlayButtonOrig = BitmapFactory.decodeResource(
        res, R.drawable.play_button, options);
      mPenguinsOrig = BitmapFactory.decodeResource(
        res, R.drawable.penguins, options);
      mPenguins2Orig = BitmapFactory.decodeResource(
        res, R.drawable.penguins2, options);
      mCompressorHeadOrig = BitmapFactory.decodeResource(
        res, R.drawable.compressor, options);
      mCompressorOrig = BitmapFactory.decodeResource(
        res, R.drawable.compressor_body, options);
      mLifeOrig = BitmapFactory.decodeResource(
        res, R.drawable.life, options);
      mFontImageOrig = BitmapFactory.decodeResource(
        res, R.drawable.bubble_font, options);
      mBananaOrig = BitmapFactory.decodeResource(
        res, R.drawable.banana, options);
      mTomatoOrig = BitmapFactory.decodeResource(
        res, R.drawable.tomato, options);

      mImageList = new Vector<BmpWrap>();

      mBubbles = new BmpWrap[8];
      for (int i = 0; i < mBubbles.length; i++) {
        mBubbles[i] = NewBmpWrap();
      }

      mBubblesBlind = new BmpWrap[8];
      for (int i = 0; i < mBubblesBlind.length; i++) {
        mBubblesBlind[i] = NewBmpWrap();
      }

      mFrozenBubbles = new BmpWrap[8];
      for (int i = 0; i < mFrozenBubbles.length; i++) {
        mFrozenBubbles[i] = NewBmpWrap();
      }

      mTargetedBubbles = new BmpWrap[6];
      for (int i = 0; i < mTargetedBubbles.length; i++) {
        mTargetedBubbles[i] = NewBmpWrap();
      }

      mBackButton     = NewBmpWrap();
      mBackground     = NewBmpWrap();
      mBubbleBlink    = NewBmpWrap();
      mGameWon        = NewBmpWrap();
      mGameLost       = NewBmpWrap();
      mGamePaused     = NewBmpWrap();
      mHurry          = NewBmpWrap();
      mPauseButton    = NewBmpWrap();
      mPlayButton     = NewBmpWrap();
      mPenguins       = NewBmpWrap();
      mPenguins2      = NewBmpWrap();
      mCompressorHead = NewBmpWrap();
      mCompressor     = NewBmpWrap();
      mLife           = NewBmpWrap();
      mFontImage      = NewBmpWrap();
      mBanana         = NewBmpWrap();
      mTomato         = NewBmpWrap();

      mFont             = new BubbleFont(mFontImage);
      mLauncher         = res.getDrawable(R.drawable.launcher);
      mSoundManager     = new SoundManager(mContext);

      /*
       * Load game sound effects.
       */
      mSoundManager.loadSound("applause",      R.raw.applause     );
      mSoundManager.loadSound("destroy_group", R.raw.destroy_group);
      mSoundManager.loadSound("hurry",         R.raw.hurry        );
      mSoundManager.loadSound("launch",        R.raw.launch       );
      mSoundManager.loadSound("lose",          R.raw.lose         );
      mSoundManager.loadSound("newroot_solo",  R.raw.newroot_solo );
      mSoundManager.loadSound("noh",           R.raw.noh          );
      mSoundManager.loadSound("rebound",       R.raw.rebound      );
      mSoundManager.loadSound("stick",         R.raw.stick        );
      mSoundManager.loadSound("whip",          R.raw.whip         );

      /*
       * Only keep a high score database when the opponent is the CPU.
       */
      if (mRemoteInput.isCPU) {
        mHighScoreManager = new HighscoreManager(getContext(),
                                                 HighscoreManager.
                                                 MULTIPLAYER_DATABASE_NAME);
      }
      else {
        mHighScoreManager = null;
      }

      mLevelManager = new LevelManager(0, FrozenBubble.getDifficulty());
      newGame(false);
    }

    public GameThread(SurfaceHolder surfaceHolder, byte[] customLevels,
                      int startingLevel, boolean arcadeGame) {
      //Log.i("frozen-bubble", "GameThread()");
      mSurfaceHolder = surfaceHolder;
      Resources res = mContext.getResources();
      setState(stateEnum.PAUSED);

      BitmapFactory.Options options = new BitmapFactory.Options();

      /*
       *  The Options.inScaled field is only available starting at API 4.
       */
      try {
        Field f = options.getClass().getField("inScaled");
        f.set(options, Boolean.FALSE);
      } catch (Exception ignore) {}

      mBackButtonOrig = BitmapFactory.decodeResource(
          res, R.drawable.back_button, options);
      mBackgroundOrig = BitmapFactory.decodeResource(
          res, R.drawable.background, options);
      mBubblesOrig = new Bitmap[8];
      mBubblesOrig[0] = BitmapFactory.decodeResource(
          res, R.drawable.bubble_1, options);
      mBubblesOrig[1] = BitmapFactory.decodeResource(
          res, R.drawable.bubble_2, options);
      mBubblesOrig[2] = BitmapFactory.decodeResource(
          res, R.drawable.bubble_3, options);
      mBubblesOrig[3] = BitmapFactory.decodeResource(
          res, R.drawable.bubble_4, options);
      mBubblesOrig[4] = BitmapFactory.decodeResource(
          res, R.drawable.bubble_5, options);
      mBubblesOrig[5] = BitmapFactory.decodeResource(
          res, R.drawable.bubble_6, options);
      mBubblesOrig[6] = BitmapFactory.decodeResource(
          res, R.drawable.bubble_7, options);
      mBubblesOrig[7] = BitmapFactory.decodeResource(
          res, R.drawable.bubble_8, options);
      mBubblesBlindOrig = new Bitmap[8];
      mBubblesBlindOrig[0] = BitmapFactory.decodeResource(
          res, R.drawable.bubble_colourblind_1, options);
      mBubblesBlindOrig[1] = BitmapFactory.decodeResource(
          res, R.drawable.bubble_colourblind_2, options);
      mBubblesBlindOrig[2] = BitmapFactory.decodeResource(
          res, R.drawable.bubble_colourblind_3, options);
      mBubblesBlindOrig[3] = BitmapFactory.decodeResource(
          res, R.drawable.bubble_colourblind_4, options);
      mBubblesBlindOrig[4] = BitmapFactory.decodeResource(
          res, R.drawable.bubble_colourblind_5, options);
      mBubblesBlindOrig[5] = BitmapFactory.decodeResource(
          res, R.drawable.bubble_colourblind_6, options);
      mBubblesBlindOrig[6] = BitmapFactory.decodeResource(
          res, R.drawable.bubble_colourblind_7, options);
      mBubblesBlindOrig[7] = BitmapFactory.decodeResource(
          res, R.drawable.bubble_colourblind_8, options);
      mFrozenBubblesOrig = new Bitmap[8];
      mFrozenBubblesOrig[0] = BitmapFactory.decodeResource(
          res, R.drawable.frozen_1, options);
      mFrozenBubblesOrig[1] = BitmapFactory.decodeResource(
          res, R.drawable.frozen_2, options);
      mFrozenBubblesOrig[2] = BitmapFactory.decodeResource(
          res, R.drawable.frozen_3, options);
      mFrozenBubblesOrig[3] = BitmapFactory.decodeResource(
          res, R.drawable.frozen_4, options);
      mFrozenBubblesOrig[4] = BitmapFactory.decodeResource(
          res, R.drawable.frozen_5, options);
      mFrozenBubblesOrig[5] = BitmapFactory.decodeResource(
          res, R.drawable.frozen_6, options);
      mFrozenBubblesOrig[6] = BitmapFactory.decodeResource(
          res, R.drawable.frozen_7, options);
      mFrozenBubblesOrig[7] = BitmapFactory.decodeResource(
          res, R.drawable.frozen_8, options);
      mTargetedBubblesOrig = new Bitmap[6];
      mTargetedBubblesOrig[0] = BitmapFactory.decodeResource(
          res, R.drawable.fixed_1, options);
      mTargetedBubblesOrig[1] = BitmapFactory.decodeResource(
          res, R.drawable.fixed_2, options);
      mTargetedBubblesOrig[2] = BitmapFactory.decodeResource(
          res, R.drawable.fixed_3, options);
      mTargetedBubblesOrig[3] = BitmapFactory.decodeResource(
          res, R.drawable.fixed_4, options);
      mTargetedBubblesOrig[4] = BitmapFactory.decodeResource(
          res, R.drawable.fixed_5, options);
      mTargetedBubblesOrig[5] = BitmapFactory.decodeResource(
          res, R.drawable.fixed_6, options);
      mBubbleBlinkOrig = BitmapFactory.decodeResource(
          res, R.drawable.bubble_blink, options);
      mGameWonOrig = BitmapFactory.decodeResource(
          res, R.drawable.win_panel, options);
      mGameLostOrig = BitmapFactory.decodeResource(
          res, R.drawable.lose_panel, options);
      mGamePausedOrig = BitmapFactory.decodeResource(
          res, R.drawable.pause_panel, options);
      mHurryOrig = BitmapFactory.decodeResource(
          res, R.drawable.hurry, options);
      mPauseButtonOrig = null;
      mPlayButtonOrig = BitmapFactory.decodeResource(
          res, R.drawable.play_button, options);
      mPenguinsOrig = BitmapFactory.decodeResource(
          res, R.drawable.penguins, options);
      mPenguins2Orig = null;
      mCompressorHeadOrig = BitmapFactory.decodeResource(
          res, R.drawable.compressor, options);
      mCompressorOrig = BitmapFactory.decodeResource(
          res, R.drawable.compressor_body, options);
      mLifeOrig = BitmapFactory.decodeResource(
           res, R.drawable.life, options);
      mFontImageOrig = BitmapFactory.decodeResource(
          res, R.drawable.bubble_font, options);
      mBananaOrig = null;
      mTomatoOrig = null;

      mImageList = new Vector<BmpWrap>();

      mBubbles = new BmpWrap[8];
      for (int i = 0; i < mBubbles.length; i++) {
        mBubbles[i] = NewBmpWrap();
      }

      mBubblesBlind = new BmpWrap[8];
      for (int i = 0; i < mBubblesBlind.length; i++) {
        mBubblesBlind[i] = NewBmpWrap();
      }

      mFrozenBubbles = new BmpWrap[8];
      for (int i = 0; i < mFrozenBubbles.length; i++) {
        mFrozenBubbles[i] = NewBmpWrap();
      }

      mTargetedBubbles = new BmpWrap[6];
      for (int i = 0; i < mTargetedBubbles.length; i++) {
        mTargetedBubbles[i] = NewBmpWrap();
      }

      mBackButton     = NewBmpWrap();
      mBackground     = NewBmpWrap();
      mBubbleBlink    = NewBmpWrap();
      mGameWon        = NewBmpWrap();
      mGameLost       = NewBmpWrap();
      mGamePaused     = NewBmpWrap();
      mHurry          = NewBmpWrap();
      mPauseButton    = null;
      mPlayButton     = NewBmpWrap();
      mPenguins       = NewBmpWrap();
      mPenguins2      = null;
      mCompressorHead = NewBmpWrap();
      mCompressor     = NewBmpWrap();
      mLife           = NewBmpWrap();
      mFontImage      = NewBmpWrap();
      mBanana         = null;
      mTomato         = null;

      mFont             = new BubbleFont(mFontImage);
      mLauncher         = res.getDrawable(R.drawable.launcher);
      mSoundManager     = new SoundManager(mContext);

      /*
       * Load game sound effects.
       */
      mSoundManager.loadSound("applause",      R.raw.applause     );
      mSoundManager.loadSound("destroy_group", R.raw.destroy_group);
      mSoundManager.loadSound("hurry",         R.raw.hurry        );
      mSoundManager.loadSound("launch",        R.raw.launch       );
      mSoundManager.loadSound("lose",          R.raw.lose         );
      mSoundManager.loadSound("newroot_solo",  R.raw.newroot_solo );
      mSoundManager.loadSound("noh",           R.raw.noh          );
      mSoundManager.loadSound("rebound",       R.raw.rebound      );
      mSoundManager.loadSound("stick",         R.raw.stick        );
      mSoundManager.loadSound("whip",          R.raw.whip         );

      if (arcadeGame) {
        mHighScoreManager =
            new HighscoreManager(getContext(),
                                 HighscoreManager.ARCADE_DATABASE_NAME);
        mLevelManager = new LevelManager(System.currentTimeMillis(),
                                         FrozenBubble.getDifficulty());
      }
      else {
        mHighScoreManager =
            new HighscoreManager(getContext(),
                                 HighscoreManager.PUZZLE_DATABASE_NAME);
        if (null == customLevels) {
          try {
            InputStream is     = mContext.getAssets().open("levels.txt");
            int         size   = is.available();
            byte[]      levels = new byte[size];
            is.read(levels);
            is.close();
            SharedPreferences sp = mContext.getSharedPreferences(
            FrozenBubble.PREFS_NAME, Context.MODE_PRIVATE);
            startingLevel = sp.getInt("level", 0);
            mLevelManager = new LevelManager(levels, startingLevel);
          } catch (IOException e) {
            /*
             *  Should never happen.
             */
            throw new RuntimeException(e);
          }
        }
        else {
          /*
           *  We were launched by the level editor.
           */
          mLevelManager = new LevelManager(customLevels, startingLevel);
        }
      }

      newGame(false);
    }

    public void cleanUp() {
      synchronized(mSurfaceHolder) {
        /*
         * I don't really understand why all this is necessary.
         * I used to get a crash (an out-of-memory error) once every six or
         * seven times I started the game.  I googled the error and someone
         * said you have to call recycle() on all the bitmaps and set
         * the pointers to null to facilitate garbage collection.  So I did
         * and the crashes went away.
         */
        mImagesReady = false;
        mFrozenGame1 = null;
        mFrozenGame2 = null;

        mBackButtonOrig.recycle();
        mBackButtonOrig = null;

        mBackgroundOrig.recycle();
        mBackgroundOrig = null;

        for (int i = 0; i < mBubblesOrig.length; i++) {
          mBubblesOrig[i].recycle();
          mBubblesOrig[i] = null;
        }
        mBubblesOrig = null;

        for (int i = 0; i < mBubblesBlindOrig.length; i++) {
          mBubblesBlindOrig[i].recycle();
          mBubblesBlindOrig[i] = null;
        }
        mBubblesBlindOrig = null;

        for (int i = 0; i < mFrozenBubblesOrig.length; i++) {
          mFrozenBubblesOrig[i].recycle();
          mFrozenBubblesOrig[i] = null;
        }
        mFrozenBubblesOrig = null;

        for (int i = 0; i < mTargetedBubblesOrig.length; i++) {
          mTargetedBubblesOrig[i].recycle();
          mTargetedBubblesOrig[i] = null;
        }
        mTargetedBubblesOrig = null;

        mBubbleBlinkOrig.recycle();
        mBubbleBlinkOrig = null;
        mGameWonOrig.recycle();
        mGameWonOrig = null;
        mGameLostOrig.recycle();
        mGameLostOrig = null;
        mGamePausedOrig.recycle();
        mGamePausedOrig = null;
        mHurryOrig.recycle();
        mHurryOrig = null;
        if (mPauseButtonOrig != null) {
          mPauseButtonOrig.recycle();
        }
        mPauseButtonOrig = null;
        if (mPlayButtonOrig != null) {
          mPlayButtonOrig.recycle();
        }
        mPlayButtonOrig = null;
        mPenguinsOrig.recycle();
        mPenguinsOrig = null;
        if (mPenguins2Orig != null) {
          mPenguins2Orig.recycle();
        }
        mPenguins2Orig = null;
        mCompressorHeadOrig.recycle();
        mCompressorHeadOrig = null;
        mCompressorOrig.recycle();
        mCompressorOrig = null;
        mLifeOrig.recycle();
        mLifeOrig = null;
        mFontImageOrig.recycle();
        mFontImageOrig = null;
        if (mBananaOrig != null) {
          mBananaOrig.recycle();
        }
        mBananaOrig = null;
        if (mTomatoOrig != null) {
          mTomatoOrig.recycle();
        }
        mTomatoOrig = null;

        /*
         * All the scalable bitmaps are located within the image list,
         * so recycling all the bitmaps in this list ensures they are
         * all recycled.
         */
        int size = mImageList.size();
        while (size > 0) {
          BmpWrap bmpWrap = mImageList.elementAt(--size);
          /*
           * If the bitmaps were not scaled, then they will already have
           * been recycled.
           */
          if (bmpWrap.bmp != null) {
            bmpWrap.bmp.recycle();
          }
          bmpWrap.bmp = null;
        }
        mImageList.clear();
        mImageList = null;

        mBackButton = null;
        mBackground = null;

        for (int i = 0; i < mBubbles.length; i++) {
          mBubbles[i] = null;
        }
        mBubbles = null;

        for (int i = 0; i < mBubblesBlind.length; i++) {
          mBubblesBlind[i] = null;
        }
        mBubblesBlind = null;

        for (int i = 0; i < mFrozenBubbles.length; i++) {
          mFrozenBubbles[i] = null;
        }
        mFrozenBubbles = null;

        for (int i = 0; i < mTargetedBubbles.length; i++) {
          mTargetedBubbles[i] = null;
        }
        mTargetedBubbles = null;

        mBubbleBlink    = null;
        mGameWon        = null;
        mGameLost       = null;
        mGamePaused     = null;
        mHurry          = null;
        mPauseButton    = null;
        mPlayButton     = null;
        mPenguins       = null;
        mPenguins2      = null;
        mCompressorHead = null;
        mCompressor     = null;
        mLife           = null;
        mFontImage      = null;
        mBanana         = null;
        mTomato         = null;

        mSoundManager.cleanUp();
        mSoundManager = null;
        mLevelManager = null;

        if (mHighScoreManager != null) {
          mHighScoreManager.close();
        }
      }
    }

    private void doDraw(Canvas canvas) {
      //Log.i("frozen-bubble", "doDraw()");
      if (!mImagesReady) {
        //Log.i("frozen-bubble", "!mImagesReady, returning");
        return;
      }
      if ((mDisplayDX > 0) || (mDisplayDY > 0)) {
        //Log.i("frozen-bubble", "Drawing black background.");
        canvas.drawRGB(0, 0, 0);
      }
      drawBackground(canvas);
      if (mFrozenGame1 != null) {
        mFrozenGame1.paint(canvas, mDisplayScale, mPlayer1DX, mDisplayDY);
      }
      if (FrozenBubble.arcadeGame) {
        drawDifficulty(canvas);
      }
      else if (numPlayers > 1) {
        if (mFrozenGame2 != null) {
          mFrozenGame2.paint(canvas, mDisplayScale, mPlayer2DX, mDisplayDY);
        }
        drawWinTotals(canvas);
      }
      else {
        drawLevelNumber(canvas);
      }
    }

    /**
     * Process key presses.  This must be allowed to run regardless of
     * the game state to correctly handle initial game conditions.
     * <p>TODO: Early versions of Android have a bug related to handling
     * key events from multiple inputs, in that it does not check the
     * input source upon an <code>onKeyDown</code> event and it does not
     * issue an <code>onKeyDown</code> event if a separate input
     * source a key press with the same key code as the previous input
     * without an intervening <code>onKeyUp</code> event.  At some
     * point, a workaround needs to be implemented, or the application
     * should be migrated to a version of Android without the bug.
     * @param keyCode - the static KeyEvent key identifier.
     * @param deviceId - the source device ID.
     * @return - <code>true</code> if the key action is processed.
     * @see android.view.View#onKeyDown(int, android.view.KeyEvent)
     */
    boolean doKeyDown(int keyCode, int deviceId) {
      boolean handled = false;
      /*
       * If this input came from a second connected gamepad, then it
       * came from player 2.
       */
      if (isRemoteInput(deviceId)) {
        /*
         * Only update the game state if this is a fresh key press.
         */
        if (mRemoteInput.checkNewActionKeyPress(keyCode))
          updateStateOnEvent(null);

        /*
         * Process the key press if it is a function key.
         */
        toggleKeyPress(keyCode, true, true);

        /*
         * Process the key press if it is a game input key, except if a
         * level is being started.  This is so we do not get an
         * inadvertent bubble launch.
         */
        if (!levelStarted) {
          if (mRemoteInput.playerID == VirtualInput.PLAYER1) {
            synchronized(input1Lock) {
              mRemoteInput.setKeyUp(mRemoteInput.getLastKeyCode());
              handled = mRemoteInput.setKeyDown(keyCode);
            }
          }
          else {
            synchronized(input2Lock) {
              mRemoteInput.setKeyUp(mRemoteInput.getLastKeyCode());
              handled = mRemoteInput.setKeyDown(keyCode);
            }
          }
        }
      }
      else {
        /*
         * Only update the game state if this is a fresh key press.
         */
        if (mLocalInput.checkNewActionKeyPress(keyCode))
          updateStateOnEvent(null);

        /*
         * Process the key press if it is a function key.
         */
        toggleKeyPress(keyCode, true, true);

        /*
         * Process the key press if it is a game input key, except if a
         * level is being started.  This is so we do not get an
         * inadvertent bubble launch.
         */
        if (!levelStarted) {
          if (mLocalInput.playerID == VirtualInput.PLAYER1) {
            synchronized(input1Lock) {
              mLocalInput.setKeyUp(mLocalInput.getLastKeyCode());
              handled = mLocalInput.setKeyDown(keyCode);
            }
          }
          else {
            synchronized(input2Lock) {
              mLocalInput.setKeyUp(mLocalInput.getLastKeyCode());
              handled = mLocalInput.setKeyDown(keyCode);
            }
          }
        }
      }

      return handled;
    }

    /**
     * Process key releases.  This must be allowed to run regardless of
     * the game state in order to properly clear key presses.
     * @param deviceId - the input source device identifier.
     * @return - <code>true</code> if the key action is processed.
     * @see android.view.View#onKeyUp(int, android.view.KeyEvent)
     */
    boolean doKeyUp(int deviceId) {
      boolean handled = false;
      /*
       * Process a key up event by simply clearing the last key pressed.
       * TODO: Early versions of Android have a bug related to handling
       * key events from multiple inputs, in that it does not check the
       * input source upon an <code>onKeyUp</code> event and clears all
       * <code>onKeyDown</code> event occurrences.  Thus the only
       * recourse is to clear all local key presses upon a key up event.
       * When multiple keys are pressed simultaneously, we we only get
       * an <code>onKeyUp</code> event after the first key release.  At
       * some point, a proper workaround needs to be implemented, or the
       * application should be migrated to a version of Android without
       * the bug.
       */
      if (isRemoteInput(deviceId)) {
        if (mRemoteInput.playerID == VirtualInput.PLAYER1) {
          synchronized(input1Lock) {
            handled = mRemoteInput.setKeyUp(mRemoteInput.getLastKeyCode());
          }
        }
        else {
          synchronized(input2Lock) {
            handled = mRemoteInput.setKeyUp(mRemoteInput.getLastKeyCode());
          }
        }
      }
      else {
        if (mLocalInput.playerID == VirtualInput.PLAYER1) {
          synchronized(input1Lock) {
            handled = mLocalInput.setKeyUp(mLocalInput.getLastKeyCode());
          }
        }
        else {
          synchronized(input2Lock) {
            handled = mLocalInput.setKeyUp(mLocalInput.getLastKeyCode());
          }
        }
      }

      return handled;
    }

    /**
     * This method handles screen touch motion events.
     * <p>This method will be called three times in succession for each
     * touch, to process <code>ACTION_DOWN</code>,
     * <code>ACTION_UP</code>, and <code>ACTION_MOVE</code>.
     * @param event - the motion event.
     * @return <code>true</code> if the event was handled.
     */
    boolean doTouchEvent(MotionEvent event) {
      boolean handled = false;
      double  x_offset;
      double  x       = xFromScr(event.getX());
      double  y       = yFromScr(event.getY());

      if (mLocalInput.playerID == VirtualInput.PLAYER2) {
        x_offset = -318;
      }
      else {
        x_offset = 0;
      }

      /*
       * Check for a back button sprite press.
       */
      if (event.getAction() == MotionEvent.ACTION_DOWN) {
        if ((Math.abs(x - BACK_TOUCH_X) <= TOUCH_BUTTON_THRESHOLD) &&
            (Math.abs(y - BACK_TOUCH_Y) <= TOUCH_BUTTON_THRESHOLD)) {
          if (mGameListener != null) {
            mGameListener.onGameEvent(eventEnum.GAME_EXIT);
            return true;
          }
        }
      }

      /*
       * Check for a pause button sprite press.  This will toggle the
       * pause button sprite between pause and play.  If the game was
       * previously paused by the pause button, ignore screen touches
       * that aren't on the pause button sprite.
       */
      if (event.getAction() == MotionEvent.ACTION_DOWN) {
        if ((Math.abs(x - PAUSE_TOUCH_X) <= TOUCH_BUTTON_THRESHOLD) &&
            (Math.abs(y - PAUSE_TOUCH_Y) <= TOUCH_BUTTON_THRESHOLD)) {
          toggleKeyPress(KeyEvent.KEYCODE_P, false, true);
        }
        else if (toggleKeyState(KeyEvent.KEYCODE_P)) {
          return false;
        }
      }

      /*
       * Update the game state (paused, running, etc.) if necessary.
       */
      if(updateStateOnEvent(event)) {
        return true;
      }

      /*
       * If the game is running and the pause button sprite was pressed,
       * pause the game.
       */
      if ((mMode == stateEnum.RUNNING) &&
          (toggleKeyState(KeyEvent.KEYCODE_P))) {
        pause();
      }

      /*
       * Process the screen touch event.
       */
      if (mLocalInput.playerID == VirtualInput.PLAYER1) {
        synchronized(input1Lock) {
          handled = mLocalInput.setTouchEvent(event.getAction(), x + x_offset, y);
        }
      }
      else {
        synchronized(input2Lock) {
          handled = mLocalInput.setTouchEvent(event.getAction(), x + x_offset, y);
        }
      }
      return handled;
    }

    /**
     * Process trackball motion events.
     * <p>This method only processes trackball motion for the purpose of
     * aiming the launcher.  The trackball has no effect on the game
     * state, much like moving a mouse cursor over a screen does not
     * perform any intrinsic actions in most applications.
     * @param event - the motion event associated with the trackball.
     * @return This function returns <code>true</code> if the trackball
     * motion was processed, which notifies the caller that this method
     * handled the motion event and no other handling is necessary.
     */
    boolean doTrackballEvent(MotionEvent event) {
      boolean handled = false;

      if (mMode == stateEnum.RUNNING) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
          if (mLocalInput.playerID == VirtualInput.PLAYER1) {
            synchronized(input1Lock) {
              mLocalInput.setTrackBallDx(event.getX() * TRACKBALL_COEFFICIENT);
            }
          }
          else {
            synchronized(input2Lock) {
              mLocalInput.setTrackBallDx(event.getX() * TRACKBALL_COEFFICIENT);
            }
          }
          handled = true;
        }
      }

      return handled;
    }

    private void drawAboutScreen(Canvas canvas) {
      canvas.drawRGB(0, 0, 0);
      if (!mBlankScreen) {
        int x      = drawTextOffsetX();
        int y      = 20;
        int ysp    = 26;
        int indent = 10;
        mFont.print("original frozen bubble:", x, y, canvas,
                    mDisplayScale, mDisplayDX, mDisplayDY);
        y += ysp;
        mFont.print("guillaume cottenceau", x + indent, y, canvas,
                    mDisplayScale, mDisplayDX, mDisplayDY);
        y += ysp;
        mFont.print("alexis younes", x + indent, y, canvas,
                    mDisplayScale, mDisplayDX, mDisplayDY);
        y += ysp;
        mFont.print("amaury amblard-ladurantie", x + indent, y, canvas,
                    mDisplayScale, mDisplayDX, mDisplayDY);
        y += ysp;
        mFont.print("matthias le bidan", x + indent, y, canvas,
                    mDisplayScale, mDisplayDX, mDisplayDY);
        y += ysp;
        y += ysp;
        mFont.print("java version:", x, y, canvas,
                    mDisplayScale, mDisplayDX, mDisplayDY);
        y += ysp;
        mFont.print("glenn sanson", x + indent, y, canvas,
                    mDisplayScale, mDisplayDX, mDisplayDY);
        y += ysp;
        y += ysp;
        mFont.print("android port:", x, y, canvas,
                    mDisplayScale, mDisplayDX, mDisplayDY);
        y += ysp;
        mFont.print("aleksander fedorynski", x + indent, y, canvas,
                    mDisplayScale, mDisplayDX, mDisplayDY);
        y += ysp;
        mFont.print("eric fortin", x + indent, y, canvas,
                    mDisplayScale, mDisplayDX, mDisplayDY);
        y += 2 * ysp;
        mFont.print("android port source code", x, y, canvas,
                    mDisplayScale, mDisplayDX, mDisplayDY);
        y += ysp;
        mFont.print("is available at:", x, y, canvas,
                    mDisplayScale, mDisplayDX, mDisplayDY);
        y += ysp;
        mFont.print("http://code.google.com", x, y, canvas,
                    mDisplayScale, mDisplayDX, mDisplayDY);
        y += ysp;
        mFont.print("/p/frozenbubbleandroid", x, y, canvas,
                    mDisplayScale, mDisplayDX, mDisplayDY);
      }
    }

    private void drawBackground(Canvas c) {
      Sprite.drawImage(mBackground, 0, 0, c,
                       mDisplayScale, mDisplayDX, mDisplayDY);
      if (numPlayers > 1) {
        Sprite.drawImage(mBackButton, BACK_2P_X, BACK_2P_Y, c,
                         mDisplayScale, mDisplayDX, mDisplayDY);
      }
      else {
        Sprite.drawImage(mBackButton, BACK_1P_X, BACK_1P_Y, c,
                         mDisplayScale, mDisplayDX, mDisplayDY);
      }
    }

    private void drawDifficulty(Canvas canvas) {
      int y     = 433;
      int x     = 159;
      int level = mLevelManager.getLevelIndex();
      mFont.print(LevelManager.DifficultyStrings[level], x, y, canvas,
                  mDisplayScale, mDisplayDX, mDisplayDY);
    }

    /**
     * Draw the high score screen for puzzle game mode.
     * <p>The objective of puzzle game mode is efficiency - fire as few
     * bubbles as possible as quickly as possible.  Thus the high score
     * will exhibit the fewest shots fired the quickest.
     * @param canvas - the drawing canvas to display the scores on.
     * @param level - the level index.
     */
    private void drawHighScoreScreen(Canvas canvas, int level) {
      if (mHighScoreManager == null) {
        mShowScores = false;
        return;
      }

      canvas.drawRGB(0, 0, 0);
      int         x      = drawTextOffsetX();
      int         y      = 10;
      int         ysp    = 26;
      int         indent = 10;
      HighscoreDO myDO   = null;

      mFont.print("highscore for level " + (level + 1), x, y, canvas,
                  mDisplayScale, mDisplayDX, mDisplayDY);
      y += 1.5f * ysp;

      List<HighscoreDO> hlist = mHighScoreManager.getHighScore(level, 15);
      long lastScoreId = mHighScoreManager.getLastScoreId();
      int  i           = 1;

      for (HighscoreDO hdo : hlist) {
        String you = "";
        if (lastScoreId == hdo.getId()) {
          myDO = hdo;
          you  = "|";
        }
        // TODO: Add player name support.
        // mFont.print(you + i++ + " - " + hdo.getName().toLowerCase()
        // + " - "
        // + hdo.getShots()
        // + " - " + (hdo.getTime() / 1000)
        // + " sec", x + indent,
        // y, canvas,
        // mDisplayScale, mDisplayDX, mDisplayDY);
        mFont.print(you + i++ + " - "
          + hdo.getShots()
          + " shots - "
          + (hdo.getTime() / 1000)
          + " sec", x + indent,
          y, canvas,
          mDisplayScale, mDisplayDX, mDisplayDY);
        y += ysp;
      }

      if (myDO == null) {
        myDO = mHighScoreManager.getLastScoreDO();
        if (myDO != null) {
          mFont.print("|" + "  - "
              + myDO.getShots()
              + " shots - "
              + (myDO.getTime() / 1000)
              + " sec", x + indent,
              y, canvas,
              mDisplayScale, mDisplayDX, mDisplayDY);
        }
      }
    }

    private void drawLevelNumber(Canvas canvas) {
      int y = 433;
      int x;
      int level = mLevelManager.getLevelIndex() + 1;
      if (level < 10) {
        x = 185;
        mFont.paintChar(Character.forDigit(level, 10), x, y, canvas,
                        mDisplayScale, mDisplayDX, mDisplayDY);
      }
      else if (level < 100) {
        x = 178;
        x += mFont.paintChar(Character.forDigit(level / 10, 10), x, y, canvas,
                             mDisplayScale, mDisplayDX, mDisplayDY);
        mFont.paintChar(Character.forDigit(level % 10, 10), x, y, canvas,
                        mDisplayScale, mDisplayDX, mDisplayDY);
      }
      else {
        x = 173;
        x += mFont.paintChar(Character.forDigit(level / 100, 10), x, y, canvas,
                             mDisplayScale, mDisplayDX, mDisplayDY);
        level -= 100 * (level / 100);
        x += mFont.paintChar(Character.forDigit(level / 10, 10), x, y, canvas,
                             mDisplayScale, mDisplayDX, mDisplayDY);
        mFont.paintChar(Character.forDigit(level % 10, 10), x, y, canvas,
                        mDisplayScale, mDisplayDX, mDisplayDY);
      }
    }

    /**
     * Draw the low score screen for arcade and multiplayer game modes.
     * <p>The objective of arcade and multiplayer games is endurance -
     * fire as many bubbles as possible for as long as possible.  Thus
     * the low score will exhibit the most shots fired during the
     * longest game.
     * @param canvas - the drawing canvas to display the scores on.
     * @param level - the level difficulty index.
     */
    private void drawLowScoreScreen(Canvas canvas, int level) {
      if (mHighScoreManager == null) {
        mShowScores = false;
        return;
      }

      canvas.drawRGB(0, 0, 0);
      int         x      = drawTextOffsetX();
      int         y      = 10;
      int         ysp    = 26;
      int         indent = 10;
      HighscoreDO myDO   = null;

      mFont.print("highscore for " +
                  LevelManager.DifficultyStrings[mHighScoreManager.getLevel()],
                  x, y, canvas, mDisplayScale, mDisplayDX, mDisplayDY);
      y += 1.5f * ysp;

      List<HighscoreDO> hlist = mHighScoreManager.getLowScore(level, 15);
      long lastScoreId = mHighScoreManager.getLastScoreId();
      int  i           = 1;

      for (HighscoreDO hdo : hlist) {
        String you = "";
        if (lastScoreId == hdo.getId()) {
          myDO = hdo;
          you  = "|";
        }
        // TODO: Add player name support.
        // mFont.print(you + i++ + " - " + hdo.getName().toLowerCase()
        // + " - "
        // + hdo.getShots()
        // + " - " + (hdo.getTime() / 1000)
        // + " sec", x + indent,
        // y, canvas,
        // mDisplayScale, mDisplayDX, mDisplayDY);
        mFont.print(you + i++ + " - "
          + hdo.getShots()
          + " shots - "
          + (hdo.getTime() / 1000)
          + " sec", x + indent,
          y, canvas,
          mDisplayScale, mDisplayDX, mDisplayDY);
        y += ysp;
      }

      if (myDO == null) {
        myDO = mHighScoreManager.getLastScoreDO();
        if (myDO != null) {
          mFont.print("|" + "  - "
              + myDO.getShots()
              + " shots - "
              + (myDO.getTime() / 1000)
              + " sec", x + indent,
              y, canvas,
              mDisplayScale, mDisplayDX, mDisplayDY);
        }
      }
    }

    private void drawNetworkScreen(Canvas canvas) {
      if (mNetworkManager == null) {
        mShowNetwork = false;
        return;
      }

      canvas.drawRGB(0, 0, 0);
      int x   = drawTextOffsetX();
      int y   = 20;
      int ysp = 26;

      NetworkStatus status = new NetworkStatus();
      mNetworkManager.updateNetworkStatus(status);

      if (gameLocale == FrozenBubble.LOCALE_WIFI) {
        if (status.isConnected) {
          mFont.print("wifi status: ]", x, y, canvas,
                      mDisplayScale, mDisplayDX, mDisplayDY);
          y += ysp;
        }
        else {
          mFont.print("wifi status: _", x, y, canvas,
                      mDisplayScale, mDisplayDX, mDisplayDY);
          y += ysp;
        }
      }
      else if (gameLocale == FrozenBubble.LOCALE_BLUETOOTH) {
        if (status.isConnected) {
          mFont.print("bluetooth status: ]", x, y, canvas,
                      mDisplayScale, mDisplayDX, mDisplayDY);
          y += ysp;
        }
        else {
          mFont.print("bluetooth status: _", x, y, canvas,
                      mDisplayScale, mDisplayDX, mDisplayDY);
          y += ysp;
        }
      }

      mFont.print("my address: " + status.localIpAddress, x, y, canvas,
          mDisplayScale, mDisplayDX, mDisplayDY);
      y += ysp;

      mFont.print("connect to: " + status.remoteIpAddress, x, y, canvas,
          mDisplayScale, mDisplayDX, mDisplayDY);
      y += ysp;

      if (status.playerJoined) {
        mFont.print("waiting for player " + status.remotePlayerId + "...|",
                    x, y, canvas, mDisplayScale, mDisplayDX, mDisplayDY);
        y += ysp;
      }
      else {
        mFont.print("waiting for player " + status.remotePlayerId + "...",
                    x, y, canvas, mDisplayScale, mDisplayDX, mDisplayDY);
        return;
      }

      if (status.localPlayerId == VirtualInput.PLAYER2) {
        if (status.gotPrefsData || status.readyToPlay) {
          mFont.print("getting preferences...|", x, y, canvas,
                      mDisplayScale, mDisplayDX, mDisplayDY);
          y += ysp;
        }
        else {
          mFont.print("getting preferences...", x, y, canvas,
                      mDisplayScale, mDisplayDX, mDisplayDY);
          return;
        }
      }

      if (status.gotFieldData || status.readyToPlay) {
        mFont.print("getting data...|", x, y, canvas,
                    mDisplayScale, mDisplayDX, mDisplayDY);
        y += ysp;
      }
      else {
        mFont.print("getting data...", x, y, canvas,
                    mDisplayScale, mDisplayDX, mDisplayDY);
        return;
      }

      if (status.readyToPlay) {
        mFont.print("waiting for game start...|", x, y, canvas,
                    mDisplayScale, mDisplayDX, mDisplayDY);
        y += ysp;
      }
      else {
        mFont.print("waiting for game start...", x, y, canvas,
                    mDisplayScale, mDisplayDX, mDisplayDY);
        return;
      }

      mFont.print("tap to begin playing!", x, y, canvas,
                  mDisplayScale, mDisplayDX, mDisplayDY);
    }

    /**
     * Obtain the horizontal offset to approximately center a line of
     * 20 characters in the screen for the current device orientation.
     * @return The horizontal offset.
     */
    private int drawTextOffsetX() {
      int x           = (int) (GAMEFIELD_WIDTH * 0.55f);
      int orientation = getScreenOrientation();

      if (numPlayers == 2) {
        if ((orientation == ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT) ||
            (orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)) {
          if (mLocalInput.playerID == VirtualInput.PLAYER2) {
            x = (int) -((float) mDisplayDX / mDisplayScale) + 5;
          }
          else {
            x = mDisplayDX + 5;
          }
        }
      }

      return x;
    }

    private void drawWinTotals(Canvas canvas) {
      int y = 433;
      int x = GAMEFIELD_WIDTH - 40;
      int gamesWon1 = numPlayer1GamesWon;
      int gamesWon2 = numPlayer2GamesWon;

      if (numPlayer1GamesWon < 10) {
        x += 12;
        x += mFont.paintChar(Character.forDigit(gamesWon1, 10), x, y, canvas,
                             mDisplayScale, mDisplayDX, mDisplayDY);
      }
      else if (numPlayer1GamesWon < 100) {
        x += 5;
        x += mFont.paintChar(Character.forDigit(gamesWon1 / 10, 10), x, y, canvas,
                             mDisplayScale, mDisplayDX, mDisplayDY);
        x += mFont.paintChar(Character.forDigit(gamesWon1 % 10, 10), x, y, canvas,
                             mDisplayScale, mDisplayDX, mDisplayDY);
      }
      else {
        x += mFont.paintChar(Character.forDigit(gamesWon1 / 100, 10), x, y, canvas,
                             mDisplayScale, mDisplayDX, mDisplayDY);
        gamesWon1 -= 100 * (gamesWon1 / 100);
        x += mFont.paintChar(Character.forDigit(gamesWon1 / 10, 10), x, y, canvas,
                             mDisplayScale, mDisplayDX, mDisplayDY);
        x += mFont.paintChar(Character.forDigit(gamesWon1 % 10, 10), x, y, canvas,
                             mDisplayScale, mDisplayDX, mDisplayDY);
      }
      x += 7;
      x += mFont.paintChar('-', x, y, canvas,
                           mDisplayScale, mDisplayDX, mDisplayDY);
      x += 7;
      if (numPlayer2GamesWon < 10) {
        x += mFont.paintChar(Character.forDigit(gamesWon2, 10), x, y, canvas,
                             mDisplayScale, mDisplayDX, mDisplayDY);
      }
      else if (numPlayer2GamesWon < 100) {
        x += mFont.paintChar(Character.forDigit(gamesWon2 / 10, 10), x, y, canvas,
                             mDisplayScale, mDisplayDX, mDisplayDY);
        x += mFont.paintChar(Character.forDigit(gamesWon2 % 10, 10), x, y, canvas,
                             mDisplayScale, mDisplayDX, mDisplayDY);
      }
      else {
        x += mFont.paintChar(Character.forDigit(gamesWon2 / 100, 10), x, y, canvas,
                             mDisplayScale, mDisplayDX, mDisplayDY);
        gamesWon1 -= 100 * (gamesWon2 / 100);
        x += mFont.paintChar(Character.forDigit(gamesWon2 / 10, 10), x, y, canvas,
                             mDisplayScale, mDisplayDX, mDisplayDY);
        x += mFont.paintChar(Character.forDigit(gamesWon2 % 10, 10), x, y, canvas,
                             mDisplayScale, mDisplayDX, mDisplayDY);
      }
    }

    public boolean gameInProgress() {
      return !mShowNetwork;
    }

    public int getCurrentLevelIndex() {
      return mLevelManager.getLevelIndex();
    }

    private int getScreenOrientation() {
      return FrozenBubble.getScreenOrientation(((Activity) mContext).
                                               getWindowManager());
    }

    /**
     * <p>Determine if the input came from the remote player.  The
     * last attached gamepad always belongs to the remote player.
     * @param msg - the <code>KeyEvent</code> from which to obtain the
     * input device ID.
     * @return <code>true</code> if this input came from the remote
     * player.
     */
    private boolean isRemoteInput(int deviceId) {
      boolean remoteInputFound = false;
      /*
       * If this is a local 2 player game, check if this input came from
       * a connected gamepad for the remote player.
       *
       * Local 2 player games can only be played by having one or more
       * attached gamepads.
       *
       * NOTE: The InputDevice SOURCE_GAMEPAD input type was added in
       * API 12.  It is a derivative of the input source class
       * SOURCE_CLASS_BUTTON.
       */
      if ((numPlayers == 2) &&
          (gameLocale == FrozenBubble.LOCALE_LOCAL) &&
          !mRemoteInput.isCPU) {
        int[] deviceIds     = InputDevice.getDeviceIds();
        int   lastGamepadId = 0;
        int   numGamepads   = 0;
        for (int id : deviceIds) {
          InputDevice device = InputDevice.getDevice(id);
          if (((device.getSources() & InputDevice.SOURCE_GAMEPAD) ==
              InputDevice.SOURCE_GAMEPAD) ||
              ((device.getSources() & InputDevice.SOURCE_JOYSTICK) ==
              InputDevice.SOURCE_JOYSTICK)) {
            lastGamepadId = device.getId();
            numGamepads++;
          }
        }

        if ((numGamepads > 0) && (deviceId == lastGamepadId)) {
          remoteInputFound = true;
        }
      }

      return remoteInputFound;
    }

    private BmpWrap NewBmpWrap() {
      int new_img_id = mImageList.size();
      BmpWrap new_img = new BmpWrap(new_img_id);
      mImageList.addElement(new_img);
      return new_img;
    }

    /**
     * Start a new game.
     * @param firstLevel if <code>true</code>, start a new game in
     * puzzle mode beginning at the first level. 
     */
    public void newGame(boolean firstLevel) {
      game1Status  = gameEnum.PLAYING;
      levelStarted = true;

      synchronized(mSurfaceHolder) {
        if (numPlayers > 1) {
          malusBar1 = new MalusBar(GameView.GAMEFIELD_WIDTH - 164, 40,
                                   mBanana, mTomato);
          malusBar2 = new MalusBar(GameView.GAMEFIELD_WIDTH + 134, 40,
                                   mBanana, mTomato);
        }
        else {
          malusBar1 = null;
          malusBar2 = null;
          if (!FrozenBubble.arcadeGame && firstLevel && (numPlayers == 1)) {
            mLevelManager.goToFirstLevel();
          }
        }

        mImagesReady = false;
        mPlayer1.setGameRef(null);
        mFrozenGame1 = new FrozenGame(mBubbles, mBubblesBlind,
                                      mFrozenBubbles, mTargetedBubbles,
                                      mBubbleBlink, mGameWon, mGameLost,
                                      mGamePaused, mHurry,
                                      mPauseButton, mPlayButton, mPenguins,
                                      mCompressorHead, mCompressor,
                                      malusBar2, mLauncher,
                                      mSoundManager, mLevelManager,
                                      mHighScoreManager, mNetworkManager,
                                      mPlayer1);
        mPlayer1.setGameRef(mFrozenGame1);

        if (numPlayers > 1) {
          mPlayer2.setGameRef(null);
          mFrozenGame2 = new FrozenGame(mBubbles, mBubblesBlind,
                                        mFrozenBubbles, mTargetedBubbles,
                                        mBubbleBlink, mGameWon, mGameLost,
                                        mGamePaused, mHurry,
                                        null, null, mPenguins2,
                                        mCompressorHead, mCompressor,
                                        malusBar1, mLauncher,
                                        mSoundManager, mLevelManager,
                                        null, mNetworkManager,
                                        mPlayer2);
          mPlayer2.setGameRef(mFrozenGame2);

          if (mNetworkManager != null) {
            mNetworkManager.newGame();
            mShowNetwork = true;
          }
        }

        mImagesReady = true;
      }

      if (mHighScoreManager != null) {
        mHighScoreManager.startLevel(mLevelManager.getLevelIndex());
      }

      startOpponent();
    }

    private void nextLevel() {
      mLevelManager.goToNextLevel();
      newGame(false);
    }

    public void pause() {
      synchronized(mSurfaceHolder) {
        if (mMode == stateEnum.RUNNING) {
          setState(stateEnum.PAUSED);

          if (mGameListener != null)
            mGameListener.onGameEvent(eventEnum.GAME_PAUSED);
          if (mFrozenGame1 != null)
            mFrozenGame1.pause();
          if (mFrozenGame2 != null)
            mFrozenGame2.pause();
          if (mHighScoreManager != null)
            mHighScoreManager.pauseLevel();
        }
      }
    }

    public void pauseButtonPressed(boolean pauseKeyPressed) {
      if (mFrozenGame1 != null) {
        mFrozenGame1.pauseButtonPressed(pauseKeyPressed);
      }
    }

    private void resizeBitmaps() {
      //Log.i("frozen-bubble", "resizeBitmaps()");
      scaleFrom(mBackButton, mBackButtonOrig);
      scaleFrom(mBackground, mBackgroundOrig);
      for (int i = 0; i < mBubblesOrig.length; i++) {
        scaleFrom(mBubbles[i], mBubblesOrig[i]);
      }
      for (int i = 0; i < mBubblesBlind.length; i++) {
        scaleFrom(mBubblesBlind[i], mBubblesBlindOrig[i]);
      }
      for (int i = 0; i < mFrozenBubbles.length; i++) {
        scaleFrom(mFrozenBubbles[i], mFrozenBubblesOrig[i]);
      }
      for (int i = 0; i < mTargetedBubbles.length; i++) {
        scaleFrom(mTargetedBubbles[i], mTargetedBubblesOrig[i]);
      }
      scaleFrom(mBubbleBlink, mBubbleBlinkOrig);
      scaleFrom(mGameWon, mGameWonOrig);
      scaleFrom(mGameLost, mGameLostOrig);
      scaleFrom(mGamePaused, mGamePausedOrig);
      scaleFrom(mHurry, mHurryOrig);
      if ((mPauseButton != null) && (mPauseButtonOrig != null)) {
        scaleFrom(mPauseButton, mPauseButtonOrig);
      }
      if ((mPlayButton != null) && (mPlayButtonOrig != null)) {
        scaleFrom(mPlayButton, mPlayButtonOrig);
      }
      scaleFrom(mPenguins, mPenguinsOrig);
      if ((mPenguins2 != null) && (mPenguins2Orig != null)) {
        scaleFrom(mPenguins2, mPenguins2Orig);
      }
      scaleFrom(mCompressorHead, mCompressorHeadOrig);
      scaleFrom(mCompressor, mCompressorOrig);
      scaleFrom(mLife, mLifeOrig);
      scaleFrom(mFontImage, mFontImageOrig);
      if ((mBanana != null) && (mBananaOrig != null)) {
        scaleFrom(mBanana, mBananaOrig);
      }
      if ((mTomato != null) && (mTomatoOrig != null)) {
        scaleFrom(mTomato, mTomatoOrig);
      }
      //Log.i("frozen-bubble", "resizeBitmaps done.");
      mImagesReady = true;
    }

    /**
     * Restores game state from the indicated Bundle. Typically called
     * when the Activity is being restored after having been previously
     * destroyed.
     * @param savedState - Bundle containing the game state.
     */
    public void restoreState(Bundle map) {
      if (map != null) {
        synchronized(mSurfaceHolder) {
          setState(stateEnum.PAUSED);
          if (mFrozenGame1 != null) {
            mFrozenGame1.restoreState(map, mImageList);
          }
          if (numPlayers > 1) {
            numPlayer1GamesWon = map.getInt("numPlayer1GamesWon", 0);
            numPlayer2GamesWon = map.getInt("numPlayer2GamesWon", 0);
            if (mFrozenGame2 != null) {
              mFrozenGame2.restoreState(map, mImageList);
              startOpponent();
            }
          }
          if (mLevelManager != null) {
            mLevelManager.restoreState(map);
          }
          if (mHighScoreManager != null) {
            mHighScoreManager.restoreState(map);
          }
        }
      }
    }

    public void resumeGame() {
      synchronized(mSurfaceHolder) {
        if (mMode == stateEnum.RUNNING) {
          if (mFrozenGame1 != null) {
            mFrozenGame1.resume();
          }
          if ((numPlayers > 1) && (mFrozenGame2 != null)) {
            mFrozenGame2.resume();
          }
          if (mHighScoreManager != null) {
            mHighScoreManager.resumeLevel();
          }
        }
      }
    }

    @Override
    public void run() {
      while (mRun) {
        long now = System.currentTimeMillis();
        long delay = FRAME_DELAY + mLastTime - now;
        if (delay > 0) try {
          sleep(delay);
        } catch (InterruptedException e) {}
        mLastTime = now;
        Canvas c = null;
        try {
          if (surfaceOK()) {
            c = mSurfaceHolder.lockCanvas(null);
            if (c != null) {
              synchronized(mSurfaceHolder) {
                if (mRun) {
                  monitorRemotePlayer();
                  if (mMode == stateEnum.ABOUT) {
                    drawAboutScreen(c);
                  }
                  else if (mMode == stateEnum.PAUSED) {
                    if (mNetworkManager != null) {
                      if (mShowNetwork) {
                        drawNetworkScreen(c);
                      }
                      else {
                        doDraw(c);
                      }
                    }
                    else if ((mHighScoreManager != null) && mShowScores) {
                      if (FrozenBubble.arcadeGame || (numPlayers > 1)) {
                        drawLowScoreScreen(c, mHighScoreManager.getLevel());
                      }
                      else {
                        drawHighScoreScreen(c, mHighScoreManager.getLevel());
                      }
                    }
                    else {
                      doDraw(c);
                    }
                  }
                  else {
                    if (mMode == stateEnum.RUNNING) {
                      if (mModeWas != stateEnum.RUNNING) {
                        if (mGameListener != null) {
                          mGameListener.onGameEvent(eventEnum.GAME_RESUME);
                        }
                        mModeWas = stateEnum.RUNNING;
                        resumeGame();
                      }
                      updateGameState();
                    }
                    doDraw(c);
                  }
                }
              }
            }
          }
        } finally {
          /*
           * Do this in a finally so that if an exception is thrown
           * during the above, we don't leave the Surface in an
           * inconsistent state.
           */
          if (c != null) {
            try {
              mSurfaceHolder.unlockCanvasAndPost(c);
            } catch (IllegalStateException ise) {
              /*
               * Surface has already been released.
               */
            }
          }
        }
      }
    }

    /**
     * Dump game state to the provided Bundle. Typically called when the
     * Activity is being suspended.
     * @return Bundle with this view's state
     */
    public Bundle saveState(Bundle map) {
      synchronized(mSurfaceHolder) {
        if (map != null) {
          if (mFrozenGame1 != null) {
            mFrozenGame1.saveState(map);
          }
          if (numPlayers > 1) {
            map.putInt("numPlayers", 2);
            map.putInt("numPlayer1GamesWon", numPlayer1GamesWon);
            map.putInt("numPlayer2GamesWon", numPlayer2GamesWon);
            if (mFrozenGame2 != null) {
              mFrozenGame2.saveState(map);
            }
          }
          else {
            map.putInt("numPlayers", 1);
          }
          if (mLevelManager != null) {
            mLevelManager.saveState(map);
          }
          if (mHighScoreManager != null) {
            mHighScoreManager.saveState(map);
          }
        }
      }
      return map;
    }

    private void scaleFrom(BmpWrap image, Bitmap bmp) {
      if ((image.bmp != null) && (image.bmp != bmp)) {
        image.bmp.recycle();
      }

      if ((mDisplayScale > 0.99999) && (mDisplayScale < 1.00001)) {
        image.bmp = bmp;
        return;
      }

      int dstWidth  = (int)(bmp.getWidth()  * mDisplayScale);
      int dstHeight = (int)(bmp.getHeight() * mDisplayScale);
      image.bmp = Bitmap.createScaledBitmap(bmp, dstWidth, dstHeight, true);
    }

    /**
     * Set the player action for a remote player - as in a person playing
     * via a client device over a network.
     * @param newAction - the object containing the remote input info.
     */
    public void setPlayerAction(PlayerAction newAction) {
      VirtualInput playerRef;
      FrozenGame   gameRef;

      if (newAction.playerID == VirtualInput.PLAYER1) {
        playerRef = mPlayer1;
      }
      else if (newAction.playerID == VirtualInput.PLAYER2) {
        playerRef = mPlayer2;
      }
      else {
        return;
      }

      if (playerRef.mGameRef != null) {
        gameRef = playerRef.mGameRef;
      }
      else {
        return;
      }

      if (mGameThread != null)
        mGameThread.updateStateOnEvent(null);

      synchronized(mSurfaceHolder) {
        /*
         * Set the launcher bubble colors.
         */
        if ((newAction.launchBubbleColor  > -1) &&
            (newAction.launchBubbleColor  <  8) &&
            (newAction.nextBubbleColor    > -1) &&
            (newAction.nextBubbleColor    <  8) &&
            (newAction.newNextBubbleColor > -1) &&
            (newAction.newNextBubbleColor <  8)) {
          gameRef.setLaunchBubbleColors(newAction.launchBubbleColor,
                                        newAction.nextBubbleColor,
                                        newAction.newNextBubbleColor);
        }

        /*
         * Set the launcher aim position.
         */
        gameRef.setPosition(newAction.aimPosition);

        /*
         * Process a compressor lower request.
         */
        if (newAction.compress) {
          gameRef.lowerCompressor(true);
        }

        /*
         * Process a bubble launch request.
         */
        if (newAction.launchBubble) {
          playerRef.setAction(KeyEvent.KEYCODE_DPAD_UP, true);
        }

        /*
         * Process a bubble swap request.
         */
        if (newAction.swapBubble) {
          playerRef.setAction(KeyEvent.KEYCODE_DPAD_DOWN, false);
        }

        /*
         * Process a pause/play button toggle request.
         */
        if (newAction.keyCode == (byte) KeyEvent.KEYCODE_P) {
          if (mGameThread != null) {
            mGameThread.toggleKeyPress(KeyEvent.KEYCODE_P, true, false);
          }
        }

        /*
         * Set the current value of the attack bar.
         */
        if (newAction.attackBarBubbles > -1) {
          gameRef.malusBar.setAttackBubbles(newAction.attackBarBubbles,
                                            newAction.attackBubbles);
        }
      }
    }

    public void setPosition(double value) {
      if (mLocalInput.mGameRef != null) {
        mLocalInput.mGameRef.setPosition(value);
      }
    }

    public void setRunning(boolean b) {
      mRun = b;
    }

    public void setState(stateEnum newMode) {
      synchronized(mSurfaceHolder) {
        /*
         * Only update the previous mode storage if the new mode is
         * different from the current mode, in case the same mode is
         * being set multiple times.
         *
         * The transition from state to state must be preserved in case
         * a separate execution thread that checks for state transitions
         * does not get a chance to run between calls to this method.
         */
        if (newMode != mMode)
          mModeWas = mMode;

        mMode = newMode;
      }
    }

    public void setSurfaceOK(boolean ok) {
      synchronized(mSurfaceHolder) {
        mSurfaceOK = ok;
      }
    }

    public void setSurfaceSize(int width, int height) {
      float newHeight    = height;
      float newWidth     = width;
      float gameHeight   = GAMEFIELD_HEIGHT;
      float gameWidth    = GAMEFIELD_WIDTH;
      float extGameWidth = EXTENDED_GAMEFIELD_WIDTH;
      synchronized(mSurfaceHolder) {
        if ((newWidth / newHeight) >= (gameWidth / gameHeight)) {
          mDisplayScale = (1.0 * newHeight) / gameHeight;
          mDisplayDX    = (int)((newWidth - (mDisplayScale * extGameWidth)) / 2);
          mDisplayDY    = 0;
        }
        else {
          mDisplayScale = (1.0 * newWidth) / gameWidth;
          mDisplayDX    = (int)(mDisplayScale * (gameWidth - extGameWidth) / 2);
          mDisplayDY    = (int)((newHeight - (mDisplayScale * gameHeight)) / 2);
        }
        if (numPlayers > 1) {
          /*
           * In portrait mode during a multiplayer game, display just
           * one game field.  Depending on which player is the local
           * player, display the game field for just that player. This
           * is useful for devices with small screens.
           */
          int orientation = getScreenOrientation();
          if ((orientation == ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT) ||
              (orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)) {
            if (mLocalInput.playerID == VirtualInput.PLAYER2) {
              mDisplayDX = (int)(-mDisplayScale * gameWidth);
            }
            else {
              mDisplayDX = 0;
            }
          }
        }
        if (numPlayers > 1) {
          mPlayer1DX = (int)(mDisplayDX - (mDisplayScale * (gameWidth / 2)));
        }
        else {
          mPlayer1DX = mDisplayDX;
        }
        mPlayer2DX = (int)(mDisplayDX + (mDisplayScale * (gameWidth / 2)));
        resizeBitmaps();
      }
    }

    /**
     * Create a CPU opponent object (if necessary) and start the thread.
     */
    private void startOpponent() {
      if (mOpponent != null) {
        mOpponent.stopThread();
        mOpponent = null;
      }
      if ((numPlayers > 1) && mRemoteInput.isCPU) {
        if (mRemoteInput.playerID == VirtualInput.PLAYER2)
          mOpponent = new ComputerAI(mFrozenGame2, mRemoteInput);
        else
          mOpponent = new ComputerAI(mFrozenGame1, mRemoteInput);
        mOpponent.start();
      }
    }

    public boolean surfaceOK() {
      synchronized(mSurfaceHolder) {
        return mSurfaceOK;
      }
    }

    /**
     * Process function key presses.  Function keys toggle features on
     * and off (e.g., game paused on/off, sound on/off, etc.).
     * @param keyCode - the key code to process.
     * @param updateNow - if true, apply state changes.
     * @param transmit - if true and this is a network game, send the
     * key code over the network.
     */
    public void toggleKeyPress(int keyCode,
                               boolean updateNow,
                               boolean transmit) {
      if (keyCode == KeyEvent.KEYCODE_M)
        muteKeyToggle = !muteKeyToggle;
      else if (keyCode == KeyEvent.KEYCODE_P) {
        if (transmit && (mNetworkManager != null)) {
          mNetworkManager.sendLocalPlayerAction(mLocalInput.playerID,
              false, false, false, keyCode, -1, -1, -1, -1, null,
              mLocalInput.mGameRef.launchBubblePosition);
        }
        pauseKeyToggle = !pauseKeyToggle;
        mGameThread.pauseButtonPressed(pauseKeyToggle);
        if (updateNow) {
          updateStateOnEvent(null);
          /*
           * If the game is running and the pause button was pressed,
           * pause the game.
           */
          if (pauseKeyToggle && (mMode == stateEnum.RUNNING)) {
            pause();
          }
        }
      }
    }

    /**
     * Obtain the current state of a feature toggle key.
     * @param keyCode
     * @return The state of the desired feature toggle key flag.
     */
    public boolean toggleKeyState(int keyCode) {
      if (keyCode == KeyEvent.KEYCODE_M) {
        return muteKeyToggle;
      }
      else if (keyCode == KeyEvent.KEYCODE_P) {
        return pauseKeyToggle;
      }

      return false;
    }

    /**
     * updateStateOnEvent() - a common method to process motion events
     * to set the game state.  When the motion event has been fully
     * processed, this function will return true, otherwise if the
     * calling method should also process the motion event, this
     * function will return false.
     * @param event - the MotionEvent to process for the purpose of
     * updating the game state.  If this parameter is null, then the
     * game state is forced to update if applicable based on the current
     * game state.
     * @return This function returns <code>true</code> to inform the
     * calling function that the game state has been updated and that no
     * further processing is necessary, and <code>false</code> to
     * indicate that the caller should continue processing the motion
     * event.
     */
    private boolean updateStateOnEvent(MotionEvent event) {
      boolean event_action_down = false;

      if (event == null)
        event_action_down = true;
      else if (event.getAction() == MotionEvent.ACTION_DOWN)
        event_action_down = true;

      if (event_action_down) {
        switch (mMode) {
          case ABOUT:
            levelStarted = true;
            if (numPlayers > 1) {
              setState(stateEnum.RUNNING);
              return true;
            }
            else {
              if (!mBlankScreen) {
                setState(stateEnum.RUNNING);
                return true;
              }
            }
            break;

          case PAUSED:
            levelStarted = true;
            if (mNetworkManager != null) {
              if (mShowNetwork) {
                if (mNetworkManager.gameIsReadyForAction()) {
                  mShowNetwork = false;
                  setState(stateEnum.RUNNING);
                  if (mGameListener != null) {
                    mGameListener.onGameEvent(eventEnum.GAME_START);
                  }
                }
                return true;
              }
            }
            else if (mShowScores) {
              mShowScores = false;
              if (numPlayers > 1) {
                setState(stateEnum.RUNNING);
              }
              else {
                if (game1Status == gameEnum.WON) {
                  nextLevel();
                }
                if (getCurrentLevelIndex() != 0) {
                  setState(stateEnum.RUNNING);
                }
              }
              if (mGameListener != null) {
                mGameListener.onGameEvent(eventEnum.GAME_START);
              }
              return true;
            }
            setState(stateEnum.RUNNING);
            break;

          case RUNNING:
            levelStarted = false;
          default:
            break;
        }
      }
      return false;
    }

    private void updateGameState() {
      if ((mFrozenGame1 == null) ||
          ((numPlayers > 1) &&
           ((mFrozenGame2 == null) ||
            ((mOpponent == null) && mRemoteInput.isCPU)))) {
        return;
      }

      boolean actionLeft;
      boolean actionRight;
      boolean actionUp;
      boolean actionDown;
      boolean actionTouchFire;
      boolean actionToucheFireATS;
      double  trackBallDx;
      double  touchX;
      double  touchY;
      double  touchDxATS;

      synchronized(input1Lock) {
        actionLeft          = mPlayer1.actionLeft();
        actionRight         = mPlayer1.actionRight();
        actionUp            = mPlayer1.actionUp();
        actionDown          = mPlayer1.actionDown();
        actionTouchFire     = mPlayer1.actionTouchFire();
        actionToucheFireATS = mPlayer1.actionTouchFireATS();
        trackBallDx         = mPlayer1.getTrackBallDx();
        touchX              = mPlayer1.getTouchX();
        touchY              = mPlayer1.getTouchY();
        touchDxATS          = mPlayer1.getTouchDxATS();
      }

      gameEnum game1State = mFrozenGame1.play(actionLeft,
                                              actionRight,
                                              actionUp,
                                              actionDown,
                                              trackBallDx,
                                              actionTouchFire,
                                              touchX,
                                              touchY,
                                              actionToucheFireATS,
                                              touchDxATS);

      if (numPlayers > 1) {
        synchronized(input2Lock) {
          actionLeft          = mPlayer2.actionLeft();
          actionRight         = mPlayer2.actionRight();
          actionUp            = mPlayer2.actionUp();
          actionDown          = mPlayer2.actionDown();
          actionTouchFire     = mPlayer2.actionTouchFire();
          actionToucheFireATS = mPlayer2.actionTouchFireATS();
          trackBallDx         = mPlayer2.getTrackBallDx();
          touchX              = mPlayer2.getTouchX();
          touchY              = mPlayer2.getTouchY();
          touchDxATS          = mPlayer2.getTouchDxATS();
        }

        gameEnum game2State = mFrozenGame2.play(actionLeft,
                                                actionRight,
                                                actionUp,
                                                actionDown,
                                                trackBallDx,
                                                actionTouchFire,
                                                touchX,
                                                touchY,
                                                actionToucheFireATS,
                                                touchDxATS);

        /*
         * If playing a network game, update the bubble grid checksums.
         */
        if (mNetworkManager != null) {
          mNetworkManager.setLocalChecksum(mLocalInput.mGameRef.gridChecksum);
          mNetworkManager.setRemoteChecksum(mRemoteInput.mGameRef.gridChecksum);
        }

        /*
         * If playing a CPU opponent, notify the computer that the current
         * action has been processed and we are ready for a new action.
         */
        if (mOpponent != null) {
          mOpponent.clearAction();
        }

        /*
         * Obtain the number of attack bubbles to add to each player's
         * attack bar that are being sent by their respective opponents.
         */
        malusBar1.addBubbles(mFrozenGame1.getSendToOpponent());
        malusBar2.addBubbles(mFrozenGame2.getSendToOpponent());

        /*
         * Use the immediate game play result to determine when a player
         * wins or loses during a multiplayer game, as the other player
         * will automatically lose or win, respectively.
         */
        gameEnum game1Result = mFrozenGame1.getGameResult();
        gameEnum game2Result = mFrozenGame2.getGameResult();

        if (game1Result != gameEnum.PLAYING) {
          if (mNetworkManager != null) {
            mNetworkManager.setGameIsFinished();
          }
          if ((game1Result == gameEnum.WON) ||
              (game1Result == gameEnum.NEXT_WON)) {
            mFrozenGame2.setGameResult(gameEnum.LOST);
          }
          else {
            mFrozenGame2.setGameResult(gameEnum.WON);
          }
        }
        else if (game2Result != gameEnum.PLAYING) {
          if (mNetworkManager != null) {
            mNetworkManager.setGameIsFinished();
          }
          if ((game2Result == gameEnum.WON) ||
              (game2Result == gameEnum.NEXT_WON)) {
            if (mHighScoreManager != null) {
              mHighScoreManager.lostLevel();
            }
            mFrozenGame1.setGameResult(gameEnum.LOST);
          }
          else {
            if (mHighScoreManager != null) {
              mHighScoreManager.endLevel(mFrozenGame1.nbBubbles);
            }
            mFrozenGame1.setGameResult(gameEnum.WON);
          }
        }

        /*
         * When playing a network game, only start a new game when the
         * current game is finished, which is indicated when both
         * players have either won or lost.
         *
         * If the opponent in a multiplayer game is the CPU, only start
         * a new game when player 1 provides input, because otherwise
         * the CPU is prone to sneaking a launch attempt in after the
         * game has already been decided.
         *
         * Otherwise, the first player to provide input initiates the
         * new game.
         */
        boolean gameFinished = false;
        if (mNetworkManager != null) {
          gameFinished = mNetworkManager.getGameIsFinished();
        }

        if (((mNetworkManager == null) || gameFinished) &&
            (((game1State == gameEnum.NEXT_LOST) ||
              (game1State == gameEnum.NEXT_WON)) ||
             (!mRemoteInput.isCPU &&
              ((game2State == gameEnum.NEXT_LOST) ||
               (game2State == gameEnum.NEXT_WON))))) {
          if ((game1State == gameEnum.NEXT_WON) ||
              (game2State == gameEnum.NEXT_LOST)) {
            numPlayer1GamesWon++;
          }
          else {
            numPlayer2GamesWon++;
          }

          if (mNetworkManager == null) {
            mShowScores = true;
          }

          pause();
          nextLevel();
        }
      }
      else if ((game1State == gameEnum.NEXT_LOST) ||
               (game1State == gameEnum.NEXT_WON )) {
        if (FrozenBubble.arcadeGame) {
          game1Status = gameEnum.WON;
          mShowScores = true;
          pause();
        }
        else if (game1State == gameEnum.NEXT_WON) {
          game1Status = gameEnum.WON;
          mShowScores = true;
          pause();
        }
        else {
          game1Status = gameEnum.LOST;
          newGame(false);
        }
      }

      if (mGameListener != null) {
        if (game1State == gameEnum.NEXT_WON) {
          mGameListener.onGameEvent(eventEnum.GAME_WON);
        }
        else if (game1State == gameEnum.NEXT_LOST){
          mGameListener.onGameEvent(eventEnum.GAME_LOST);
        }
      }
    }

    /**
     * Use the player 1 horizontal screen offset to adjust the
     * playfield horizontal touch position.
     * @param x - the raw horizontal touch coordinate.
     * @return The adjusted horizontal touch position.
     */
    private double xFromScr(float x) {
      return (x - mPlayer1DX) / mDisplayScale;
    }

    private double yFromScr(float y) {
      return (y - mDisplayDY) / mDisplayScale;
    }
  }

  /**
   * <code>GameView</code> class constructor.
   * @param context - the application context.
   * @param attrs - the compiled XML attributes for the superclass.
   */
  public GameView(Context context, AttributeSet attrs) {
    super(context, attrs);
    //Log.i("frozen-bubble", "GameView constructor");
    init(context, 1, (int) VirtualInput.PLAYER1, FrozenBubble.HUMAN,
         FrozenBubble.LOCALE_LOCAL, FrozenBubble.arcadeGame, null, 0);
  }

  /**
   * <code>GameView</code> class constructor.
   * @param context - the application context.
   * @param levels - the single player game levels (can be null).
   * @param startingLevel - the single player game starting level.
   */
  public GameView(Context context, byte[] levels, int startingLevel) {
    super(context);
    //Log.i("frozen-bubble", "GameView constructor");
    init(context, 1, (int) VirtualInput.PLAYER1, FrozenBubble.HUMAN,
         FrozenBubble.LOCALE_LOCAL, FrozenBubble.arcadeGame, levels,
         startingLevel);
  }

  /**
   * <code>GameView</code> class constructor.
   * @param context - the application context.
   * @param numPlayers - the number of players (1 or 2).
   * @param myPlayerId - the local player ID (1 or 2).
   * @param opponentId - the opponent type ID, human or CPU.
   * @param gameLocale - the game topology, which can be either local,
   * or distributed over various network types.
   * @param arcadeGame - arcade game mode flag.
   */
  public GameView(Context context,
                  int numPlayers,
                  int myPlayerId,
                  int opponentId,
                  int gameLocale,
                  boolean arcadeGame) {
    super(context);
    //Log.i("frozen-bubble", "GameView constructor");
    init(context, numPlayers, myPlayerId, opponentId, gameLocale, arcadeGame, null, 0);
  }

  private boolean checkImmediateAction() {
    boolean actNow = false;
    /*
     * Preview the current action if one is available to see if it
     * contains an asynchronous action (e.g., launch bubble swap).
     */
    PlayerAction previewAction = mNetworkManager.getRemoteActionPreview();

    if (previewAction != null) {
      actNow = previewAction.compress || previewAction.swapBubble;
    }

    return actNow;
  }

  public void cleanUp() {
    //Log.i("frozen-bubble", "GameView.cleanUp()");
    cleanUpNetworkManager();

    mPlayer1.init();
    mPlayer2.init();

    if (mOpponent != null)
      mOpponent.stopThread();
    mOpponent = null;

    mGameThread.cleanUp();
  }

  private void cleanUpNetworkManager() {
    if (mNetworkManager != null)
      mNetworkManager.cleanUp();
    mNetworkManager = null;
  }

  /**
   * Display a blank screen (black background) for the specified wait
   * interval.
   * @param clearScreen - If <code>true</code>, show a blank screen for
   * the specified wait interval.  If <code>false</code>, show the
   * normal screen.
   * @param wait - The amount of time to display the blank screen.
   */
  public void clearGameScreen(boolean clearScreen, int wait) {
    mBlankScreen = clearScreen;
    try {
      if (clearScreen) {
        mGameThread.setState(stateEnum.ABOUT);
        Timer timer = new Timer();
        timer.schedule(new ResumeGameScreenTask(), wait, wait + 1);
      }
    } catch (IllegalArgumentException illArgEx) {
      illArgEx.printStackTrace();
      mBlankScreen = false;
    } catch (IllegalStateException illStateEx) {
      illStateEx.printStackTrace();
      mBlankScreen = false;
    }
  }

  /**
   * <code>GameView</code> object initialization.
   * @param context - the application context.
   * @param numPlayers - the number of players (1 or 2).
   * @param myPlayerId - the local player ID (1 or 2).
   * @param opponentId - the opponent type ID, human or CPU.
   * @param gameLocale - the game topology, which can be either local,
   * or distributed over various network types.
   * @param arcadeGame - arcade game mode flag.
   * @param levels - the single player game levels (can be null).
   * @param startingLevel - the single player game starting level.
   */
  private void init(Context context,
                    int numPlayers,
                    int myPlayerId,
                    int opponentId,
                    int gameLocale,
                    boolean arcadeGame,
                    byte[] levels,
                    int startingLevel) {
    mContext = context;
    this.gameLocale = gameLocale;
    this.numPlayers = numPlayers;
    SurfaceHolder holder = getHolder();
    holder.addCallback(this);
    mOpponent = null;

    numPlayer1GamesWon = 0;
    numPlayer2GamesWon = 0;

    boolean isRemote = gameLocale != FrozenBubble.LOCALE_LOCAL;
    boolean isCPU    = (opponentId == FrozenBubble.CPU) && !isRemote;

    if (myPlayerId == VirtualInput.PLAYER1) {
      mPlayer1 = new PlayerInput(VirtualInput.PLAYER1, false, false);
      mPlayer2 = new PlayerInput(VirtualInput.PLAYER2, isCPU, isRemote);
      mLocalInput  = mPlayer1;
      mRemoteInput = mPlayer2;
    }
    else {
      mPlayer1 = new PlayerInput(VirtualInput.PLAYER1, isCPU, isRemote);
      mPlayer2 = new PlayerInput(VirtualInput.PLAYER2, false, false);
      mLocalInput  = mPlayer2;
      mRemoteInput = mPlayer1;
    }

    /*
     * Create the player input mutexes.
     */
    input1Lock = new Object();
    input2Lock = new Object();

    /*
     * Create a network game manager if this is a network game.
     */
    mNetworkManager = null;
    if ((gameLocale == FrozenBubble.LOCALE_BLUETOOTH) ||
        (gameLocale == FrozenBubble.LOCALE_WIFI     )) {
      connectEnum mode;
      if (gameLocale == FrozenBubble.LOCALE_BLUETOOTH) {
        mode = connectEnum.BLUETOOTH;
      }
      else {
        mode = connectEnum.UDP_MULTICAST;
      }
      mNetworkManager = new NetworkManager(context,
                                           mode,
                                           mLocalInput,
                                           mRemoteInput);
      remoteInterface = mNetworkManager.getRemoteInterface();
    }

    /*
     * Give this view focus-ability for improved compatibility with
     * various input devices.
     */
    setFocusable(true);
    setFocusableInTouchMode(true);

    /*
     * Create and start the game thread.
     */
    if (numPlayers > 1) {
      mGameThread = new GameThread(holder);
    }
    else {
      mGameThread = new GameThread(holder, levels, startingLevel, arcadeGame);
    }
    mGameThread.setRunning(true);
    mGameThread.start();
  }

  public GameThread getThread() {
    return mGameThread;
  }

  private void monitorRemotePlayer() {
    if ((mNetworkManager != null) && (mRemoteInput != null)) {
      /*
       * Check the remote player interface for game field updates.
       * Reject the game field data if it doesn't correspond to the
       * latest remote player game field.  This is determined based on
       * whether the game field data action ID matches the latest remote
       * player action ID.
       */
      if (remoteInterface.gotFieldData) {
        if (mNetworkManager.getLatestRemoteActionId() ==
            remoteInterface.gameFieldData.localActionID) {
          setPlayerGameField(remoteInterface.gameFieldData);
        }
        remoteInterface.gotFieldData = false;
      }

      /*
       * Once the game is ready, if the game thread is not running, then
       * allow the remote player to update the game thread state.
       *
       * If an asynchronous action is available or we are clear to
       * perform a synchronous action, retrieve and clear the current
       * available action from the action queue.
       */
      if (mNetworkManager.gameIsReadyForAction() && (checkImmediateAction() ||
          mRemoteInput.mGameRef.getOkToFire() ||
          (mGameThread.mMode != stateEnum.RUNNING))) {
        if (mNetworkManager.getRemoteAction()) {
          setPlayerAction(remoteInterface.playerAction);
          remoteInterface.gotAction = false;
        }
        else if (mRemoteInput.mGameRef.getOkToFire()) {
          mNetworkManager.checkRemoteChecksum();
        }
      }
    }
  }

  @Override
  public boolean onGenericMotionEvent(MotionEvent event) {
    boolean handled = false;
    float   x       = event.getAxisValue(MotionEvent.AXIS_HAT_X);
    float   y       = event.getAxisValue(MotionEvent.AXIS_HAT_Y);
    int     keyCode = KeyEvent.KEYCODE_UNKNOWN;

    if (event.getAction() == MotionEvent.ACTION_MOVE) {
      if (y != 0.0f) {
        if (y < 0.0f) {
          keyCode = KeyEvent.KEYCODE_DPAD_UP;
        }
        else {
          keyCode = KeyEvent.KEYCODE_DPAD_DOWN;
        }
      }
  
      if (x != 0.0f) {
        if (x > 0.0f) {
          keyCode = KeyEvent.KEYCODE_DPAD_RIGHT;
        }
        else {
          keyCode = KeyEvent.KEYCODE_DPAD_LEFT;
        }
      }
  
      if (keyCode != KeyEvent.KEYCODE_UNKNOWN) {
        handled = mGameThread.doKeyDown(keyCode, event.getDeviceId());
      }
      else {
        handled = mGameThread.doKeyUp(event.getDeviceId());
      }
    }

    return handled || super.onGenericMotionEvent(event);
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    //Log.i("frozen-bubble", "GameView.onKeyDown()");
    return mGameThread.doKeyDown(keyCode, event.getDeviceId()) ||
           super.onKeyDown(keyCode, event);
  }

  @Override
  public boolean onKeyUp(int keyCode, KeyEvent event) {
    //Log.i("frozen-bubble", "GameView.onKeyUp()");
    return mGameThread.doKeyUp(event.getDeviceId()) ||
           super.onKeyUp(keyCode, event);
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    //Log.i("frozen-bubble", "GameView.onTouchEvent()");
    return mGameThread.doTouchEvent(event) ||
           super.onTouchEvent(event);
  }

  @Override
  public boolean onTrackballEvent(MotionEvent event) {
    //Log.i("frozen-bubble", "event.getX(): " + event.getX());
    //Log.i("frozen-bubble", "event.getY(): " + event.getY());
    return mGameThread.doTrackballEvent(event) ||
           super.onTrackballEvent(event);
  }

  @Override
  public void onWindowFocusChanged(boolean hasWindowFocus) {
    //Log.i("frozen-bubble", "GameView.onWindowFocusChanged()");
    super.onWindowFocusChanged(hasWindowFocus);
    if (!hasWindowFocus) {
      if (mNetworkManager != null) {
        mNetworkManager.pause();
      }
      if (mGameThread != null)
        mGameThread.pause();
    }
    else if (mNetworkManager != null) {
      mNetworkManager.unPause();
    }
  }

  /**
   * This is a class that extends TimerTask to resume displaying the
   * game screen as normal after it has been shown as a blank screen.
   * @author Eric Fortin
   *
   */
  class ResumeGameScreenTask extends TimerTask {
    @Override
    public void run() {
      mBlankScreen = false;
      cancel();
    }
  };

  /**
   * Set the player action for a remote player - as in a person playing
   * via a client device over a network.
   * @param newAction - the object containing the remote input info.
   */
  private void setPlayerAction(PlayerAction newAction) {
    if ((newAction != null) && (mGameThread != null)) {
      mGameThread.setPlayerAction(newAction);
    }
  }

  /**
   * Set the remote player client game field.
   * @param newGameField - the object containing the remote field data.
   */
  private void setPlayerGameField(GameFieldData newField) {
    if (newField == null) {
      return;
    }

    FrozenGame gameRef;

    if (newField.playerID == VirtualInput.PLAYER1) {
      gameRef = mPlayer1.mGameRef;
    }
    else if (newField.playerID == VirtualInput.PLAYER2) {
      gameRef = mPlayer2.mGameRef;
    }
    else {
      return;
    }

    /*
     * Set the bubble grid, and lower the compressor and bubbles in play
     * to the required number of compressor steps.
     */
    gameRef.setGrid(newField.gameField, newField.compressorSteps);

    /*
     * Set the launcher bubble colors.
     */
    gameRef.setLaunchBubbleColors(newField.launchBubbleColor,
                                  newField.nextBubbleColor,
                                  gameRef.getNewNextColor());

    /*
     * Set the current value of the attack bar.
     */
    gameRef.malusBar.setAttackBubbles(newField.attackBarBubbles, null);
  }

  public void surfaceChanged(SurfaceHolder holder, int format, int width,
                             int height) {
    //Log.i("frozen-bubble", "GameView.surfaceChanged");
    mGameThread.setSurfaceSize(width, height);
  }

  public void surfaceCreated(SurfaceHolder holder) {
    //Log.i("frozen-bubble", "GameView.surfaceCreated()");
    mGameThread.setSurfaceOK(true);
  }

  public void surfaceDestroyed(SurfaceHolder holder) {
    //Log.i("frozen-bubble", "GameView.surfaceDestroyed()");
    mGameThread.setSurfaceOK(false);
  }
}
