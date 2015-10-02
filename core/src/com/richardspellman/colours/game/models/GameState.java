package com.richardspellman.colours.game.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by richardspellman on 2/10/15.
 */
public class GameState {
  public static final GameState instance = new GameState();
  public static TimedHighScoreValue timedHighScoreValue;

  public static Preferences preferences;

  private GameState(){}

  public void init(){
    preferences = Gdx.app.getPreferences("preferences");
    timedHighScoreValue = new TimedHighScoreValue();
  }

  public class TimedHighScoreValue{
    public int timedHighScoreValue;
    public TimedHighScoreValue(){
      this.timedHighScoreValue = preferences.getInteger("timedHighScoreValue", 0);
    }
  }


}
