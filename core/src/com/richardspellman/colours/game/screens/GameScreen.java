package com.richardspellman.colours.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.richardspellman.colours.game.WorldController;
import com.richardspellman.colours.game.WorldRenderer;

/**
 * Created by richardspellman on 3/08/15.
 */
public class GameScreen extends AbstractGameScreen{

  private WorldController worldController;
  private WorldRenderer worldRenderer;

  private boolean paused;

  public GameScreen(Game game){
    super(game);
  }

  @Override
  public void render(float deltaTime) {
    if(!paused){
      worldController.update(deltaTime);
      Gdx.gl.glClearColor(205.0f / 255.0f, 200.0f / 255.0f, 177.0f / 255.0f, 255.0f / 255.0f);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      worldRenderer.render();
    }
  }

  @Override
  public void resize(int width, int height) {
    worldRenderer.resize(width, height);
  }

  @Override
  public void show() {
    worldController = new WorldController(game);
    worldRenderer = new WorldRenderer(worldController);
    Gdx.input.setCatchBackKey(true);

  }

  @Override
  public void hide() {
    worldRenderer.dispose();
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
