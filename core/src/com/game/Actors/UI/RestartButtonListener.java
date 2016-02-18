package com.game.Actors.UI;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.game.Actors.MyActor;
import com.game.Controllers.WorldController;
import com.game.Main.AssetLoader;

public class RestartButtonListener extends InputListener {
    WorldController worldController;

    public RestartButtonListener(WorldController worldController){
        this.worldController = worldController;
    }

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        return true;
    }

    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        for (Object actor:  worldController.getActorsController().getActors()){
            MyActor myActor = (MyActor)actor;
            myActor.setHP(-1);
        }
        worldController.getActorsController().deleteDeadUnits(true);
        worldController.nullScore();
        worldController.getEnemyWave().setWaveNumber(1);
        worldController.getAiController().nullWaveDifficulty();
        AssetLoader.clearPrefs();
        worldController.getGameCycle().setGameState("WAVE_GENERATING_STARTED");
    }
}
