package com.richardspellman.colors.game.models;

/**
 * Created by richardspellman on 21/09/15.
 */
public class EndlessGame extends BaseGame{

  public EndlessGame(){
    paused = false;
  }

  @Override
  public void update(float deltaTime){
    grid.update(deltaTime);
  }


}

