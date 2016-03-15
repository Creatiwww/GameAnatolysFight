package com.game.Actors.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.game.Actors.Field;
import com.game.Controllers.WorldController;
import com.game.Main.AssetLoader;

public class RestartButton extends ImageButton {

    public RestartButton(Field field, WorldController worldController){
        super(new SpriteDrawable(new Sprite(AssetLoader.textureAtlas.findRegion("btnReply"))));
        final double SIZE_MODIFICATOR = 1;
        float buttonSize =   field.getCellWidth()*(float)SIZE_MODIFICATOR * AssetLoader.scale;;
        setSize(buttonSize, buttonSize);
        float positionX = - buttonSize + field.getCoordinates().getRightFieldEdge();
        float positionY = - field.getCellByIndex(0).getbLY() / 2 + field.getCellByIndex(0).getbLY() - buttonSize / 2;
        setPosition(positionX,positionY);
        addListener(new RestartButtonListener(worldController));
    }
}
