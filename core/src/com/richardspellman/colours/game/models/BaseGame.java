package com.richardspellman.colours.game.models;

/**
 * Created by richardspellman on 24/09/15.
 */
public class BaseGame {

  protected Grid grid;
  protected int score;
  protected boolean paused = true;

  public BaseGame(){
    grid = new Grid();
    score = 0;
  }

  public void update(float deltaTime){
  }

  public Grid getGrid() {
    return grid;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score){
    this.score = score;
  }

  public boolean isPaused() {
    return paused;
  }

  public void setPaused(boolean paused) {
    this.paused = paused;
  }
}
