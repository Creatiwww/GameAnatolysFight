package com.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by creatiwww on 08.09.2015.
 */
public class AvailableCell extends Actor {
    private Texture availableCell;
    public AvailableCell() {
        availableCell = new Texture(Gdx.files.internal("AvailableCell.png"));
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(availableCell, getX(), getY(), getWidth(), getHeight());
    }

}
