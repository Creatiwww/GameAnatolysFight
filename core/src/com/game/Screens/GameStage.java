package com.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GameStage implements Stage {
    private static final String TAG = GameStage.class.getName();

    private Sprite[] sprites;

    // game stage sprites drawing in constructor
    public GameStage(){
        DrawTestSprites();
    }

    public Sprite[] getSprites(){
        //Gdx.app.log("MyTag", "'getSprites' method started @" + TAG);
        return sprites;
    }

    //TODO: remove draw test sprites before publishing
    private void DrawTestSprites(){
        //Gdx.app.log("MyTag", "GameStage constructor started @" + TAG);
        Pixmap pixmap = new Pixmap(25,25, Pixmap.Format.RGBA8888);
        pixmap.setColor(1, 0, 0, 0.5f);
        pixmap.fill();
        pixmap.drawRectangle(0, 0, 25, 25);
        Texture texture;
        texture = new Texture(pixmap);
        pixmap.dispose();
        sprites = new Sprite[1];
        sprites[0]=new Sprite(texture);
        sprites[0].setSize(1,1);
    }
}
