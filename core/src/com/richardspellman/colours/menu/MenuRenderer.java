package com.richardspellman.colours.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.Disposable;
import com.richardspellman.colours.game.WorldController;
import com.richardspellman.colours.util.Constants;

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

    shapeRenderer = new ShapeRenderer();
  }

  public void render(){
    renderMenu(batch);
    //renderDebug(batch);
  }

  public void renderMenu(SpriteBatch batch){
    //worldController.cameraHelper.applyTo(camera);
    batch.setProjectionMatrix(camera.combined);
    batch.begin();
    menuController.menu.render(batch);
    batch.end();

  }

  public void renderDebug(SpriteBatch batch){

    shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
    shapeRenderer.setProjectionMatrix(camera.combined);
    shapeRenderer.circle(menuController.menu.menuItems.get(0).getPosition().x, menuController.menu.menuItems.get(0).getPosition().x, 0.2f);
    System.out.println(menuController.menu.menuItems.get(0).getPosition());
    System.out.println(menuController.menu.menuItems.get(0).getType());
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
