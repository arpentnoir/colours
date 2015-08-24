package com.richardspellman.colours.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.richardspellman.colours.menu.Button;
import com.richardspellman.colours.util.Assets;


/**
 * Created by richardspellman on 3/08/15.
 */
public class MenuScreen extends AbstractGameScreen{


  Texture texture;
  SpriteBatch batch;
  Sprite sprite;
  boolean paused;
  private Button continuousPlayButton;

  public MenuScreen(Game game){
    super(game);
    texture = new Texture("images/start_screen.png");
    batch = new SpriteBatch();
    sprite = new Sprite(texture);
    paused = true;
    continuousPlayButton = new Button(new Vector2(100, 100));
  }

  @Override
  public void render(float deltaTime) {

    batch.begin();
      sprite.draw(batch);
      //continuousPlayButton.render(batch);
      batch.end();
    if(Gdx.input.getY() > 100){
      Gdx.gl.glClearColor(252.0f / 255.0f, 252.0f / 255.0f, 252.0f / 255.0f, 255.0f / 255.0f);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      game.setScreen(new GameScreen(game));
    }
  }

  @Override
  public void resize(int width, int height) {

  }

  @Override
  public void show() {

  }

  @Override
  public void hide() {

  }

  @Override
  public void pause() {

  }

  @Override
  public void dispose(){
    Assets.instance.dispose();
    batch.dispose();
    texture.dispose();
  }
}
