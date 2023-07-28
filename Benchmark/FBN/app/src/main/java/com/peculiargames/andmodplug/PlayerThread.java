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

//
// This class is for a separate thread to control the modplug player,
// getting commands from the Activity.
//
// TODO:  Needs more error checking - I ignore the minbuffer size when
//        getting the audio track, LoadMODData() may fail, etc.
//
// Typical call order:
//
// PlayerThreadOLD() - to get player instance (in top most activity
//                     that will use music)
// LoadMODData()     - to call libmodplug's Load() function with the
//                     MOD data
// or
// PlayerThreadOLD(moddatabuffer) - to get player instance and load
//                                  data in one call
// then
// start()
//
// Then when changing songs (i.e. new game level or transition to
// another sub-activity, etc.) 
//
// PausePlay()
// UnLoadMod()
// LoadMODData(newmodfiledata)
// UnPausePlay()
// repeat...
//
// *NOTE*
// This class assumes there's only one player thread for a whole
// application (all activities) thus the static lock objects (mPVlock,
// mRDlock) below, and lots of other probably bad coding practice
// below... :-(  
//
// For a multi-Activity application, you can try the TakeOwnership()
// and GiveUpOwnership() calls, e.g. TakeOwnership(this) in an
// Activity's OnCreate(), and then GiveUpOwnership(this) in onPause().
//
//

package com.peculiargames.andmodplug;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.util.Log;

/**
 * Player class for MOD/XM song files (extends Java Thread). Has
 * methods to load song file data, play the song, get information about
 * the song, pause, unpause, etc.
 * <p><b>Typical call order:</b>
 * <br><code>// get player instance (in topmost activity, etc.)
 * <br>pt = PlayerThread();
 * <br>pt.loadModuleData();  // load MOD/XM data into player</code>
 * <br><b>or:</b><br>
 * <code>// get player & load data in one call
 * <br>pt = PlayerThread(modDataBuffer);</code>
 * <br><b>then:</b><br>
 * <code>pt.start();  // start thread (playing song)</code><br>
 * <b>To play a different song:</b> 
 * <br><code>// changing songs...
 * <br>pt.pausePlay();
 * <br>pt.unLoadMod();
 * <br>pt.loadModuleData(newModFileData);
 * <br>pt.unPausePlay();
 * <br>// repeat...</code>
 * @version 1.0
 * @author P.A. Casey (crow) Peculiar-Games.com
 * @author Eric Fortin
 *
 */
public class PlayerThread extends Thread {

  public  final static String VERS      = "1.0";
  private final static String LOGPREFIX = "PLAYERTHREAD";

  /*
   * Constant for <code>setPatternLoopRange()</code> calls - change to
   * new pattern range immediately.
   */
  public final static int PATTERN_CHANGE_IMMEDIATE = 1;

  /*
   * Constant for <code>setPatternLoopRange()</code> calls - change to
   * new pattern range after currently playing pattern finishes.
   */
  public final static int PATTERN_CHANGE_AFTER_CURRENT = 2;

  /*
   * Constant for <code>setPatternLoopRange()</code> calls - change to
   * new pattern range after current range of patterns finishes playing.
   */
  public final static int PATTERN_CHANGE_AFTER_GROUP = 3;

  /*
   * Constant for <code>setLoopCount()</code> calls - loop song forever.
   */
  public final static int LOOP_SONG_FOREVER = -1;

  /*
   * Limit volume volume steps to 8 steps (just an arbitrary decision).
   * There's also a setVolume() method that accepts a float.
   */
  public final static float[] sVolume_floats = {0.0f, 0.125f, 0.25f, 0.375f,
                                                0.5f, 0.625f, 0.75f, 1.0f};

  /*
   * Object for lock on ReadData call (to prevent UI thread messing
   * with player thread's GetSoundData() calls).
   */
  private Object sRDlock;

  /*
   * Private audio playback control flags.
   */
  private boolean mFlushed   = false;
  private boolean mPaused    = false;
  private boolean mPausedWas = false;
  private boolean mRunning   = true;

