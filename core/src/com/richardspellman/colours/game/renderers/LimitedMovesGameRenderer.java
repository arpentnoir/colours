package com.richardspellman.colours.game.renderers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.richardspellman.colours.game.controllers.LimitedMovesGameController;
import com.richardspellman.colours.util.Assets;
import com.richardspellman.colours.util.Constants;

/**
 * Created by richardspellman on 21/09/15.
 */
public class LimitedMovesGameRenderer implements Disposable {


  private OrthographicCamera camera;
  private OrthographicCamera gridCamera;
  private SpriteBatch gridBatch;
  private SpriteBatch batch;
  private LimitedMovesGameController limitedMovesGameController;


  public LimitedMovesGameRenderer(LimitedMovesGameController limitedMovesGameController){
    this.limitedMovesGameController = limitedMovesGameController;
    init();
  }

  private void init(){
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
    renderLimitedMovesGame(batch);
    renderGrid(gridBatch);

  }

  public void renderLimitedMovesGame(SpriteBatch batch){
    batch.setProjectionMatrix(camera.combined);
    batch.begin();
    renderPowerupsMenu(batch);
    renderTimer(batch);
    renderScore(batch);
    //Assets.instance.fonts.defaultBig.draw(batch, "Limited Moves Game", 0, 0);
    batch.end();

  }

  public void renderTimer(SpriteBatch batch){
    Assets.instance.fonts.defaultSmall.draw(batch, "Moves  " + String.format("%.0f%n", limitedMovesGameController.getGame().getMoves()), Constants.VIEWPORT_GUI_WIDTH / 6, Constants.VIEWPORT_GUI_HEIGHT / 20);

  }

  public void renderGrid(SpriteBatch batch){
    batch.setProjectionMatrix(gridCamera.combined);
    batch.begin();
    limitedMovesGameController.getGame().getGrid().render(batch);

    batch.end();
  }

  public void renderPowerupsMenu(SpriteBatch batch){

  }

  public void renderScore(SpriteBatch batch){
    Assets.instance.fonts.defaultSmall.draw(batch, "Score  " + limitedMovesGameController.getGame().getScore(), (Constants.VIEWPORT_GUI_WIDTH / 6) * 4, Constants.VIEWPORT_GUI_HEIGHT / 20);

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

