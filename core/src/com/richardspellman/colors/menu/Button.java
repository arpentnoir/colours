package com.richardspellman.colors.menu;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.richardspellman.colors.util.Assets;

/**
 * Created by richardspellman on 21/08/15.
 */
public class Button {


  private Vector2 position;
  private Vector2 dimension;
  private Vector2 origin;
  private Vector2 scale;
  private String type;
  public Body body;
  public boolean isSelected;

  private float rotation;

  public Vector2 centre;

  public Sound sound;


  private TextureRegion regButton;

  public Button(Vector2 position, String type, World world){
    super();
    dimension = new Vector2(2, 2);
    origin = new Vector2(1, 1);
    scale = new Vector2(1, 1);
    this.type = type;
    centre = position; //new Vector2(position.x + origin.x, position.y + origin.y);
    this.position = position; //new Vector2(centre.x - 1, centre.y - 1);


    //if(type.equals("about")) {
      /*BodyDef bodyDef = new BodyDef();
      bodyDef.type = BodyDef.BodyType.DynamicBody;

      bodyDef.position.set(position);
      body = world.createBody(bodyDef);

      CircleShape circleShape = new CircleShape();
      circleShape.setRadius(1f);
      circleShape.setPosition(body.getPosition());
      FixtureDef fixtureDef1 = new FixtureDef();
      fixtureDef1.shape = circleShape;
      fixtureDef1.density = 1;
      Fixture fixture1 = body.createFixture(fixtureDef1);*/
    //}

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
    // rotation++;
    //if(type.equals("about")) {
      //position.x = (body.getPosition().x - Constants.VIEWPORT_GUI_WIDTH / 4) / 30;
      //position.y = (-(body.getPosition().y - Constants.VIEWPORT_GUI_HEIGHT / 2) / 30);
      //setCentre(new Vector2(body.getPosition().x, body.getPosition().y));
      position = body.getPosition();
      //System.out.println("body position = " + body.getPosition());
      //System.out.println("button position = " + position);
    //}
  }

  public void render(SpriteBatch batch){
    TextureRegion region = regButton;
    regButton.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

    batch.draw(region.getTexture(), position.x -1, position.y -1, origin.x, origin.y, dimension.x, dimension.y, scale.x,
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

    //this.centre = centre;
    //this.position = new Vector2(centre.x - 1, centre.y - 1);
  }

  public String getType(){
    return this.type;
  }
}

