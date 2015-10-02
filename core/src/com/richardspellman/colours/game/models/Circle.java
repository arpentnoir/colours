package com.richardspellman.colours.game.models;

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
import com.badlogic.gdx.physics.box2d.Body;

import java.util.Random;


/**
 * Created by richardspellman on 2/08/15.
 */
public class Circle{
  private Vector2 position;
  private Vector2 currentPosition;
  private Vector2 gridPosition;
  private Vector2 dimension;
  private Vector2 origin;
  private Vector2 scale;
  private int colour;
  private int rank;
  private boolean isSelected;
  private Vector2 centre;
  private float rotation;
  private boolean isShrinking;
  private boolean isMoving;
  private Body body;
  private Random random;
  private float size;

  float seperation = Constants.VIEWPORT_GUI_WIDTH / 8.5f;
  float xOffset = (Constants.VIEWPORT_GUI_WIDTH / 2) - 3.5f * seperation;
  float yOffset = (Constants.VIEWPORT_GUI_HEIGHT / 2) - 3f * seperation;

  private TextureRegion regCircle;

  public Circle(Vector2 gridPosition, int colour){
    super();
    size = Constants.VIEWPORT_GUI_WIDTH / 9.0f;
    dimension = new Vector2(size, size);
    origin = new Vector2(0.5f, 0.5f);
    scale = new Vector2(1f, 1f);
    this.gridPosition = gridPosition;
    //TODO: finalise the current position on creation
    currentPosition = new Vector2(gridPosition.x * seperation + xOffset, -gridPosition.y * seperation * 2 - yOffset / 2 );
    position = new Vector2(gridPosition.x * seperation + xOffset, -gridPosition.y * seperation + yOffset * 2);
    centre = new Vector2(position.x  + (size / 2), position.y + (size / 2));
    setColour(colour);
    isSelected = false;
    isShrinking = false;
    isMoving = false;
    //System.out.println("Created circle with current position =" + currentPosition);
  }

  public void update(float deltaTime){
    // kludgy, fix
    //centre = new Vector2(position.x + scale.x / 2f, position.y = scale.y / 2f);
    //System.out.println(currentPosition.y - position.y);
    //TODO: remove hardcoded values
    if(!isSelected) {
      //System.out.println(currentPosition.y - position.y);
      if (position.y - currentPosition.y > 5) {
        currentPosition.y += 15;
      } else {
        currentPosition.y = position.y;
      }
    }
    centre = new Vector2(currentPosition.x  + (size / 2), currentPosition.y + (size / 2));

    //TODO: change this so they can't fall off below the grid
    //if(!isSelected && position.y != ((7 - rank) - 3.5f) * 1.05f){
    //  isMoving = true;
    //}
    //if(isMoving && Math.abs(position.y - ((7 - rank) - 3.5f) * 1.05f) > 0.2){
    //  position.y += 0.2;
    //} else if(Math.abs(position.y - ((7 - rank) - 3.5f) * 1.05f) <= 0.2){
    //  position.y = ((7 - rank) - 3.5f) * 1.05f;
    //  isMoving = false;
    //}
    if(isShrinking) scale = new Vector2(scale.x * 0.9f, scale.y * 0.9f);
  }


  public void render(SpriteBatch batch){
    regCircle = getRegion();
    TextureRegion region = regCircle;
    //System.out.println(colour + " " + regCircle);

    regCircle.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

    batch.draw(region.getTexture(), currentPosition.x, currentPosition.y, origin.x, origin.y, dimension.x, dimension.y, scale.x,
        scale.y, 0, region.getRegionX(), region.getRegionY(), region.getRegionWidth(),
        region.getRegionHeight(), false, false);
  }

  public boolean setColour(int colour){
    if(colour == 2 || colour == 3 || colour == 5 || colour == 6 || colour == 10 || colour == 15 || colour == 30) {
      this.colour = colour;
    } else {
      //System.out.println("ok, so it's calling setColour, but not working for some reason...");
      return false;
    }
   //System.out.println("well, that seems to have worked");
    return true;
  }

  private TextureRegion getRegion(){

    TextureRegion region;
    if(colour == 2){
      region = Assets.instance.red.red;
    } else if(colour == 6){
      region = Assets.instance.orange.orange;
    } else if(colour == 3){
      region = Assets.instance.yellow.yellow;
    } else if(colour == 15){
      region = Assets.instance.green.green;
    } else if(colour == 5){
      region = Assets.instance.blue.blue;
    } else if(colour == 10){
      region = Assets.instance.purple.purple;
    } else{
      region = Assets.instance.brown.brown;
    }
    return region;
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

  public Vector2 getDimension() {
    return dimension;
  }

  public void setDimension(Vector2 dimension) {
    this.dimension = dimension;
  }

  public Vector2 getOrigin() {
    return origin;
  }

  public void setOrigin(Vector2 origin) {
    this.origin = origin;
  }

  public Vector2 getScale() {
    return scale;
  }

  public void setScale(Vector2 scale) {
    this.scale = scale;
  }

  public int getColour() {
    return colour;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public boolean isSelected() {
    return isSelected;
  }

  public void setIsSelected(boolean isSelected) {
    this.isSelected = isSelected;
  }

  public TextureRegion getRegCircle() {
    return regCircle;
  }

  public void setRegCircle(TextureRegion regCircle) {
    this.regCircle = regCircle;
  }

  public Random getRandom() {
    return random;
  }

  public void setRandom(Random random) {
    this.random = random;
  }

  public Body getBody() {
    return body;
  }

  public void setBody(Body body) {
    this.body = body;
  }

  public boolean isMoving() {
    return isMoving;
  }

  public void setIsMoving(boolean isMoving) {
    this.isMoving = isMoving;
  }

  public boolean isShrinking() {
    return isShrinking;
  }

  public void setIsShrinking(boolean isShrinking) {
    this.isShrinking = isShrinking;
  }

  public float getRotation() {
    return rotation;
  }

  public void setRotation(float rotation) {
    this.rotation = rotation;
  }

  public void setCentre(Vector2 centre) {
    this.centre = centre;
  }

  public Vector2 getGridPosition() {
    return gridPosition;
  }

  public void setGridPosition(Vector2 gridPosition) {

    this.gridPosition = gridPosition;
    updatePosition();
  }

  public void updatePosition(){
    position = new Vector2(gridPosition.x * seperation + xOffset, -gridPosition.y * seperation + yOffset * 2);
  }

  public void setCurrentPosition(Vector2 currentPosition){
    this.currentPosition = currentPosition;
  }

  public Vector2 getCurrentPosition(){
    return currentPosition;
  }
}