  /*
   * Android will report the minimum buffer size needed to keep playing
   * audio at our requested rate smoothly.
   */
  private int mMinbuffer;
  private int mModsize;  // holds the size in bytes of the MOD file
  private final static int BUFFERSIZE = 20000;  // the sample buffer size
  private AudioTrack mMyTrack;
  private boolean mLoadOk;

  /*
   * Variables for storing info about the MOD file currently loaded.
   */
  private String  mModname;
  private int     mNumChannels;
  private int     mRate;
  private int     posWas;
  private boolean songFinished;
  private boolean songFinishedWas;

  /*
   * Track if player has started (after loading a new MOD).
   */
  private boolean playerStarted;

  /*
   * Start the player in a paused state?
   */
  private boolean startPaused;

  /*
   * Audio sampling rate definitions.
   */
  private static final int NUM_RATES = 5;
  private final int[] try_rates = {44100, 32000, 22000, 16000, 8000};

  /*
   * Static initializer block.  This block is executed if a static
   * PlayerThread field is accessed, even without prior instantiation
   * of a PlayerThread object. 
   */
  static {
    try {
      System.loadLibrary("modplug-"+VERS);
      //System.loadLibrary("modplug");
    } catch (UnsatisfiedLinkError ule) {
      Log.e(LOGPREFIX, "WARNING: Could not load libmodplug-"+VERS+".so");
      Log.e(LOGPREFIX, "------ older or differently named libmodplug???");
    }
  }

  //********************************************************************
  // Listener interface for various events
  //********************************************************************

  /*
   * Event types enumeration.
   */
  public static enum eventEnum {
    PLAYER_STARTED,
    PATTERN_CHANGE,
    SONG_COMPLETED;
  }

  /**
   * Music player event listener set.
   * @author P.A. Casey (crow) Peculiar-Games.com
   *
   */
  public interface PlayerListener {
    public abstract void onPlayerEvent(eventEnum event);
  }

  private PlayerListener mPlayerListener = null;

  public void setPlayerListener(PlayerListener pl) {
    mPlayerListener = pl;
  }

  /*
   * Here's (one of) the constructor(s) - grabs an audio track and loads
   * a MOD file.
   *
   * MOD file data has already been read in (using a FileStream) by the
   * caller -- that functionality could probably be included here, but
   * for now we'll do it this way.
   *
   * You could use this in the top parent activity (like a game menu)
   * to create a PlayerThread and load the MOD data in one call.
   */

  /**
   * Allocates a MOD/XM/etc. song PlayerThread  
   * <p>The modData argument is a byte[] array with the MOD file
   * preloaded into it. The desiredRate argument is a specifier that
   * attempts to set the rate audio data will play at - will be
   * overridden if the OS doesn't allow that rate. 
   * @param modData - A byte[] array containing the MOD file data.
   * @param desiredRate - Rate of playback (e.g. 44100Hz, or 0 for
   * default rate) for system audio data playback.
   */
  public PlayerThread(byte[] modData, int desiredRate) {
    /*
     * Just call the regular constructor and then load in the supplied
     * MOD file data.
     */
    this(desiredRate);

    /*
     * Load the module file (data) into libmodplug and initialize module
     * information variables.
     */
    loadModuleInfo(modData);
  }

  /**
   * Allocates a MOD/XM/etc. song PlayerThread.  This method just gets
   * an audio track. The MOD file will be loaded later with a call to
   * LoadMODData().
   * <p>The desiredRate argument is a specifier that attempts to set the
   * rate audio data will play at - will be overridden if the OS doesn't
   * allow that rate.
   * <p>General call order when using this constructor is:
   * <br><code>pt = new PlayerThread(0);
   * <br>pt.loadModuleData(modData);
   * <br>pt.start();</code>
   * @param desiredRate - Rate of playback (e.g. 44100Hz, or 0 for
   * default rate) for system audio data playback.
   */
  public PlayerThread(int desiredRate) {
    /*
     * No Activity owns this player yet.
     */
    mMyTrack      = null;
    startPaused   = false;
    playerStarted = false;

    /*
     * Get lock object for synchronizing access to GetSoundData() call.
     */
    sRDlock = new Object();

    /*
     * Try to get the audio track.
     */
    if (!getAndroidAudioTrack(desiredRate)) {
      return;
    }
  }

