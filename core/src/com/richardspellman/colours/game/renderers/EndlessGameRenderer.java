package com.richardspellman.colours.game.renderers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.richardspellman.colours.game.controllers.EndlessGameController;
import com.richardspellman.colours.util.Assets;
import com.richardspellman.colours.util.Constants;

/**
 * Created by richardspellman on 21/09/15.
 */
public class EndlessGameRenderer implements Disposable {


  private OrthographicCamera camera;
  private SpriteBatch batch;
  private EndlessGameController endlessGameController;
  private OrthographicCamera gridCamera;
  private SpriteBatch gridBatch;


  public EndlessGameRenderer(EndlessGameController endlessGameController){
    this.endlessGameController = endlessGameController;
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

    renderEndlessGame(batch);
    renderGrid(gridBatch);
  }

  public void renderEndlessGame(SpriteBatch batch){
    batch.setProjectionMatrix(camera.combined);
    batch.begin();
    renderPowerupsMenu(batch);
    renderTimer(batch);
    renderScore(batch);
    //Assets.instance.fonts.defaultBig.draw(batch, "Endless Game", 0, 0);
    batch.end();

  }

  public void renderTimer(SpriteBatch batch){

  }

  public void renderGrid(SpriteBatch batch){
    batch.setProjectionMatrix(gridCamera.combined);
    batch.begin();
    endlessGameController.getGame().getGrid().render(batch);

    batch.end();
  }

  public void renderPowerupsMenu(SpriteBatch batch){

  }

  public void renderScore(SpriteBatch batch){
    Assets.instance.fonts.defaultSmall.draw(batch, "Score  " + endlessGameController.getGame().getScore(), (Constants.VIEWPORT_GUI_WIDTH / 6) * 4, Constants.VIEWPORT_GUI_HEIGHT / 20);

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

