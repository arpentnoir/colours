package com.richardspellman.colors.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.richardspellman.colors.game.controllers.EndGameController;
import com.richardspellman.colors.game.controllers.SettingsController;
import com.richardspellman.colors.game.models.EndGame;
import com.richardspellman.colors.game.renderers.EndGameRenderer;
import com.richardspellman.colors.game.renderers.SettingsRenderer;

/**
 * Created by richardspellman on 5/11/2015.
 */
public class EndGameScreen extends AbstractGameScreen{

  private EndGameController endGameController;
  private EndGameRenderer endGameRenderer;
  private int score;
  private boolean paused;

  public EndGameScreen(Game game){
    super(game);
  }

  @Override
  public void render(float deltaTime) {
    if(!paused){
      endGameController.update(deltaTime);
      Gdx.gl.glClearColor(245.0f / 255.0f, 245.0f / 255.0f, 245.0f / 255.0f, 255.0f / 255.0f);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      endGameRenderer.render();
    }
  }

  @Override
  public void resize(int width, int height) {
    endGameRenderer.resize(width, height);
  }

  @Override
  public void show() {
    endGameController = new EndGameController(game);
    endGameRenderer = new EndGameRenderer(endGameController);
    Gdx.input.setCatchBackKey(true);

  }

  @Override
  public void hide() {
    endGameRenderer.dispose();
    Gdx.input.setCatchBackKey(false);

  }

  @Override
  public void pause() {
    paused = true;
  }

  @Override
  public void resume(){
    super.resume();
    paused = false;
  }
}

