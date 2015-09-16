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
  int nextPosition;

  public Column(){

    circles = new ArrayList<Circle>();
    colours = new int[] {2, 3, 5, 6, 10, 15, 30};
    random = new Random();
  }
  public void update(float deltaTime){

    nextPosition = 0;
    for(int i = 0; i < circles.size(); i++){
      circles.get(i).rank = i;
      circles.get(i).update(deltaTime);
      if(circles.get(i).scale.x < 0.2){
        //circles.get(i).sound.play();
        remove(i);
        nextPosition++;

      }
    }
  }

  public void remove(int index){
    Vector2 newPosition = new Vector2(circles.get(index).getPosition().x, (-nextPosition - 7f) * 1.05f);
    circles.remove(index);
    Circle circle = new Circle(newPosition, colours[random.nextInt(7)]);

    add(circle);
  }

  public void add(Circle c){
    if(circles.size() < 7){
      circles.add(c);
    }
  }

  public void remove(Circle circle){
    circles.remove(circle);
    int rank = circles.size();
    Circle c = new Circle(new Vector2((position - 3.5f) * 1.05f, (-rank) * 1.05f), colours[random.nextInt(7)]);
    add(c);
    c.rank = rank;
  }

  public void render(SpriteBatch batch){
    for(Circle c : circles){
      c.render(batch);
    }
  }
}
