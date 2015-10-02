package com.richardspellman.colors.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.richardspellman.colors.game.controllers.SettingsController;
import com.richardspellman.colors.game.renderers.SettingsRenderer;

/**
 * Created by richardspellman on 21/09/15.
 */
public class SettingsScreen extends AbstractGameScreen{

  private SettingsController powerupController;
  private SettingsRenderer powerupsRenderer;

  private boolean paused;

  public SettingsScreen(Game game){
    super(game);
  }

  @Override
  public void render(float deltaTime) {
    if(!paused){
      powerupController.update(deltaTime);
      Gdx.gl.glClearColor(245.0f / 255.0f, 245.0f / 255.0f, 245.0f / 255.0f, 255.0f / 255.0f);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      powerupsRenderer.render();
    }
  }

  @Override
  public void resize(int width, int height) {
    powerupsRenderer.resize(width, height);
  }

  @Override
  public void show() {
    powerupController = new SettingsController(game);
    powerupsRenderer = new SettingsRenderer(powerupController);
    Gdx.input.setCatchBackKey(true);

  }

  @Override
  public void hide() {
    powerupsRenderer.dispose();
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
