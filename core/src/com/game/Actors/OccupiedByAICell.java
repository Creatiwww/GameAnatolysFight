package com.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.game.Main.AssetLoader;

public class OccupiedByAICell extends Actor {
    private TextureRegion textureRegion;

    public OccupiedByAICell() {
        textureRegion = AssetLoader.textureAtlas.findRegion("AICell");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textureRegion, getX(), getY(), getWidth(), getHeight());
    }

}