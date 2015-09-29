package com.richardspellman.colours.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.richardspellman.colours.game.controllers.TimedGameController;
import com.richardspellman.colours.game.renderers.TimedGameRenderer;

/**
 * Created by richardspellman on 21/09/15.
 */
public class TimedGameScreen extends AbstractGameScreen{

  private TimedGameController timedGameController;
  private TimedGameRenderer timedGameRenderer;

  private boolean paused;

  private static final String TAG = TimedGameScreen.class.getName();

  public TimedGameScreen(Game game){
    super(game);
  }

  @Override
  public void render(float deltaTime) {
    if(!paused){
      timedGameController.update(deltaTime);
      Gdx.gl.glClearColor(245.0f / 255.0f, 245.0f / 255.0f, 245.0f / 255.0f, 255.0f / 255.0f);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      timedGameRenderer.render();
    }
  }

  @Override
  public void resize(int width, int height) {
    timedGameRenderer.resize(width, height);
  }

  @Override
  public void show() {
    Gdx.app.log(TAG, "Create TimedGameController and TimedGameRenderer");
    timedGameController = new TimedGameController(game);
    timedGameRenderer = new TimedGameRenderer(timedGameController);
    Gdx.input.setCatchBackKey(true);

  }

  @Override
  public void hide() {
    timedGameRenderer.dispose();
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
