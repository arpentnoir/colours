package com.richardspellman.colours.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.richardspellman.colours.menu.MenuController;
import com.richardspellman.colours.menu.MenuRenderer;



/**
 * Created by richardspellman on 3/08/15.
 */
public class MenuScreen extends AbstractGameScreen{


    private MenuController menuController;
    private MenuRenderer menuRenderer;

    private boolean paused;


    public MenuScreen(Game game){
      super(game);
    }

    @Override
    public void render(float deltaTime) {
        menuController.update(deltaTime);
        Gdx.gl.glClearColor(245.0f / 255.0f, 245.0f / 255.0f, 245.0f / 255.0f, 255.0f / 255.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        menuRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
      menuRenderer.resize(width, height);
    }

    @Override
    public void show() {
      menuController = new MenuController(game);
      menuRenderer = new MenuRenderer(menuController);
      Gdx.input.setCatchBackKey(true);

    }

    @Override
    public void hide() {
      menuRenderer.dispose();
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
