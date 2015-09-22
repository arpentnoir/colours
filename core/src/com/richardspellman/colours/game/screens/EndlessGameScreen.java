package com.richardspellman.colours.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.richardspellman.colours.game.controllers.EndlessGameController;
import com.richardspellman.colours.game.renderers.EndlessGameRenderer;

/**
 * Created by richardspellman on 21/09/15.
 */
public class EndlessGameScreen extends AbstractGameScreen{

  private EndlessGameController endlessGameController;
  private EndlessGameRenderer endlessGameRenderer;

  private boolean paused;

  public EndlessGameScreen(Game game){
    super(game);
  }

  @Override
  public void render(float deltaTime) {
    if(!paused){
      endlessGameController.update(deltaTime);
      Gdx.gl.glClearColor(245.0f / 255.0f, 245.0f / 255.0f, 245.0f / 255.0f, 255.0f / 255.0f);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      endlessGameRenderer.render();
    }
  }

  @Override
  public void resize(int width, int height) {
    endlessGameRenderer.resize(width, height);
  }

  @Override
  public void show() {
    endlessGameController = new EndlessGameController(game);
    endlessGameRenderer = new EndlessGameRenderer(endlessGameController);
    Gdx.input.setCatchBackKey(true);

  }

  @Override
  public void hide() {
    endlessGameRenderer.dispose();
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
