package com.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.game.Main.AssetLoader;

public class AvailableForMovementCell extends Actor {
    private TextureRegion textureRegion;

    public AvailableForMovementCell() {
        textureRegion = AssetLoader.textureAtlas.findRegion("AvailableCell");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textureRegion, getX(), getY(), getWidth(), getHeight());
    }

}