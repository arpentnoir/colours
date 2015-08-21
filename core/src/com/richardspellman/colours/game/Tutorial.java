package com.richardspellman.colours.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.richardspellman.colours.game.objects.Circle;
import com.richardspellman.colours.game.objects.Column;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by richardspellman on 20/08/15.
 */
public class Tutorial {
  public ArrayList<Circle> circles;
  public Circle red;
  public Circle blue;
  public Circle yellow;
  public Circle purble;
  public Circle orange;
  public Circle green;
  public Circle brown;


    public Tutorial(){
      init();
    }

    public void render(SpriteBatch batch){
      blue.render(batch);
      yellow.render(batch);



    }
    public void init(){
      circles = new ArrayList<Circle>();

      yellow = new Circle(new Vector2(1, 0), 3);
      blue = new Circle(new Vector2(-1, 0), 5);

      circles.add(blue);
      circles.add(yellow);


    }

    public void update(float deltaTime){


    }
  }

