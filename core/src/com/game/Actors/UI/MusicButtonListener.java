package com.game.Actors.UI;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.game.Controllers.WorldController;
import com.game.Main.AssetLoader;

public class MusicButtonListener extends ClickListener {
    WorldController worldController;

    public MusicButtonListener(WorldController worldController){
        this.worldController = worldController;
    }

    @Override
    public void clicked (InputEvent event, float x, float y) {
        if (worldController.isMusicOn()){
            AssetLoader.gameMusic.stop();
            worldController.turnOffMusic();
        }else {
            AssetLoader.gameMusic.play();
            worldController.turnOnMusic();
        }
    }
}
