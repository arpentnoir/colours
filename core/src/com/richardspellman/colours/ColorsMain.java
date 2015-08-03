package com.richardspellman.colours;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.richardspellman.colours.game.WorldController;
import com.richardspellman.colours.game.WorldRenderer;
import com.richardspellman.colours.game.screens.MenuScreen;
import com.richardspellman.colours.util.Assets;

public class ColorsMain extends Game {
	SpriteBatch batch;
	Texture img;

	private static final String TAG = ColorsMain.class.getName();

	private WorldController worldController;
	private WorldRenderer worldRenderer;

	private boolean paused;


	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		// Set Libgdx log level to DEBUG
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		// Load assets
		Assets.instance.init(new AssetManager());
		setScreen(new MenuScreen(this));

		// Game world is active on start
		paused = true;
	}
/*
	@Override
	public void render () {
		// Do not update the game world when paused
		if(!paused) {
			// Update the game world by the time that has passed
			// since the last rendered frame
			worldController.update(Gdx.graphics.getDeltaTime());
		}
		// Sets the clear screen color to: Cornflower Blue
		Gdx.gl.glClearColor(205.0f / 255.0f, 200.0f / 255.0f, 177.0f / 255.0f, 0xff / 255.0f);

		// Clears the screen
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Render the game world to the screen
		worldRenderer.render();
	}*/
}