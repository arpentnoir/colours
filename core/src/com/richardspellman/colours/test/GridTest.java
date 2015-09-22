package com.richardspellman.colours.test;

import com.richardspellman.colours.game.models.Column;
import com.richardspellman.colours.game.models.Grid;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by richardspellman on 19/09/15.
 */
public class GridTest {

  @Test
  public void testMoveCircleBlueAndYellow() throws Exception {
    //Grid
    //Circle circle1 = new Circle(new Vector2(0, 0), 5); // blue
    //Circle circle2 = new Circle(new Vector2(0, 0), 3); // yellow

    //Assert(true, Grid.move)
    assertFalse(true);
  }

  @Test
  public void testInitGrid() throws Exception {
    Grid grid = new Grid();
    assertNotNull(grid.columns);
    assertEquals(7, grid.columns.length);
    for(Column column : grid.columns){
      assertNotNull(column.circles);
      assertEquals(7, column.circles.size());
    }
    // grid should have array of 7 columns
    // each column should have an arraylist of 7 circles
    // grid should not have any scoring runs of circles

  }

  @Test
  public void testInitGridWithArray() throws Exception {
    // grid should match the array passed in to create it
    int[][] array = {{2,  5,  15, 3,  30, 6,  6},
                     {10, 2,  3,  2,  15, 10, 6},
                     {30, 2,  30, 6,  10, 10, 30},
                     {10, 3,  6,  6,  30, 6,  3},
                     {2,  5,  30, 10, 15, 5,  30},
                     {15, 30, 2,  15, 3,  3,  10},
                     {2,  15, 2,  5,  3,  6,  6}};

    Grid grid = new Grid(array);
    assertNotNull(grid.columns);
    assertEquals(7, grid.columns.length);
    for(Column column : grid.columns){
      assertNotNull(column.circles);
      assertEquals(7, column.circles.size());
    }
    assertEquals("2   5   15  3   30  6   6   \n" +
        "10  2   3   2   15  10  6   \n" +
        "30  2   30  6   10  10  30  \n" +
        "10  3   6   6   30  6   3   \n" +
        "2   5   30  10  15  5   30  \n" +
        "15  30  2   15  3   3   10  \n" +
        "2   15  2   5   3   6   6   \n", grid.toString());
  }

  @Test
  public void testColumns(){
    int[][] array = {{2,  5,  15, 3,  30, 6,  6},
        {10, 2,  3,  2,  15, 10, 6},
        {30, 2,  30, 6,  10, 10, 30},
        {10, 3,  6,  6,  30, 6,  3},
        {2,  5,  30, 10, 15, 5,  30},
        {15, 30, 2,  15, 3,  3,  10},
        {2,  15, 2,  5,  3,  6,  6}};

    Grid grid = new Grid(array);
    assertNotNull(grid.columns);

    assertEquals("2 10 30 10 2 15 2", grid.columns[0].toString());
    assertEquals("5 2 2 3 5 30 15", grid.columns[0].toString());
    assertEquals("15 3 30 6 30 2 2", grid.columns[0].toString());
    assertEquals("3 2 6 6 10 15 5", grid.columns[0].toString());
    assertEquals("30 15 10 30 15 3 3", grid.columns[0].toString());
    assertEquals("6 10 10 6 5 3 6", grid.columns[0].toString());
    assertEquals("6 6 30 3 30 10 6", grid.columns[0].toString());
  }


  // test for no score, column score, row score, non-intersecting row and column score and intersecting
  // row and column score
  // before, removal queue should be non-empty
  // create temporary reference to items in removal queue
  // check items in removal queue are not present in grid
  // check removal queue is empty

  @Test
  public void testCheckColumnsNoScore() throws Exception {
    int[][] array = {{2,  5,  15, 3,  30, 6,  6},
        {10, 2,  3,  2,  15, 10, 6},
        {30, 2,  30, 6,  10, 10, 30},
        {10, 3,  6,  6,  30, 6,  3},
        {2,  5,  30, 10, 15, 5,  30},
        {15, 30, 2,  15, 3,  3,  10},
        {2,  15, 2,  5,  3,  6,  6}};

    Grid grid = new Grid(array); // initialise the grid with an array containing no scoring runs

    assertNotNull(grid.removalQueue); // check that the removalQueue is not null
    assertEquals(0, grid.removalQueue.size()); // check that removal queue is empty

    grid.checkRows(); // check rows
    assertEquals(0, grid.removalQueue.size()); // check that nothing added to removal queue

    grid.checkColumns(); // check columns
    assertEquals(0, grid.removalQueue.size()); // check that nothing added to removal queue

    assertEquals("2   5   15  3   30  6   6   \n" +
        "10  2   3   2   15  10  6   \n" +
        "30  2   30  6   10  10  30  \n" +
        "10  3   6   6   30  6   3   \n" +
        "2   5   30  10  15  5   30  \n" +
        "15  30  2   15  3   3   10  \n" +
        "2   15  2   5   3   6   6   \n", grid.toString());
  }


