package com.game.ScreensAndStages.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Actors.AvailableForMovementCell;
import com.game.Actors.MergeableCell;
import com.game.Actors.MyActor;
import com.game.Actors.OccupiedByAICell;
import com.game.Actors.Playable.Products.PlayableActor;
import com.game.Controllers.AIController;
import com.game.Controllers.WorldController;
import com.game.Actors.Field;
import com.game.ScreensAndStages.Stages.GameStage;
import com.game.UI.NotificationsInterface;

import java.util.Objects;

public class GameScreen extends MyScreen {

    private GameStage gameStage;
    private Field field;
    private WorldController worldController;
    private AIController aiController;
    private NotificationsInterface notificationsInterface;
    boolean isGameOverToastShown=false;

    public GameScreen(WorldController worldController){
        super(worldController);
        this.worldController=worldController;
        this.field=worldController.getActorsController().getField();
        aiController=worldController.getAiController();
        gameStage=new GameStage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), batch);
        gameStage.addActor(field);
        drawActors();
        notificationsInterface=worldController.getNotificationsInterface();
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

        // game over when all PActor are dead and size of its array = 0
        if (actorsController.getPActors().isEmpty()){
            if (!isGameOverToastShown) {
                notificationsInterface.toast("    Game Over    ");
                isGameOverToastShown = true;
            }
        }

        // if all ai actors are dead, next wave starts
        if (aiController.getAiUnits().isEmpty()) {
            // force setting HP as -1 for all PUnits to let method deleteDeadUnits work correctly
            for (Object actor: actorsController.getActors()){
                PlayableActor playableActor=(PlayableActor)actor;
                playableActor.setHP(-1);
            }
            actorsController.deleteDeadUnits();
            worldController.getEnemyWave().setNextWave();
            aiController.calculateNextWaveDifficulty();
            aiController.generateNextWavesPlayableUnits();
            notificationsInterface.toast("    Level    " + worldController.getEnemyWave().getWaveNumber() + "    ");
            aiController.generateNextWavesEnemies();
        }

        // if this is the turn of AI and turn has not already been made
        if (worldController.getTurn().isAITurn() && !worldController.getTurn().isTurnAlreadyMadeByAI()){
            worldController.getTurn().setTurnAlreadyMadeByAI(); // ai turn already initiated
            worldController.getAiController().startAITurn();
        }

    }
}
