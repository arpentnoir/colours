package com.richardspellman.colours.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.richardspellman.colours.game.Level;
import com.richardspellman.colours.game.objects.Circle;
import com.richardspellman.colours.game.objects.Column;
import com.richardspellman.colours.game.screens.GameScreen;
import com.richardspellman.colours.game.screens.MenuScreen;
import com.richardspellman.colours.game.screens.SettingsScreen;
import com.richardspellman.colours.util.CameraHelper;
import com.richardspellman.colours.util.Constants;

/**
 * Created by richardspellman on 24/08/15.
 */
public class MenuController extends InputAdapter{


  public CameraHelper cameraHelper;
  public Menu menu;
  private Game game;
  private Circle selectedCircle;

  private boolean animate;


  private static final String TAG = MenuController.class.getName();

  public MenuController(Game game){
    this.game = game;
    init();
  }

  private void init(){
    Gdx.input.setInputProcessor(this);
    cameraHelper = new CameraHelper();
    initMenu();
    animate = false;


  }


  private void initMenu(){
    menu = new Menu();
  }

  public void update (float deltaTime) {
    menu.menuItems.get(0).update(deltaTime);
    //handleDebugInput(deltaTime);
    //handleInputMenu(deltaTime);
    //menu.update(deltaTime);

  }

  private void handleDebugInput(float deltaTime) {

  }

  @Override
  public boolean touchDown(int x, int y, int pointer, int button){
    /*if(y < 100) {
      System.out.println("touched at y = " + y);
      game.setScreen(new MenuScreen(game));
    }
    if(!animate) {
      float X = (x - (Gdx.graphics.getWidth() / 2)) / 60.0f;
      float Y = (y - (Gdx.graphics.getHeight() / 2)) / 60.0f;
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
    }*/
    return false;
  }

  @Override
  public boolean touchUp(int x, int y, int pointer, int button){
    float X = (x - (Gdx.graphics.getWidth() / 2)) / 60.0f;
    float Y = (y - (Gdx.graphics.getHeight() / 2)) / 60.0f;

    for(Button b : menu.menuItems){
      System.out.println(b.getCentre().dst(X, Y));
      if(b.getCentre().dst(X, Y) < 1){
        open(b.getType());
      }
    }
    return false;
  }

  public void animate() throws InterruptedException{
  }

  public void open(String type){
    if(type.equals("timed")){
      game.setScreen(new GameScreen(game));
    } else if(type.equals("settings")){
      game.setScreen(new SettingsScreen(game));
    }
  }

  @Override
  public boolean touchDragged(int x, int y, int pointer){
    //if(selectedCircle != null && !animate){
    //  selectedCircle.setPosition(new Vector2((x - (Gdx.graphics.getWidth() / 2)) / 60.0f - deltaX, (y - (Gdx.graphics.getHeight() / 2)) / 60.0f - deltaY));
    //}

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


  private void handleInputMenu(float deltaTime){
  }

}
