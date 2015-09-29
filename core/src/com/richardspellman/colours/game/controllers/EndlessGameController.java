package com.richardspellman.colours.game.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.richardspellman.colours.game.models.BaseGame;
import com.richardspellman.colours.game.models.EndlessGame;

/**
 * Created by richardspellman on 21/09/15.
 */
public class EndlessGameController extends GameController{

  private static final String TAG = EndlessGameController.class.getName();

  public EndlessGameController(Game game){
    super(game);
    init();
  }

  private void init(){
    initController();
  }

  private void initController(){
    super.game = new EndlessGame();
  }

  public void update (float deltaTime) {
  }

  public EndlessGame getGame(){
    return (EndlessGame) game;
  }
}