  /**
   * Determine when a song has played to completion.  This method also
   * detects when a looping track has started over from the beginning.
   */
  private void checkSongCompleted() {
    int posNow = getCurrentPos();

    if ((posNow >= posWas) && (posNow < getMaxPos())) {
      songFinished = false;
    }

    if (!songFinished && ((posNow < posWas) || (posNow >= getMaxPos()))) {
      songFinished = true;
    }

    posWas = posNow;
  }

  private void cleanUp() {
    mModname = null;
    sRDlock  = null;
    /*
     * Release the audio track resources.
     */
    if (mMyTrack != null)
    {
      mMyTrack.release();
      mMyTrack = null;
    }
  }

  /**
   * Close the native internal tracker library (libmodplug) and
   * deallocate any resources.
   */
  public void closeLibModPlug() {
    ModPlug_JUnload();
    ModPlug_CloseDown();
  }

  /**
   * Try to get an Android stereo audio track used by the various
   * constructors.
   */
  private boolean getAndroidAudioTrack(int desiredRate) {
    int rateIndex = 0;

    /*
     * Get a stereo audio track from Android.
     *
     * PACKETSIZE is the amount of data we request from libmodplug,
     * minbuffer is the size Android tells us is necessary to play
     * smoothly for the rate, configuration we want and is a separate
     * buffer the OS handles.
     *
     * Init the track and player for the desired rate, or if none
     * specified, highest possible.
     */
    if (desiredRate == 0) {
      boolean success = false;
      while (!success && (rateIndex < NUM_RATES)) {
        try {
          mMinbuffer = AudioTrack.getMinBufferSize(try_rates[rateIndex],
            AudioFormat.CHANNEL_OUT_STEREO,
            AudioFormat.ENCODING_PCM_16BIT);
          mMyTrack = new AudioTrack(AudioManager.STREAM_MUSIC,
                                    try_rates[rateIndex],
                                    AudioFormat.CHANNEL_OUT_STEREO,
                                    AudioFormat.ENCODING_PCM_16BIT,
                                    mMinbuffer, AudioTrack.MODE_STREAM);
          /*
           * Init the Modplug player for this sample rate.
           */
          ModPlug_Init(try_rates[rateIndex]);
          success = true;
        } catch (IllegalArgumentException e) {
          rateIndex++;
        }
      }
    }
    else {
      mMinbuffer = AudioTrack.getMinBufferSize(desiredRate,
        AudioFormat.CHANNEL_OUT_STEREO,
        AudioFormat.ENCODING_PCM_16BIT);
      mMyTrack = new AudioTrack(AudioManager.STREAM_MUSIC, desiredRate,
                                AudioFormat.CHANNEL_OUT_STEREO,
                                AudioFormat.ENCODING_PCM_16BIT,
                                mMinbuffer, AudioTrack.MODE_STREAM);
      /*
       * Init the Modplug player for this sample rate.
       */
      ModPlug_Init(desiredRate);
    }

    if (desiredRate == 0) {
      if (rateIndex < NUM_RATES) {
        mRate = try_rates[rateIndex];
      }
      else {
        mMyTrack = null;
        mRate    = 0;
      }
    }
    else {
      mRate = desiredRate;
    }

    if (mMyTrack == null) {
      /*
       * Couldn't get an audio track so return false to caller.
       */
      return false;
    }
    else {
      /*
       * An audio track was successfully created, so check if the
       * appropriate resources were acquired for audio streaming.  If
       * not, then attempt to re-create the audio track one more time.
       */
      switch(mMyTrack.getState()) {
        case AudioTrack.STATE_INITIALIZED:
           break;
        default:
          mMyTrack = new AudioTrack(AudioManager.STREAM_MUSIC, mRate,
                                    AudioFormat.CHANNEL_OUT_STEREO,
                                    AudioFormat.ENCODING_PCM_16BIT,
                                    mMinbuffer*2, AudioTrack.MODE_STREAM);
          break;
      }
    }
    /*
     * Got the audio track!
     */
    return true;
  }

