package com.game.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.Actors.Playable.Products.PlayableActor;
import com.game.Main.Main;
import com.game.ScreensAndStages.Screens.MyScreen;
import com.game.UI.NotificationsInterface;

public class WorldController  {

    private ActorsController actorsController;
    private AIController aiController;
    private ScreenController screenController;
    private Batch batch;
    private Turn turn;
    private EnemyWave enemyWave;
    private NotificationsInterface notificationsInterface;
    boolean isGameOverToastShown = false;

    public WorldController (NotificationsInterface notificationsInterface) {
        batch = new SpriteBatch();
        turn = new Turn();
        enemyWave = new EnemyWave();
        actorsController = new ActorsController(this);
        aiController = new AIController(this);
        this.notificationsInterface=notificationsInterface;
        this.notificationsInterface.toast("    Level    " + getEnemyWave().getWaveNumber() + "    ");
        // generates initial set of p and ai enemies
        aiController.generateNextWavesPlayableUnits();
        aiController.generateNextWavesEnemies();
        aiController.updateAIUnitsCoordinates();
        screenController = new ScreenController(this);
    }

    public NotificationsInterface getNotificationsInterface(){
        return notificationsInterface;
    }

    public Batch getBatch(){
        return batch;
    }

    public ActorsController getActorsController(){
        return actorsController;
    }

    public AIController getAiController(){
        return aiController;
    }

    public MyScreen getScreen(){
        return screenController.getScreen();
    }

    public Turn getTurn(){
        return this.turn;
    }

    /**
     * Main game cycle
     */
    public void runMainGameCycle(){
        actorsController.deleteDeadUnits();
        screenController.getScreen().getGameStage().draw();

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
            getEnemyWave().setNextWave();
            aiController.calculateNextWaveDifficulty();
            aiController.generateNextWavesPlayableUnits();
            notificationsInterface.toast("    Level    " + getEnemyWave().getWaveNumber() + "    ");
            aiController.generateNextWavesEnemies();
        }

        // if this is the turn of AI and turn has not already been made
        if (getTurn().isAITurn() && !getTurn().isTurnAlreadyMadeByAI()){
            getTurn().setTurnAlreadyMadeByAI(); // ai turn already initiated
            getAiController().startAITurn();
        }
    }

    public EnemyWave getEnemyWave(){
        return this.enemyWave;
    }

    public class Turn {
        public int turnIndex; // 0 - nobody; 1 - player; 2 - AI
        public boolean isTurnAlreadyMadeByAI;

        Turn(){
            this.turnIndex=0;
            this.isTurnAlreadyMadeByAI=false;
        }

        public void setTurnAlreadyMadeByAI(){
            isTurnAlreadyMadeByAI=true;
        }
        public boolean isTurnAlreadyMadeByAI(){
            return isTurnAlreadyMadeByAI;
        }
        public void startAITurn(){
            setAITurn();
        }
        public void endAITurn(){
            setNobodyTurn();
            actorsController.reproductionPauseRedaction();
            actorsController.ageIncrease();
            actorsController.maturation();
           // screenController.getScreen().drawActors();
        }
        public void startPlayerTurn(){
            setPlayerTurn();
        }
        public void endPlayerTurn(){
            setNobodyTurn();
        }

        public boolean isAITurn(){
            if (turnIndex==2)return true;
            else return false;
        }
        public boolean isPlayerTurn(){
            if (turnIndex==1)return true;
            else return false;
        }
        public boolean isNobodyTurn(){
            if (turnIndex==0)return true;
            else return false;
        }

        private void setAITurn(){
            turnIndex=2;
        }
        private void setPlayerTurn(){
            turnIndex=1;
        }
        private void setNobodyTurn(){
            isTurnAlreadyMadeByAI=false;
            turnIndex=0;
        }
    }

    public class EnemyWave {
        private int waveNumber;

        EnemyWave(){
            waveNumber=1;
        }

        public void setNextWave(){
            waveNumber++;
        }
        public int getWaveNumber(){
            return waveNumber;
        }

    }
}


