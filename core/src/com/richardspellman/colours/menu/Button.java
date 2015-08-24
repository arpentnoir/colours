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
  private String type;

  private float rotation;

  private Vector2 centre;

  public Sound sound;


  private TextureRegion regButton;

  public Button(Vector2 position, String type){
    super();
    dimension = new Vector2(1, 1);
    origin = new Vector2(0.5f, 0.5f);
    scale = new Vector2(2, 2);
    this.position = position;
    this.type = type;
    centre = new Vector2(position.x + origin.x, position.y + origin.y);

  // TODO: each button should have a standard position based on it's type

    if(type.equals("about")) {
      regButton = Assets.instance.about.about;
    } else if (type.equals("achievements")) {
      regButton = Assets.instance.achievements.achievements;
    } else if (type.equals("endless")) {
      regButton = Assets.instance.endless.endless;
    } else if (type.equals("moves")){
      regButton = Assets.instance.moves.moves;
    } else if (type.equals("powerup")){
      regButton = Assets.instance.powerup.powerup;
    } else if (type.equals("redButton")){
      regButton = Assets.instance.redButton.redButton;
    } else if (type.equals("settings")){
      regButton = Assets.instance.settings.settings;
    } else if (type.equals("timed")){
      regButton = Assets.instance.timed.timed;
    }
  }

  public void update(float deltaTime){
    //rotation++;
  }

  public void render(SpriteBatch batch){
    TextureRegion region = regButton;
    regButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

    batch.draw(region.getTexture(), position.x, - position.y - 1, origin.x, origin.y, dimension.x, dimension.y, scale.x,
        scale.y, rotation, region.getRegionX(), region.getRegionY(), region.getRegionWidth(),
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

  public String getType(){
    return this.type;
  }
}

