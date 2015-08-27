package com.game.Actors.Playable.Products;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class MyActor extends Actor {

    protected Texture texture;
    protected String texturePath;

    @Override
    public void draw(Batch batch, float parentAlpha) {
        //Gdx.app.log("MyTag", "'draw' method started @" + TAG);
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
        //Gdx.app.log("MyTag", "'draw' method ended @" + TAG);
    }

    protected void textureInit(){
        texture=new Texture(Gdx.files.internal(texturePath));
    }

}