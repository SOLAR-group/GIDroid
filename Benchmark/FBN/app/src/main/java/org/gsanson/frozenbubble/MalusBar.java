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

package org.gsanson.frozenbubble;

import org.jfedor.frozenbubble.BmpWrap;
import org.jfedor.frozenbubble.LevelManager;
import org.jfedor.frozenbubble.Sprite;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;

public class MalusBar extends Sprite {
  public final static int MAX_ATTACK = LevelManager.NUM_COLS - 1;

  /* X-pos for tomatoes */
  int minX;
  /* Max Y-pos for bar */
  int maxY;
  /* Number of waiting bubbles */
  int nbMalus;
  /* Time to release bubbles */
  public int releaseTime;
  /* Banana Image */
  private BmpWrap banana;
  /* Tomato Image */
  private BmpWrap tomato;
  /* Attack bubble array */
  public byte[] attackBubbles = { -1, -1, -1, -1, -1,
                                  -1, -1, -1, -1, -1,
                                  -1, -1, -1, -1, -1 };

  /**
   * Manages a malus bar (bananas & tomatoes).
   * @param coordX - X-coord of game facade.
   * @param coordY - Y-coord of game facade.
   * @param leftSide - if on left side (false => right side).
   * @param tomato - image resource for a tomato.
   * @param banana - image resource for a banana.
   */
  public MalusBar(int coordX, int coordY, BmpWrap banana, BmpWrap tomato) {
    super(new Rect(coordX, coordY, coordX + 33, coordY + 354));
    minX        = coordX;
    maxY        = coordY + 354;
    releaseTime = 0;
    setBitmaps(banana, tomato);
  }

  @Override
  public final void paint(Canvas c, double scale, int dx, int dy) {
    int count = nbMalus;
    int pos = maxY;
    while (count >= MAX_ATTACK) {
      pos -= 13;
      drawImage(tomato, minX, pos, c, scale, dx, dy);
      count -= MAX_ATTACK;
    }
    while (count > 0) {
      pos -= 11;
      drawImage(banana, minX + 3, pos, c, scale, dx, dy);
      count--;
    }
  }

  public void addBubbles(int toAdd) {
    if ((toAdd > 0) && (nbMalus == 0))
      releaseTime = 0;
    nbMalus += toAdd;
  }

  /**
   * Clear the attack bubbles stored in the attack bubble array.
   */
  public void clearAttackBubbles() {
    for (int i = 0; i < LevelManager.LANES; i++)
      this.attackBubbles[i] = -1;
  }

  public int getAttackBarBubbles() {
    return nbMalus;
  }

  public int getTypeId() {
    return Sprite.TYPE_IMAGE;
  }

  /**
   * The number of attack bubbles will be decremented by the supplied
   * number of bubbles, which is the number of attack bubbles that were
   * previously launched.
   * @param remove - the number of attack bubbles to remove from the
   * total number of attack bubbles.
   */
  public void removeAttackBubbles(int remove) {
    nbMalus -= remove;

    if (nbMalus < 0)
      nbMalus = 0;
  }

  public int removeLine() {
    int nb = Math.min(MAX_ATTACK, nbMalus);
    nbMalus -= nb;
    return nb;
  }

  public void restoreState(Bundle map, int id) {
    nbMalus     = map.getInt(String.format("%d-nbMalus", id));
    releaseTime = map.getInt(String.format("%d-releaseTime", id));
  }

  public void saveState(Bundle map, int id) {
    map.putInt(String.format("%d-nbMalus", id), nbMalus);
    map.putInt(String.format("%d-releaseTime", id), releaseTime);
  }

  /**
   * Set the value of an attack bubble color in the attack bubble array.
   * @param bubbleIndex - the update index in the attack bubble array.
   * @param bubbleColor - the attack bubble color.
   */
  public void setAttackBubble(int bubbleIndex, int bubbleColor) {
    this.attackBubbles[bubbleIndex] = (byte) bubbleColor;
  }

  /** 
   * Set the total number of attack bubbles stored in the attack bar,
   * as well as the array of current attack bubbles.
   * @param numBubbles - the total number of attack bubbles.
   * @param attackBubbles - the array of attack bubbles.
   */
  public void setAttackBubbles(int numBubbles, byte[] attackBubbles) {
    nbMalus = numBubbles;

    if (attackBubbles != null)
      for (int i = 0; i < LevelManager.LANES; i++)
        this.attackBubbles[i] = attackBubbles[i];
  }

  public void setBitmaps(BmpWrap banana, BmpWrap tomato) {
    this.banana = banana;
    this.tomato = tomato;
  }
}
