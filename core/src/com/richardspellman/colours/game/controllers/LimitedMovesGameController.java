package com.richardspellman.colours.game.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.richardspellman.colours.game.models.Grid;
import com.richardspellman.colours.game.models.LimitedMovesGame;
import com.richardspellman.colours.game.models.TimedGame;
import com.richardspellman.colours.game.screens.MenuScreen;

/**
 * Created by richardspellman on 21/09/15.
 */
public class LimitedMovesGameController extends GameController{

  private static final String TAG = LimitedMovesGameController.class.getName();

  public LimitedMovesGameController(Game game){
    super(game);
    init();
  }

  private void init(){
    initController();
  }

  private void initController(){
    super.game = new LimitedMovesGame();
  }

  public void update (float deltaTime) {
    if(((LimitedMovesGame) game).getMoves() < 0){
      libgdxGame.setScreen(new MenuScreen(libgdxGame));
    }
  }

  @Override
  public void processMove(Grid grid){
    ((LimitedMovesGame) game).decrementMoves();
    grid.checkColumns();
    grid.checkRows();
    game.setScore(grid.getScore());
    grid.removeScoringRuns();
  }

  public LimitedMovesGame getGame(){
    return (LimitedMovesGame) game;
  }
}


