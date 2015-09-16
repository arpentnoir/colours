package com.richardspellman.colours.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.richardspellman.colours.game.WorldController;
import com.richardspellman.colours.util.Assets;
import com.richardspellman.colours.util.Constants;

import java.util.ArrayList;

/**
 * Created by richardspellman on 24/08/15.
 */
public class MenuRenderer implements Disposable{


  private OrthographicCamera camera;
  private OrthographicCamera cameraGUI;
  private SpriteBatch batch;
  private MenuController menuController;
  private Box2DDebugRenderer debugRenderer;
  private ShapeRenderer shapeRenderer;
  Matrix4 debugMatrix;

  public MenuRenderer(MenuController menuController){
    this.menuController = menuController;
    init();
  }

  private void init(){
    batch = new SpriteBatch();
    camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
    camera.position.set(0, 0, 0);
    camera.update();
    cameraGUI = new OrthographicCamera(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
    cameraGUI.position.set(0, 0, 0);
    cameraGUI.setToOrtho(true); // flip y-axis
    cameraGUI.update();

    debugRenderer = new Box2DDebugRenderer();
    debugMatrix = new Matrix4(camera.combined);
    debugMatrix.scale(0.5f, 0.5f, 0.5f);
    shapeRenderer = new ShapeRenderer();
  }

  public void render(){
    renderMenu(batch);
    System.out.println(Gdx.input.getAccelerometerX());
    //debugRenderer.render(menuController.world, camera.combined);
    //renderDebug(batch);
  }

  public void renderMenu(SpriteBatch batch){
    //worldController.cameraHelper.applyTo(camera);
    batch.setProjectionMatrix(camera.combined);
    batch.begin();
    menuController.menu.render(batch);
    Assets.instance.fonts.defaultBig.draw(batch, "(" + menuController.mouseX + ", " + menuController.mouseY + ")", 200, 50);
    batch.end();

  }

  public void renderDebug(SpriteBatch batch){

    shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
    shapeRenderer.setProjectionMatrix(camera.combined);
    //shapeRenderer.circle(menuController.menu.menuItems.get(0).getPosition().x, menuController.menu.menuItems.get(0).getPosition().x, 0.2f);
    shapeRenderer.setColor(Color.BLUE);
    //shapeRenderer.line(-5, menuController.menu.b.getPosition().y, 5, menuController.menu.b.getPosition().y);
    shapeRenderer.line(-Constants.VIEWPORT_WIDTH / 2.0f, 0, Constants.VIEWPORT_WIDTH / 2.0f, 0);
    shapeRenderer.line(-Constants.VIEWPORT_WIDTH / 2, 1, Constants.VIEWPORT_WIDTH / 2, 1);
    shapeRenderer.line(-Constants.VIEWPORT_WIDTH / 2, 2, Constants.VIEWPORT_WIDTH / 2, 2);
    shapeRenderer.line(-Constants.VIEWPORT_WIDTH / 2, 3, Constants.VIEWPORT_WIDTH / 2, 3);
    shapeRenderer.line(-Constants.VIEWPORT_WIDTH / 2, 4, Constants.VIEWPORT_WIDTH / 2, 4);
    shapeRenderer.line(-Constants.VIEWPORT_WIDTH / 2, 5, Constants.VIEWPORT_WIDTH / 2, 5);
    shapeRenderer.line(-Constants.VIEWPORT_WIDTH / 2, 6, Constants.VIEWPORT_WIDTH / 2, 6);
    shapeRenderer.line(-Constants.VIEWPORT_WIDTH / 2, 7, Constants.VIEWPORT_WIDTH / 2, 7);
    shapeRenderer.line(-Constants.VIEWPORT_WIDTH / 2, 8, Constants.VIEWPORT_WIDTH / 2, 8);
    shapeRenderer.line(-Constants.VIEWPORT_WIDTH / 2, -1, Constants.VIEWPORT_WIDTH / 2, -1);
    shapeRenderer.line(-Constants.VIEWPORT_WIDTH / 2, -2, Constants.VIEWPORT_WIDTH / 2, -2);
    shapeRenderer.line(-Constants.VIEWPORT_WIDTH / 2, -3, Constants.VIEWPORT_WIDTH / 2, -3);
    shapeRenderer.line(-Constants.VIEWPORT_WIDTH / 2, -4, Constants.VIEWPORT_WIDTH / 2, -4);
    shapeRenderer.line(-Constants.VIEWPORT_WIDTH / 2, -5, Constants.VIEWPORT_WIDTH / 2, -5);
    shapeRenderer.line(-Constants.VIEWPORT_WIDTH / 2, -6, Constants.VIEWPORT_WIDTH / 2, -6);
    shapeRenderer.line(-Constants.VIEWPORT_WIDTH / 2, -7, Constants.VIEWPORT_WIDTH / 2, -7);
    shapeRenderer.line(-Constants.VIEWPORT_WIDTH / 2, -8, Constants.VIEWPORT_WIDTH / 2, -8);

    shapeRenderer.line(0, -Constants.VIEWPORT_HEIGHT / 2, 0, Constants.VIEWPORT_HEIGHT / 2);
    shapeRenderer.line(1, -Constants.VIEWPORT_HEIGHT / 2, 1, Constants.VIEWPORT_HEIGHT / 2);
    shapeRenderer.line(2, -Constants.VIEWPORT_HEIGHT / 2, 2, Constants.VIEWPORT_HEIGHT / 2);
    shapeRenderer.line(3, -Constants.VIEWPORT_HEIGHT / 2, 3, Constants.VIEWPORT_HEIGHT / 2);
    shapeRenderer.line(4, -Constants.VIEWPORT_HEIGHT / 2, 4, Constants.VIEWPORT_HEIGHT / 2);
    shapeRenderer.line(5, -Constants.VIEWPORT_HEIGHT / 2, 5, Constants.VIEWPORT_HEIGHT / 2);
    shapeRenderer.line(-1, -Constants.VIEWPORT_HEIGHT / 2, -1, Constants.VIEWPORT_HEIGHT / 2);
    shapeRenderer.line(-2, -Constants.VIEWPORT_HEIGHT / 2, -2, Constants.VIEWPORT_HEIGHT / 2);
    shapeRenderer.line(-3, -Constants.VIEWPORT_HEIGHT / 2, -3, Constants.VIEWPORT_HEIGHT / 2);
    shapeRenderer.line(-4, -Constants.VIEWPORT_HEIGHT / 2, -4, Constants.VIEWPORT_HEIGHT / 2);
    shapeRenderer.line(-5, -Constants.VIEWPORT_HEIGHT / 2, -5, Constants.VIEWPORT_HEIGHT / 2);


    //Array<Body> bodies = new Array();
    //menuController.world.getBodies(bodies);
    //for(Body bod : bodies ){
      //System.out.println("Drawing line at y = " + bod.getPosition().y);
      //shapeRenderer.line(-5, bod.getPosition().y, 5, bod.getPosition().y);
      //shapeRenderer.circle(bod.getPosition().x, bod.getPosition().y, 1);
    //}

    // about position
    //shapeRenderer.circle(menuController.menu.menuItems.get(0).body.getPosition().x, menuController.menu.menuItems.get(0).body.getPosition().x, 1);
    /*shapeRenderer.line(menuController.menu.menuItems.get(0).body.getPosition().x,
        menuController.menu.menuItems.get(0).body.getPosition().y + 1,
        menuController.menu.menuItems.get(0).body.getPosition().x,
        menuController.menu.menuItems.get(0).body.getPosition().y - 1);
    shapeRenderer.line(menuController.menu.menuItems.get(0).body.getPosition().x - 1,
        menuController.menu.menuItems.get(0).body.getPosition().y,
        menuController.menu.menuItems.get(0).body.getPosition().x + 1,
        menuController.menu.menuItems.get(0).body.getPosition().y);
    */
    // about centre
    //shapeRenderer.line(menuController.menu.menuItems.get(0).body.centre.x,
    //    menuController.menu.menuItems.get(0).body.centre.y + 1,
    //    menuController.menu.menuItems.get(0).body.centre.x,
    //    menuController.menu.menuItems.get(0).body.centre.y - 1);
    //shapeRenderer.line(menuController.menu.menuItems.get(0).body.centre.x - 1,
    //    menuController.menu.menuItems.get(0).body.centre.y,
    //    menuController.menu.menuItems.get(0).body.centre.x + 1,
    //    menuController.menu.menuItems.get(0).body.centre.y);

    /*shapeRenderer.line(menuController.menu.menuItems.get(1).getPosition().x,
        menuController.menu.menuItems.get(1).getPosition().y + 1,
        menuController.menu.menuItems.get(1).getPosition().x,
        menuController.menu.menuItems.get(1).getPosition().y - 1);
    shapeRenderer.line(menuController.menu.menuItems.get(1).getPosition().x - 1,
        menuController.menu.menuItems.get(1).getPosition().y,
        menuController.menu.menuItems.get(1).getPosition().x + 1,
        menuController.menu.menuItems.get(1).getPosition().y);

    shapeRenderer.line(menuController.menu.menuItems.get(2).getPosition().x,
        menuController.menu.menuItems.get(2).getPosition().y + 1,
        menuController.menu.menuItems.get(2).getPosition().x,
        menuController.menu.menuItems.get(2).getPosition().y - 1);
    shapeRenderer.line(menuController.menu.menuItems.get(2).getPosition().x - 1,
        menuController.menu.menuItems.get(2).getPosition().y,
        menuController.menu.menuItems.get(2).getPosition().x + 1,
        menuController.menu.menuItems.get(2).getPosition().y);

    shapeRenderer.line(menuController.menu.menuItems.get(3).getPosition().x,
        menuController.menu.menuItems.get(3).getPosition().y + 1,
        menuController.menu.menuItems.get(3).getPosition().x,
        menuController.menu.menuItems.get(3).getPosition().y - 1);
    shapeRenderer.line(menuController.menu.menuItems.get(3).getPosition().x - 1,
        menuController.menu.menuItems.get(3).getPosition().y,
        menuController.menu.menuItems.get(3).getPosition().x + 1,
        menuController.menu.menuItems.get(3).getPosition().y);

    shapeRenderer.line(menuController.menu.menuItems.get(4).getPosition().x,
        menuController.menu.menuItems.get(4).getPosition().y + 1,
        menuController.menu.menuItems.get(4).getPosition().x,
        menuController.menu.menuItems.get(4).getPosition().y - 1);
    shapeRenderer.line(menuController.menu.menuItems.get(4).getPosition().x - 1,
        menuController.menu.menuItems.get(4).getPosition().y,
        menuController.menu.menuItems.get(4).getPosition().x + 1,
        menuController.menu.menuItems.get(4).getPosition().y);

    shapeRenderer.line(menuController.menu.menuItems.get(5).getPosition().x,
        menuController.menu.menuItems.get(5).getPosition().y + 1,
        menuController.menu.menuItems.get(5).getPosition().x,
        menuController.menu.menuItems.get(5).getPosition().y - 1);
    shapeRenderer.line(menuController.menu.menuItems.get(5).getPosition().x - 1,
        menuController.menu.menuItems.get(5).getPosition().y,
        menuController.menu.menuItems.get(5).getPosition().x + 1,
        menuController.menu.menuItems.get(5).getPosition().y);

    shapeRenderer.line(menuController.menu.menuItems.get(6).getPosition().x,
        menuController.menu.menuItems.get(6).getPosition().y + 1,
        menuController.menu.menuItems.get(6).getPosition().x,
        menuController.menu.menuItems.get(6).getPosition().y - 1);
    shapeRenderer.line(menuController.menu.menuItems.get(6).getPosition().x - 1,
        menuController.menu.menuItems.get(6).getPosition().y,
        menuController.menu.menuItems.get(6).getPosition().x + 1,
        menuController.menu.menuItems.get(6).getPosition().y);

    shapeRenderer.line(menuController.menu.menuItems.get(7).getPosition().x,
        menuController.menu.menuItems.get(7).getPosition().y + 1,
        menuController.menu.menuItems.get(7).getPosition().x,
        menuController.menu.menuItems.get(7).getPosition().y - 1);
    shapeRenderer.line(menuController.menu.menuItems.get(7).getPosition().x - 1,
        menuController.menu.menuItems.get(7).getPosition().y,
        menuController.menu.menuItems.get(7).getPosition().x + 1,
        menuController.menu.menuItems.get(7).getPosition().y);*/

    //shapeRenderer.circle(menuController.menu.menuItems.get(0).getPosition().x, menuController.menu.menuItems.get(0).getPosition().y, 0.1f);

    //shapeRenderer.circle(0, 0, 5, 5);
    shapeRenderer.end();
  }

  public void resize(int width, int height){
    camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / height) * width;
    camera.update();
    cameraGUI.viewportHeight = Constants.VIEWPORT_GUI_HEIGHT;
    cameraGUI.viewportWidth = (Constants.VIEWPORT_GUI_HEIGHT / (float) height) * (float) width;
    cameraGUI.position.set(cameraGUI.viewportWidth / 2, cameraGUI.viewportHeight / 2, 0);
    cameraGUI.update();
  }

