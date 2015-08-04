package com.richardspellman.colours.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.richardspellman.colours.game.objects.Circle;
import com.richardspellman.colours.game.objects.Column;
import com.richardspellman.colours.util.CameraHelper;
import com.richardspellman.colours.util.Constants;



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

  private static final String TAG = WorldController.class.getName();

  public WorldController(Game game){
    this.game = game;
    init();
  }

  private void init(){
    Gdx.input.setInputProcessor(this);
    cameraHelper = new CameraHelper();
    initLevel();
  }


  private void initLevel(){
    score = 0;
    level = new Level(Constants.LEVEL_01);

  }

  public void update (float deltaTime) {
    handleDebugInput(deltaTime);
    handleInputGame(deltaTime);
    level.update(deltaTime);
    //cameraHelper.update(deltaTime);

  }

  private void handleDebugInput(float deltaTime) {

  }

  @Override
  public boolean touchDown(int x, int y, int pointer, int button){
    float X = (x - (Gdx.graphics.getWidth() / 2)) / 60.0f;
    float Y = (y - (Gdx.graphics.getHeight() / 2)) / 60.0f;
    for(int i = 0; i < level.columns.length; i++){

      for(int j = 0; j < level.columns[i].circles.size(); j++){
        Circle c = level.columns[i].circles.get(j);
        Vector2 centre = new Vector2(c.getPosition().x + 0.5f, c.getPosition().y + 0.5f);
        if(centre.dst(X, Y) < 0.5) {
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
    return false;
  }

  @Override
  public boolean touchUp(int x, int y, int pointer, int button){
    float X = (x - (Gdx.graphics.getWidth() / 2)) / 60.0f;
    float Y = (y - (Gdx.graphics.getHeight() / 2)) / 60.0f;
    for(int i = 0; i < level.columns.length; i++){

      for(int j = 0; j < level.columns[i].circles.size(); j++){
        Circle c = level.columns[i].circles.get(j);
        Vector2 centre = new Vector2(c.getPosition().x + 0.5f, c.getPosition().y + 0.5f);
        if(!c.equals(selectedCircle) && centre.dst(X, Y) < 0.5) {
          System.out.println("selected circle's colour is: " + selectedCircle.colour + " other circle's colour is: " + c.colour);
          // make set colour return false if can't set, then know when to return
          c.setColour(c.colour * selectedCircle.colour);
          selectedColumn.circles.remove(selectedCircle);
          System.out.println(c.colour);
        }
      }
    }
    return false;
  }

  @Override
  public boolean touchDragged(int x, int y, int pointer){
    if(selectedCircle != null) selectedCircle.setPosition(new Vector2((x - (Gdx.graphics.getWidth() / 2)) / 60.0f - deltaX, (y - (Gdx.graphics.getHeight() / 2)) / 60.0f - deltaY));
    //System.out.println(screenX + " " + screenY);

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
