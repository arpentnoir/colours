package com.richardspellman.colors.game.renderers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.richardspellman.colors.game.controllers.AchievementsController;
import com.richardspellman.colors.util.Assets;
import com.richardspellman.colors.util.Constants;

/**
 * Created by richardspellman on 21/09/15.
 */
public class AchievementsRenderer implements Disposable{


    private OrthographicCamera camera;
    private SpriteBatch batch;
    private AchievementsController achievementsController;
    float stringWidth;



    public AchievementsRenderer(AchievementsController achievementsController){
      this.achievementsController = achievementsController;
      init();
    }

    private void init(){
      batch = new SpriteBatch();
      camera = new OrthographicCamera(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
      camera.position.set(0, 0, 0);
      camera.setToOrtho(true);
      camera.update();

      GlyphLayout layout = new GlyphLayout(); //dont do this every frame! Store it as member
      layout.setText(Assets.instance.fonts.defaultBig, "Achievements");
      stringWidth = layout.width;// contains the width of the current set text
      //float height = layout.height; // contains the height of the current set text

    }

    public void render(){
      renderAchievements(batch);
    }

    public void renderAchievements(SpriteBatch batch){
      batch.setProjectionMatrix(camera.combined);
      batch.begin();
      Assets.instance.fonts.defaultBig.draw(batch, "Achievements", (int) (Constants.VIEWPORT_GUI_WIDTH / 2 - stringWidth / 2), 50);
      Assets.instance.fonts.defaultSmall.draw(batch, "Timed High score: " + Assets.instance.preferences.getInteger("timedHighScoreValue", 0), 10, 100);
      Assets.instance.fonts.defaultSmall.draw(batch, "Moves High score: " + Assets.instance.preferences.getInteger("movesHighScoreValue", 0), 10, 150);
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


