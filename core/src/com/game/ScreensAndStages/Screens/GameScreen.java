package com.game.ScreensAndStages.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Actors.AvailableForMovementCell;
import com.game.Actors.MyActor;
import com.game.Controllers.WorldController;
import com.game.Actors.Field;
import com.game.ScreensAndStages.Stages.GameStage;

import java.util.ArrayList;

public class GameScreen extends MyScreen {

    private GameStage gameStage;
    private Field field;
    private WorldController worldController;

    public GameScreen(WorldController worldController){

        super(worldController);
        this.worldController=worldController;
        this.field=worldController.getActorsController().getField();
        gameStage=new GameStage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), batch);
        gameStage.addActor(field);

        for(Object myActor:actorsController.getActors()) {
            gameStage.addActor((MyActor)myActor);
        }
    }

    @Override
    public void drawAvailableForMovementCells(){
        for(Object myAvailableCell:actorsController.getAvailableCell()) {
            gameStage.addActor((AvailableForMovementCell)myAvailableCell);
            Actor availableCell=(Actor)myAvailableCell;
            availableCell.toBack();
        }
        field.toBack();
    }

    @Override
    public void render(float delta){
        // gameStage.act(delta);
        worldController.getActorsController().deleteDeadUnits();
        gameStage.draw();
    }

}
