package com.richardspellman.colours.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by richardspellman on 3/08/15.
 */
public class Column {
  public ArrayList<Circle> circles;
  private int[] colours;
  public int position;
  Random random;

  public Column(){

    circles = new ArrayList<Circle>();
    colours = new int[] {2, 3, 5, 6, 10, 15, 30};
    random = new Random();
  }
  public void update(){

    for(int i = 0; i < circles.size(); i++){
      circles.get(i).rank = i;
      circles.get(i).update();
    }
  }

  public void remove(int index){
    circles.remove(index);
    Circle circle = new Circle(new Vector2((position - 3.5f) * 1.05f, (circles.size() + 6 - 3.5f) * 1.05f), colours[random.nextInt(7)]);
    circles.add(circle);
    //System.out.println("circle size: " + circles.size());
  }

  public void remove(Circle circle){
    circles.remove(circle);
    Circle c = new Circle(new Vector2((position - 3.5f) * 1.05f, (circles.size() + 6 - 3.5f) * 1.05f), colours[random.nextInt(7)]);
    circles.add(c);
    //System.out.println("circle size: " + circles.size());
  }

  public void render(SpriteBatch batch){
    for(Circle c : circles){
      c.render(batch);
    }
  }
}