  private void renderGuiScore(SpriteBatch batch){
    float x = -15;
    float y = -15;
    //batch.draw(Assets.instance.goldCoin.goldCoin, x, y, 50, 50, 100, 100, 0.35f, -0.35f, 0);
    //Assets.instance.fonts.defaultBig.draw(batch, "" + worldController.score, x + 75, y + 37);
  }

  private void renderGuiExtraLive(SpriteBatch batch){
    float x = cameraGUI.viewportWidth - 50 - Constants.LIVES_START * 50;
    float y = -15;
    for(int i = 0; i < Constants.LIVES_START; i++){
      //  if(worldController.lives <= 1) {
      //    batch.setColor(0.5f, 0.5f, 0.5f, 0.5f);
      //  }
      //batch.draw(Assets.instance.bunny.head, x + i * 50, y, 50, 50, 120, 100, 0.35f, -0.35f, 0);
      batch.setColor(1, 1, 1, 1);
    }
  }

  private void renderGuiFpsCounter(SpriteBatch batch){
    float x = cameraGUI.viewportWidth - 55;
    float y = cameraGUI.viewportHeight - 15;
    int fps = Gdx.graphics.getFramesPerSecond();
    //BitmapFont fpsFont = Assets.instance.fonts.defaultNormal;

   /* if(fps >= 45){
      // 45 or more FPS show up in green
      fpsFont.setColor(0, 1, 0, 1);
    } else if (fps >= 30){
      // 30 or more FPS show up in yellow
      fpsFont.setColor(1, 1, 0, 1);
    } else {
      // less than 30 FPS show up in red
      fpsFont.setColor(1, 0, 0, 1);
    }
    fpsFont.draw(batch, "FPS: " + fps, x, y);
    fpsFont.setColor(1, 1, 1, 1); // white
    */
  }

  private void renderGui(SpriteBatch batch){
    batch.setProjectionMatrix(cameraGUI.combined);
    batch.begin();

    // draw collected gold coins icon + text
    // (anchored to top left edge)
    renderGuiScore(batch);

    // draw extra lives icon + text (anchored to top right edge)
    renderGuiExtraLive(batch);

    // draw FPS text (anchored to bottom right edge)
    renderGuiFpsCounter(batch);
    batch.end();
  }

  @Override
  public void dispose() {
    batch.dispose();
  }
}
