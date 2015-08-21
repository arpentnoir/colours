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

/**
 * Created by richardspellman on 31/07/15.
 */


public class Assets implements Disposable, AssetErrorListener {
  public static final String TAG = Assets.class.getName();

  public static final Assets instance = new Assets();

  public AssetRed red;
  public AssetOrange orange;
  public AssetYellow yellow;
  public AssetGreen green;
  public AssetBlue blue;
  public AssetPurple purple;
  public AssetBrown brown;
  public AssetContinuousPlayButton continuousPlayButton;

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
    continuousPlayButton = new AssetContinuousPlayButton(atlas);
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
