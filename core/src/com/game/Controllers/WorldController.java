package com.game.Controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.game.Main.AssetLoader;
import com.game.Main.Main;
import com.game.Screens.MyScreen;
import com.game.Screens.StartScreen;
import com.game.UI.GetAndroidResInterface;
import com.game.UI.NotificationsInterface;

public class WorldController  {

    private Main main;
    private ActorsController actorsController;
    private AIController aiController;
    private ScreenController screenController;
    private SpriteBatch batch;
    private EnemyWave enemyWave;
    private NotificationsInterface notificationsInterface;
    private GetAndroidResInterface getAndroidResInterface;
    //boolean isGameOverToastShown = false;
    private int score = 0;
    private GameCycle gameCycle;

    public WorldController (NotificationsInterface notificationsInterface, GetAndroidResInterface getAndroidResInterface, Main main) {
        AssetLoader.load();
        this.main = main;
        batch = new SpriteBatch();
        enemyWave = new EnemyWave();
        actorsController = new ActorsController(this);
        aiController = new AIController(this);
        this.notificationsInterface = notificationsInterface;
        this.getAndroidResInterface = getAndroidResInterface;
        screenController = new ScreenController(this);
        gameCycle = new GameCycle(this);
    }

    public GetAndroidResInterface getAndroidResInterface(){
        return getAndroidResInterface;
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

    public ScreenController getScreenController() {
        return screenController;
    }

    public AIController getAiController(){
        return aiController;
    }

    public MyScreen getScreen(){
        return screenController.getScreen();
    }

    public void setRenderedScreen(MyScreen screen){
        main.setRenderedScreen(screen);
    }

    public GameCycle getGameCycle(){
        return gameCycle;
    }

    public int getScore() {
        return score;
    }

    public void nullScore(){
        score = 0;
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
            waveNumber = 1;
        }

        public void setNextWave(){
            waveNumber++;
        }

        public void setWaveNumber(int waveNumber){
            this.waveNumber = waveNumber;
        }

        public int getWaveNumber(){
            return waveNumber;
        }
    }
}


