package com.richardspellman.colors;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.richardspellman.colors.game.screens.MenuScreen;
import com.richardspellman.colors.util.Assets;

public class ColorsMain extends Game {
	SpriteBatch batch;
	Preferences preferences;

	private static final String TAG = ColorsMain.class.getName();

	private boolean paused;


	@Override
	public void create () {
		batch = new SpriteBatch();

		// Set Libgdx log level to DEBUG
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		// Load assets
		Assets.instance.init(new AssetManager());

		// display logo/splash screen
		// check if this is the first time playing the game on this device
		// load settings
		// if first time, go to tutorial
		// else, go to menu screen

		setScreen(new MenuScreen(this));

		// Game world is active on start
		paused = false;
	}

}