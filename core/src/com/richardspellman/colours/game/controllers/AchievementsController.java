package com.richardspellman.colours.game.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

/**
 * Created by richardspellman on 21/09/15.
 */
public class AchievementsController extends InputAdapter{
  private Game game;

  private static final String TAG = AchievementsController.class.getName();

  public AchievementsController(Game game){
    this.game = game;
    init();
  }

  private void init(){
    Gdx.input.setInputProcessor(this);
    initController();
  }

  private void initController(){

  }

  public void update (float deltaTime) {

  }
}
