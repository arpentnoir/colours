package com.richardspellman.colours.game.controllers;

import com.badlogic.gdx.Game;
import com.richardspellman.colours.game.models.Grid;
import com.richardspellman.colours.game.models.TimedGame;
import com.richardspellman.colours.game.screens.MenuScreen;

/**
 * Created by richardspellman on 21/09/15.
 */
public class TimedGameController extends GameController {

  private static final String TAG = TimedGameController.class.getName();

  public TimedGameController(Game game){
    super(game);
    init();
  }

  private void init(){
    initController();
  }

  private void initController(){
    super.game = new TimedGame();
  }

  public void update (float deltaTime) {
    game.update(deltaTime);
    if(((TimedGame) game).getTime() < 0){
      libgdxGame.setScreen(new MenuScreen(libgdxGame));
    }
  }

  @Override
  public void processMove(Grid grid){
    grid.checkColumns();
    grid.checkRows();
    game.setScore(grid.getScore());
    grid.removeScoringRuns();
    System.out.println(grid.columns[0].circles.get(0).getPosition());
    System.out.println(grid.toString());
    System.out.println(grid.currentPositionToString());
  }

  public TimedGame getGame(){
    return (TimedGame) game;
  }
}
