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

/*
 *  This file is derived from the LunarLander.java file which is part of
 *  the Lunar Lander game included with Android documentation.  The
 *  copyright notice for the Lunar Lander game is reproduced below.
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
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jfedor.frozenbubble;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.jfedor.frozenbubble.GameScreen.eventEnum;
import org.jfedor.frozenbubble.GameScreen.stateEnum;
import org.jfedor.frozenbubble.GameView.GameListener;
import org.jfedor.frozenbubble.GameView.GameThread;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.efortin.frozenbubble.AccelerometerManager;
import com.efortin.frozenbubble.AccelerometerManager.AccelerometerListener;
import com.efortin.frozenbubble.HomeScreen;
import com.efortin.frozenbubble.ModPlayer;
import com.efortin.frozenbubble.Preferences;
import com.efortin.frozenbubble.PreferencesActivity;
import com.efortin.frozenbubble.ScrollingCredits;
import com.efortin.frozenbubble.VirtualInput;
import com.peculiargames.andmodplug.PlayerThread;
import com.peculiargames.andmodplug.PlayerThread.PlayerListener;

public class FrozenBubble extends Activity
  implements GameListener,
             AccelerometerListener,
             PlayerListener{
  public final static boolean GAME_NORMAL     = false;
  public final static boolean GAME_COLORBLIND = true;

  public final static int MENU_COLORBLIND_ON  = 1;
  public final static int MENU_COLORBLIND_OFF = 2;
  public final static int MENU_FULLSCREEN_ON  = 3;
  public final static int MENU_FULLSCREEN_OFF = 4;
  public final static int MENU_SOUND_OPTIONS  = 5;
  public final static int MENU_DONT_RUSH_ME   = 6;
  public final static int MENU_RUSH_ME        = 7;
  public final static int MENU_NEW_GAME       = 8;
  public final static int MENU_ABOUT          = 9;
  public final static int MENU_EDITOR         = 10;
  public final static int MENU_TARGET_MODE    = 11;

  public final static int AIM_TO_SHOOT    = 0;
  public final static int POINT_TO_SHOOT  = 1;
  public final static int ROTATE_TO_SHOOT = 2;

  public final static int LOCALE_LOCAL     = 0;
  public final static int LOCALE_WIFI      = 1;
  public final static int LOCALE_INTERNET  = 2;
  public final static int LOCALE_BLUETOOTH = 3;

  public final static int CPU   = 0;
  public final static int HUMAN = 1;

  public static boolean arcadeGame = false;
  public static int     gameLocale = LOCALE_LOCAL;
  public static int     myPlayerId = VirtualInput.PLAYER1; 
  public static int     numPlayers = 0;
  public static int     opponentId = CPU;
  public static boolean playerSave = false;

  private static Preferences prefs = new Preferences();

  public final static String EDITORACTION = "org.jfedor.frozenbubble.GAME";
  public final static String PREFS_NAME   = "frozenbubble";
  public final static String SAVE_GAME    = "FrozenBubble.save";
  public final static String TAG          = "FrozenBubble.java";

  private boolean    activityCustomStarted = false;
  private boolean    allowUnpause          = true;
  private int        currentOrientation;
  private GameThread mGameThread           = null;
  private GameView   mGameView             = null;
  private ModPlayer  myModPlayer           = null;
  private OrientationEventListener myOrientationEventListener = null;

  private final int[] MODlist = {
    R.raw.ambientpower,
    R.raw.ambientlight,
    R.raw.androidrupture,
    R.raw.artificial,
    R.raw.aftertherain,
    R.raw.bluestars,
    R.raw.chungababe,
    R.raw.crystalhammer,
    R.raw.dreamscope,
    R.raw.freefall,
    R.raw.gaeasawakening,
    R.raw.homesick,
    R.raw.ifcrystals,
    R.raw.popcorn,
    R.raw.stardustmemories,
    R.raw.sunshineofthemorningsun,
    R.raw.technostyleiii
  };

  /*
   * Following are ancestor superclass overrides.
   */

  /*
   * (non-Javadoc)
   * @see android.app.Activity#onCreate(android.os.Bundle)
   * This method is called when the activity is started.  The activity
   * may have been reconfigured or the system may have killed the
   * process, after which it regained focus to invoke this method.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    //if (savedInstanceState != null)
    //{
    //  Log.i(TAG, "FrozenBubble.onCreate(...)");
    //}
    //else
    //{
    //  Log.i(TAG, "FrozenBubble.onCreate(null)");
    //}
    super.onCreate(savedInstanceState);
    setVolumeControlStream(AudioManager.STREAM_MUSIC);
    requestWindowFeature(Window.FEATURE_NO_TITLE);

    /*
     * Allow editor functionalities.
     */
    Intent intent = getIntent();
    try {
      if ((null == intent) || (null == intent.getExtras()) ||
          !intent.getExtras().containsKey("levels"))
        startDefaultGame(intent, savedInstanceState);
      else
        startCustomGame(intent);
    } catch (NullPointerException npe) {
      startDefaultGame(intent, savedInstanceState);
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    menu.add(0, MENU_COLORBLIND_ON,  0, R.string.menu_colorblind_on);
    menu.add(0, MENU_COLORBLIND_OFF, 0, R.string.menu_colorblind_off);
    menu.add(0, MENU_FULLSCREEN_ON,  0, R.string.menu_fullscreen_on);
    menu.add(0, MENU_FULLSCREEN_OFF, 0, R.string.menu_fullscreen_off);
    menu.add(0, MENU_SOUND_OPTIONS,  0, R.string.menu_sound_options);
    menu.add(0, MENU_TARGET_MODE,    0, R.string.menu_target_mode);
    menu.add(0, MENU_DONT_RUSH_ME,   0, R.string.menu_dont_rush_me);
    menu.add(0, MENU_RUSH_ME,        0, R.string.menu_rush_me);
    menu.add(0, MENU_ABOUT,          0, R.string.menu_about);
    menu.add(0, MENU_NEW_GAME,       0, R.string.menu_new_game);
    menu.add(0, MENU_EDITOR,         0, R.string.menu_editor);
    return true;
  }

  /**
   * Invoked when the Activity is finishing or being destroyed by the
   * system.
   */
  @Override
  protected void onDestroy() {
    //Log.i(TAG, "FrozenBubble.onDestroy()");
    super.onDestroy();
    cleanUp();
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    boolean handled = false;
    if (keyCode == KeyEvent.KEYCODE_BACK) {
      /*
       * Only show the game exit dialog while a game is in progress,
       * otherwise simply exit.
       */
      if ((mGameThread != null) && mGameThread.gameInProgress()) {
        exitGameDialog();
      }
      else {
        exit(true);
      }
      handled = true;
    }
    return handled || super.onKeyDown(keyCode, event);
  }

  /* (non-Javadoc)
   * @see android.app.Activity#onNewIntent(android.content.Intent)
   */
  @Override
  protected void onNewIntent(Intent intent) {
    if (null != intent) {
      if (EDITORACTION.equals(intent.getAction())) {
        cleanUpGameView();
        startCustomGame(intent);
      }
      else if ((numPlayers != 0) && intent.hasExtra("numPlayers")) {
        int newNumPlayers = intent.getIntExtra("numPlayers", 1);

        if (newNumPlayers != numPlayers) {
          cleanUpGameView();
          startDefaultGame(intent, null);
        }
      }
    }
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    boolean prefsUpdated = false;

    switch (item.getItemId()) {
      case MENU_NEW_GAME:
        newGameDialog();
        return true;
      case MENU_COLORBLIND_ON:
        prefs.colorMode = GAME_COLORBLIND;
        prefsUpdated = true;
        break;
      case MENU_COLORBLIND_OFF:
        prefs.colorMode = GAME_NORMAL;
        prefsUpdated = true;
        break;
      case MENU_FULLSCREEN_ON:
        prefs.fullscreen = true;
        setFullscreen();
        prefsUpdated = true;
        break;
      case MENU_FULLSCREEN_OFF:
        prefs.fullscreen = false;
        setFullscreen();
        prefsUpdated = true;
        break;
      case MENU_SOUND_OPTIONS:
        soundOptionsDialog();
        return true;
      case MENU_ABOUT:
        if (mGameThread != null)
          mGameThread.setState(stateEnum.ABOUT);
        return true;
      case MENU_TARGET_MODE:
        targetOptionsDialog();
        return true;
      case MENU_DONT_RUSH_ME:
        prefs.dontRushMe = true;
        prefsUpdated = true;
        break;
      case MENU_RUSH_ME:
        prefs.dontRushMe = false;
        prefsUpdated = true;
        break;
      case MENU_EDITOR:
        startEditor();
        return true;
    }

    if (prefsUpdated) {
      SharedPreferences sp =
          PreferenceManager.getDefaultSharedPreferences(this);
      PreferencesActivity.saveDefaultPreferences(prefs, sp);
    }

    return prefsUpdated;
  }

  @Override
  public void onOptionsMenuClosed(Menu menu) {
    super.onOptionsMenuClosed(menu);
    allowUnpause = true;
  }

  /**
   * Invoked when the Activity loses user focus.
   */
  @Override
  protected void onPause() {
    //Log.i(TAG, "FrozenBubble.onPause()");
    super.onPause();
    pause();
  }

  @Override
  public boolean onPrepareOptionsMenu(Menu menu) {
    super.onPrepareOptionsMenu(menu);
    allowUnpause = false;
    menu.findItem(MENU_COLORBLIND_ON ).setVisible(prefs.colorMode == GAME_NORMAL);
    menu.findItem(MENU_COLORBLIND_OFF).setVisible(prefs.colorMode != GAME_NORMAL);
    menu.findItem(MENU_FULLSCREEN_ON ).setVisible(!prefs.fullscreen);
    menu.findItem(MENU_FULLSCREEN_OFF).setVisible(prefs.fullscreen);
    menu.findItem(MENU_SOUND_OPTIONS ).setVisible(true);
    menu.findItem(MENU_TARGET_MODE   ).setVisible(true);
    menu.findItem(MENU_DONT_RUSH_ME  ).setVisible(!prefs.dontRushMe);
    menu.findItem(MENU_RUSH_ME       ).setVisible(prefs.dontRushMe);
    return true;
  }

  /**
   * Notification that something is about to happen, to give the
   * Activity a chance to save state.
   * @param outState - A Bundle into which this Activity should save its
   * state.
   */
  @Override
  protected void onSaveInstanceState(Bundle outState) {
    //Log.i(TAG, "FrozenBubble.onSaveInstanceState()");
    /*
     * Just have the View's thread save its state into our Bundle.
     */
    super.onSaveInstanceState(outState);
    saveState(outState);

    /*
     * Set a flag indicating that the system passed us a bundle to save
     * the game state in.
     */
    SharedPreferences.Editor editor =
        PreferenceManager.getDefaultSharedPreferences(this).edit();
    editor.putBoolean("systemSave", true);
    editor.commit();
  }

  @Override
  public void onWindowFocusChanged (boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);
    allowUnpause = hasFocus;
  }

  /*
   * The following methods are used to retrieve and set the volatile
   * memory game options variables.  They are all static, so are
   * available to all activities within this application while the
   * application is running.
   */

  public static boolean getAimThenShoot() {
    return (prefs.targetMode == AIM_TO_SHOOT) || (prefs.targetMode == ROTATE_TO_SHOOT);
  }

  public static int getBluetooth() {
    return prefs.bluetooth;
  }

  public static void setBluetooth(int newBluetooth) {
    prefs.bluetooth = newBluetooth;
  }

  public static int getCollision() {
    return prefs.collision;
  }

  public static void setCollision(int newCollision) {
    prefs.collision = newCollision;
    BubbleSprite.setCollisionThreshold(prefs.collision);
  }

  public static boolean getColorMode() {
    return prefs.colorMode;
  }

  public static void setColorMode(boolean newMode) {
    prefs.colorMode = newMode;
  }

  public static boolean getCompressor() {
    return prefs.compressor;
  }

  public static void setCompressor(boolean newCompressor) {
    prefs.compressor = newCompressor;
  }

  public static int getDifficulty() {
    return prefs.difficulty;
  }

  public static void setDifficulty(int newDifficulty) {
    prefs.difficulty = newDifficulty;
  }

  public static boolean getDontRushMe() {
    return prefs.dontRushMe;
  }

  public static void setDontRushMe(boolean dont) {
    prefs.dontRushMe = dont;
  }

  public static boolean getFullscreen() {
    return prefs.fullscreen;
  }

  public static void setFullscreen(boolean newFullscreen) {
    prefs.fullscreen = newFullscreen;
  }

  public static boolean getMusicOn() {
    return prefs.musicOn;
  }

  public static void setMusicOn(boolean mo) {
    prefs.musicOn = mo;
  }

  public static boolean getSoundOn() {
    return prefs.soundOn;
  }

  public static void setSoundOn(boolean so) {
    prefs.soundOn = so;
  }

  public static int getTargetMode() {
    return prefs.targetMode;
  }

  public static void setTargetMode(int tm) {
    prefs.targetMode = tm;
  }

  /*
   * Following are general utility functions.
   */

  /**
   * Perform activity cleanup.  <b>This must only be called when the
   * activity is being destroyed.</b>
   */
  public void cleanUp() {
    /*
     * The current game is being destroyed, so reset the static game
     * state variables.
     */
    arcadeGame = false;
    gameLocale = LOCALE_LOCAL;
    myPlayerId = VirtualInput.PLAYER1; 
    numPlayers = 0;
    opponentId = CPU;

    if (AccelerometerManager.isListening())
      AccelerometerManager.stopListening();

    if (myOrientationEventListener != null) {
      myOrientationEventListener.disable();
    }
    myOrientationEventListener = null;

    cleanUpGameView();

    if (myModPlayer != null) {
      myModPlayer.destroyMusicPlayer();
    }
    myModPlayer = null;
  }

  private void cleanUpGameView() {
    mGameThread = null;
    if (mGameView != null) {
      mGameView.cleanUp();
    }
    mGameView = null;
  }

  private void exit(boolean goToHomeScreen) {
    /*
     * Preserve game information and perform activity cleanup.
     */
    pause();
    if (mGameThread != null)
      mGameThread.setRunning(false);
    cleanUp();
    /*
     * Clear the flag indicating that the system passed us a bundle to
     * save the game state.
     */
    SharedPreferences.Editor editor =
        PreferenceManager.getDefaultSharedPreferences(this).edit();
    editor.putBoolean("systemSave", false);
    editor.commit();
    /*
     * Create an intent to launch the home screen.
     */
    if (goToHomeScreen) {
      Intent intent = new Intent(this, HomeScreen.class);
      intent.putExtra("startHomeScreen", true);
      startActivity(intent);
    }
    /*
     * Finish the current activity.
     */
    finish();
  }

  private void exitGameDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(FrozenBubble.this);
    /*
     * Set the dialog title.
     */
    builder.setTitle(R.string.exit)
    /*
     * Set the action buttons.
     */
    .setPositiveButton(R.string.save_and_exit,
                       new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int id) {
        /*
         * User clicked OK.  Save and quit.  Only save if this isn't a
         * custom game.
         */
        if (!activityCustomStarted) {
          saveGame(null);
        }
        exit(true);
      }
    })
    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int id) {
        /*
         * User clicked Cancel.  Do nothing.
         */
        if (mGameThread != null) {
          mGameThread.resumeGame();
        }
      }
    })
    .setNeutralButton(R.string.exit, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int id) {
        /*
         * User clicked neutral option.  Quit.
         */
        exit(true);
      }
    })
    .setOnCancelListener(new DialogInterface.OnCancelListener() {
      @Override
      public void onCancel(DialogInterface dialog) {
        /*
         * User canceled.  Do nothing.
         */
        if (mGameThread != null) {
          mGameThread.resumeGame();
        }
      }
    });
    AlertDialog alert = builder.create();
    alert.show();
    Button btn1 = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
    btn1.setTextSize(18);
    Button btn2 = alert.getButton(DialogInterface.BUTTON_NEUTRAL);
    btn2.setTextSize(18);
    Button btn3 = alert.getButton(DialogInterface.BUTTON_POSITIVE);
    btn3.setTextSize(18);
  }

  /**
   * Obtain the screen orientation.
   * @param windowManager - used to get a reference to the display to
   * obtain display information.
   * @return The screen orientation, which can be among the following
   * values:<br><code>
   * ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE<br>
   * ActivityInfo.SCREEN_ORIENTATION_PORTRAIT<br>
   * FrozenBubble.SCREEN_ORIENTATION_REVERSE_LANDSCAPE<br>
   * FrozenBubble.SCREEN_ORIENTATION_REVERSE_PORTRAIT</code>
   */
  public static int getScreenOrientation(WindowManager windowManager) {
    /*
     * The method getOrientation() was deprecated in API level 8.
     *
     * For API level 8 or greater, use getRotation().
     */
    int rotation = windowManager.getDefaultDisplay().getRotation();
    DisplayMetrics dm = new DisplayMetrics();
    windowManager.getDefaultDisplay().getMetrics(dm);
    int width  = dm.widthPixels;
    int height = dm.heightPixels;
    int orientation;
    /*
     * The orientation determination is based on the natural orienation
     * mode of the device, which can be either portrait, landscape, or
     * square.
     *
     * After the natural orientation is determined, convert the device
     * rotation into a fully qualified orientation.
     */
    if ((((rotation == Surface.ROTATION_0  ) ||
          (rotation == Surface.ROTATION_180)) && (height > width)) ||
        (((rotation == Surface.ROTATION_90 ) ||
          (rotation == Surface.ROTATION_270)) && (width  > height))) {
      /*
       * Natural orientation is portrait.
       */
      switch(rotation) {
        case Surface.ROTATION_0:
          orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
          break;
        case Surface.ROTATION_90:
          orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
          break;
        case Surface.ROTATION_180:
          orientation = ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
          break;
        case Surface.ROTATION_270:
          orientation = ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
          break;
        default:
          orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
          break;              
      }
    }
    else {
      /*
       * Natural orientation is landscape or square.
       */
      switch(rotation) {
        case Surface.ROTATION_0:
          orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
          break;
        case Surface.ROTATION_90:
          orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
          break;
        case Surface.ROTATION_180:
          orientation = ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
          break;
        case Surface.ROTATION_270:
          orientation = ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
          break;
        default:
          orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
          break;              
      }
    }

    return orientation;
  }

  /**
   * Restore the game options from the saved preferences, and register
   * the device orientation listener to detect orientation changes.
   */
  private void initGameOptions() {
    restoreGamePrefs();

    currentOrientation = getScreenOrientation(getWindowManager());
    myOrientationEventListener =
      new OrientationEventListener(this, SensorManager.SENSOR_DELAY_NORMAL) {
        @Override
        public void onOrientationChanged(int arg0) {
          currentOrientation = getScreenOrientation(getWindowManager());
        }
      };
    if (myOrientationEventListener.canDetectOrientation())
      myOrientationEventListener.enable();
  }

  /**
   * Start a new game and music player.
   */
  public void newGame() {
    if (mGameThread != null) {
      mGameThread.newGame(true);
    }

    playMusic(false);
  }

  private void newGameDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(FrozenBubble.this);
    /*
     * Set the dialog title.
     */
    builder.setTitle(R.string.menu_new_game)
    /*
     * Set the action buttons.
     */
    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int id) {
        // User clicked OK.  Start a new game.
        newGame();
      }
    })
    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int id) {
        // User clicked Cancel.  Do nothing.
      }
    });
    builder.create();
    builder.show();
  }

  private void newGameView(Bundle map) {
    if (map != null) {
      /*
       * Force the game locale to be confined to the local device when
       * restoring a saved game.  Restoring a network game is of little
       * to no value as opposed to simply starting a new game.
       */
      arcadeGame = map.getBoolean("arcadeGame", false               );
      gameLocale = LOCALE_LOCAL;
      myPlayerId = map.getInt    ("myPlayerId", VirtualInput.PLAYER1);
      numPlayers = map.getInt    ("numPlayers", 0                   );
      opponentId = map.getInt    ("opponentId", CPU                 );
    }
    mGameView = new GameView(this,
                             numPlayers,
                             myPlayerId,
                             opponentId,
                             gameLocale,
                             arcadeGame);
    setContentView(mGameView);
    mGameView.setGameListener(this);
    mGameThread = mGameView.getThread();
    mGameThread.restoreState(map);
    mGameView.requestFocus();
  }

  @Override
  public void onAccelerationChanged(float x, float y, float z) {
    if (mGameThread != null) {
      if (numPlayers > 1) {
        if (currentOrientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
          x = -y;
        else if (currentOrientation == ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE)
          x = y;
        else if (currentOrientation == ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT)
          x = -x;
      }
      else if (currentOrientation == ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT) {
        x = -x;
      }
      mGameThread.setPosition(20.0f+x*2.0f);
    }
  }

  @Override
  public void onGameEvent(eventEnum event) {
    switch (event) {
      case GAME_EXIT:
        /*
         * Only show the game exit dialog while a game is in progress,
         * otherwise simply exit.
         */
        if ((mGameThread != null) && mGameThread.gameInProgress()) {
          exitGameDialog();
        }
        else {
          exit(true);
        }
        break;

      case GAME_WON:
        break;

      case GAME_LOST:
        break;

      case GAME_PAUSED:
        if (myModPlayer != null)
          myModPlayer.pausePlay();
        break;

      case GAME_RESUME:
        if (myModPlayer == null)
          playMusic(true);
        else if (allowUnpause)
          myModPlayer.unPausePlay();
        break;

      case GAME_START:
        if (!arcadeGame && (mGameView != null) && (mGameThread != null) &&
            (numPlayers == 1)) {
          if (mGameThread.getCurrentLevelIndex() == 0) {
            /*
             * Destroy the current music player, which will free audio
             * stream resources and allow the system to use them.
             */
            if (myModPlayer != null)
              myModPlayer.destroyMusicPlayer();
            myModPlayer = null;
            /*
             * Clear the game screen and suspend input processing for
             * three seconds.
             *
             * Afterwards,  the "About" screen will be displayed as a
             * backup just in case anything goes awry with displaying
             * the end-of-game credits.  It will be displayed after the
             * user touches the screen when the credits are finished.
             */
            mGameView.clearGameScreen(true, 3000);
            /*
             * Create an intent to launch the activity to display the
             * credits screen.
             */
            Intent intent = new Intent(this, ScrollingCredits.class);
            startActivity(intent);
            break;
          }
        }
        playMusic(true);
        break;

      default:
        break;
    }
  }

  @Override
  public void onPlayerEvent(
      com.peculiargames.andmodplug.PlayerThread.eventEnum event) {
      switch (event) {
      case SONG_COMPLETED:
        if (myModPlayer != null) {
          if (!songsSequential()) {
            playMusic(true);
          }
        }
        break;
      case PATTERN_CHANGE:
      case PLAYER_STARTED:
      default:
        break;
    }
  }

  /**
   * Pause the game.
   */
  private void pause() {
    if (mGameThread != null)
      mGameThread.pause();

    /*
     * Pause the MOD player.
     */
    if (myModPlayer != null)
      myModPlayer.pausePlay();
  }

  /**
   * This function determines whether a music player instance needs to
   * be created or if one already exists.  Then, based on the current
   * level, the song to play is calculated and loaded.  If desired, the
   * song will start playing immediately, or it can remain paused.
   * @param startPlaying - If <code>true</code>, the song starts playing
   * immediately.  Otherwise it is paused and must be unpaused to start
   * playing.
   */
  private void playMusic(boolean startPlaying)
  {
    int loopCount;
    int modNow;
    /*
     * Ascertain which song to play.  For a single player game, the song
     * is based on the current level.  For an arcade game, a two player
     * game, or if the game thread has been destroyed, the song is
     * selected at random.
     */
    if (songsSequential()) {
      loopCount = PlayerThread.LOOP_SONG_FOREVER;
      modNow    = mGameThread.getCurrentLevelIndex() % MODlist.length;
    }
    else
    {
      loopCount = PlayerThread.LOOP_SONG_FOREVER;
      modNow = new Random().nextInt(MODlist.length);
    }
    /*
     * Determine whether to create a music player or load the song.
     */
    if (myModPlayer == null) {
      myModPlayer = new ModPlayer(this,
                                  MODlist[modNow],
                                  loopCount,
                                  getMusicOn(),
                                 !startPlaying);
      myModPlayer.setPlayerListener(this);
    }
    else {
      myModPlayer.loadNewSong(MODlist[modNow], startPlaying);
    }
    allowUnpause = true;
  }

  /**
   * Restore the game from a player saved bundle.
   * <p>Note that this implementation uses a practice that is not
   * recommended by the API documentation, as serializing a
   * <code>Parcel</code> object is not guaranteed to be compatible
   * amongst disparate versions of the Android OS.
   */
  private Bundle restoreSavedGame() {
    Bundle inState = null;
    Parcel parcel  = Parcel.obtain();

    try {
      FileInputStream fis = openFileInput(SAVE_GAME);
      byte[] array = new byte[(int) fis.getChannel().size()];
      fis.read(array, 0, array.length);
      fis.close();
      parcel.unmarshall(array, 0, array.length);
      parcel.setDataPosition(0);
      inState = parcel.readBundle();
      inState.putAll(inState);
    } catch (FileNotFoundException fnfe) {
      /*
       * Cannot open file, so the game could not be restored.
       */
    } catch (IOException ioe) {
      /*
       * Error occurred while reading from file.
       */
      ioe.printStackTrace();
    } finally {
      parcel.recycle();
    }

    return inState;
  }

  /**
   * Load the game options from the saved shared preferences.
   */
  private void restoreGamePrefs() {
    SharedPreferences sp =
        PreferenceManager.getDefaultSharedPreferences(this);
    prefs = PreferencesActivity.getDefaultPrefs(sp);

    /*
     * Some game options require additional handling to fully implement
     * changes to game play.
     */
    BubbleSprite.setCollisionThreshold(prefs.collision);
    setTargetModeOrientation();
  }

  /**
   * Save the game to a player saved bundle.
   * <p>Note that this implementation uses a practice that is not
   * recommended by the API documentation, as serializing a
   * <code>Parcel</code> object is not guaranteed to be compatible
   * amongst disparate versions of the Android OS.
   */
  private void saveGame(Bundle map) {
    Bundle outState = map;
    Parcel parcel   = Parcel.obtain();

    if (outState == null) {
      outState = new Bundle();
      saveState(outState);
    }

    try {
      FileOutputStream fos = openFileOutput(SAVE_GAME, Context.MODE_PRIVATE);
      outState.writeToParcel(parcel, 0);
      fos.write(parcel.marshall());
      fos.flush();
      fos.close();
      /*
       * Set a flag indicating that the player saved the game.
       */
      Editor editor =
          PreferenceManager.getDefaultSharedPreferences(this).edit();
      editor.putBoolean("playerSave", true);
      editor.commit();
    } catch (FileNotFoundException fnfe) {
      /*
       * Cannot create file, so the game could not be saved.
       */
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      /*
       * Error occurred while writing to file.
       */
      ioe.printStackTrace();
    } finally {
      parcel.recycle();
    }
  }

  /**
   * Save critically important game information.
   */
  public void saveState(Bundle map) {
    if (!arcadeGame && (mGameThread != null) && (numPlayers == 1)) {
      /*
       * Allow level editor functionalities.
       */
      SharedPreferences sp = getSharedPreferences(PREFS_NAME,
                                                  Context.MODE_PRIVATE);
      SharedPreferences.Editor editor = sp.edit();
      /*
       * If the game wasn't launched from the level editor, save the
       * last level played.
       */
      Intent i = getIntent();
      if ((null == i) || !activityCustomStarted) {
        editor.putInt("level", mGameThread.getCurrentLevelIndex());
      }
      else {
        /*
         * The level editor's intent is running.
         */
        editor.putInt("levelCustom", mGameThread.getCurrentLevelIndex());
      }
      editor.commit();
    }
    if (map != null) {
      map.putBoolean("arcadeGame", arcadeGame);
      map.putInt    ("gameLocale", gameLocale);
      map.putInt    ("myPlayerId", myPlayerId);
      map.putInt    ("numPlayers", numPlayers);
      map.putInt    ("opponentId", opponentId);
  
      if (mGameThread != null) {
        mGameThread.saveState(map);
      }
    }
  }

  private void setFullscreen() {
    final int flagFs   = WindowManager.LayoutParams.FLAG_FULLSCREEN;
    final int flagNoFs = WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN;

    if (prefs.fullscreen) {
      getWindow().addFlags(flagFs);
      getWindow().clearFlags(flagNoFs);
    }
    else {
      getWindow().clearFlags(flagFs);
      getWindow().addFlags(flagNoFs);
    }

    if (mGameView != null)
      mGameView.requestLayout();
  }

  private void setTargetModeOrientation() {
    if ((prefs.targetMode == ROTATE_TO_SHOOT) &&
        AccelerometerManager.isSupported(getApplicationContext())) {
      AccelerometerManager.startListening(getApplicationContext(),this);
      /*
       * In API level 9, SCREEN_ORIENTATION_SENSOR_PORTRAIT and
       * SCREEN_ORIENTATION_SENSOR_LANDSCAPE were added to ActivityInfo.
       * This application is developed in API level 4, but using these
       * values will be supported correctly in devices with a native API
       * level that implements this functionality.
       *
       * These modes allow the device to display the screen in either
       * normal or reverse portrait mode based on the device orientation
       * reported by the accelerometer hardware.
       *
       * For multiplayer games using rotate to shoot, set the
       * orientation to sensor landscape, and for single player games,
       * set the orientation to sensor portrait.
       */
      if (numPlayers > 1) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
      }
      else {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
      }
    }

    if ((prefs.targetMode != ROTATE_TO_SHOOT) &&
        AccelerometerManager.isListening()) {
      AccelerometerManager.stopListening();
      setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
    }
  }

  /**
   * For a Puzzle game, there are consecutive levels.  Each level will
   * have a corresponding song.
   * @return <code>true</code> if the song index should be selected
   * based on the current game level.
   */
  private boolean songsSequential() {
    return(!arcadeGame && (mGameThread != null) && (numPlayers == 1));
  }

  private void soundOptionsDialog() {
    boolean isCheckedItem[] = {getSoundOn(), getMusicOn()};

    AlertDialog.Builder builder = new AlertDialog.Builder(FrozenBubble.this);
    /*
     * Set the dialog title.
     */
    builder.setTitle(R.string.menu_sound_options)
    /*
     * Specify the list array, the items to be selected by default (null
     * for none), and the listener through which to receive callbacks
     * when items are selected.
     */
    .setMultiChoiceItems(R.array.sound_options_array, isCheckedItem,
                         new DialogInterface.OnMultiChoiceClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which, boolean isChecked) {
        boolean prefsUpdated = false;

        switch (which) {
          case 0:
            setSoundOn(isChecked);
            prefsUpdated = true;
            break;
          case 1:
            setMusicOn(isChecked);
            if (myModPlayer != null) {
              myModPlayer.setMusicOn(isChecked);
            }
            prefsUpdated = true;
            break;
        }
        
        if (prefsUpdated) {
          SharedPreferences sp =
              PreferenceManager.getDefaultSharedPreferences(getApplication());
          PreferencesActivity.saveDefaultPreferences(prefs, sp);
        }
      }
    })
    /*
     * Set the action buttons.
     */
    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int id) {
        // User clicked OK.
      }
    });
    builder.create();
    builder.show();
  }

  /**
   * Update the game preferences to the desired values.
   * @param prefs - the desired game preferences.
   */
  public static void setPrefs(Preferences prefs) {
    FrozenBubble.setBluetooth (prefs.bluetooth );
    FrozenBubble.setCollision (prefs.collision );
    FrozenBubble.setColorMode (prefs.colorMode );
    FrozenBubble.setCompressor(prefs.compressor);
    FrozenBubble.setDifficulty(prefs.difficulty);
    FrozenBubble.setDontRushMe(prefs.dontRushMe);
    FrozenBubble.setFullscreen(prefs.fullscreen);
    FrozenBubble.setMusicOn   (prefs.musicOn   );
    FrozenBubble.setSoundOn   (prefs.soundOn   );
    FrozenBubble.setTargetMode(prefs.targetMode);
  }

  /**
   * Method to start a game using levels from the level editor.
   * <p>If the level isn't specified from the editor, then the player
   * selected the option to continue playing from the last level
   * played, so use the last level played instead.
   * @param intent - The intent from the level editor used to start this
   * activity, which contains the custom level data.
   */
  private void startCustomGame(Intent intent) {
    activityCustomStarted = true;
    numPlayers = 1;
    initGameOptions();
    /*
     * Get custom level last played.
     */
    SharedPreferences sp = getSharedPreferences(PREFS_NAME,
                                                Context.MODE_PRIVATE);
    int startingLevel       = sp    .getInt     ("levelCustom",    0);
    int startingLevelIntent = intent.getIntExtra("startingLevel", -2);
    startingLevel =
      (startingLevelIntent == -2) ? startingLevel : startingLevelIntent;
    mGameView = new GameView(this,
                             intent.getExtras().getByteArray("levels"),
                             startingLevel);
    setContentView(mGameView);
    mGameView.setGameListener(this);
    mGameThread = mGameView.getThread();
    mGameView.requestFocus();
    setFullscreen();
    playMusic(false);
  }

  /**
   * Method to start a game using default levels, if single player game
   * mode was selected.
   * <p>This method is also used to start a multiplayer game.
   * @param intent - The intent used to start this activity.
   * @param savedInstanceState - the bundle of saved state information.
   */
  private void startDefaultGame(Intent intent, Bundle savedInstanceState) {
    /*
     * Initialize the flag to denote this game uses default levels.
     */
    activityCustomStarted = false;

    /*
     * Initialize the game state variables to safe defaults.
     */
    arcadeGame = false;
    gameLocale = LOCALE_LOCAL;
    myPlayerId = VirtualInput.PLAYER1;
    numPlayers = 1;
    opponentId = CPU;
    playerSave = false;

    /*
     * Load the game configuration from the intent data, if it exists.
     * These values may be superseded if a player or system save bundle
     * is loaded.
     */
    if (intent != null) {
      if (intent.hasExtra("myPlayerId"))
        myPlayerId = intent.getIntExtra("myPlayerId", VirtualInput.PLAYER1);
      if (intent.hasExtra("numPlayers"))
        numPlayers = intent.getIntExtra("numPlayers", 1);
      if (intent.hasExtra("opponentId"))
        opponentId = intent.getIntExtra("opponentId", CPU);
      if (intent.hasExtra("gameLocale"))
        gameLocale = intent.getIntExtra("gameLocale", LOCALE_LOCAL);
      if (intent.hasExtra("arcadeGame"))
        arcadeGame = intent.getBooleanExtra("arcadeGame", false);
      if (intent.hasExtra("playerSave"))
        playerSave = intent.getBooleanExtra("playerSave", false);
    }

    initGameOptions();

    if (playerSave) {
      newGameView(restoreSavedGame());
    }
    else {
      newGameView(savedInstanceState);
    }

    setFullscreen();
    playMusic(false);
  }

  /**
   * Starts editor / market with editor's download.
   */
  private void startEditor() {
    Intent i = new Intent();
    /*
     * First try to run the plus version of the level editor.
     */
    i.setClassName("sk.halmi.fbeditplus", 
                   "sk.halmi.fbeditplus.EditorActivity");
    try {
      startActivity(i);
      finish();
    } catch (ActivityNotFoundException e) {
      /*
       * If not found, try to run the normal version.
       */
      i.setClassName("sk.halmi.fbedit", 
                     "sk.halmi.fbedit.EditorActivity");
      try {
        startActivity(i);
        finish();
      } catch (ActivityNotFoundException ex) {
        /*
         * If the user doesn't have the Frozen Bubble Level Editor, take
         * him to the application market.
         */
        try {
          Toast.makeText(getApplicationContext(), 
                         R.string.install_editor, Toast.LENGTH_SHORT).show();
          i = new Intent(Intent.ACTION_VIEW,
                         Uri.parse(
                         "market://search?q=frozen bubble level editor"));
          startActivity(i);
        } catch (Exception exc) {
          /*
           * Damn, you don't have market?
           */
          Toast.makeText(getApplicationContext(), 
                         R.string.market_missing, Toast.LENGTH_SHORT).show();
        }
      }
    }
  }

  private void targetOptionsDialog() {
    AlertDialog.Builder builder = new AlertDialog.Builder(FrozenBubble.this);
    /*
     * Set the dialog title.
     */
    builder.setTitle(R.string.menu_target_mode)
    /*
     * Specify the list array, the item to be selected by default, and
     * the listener through which to receive callbacks when the item is
     * selected.
     */
    .setSingleChoiceItems(R.array.shoot_mode_array, prefs.targetMode,
                          new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface builder, int which) {
        switch (which) {
          case 0:
            setTargetMode(AIM_TO_SHOOT);
            break;
          case 1:
            setTargetMode(POINT_TO_SHOOT);
            break;
          case 2:
            setTargetMode(ROTATE_TO_SHOOT);
            break;
        }
        setTargetModeOrientation();
      }
    })
    /*
     * Set the action buttons.
     */
    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface builder, int id) {
        // User clicked OK.
        SharedPreferences sp =
            PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        PreferencesActivity.saveDefaultPreferences(prefs, sp);
      }
    });

    builder.create();
    builder.show();
  }
}