  @Test
  public void testCheckColumnsWithScore() throws Exception{
    int[][] array = {{2,  5,  15, 3,  30, 6,  6},
        {10, 2,  3,  2,  15, 10, 6},
        {30, 2,  30, 6,  10, 10, 30},
        {10, 3,  2,  6,  30, 10,  3},
        {2,  5,  2, 10, 15, 10,  30},
        {15, 30, 2,  15, 3,  3,  10},
        {2,  15, 2,  5,  3,  6,  6}};

    Grid grid = new Grid(array); // initialise the grid with an array containing no scoring runs

    assertNotNull(grid.removalQueue); // check that the removalQueue is not null
    assertEquals(0, grid.removalQueue.size()); // check that removal queue is empty

    grid.checkRows(); // check rows
    assertEquals(0, grid.removalQueue.size()); // check that nothing added to removal queue

    grid.checkColumns(); // check columns
    assertEquals(8, grid.removalQueue.size()); // check that nothing added to removal queue

    assertEquals(12, grid.getScore());

    assertEquals("2   5   15  3   30  6   6   \n" +
        "10  2   3   2   15  10  6   \n" +
        "30  2   30  6   10  10  30  \n" +
        "10  3   2   6   30  10  3   \n" +
        "2   5   2   10  15  10  30  \n" +
        "15  30  2   15  3   3   10  \n" +
        "2   15  2   5   3   6   6   \n", grid.toString());

  }

  @Test
  public void testCheckRowsWithScore() throws Exception{
    int[][] array = {{2,  5,  15, 3,  30, 6,  6},
        {10, 2,  3,  2,  15, 10, 6},
        {30, 2,  30, 10,  10, 10, 10},
        {10, 3,  6,  6,  30, 6,  3},
        {2,  5,  30, 10, 15, 5,  30},
        {15, 30, 2,  15, 3,  3,  10},
        {2,  2, 2,  2,  3,  6,  6}};

    Grid grid = new Grid(array); // initialise the grid with an array containing no scoring runs

    assertNotNull(grid.removalQueue); // check that the removalQueue is not null
    assertEquals(0, grid.removalQueue.size()); // check that removal queue is empty

    grid.checkColumns(); // check columns
    assertEquals(0, grid.removalQueue.size()); // check that nothing added to removal queue

    grid.checkRows(); // check rows
    assertEquals(8, grid.removalQueue.size()); // check that nothing added to removal queue

    assertEquals(12, grid.getScore());

    assertEquals("2   5   15  3   30  6   6   \n" +
        "10  2   3   2   15  10  6   \n" +
        "30  2   30  10  10  10  10  \n" +
        "10  3   6   6   30  6   3   \n" +
        "2   5   30  10  15  5   30  \n" +
        "15  30  2   15  3   3   10  \n" +
        "2   2   2   2   3   6   6   \n", grid.toString());

  }

  @Test
  public void testRemoveScoringRunsColumnScore() throws Exception {

    assertFalse(true);
  }

  @Test
  public void testRemoveScoringRunsRowScore() throws Exception {

    assertFalse(true);
  }

  @Test
  public void testCheckColumns() throws Exception {
    assertFalse(true);
    //
  }

  @Test
  public void testCheckRows() throws Exception {
    assertFalse(true);
  }

  @Test
  public void testMoveCircle() throws Exception {
    assertFalse(true);
  }

  @Test
  public void testToString() throws Exception {
    int[][] array = {{2,  5,  15, 3,  30, 6,  6},
        {10, 2,  3,  2,  15, 10, 6},
        {30, 2,  30, 6,  10, 10, 30},
        {10, 3,  6,  6,  30, 6,  3},
        {2,  5,  30, 10, 15, 5,  30},
        {15, 30, 2,  15, 3,  3,  10},
        {2,  15, 2,  5,  3,  6,  6}};
    Grid grid = new Grid(array);
    assertEquals("2   5   15  3   30  6   6   \n" +
        "10  2   3   2   15  10  6   \n" +
        "30  2   30  6   10  10  30  \n" +
        "10  3   6   6   30  6   3   \n" +
        "2   5   30  10  15  5   30  \n" +
        "15  30  2   15  3   3   10  \n" +
        "2   15  2   5   3   6   6   \n", grid.toString());
  }
}