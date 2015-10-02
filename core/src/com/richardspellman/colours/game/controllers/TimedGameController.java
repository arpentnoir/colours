package com.richardspellman.colours.game.controllers;

import com.badlogic.gdx.Game;
import com.richardspellman.colours.game.models.GameState;
import com.richardspellman.colours.game.models.Grid;
import com.richardspellman.colours.game.models.TimedGame;
import com.richardspellman.colours.game.screens.MenuScreen;
import com.richardspellman.colours.util.Assets;

/**
 * Created by richardspellman on 21/09/15.
 */
public class TimedGameController extends GameController {

  private static final String TAG = TimedGameController.class.getName();
  private int highScore;

  public TimedGameController(Game game){
    super(game);
    init();
  }

  private void init(){
    initController();
  }

  private void initController(){

    super.game = new TimedGame();
    highScore = Assets.instance.preferences.getInteger("timedHighScoreValue", 0);
  }

  public void update (float deltaTime) {
    game.update(deltaTime);
    if(((TimedGame) game).getTime() < 0){
      finishGame();
      libgdxGame.setScreen(new MenuScreen(libgdxGame));
    }
  }

  @Override
  public void processMove(Grid grid){
    grid.checkColumns();
    grid.checkRows();
    game.setScore(grid.getScore());
    handleBrowns(grid.getBrownCount());
    grid.removeScoringRuns();

  }

  public void handleBrowns(int brownCount){
    ((TimedGame) game).incrementTime(brownCount * 2);
  }

  public void finishGame(){
    // this is where high score is updated
    if(game.getScore() > highScore) {
      Assets.instance.preferences.putInteger("timedHighScoreValue", game.getScore());
      Assets.instance.preferences.flush();
    }
  }

  public TimedGame getGame(){
    return (TimedGame) game;
  }
}
