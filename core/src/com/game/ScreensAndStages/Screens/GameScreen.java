package com.game.ScreensAndStages.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Actors.AvailableForMovementCell;
import com.game.Actors.MergeableCell;
import com.game.Actors.MyActor;
import com.game.Actors.OccupiedByAICell;
import com.game.Controllers.AIController;
import com.game.Controllers.WorldController;
import com.game.Actors.Field;
import com.game.ScreensAndStages.Stages.GameStage;

public class GameScreen extends MyScreen {

    private GameStage gameStage;
    private Field field;
    private WorldController worldController;
    private AIController aiController;

    public GameScreen(WorldController worldController){

        super(worldController);
        this.worldController=worldController;
        this.field=worldController.getActorsController().getField();
        aiController=worldController.getAiController();
        gameStage=new GameStage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), batch);
        gameStage.addActor(field);
        drawActors();
    }

    @Override
    public void drawActors(){
        for(Object myActor:actorsController.getActors()) {
            gameStage.addActor((MyActor)myActor);
        }
    }

    @Override
    public void drawAvailableForMovementCells(){
        Actor cell;
        for(Object cellIterator:actorsController.getAvailableCell()) {
            gameStage.addActor((AvailableForMovementCell)cellIterator);
            cell=(Actor)cellIterator;
            cell.toBack();
        }
        for(Object cellIterator:actorsController.getMergeableCell()) {
            gameStage.addActor((MergeableCell)cellIterator);
            cell=(Actor)cellIterator;
            cell.toBack();
        }
        for(Object cellIterator:actorsController.getOccupiedByAICell()) {
            gameStage.addActor((OccupiedByAICell)cellIterator);
            cell=(Actor)cellIterator;
            cell.toBack();
        }
        field.toBack();
    }

    /**
     * Main game cycle for main screen
     */
    @Override
    public void render(float delta){
        worldController.getActorsController().deleteDeadUnits();
        gameStage.draw();
        // if this is the turn of AI and turn has not already been made

        // if all ai actors are dead, next wave starts
        if (aiController.getAiUnits().isEmpty()) {
            aiController.generateNextWavesEnemies();
        }

        if (worldController.getTurn().isAITurn() && !worldController.getTurn().isTurnAlreadyMadeByAI()){
            worldController.getTurn().setTurnAlreadyMadeByAI(); // ai turn already initiated
            worldController.getAiController().startAITurn();
        }
    }
}
