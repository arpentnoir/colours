package com.richardspellman.colors.game.controllers;

import com.badlogic.gdx.Game;
import com.richardspellman.colors.game.models.Grid;
import com.richardspellman.colors.game.models.LimitedMovesGame;
import com.richardspellman.colors.game.screens.MenuScreen;
import com.richardspellman.colors.util.Assets;

/**
 * Created by richardspellman on 21/09/15.
 */
public class LimitedMovesGameController extends GameController{

  private static final String TAG = LimitedMovesGameController.class.getName();
  private int highScore;

  public LimitedMovesGameController(Game game){
    super(game);
    init();
  }

  private void init(){
    initController();
  }

  private void initController(){

    super.game = new LimitedMovesGame();
    highScore = Assets.instance.preferences.getInteger("movesHighScoreValue", 0);
  }

  public void update (float deltaTime) {
    game.update(deltaTime);
    if(((LimitedMovesGame) game).getMoves() < 0){
      finishGame();
      libgdxGame.setScreen(new MenuScreen(libgdxGame));
    }
  }

  @Override
  public void processMove(Grid grid){
    ((LimitedMovesGame) game).decrementMoves();
    grid.checkColumns();
    grid.checkRows();
    game.setScore(grid.getScore());
    handleBrowns(grid.getBrownCount());
    grid.removeScoringRuns();
  }

  public void handleBrowns(int brownCount){
    ((LimitedMovesGame) game).incrementMoves(brownCount);
  }

  public void finishGame(){
    // this is where high score is updated
    if(game.getScore() > highScore) {
      Assets.instance.preferences.putInteger("movesHighScoreValue", game.getScore());
      Assets.instance.preferences.flush();
    }
  }

  public LimitedMovesGame getGame(){
    return (LimitedMovesGame) game;
  }
}


