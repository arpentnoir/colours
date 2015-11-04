package com.richardspellman.colors.game.models;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by richardspellman on 19/09/15.
 */
public class Grid {

  public Column[] columns;
  private Random random;
  private int[] colours;
  public ArrayList<Circle> removalQueue;


  public Grid(){
    random = new Random();
    colours = new int[] {2, 3, 5, 6, 10, 15, 30};
    initVariables();
    // populate the columns array
    for(int i = 0; i < 7; i++){
      columns[i] = new Column();
    }
    initGrid();
  }

  public Grid(int[][] array){

    initVariables();
    for(int i = 0; i < 7; i++){
      columns[i] = new Column();
    }
    initGridWithArray(array);
  }

  private void initVariables(){
    columns = new Column[7];
    removalQueue = new ArrayList<Circle>();
  }

  public void initGrid(){
    for (int i = 0; i < columns.length; i++){
      Column column = columns[i];

      for(int j = 0; j < 7; j++){
        int primary = random.nextInt(2);
        int colour;
        if(primary == 1){
          colour = random.nextInt(3);
        } else {
          colour = random.nextInt(4) + 3;
        }
        column.add(new Circle(new Vector2(i, j), colours[colour]));
      }
    }
  }

  public void initGridWithArray(int[][] array){
    for(int i = 0; i < 7; i++){
      Column column = columns[i];
      for(int j = 0; j < 7; j++){
        column.add(new Circle(new Vector2(i, j), array[j][i]));
      }
    }
  }

  public void removeScoringRuns(){
    for(Circle circle : removalQueue){
      columns[(int) circle.getGridPosition().x].remove(circle);
    }
    removalQueue = new ArrayList<Circle>();

  }

  public int getBrownCount(){
    int count = 0;
    for(Circle circle : removalQueue){
      if(circle.getColour() == 30){
        count++;
      }
    }
    return count;
  }

  public void checkColumns(){
    int previousColour;
    int count = 1;
    int firstIndex;
    int lastIndex;
    for(int i = 0; i < columns.length; i++) {
      count = 1;
      if (columns[i].circles.size() > 0) {
        previousColour = columns[i].circles.get(0).getColour();
        firstIndex = 0;
        lastIndex = 0;
        for (int j = 1; j < columns[i].circles.size(); j++) {
          if (columns[i].circles.get(j).getColour() == previousColour) {
            count++;
            lastIndex = j;
          } else {
            if (count < 4) {
              count = 1;
              previousColour = columns[i].circles.get(j).getColour();
              firstIndex = j;
              lastIndex = j;
            } else {
              break; // already found a sequence of 4, this colour different so no use completing the loop
            }
          }
        }
        if (count >= 4) {
          for (int j = firstIndex; j <= lastIndex; j++) {
            //System.out.println("adding to removal queue");
            removalQueue.add(columns[i].circles.get(j));
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
      previousColour = columns[0].circles.get(j).getColour();
      firstIndex = 0;
      lastIndex = 0;
      count = 1;
      for (int i = 1; i < columns.length; i++) {
        if (columns[i].circles.get(j).getColour() == previousColour) {
          count++;
          lastIndex = i;
        } else {
          if (count < 4) {
            count = 1;
            previousColour = columns[i].circles.get(j).getColour();
            firstIndex = i;
            lastIndex = i;
          } else {
            break; // already found a sequence of 4, this colour different so no use completing the loop
          }
        }
      }
      if (count >= 4) {
        for (int i = firstIndex; i <= lastIndex; i++) {
          //System.out.println("adding to removal queue");
          removalQueue.add(columns[i].circles.get(j));
        }
      }
    }
  }

  public int getScore() {
    int score = 0;
    for (Circle circle : removalQueue) {
      switch (circle.getColour()) {
        case 2:
          score += 2;
          break;
        case 3:
          score += 2;
          break;
        case 5:
          score += 2;
          break;
        case 6:
          score += 1;
          break;
        case 10:
          score += 1;
          break;
        case 15:
          score += 1;
          break;
        default:
          break;
      }
    }
    return score;
  }

  @Override
  public String toString(){
    String str = "";
    for(int j = 0; j < 7; j++){
      for(int i = 0; i < columns.length; i++){
        str = str + String.format("%1$-4s", columns[i].circles.get(j).getColour());
      }
      str = str + "\n";
    }
    return str;
  }


  public String currentPositionToString(){
    String str = "";
    for(int j = 0; j < 7; j++){
      for(int i = 0; i < columns.length; i++){
        str = str + columns[i].circles.get(j).getCurrentPosition() + " ";
      }
      str = str + "\n";
    }
    return str;
  }

  public void render(SpriteBatch batch){
    for(Column column : columns){
      column.render(batch);
    }
  }

  public void update(float deltaTime){
    for (Column column : columns){
      column.update(deltaTime);
    }
  }

  /**
   * @param fromCircle
   * @param toCircle
   * @return
   */
  public boolean moveCircle(Circle fromCircle, Circle toCircle) {

    return false;
  }
}

