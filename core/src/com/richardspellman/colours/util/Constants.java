package com.richardspellman.colours.util;

/**
 * Created by richardspellman on 31/07/15.
 */
public class Constants {

  // Colours for circles
  public enum COLOUR{RED, BLUE, GREEN, CYAN, MAGENTA, YELLOW, WHITE}

  // Visible game world is 10 meters wide
  public static final float VIEWPORT_WIDTH = 9f;

  // Visible game world is 6 meters tall
  public static final float VIEWPORT_HEIGHT = 16f;

  // GUI width
  public static final float VIEWPORT_GUI_WIDTH = 540.0f;

  // GUI Height
  public static final float VIEWPORT_GUI_HEIGHT = 960.0f;

  // Location of description file for texture atlas
  public static final String TEXTURE_ATLAS_OBJECTS = "images/circles.pack";

  // Location of image file for level 01
  public static final String LEVEL_01 = "levels/level1.xml";

  // Amount of extra lives at level start
  public static final int LIVES_START = 3;

}