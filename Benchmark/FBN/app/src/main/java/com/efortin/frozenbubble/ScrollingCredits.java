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

package com.efortin.frozenbubble;

import org.jfedor.frozenbubble.FrozenBubble;
import org.jfedor.frozenbubble.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.peculiargames.andmodplug.PlayerThread;

public class ScrollingCredits extends Activity implements Runnable {
  private boolean victoryScreenShown = false;
  private ScrollingTextView credits;
  private ModPlayer myModPlayer = null;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // Configure the window presentation and layout.
    setWindowLayout(R.layout.activity_scrolling_credits);
    // Get the instance of the ScrollingTextView object.
    credits = (ScrollingTextView)findViewById(R.id.scrolling_credits);
    // Configure the credits text presentation.
    credits.setScrollRepeatLimit(0);
    credits.setSpeed(50.0f);
    credits.setScrollDirection(ScrollingTextView.SCROLL_UP);
    credits.setTextSize(18.0f);
    // Start the credits music.
    myModPlayer = new ModPlayer(this,
                                R.raw.worldofpeace,
                                PlayerThread.LOOP_SONG_FOREVER,
                                FrozenBubble.getMusicOn(),
                                false);
    // Post this runnable instance to the scrolling text view.
    credits.postDelayed(this, 100);
  }

  @Override
  public void onPause() {
    super.onPause();
    pauseCredits();
  }

  @Override
  public void onResume() {
    super.onResume();
    resumeCredits();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    cleanUp();
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent msg) {
    if (keyCode == KeyEvent.KEYCODE_BACK) {
      end();
      return true;
    }
    return checkCreditsDone();
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    return checkCreditsDone();
  }

  @Override
  public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);

    if (hasFocus)
      resumeCredits();
    else
      pauseCredits();
  }

  private void displayImage(int id) {
    // Construct a new LinearLayout programmatically. 
    LinearLayout linearLayout = new LinearLayout(this);
    linearLayout.setOrientation(LinearLayout.VERTICAL);
    linearLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                                                  LayoutParams.MATCH_PARENT));
    // ImageView setup for the image.
    ImageView imageView = new ImageView(this);
    // Set image resource.
    imageView.setImageResource(id);
    // Set image position and scaling.
    imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                                               LayoutParams.MATCH_PARENT));
    // Add view to layout.
    linearLayout.addView(imageView);
    // Set the content view to this layout and display the image.
    setContentView(linearLayout);
  }

  /**
   * Set the window layout according to the settings in the specified
   * layout XML file.  Then apply the full screen option according to
   * the player preference setting.
   * <p>Note that the title bar is not desired for the scrolling
   * credits, and requesting that the title bar be removed <b>must</b>
   * be applied before setting the view content by applying the XML
   * layout or it will generate an exception.
   * @param layoutResID - The resource ID of the XML layout to use for
   * the window layout settings.
   */
  private void setWindowLayout(int layoutResID) {
    final int flagFs   = WindowManager.LayoutParams.FLAG_FULLSCREEN;
    final int flagNoFs = WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN;

    // Remove the title bar.
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    // Load and apply the specified XML layout.
    setContentView(layoutResID);
    // Set full screen mode based on the game preferences.
    SharedPreferences mConfig =
      getSharedPreferences(FrozenBubble.PREFS_NAME, Context.MODE_PRIVATE);
    boolean fullscreen = mConfig.getBoolean("fullscreen", true);

    if (fullscreen) {
      getWindow().addFlags(flagFs);
      getWindow().clearFlags(flagNoFs);
    }
    else {
      getWindow().clearFlags(flagFs);
      getWindow().addFlags(flagNoFs);
    }
  }

  public boolean checkCreditsDone() {
    if (!credits.isScrolling()) {
      end();
      return true;
    }
    return false;
  }

  public void cleanUp() {
    if (myModPlayer != null) {
      myModPlayer.destroyMusicPlayer();
      myModPlayer = null;
    }
  }

  public void end() {
    credits.abort();
    /*
     * Since the default game activity creates its own player,
     * destroy the current player.
     */
    cleanUp();
    /*
     * Create an intent to launch the game activity.  Since it was
     * running in the background while this activity was running, it
     * may have been stopped by the system.
     */
    Intent intent = new Intent(this, FrozenBubble.class);
    startActivity(intent);
    finish();
  }

  public void pauseCredits() {
    if (myModPlayer != null)
      myModPlayer.pausePlay();
    credits.setPaused(true);
  }

  public void resumeCredits() {
    if (myModPlayer != null)
      myModPlayer.unPausePlay();
    credits.setPaused(false);
  }

  @Override
  public void run() {
    /*
     * Check if we need to display the end of game victory image.
     */
    if (!credits.isScrolling() && !victoryScreenShown) {
      victoryScreenShown = true;
      // Make the credits text transparent.
      credits.setTextColor(Color.TRANSPARENT);
      // Display the end of game victory image.
      displayImage(R.drawable.victory);
    }
    credits.postDelayed(this, 100);
  }
}
