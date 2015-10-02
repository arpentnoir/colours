package com.richardspellman.colours.game.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.richardspellman.colours.game.models.BaseGame;
import com.richardspellman.colours.game.models.EndlessGame;
import com.richardspellman.colours.game.models.Grid;
import com.richardspellman.colours.game.models.LimitedMovesGame;
import com.richardspellman.colours.util.Assets;

/**
 * Created by richardspellman on 21/09/15.
 */
public class EndlessGameController extends GameController{

  private static final String TAG = EndlessGameController.class.getName();
  private int highScore;

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
    game.update(deltaTime);
  }

  @Override
  public void processMove(Grid grid){
    grid.checkColumns();
    grid.checkRows();
    game.setScore(grid.getScore());
    grid.removeScoringRuns();
    System.out.println(grid.toString());
  }

  public void finishGame(){
    // this is where high score is updated
    if(game.getScore() > highScore) {
      Assets.instance.preferences.putInteger("endlessHighScoreValue", game.getScore());
      Assets.instance.preferences.flush();
    }
  }
  public EndlessGame getGame(){
    return (EndlessGame) game;
  }
}

