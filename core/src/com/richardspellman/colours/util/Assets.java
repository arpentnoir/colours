package com.richardspellman.colours.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
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

  public AssetFonts fonts;


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
  public AssetCheckOff checkOff;
  public AssetTextField textField;
  public AssetCheckOn checkOn;
  public AssetCursor  cursor;
  public AssetDefault assDefault;
  public AssetDefaultPane defaultPane;
  public AssetDefaultRectPad defaultRectPad;
  public AssetDefaultPaneNoborder defaultPaneNoborder;
  public AssetDefaultRect defaultRect;
  public AssetDefaultRectDown defaultRectDown;
  public AssetDefaultRound defaultRound;
  public AssetDefaultRoundDown defaultRoundDown;
  public AssetDefaultRoundLarge defaultRoundLarge;
  public AssetDefaultScroll defaultScroll;
  public AssetDefaultSelect defaultSelect;
  public AssetDefaultSelectSelection defaultSelectSelection;
  public AssetDefaultSlider defaultSlider;
  public AssetDefaultSliderKnob defaultSliderKnob;
  public AssetDefaultSplitPane defaultSplitpane;
  public AssetDefaultSplitPaneVertical defaultSplitpaneVertical;
  public AssetDefaultWindow defaultWindow;
  public AssetSelection selection;
  public AssetTreeMinus treeMinus;
  public AssetTreePlus treePlus;
  public AssetWhite white;


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
    //Gdx.app.debug(TAG, "# of assets loaded: " + assetManager.getAssetNames().size);
    for(String a : assetManager.getAssetNames()){
      //Gdx.app.debug(TAG, "asset: " + a);
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

    fonts = new AssetFonts();


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
    checkOff = new AssetCheckOff(atlas);
    textField = new AssetTextField(atlas);
    checkOn = new AssetCheckOn(atlas);
    cursor = new AssetCursor (atlas);
    assDefault = new AssetDefault(atlas);
    defaultPane = new AssetDefaultPane(atlas);
    defaultRectPad = new AssetDefaultRectPad(atlas);
    defaultPaneNoborder = new AssetDefaultPaneNoborder(atlas);
    defaultRect = new AssetDefaultRect(atlas);
    defaultRectDown = new AssetDefaultRectDown(atlas);
    defaultRound = new AssetDefaultRound(atlas);
    defaultRoundDown = new AssetDefaultRoundDown(atlas);
    defaultRoundLarge = new AssetDefaultRoundLarge(atlas);
    defaultScroll = new AssetDefaultScroll(atlas);
    defaultSelect = new AssetDefaultSelect(atlas);
    defaultSelectSelection = new AssetDefaultSelectSelection(atlas);
    defaultSlider = new AssetDefaultSlider(atlas);
    defaultSliderKnob = new AssetDefaultSliderKnob(atlas);
    defaultSplitpane = new AssetDefaultSplitPane(atlas);
    defaultSplitpaneVertical = new AssetDefaultSplitPaneVertical(atlas);
    defaultWindow = new AssetDefaultWindow(atlas);
    selection = new AssetSelection(atlas);
    treeMinus = new AssetTreeMinus(atlas);
    treePlus = new AssetTreePlus(atlas);
    white = new AssetWhite(atlas);
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
    //Gdx.app.error(TAG, "Couldn't load asset '" + asset.fileName + "'");
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

  public class AssetCheckOff{
    public final TextureAtlas.AtlasRegion checkOff;

    public AssetCheckOff(TextureAtlas atlas) {checkOff = atlas.findRegion("check-off");}
  }

  public class AssetTextField{
    public final TextureAtlas.AtlasRegion textField;

    public AssetTextField(TextureAtlas atlas) {textField = atlas.findRegion("textfield");}
  }

  public class AssetCheckOn{
    public final TextureAtlas.AtlasRegion checkOn;

    public AssetCheckOn(TextureAtlas atlas) {checkOn = atlas.findRegion("check-on");}
  }

  public class AssetCursor{
    public final TextureAtlas.AtlasRegion cursor;

    public AssetCursor(TextureAtlas atlas) {cursor = atlas.findRegion("cursor");}
  }

  public class AssetDefault{
    public final TextureAtlas.AtlasRegion assDefault;

    public AssetDefault(TextureAtlas atlas) {assDefault = atlas.findRegion("default");}
  }

  public class AssetDefaultPane{
    public final TextureAtlas.AtlasRegion defaultPane;

    public AssetDefaultPane(TextureAtlas atlas) {defaultPane = atlas.findRegion("default-pane");}
  }

  public class AssetDefaultRectPad{
    public final TextureAtlas.AtlasRegion defaultRectPad;

    public AssetDefaultRectPad(TextureAtlas atlas) {defaultRectPad = atlas.findRegion("default-rect-pad");}
  }

  public class AssetDefaultPaneNoborder{
    public final TextureAtlas.AtlasRegion defaultPaneNoborder;

    public AssetDefaultPaneNoborder(TextureAtlas atlas) {defaultPaneNoborder = atlas.findRegion("default-pane-noborder");}
  }

  public class AssetDefaultRect{
    public final TextureAtlas.AtlasRegion defaultRect;

    public AssetDefaultRect(TextureAtlas atlas) {defaultRect = atlas.findRegion("default-rect");}
  }

  public class AssetDefaultRectDown{
    public final TextureAtlas.AtlasRegion defaultRectDown;

    public AssetDefaultRectDown(TextureAtlas atlas) {defaultRectDown = atlas.findRegion("default-rect-down");}
  }

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

  public class AssetDefaultRoundLarge{
    public final TextureAtlas.AtlasRegion defaultRoundLarge;

    public AssetDefaultRoundLarge(TextureAtlas atlas) {defaultRoundLarge = atlas.findRegion("default-round-large");}
  }

  public class AssetDefaultScroll{
    public final TextureAtlas.AtlasRegion defaultScroll;

    public AssetDefaultScroll(TextureAtlas atlas) {defaultScroll = atlas.findRegion("default-scroll");}
  }

  public class AssetDefaultSelect{
    public final TextureAtlas.AtlasRegion defaultSelect;

    public AssetDefaultSelect(TextureAtlas atlas) {defaultSelect = atlas.findRegion("default-select");}
  }

  public class AssetDefaultSelectSelection{
    public final TextureAtlas.AtlasRegion defaultSelectSelection;

    public AssetDefaultSelectSelection(TextureAtlas atlas) {defaultSelectSelection = atlas.findRegion("default-select-selection");}
  }

  public class AssetDefaultSlider {
    public final TextureAtlas.AtlasRegion defaultSlider;

    public AssetDefaultSlider(TextureAtlas atlas) {defaultSlider = atlas.findRegion("default-slider");}
  }

  public class AssetDefaultSliderKnob{
    public final TextureAtlas.AtlasRegion defaultSliderKnob;

    public AssetDefaultSliderKnob(TextureAtlas atlas) {defaultSliderKnob = atlas.findRegion("default-slider-knob");}
  }

  public class AssetDefaultSplitPane{
    public final TextureAtlas.AtlasRegion defaultSplitpane;

    public AssetDefaultSplitPane(TextureAtlas atlas) {defaultSplitpane = atlas.findRegion("default-splitpane");}
  }

  public class AssetDefaultSplitPaneVertical{
    public final TextureAtlas.AtlasRegion defaultSplitpaneVertical;

    public AssetDefaultSplitPaneVertical(TextureAtlas atlas) {defaultSplitpaneVertical = atlas.findRegion("default-splitpane-vertical");}
  }

  public class AssetDefaultWindow{
    public final TextureAtlas.AtlasRegion defaultWindow;

    public AssetDefaultWindow(TextureAtlas atlas) {defaultWindow = atlas.findRegion("default-window");}
  }

  public class AssetSelection{
    public final TextureAtlas.AtlasRegion selection;

    public AssetSelection(TextureAtlas atlas) {selection = atlas.findRegion("selection");}
  }

  public class AssetTreeMinus{
    public final TextureAtlas.AtlasRegion treeMinus;

    public AssetTreeMinus(TextureAtlas atlas) {treeMinus = atlas.findRegion("tree-minus");}
  }

  public class AssetTreePlus{
    public final TextureAtlas.AtlasRegion treePlus;

    public AssetTreePlus(TextureAtlas atlas) {treePlus = atlas.findRegion("tree-plus");}
  }

  public class AssetWhite{
    public final TextureAtlas.AtlasRegion white;

    public AssetWhite(TextureAtlas atlas) {white = atlas.findRegion("white");}
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



        FileHandle fontFile = Gdx.files.internal("Roboto-Bold.ttf");
        //FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        //FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        //parameter.size = 12;
        //textFont = generator.generateFont(parameter);
        //parameter.size = 24;
        //titleFont = generator.generateFont(parameter);
        //generator.dispose();
    }
  }

}
