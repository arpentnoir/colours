package com.richardspellman.colours.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by richardspellman on 3/08/15.
 */
public class Column {
  public ArrayList<Circle> circles;

  public Column(){
    circles = new ArrayList<Circle>();
  }
  public void update(){
    for(int i = 0; i < circles.size(); i++){
      circles.get(i).rank = i;
      circles.get(i).update();
    }
  }

  public void render(SpriteBatch batch){
    for(Circle c : circles){
      c.render(batch);
    }
  }
}
