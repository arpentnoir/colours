package com.richardspellman.colors.game.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.richardspellman.colors.game.screens.MenuScreen;

/**
 * Created by richardspellman on 30/09/15.
 */
public class EndGameController extends InputAdapter{

  public Game getGame() {
    return game;
  }

  private Game game;

  private static final String TAG = EndGameController.class.getName();

  public EndGameController(Game game){
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
    if (y < 100) {
      game.setScreen(new MenuScreen(game));
    }
    return false;
  }

  public void update (float deltaTime) {

  }
}