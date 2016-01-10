package com.game.Controllers;

import com.badlogic.gdx.Gdx;
import com.game.Screens.GameOverScreen;
import com.game.Screens.GameScreen;
import com.game.Screens.InfoScreen;
import com.game.Screens.StartScreen;
import com.game.Screens.MyScreen;

public class ScreenController  {

    private MyScreen screen;
    private MyScreen gameScreen, infoScreen, startScreen, gameOverScreen;
    private WorldController worldController;

    public ScreenController(WorldController worldController){
        this.worldController = worldController;

        gameScreen = new GameScreen(worldController);
        infoScreen = new InfoScreen(worldController);
        startScreen = new StartScreen(worldController);
        gameOverScreen = new GameOverScreen(worldController);

        // Game starts with the screen mentioned below
        screen = startScreen;
        Gdx.input.setInputProcessor(screen.getStage());
    }

    public void setInfoScreen(){
        screen = infoScreen;
        switchScreen();
    }

    public void setStartScreen(){
        screen = startScreen;
        switchScreen();
    }

    public void setGameScreen(){
        screen = gameScreen;
        switchScreen();
    }

    public void setGameOverScreen(){
        screen = gameOverScreen;
        switchScreen();
    }

    private void switchScreen(){
        worldController.setRenderedScreen(screen);
        Gdx.input.setInputProcessor(screen.getStage());
    }

    public MyScreen getScreen(){
        return screen;
    }

}
