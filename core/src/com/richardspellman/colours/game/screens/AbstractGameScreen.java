package com.richardspellman.colours.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.richardspellman.colours.util.Assets;

/**
 * Created by richardspellman on 3/08/15.
 */

public abstract class AbstractGameScreen implements Screen{
  protected Game game;

  public AbstractGameScreen(Game game){
    this.game = game;
  }

  public abstract void render(float deltaTime);
  public abstract void resize(int width, int height);
  public abstract void show();
  public abstract void hide();
  public abstract void pause();

  public void resume(){
    Assets.instance.init(new AssetManager());
  }

  public void dispose(){
    Assets.instance.dispose();
  }
}
