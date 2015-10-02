package com.richardspellman.colors.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.richardspellman.colors.game.controllers.AchievementsController;
import com.richardspellman.colors.game.renderers.AchievementsRenderer;

/**
 * Created by richardspellman on 21/09/15.
 */
public class AchievementsScreen extends AbstractGameScreen{

  private AchievementsController achievementsController;
  private AchievementsRenderer achievementsRenderer;

  private boolean paused;

  public AchievementsScreen(Game game){
    super(game);
  }

  @Override
  public void render(float deltaTime) {
    if(!paused){
      achievementsController.update(deltaTime);
      Gdx.gl.glClearColor(245.0f / 255.0f, 245.0f / 255.0f, 245.0f / 255.0f, 255.0f / 255.0f);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      achievementsRenderer.render();
    }
  }

  @Override
  public void resize(int width, int height) {
    achievementsRenderer.resize(width, height);
  }

  @Override
  public void show() {
    achievementsController = new AchievementsController(game);
    achievementsRenderer = new AchievementsRenderer(achievementsController);
    Gdx.input.setCatchBackKey(true);

  }

  @Override
  public void hide() {
    achievementsRenderer.dispose();
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
