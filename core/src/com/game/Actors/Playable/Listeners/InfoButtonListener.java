package com.game.Actors.Playable.Listeners;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.game.Controllers.WorldController;

public class InfoButtonListener extends ClickListener {
    WorldController worldController;

    public InfoButtonListener(WorldController worldController){
        this.worldController = worldController;
    }

    @Override
    public void clicked (InputEvent event, float x, float y) {
        worldController.getScreenController().setInfoScreen();
    }
}