  /**
   * Loads MOD/XM,etc. song data for playback.  Call
   * <code>pausePlay()</code> if a song is currently playing prior to
   * invoking this method.
   * <p>The modData argument is a byte[] array with the MOD containing
   * the song file data.
   * <p>Example of loading the data:<br><code>
   * modfileInStream = getResources().openRawResource(R.raw.coolxmsong);
   * <br>try {<br>
   * modsize = modfileInStream.read(modData,0,
   * modfileInStream.available());
   * <br>} catch (IOException e) {
   * <br>e.printStackTrace();
   * <br>}</code>
   * @param modData - A byte[] array containing the MOD file data.
   */
  public void loadModuleData(byte[] modData) {
    unLoadMod();

    /*
     * Load the module file (data) into libmodplug and initialize module
     * information variables.
     */
    loadModuleInfo(modData);

    /*
     * Re-init this flag so that an event will be passed to the
     * PlayerListener after the first write() to the AudioTrack - when
     * I assume music will actually start playing...
     */
    synchronized(this) {
      playerStarted = false;
    }
  }

  /**
   * Load the module file (data) into libmodplug.
   * <p>If the module loads successfully, initialize module info (name
   * and number of tracks, track playback location, etc.).
   */
  private void loadModuleInfo(byte[] modData) {
    mLoadOk = ModPlug_JLoad(modData, modData.length);

    if (mLoadOk) {
      mModname        = ModPlug_JGetName();
      mNumChannels    = ModPlug_JNumChannels();
      posWas          = 0;
      songFinished    = false;
      songFinishedWas = false;
    }
  }

  /*
   * MOD file info retrieval methods.
   */

  /**
   * Get the name of the song.
   * @return the name of the song (from the MOD/XM file header)
   */
  public String getModName() {
    return mModname;
  }

  /**
   * Get the file size of the MOD/XM song.
   * @return the size of the song file
   */
  public int getModSize() {
    return mModsize;
  }

  /**
   * Get the number of channels used in the song (MOD/XM songs
   * typically use from 4 to 32 channels in a pattern, mixed together
   * for awesomeness).
   * @return the number of channels the song uses
   */
  public int getNumChannels() {
    return mNumChannels;
  }

  public int getRate() {
    return mRate;
  }

  /**
   * Pauses playback of the current song.
   * @param immediate - if <code>true</code>, <code>pause()</code> then
   * <code>flush()</code> the audio stream to immediately stop audio
   * playback, otherwise simply <code>stop()</code> the audio stream
   * which continues playing until the last buffer written has been
   * played to completion. 
   * @return <code>true</code> if the song was successfully paused.
   */
  public boolean pausePlay(boolean immediate) {
    boolean paused = false;

    /*
     * Set the control flags to stop playback and suspend the thread.
     */
    mPaused    = true;
    mPausedWas = true;

    if (mMyTrack != null)
    {
      /*
       * This check is usually not needed before stopping the audio
       * track, but we seem to get an uninitialized audio track here
       * occasionally, which throws an IllegalStateException.
       */
      if (mMyTrack.getState() == AudioTrack.STATE_INITIALIZED) try {
        if (immediate) {
          mMyTrack.pause();
          if (mMyTrack != null) {
            mMyTrack.flush();
            mFlushed = true;
          }
        }
        else {
          mMyTrack.stop();
        }
        paused = true;
      } catch (NullPointerException npe) {
        /*
         * mMyTrack may be destroyed in a different process, so the
         * slim possibility exists that we may invoke it when it has
         * been nullified.
         */
      } catch (IllegalStateException ise) {
        /*
         * Nothing to do here, so just try to continue gracefully.
         */
      }
    }

    return paused;
  }

