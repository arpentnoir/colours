package com.richardspellman.colours.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.richardspellman.colours.util.Assets;

/**
 * Created by richardspellman on 24/08/15.
 */
public class Settings {

  private Stage stage;
  private Table table;
  // For debug drawing
  private ShapeRenderer shapeRenderer;
  private Skin skin;

  public Settings() {
    create();
  }

  public void create() {
    stage = new Stage();
    Gdx.input.setInputProcessor(stage);
    UISkin uiskin = new UISkin();
    skin = uiskin.getSkin();
    //skin = new Skin(Gdx.files.internal("uiskin.json"));
    table = new Table();
    table.setFillParent(true);
    stage.addActor(table);


    // Add an image actor. Have to set the size, else it would be the size of the drawable (which is the 1x1 texture).
    //table.add(new Image(skin.newDrawable("white", Color.RED))).size(64);

    // Create a table that fills the screen. Everything else will go inside this table.
    Table table = new Table();
    table.setFillParent(true);
    stage.addActor(table);

    //***********************************

    Label label = new Label("enter a value: ", skin);
    label.setHeight(20);
    table.add(label);

    // create text field
    TextField textField = new TextField("some text here", skin);
    textField.setHeight(60);
    table.add(textField);

    // Create a button with the "default" TextButtonStyle. A 3rd parameter can be used to specify a name other than "default".
    final TextButton button = new TextButton("Cl!", skin);
    table.add(button);

    // Add a listener to the button. ChangeListener is fired when the button's checked state changes, eg when clicked,
    // Button#setChecked() is called, via a key press, etc. If the event.cancel() is called, the checked state will be reverted.
    // ClickListener could have been used, but would only fire when clicked. Also, canceling a ClickListener event won't
    // revert the checked state.
    button.addListener(new ChangeListener() {
      public void changed (ChangeEvent event, Actor actor) {
        button.setText("Good job!");
      }
    });

    table.row();

    //***********************************

    Label label2 = new Label("enter a value: ", skin);
    table.add(label2);

    // create text field
    TextField textField2 = new TextField("some text here", skin);
    //table.row();
    table.add(textField2);

    // Create a button with the "default" TextButtonStyle. A 3rd parameter can be used to specify a name other than "default".
    final TextButton button2 = new TextButton("Cl!", skin);
    table.add(button2);

    // Add a listener to the button. ChangeListener is fired when the button's checked state changes, eg when clicked,
    // Button#setChecked() is called, via a key press, etc. If the event.cancel() is called, the checked state will be reverted.
    // ClickListener could have been used, but would only fire when clicked. Also, canceling a ClickListener event won't
    // revert the checked state.
    button2.addListener(new ChangeListener() {
      public void changed (ChangeEvent event, Actor actor) {
        button2.setText("Good job!");
      }
    });

    table.row();

    //***********************************

    Label label3 = new Label("enter a value: ", skin);
    table.add(label3);

    // create text field
    TextField textField3 = new TextField("some text here", skin);
    //table.row();
    table.add(textField3);

    // Create a button with the "default" TextButtonStyle. A 3rd parameter can be used to specify a name other than "default".
    final TextButton button3 = new TextButton("Cl!", skin);
    table.add(button3);

    // Add a listener to the button. ChangeListener is fired when the button's checked state changes, eg when clicked,
    // Button#setChecked() is called, via a key press, etc. If the event.cancel() is called, the checked state will be reverted.
    // ClickListener could have been used, but would only fire when clicked. Also, canceling a ClickListener event won't
    // revert the checked state.
    button3.addListener(new ChangeListener() {
      public void changed (ChangeEvent event, Actor actor) {
        button3.setText("Good job!");
      }
    });

    table.row();

    //***********************************

    Label label4 = new Label("enter a value: ", skin);
    table.add(label4);

    // create text field
    TextField textField4 = new TextField("some text here", skin);
    //table.row();
    table.add(textField4);

    // Create a button with the "default" TextButtonStyle. A 3rd parameter can be used to specify a name other than "default".
    final TextButton button4 = new TextButton("Cl!", skin);
    table.add(button4);

    // Add a listener to the button. ChangeListener is fired when the button's checked state changes, eg when clicked,
    // Button#setChecked() is called, via a key press, etc. If the event.cancel() is called, the checked state will be reverted.
    // ClickListener could have been used, but would only fire when clicked. Also, canceling a ClickListener event won't
    // revert the checked state.
    button4.addListener(new ChangeListener() {
      public void changed (ChangeEvent event, Actor actor) {
        button4.setText("Good job!");
      }
    });

    table.row();

    //***********************************

    Label label5 = new Label("enter a value: ", skin);
    table.add(label5);

    // create text field
    TextField textField5 = new TextField("some text here", skin);
    //table.row();
    table.add(textField5);

    // Create a button with the "default" TextButtonStyle. A 3rd parameter can be used to specify a name other than "default".
    final TextButton button5 = new TextButton("Cl!", skin);
    table.add(button5);

    // Add a listener to the button. ChangeListener is fired when the button's checked state changes, eg when clicked,
    // Button#setChecked() is called, via a key press, etc. If the event.cancel() is called, the checked state will be reverted.
    // ClickListener could have been used, but would only fire when clicked. Also, canceling a ClickListener event won't
    // revert the checked state.
    button5.addListener(new ChangeListener() {
      public void changed (ChangeEvent event, Actor actor) {
        button5.setText("Good job!");
      }
    });

    table.row();

    //***********************************

    Label label6 = new Label("enter a value: ", skin);
    table.add(label6);

    // create text field
    TextField textField6 = new TextField("some text here", skin);
    //table.row();
    table.add(textField6);

    // Create a button with the "default" TextButtonStyle. A 3rd parameter can be used to specify a name other than "default".
    final TextButton button6 = new TextButton("Cl!", skin);
    table.add(button6);

    // Add a listener to the button. ChangeListener is fired when the button's checked state changes, eg when clicked,
    // Button#setChecked() is called, via a key press, etc. If the event.cancel() is called, the checked state will be reverted.
    // ClickListener could have been used, but would only fire when clicked. Also, canceling a ClickListener event won't
    // revert the checked state.
    button6.addListener(new ChangeListener() {
      public void changed (ChangeEvent event, Actor actor) {
        button6.setText("Good job!");
      }
    });

    table.row();

    //***********************************

    Label label7 = new Label("enter a value: ", skin);
    table.add(label7);

    // create text field
    TextField textField7 = new TextField("some text here", skin);
    //table.row();
    table.add(textField7);

    // Create a button with the "default" TextButtonStyle. A 3rd parameter can be used to specify a name other than "default".
    final TextButton button7 = new TextButton("Cl!", skin);
    table.add(button7);

    // Add a listener to the button. ChangeListener is fired when the button's checked state changes, eg when clicked,
    // Button#setChecked() is called, via a key press, etc. If the event.cancel() is called, the checked state will be reverted.
    // ClickListener could have been used, but would only fire when clicked. Also, canceling a ClickListener event won't
    // revert the checked state.
    button7.addListener(new ChangeListener() {
      public void changed (ChangeEvent event, Actor actor) {
        button7.setText("Good job!");
      }
    });

    table.row();

    //***********************************

    Label label8 = new Label("enter a value: ", skin);
    table.add(label8);

    // create text field
    TextField textField8 = new TextField("some text here", skin);
    //table.row();
    table.add(textField8);

    // Create a button with the "default" TextButtonStyle. A 3rd parameter can be used to specify a name other than "default".
    final TextButton button8 = new TextButton("Cl!", skin);
    table.add(button8);

    // Add a listener to the button. ChangeListener is fired when the button's checked state changes, eg when clicked,
    // Button#setChecked() is called, via a key press, etc. If the event.cancel() is called, the checked state will be reverted.
    // ClickListener could have been used, but would only fire when clicked. Also, canceling a ClickListener event won't
    // revert the checked state.
    button8.addListener(new ChangeListener() {
      public void changed (ChangeEvent event, Actor actor) {
        button8.setText("Good job!");
      }
    });

    // Add an image actor. Have to set the size, else it would be the size of the drawable (which is the 1x1 texture).
    //table.add(new Image(skin.newDrawable("white", Color.RED))).size(64);

    //shapeRenderer = new ShapeRenderer();

    // Add widgets to the table here.

    /*Label nameLabel = new Label("Name:", skin);
    TextField nameText = new TextField("", skin);
    Label addressLabel = new Label("Address:", skin);
    TextField addressText = new TextField("", skin);

    Table table = new Table();
    table.add(nameLabel);
    table.add(nameText).width(100);
    table.row();
    table.add(addressLabel);
    table.add(addressText).width(100);*/
  }

  public void resize(int width, int height) {
    stage.getViewport().update(width, height, true);
  }

  public void render() {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    stage.act(Gdx.graphics.getDeltaTime());
    stage.draw();

    table.drawDebug(shapeRenderer); // This is optional, but enables debug lines for tables.
  }

  public void dispose() {
    stage.dispose();
    shapeRenderer.dispose();
  }
}
