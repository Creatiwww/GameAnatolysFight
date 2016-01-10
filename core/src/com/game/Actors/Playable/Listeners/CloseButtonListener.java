package com.game.Actors.Playable.Listeners;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.game.Actors.MyActor;
import com.game.Controllers.WorldController;
import com.game.Main.AssetLoader;

public class CloseButtonListener extends ClickListener {
    WorldController worldController;

    public CloseButtonListener(WorldController worldController){
        this.worldController = worldController;
    }

    @Override
    public void clicked (InputEvent event, float x, float y) {
        worldController.getScreenController().setGameScreen();
    }
}
