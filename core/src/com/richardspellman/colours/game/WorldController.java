package com.richardspellman.colours.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.TimeUtils;
import com.richardspellman.colours.game.objects.Circle;
import com.richardspellman.colours.game.objects.Column;
import com.richardspellman.colours.game.screens.MenuScreen;
import com.richardspellman.colours.util.CameraHelper;
import com.richardspellman.colours.util.Constants;

import java.util.ArrayList;


/**
 * Created by richardspellman on 31/07/15.
 */

public class WorldController extends InputAdapter {

  public CameraHelper cameraHelper;
  public Level level;
  public int score;
  private Game game;
  public World world;
  private Circle selectedCircle;
  private Column selectedColumn;
  private float deltaX;
  private float deltaY;
  private float startX;
  private float startY;
  private boolean animate;



  private static final String TAG = WorldController.class.getName();

  public WorldController(Game game){
    this.game = game;
    init();
  }

  private void init(){
    Gdx.input.setInputProcessor(this);
    cameraHelper = new CameraHelper();
    initLevel();
    animate = false;


  }


  private void initLevel(){
    score = 0;
    level = new Level(Constants.LEVEL_01);

  }

  public void update (float deltaTime) {
    handleDebugInput(deltaTime);
    handleInputGame(deltaTime);
    if(!animate) level.update(deltaTime);
    if(level.time < 0){
      game.setScreen(new MenuScreen(game));
    }
    //cameraHelper.update(deltaTime);

  }

  private void handleDebugInput(float deltaTime) {

  }

  @Override
  public boolean touchDown(int x, int y, int pointer, int button){
    if(y < 100) {
      game.setScreen(new MenuScreen(game));
    }
    if(!animate && selectedCircle == null && pointer == 0) {
      float X = (x - (Gdx.graphics.getWidth() / 2)) / Constants.PIXELS_TO_METERS;
      float Y = (y - (Gdx.graphics.getHeight() / 2)) / Constants.PIXELS_TO_METERS;
      for (int i = 0; i < level.columns.length; i++) {

        for (int j = 0; j < level.columns[i].circles.size(); j++) {
          Circle c = level.columns[i].circles.get(j);
          Vector2 centre = new Vector2(c.getPosition().x + 0.5f, c.getPosition().y + 0.5f);
          if (centre.dst(X, Y) < 0.5) {
            selectedCircle = c;
            selectedColumn = level.columns[i];
            c.isSelected = true;
            // used to keep relationship to mouse cursor when moving
            deltaX = X - c.getPosition().x;
            deltaY = Y - c.getPosition().y;

            // used to snap back to original position if no candidate position found
            startX = c.getPosition().x;
            startY = c.getPosition().y;
          }
        }
      }
    }
    return false;
  }

  @Override
  public boolean touchUp(int x, int y, int pointer, int button){
    if(!animate) {
      float X = (x - (Gdx.graphics.getWidth() / 2)) / Constants.PIXELS_TO_METERS;
      float Y = (y - (Gdx.graphics.getHeight() / 2)) / Constants.PIXELS_TO_METERS;
      boolean intersectionFound = false;
      if (selectedCircle != null && pointer == 0) {
        for (int i = 0; i < level.columns.length; i++) {
          for (int j = 0; j < level.columns[i].circles.size(); j++) {
            Circle c = level.columns[i].circles.get(j);
            Vector2 centre = new Vector2(c.getPosition().x + 0.5f, c.getPosition().y + 0.5f);
            if (!c.equals(selectedCircle) && centre.dst(X, Y) < 0.5) {
              intersectionFound = true;
              // make set colour return false if can't set, then know when to return
              if (c.setColour(c.colour * selectedCircle.colour)) {
                selectedColumn.remove(selectedCircle);
                break;
              } else {
                selectedCircle.setPosition(new Vector2(startX, startY));
                selectedCircle.isSelected = false;
                selectedCircle = null;
                selectedColumn = null;
                break;
              }
            }
          }
        }
        if (intersectionFound == false) {
          selectedCircle.setPosition(new Vector2(startX, startY));
          selectedCircle.isSelected = false;
          selectedCircle = null;
          selectedColumn = null;
        }
      }
      level.checkColumns();
      level.checkRows();
      try {
        animate();
      } catch (InterruptedException e){

      }
    }
    return false;
  }

  public void animate() throws InterruptedException{
    animate = true;

    for (Circle c : level.removalQueue) {
      c.isShrinking = true;
    }
    animate = false;
  }

  @Override
  public boolean touchDragged(int x, int y, int pointer){
    if(selectedCircle != null && !animate && pointer == 0){
      selectedCircle.setPosition(new Vector2((x - (Gdx.graphics.getWidth() / 2)) / Constants.PIXELS_TO_METERS - deltaX, (y - (Gdx.graphics.getHeight() / 2)) / Constants.PIXELS_TO_METERS - deltaY));
    }

    return false;
  }

  @Override
  public boolean keyUp(int keycode){
    // Reset game world
    if(keycode == Input.Keys.R){
      init();
      Gdx.app.debug(TAG, "Game world reset");
    }
    return false;
  }


  private void handleInputGame(float deltaTime){
  }

}
