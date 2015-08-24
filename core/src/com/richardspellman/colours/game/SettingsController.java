package com.richardspellman.colours.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.richardspellman.colours.game.objects.Circle;
import com.richardspellman.colours.game.screens.GameScreen;
import com.richardspellman.colours.menu.Button;
import com.richardspellman.colours.menu.Menu;
import com.richardspellman.colours.util.CameraHelper;

/**
 * Created by richardspellman on 24/08/15.
 */
public class SettingsController extends InputAdapter{



    public CameraHelper cameraHelper;
    public Settings settings;
    private Game game;
    private Circle selectedCircle;

    private boolean animate;


    private static final String TAG = SettingsController.class.getName();

    public SettingsController(Game game){
      this.game = game;
      init();
    }

    private void init(){
      Gdx.input.setInputProcessor(this);
      cameraHelper = new CameraHelper();
      initSettings();

    }


    private void initSettings(){
      settings = new Settings();
    }

    public void update (float deltaTime) {

    }

    private void handleDebugInput(float deltaTime) {

    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button){

      return false;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button){
      return false;
    }

    public void animate() throws InterruptedException{
    }

    public void open(String type){

    }

    @Override
    public boolean touchDragged(int x, int y, int pointer){

      return false;
    }

    @Override
    public boolean keyUp(int keycode){

      return false;
    }


    private void handleInputMenu(float deltaTime){
    }

  }