  /**
   * The thread's run() call, where the modules are played.
   * <p>Start playing the MOD/XM song (hopefully it's been previously
   * loaded using <code>loadModuleData()</code> or
   * <code>loadModuleResource()</code> ;)
   */
  public void run() {
    boolean patternChange = false;
    /*
     * Set up our audio sample buffer(libmodplug processes the MOD file
     * and fills this with sample data).
     *
     * For proper error checking, this should check that BUFFERSIZE is
     * greater than the minbuffer size the audio system reports in the
     * contructors...
     */
    short[] mBuffer;
    try {
      mBuffer = new short[BUFFERSIZE];
    } catch (OutOfMemoryError oome) {
      // Auto-generated catch block.
      oome.printStackTrace();
      mBuffer = null;
    }

    if (startPaused) {
      mPaused    = true;
      mPausedWas = true;
    }
    else {
      mPaused    = false;
      mPausedWas = false;
    }

    if ((mMyTrack != null) && (mBuffer != null)) {
      boolean startedPlaying = false;
      while (mRunning && !startedPlaying) {
        try {
          mMyTrack.play();
          startedPlaying = true;
        } catch (IllegalStateException ise) {
          /*
           * The audio track isn't initialized yet.  Wait a short
           * duration, then try again.
           */
          startedPlaying = false;
          synchronized(this) {
            try {
              sleep(20);
            } catch (InterruptedException ie) {
              /*
               * This is expected behavior.
               */
            }
          }
        }
      }
    }
    else {
      mRunning = false;
    }

    /*
     * Main play loop.
     */
    while (mRunning) {
      while (!mPaused) {
        /*
         * To prevent unwanted playback of prior audio track buffer
         * data, only unpause the audio track after sufficient time has
         * elapsed to permit the audio stream to flush the previous
         * audio stream buffer if the audio track was flushed.  Thus
         * playback is resumed here where the audio track control timing
         * is managed correctly.
         */
        if (mRunning && !mPaused && mPausedWas) {
          mPausedWas = false;
          if (mFlushed) {
            try {
              sleep(200);
            } catch (InterruptedException ie) {
              /*
               * This is expected behavior.
               */
            }
          }
          mFlushed = false;
          unPause();
        }

        /*
         * Pre-load another packet.
         */
        synchronized(sRDlock) {
          if (mRunning && !mPaused && mLoadOk) {
            ModPlug_JGetSoundData(mBuffer, BUFFERSIZE);
  
            if (ModPlug_CheckPatternChange()) {
              patternChange = true;
            }

            checkSongCompleted();
          }
        }

        /*
         * Pass a packet of sound sample data to the audio track
         * (blocks until audio track can accept the new data).
         */
        if (mRunning && !mPaused) {
          mMyTrack.write(mBuffer, 0, BUFFERSIZE);
        }

        /*
         * Send player events.
         */
        synchronized(this) {
          if (!playerStarted) {
            playerStarted = true;
            if (mPlayerListener != null) {
              mPlayerListener.onPlayerEvent(eventEnum.PLAYER_STARTED);
            }
          }

          if (patternChange) {
            patternChange = false;
            if (mPlayerListener != null) {
              mPlayerListener.onPlayerEvent(eventEnum.PATTERN_CHANGE);
            }
          }

          if (songFinished && !songFinishedWas) {
            if (mPlayerListener != null) {
              mPlayerListener.onPlayerEvent(eventEnum.SONG_COMPLETED);
            }
          }
          songFinishedWas = songFinished;
        }
      }

      /*
       * Wait until notify() is called.
       */
      synchronized(this) {
        if (mRunning && mPaused) {
          try {
            wait();
          } catch (InterruptedException ie) {
            /*
             * This is expected behavior.
             */
          }
        }
      }
    }

    cleanUp();
  }

  /**
   * Set the file size of the MOD/XM song.
   */
  public void setModSize(int modsize) {
    mModsize = modsize;
  }

  /**
   * Sets playback volume for the MOD/XM player.
   * @param vol - An integer from 0 (sound off) to 255 (full volume).
   */
  public void setVolume(int vol) {
    vol = vol>>5;
    if (vol>7) vol = 7;
    if (vol<0) vol = 0;
    mMyTrack.setStereoVolume(sVolume_floats[vol], sVolume_floats[vol]);
  }

  /**
   * Sets playback volume for the MOD/XM player.
   * @param vol - A floating point number from 0.0f (sound off) to 1.0f
   * (full volume).
   */
  public void setVolume(float vol) {
    if (vol>1.0f) vol = 1.0f;
    if (vol<0) vol = 0;
    mMyTrack.setStereoVolume(vol, vol);
  }

