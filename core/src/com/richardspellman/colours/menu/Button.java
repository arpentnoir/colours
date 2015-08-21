package com.richardspellman.colours.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.richardspellman.colours.util.Assets;

import java.util.Random;

/**
 * Created by richardspellman on 21/08/15.
 */
public class Button {


  private Vector2 position;
  private Vector2 dimension;
  private Vector2 origin;
  private Vector2 scale;

  private Vector2 centre;

  public Sound sound;


  private TextureRegion regButton;

  public Button(Vector2 position, int colour){
    super();
    dimension = new Vector2(1, 1);
    origin = new Vector2(0.5f, 0.5f);
    scale = new Vector2(0.9f, 0.9f);
    this.position = position;

    //TODO: this just a placeholder until have a proper button image, will need to conditionally set button image
    regButton = Assets.instance.continuousPlayButton.continuousPlayButton;

  }

  public void update(float deltaTime){
  }

  public void render(SpriteBatch batch){
    TextureRegion region = regButton;
    regButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

    batch.draw(region.getTexture(), position.x, - position.y - 1, origin.x, origin.y, dimension.x, dimension.y, scale.x,
        scale.y, 0, region.getRegionX(), region.getRegionY(), region.getRegionWidth(),
        region.getRegionHeight(), false, false);
  }

  public Vector2 getPosition() {
    return position;
  }

  public void setPosition(Vector2 position) {
    this.position = position;
  }

  public Vector2 getCentre() {
    return centre;
  }

  public void setCentre(Vector2 centre){
    this.centre = centre;
  }
}

