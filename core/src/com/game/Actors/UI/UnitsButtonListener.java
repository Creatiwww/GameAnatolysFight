package com.game.Actors.UI;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.game.Controllers.WorldController;

public class UnitsButtonListener extends InputListener {
    WorldController worldController;

    public UnitsButtonListener(WorldController worldController){
        this.worldController = worldController;
    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        return true;
    }

    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        worldController.getScreenController().setAllUnitsScreen();
    }

}
