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

    for(int x = 0; x < 7; x++){
      Column c = new Column();
      columns[x] = c;
      for(int y = 0; y < 7; y++){
        Circle circle = new Circle(new Vector2((x - 3.5f) * 1.05f, (y - 3.5f) * 1.05f), random.nextInt(7));
        circle.rank = y;
        c.circles.add(circle);

      }
    }
  }

  public void update(float deltaTime){
    for(Column c : columns){
      c.update();
    }
  }
}
