package com.richardspellman.colours.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.richardspellman.colours.game.TutorialController;
import com.richardspellman.colours.game.TutorialRenderer;
import com.richardspellman.colours.game.WorldController;
import com.richardspellman.colours.game.WorldRenderer;

/**
 * Created by richardspellman on 20/08/15.
 */
public class TutorialScreen extends AbstractGameScreen{

  private TutorialController tutorialController;
  private TutorialRenderer  tutorialRenderer;

  private boolean paused;

  public TutorialScreen(Game game){
    super(game);
  }

  @Override
  public void render(float deltaTime) {
    if(!paused){
      tutorialController.update(deltaTime);
      Gdx.gl.glClearColor(205.0f / 255.0f, 200.0f / 255.0f, 177.0f / 255.0f, 255.0f / 255.0f);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      tutorialRenderer.render();
    }
  }

  @Override
  public void resize(int width, int height) {
    tutorialRenderer.resize(width, height);
  }

  @Override
  public void show() {
    tutorialController = new TutorialController(game);
    tutorialRenderer = new TutorialRenderer(tutorialController);
    Gdx.input.setCatchBackKey(true);

  }

  @Override
  public void hide() {
    tutorialRenderer.dispose();
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

