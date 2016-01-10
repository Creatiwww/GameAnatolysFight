package com.game.Actors.UI;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.game.Actors.Field;
import com.game.Actors.Playable.Listeners.InfoButtonListener;
import com.game.Controllers.WorldController;
import com.game.Main.AssetLoader;

public class HelpButton extends ImageButton {
    ImageButton helpButton;

    public HelpButton(Field field, WorldController worldController){
        super(new SpriteDrawable(new Sprite(AssetLoader.textureAtlas.findRegion("btnInfo"))));
        final double SIZE_MODIFICATOR = 1;
        float buttonSize =   field.getCellWidth()*(float)SIZE_MODIFICATOR;
        setSize(buttonSize, buttonSize);
        //setPosition(0, field.getCellByIndex(field.getFeildSizeY() - 1).gettLY() + field.getCellByIndex(field.getFeildSizeY() - 1).gettLY() / 20);
        // positionX = left corner of first cell + number of cells in row -2 * width of particular cell
        float positionX = field.getCellByIndex(0).getbLX()+(field.getFeildSizeX()-2)*field.getCellWidth();
        // positionY = bottom corner of first cell - 1,5 * width of particular cell
        float positionY = field.getCellByIndex(0).getbLY()-(field.getCellWidth()+field.getCellWidth()/2);
        setPosition(positionX, positionY);
        addListener(new InfoButtonListener(worldController));
    }
}
