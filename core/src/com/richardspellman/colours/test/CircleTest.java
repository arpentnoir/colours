package com.richardspellman.colours.test;

import com.badlogic.gdx.math.Vector2;
import com.richardspellman.colours.game.models.Circle;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by richardspellman on 20/09/15.
 */
public class CircleTest{


  @Test
  public void testCreateCircle() throws Exception{
    Circle circle = new Circle(new Vector2(0, 0), 2);
    assertNotNull(circle);
    assertEquals(new Vector2(0,0), circle.getPosition());
    assertEquals(2, circle.getColour());
  }

  @Test
  public void testUpdate() throws Exception {
    assertTrue(false);
  }


  @Test
  public void testSetColour() throws Exception {
    assertTrue(false);
  }

  @Test
  public void testGetPosition() throws Exception {
    assertTrue(false);
  }

  @Test
  public void testSetPosition() throws Exception {
    assertTrue(false);
  }

  @Test
  public void testGetCentre() throws Exception {
    assertTrue(false);
  }

}