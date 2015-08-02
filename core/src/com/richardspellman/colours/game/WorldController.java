package com.richardspellman.colours.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.richardspellman.colours.util.CameraHelper;
import com.richardspellman.colours.util.Constants;



/**
 * Created by richardspellman on 31/07/15.
 */

public class WorldController extends InputAdapter {

  public CameraHelper cameraHelper;
  public Level level;
  public int score;
  public World world;

  private static final String TAG = WorldController.class.getName();

  public WorldController(){
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
