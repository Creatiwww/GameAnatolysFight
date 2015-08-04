package com.game.Actors.Playable.Products;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class PlayableActor1 extends Actor {
    private static final String TAG = PlayableActor1.class.getName();

    //TODO: remove test override
    @Override
    public void draw(Batch batch, float parentAlpha) {
        //Gdx.app.log("MyTag", "'draw' method started @" + TAG);
        Texture texture=new Texture(Gdx.files.internal("badlogic.jpg"));
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
        //Gdx.app.log("MyTag", "'draw' method ended @" + TAG);
    }
}
