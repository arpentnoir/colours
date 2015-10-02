package com.richardspellman.colors.game.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.richardspellman.colors.game.controllers.TimedGameController;
import com.richardspellman.colors.util.Assets;
import com.richardspellman.colors.util.Constants;

/**
 * Created by richardspellman on 21/09/15.
 */
public class TimedGameRenderer implements Disposable {

  private OrthographicCamera camera;
  private OrthographicCamera gridCamera;
  private SpriteBatch batch;
  private SpriteBatch gridBatch;
  private TimedGameController timedGameController;

  private static final String TAG = TimedGameRenderer.class.getName();

  public TimedGameRenderer(TimedGameController timedGameController){
    this.timedGameController = timedGameController;
    init();
  }

  private void init(){
    Gdx.app.log(TAG, "Initialising TimedGameRenderer");
    batch = new SpriteBatch();
    camera = new OrthographicCamera(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
    camera.position.set(0, 0, 0);
    camera.setToOrtho(true);
    camera.update();

    gridBatch = new SpriteBatch();
    gridCamera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
    gridCamera.position.set(0, 0, 0);
    gridCamera.setToOrtho(true);
    gridCamera.update();

  }

  public void render(){
    renderTimedGame(batch);
    renderGrid(gridBatch);
  }

  public void renderTimedGame(SpriteBatch batch){

    batch.setProjectionMatrix(camera.combined);
    batch.begin();
    renderPowerupsMenu(batch);
    renderTimer(batch);
    renderScore(batch);
    //Assets.instance.fonts.defaultSmall.draw(batch, "Timed Game", 0, 0);
    batch.end();

  }

  public void renderTimer(SpriteBatch batch){
    Assets.instance.fonts.defaultSmall.draw(batch, "Time  " + String.format("%.0f%n", timedGameController.getGame().getTime()), Constants.VIEWPORT_GUI_WIDTH / 6, Constants.VIEWPORT_GUI_HEIGHT / 20);

  }

  public void renderGrid(SpriteBatch batch){
    batch.setProjectionMatrix(gridCamera.combined);
    batch.begin();
    timedGameController.getGame().getGrid().render(batch);

    batch.end();
  }

  public void renderPowerupsMenu(SpriteBatch batch){

  }

  public void renderScore(SpriteBatch batch){
    Assets.instance.fonts.defaultSmall.draw(batch, "Score  " + timedGameController.getGame().getScore(), (Constants.VIEWPORT_GUI_WIDTH / 6) * 4, Constants.VIEWPORT_GUI_HEIGHT / 20);

  }

  public void renderDebug(SpriteBatch batch){

  }

  public void resize(int width, int height){
    camera.viewportWidth = (Constants.VIEWPORT_GUI_HEIGHT / height) * width;
    camera.update();
  }

  @Override
  public void dispose() {
    batch.dispose();
  }
}

