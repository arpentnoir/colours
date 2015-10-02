package com.richardspellman.colours.game.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.richardspellman.colours.game.screens.MenuScreen;

/**
 * Created by richardspellman on 21/09/15.
 */
public class PowerupController extends InputAdapter {
  private Game game;

  private static final String TAG = PowerupController.class.getName();

  public PowerupController(Game game){
    this.game = game;
    init();
  }

  private void init(){
    Gdx.input.setInputProcessor(this);
    initController();
  }

  private void initController(){

  }

  @Override
  public boolean touchDown(int x, int y, int pointer, int button) {
    //System.out.println("touch down - " + x + " " + y);
    if (y < 100) {
      game.setScreen(new MenuScreen(game));
    }
    return false;
  }

  public void update (float deltaTime) {

  }
}
