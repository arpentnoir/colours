package com.richardspellman.colours.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.richardspellman.colours.util.Constants;
import com.richardspellman.colours.util.Constants.COLOUR;
import com.richardspellman.colours.util.Assets;

import java.util.Random;


/**
 * Created by richardspellman on 2/08/15.
 */
public class Circle extends Button{
  private Vector2 position;
  public Vector2 dimension;
  public Vector2 origin;
  public Vector2 scale;
  public int colour;
  public int rank;
  public boolean isSelected;
  private Vector2 centre;
  public float rotation;
  public boolean isShrinking;
  boolean isMoving;
  public Sound sound;
  Random random;


  private TextureRegion regCircle;

  public Circle(Vector2 position, int colour){
    super();
    dimension = new Vector2(1, 1);
    origin = new Vector2(0.5f, 0.5f);
    scale = new Vector2(1, 1);
    //centre = new Vector2(position.x + scale.x / 2f, position.y = scale.y / 2f);
    this.position = position;
    setColour(colour);
    isSelected = false;
    isShrinking = false;
    isMoving = false;
    random = new Random();
    int r = random.nextInt(10) + 1;
    sound = Gdx.audio.newSound(Gdx.files.internal("sounds/pop" + r +".wav"));

  }

  public void update(float deltaTime){
    // kludgy, fix
    //centre = new Vector2(position.x + scale.x / 2f, position.y = scale.y / 2f);
    if(!isSelected && position.y != ((7 - rank) - 3.5f) * 1.05f){
      isMoving = true;
    }
    if(isMoving && Math.abs(position.y - ((7 - rank) - 3.5f) * 1.05f) > 0.2){
      position.y += 0.2;
    } else if(Math.abs(position.y - ((7 - rank) - 3.5f) * 1.05f) <= 0.2){
      position.y = ((7 - rank) - 3.5f) * 1.05f;
      isMoving = false;
    }
    if(isShrinking) scale = new Vector2(scale.x * 0.9f, scale.y * 0.9f);
  }

  public void render(SpriteBatch batch){
    TextureRegion region = regCircle;
    regCircle.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    //if(colour.equals(COLOUR.RED)){
      //System.out.println("position before render is " + position);
    //}
    batch.draw(region.getTexture(), position.x, - position.y - 1, origin.x, origin.y, dimension.x, dimension.y, scale.x,
        scale.y, 0, region.getRegionX(), region.getRegionY(), region.getRegionWidth(),
        region.getRegionHeight(), false, false);
  }

  public boolean setColour(int colour){
    if(colour == 2 || colour == 3 || colour == 5 || colour == 6 || colour == 10 || colour == 15 || colour == 30) {
      this.colour = colour;
    } else {
      return false;
    }
    if(colour == 2){
      regCircle = Assets.instance.red.red;
    } else if(colour == 6){
      regCircle = Assets.instance.orange.orange;
    } else if(colour == 3){
      regCircle = Assets.instance.yellow.yellow;
    } else if(colour == 15){
      regCircle = Assets.instance.green.green;
    } else if(colour == 5){
      regCircle = Assets.instance.blue.blue;
    } else if(colour == 10){
      regCircle = Assets.instance.purple.purple;
    } else if(colour == 30){
      regCircle = Assets.instance.brown.brown;
    }
    return true;
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
}
