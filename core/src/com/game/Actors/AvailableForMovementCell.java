package com.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class AvailableForMovementCell extends Actor {
    private Texture texture;

    public AvailableForMovementCell() {
        texture = new Texture(Gdx.files.internal("AvailableCell.png"));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

}