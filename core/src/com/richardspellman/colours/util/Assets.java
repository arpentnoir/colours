package com.richardspellman.colours.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.richardspellman.colours.util.Constants;

import java.awt.font.TextAttribute;

/**
 * Created by richardspellman on 31/07/15.
 */


public class Assets implements Disposable, AssetErrorListener {
  public static final String TAG = Assets.class.getName();

  public static final Assets instance = new Assets();

  // game assets
  public AssetRed red;
  public AssetOrange orange;
  public AssetYellow yellow;
  public AssetGreen green;
  public AssetBlue blue;
  public AssetPurple purple;
  public AssetBrown brown;
  public AssetContinuousPlayButton continuousPlayButton;

  // menu assets
  public AssetAbout about;
  public AssetAchievements achievements;
  public AssetEndless endless;
  public AssetMoves moves;
  public AssetPowerup powerup;
  public AssetRedButton redButton;
  public AssetSettings settings;
  public AssetTimed timed;

  // ui assets
  //public AssetCheckOff checkOff;
  //public AssetTextField textField;
  //public AssetCheckOn checkOn;
  //public AssetCursor  cursor;
  //public AseetDefault assDefault;
  //public AssetDefaultPane defaultPane;
  //public AssetDefaultRectPad defaultRectPad;
  //public AssetDefaultPaneNoborder defaultPaneNoborder;
  //public AssetDefaultRect defaultRect;
  //public AssetDefaultRectDown defaultRectDown;
  public AssetDefaultRound defaultRound;
  public AssetDefaultRoundDown defaultRoundDown;
  //public AssetDefaultRoundLarge defaultRoundLarge;
  //public AssetDefaultScroll defaultScroll;
  //public AssetDefaultSelect defaultSelect;
  //public AssetDefaultSelectSelection defaultSelectSelection;
  //public AssetDefaultSlider defaultSlider;
  //public AssetDefaultSliderKnob defaultSliderKnob;
  //public AssetDefaultSplitPane defaultSplitpane;
  //public AssetDefaultSpliPaneVertical defaultSplitpaneVertical;
  //public AssetDefaultWindow defaultWindow;
  //public AssetSelection selection;
  //public AssetTreeMinus treeMinus;
  //public AssetTreePlus treePlus;
  //public AssetWhite white;


  private AssetManager assetManager;
  // singleton: prevent instantiation from other classes
  private Assets(){}