  /**
   * This method sets the player startup mode.
   * @param flag - If this is set to true, then the player will start up
   * paused and will have to be unpaused to start playing.  If this is
   * set to false, then the player will immediately begin playing when
   * it is started.
   */
  public void startPaused(boolean flag) {
    /*
     * Set before calling the thread's start() method.  This will cause
     * it to start in paused mode.
     */
    startPaused = flag;
  }

  /**
   * This stops the current song if it is playing, and stops the thread.
   * <p>Typically the player should then be <code>join()</code>ed to
   * completely remove the thread from the application's Android
   * process, and also call <code>closeLibModPlug()</code> to close
   * the native player library and de-allocate all resources it used.
   */
  public void stopThread() {
    /*
     * Music playback must be paused before stopping the thread.  Force
     * a flush of the audio data to immediately stop audio playback.
     */
    pausePlay(true);

    /*
     * Stops the music player thread (see run() above).
     */
    mRunning = false;

    /*
     * Interrupt the thread if it is sleeping or waiting.
     */
    synchronized(this) {
      this.interrupt();
    }
  }

  /**
   * Unload the current MOD from libmodplug, but make sure to wait
   * until any <code>GetSoundData()</code> call in the player thread has
   * finished.  <p>Unload MOD/XM data previously loaded into the native
   * player library.
   */
  public void unLoadMod() {
    /*
     * Since this can/will be called from the UI thread, need to synch
     * and not have a call into libmodplug unloading the file, while a
     * call to GetModData() is also executing in the player thread (see
     * run() above).
     */
    synchronized(sRDlock) {
      mLoadOk = false;
      ModPlug_JUnload();
    }
  }

  /**
   * Resumes playback of the current song.
   * @return <code>true</code> if the song was successfully unpaused.
   */
  private boolean unPause() {
    boolean unPaused = false;
    if (mMyTrack != null)
    {
      try {
        mMyTrack.play();
        unPaused = true;
      } catch (IllegalStateException ise) {
        /*
         * This is a spurious exception, with the only drawback being
         * that audio will remain stopped.  Nothing to do here but
         * continue gracefully and wait for the next attempt.
         */
      }
    }
    return unPaused;
  }

  /**
   * Resumes playback of the current song.
   */
  public void unPausePlay() {
    mPaused = false;

    synchronized(this) {
      this.notify();
    }
  }

  /**
   * EXPERIMENTAL: Change patterns in a song (playing in PATTERN LOOP
   * mode). Waits for the currently playing pattern to finish.
   * @param newpattern - The new song pattern to start playing
   * (repeating) in PATTERN LOOP mode.
   */
  public void changePattern(int newpattern) {
    ModPlug_ChangePattern(newpattern);
  }

  /**
   * EXPERIMENTAL: Get the current order
   * @return the order.
   */
  public int getCurrentOrder() {
    return ModPlug_GetCurrentOrder();
  }

  /**
   * EXPERIMENTAL: Get the current pattern
   * @return the pattern.
   */
  public int getCurrentPattern() {
    return ModPlug_GetCurrentPattern();
  }

  /**
   * EXPERIMENTAL: Get the current "position" in song
   * @return the position.
   */
  public int getCurrentPos() {
    return ModPlug_GetCurrentPos();
  }

  /**
   * EXPERIMENTAL: Get the current row in the pattern
   * @return the row.
   */
  public int getCurrentRow() {
    return ModPlug_GetCurrentRow();
  }

  /**
   * EXPERIMENTAL: Get the maximum "position" in song
   * @return the maximum position.
   */
  public int getMaxPos() {
    return ModPlug_GetMaxPos();
  }

  /**
   * EXPERIMENTAL: Get the default tempo from the song's header.
   * @return the tempo.
   */
  public int getSongDefaultTempo() {
    return ModPlug_GetNativeTempo();
  }

  /**
   * EXPERIMENTAL: Modify the song's tempo (+ or -) by <code>mt</code>.
   * @param mt - Modifier for the song's "native" tempo (positive values
   * to increase tempo, negative values to decrease tempo).
   */
  public void modifyTempo(int mt) {
    ModPlug_ChangeTempo(mt);
  }

