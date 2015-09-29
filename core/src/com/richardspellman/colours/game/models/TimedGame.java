package com.richardspellman.colours.game.models;


/**
 * Created by richardspellman on 21/09/15.
 */
public class TimedGame extends BaseGame{

  private float time = 60;

  public TimedGame(){
    paused = true;

  }

  @Override
  public void update(float deltaTime){
    if(grid.columns[0].circles.get(6).getCurrentPosition().y == grid.columns[0].circles.get(6).getPosition().y){
      paused = false;
    }
    grid.update(deltaTime);
    if(!paused) time -= deltaTime;
  }

  public float getTime() {
    return time;
  }

}
