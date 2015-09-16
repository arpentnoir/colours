package com.richardspellman.colours.util;

import com.badlogic.gdx.Gdx;

/**
 * Created by richardspellman on 31/07/15.
 */
public class Constants {

  // Colours for circles
  public enum COLOUR{RED, BLUE, GREEN, CYAN, MAGENTA, YELLOW, WHITE}

  // GUI Height
  public static final float VIEWPORT_GUI_HEIGHT = Gdx.graphics.getHeight();
  // GUI width
  public static final float VIEWPORT_GUI_WIDTH = Gdx.graphics.getWidth();

  // Visible game world is 16 meters tall
  public static final float VIEWPORT_HEIGHT = 16f;

  // pixels in one meter
  public static final float PIXELS_TO_METERS = VIEWPORT_GUI_HEIGHT / VIEWPORT_HEIGHT;

  // Visible game world is 10 meters wide
  public static final float VIEWPORT_WIDTH = VIEWPORT_GUI_WIDTH / PIXELS_TO_METERS;

  // Location of description file for texture atlas
  public static final String TEXTURE_ATLAS_OBJECTS = "images/assets.pack";

  public static final String TEXTURE_ATLAS_MENU = "images/menu.pack";

  // Location of image file for level 01
  public static final String LEVEL_01 = "levels/level1.xml";

  // Amount of extra lives at level start
  public static final int LIVES_START = 3;

}