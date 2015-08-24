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
    skin = new Skin();

    // Generate a 1x1 white texture and store it in the skin named "white".
    Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
    pixmap.setColor(Color.WHITE);
    pixmap.fill();
    skin.add("white", new Texture(pixmap));

    // Store the default libgdx font under the name "default".
    skin.add("default", new BitmapFont());

    // Configure a TextButtonStyle and name it "default". Skin resources are stored by type, so this doesn't overwrite the font.
    TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
    System.out.println(Assets.instance.defaultRound.defaultRound);
    textButtonStyle.up = new TextureRegionDrawable(Assets.instance.defaultRound.defaultRound);
    textButtonStyle.down = new TextureRegionDrawable(Assets.instance.defaultRoundDown.defaultRoundDown);

    textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
    textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);
    textButtonStyle.font = skin.getFont("default");
    skin.add("default", textButtonStyle);

    table = new Table();
    table.setFillParent(true);
    stage.addActor(table);


    // Add an image actor. Have to set the size, else it would be the size of the drawable (which is the 1x1 texture).
    table.add(new Image(skin.newDrawable("white", Color.RED))).size(64);

    // Create a table that fills the screen. Everything else will go inside this table.
    Table table = new Table();
    table.setFillParent(true);
    stage.addActor(table);

    // Create a button with the "default" TextButtonStyle. A 3rd parameter can be used to specify a name other than "default".
    final TextButton button = new TextButton("Click me!", skin);
    table.add(button);

    // Add a listener to the button. ChangeListener is fired when the button's checked state changes, eg when clicked,
    // Button#setChecked() is called, via a key press, etc. If the event.cancel() is called, the checked state will be reverted.
    // ClickListener could have been used, but would only fire when clicked. Also, canceling a ClickListener event won't
    // revert the checked state.
    button.addListener(new ChangeListener() {
      public void changed (ChangeEvent event, Actor actor) {
        System.out.println("Clicked! Is checked: " + button.isChecked());
        button.setText("Good job!");
      }
    });

    // Add an image actor. Have to set the size, else it would be the size of the drawable (which is the 1x1 texture).
    table.add(new Image(skin.newDrawable("white", Color.RED))).size(64);

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
