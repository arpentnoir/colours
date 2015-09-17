package com.richardspellman.colours.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.richardspellman.colours.game.objects.Circle;
import com.richardspellman.colours.game.objects.Column;
import com.richardspellman.colours.menu.Button;
import com.richardspellman.colours.util.Constants;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by richardspellman on 30/06/15.
 */
public class Level {
  public Column[] columns;
  public ArrayList<Circle> components;
  public ArrayList<Circle> removalQueue;
  public int[] colours;
  Random random;
  int score;
  private boolean timerOn = false;
  float time = 60;


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

    float deltaTime = Gdx.graphics.getDeltaTime();
    time -= deltaTime;

  }
  public void init(String filename){
    columns = new Column[7];
    components = new ArrayList<Circle>();
    random = new Random();
    colours = new int[] {2, 3, 5, 6, 10, 15, 30};
    removalQueue = new ArrayList<Circle>();



    for(int x = 0; x < 7; x++){
      Column c = new Column();
      columns[x] = c;
      c.position = x;
      for(int y = 0; y < 7; y++){
        Circle circle = new Circle(new Vector2((x - 3.5f) * 1.05f, (7 - y - 3.5f) * 1.05f), colours[random.nextInt(7)]);
        circle.rank = y;
        c.add(circle);

      }
    }
  }

  public void checkColumns(){
    int previousColour;
    int count = 1;
    int firstIndex;
    int lastIndex;
    for(int i = 0; i < columns.length; i++) {
      count = 1;
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
            removalQueue.add(columns[i].circles.get(j));
            columns[i].circles.get(j).sound.play();
            switch (columns[i].circles.get(j).colour){
              case 2:
                score += 4;
                break;
              case 3:
                score += 4;
                break;
              case 5:
                score += 4;
                break;
              case 6:
                score += 2;
                break;
              case 10:
                score += 2;
                break;
              case 15:
                score += 2;
                break;
              case 30:
                time += 2;
                break;
              default:
                break;
            }
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
        count = 1;
        for (int i = 1; i < columns.length; i++) {
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
            removalQueue.add(columns[i].circles.get(j));
            columns[i].circles.get(j).sound.play();
            switch (columns[i].circles.get(i).colour){
              case 2:
                score += 4;
                break;
              case 3:
                score += 4;
                break;
              case 5:
                score += 4;
                break;
              case 6:
                score += 2;
                break;
              case 10:
                score += 2;
                break;
              case 15:
                score += 2;
                break;
              case 30:
                time += 2;
                break;
              default:
                break;
            }
          }
        }
      }
  }

  public void update(float deltaTime){
    //checkRows();
    //checkColumns();
    for(Column c : columns){
      c.update(deltaTime);
    }

  }
}
