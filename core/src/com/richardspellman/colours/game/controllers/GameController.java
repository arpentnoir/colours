package com.richardspellman.colours.game.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.richardspellman.colours.game.models.BaseGame;
import com.richardspellman.colours.game.models.Circle;
import com.richardspellman.colours.game.models.Column;
import com.richardspellman.colours.game.models.Grid;
import com.richardspellman.colours.game.screens.MenuScreen;
import com.richardspellman.colours.util.CameraHelper;
import com.richardspellman.colours.util.Constants;

/**
 * Created by richardspellman on 21/09/15.
 */
public class GameController extends InputAdapter{


  public CameraHelper cameraHelper;
  public BaseGame game;
  public int score;
  protected Game libgdxGame;
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
    this.libgdxGame = game;
    init();
  }

  private void init(){
    Gdx.input.setInputProcessor(this);
  }


  public void update (float deltaTime) {
    System.out.println("game controller update");

  }

  private void handleDebugInput(float deltaTime) {

  }

  @Override
  public boolean touchDown(int x, int y, int pointer, int button){
    //System.out.println("touch down - " + x + " " + y);
    if(y < 100) {
      libgdxGame.setScreen(new MenuScreen(libgdxGame));
    }
    if(!animate && selectedCircle == null && pointer == 0) {
      float X = x;//(x - (Gdx.graphics.getWidth() / 2)) / Constants.PIXELS_TO_METERS;
      float Y = y;//(y - (Gdx.graphics.getHeight() / 2)) / Constants.PIXELS_TO_METERS;
      //System.out.println(game.getGrid().columns[0].circles.get(0).getCentre());
      //System.out.println(game.getGrid().toString());
      for (int i = 0; i < game.getGrid().columns.length; i++) {

        for (int j = 0; j < game.getGrid().columns[i].circles.size(); j++) {
          Circle c = game.getGrid().columns[i].circles.get(j);
          //System.out.print(c.getCentre() + " ");
          //TODO: remove hardcoded radius
          if (c.getCentre().dst(X, Y) < 15) {
            selectedCircle = c;
            selectedColumn = game.getGrid().columns[i];
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
    //System.out.println("touch up");
    if(!animate) {
      float X = x; // (x - (Gdx.graphics.getWidth() / 2)) / Constants.PIXELS_TO_METERS;
      float Y = y; //(y - (Gdx.graphics.getHeight() / 2)) / Constants.PIXELS_TO_METERS;
      boolean intersectionFound = false;
      if (selectedCircle != null && pointer == 0) {
        for (int i = 0; i < game.getGrid().columns.length; i++) {
          for (int j = 0; j < game.getGrid().columns[i].circles.size(); j++) {
            Circle c = game.getGrid().columns[i].circles.get(j);
            // TODO: remove hard coded radius
            if (!c.equals(selectedCircle) && c.getCentre().dst(X, Y) < 15) {
              intersectionFound = true;
              // make set colour return false if can't set, then know when to return
              if (c.setColour(c.getColour() * selectedCircle.getColour())) {
                selectedColumn.remove(selectedCircle);
                processMove(game.getGrid());
                break;
              } else {
                selectedCircle.setCurrentPosition(new Vector2(startX, startY));
                selectedCircle.setIsSelected(false);
                selectedCircle = null;
                selectedColumn = null;
                break;
              }
            }
          }
        }
        if (intersectionFound == false) {
          selectedCircle.setCurrentPosition(new Vector2(startX, startY));
          selectedCircle.setIsSelected(false);
          selectedCircle = null;
          selectedColumn = null;
        }
      }

      try {
        animate();
      } catch (InterruptedException e){

      }
    }
    if(selectedCircle != null){
      selectedCircle.setIsSelected(false);
      selectedCircle = null;
    }
    return false;
  }

  public void animate() throws InterruptedException{
    animate = true;

    for (Circle c : game.getGrid().removalQueue) {
      c.setIsShrinking(true);
    }
    animate = false;
  }

  @Override
  public boolean touchDragged(int x, int y, int pointer){
    //System.out.println("touch dragged");
    if(selectedCircle != null && !animate && pointer == 0){
      //System.out.println("mouse at " + x + " " + y);

      selectedCircle.setCurrentPosition(new Vector2(x - deltaX, y - deltaY));
      //System.out.println("current position of circle is " + selectedCircle.getCurrentPosition());
    }

    return false;
  }

  protected void processMove(Grid grid){
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

