package com.richardspellman.colors.game.models;

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
      circles.get(i).setRank(i);
      circles.get(i).update(deltaTime);
      // TODO: check that commenting this out doesn't stuff anything up
      //if(circles.get(i).getScale().x < 0.2){
        //circles.get(i).sound.play();
        //remove(i);
        //nextPosition++;

      //}
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
    float gridX = circle.getGridPosition().x;
    for(int i = 0; i < circles.size(); i++){
      Circle c = circles.get(i);
      c.setGridPosition(new Vector2(gridX, i));
    }
    int rank = circles.size();
    Circle c = new Circle(new Vector2(gridX, rank), colours[random.nextInt(7)]);
    add(c);
    c.setRank(rank);
  }

  @Override
  public String toString(){
    String str = "";
    for(Circle circle : circles){
      str = str + circle.getColour() + " ";
    }
    return str;
  }

  public void render(SpriteBatch batch){
    for(Circle circle : circles){
      circle.render(batch);
    }

  }
}
