/*
 *                 [[ Frozen-Bubble ]]
 *
 * Copyright (c) 2000-2003 Guillaume Cottenceau.
 * Java sourcecode - Copyright (c) 2003 Glenn Sanson.
 * MOD player source - Copyright (c) 2011 Patrick Casey.
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

package com.peculiargames.andmodplug;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;

/**
 * Convenience class extending PlayerThread, handling all the file
 * operations, accepting Android resource IDs for MOD/XM song files.
 * <p><b>Typical call order:</b>
 * <br><code>// get player instance (in topmost activity, etc.)
 * <br>mrp = MODResourcePlayer();
 * <br>// load MOD/XM data into player
 * <br>mrp.loadModuleResource(R.raw.coolsong);
 * <br>mrp.start();  // start thread (playing song)</code>
 * <br><b>Then when changing songs (new game level or transition to
 * another sub-activity, etc.):</b> 
 * <br><code>mrp.pausePlay();
 * <br>mrp.loadModuleResource(R.raw.newcoolsong);
 * <br>mrp.unPausePlay();
 * <br>// repeat...</code>
 * @version 1.0
 * @author P.A. Casey (crow) Peculiar-Games.com
 * @author Eric Fortin
 *
 */
public class MODResourcePlayer extends PlayerThread {
  /*
   * Application context, for accessing the resources - specifically the
   * the R.raw.<filename> resources which are MOD music files.
   */
  private Context mContext;

  /**
   * Allocates a MOD/XM/etc. song Player object that can handle Android
   * resource files (typically the songs are stored in the res/raw
   * project directory and conform to Android build process rules,
   * lower-case names, etc.)
   * <p><b>Note about extensions:</b>
   * <br>Developers using Eclipse as an IDE should note that it allows
   * the .xm file extension but may be fussy about other tracker format
   * extensions.
   * <p>The <code>context</code> argument is the application context
   * which allows MODResourcePlayer to load resources directly.
   * @param context - Application context creating this instance.
   */
  public MODResourcePlayer(Context context) {
    // Get super class (PlayerThread) with default rate.
    super(0);
    mContext = context;
    // Set full volume.
    setVolume(255);
  }

  /**
   * Load a MOD/XM/etc. song file from an Android resource.
   * <p><b>Note about extensions:</b>
   * <br>Developers using Eclipse as an IDE should note that it allows
   * the .xm file extension but may be fussy about other tracker format
   * extensions.
   * <p>The <code>modResource</code> argument is the resource id for the
   * MOD/XM song file, e.g. R.raw.coolsong
   * @param modResource - Android resource ID for a MOD/XM/etc. (tracker
   * format) song file.
   */
  public boolean loadModuleResource(int modResource) {
    byte[]      modData      = null;
    int         currfilesize = 0;
    InputStream mModfileInStream;

    /*
     * Unload any MOD file we have currently loaded.
     */
    unLoadMod();

    /*
     * Get an input stream for the MOD file resource.
     */
    mModfileInStream = mContext.getResources().openRawResource(modResource);
    try {
      currfilesize = mModfileInStream.available();
    } catch (IOException ioe1) {
      try {
        mModfileInStream.close();
      } catch (IOException ioe2) {
        /*
         * Should never happen.
         */
      }
      return false;
    }

    /*
     * Allocate a buffer that can hold the current MOD file data.
     */
    try {
      modData = new byte[currfilesize];
    } catch (OutOfMemoryError oome) {
      // Auto-generated catch block.
      oome.printStackTrace();
      try {
        mModfileInStream.close();
      } catch (IOException e) {
        /*
         * Should never happen.
         */
      }
      return false;
    }

    try {
      setModSize(mModfileInStream.read(modData, 0, currfilesize));
      mModfileInStream.close();
    } catch (IOException e) {
      // Auto-generated catch block.
      e.printStackTrace();
    }

    /*
     * Load the song into the player.
     */
    loadModuleData(modData);
    return true;
  }

  /**
   * Stop playing the song, close down the player and
   * <code>join()</code> the player thread.
   * <p>Typically called in the application's main activity
   * <code>onDestroy()</code> method.
   */
  public void stopAndClose() {
    stopThread();
    /*
     * Now close and join() the MOD player thread.
     */
    boolean retry = true;
    while (retry) {
      try {
        join();
        retry = false;
      } catch (InterruptedException e) {
        /*
         * Keep trying to close the player thread.
         */
      }
    }
    closeLibModPlug();
  }
}
