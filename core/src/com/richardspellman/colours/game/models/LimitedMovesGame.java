package com.richardspellman.colours.game.models;

/**
 * Created by richardspellman on 21/09/15.
 */
public class LimitedMovesGame extends BaseGame{

  private float moves = 20;

  public LimitedMovesGame(){

  }

  @Override
  public void update(float deltaTime){
    grid.update(deltaTime);
  }

  public float getMoves() {
    return moves;
  }

  public void decrementMoves(){
    moves -= 1;
  }

  public void incrementMoves(int count){
    moves += count;
  }

}
