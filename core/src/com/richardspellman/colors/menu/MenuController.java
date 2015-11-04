package com.richardspellman.colors.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.richardspellman.colors.game.screens.*;
import com.richardspellman.colors.util.CameraHelper;
import com.richardspellman.colors.util.Constants;

/**
 * Created by richardspellman on 24/08/15.
 */
public class MenuController extends InputAdapter{


  public CameraHelper cameraHelper;
  public Menu menu;
  private Game game;
  private Button selectedCircle;
  public World world;
  public double mouseX;
  public double mouseY;
  private boolean gravityOn = false;
  final Vector2 gravity = new Vector2(0, -9.8f);

  private float deltaX;
  private float deltaY;

  private boolean animate;


  private static final String TAG = MenuController.class.getName();

  public MenuController(Game game){
    this.game = game;
    init();
  }

  private void init(){
    Gdx.input.setInputProcessor(this);
    cameraHelper = new CameraHelper();
    world = new World(new Vector2(0, -9.8f), true);

    initMenu(world);
    animate = false;


  }

  private void initMenu(World world){

    menu = new Menu(world);
  }

  public void update (float deltaTime) {
    menu.update(deltaTime);
    if(gravityOn) world.step(Gdx.graphics.getDeltaTime(), 6, 2);

  }

  private void handleDebugInput(float deltaTime) {

  }

  @Override
  public boolean touchDown(int x, int y, int pointer, int button){

      float X = (x - (Gdx.graphics.getWidth() / 2)) / Constants.PIXELS_TO_METERS;
      float Y = - (y - (Gdx.graphics.getHeight() / 2)) / Constants.PIXELS_TO_METERS;

        for (int j = 0; j < menu.menuItems.size(); j++) {
          Button b = menu.menuItems.get(j);
          if (b.body.getPosition().dst(X, Y) < 1) {
            selectedCircle = b;
            b.isSelected = true;
            if(!b.getType().equals("redButton"))b.body.setLinearVelocity(new Vector2(0, 15));
          }
        }
    return false;
  }

  @Override
  public boolean touchUp(int x, int y, int pointer, int button){

    float X = (x - (Gdx.graphics.getWidth() / 2)) / Constants.PIXELS_TO_METERS;
    float Y = - (y - (Gdx.graphics.getHeight() / 2)) / Constants.PIXELS_TO_METERS;
    mouseX = X;
    mouseY = Y;

    for(Button b : menu.menuItems){
      if(b.body.getPosition().dst(X, Y) < 1){
        open(b.getType());
      }
    }
    return false;
  }

  public void animate() throws InterruptedException{
  }

  public void open(String type){
    if(type.equals("timed") && !gravityOn){
      Gdx.app.log(TAG, "Set game screen to TimedGameScreen");
      game.setScreen(new TimedGameScreen(game));
    } else if(type.equals("settings") && !gravityOn){
      game.setScreen(new SettingsScreen(game));
    } else if(type.equals("about") && !gravityOn){
      game.setScreen(new AboutScreen(game));
    } else if(type.equals("endless") && !gravityOn) {
      game.setScreen(new EndlessGameScreen(game));
    } else if(type.equals("achievements") && !gravityOn) {
      game.setScreen(new AchievementsScreen(game));
    } else if(type.equals("moves") && !gravityOn) {
      game.setScreen(new LimitedMovesGameScreen(game));
    } else if(type.equals("powerup") && !gravityOn) {
      game.setScreen(new PowerupsScreen(game));
    } else if(type.equals("redButton") && !gravityOn){
      gravityOn = true;
    } else if(type.equals("redButton") && gravityOn){
      gravityOn = false;
      init();
    }
  }

  @Override
  public boolean touchDragged(int x, int y, int pointer){

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
