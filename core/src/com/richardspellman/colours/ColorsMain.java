package com.richardspellman.colours;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.richardspellman.colours.game.WorldController;
import com.richardspellman.colours.game.WorldRenderer;
import com.richardspellman.colours.game.screens.GameScreen;
import com.richardspellman.colours.game.screens.MenuScreen;
import com.richardspellman.colours.util.Assets;

public class ColorsMain extends Game {
	SpriteBatch batch;

	private static final String TAG = ColorsMain.class.getName();

	private boolean paused;


	@Override
	public void create () {
		batch = new SpriteBatch();

		// Set Libgdx log level to DEBUG
		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		// Load assets
		Assets.instance.init(new AssetManager());
		setScreen(new MenuScreen(this));

		// Game world is active on start
		paused = false;
	}

}