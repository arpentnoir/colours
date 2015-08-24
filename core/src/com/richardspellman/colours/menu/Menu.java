package com.richardspellman.colours.menu;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.richardspellman.colours.game.objects.Circle;
import com.richardspellman.colours.game.objects.Column;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by richardspellman on 24/08/15.
 */
public class Menu {

    public ArrayList<Button> menuItems;

    public Menu(){
      init();
    }

    public void render(SpriteBatch batch){
      for(Button b : menuItems){
        b.render(batch);
      }
     
    }
    public void init(){
      menuItems = new ArrayList<Button>();
      // (±1, ±(1+√2))
      // (±(1+√2), ±1).
      menuItems.add(new Button(new Vector2(0.5f, (float) Math.sqrt(2)), "about"));
      menuItems.add(new Button(new Vector2(0.5f, -(2 + (float) Math.sqrt(2))), "settings"));
      menuItems.add(new Button(new Vector2(-1.5f, ((float) Math.sqrt(2))), "achievements"));
      menuItems.add(new Button(new Vector2(-1.5f, -(2 + (float) Math.sqrt(2))), "endless"));
      menuItems.add(new Button(new Vector2((0.5f + (float) Math.sqrt(2)), 0), "moves"));
      menuItems.add(new Button(new Vector2((0.5f + (float) Math.sqrt(2)), -2), "powerup"));
      menuItems.add(new Button(new Vector2(-(1.5f + (float) Math.sqrt(2)), 0), "redButton"));
      menuItems.add(new Button(new Vector2(-(1.5f + (float) Math.sqrt(2)), -2), "timed"));


    }


    public void update(float deltaTime){
      //checkRows();
      //checkColumns();


    }
  }

