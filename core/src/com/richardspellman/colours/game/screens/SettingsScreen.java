package com.richardspellman.colours.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.richardspellman.colours.game.SettingsController;
import com.richardspellman.colours.game.SettingsRenderer;
import com.richardspellman.colours.menu.MenuController;
import com.richardspellman.colours.menu.MenuRenderer;

/**
 * Created by richardspellman on 24/08/15.
 */
public class SettingsScreen extends AbstractGameScreen{


    private SettingsController settingsController;
    private SettingsRenderer settingsRenderer;

    private boolean paused;


    public SettingsScreen(Game game){
      super(game);
    }

    @Override
    public void render(float deltaTime) {
      settingsController.update(deltaTime);
      Gdx.gl.glClearColor(245.0f / 255.0f, 245.0f / 255.0f, 245.0f / 255.0f, 255.0f / 255.0f);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      settingsRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
      settingsRenderer.resize(width, height);
    }

    @Override
    public void show() {
      settingsController = new SettingsController(game);
      settingsRenderer = new SettingsRenderer(settingsController);
      Gdx.input.setCatchBackKey(true);

    }

    @Override
    public void hide() {
      settingsRenderer.dispose();
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

