package com.richardspellman.colors.game.renderers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.richardspellman.colors.game.controllers.EndGameController;
import com.richardspellman.colors.game.controllers.SettingsController;
import com.richardspellman.colors.game.models.BaseGame;
import com.richardspellman.colors.game.models.EndGame;
import com.richardspellman.colors.util.Assets;
import com.richardspellman.colors.util.Constants;

/**
 * Created by richardspellman on 30/09/15.
 */
public class EndGameRenderer implements Disposable{


  private OrthographicCamera camera;
  private SpriteBatch batch;
  private EndGameController endGameController;
  float stringWidth;


  public EndGameRenderer(EndGameController endGameController){
    this.endGameController = endGameController;
    init();
  }

  private void init(){
    batch = new SpriteBatch();
    camera = new OrthographicCamera(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
    camera.position.set(0, 0, 0);
    camera.setToOrtho(true);
    camera.update();

    GlyphLayout layout = new GlyphLayout();
    layout.setText(Assets.instance.fonts.defaultBig, "Game Over");
    stringWidth = layout.width;


  }

  public void render(){
    renderSettings(batch);
  }

  public void renderSettings(SpriteBatch batch){
    batch.setProjectionMatrix(camera.combined);
    batch.begin();
    Assets.instance.fonts.defaultBig.draw(batch, "Game Over", (int) (Constants.VIEWPORT_GUI_WIDTH / 2 - stringWidth / 2), 50);
    Assets.instance.fonts.defaultBig.draw(batch, ((BaseGame) endGameController.getGame()).getScore(), )
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

