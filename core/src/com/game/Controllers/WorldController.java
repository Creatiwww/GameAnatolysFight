package com.game.Controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.Main.AssetLoader;
import com.game.ScreensAndStages.Screens.MyScreen;
import com.game.UI.NotificationsInterface;

public class WorldController  {

    private ActorsController actorsController;
    private AIController aiController;
    private ScreenController screenController;
    private SpriteBatch batch;
    //private Turn turn;
    private EnemyWave enemyWave;
    private NotificationsInterface notificationsInterface;
    boolean isGameOverToastShown = false;
    private int score = 0;
    private GameCycle gameCycle;

    public WorldController (NotificationsInterface notificationsInterface) {
        AssetLoader.load();
        batch = new SpriteBatch();
        enemyWave = new EnemyWave();
        actorsController = new ActorsController(this);
        aiController = new AIController(this);
        this.notificationsInterface=notificationsInterface;
        screenController = new ScreenController(this);
        gameCycle = new GameCycle(this);
    }

    public NotificationsInterface getNotificationsInterface(){
        return notificationsInterface;
    }

    public SpriteBatch getBatch(){
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

    public GameCycle getGameCycle(){
        return gameCycle;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int increment) {
        score += increment;
    }

    public EnemyWave getEnemyWave(){
        return this.enemyWave;
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


