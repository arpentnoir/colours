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
    //menu.menuItems.get(0).update(deltaTime);
    menu.update(deltaTime);
    if(gravityOn) world.step(Gdx.graphics.getDeltaTime(), 6, 2);
    //System.out.println(world.getGravity());
    //if(gravityOn){
    //  world.setGravity(gravity);
    //} else {
    //  world.setGravity(new Vector2(0, 0));
   // }
    //handleDebugInput(deltaTime);
    //handleInputMenu(deltaTime);
    //menu.update(deltaTime);

  }

  private void handleDebugInput(float deltaTime) {

  }

  @Override
  public boolean touchDown(int x, int y, int pointer, int button){
    //if(y < 100) {
    //  System.out.println("touched at y = " + y);
    //  game.setScreen(new MenuScreen(game));
    //}
    //if(!animate) {
    System.out.println(Constants.PIXELS_TO_METERS);
    System.out.println("mouse coordinates: " + x + ", " + y);
      float X = (x - (Gdx.graphics.getWidth() / 2)) / Constants.PIXELS_TO_METERS;
      float Y = - (y - (Gdx.graphics.getHeight() / 2)) / Constants.PIXELS_TO_METERS;
    System.out.println("adjusted mouse coordinates: " + X + ", " + Y);

        for (int j = 0; j < menu.menuItems.size(); j++) {
          Button b = menu.menuItems.get(j);
          if (b.body.getPosition().dst(X, Y) < 1) {
            selectedCircle = b;
            b.isSelected = true;
            // used to keep relationship to mouse cursor when moving
            //deltaX = X - c.getPosition().x;
            //deltaY = Y - c.getPosition().y;
            System.out.println("clicking button " + b.getType());
            if(!b.getType().equals("redButton"))b.body.setLinearVelocity(new Vector2(0, 15));
          }
        }
    //}
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
      game.setScreen(new GameScreen(game));
    } else if(type.equals("settings") && !gravityOn){
      game.setScreen(new SettingsScreen(game));
    } else if(type.equals("redButton") && !gravityOn){
      gravityOn = true;
      System.out.println("button clicked");
      System.out.println(gravityOn);
      //world.setGravity(gravity);
    } else if(type.equals("redButton") && gravityOn){
      gravityOn = false;
      init();
      System.out.println("button clicked");
      System.out.println(gravityOn);
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
