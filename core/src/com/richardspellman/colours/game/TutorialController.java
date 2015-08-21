package com.richardspellman.colours.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.richardspellman.colours.game.objects.Circle;
import com.richardspellman.colours.game.objects.Column;
import com.richardspellman.colours.game.screens.MenuScreen;
import com.richardspellman.colours.util.CameraHelper;
import com.richardspellman.colours.util.Constants;

/**
 * Created by richardspellman on 20/08/15.
 */
public class TutorialController extends InputAdapter{

  public CameraHelper cameraHelper;
  public Tutorial tutorial;
  private Game game;
  public World world;
  private Circle selectedCircle;
  private Column selectedColumn;
  private float deltaX;
  private float deltaY;
  private float startX;
  private float startY;
  private boolean animate;



  private static final String TAG = TutorialController.class.getName();

  public TutorialController(Game game){
    this.game = game;
    init();
  }

  private void init(){
    Gdx.input.setInputProcessor(this);
    cameraHelper = new CameraHelper();
    initTutorial();
    animate = false;


  }


  private void initTutorial(){
    tutorial = new Tutorial();

  }

  public void update (float deltaTime) {
    handleDebugInput(deltaTime);
    handleInputGame(deltaTime);
    //if(!animate) tutorial.update(deltaTime);
    //cameraHelper.update(deltaTime);

  }

  private void handleDebugInput(float deltaTime) {

  }

  @Override
  public boolean touchDown(int x, int y, int pointer, int button){
    System.out.println("touch down");
    if(y < 100) {
      System.out.println("touched at y = " + y);
      game.setScreen(new MenuScreen(game));
    }
    //if(!animate) {
      float X = (x - (Gdx.graphics.getWidth() / 2)) / 60.0f;
      float Y = (y - (Gdx.graphics.getHeight() / 2)) / 60.0f;

        for (int j = 0; j < tutorial.circles.size(); j++) {
          Circle c = tutorial.circles.get(j);
          Vector2 centre = new Vector2(c.getPosition().x + 0.5f, c.getPosition().y + 0.5f);
          if (centre.dst(X, Y) < 0.5) {
            selectedCircle = c;
            c.isSelected = true;
            // used to keep relationship to mouse cursor when moving
            deltaX = X - c.getPosition().x;
            deltaY = Y - c.getPosition().y;

            // used to snap back to original position if no candidate position found
            startX = c.getPosition().x;
            startY = c.getPosition().y;
          }
        }
      //}
    return false;
  }

  @Override
  public boolean touchUp(int x, int y, int pointer, int button){
    if(!animate) {
      float X = (x - (Gdx.graphics.getWidth() / 2)) / 60.0f;
      float Y = (y - (Gdx.graphics.getHeight() / 2)) / 60.0f;
      boolean intersectionFound = false;
      if (selectedCircle != null) {
        for (int i = 0; i < tutorial.circles.size(); i++) {
            Circle c = tutorial.circles.get(i);
            Vector2 centre = new Vector2(c.getPosition().x + 0.5f, c.getPosition().y + 0.5f);
            if (!c.equals(selectedCircle) && centre.dst(X, Y) < 0.5) {
              //System.out.println("selected circle's colour is: " + selectedCircle.colour + " other circle's colour is: " + c.colour);
              intersectionFound = true;
              // make set colour return false if can't set, then know when to return
              if (c.setColour(c.colour * selectedCircle.colour)) {
                tutorial.circles.remove(selectedCircle);
                System.out.println("removing circle...");
                //System.out.println(c.colour);
                break;
              } else {
                //System.out.println("call to set colour failed, resetting selected circle's position");
                selectedCircle.setPosition(new Vector2(startX, startY));
                selectedCircle.isSelected = false;
                selectedCircle = null;
                break;
              }
            }
          }
        if (intersectionFound == false) {
          //System.out.println("no intersecting circle found, resetting selected circle's position");
          selectedCircle.setPosition(new Vector2(startX, startY));
          selectedCircle.isSelected = false;
          selectedCircle = null;
          selectedColumn = null;
        }
      }
      try {
        animate();
      } catch (InterruptedException e){

      }
    }
    return false;
  }

  public void animate() throws InterruptedException{
   /* animate = true;

    for (Circle c : level.removalQueue) {
      c.isShrinking = true;
    }
    animate = false;*/
  }

  @Override
  public boolean touchDragged(int x, int y, int pointer){
    if(selectedCircle != null && !animate){
      selectedCircle.setPosition(new Vector2((x - (Gdx.graphics.getWidth() / 2)) / 60.0f - deltaX, (y - (Gdx.graphics.getHeight() / 2)) / 60.0f - deltaY));
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
