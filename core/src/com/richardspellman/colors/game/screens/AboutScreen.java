package com.richardspellman.colors.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.richardspellman.colors.game.renderers.AboutRenderer;
import com.richardspellman.colors.game.controllers.AboutController;

/**
 * Created by richardspellman on 21/09/15.
 */
public class AboutScreen extends AbstractGameScreen{

  private AboutController aboutController;
  private AboutRenderer aboutRenderer;

  private boolean paused;

  public AboutScreen(Game game){
    super(game);
  }

  @Override
  public void render(float deltaTime) {
    if(!paused){
      aboutController.update(deltaTime);
      Gdx.gl.glClearColor(245.0f / 255.0f, 245.0f / 255.0f, 245.0f / 255.0f, 255.0f / 255.0f);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      aboutRenderer.render();
    }
  }

  @Override
  public void resize(int width, int height) {
    aboutRenderer.resize(width, height);
  }

  @Override
  public void show() {
    aboutController = new AboutController(game);
    aboutRenderer = new AboutRenderer(aboutController);
    Gdx.input.setCatchBackKey(true);

  }

  @Override
  public void hide() {
    aboutRenderer.dispose();
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