  public void init (AssetManager assetManager){
    this.assetManager = assetManager;

    // Set asset manager error handler
    assetManager.setErrorListener(this);

    // Load texture atlas
    assetManager.load(Constants.TEXTURE_ATLAS_OBJECTS, TextureAtlas.class);

    // Start loading assets and wait until finished
    assetManager.finishLoading();
    Gdx.app.debug(TAG, "# of assets loaded: " + assetManager.getAssetNames().size);
    for(String a : assetManager.getAssetNames()){
      Gdx.app.debug(TAG, "asset: " + a);
    }

    TextureAtlas atlas = assetManager.get(Constants.TEXTURE_ATLAS_OBJECTS);

    // Enable texture filtering for pixel smoothing
    for(Texture t : atlas.getTextures()){
      t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    // Create game resource objects
    red = new AssetRed(atlas);
    yellow = new AssetYellow(atlas);
    orange = new AssetOrange(atlas);
    green = new AssetGreen(atlas);
    blue = new AssetBlue(atlas);
    purple = new AssetPurple(atlas);
    brown = new AssetBrown(atlas);


    // create menu resource objects
    about = new AssetAbout(atlas);
    achievements = new AssetAchievements(atlas);
    endless = new AssetEndless(atlas);
    moves = new AssetMoves(atlas);
    powerup = new AssetPowerup(atlas);
    redButton = new AssetRedButton(atlas);
    settings = new AssetSettings(atlas);
    timed = new AssetTimed(atlas);

    // create ui skin resource objects
    defaultRound = new AssetDefaultRound(atlas);
    defaultRoundDown = new AssetDefaultRoundDown(atlas);
  }

  @Override
  public void dispose(){

    //assetManager.dispose();
    //fonts.defaultSmall.dispose();
    //fonts.defaultNormal.dispose();
    //fonts.defaultBig.dispose();
  }

  //@Override
  //public void error(String filename, Class type, Throwable throwable) {
  //  Gdx.app.error(TAG, "Couldn't load asset '" + filename + "'");
  //}

  @Override
  public void error(AssetDescriptor asset, Throwable throwable){
    Gdx.app.error(TAG, "Couldn't load asset '" + asset.fileName + "'");
  }


  public class AssetBall{
    public final TextureAtlas.AtlasRegion ball;

    public AssetBall(TextureAtlas atlas){
      ball = atlas.findRegion("ball");
    }
  }

  public class AssetRed{
    public final TextureAtlas.AtlasRegion red;

    public AssetRed(TextureAtlas atlas){
      red = atlas.findRegion("red");
    }
  }

  public class AssetOrange{
    public final TextureAtlas.AtlasRegion orange;

    public AssetOrange(TextureAtlas atlas){
      orange = atlas.findRegion("orange");
    }
  }

  public class AssetYellow{
    public final TextureAtlas.AtlasRegion yellow;

    public AssetYellow(TextureAtlas atlas){
      yellow = atlas.findRegion("yellow");
    }
  }

  public class AssetGreen{
    public final TextureAtlas.AtlasRegion green;

    public AssetGreen(TextureAtlas atlas){
      green = atlas.findRegion("green");
    }
  }

  public class AssetBlue{
    public final TextureAtlas.AtlasRegion blue;

    public AssetBlue(TextureAtlas atlas){
      blue = atlas.findRegion("blue");
    }
  }

  public class AssetPurple{
    public final TextureAtlas.AtlasRegion purple;

    public AssetPurple(TextureAtlas atlas){
      purple = atlas.findRegion("purple");
    }
  }

  public class AssetBrown{
    public final TextureAtlas.AtlasRegion brown;

    public AssetBrown(TextureAtlas atlas){
      brown = atlas.findRegion("brown");
    }
  }

  public class AssetContinuousPlayButton{
    public final TextureAtlas.AtlasRegion continuousPlayButton;

    public AssetContinuousPlayButton(TextureAtlas atlas) { continuousPlayButton = atlas.findRegion("continuousPlayButton");}
  }

  // *** Menu Assets ***

  // ABOUT
  public class AssetAbout{
    public final TextureAtlas.AtlasRegion about;

    public AssetAbout(TextureAtlas atlas) { about = atlas.findRegion("about");}
  }

  // ACHIEVEMENTS
  public class AssetAchievements{
    public final TextureAtlas.AtlasRegion achievements;

    public AssetAchievements(TextureAtlas atlas) { achievements = atlas.findRegion("achievements");}
  }

  // ENDLESS
  public class AssetEndless{
    public final TextureAtlas.AtlasRegion endless;

    public AssetEndless(TextureAtlas atlas) { endless = atlas.findRegion("endless");}
  }

  // MOVES
  public class AssetMoves {
    public final TextureAtlas.AtlasRegion moves;

    public AssetMoves(TextureAtlas atlas) {moves = atlas.findRegion("moves");}
  }
  // POWERUP
  public class AssetPowerup{
    public final TextureAtlas.AtlasRegion powerup;

    public AssetPowerup(TextureAtlas atlas) {powerup = atlas.findRegion("powerup");}
  }

  // RED BUTTON
  public class AssetRedButton{
    public final TextureAtlas.AtlasRegion redButton;

    public AssetRedButton(TextureAtlas atlas) {redButton = atlas.findRegion("redButton");}
  }

  // SETTINGS
  public class AssetSettings{
    public final TextureAtlas.AtlasRegion settings;

    public AssetSettings(TextureAtlas atlas) {settings = atlas.findRegion("settings");}
  }

  // TIMED
  public class AssetTimed{
    public final TextureAtlas.AtlasRegion timed;

    public AssetTimed(TextureAtlas atlas) {timed = atlas.findRegion("timed");}
  }


// *** UI Assets ***

// Default Round
  public class AssetDefaultRound{
    public final TextureAtlas.AtlasRegion defaultRound;

  public AssetDefaultRound(TextureAtlas atlas) {defaultRound = atlas.findRegion("default-round");}
}
  // Default Round Down
  public class AssetDefaultRoundDown{
    public final TextureAtlas.AtlasRegion defaultRoundDown;

    public AssetDefaultRoundDown(TextureAtlas atlas) {defaultRoundDown = atlas.findRegion("default-round-down");}

  }



  public class AssetLevelDecoration{

    public AssetLevelDecoration(TextureAtlas atlas){

    }
  }

  public class AssetFonts {
    public final BitmapFont defaultSmall;
    public final BitmapFont defaultNormal;
    public final BitmapFont defaultBig;

    public AssetFonts(){
      // create three fonts using Libgdx's 15px bitmap font
      defaultSmall = new BitmapFont(Gdx.files.internal("images/arial-15.fnt"), true);
      defaultNormal = new BitmapFont(Gdx.files.internal("images/arial-15.fnt"), true);
      defaultBig = new BitmapFont(Gdx.files.internal("images/arial-15.fnt"), true);

      // set font sizes
      //defaultSmall.setScale(0.75f);
      //defaultNormal.setScale(1.0f);
      //defaultBig.setScale(2.0f);

      // enable linear texture filtering for smooth fonts
      defaultSmall.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      defaultNormal.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      defaultBig.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }
  }

}
