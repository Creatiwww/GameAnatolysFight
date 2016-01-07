package com.game.Actors.Playable.Listeners;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.game.Actors.MyActor;
import com.game.Actors.Playable.Products.PlayableActor;
import com.game.Controllers.WorldController;
import com.game.Main.AssetLoader;

/**
 * Created by creatiwww on 04.01.2016.
 */
public class RestartButtonListner extends ClickListener {
    WorldController worldController;
    public RestartButtonListner(WorldController worldController){
        this.worldController = worldController;
    }
    @Override
    public void  clicked(InputEvent event, float x, float y) {
        for (Object actor:  worldController.getActorsController().getActors()){
            MyActor myActor = (MyActor)actor;
            myActor.setHP(-1);
        }
        worldController.getActorsController().deleteDeadUnits();
        worldController.getActorsController().reproductionPauseRedaction();
        worldController.getActorsController().ageIncrease();
        worldController.getActorsController().maturation();
        worldController.nullScore();
        AssetLoader.clearPrefs();
        worldController.getGameCycle().setGameState("WAVE_GENERATING_STARTED");
        //return true;
    };
}
