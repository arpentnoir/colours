package com.richardspellman.colours.game.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.richardspellman.colours.game.models.Circle;
import com.richardspellman.colours.game.models.Column;
import com.richardspellman.colours.game.screens.MenuScreen;
import com.richardspellman.colours.util.CameraHelper;
import com.richardspellman.colours.util.Constants;

/**
 * Created by richardspellman on 21/09/15.
 */
public class GameController extends InputAdapter{
/*

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



  private static final String TAG = GameController.class.getName();

  public GameController(Game game){
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
    if(level.getTime() < 0){
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
      for (int i = 0; i < level.grid.columns.length; i++) {

        for (int j = 0; j < level.grid.columns[i].circles.size(); j++) {
          Circle c = level.grid.columns[i].circles.get(j);
          Vector2 centre = new Vector2(c.getPosition().x + 0.5f, c.getPosition().y + 0.5f);
          if (centre.dst(X, Y) < 0.5) {
            selectedCircle = c;
            selectedColumn = level.grid.columns[i];
            c.setIsSelected(true);
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
        for (int i = 0; i < level.grid.columns.length; i++) {
          for (int j = 0; j < level.grid.columns[i].circles.size(); j++) {
            Circle c = level.grid.columns[i].circles.get(j);
            Vector2 centre = new Vector2(c.getPosition().x + 0.5f, c.getPosition().y + 0.5f);
            if (!c.equals(selectedCircle) && centre.dst(X, Y) < 0.5) {
              intersectionFound = true;
              // make set colour return false if can't set, then know when to return
              if (c.setColour(c.getColour() * selectedCircle.getColour())) {
                selectedColumn.remove(selectedCircle);
                break;
              } else {
                selectedCircle.setPosition(new Vector2(startX, startY));
                selectedCircle.setIsSelected(false);
                selectedCircle = null;
                selectedColumn = null;
                break;
              }
            }
          }
        }
        if (intersectionFound == false) {
          selectedCircle.setPosition(new Vector2(startX, startY));
          selectedCircle.setIsSelected(false);
          selectedCircle = null;
          selectedColumn = null;
        }
      }
      level.grid.checkColumns();
      level.grid.checkRows();
      try {
        animate();
      } catch (InterruptedException e){

      }
    }
    return false;
  }

  public void animate() throws InterruptedException{
    animate = true;

    for (Circle c : level.grid.removalQueue) {
      c.setIsShrinking(true);
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
  }*/

}

