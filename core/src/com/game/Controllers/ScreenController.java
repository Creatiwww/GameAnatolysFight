package com.game.Controllers;

import com.game.ScreensAndStages.Screens.GameScreen;
import com.game.ScreensAndStages.Screens.MyScreen;

public class ScreenController  {

    private MyScreen gameScreen;
    private WorldController worldController;

    public ScreenController(WorldController worldController){
        this.worldController = worldController;
    }

    public MyScreen getScreen(){
        if (gameScreen == null) gameScreen = new GameScreen(worldController);
        return gameScreen;
    }

}
