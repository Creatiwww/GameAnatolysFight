package com.game.Actors.UI;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.game.Actors.MyActor;
import com.game.Controllers.WorldController;
import com.game.Main.AssetLoader;

public class StartNewGameButtonListener extends ClickListener {
    WorldController worldController;

    public StartNewGameButtonListener(WorldController worldController){
        this.worldController = worldController;
    }

    @Override
    public void clicked (InputEvent event, float x, float y) {
        for (Object actor:  worldController.getActorsController().getActors()){
            MyActor myActor = (MyActor)actor;
            myActor.setHP(-1);
        }
        worldController.getActorsController().deleteDeadUnits(true);
        worldController.getActorsController().reproductionPauseRedaction();
        worldController.getActorsController().ageIncrease();
        worldController.getActorsController().maturation();
        worldController.nullScore();
        AssetLoader.clearPrefs();
        worldController.getGameCycle().setGameState("WAVE_GENERATING_STARTED");
        worldController.getScreenController().setGameScreen();
    };
}