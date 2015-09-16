package com.richardspellman.colours.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.richardspellman.colours.util.Assets;

/**
 * Created by richardspellman on 25/08/15.
 */
public class UISkin {

  private Skin skin;

  private TextureRegionDrawable  checkOff;
  private TextureRegionDrawable  textField;
  private TextureRegionDrawable  checkOn;
  private TextureRegionDrawable  cursor;
  private TextureRegionDrawable  assDefault;
  private TextureRegionDrawable  defaultPane;
  private TextureRegionDrawable  defaultRectPad;
  private TextureRegionDrawable  defaultPaneNoborder;
  private TextureRegionDrawable  defaultRect;
  private TextureRegionDrawable  defaultRectDown;
  private TextureRegionDrawable  defaultRound;
  private TextureRegionDrawable  defaultRoundDown;
  private TextureRegionDrawable  defaultRoundLarge;
  private TextureRegionDrawable  defaultScroll;
  private TextureRegionDrawable  defaultSelect;
  private TextureRegionDrawable  defaultSelectSelection;
  private TextureRegionDrawable  defaultSlider;
  private TextureRegionDrawable  defaultSliderKnob;
  private TextureRegionDrawable  defaultSplitpane;
  private TextureRegionDrawable  defaultSplitpaneVertical;
  private TextureRegionDrawable  defaultWindow;
  private TextureRegionDrawable  selection;
  private TextureRegionDrawable  treeMinus;
  private TextureRegionDrawable  treePlus;
  private TextureRegionDrawable  white;

  public UISkin(){
    setupSkin();
  }

  public void setupSkin() {

    checkOff = new TextureRegionDrawable(Assets.instance.checkOff.checkOff);
    textField = new TextureRegionDrawable(Assets.instance.textField.textField);
    checkOn = new TextureRegionDrawable(Assets.instance.checkOn.checkOn);
    cursor = new TextureRegionDrawable(Assets.instance.cursor.cursor);
    assDefault = new TextureRegionDrawable(Assets.instance.assDefault.assDefault);
    defaultPane = new TextureRegionDrawable(Assets.instance.defaultPane.defaultPane);
    defaultRectPad = new TextureRegionDrawable(Assets.instance.defaultRect.defaultRect);
    defaultPaneNoborder = new TextureRegionDrawable(Assets.instance.defaultPaneNoborder.defaultPaneNoborder);
    defaultRect = new TextureRegionDrawable(Assets.instance.defaultRect.defaultRect);
    defaultRectDown = new TextureRegionDrawable(Assets.instance.defaultRectDown.defaultRectDown);
    defaultRound = new TextureRegionDrawable(Assets.instance.defaultRound.defaultRound);
    defaultRoundDown = new TextureRegionDrawable(Assets.instance.defaultRoundDown.defaultRoundDown);
    defaultRoundLarge = new TextureRegionDrawable(Assets.instance.defaultRoundLarge.defaultRoundLarge);
    defaultScroll = new TextureRegionDrawable(Assets.instance.defaultScroll.defaultScroll);
    defaultSelect = new TextureRegionDrawable(Assets.instance.defaultSelect.defaultSelect);
    defaultSelectSelection = new TextureRegionDrawable(Assets.instance.defaultSelectSelection.defaultSelectSelection);
    defaultSlider = new TextureRegionDrawable(Assets.instance.defaultSlider.defaultSlider);
    defaultSliderKnob = new TextureRegionDrawable(Assets.instance.defaultSliderKnob.defaultSliderKnob);
    defaultSplitpane = new TextureRegionDrawable(Assets.instance.defaultSplitpane.defaultSplitpane);
    defaultSplitpaneVertical = new TextureRegionDrawable(Assets.instance.defaultSplitpaneVertical.defaultSplitpaneVertical);
    defaultWindow = new TextureRegionDrawable(Assets.instance.defaultWindow.defaultWindow);
    selection = new TextureRegionDrawable(Assets.instance.selection.selection);
    treeMinus = new TextureRegionDrawable(Assets.instance.treeMinus.treeMinus);
    treePlus = new TextureRegionDrawable(Assets.instance.treePlus.treePlus);
    white = new TextureRegionDrawable(Assets.instance.white.white);

    skin = new Skin();

    // Generate a 1x1 white texture and store it in the skin named "white".
    Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
    pixmap.setColor(Color.WHITE);
    pixmap.fill();
    skin.add("white", new Texture(pixmap));

    // Store the default libgdx font under the name "default".
    skin.add("default", new BitmapFont());

    // Label
    Label.LabelStyle labelStyle = new Label.LabelStyle();
    labelStyle.font = new BitmapFont(Gdx.files.internal("default.fnt"));
    labelStyle.fontColor = new Color(0, 0, 0, 1);
    skin.add("default", labelStyle);


    // Image

    // Button

    // TextButton

    // ImageButton

    // Check Box

    // Button Group

    // TextField
    TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
    textFieldStyle.font = new BitmapFont(Gdx.files.internal("default.fnt"));
    textFieldStyle.fontColor = new Color(1, 1, 1, 1);
    textFieldStyle.cursor = cursor;
    textFieldStyle.background = textField;
    skin.add("default", textFieldStyle);

    // TextArea

    // List

    // SelectBox

    // Progress Bar

    // Slider

    // Window

    // Touchpad

    // Dialog

    // Configure a TextButtonStyle and name it "default". Skin resources are stored by type, so this doesn't overwrite the font.
    TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
    textButtonStyle.up = new TextureRegionDrawable(Assets.instance.defaultRound.defaultRound);
    textButtonStyle.down = new TextureRegionDrawable(Assets.instance.defaultRoundDown.defaultRoundDown);

    textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
    textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);
    textButtonStyle.font = skin.getFont("default");
    skin.add("default", textButtonStyle);
  }

  public Skin getSkin(){
    return skin;
  }
}