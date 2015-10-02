package com.richardspellman.colors.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.richardspellman.colors.game.controllers.LimitedMovesGameController;
import com.richardspellman.colors.game.renderers.LimitedMovesGameRenderer;

/**
 * Created by richardspellman on 21/09/15.
 */
public class LimitedMovesGameScreen extends AbstractGameScreen{

  private LimitedMovesGameController limitedMovesGameController;
  private LimitedMovesGameRenderer limitedMovesGameRenderer;

  private boolean paused;

  public LimitedMovesGameScreen(Game game){
    super(game);
  }

  @Override
  public void render(float deltaTime) {
    if(!paused){
      limitedMovesGameController.update(deltaTime);
      Gdx.gl.glClearColor(245.0f / 255.0f, 245.0f / 255.0f, 245.0f / 255.0f, 255.0f / 255.0f);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      limitedMovesGameRenderer.render();
    }
  }

  @Override
  public void resize(int width, int height) {
    limitedMovesGameRenderer.resize(width, height);
  }

  @Override
  public void show() {
    limitedMovesGameController = new LimitedMovesGameController(game);
    limitedMovesGameRenderer = new LimitedMovesGameRenderer(limitedMovesGameController);
    Gdx.input.setCatchBackKey(true);

  }

  @Override
  public void hide() {
    limitedMovesGameRenderer.dispose();
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
