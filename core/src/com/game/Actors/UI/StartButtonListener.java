package com.game.Actors.UI;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.game.Controllers.WorldController;

public class StartButtonListener extends ClickListener {
    WorldController worldController;

    public StartButtonListener(WorldController worldController){
        this.worldController = worldController;
    }

    @Override
    public void clicked (InputEvent event, float x, float y) {
        worldController.getScreenController().setGameScreen();
    }
}
