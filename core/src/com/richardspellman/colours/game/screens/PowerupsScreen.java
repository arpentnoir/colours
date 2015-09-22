package com.richardspellman.colours.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.richardspellman.colours.game.controllers.PowerupController;
import com.richardspellman.colours.game.renderers.PowerupsRenderer;

/**
 * Created by richardspellman on 21/09/15.
 */
public class PowerupsScreen extends AbstractGameScreen{

  private PowerupController powerupController;
  private PowerupsRenderer powerupsRenderer;

  private boolean paused;

  public PowerupsScreen(Game game){
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
    powerupController = new PowerupController(game);
    powerupsRenderer = new PowerupsRenderer(powerupController);
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
