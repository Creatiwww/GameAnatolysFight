package com.game.Controllers;

import com.badlogic.gdx.Gdx;
import com.game.Main.AssetLoader;
import com.game.Screens.AllUnitsScreen;
import com.game.Screens.GameOverScreen;
import com.game.Screens.GameScreen;
import com.game.Screens.InfoScreen;
import com.game.Screens.StartScreen;
import com.game.Screens.MyScreen;

public class ScreenController  {

    private MyScreen screen;
    private MyScreen gameScreen, infoScreen, startScreen, gameOverScreen, allUnitsScreen;
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
        AssetLoader.gameMusic.pause();
        screen = infoScreen;
        switchScreen();
    }

    public void setStartScreen(){
        screen = startScreen;
        switchScreen();
    }

    public void setGameScreen(){
        if(worldController.isMusicOn()){AssetLoader.gameMusic.play();}
        screen = gameScreen;
        switchScreen();
    }

    public void setGameOverScreen(){
        AssetLoader.gameMusic.pause();
        screen = gameOverScreen;
        switchScreen();
    }

    public void setAllUnitsScreen(){
        AssetLoader.gameMusic.pause();
        allUnitsScreen = null;
        allUnitsScreen = new AllUnitsScreen(worldController);
        screen = allUnitsScreen;
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
