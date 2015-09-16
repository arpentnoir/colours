package com.richardspellman.colours.menu;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.richardspellman.colours.game.objects.Circle;
import com.richardspellman.colours.game.objects.Column;
import com.richardspellman.colours.util.Constants;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by richardspellman on 24/08/15.
 */
public class Menu {

    public ArrayList<Button> menuItems;
  final float sqrt_2 = (float) Math.sqrt(2);
  Body b;

    public Menu(World world){
      init(world);
    }

    public void render(SpriteBatch batch){
      //System.out.println(b.getPosition());
      for(Button b : menuItems){
        b.render(batch);
      }
     
    }
    public void init(World world){
      menuItems = new ArrayList<Button>();
      // (±1, ±(1+√2))
      // (±(1+√2), ±1).
      Button aboutButton = new Button(new Vector2(1, 1 + sqrt_2), "about", world);

      BodyDef bodyDefAbout = new BodyDef();
      bodyDefAbout.type = BodyDef.BodyType.DynamicBody;
      bodyDefAbout.position.set(aboutButton.getPosition());
      Body aboutBody = world.createBody(bodyDefAbout);
      aboutButton.body = aboutBody;
      CircleShape circle = new CircleShape();
      circle.setRadius(1f);

      FixtureDef fixtureDefAbout = new FixtureDef();
      fixtureDefAbout.shape = circle;
      fixtureDefAbout.density = 1f;

      Fixture fixtureAbout = aboutBody.createFixture(fixtureDefAbout);

      menuItems.add(aboutButton);


      Button settingsButton = new Button(new Vector2(1, -(1 + sqrt_2)), "settings", world);

      BodyDef bodyDefSettings = new BodyDef();
      bodyDefSettings.type = BodyDef.BodyType.DynamicBody;
      bodyDefSettings.position.set(settingsButton.getPosition());
      Body settingsBody = world.createBody(bodyDefSettings);
      settingsButton.body = settingsBody;

      FixtureDef fixtureDefSettings = new FixtureDef();
      fixtureDefSettings.shape = circle;
      fixtureDefSettings.density = 1f;

      Fixture fixtureSettings = settingsBody.createFixture(fixtureDefSettings);

      menuItems.add(settingsButton);

      Button achievementsButton = new Button(new Vector2(-1, 1 + sqrt_2), "achievements", world);

      BodyDef bodyDefAchievements = new BodyDef();
      bodyDefAchievements.type = BodyDef.BodyType.DynamicBody;
      bodyDefAchievements.position.set(achievementsButton.getPosition());
      Body achievementsBody = world.createBody(bodyDefAchievements);
      achievementsButton.body = achievementsBody;

      FixtureDef fixtureDefAchievements = new FixtureDef();
      fixtureDefAchievements.shape = circle;
      fixtureDefAchievements.density = 1f;

      Fixture fixtureAchievements = achievementsBody.createFixture(fixtureDefAchievements);

      menuItems.add(achievementsButton);

      Button endlessButton = new Button(new Vector2(-1, -(1 + sqrt_2)), "endless", world);

      BodyDef bodyDefEndless = new BodyDef();
      bodyDefEndless.type = BodyDef.BodyType.DynamicBody;
      bodyDefEndless.position.set(endlessButton.getPosition());
      Body endlessBody = world.createBody(bodyDefEndless);
      endlessButton.body = endlessBody;

      FixtureDef fixtureDefEndless = new FixtureDef();
      fixtureDefEndless.shape = circle;
      fixtureDefEndless.density = 1f;

      Fixture fixtureEndless = endlessBody.createFixture(fixtureDefEndless);

      menuItems.add(endlessButton);


      Button movesButton = new Button(new Vector2(1 + sqrt_2, 1), "moves", world);

      BodyDef bodyDefMoves = new BodyDef();
      bodyDefMoves.type = BodyDef.BodyType.DynamicBody;
      bodyDefMoves.position.set(movesButton.getPosition());
      Body movesBody = world.createBody(bodyDefMoves);
      movesButton.body = movesBody;

      FixtureDef fixtureDefMoves = new FixtureDef();
      fixtureDefMoves.shape = circle;
      fixtureDefMoves.density = 1f;

      Fixture fixtureMoves = movesBody.createFixture(fixtureDefMoves);

      menuItems.add(movesButton);

      Button powerupButton = new Button(new Vector2(1 + sqrt_2, -1), "powerup", world);

      BodyDef bodyDefPowerup = new BodyDef();
      bodyDefPowerup.type = BodyDef.BodyType.DynamicBody;
      bodyDefPowerup.position.set(powerupButton.getPosition());
      Body powerupBody = world.createBody(bodyDefPowerup);
      powerupButton.body = powerupBody;

      FixtureDef fixtureDefPowerup = new FixtureDef();
      fixtureDefPowerup.shape = circle;
      fixtureDefPowerup.density = 1f;

      Fixture fixturePowerup = powerupBody.createFixture(fixtureDefPowerup);

      menuItems.add(powerupButton);

      Button redButton = new Button(new Vector2(-(1 + sqrt_2), 1), "redButton", world);

      BodyDef bodyDefRedButton = new BodyDef();
      bodyDefRedButton.type = BodyDef.BodyType.DynamicBody;
      bodyDefRedButton.position.set(redButton.getPosition());
      Body redbuttonBody = world.createBody(bodyDefRedButton);
      redButton.body = redbuttonBody;

      FixtureDef fixtureDefRedButton = new FixtureDef();
      fixtureDefRedButton.shape = circle;
      fixtureDefRedButton.density = 1f;

      Fixture fixtureRedButton = redbuttonBody.createFixture(fixtureDefRedButton);

      menuItems.add(redButton);

      Button timedButton = new Button(new Vector2(-(1 + sqrt_2), -1), "timed", world);

      BodyDef bodyDefTimed = new BodyDef();
      bodyDefTimed.type = BodyDef.BodyType.DynamicBody;
      bodyDefTimed.position.set(timedButton.getPosition());
      Body timedBody = world.createBody(bodyDefTimed);
      timedButton.body = timedBody;

      FixtureDef fixtureDefTimed = new FixtureDef();
      fixtureDefTimed.shape = circle;
      fixtureDefTimed.density = 1f;

      Fixture fixtureTimed = timedBody.createFixture(fixtureDefTimed);

      menuItems.add(timedButton);
      circle.dispose();

      for (Button button : menuItems){
        System.out.println(button.getType() + " :" + button.getPosition() + " body " + button.body.getPosition());
      }

      BodyDef bodyDef = new BodyDef();
      bodyDef.type = BodyDef.BodyType.KinematicBody;
      bodyDef.position.set(0, -8.5f);
      Body body = world.createBody(bodyDef);
      PolygonShape polygonShape = new PolygonShape();
      polygonShape.setAsBox(10f, 0.5f);

      FixtureDef fixtureDef = new FixtureDef();
      fixtureDef.shape = polygonShape;
      fixtureDef.density = 1f;

      Fixture fixture = body.createFixture(fixtureDef);

      polygonShape.dispose();

      BodyDef bodyDefRightWall = new BodyDef();
      bodyDefRightWall.type = BodyDef.BodyType.KinematicBody;
      bodyDefRightWall.position.set(5.6f, 0);
      Body bodyRightWall = world.createBody(bodyDefRightWall);
      PolygonShape polygonShapeWall = new PolygonShape();
      polygonShape.setAsBox(0.5f, 14f);

      FixtureDef fixtureDefRightWall = new FixtureDef();
      fixtureDefRightWall.shape = polygonShapeWall;
      fixtureDefRightWall.density = 1f;

      Fixture fixtureRightWall = bodyRightWall.createFixture(fixtureDefRightWall);

      BodyDef bodyDefLeftWall = new BodyDef();
      bodyDefLeftWall.type = BodyDef.BodyType.KinematicBody;
      bodyDefLeftWall.position.set(-5.6f, 0);
      Body bodyLeftWall = world.createBody(bodyDefLeftWall);


      FixtureDef fixtureDefLeftWall = new FixtureDef();
      fixtureDefLeftWall.shape = polygonShapeWall;
      fixtureDefLeftWall.density = 1f;

      Fixture fixtureLeftWall = bodyLeftWall.createFixture(fixtureDefLeftWall);

      polygonShapeWall.dispose();

      // ******* debugging physics screne size ********
      /*BodyDef bodyDef1 = new BodyDef();
      bodyDef1.type = BodyDef.BodyType.DynamicBody;
      bodyDef1.position.set(new Vector2(1, 1 + sqrt_2));
      Body body1 = world.createBody(bodyDef1);
      b = body1;
      CircleShape circle = new CircleShape();
      circle.setRadius(1f);

      FixtureDef fixtureDef1 = new FixtureDef();
      fixtureDef1.shape = circle;
      fixtureDef1.density = 1f;

      Fixture fixture1 = body1.createFixture(fixtureDef1);
      circle.dispose();*/



    }


    public void update(float deltaTime){
      for(Button button : menuItems){
        button.update(deltaTime);
        //System.out.println(button.getType() + " position = " + button.getPosition());
      }
      //checkRows();
      //checkColumns();


    }
  }