  /**
   * EXPERIMENTAL: Change song to PATTERN LOOP mode, repeating
   * <code>pattern</code>.
   * @param pattern - The song pattern to start playing(repeating) in
   * PATTERN LOOP mode.
   */
  public void repeatPattern(int pattern) {
    ModPlug_RepeatPattern(pattern);
  }

  /**
   * EXPERIMENTAL: set the current pattern (pattern is changed but
   * plays from current row in pattern).
   * @param pattern - The new pattern to start playing immediately.
   */
  public void setCurrentPattern(int pattern) {
    ModPlug_SetCurrentPattern(pattern);
  }

  /**
   * EXPERIMENTAL: Set log printing flag.
   * @param flag - <code>true</code> to start printing debug information
   * to log output, <code>false</code> to stop.
   */
  public void setLogOutput(boolean flag) {
    ModPlug_LogOutput(flag);
  }

  /**
   * EXPERIMENTAL method to loop song the specified number of times.
   * @param number - The number of times to loop (-1 = forever).
   */
  public void setLoopCount(int loopcount) {
    ModPlug_SetLoopCount(loopcount);
  }

  /**
   * EXPERIMENTAL: set the next pattern to play after current pattern
   * finishes.
   * @param pattern - The new pattern to start playing after the current
   * pattern finishes playing.
   */
  public void setNextPattern(int pattern) {
    ModPlug_SetNextPattern(pattern);
  }

  /**
   * EXPERIMENTAL method to set song to PATTERN LOOP mode, repeating
   * any pattern playing or subsequently set via
   * <code>changePattern()</code>.
   * @param flag - <code>true</code> to set PATTERN LOOP mode,
   * <code>false</code> to turn off PATTERN LOOP mode.
   */
  public void setPatternLoopMode(boolean flag) {
    ModPlug_SetPatternLoopMode(flag);
  }

  /**
   * EXPERIMENTAL method to loop song in a group of patterns.
   * @param from - Start of pattern range to play in loop.
   * @param to - End of pattern range to play in loop.
   * @param when - A constant flag (PATTERN_CHANGE_IMMEDIATE,
   * PATTERN_CHANGE_AFTER_CURRENT, PATTERN_CHANGE_AFTER_GROUP) to signal
   * when the new pattern range should take effect.
   */
  public void setPatternLoopRange(int from, int to, int when) {
    ModPlug_SetPatternLoopRange(from, to, when);
  }

  /**
   * EXPERIMENTAL: Set the song's tempo to <code>tempo</code>.
   * @param tempo - The tempo for the song (overrides song's "native"
   * tempo).
   */
  public void setTempo(int tempo) {
    ModPlug_SetTempo(tempo);
  }

  /*
   * Native methods in our JNI libmodplug stub code.
   */
  public native boolean ModPlug_CloseDown();
  public native boolean ModPlug_Init(int rate);
  public native String  ModPlug_JGetName();
  public native int     ModPlug_JGetSoundData(short[] sndbuffer, int datasize);
  public native boolean ModPlug_JLoad(byte[] buffer, int size);
  public native int     ModPlug_JNumChannels();
  public native boolean ModPlug_JUnload();

  /*
   * HACKS ;-).
   */
  public native void ModPlug_ChangeTempo(int tempotweak);
  public native void ModPlug_ChangePattern(int newpattern);
  public native void ModPlug_RepeatPattern(int pattern);
  public native void ModPlug_SetCurrentPattern(int pattern);
  public native void ModPlug_SetLoopCount(int loopcount);
  public native void ModPlug_SetNextPattern(int pattern);
  public native void ModPlug_SetPatternLoopMode(boolean flag);
  public native void ModPlug_SetPatternLoopRange(int from, int to, int when);
  public native void ModPlug_SetTempo(int tempo); 

  /*
   * More info.
   */
  public native boolean ModPlug_CheckPatternChange();
  public native int     ModPlug_GetCurrentOrder();
  public native int     ModPlug_GetCurrentPattern();
  public native int     ModPlug_GetCurrentPos();
  public native int     ModPlug_GetCurrentRow();
  public native int     ModPlug_GetMaxPos();
  public native int     ModPlug_GetNativeTempo();

  /*
   * Log output.
   */
  public native void ModPlug_LogOutput(boolean flag);
}
