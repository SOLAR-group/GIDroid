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

import android.content.Context;

import com.peculiargames.andmodplug.MODResourcePlayer;
import com.peculiargames.andmodplug.PlayerThread.PlayerListener;

public class ModPlayer {
  private MODResourcePlayer resPlayer = null;

  public ModPlayer(Context context,
                   int songId,
                   int loopCount,
                   boolean musicOn,
                   boolean startPaused) {
    newMusicPlayer(context, songId, loopCount, musicOn, startPaused);
  }

  /**
   * Stop the music player, close the thread, and free the instance.
   */
  public void destroyMusicPlayer() {
    synchronized(this) {
      if (resPlayer != null) {
        resPlayer.stopAndClose();
        resPlayer = null;
      }
    }
  }

  /**
   * Load a new song.
   * @param songId - The song resource ID.
   * @param startPlaying - If <code>true</code>, the song starts playing
   * immediately.  Otherwise it is paused and must be unpaused to start
   * playing.
   */
  public void loadNewSong(int songId, boolean startPlaying) {
    if (resPlayer != null) {
      // Pause the current song.
      resPlayer.pausePlay(true);
      // Load the current MOD into the player.
      resPlayer.loadModuleResource(songId);
      if (startPlaying)
        resPlayer.unPausePlay();
    }
  }

  /**
   * Create a new music player.
   * @param context - The application context.
   * @param songId - The song resource ID.
   * @param loopCount - The number of times to replay the song.  Use
   * <code>PlayerThread.LOOP_SONG_FOREVER</code> to loop the song
   * forever, and 0 to only play once, 1 to play twice, etc.
   * @param startPaused - If <code>false</code>, the song starts playing
   * immediately.  Otherwise it is paused and must be unpaused to start
   * playing.
   */
  private void newMusicPlayer(Context context,
                              int songId,
                              int loopCount,
                              boolean musicOn,
                              boolean startPaused) {
    // Create a new music player.
    resPlayer = new MODResourcePlayer(context);
    // Load the MOD file.
    resPlayer.loadModuleResource(songId);
    // Loop the song forever.
    resPlayer.setLoopCount(loopCount);
    // Turn the music on or off.
    setMusicOn(musicOn);
    // Start the music thread.
    resPlayer.startPaused(startPaused);
    resPlayer.start();
  }

  public void pausePlay() {
    if (resPlayer != null)
      resPlayer.pausePlay(false);
  }

  public void setMusicOn(boolean musicOn) {
    if (musicOn) {
      resPlayer.setVolume(255);
    }
    else {
      resPlayer.setVolume(0);
    }
  }

  public void setPlayerListener(PlayerListener pl) {
    if (resPlayer != null) {
      resPlayer.setPlayerListener(pl);
    }
  }

  public void unPausePlay() {
    if (resPlayer != null)
      resPlayer.unPausePlay();
  }
}
