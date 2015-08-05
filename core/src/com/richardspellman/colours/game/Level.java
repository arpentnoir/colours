package com.richardspellman.colours.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.richardspellman.colours.game.objects.Circle;
import com.richardspellman.colours.game.objects.Column;
import com.richardspellman.colours.util.Constants;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by richardspellman on 30/06/15.
 */
public class Level {
  public Column[] columns;
  public ArrayList<Circle> components;
  public int[] colours;
  Random random;

  public Level(String filename){
    init(filename);
  }

  public void render(SpriteBatch batch){
    for(Column c : columns){
      c.render(batch);
    }
    for(Circle c : components){
      c.render(batch);
    }
  }
  public void init(String filename){
    columns = new Column[7];
    components = new ArrayList<Circle>();
    random = new Random();
    colours = new int[] {2, 3, 5, 6, 10, 15, 30};

    for(int x = 0; x < 7; x++){
      Column c = new Column();
      columns[x] = c;
      c.position = x;
      for(int y = 0; y < 7; y++){
        Circle circle = new Circle(new Vector2((x - 3.5f) * 1.05f, (y - 3.5f) * 1.05f), colours[random.nextInt(7)]);
        circle.rank = y;
        c.circles.add(circle);

      }
    }
  }

  public void checkColumns(){
    int previousColour;
    int count = 1;
    int firstIndex;
    int lastIndex;
    for(int i = 0; i < columns.length; i++) {
      if (columns[i].circles.size() > 0) {
        previousColour = columns[i].circles.get(0).colour;
        firstIndex = 0;
        lastIndex = 0;
        for (int j = 1; j < columns[i].circles.size(); j++) {
          if (columns[i].circles.get(j).colour == previousColour) {
            count++;
            lastIndex = j;
          } else {
            if (count < 4) {
              count = 1;
              previousColour = columns[i].circles.get(j).colour;
              firstIndex = j;
              lastIndex = j;
            } else {
              break; // already found a sequence of 4, this colour different so no use completing the loop
            }
          }
        }
        if (count >= 4) {
          for (int j = firstIndex; j <= lastIndex; j++) {
            System.out.println("start: " + firstIndex + " end: " + lastIndex);
            columns[i].remove(firstIndex);
          }
        }
      }
    }
  }

  public void checkRows(){
    int previousColour;
    int count = 1;
    int firstIndex;
    int lastIndex;
    for(int j = 0; j < 7; j++) {
        previousColour = columns[0].circles.get(j).colour;
        firstIndex = 0;
        lastIndex = 0;
        for (int i = 1; i < columns.length; i++) {
          System.out.println("checking column " + columns[i].position);
          if (columns[i].circles.get(j).colour == previousColour) {
            count++;
            lastIndex = i;
          } else {
            if (count < 4) {
              count = 1;
              previousColour = columns[i].circles.get(j).colour;
              firstIndex = i;
              lastIndex = i;
            } else {
              break; // already found a sequence of 4, this colour different so no use completing the loop
            }
          }
        }
        if (count >= 4) {
          for (int i = firstIndex; i <= lastIndex; i++) {
            System.out.println("start: " + firstIndex + " end: " + lastIndex);
            columns[i].remove(j);
          }
        }
      }
  }

  public void update(float deltaTime){
    //checkRows();
    //checkColumns();
    for(Column c : columns){
      c.update();
    }

  }
}
