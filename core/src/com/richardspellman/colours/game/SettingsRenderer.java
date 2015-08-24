package com.richardspellman.colours.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.Disposable;
import com.richardspellman.colours.menu.MenuController;
import com.richardspellman.colours.util.Constants;

/**
 * Created by richardspellman on 24/08/15.
 */
public class SettingsRenderer implements Disposable{



    private OrthographicCamera camera;
    private OrthographicCamera cameraGUI;
    private SpriteBatch batch;
    private SettingsController settingsController;
    private Box2DDebugRenderer debugRenderer;
    private ShapeRenderer shapeRenderer;

    public SettingsRenderer(SettingsController settingsController){
      this.settingsController = settingsController;
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
      renderSettings();
    }

    public void renderSettings(){
      //worldController.cameraHelper.applyTo(camera);
      batch.setProjectionMatrix(camera.combined);
      batch.begin();
      settingsController.settings.render();
      batch.end();

    }


    public void resize(int width, int height){
      camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / height) * width;
      camera.update();
      cameraGUI.viewportHeight = Constants.VIEWPORT_GUI_HEIGHT;
      cameraGUI.viewportWidth = (Constants.VIEWPORT_GUI_HEIGHT / (float) height) * (float) width;
      cameraGUI.position.set(cameraGUI.viewportWidth / 2, cameraGUI.viewportHeight / 2, 0);
      cameraGUI.update();
    }

    @Override
    public void dispose() {
      batch.dispose();
    }
  }

