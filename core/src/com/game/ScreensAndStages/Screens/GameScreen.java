package com.game.ScreensAndStages.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Actors.MyActor;
import com.game.Controllers.WorldController;
import com.game.Actors.Field;
import com.game.ScreensAndStages.Stages.GameStage;

public class GameScreen extends MyScreen {

    private GameStage gameStage;
   // private Field field;

    public GameScreen(WorldController worldController, Field field){
        super(worldController);
        gameStage=new GameStage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), batch);
        gameStage.addActor(field);
        for(Object myActor:actorsController.getActors()) { // bug is here
            gameStage.addActor((MyActor)myActor);
        }
    }

    @Override
    public void render(float delta){
        // gameStage.act(delta);
        gameStage.draw();
    }
}
