package com.richardspellman.colours.game.renderers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.richardspellman.colours.game.controllers.PowerupController;
import com.richardspellman.colours.util.Assets;
import com.richardspellman.colours.util.Constants;

/**
 * Created by richardspellman on 21/09/15.
 */
public class PowerupsRenderer implements Disposable {


  private OrthographicCamera camera;
  private SpriteBatch batch;
  private PowerupController powerupController;


  public PowerupsRenderer(PowerupController powerupController){
    this.powerupController = powerupController;
    init();
  }

  private void init(){
    batch = new SpriteBatch();
    camera = new OrthographicCamera(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
    camera.position.set(0, 0, 0);
    camera.setToOrtho(true);
    camera.update();

  }

  public void render(){
    renderPowerups(batch);
  }

  public void renderPowerups(SpriteBatch batch){
    batch.setProjectionMatrix(camera.combined);
    batch.begin();
    Assets.instance.fonts.defaultBig.draw(batch, "Powerups", 0, 0);
    batch.end();

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

