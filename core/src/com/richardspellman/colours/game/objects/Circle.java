package com.richardspellman.colours.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.richardspellman.colours.util.Constants;
import com.richardspellman.colours.util.Constants.COLOUR;
import com.richardspellman.colours.util.Assets;


/**
 * Created by richardspellman on 2/08/15.
 */
public class Circle {
  private Vector2 position;
  public Vector2 dimension;
  public Vector2 origin;
  public Vector2 scale;
  public COLOUR colour;
  public float rotation;

  private TextureRegion regCircle;

  public Circle(Vector2 position, COLOUR colour){
    dimension = new Vector2(1, 1);
    origin = new Vector2(0, 0);
    scale = new Vector2(1, 1);
    this.colour = colour;
    this.position = position;
    if(colour.equals(COLOUR.RED)){
      regCircle = Assets.instance.red.red;
    } else if(colour.equals(COLOUR.GREEN)){
      regCircle = Assets.instance.green.green;
    } else if(colour.equals(COLOUR.BLUE)){
      regCircle = Assets.instance.blue.blue;
    } else if(colour.equals(COLOUR.CYAN)){
      regCircle = Assets.instance.cyan.cyan;
    } else if(colour.equals(COLOUR.MAGENTA)){
      regCircle = Assets.instance.magenta.magenta;
    } else if(colour.equals(COLOUR.YELLOW)){
      regCircle = Assets.instance.yellow.yellow;
    } else {
      regCircle = Assets.instance.white.white;
    }
  }

  public void update(){

  }

  public void render(SpriteBatch batch){
    TextureRegion region = regCircle;
    batch.draw(region.getTexture(), position.x, position.y, origin.x, origin.y, dimension.x, dimension.y, scale.x,
        scale.y, 0, region.getRegionX(), region.getRegionY(), region.getRegionWidth(),
        region.getRegionHeight(), false, false);
  }

  public Vector2 getPosition() {
    return position;
  }

  public void setPosition(Vector2 position) {
    this.position = position;
  }
}
