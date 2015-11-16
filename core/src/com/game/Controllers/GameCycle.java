package com.game.Controllers;

import com.badlogic.gdx.utils.Timer;
import com.game.AI.StrategicAI;
import com.game.AI.TacticalAI;
import com.game.Actors.Playable.Products.PlayableActor;
import com.game.UI.AnimationController;


public class GameCycle {

    public GameState gameState;
    private WorldController worldController;
    private AIController aiController;
    private ActorsController actorsController;
    private StrategicAI strategicAI;
    private TacticalAI tacticalAI;
    private float delay;

    public enum GameState {
        WAVE_GENERATING_STARTED,
        WAVE_GENERATING_IN_PROGRESS,
        PLAYER_TURN_START,
        PLAYER_TURN_IN_PROGRESS,
        PLAYER_TURN_END,
        AI_TURN_START,
        AI_TURN_IN_PROGRESS,
        AI_TURN_END,
        NOBODY_TURN,
        PAUSED,
        GAME_OVER,
        GAME_OVER_SHOWN
    }

    public GameCycle(WorldController worldController){
        this.worldController = worldController;
        aiController = worldController.getAiController();
        actorsController = worldController.getActorsController();
        strategicAI = worldController.getAiController().getStrategicAI();
        tacticalAI = worldController.getAiController().getTacticalAI();
        gameState = GameState.WAVE_GENERATING_STARTED;
    }

    public void run(){

        switch (gameState){
            case WAVE_GENERATING_STARTED:
                gameState = GameState.WAVE_GENERATING_IN_PROGRESS;
                // generates next waves enemies and playable units
                aiController.generateNextWavesPlayableUnits();
                aiController.generateNextWavesEnemies();
                aiController.updateAIUnitsCoordinates();
                worldController.getScreen().drawActors();
                gameState = GameState.PLAYER_TURN_START;
                break;
            case PLAYER_TURN_START:
                gameState = GameState.PLAYER_TURN_IN_PROGRESS;
                // after success movement by player should be switched to PLAYER_TURN_END
                // in processMovementIntention() method of PlayableActorListner class
                break;
            case PLAYER_TURN_END:
                gameState = GameState.NOBODY_TURN;
                playAnimation();
                // waiting while animation will be played
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        actorsController.deleteDeadUnits();
                        gameState = GameState.AI_TURN_START;
                    }
                }
                        , delay       //    (delay)
                );
                break;
            case AI_TURN_START:
                gameState = GameState.AI_TURN_IN_PROGRESS;
                // if all AI actors are dead, next wave starts
                if (aiController.getAiUnits().isEmpty()){
                    for (Object actor: actorsController.getActors()){
                        PlayableActor playableActor = (PlayableActor)actor;
                        playableActor.setHP(-1);
                    }
                    actorsController.deleteDeadUnits();
                    worldController.getEnemyWave().setNextWave();
                    aiController.calculateNextWaveDifficulty();
                    worldController.getNotificationsInterface().toast("    Level    " + worldController.getEnemyWave().getWaveNumber() + "    ");
                    gameState = GameState.WAVE_GENERATING_STARTED;
                } else {
                    strategicAI.defineStrategy();
                    tacticalAI.implementStrategy();
                    aiController.updateAIUnitsCoordinates();
                    gameState = GameState.AI_TURN_END;
                }
                break;
            case AI_TURN_END:
                gameState = GameState.NOBODY_TURN;
                playAnimation();
                // waiting while animation will be played
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        actorsController.deleteDeadUnits();
                        actorsController.reproductionPauseRedaction();
                        actorsController.ageIncrease();
                        actorsController.maturation();
                        gameState = GameState.PLAYER_TURN_START;
                    }
                }
                        , delay       //    (delay)
                );
                break;
            case GAME_OVER:
                worldController.getNotificationsInterface().toast("    Game Over    ");
                gameState = GameState.GAME_OVER_SHOWN;
                break;
            case PAUSED:
                // paused
                break;
            case WAVE_GENERATING_IN_PROGRESS: case PLAYER_TURN_IN_PROGRESS: case NOBODY_TURN: case GAME_OVER_SHOWN:
                // do nothing;
        }

        // game over when all PActor are dead (size of its array = 0) and it wasn't shown
        if (actorsController.getPActors().isEmpty() && gameState != GameState.GAME_OVER_SHOWN && gameState != GameState.WAVE_GENERATING_STARTED){
            gameState = GameState.GAME_OVER;
        }
    }

    // play attack animation if attack animation planned (MyActor class, method attack sets up variables)
    private void playAnimation(){
        delay = 0; // if animation not planned then actions executing in Timer.Task() with no delay
        if (AnimationController.isAttackAnimationPlanned()) {
            delay = AnimationController.ATTACK_TIME * 2;
            AnimationController.playAttackAnimation();
            AnimationController.setAttackingActor(null);
            AnimationController.setAttackedActor(null);
            //worldController.getScreen().getGameStage().act();
        }

    }

}


