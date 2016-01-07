package com.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.game.Actors.Playable.Listeners.RestartButtonListner;
import com.game.Controllers.WorldController;
import com.game.Main.AssetLoader;

public class RestartButton extends ImageButton {
    ImageButton restartButton;

    public RestartButton(Field field, WorldController worldController){
        super(new SpriteDrawable(new Sprite(new TextureAtlas(Gdx.files.internal("pack.atlas")).findRegion("test_actor_old_woman"))));
        setSize(100, 100);
        setPosition(0, field.getCellByIndex(field.getFeildSizeY() - 1).gettLY() + field.getCellByIndex(field.getFeildSizeY() - 1).gettLY() / 20);
        addListener(new RestartButtonListner(worldController));
        /*TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal("pack.atlas"));
        TextureAtlas.AtlasRegion region = textureAtlas.findRegion("test_actor_old_woman");
        Drawable drawableUp = new Image(region).getDrawable();
        restartButton  = new ImageButton(drawableUp);
        restartButton.setSize(80, 80);
        restartButton.setPosition(0, field.getCellByIndex(field.getFeildSizeY() - 1).gettLY() + field.getCellByIndex(field.getFeildSizeY() - 1).gettLY() / 20);
        restartButton.addListener(new RestartButtonListner(worldController));*/
    }

    /*@Override
    public void draw(Batch batch, float parentAlpha) {
        restartButton.draw(batch, parentAlpha);
    }*/



}
