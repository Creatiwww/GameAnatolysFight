package com.game.Controllers;

import com.game.ScreensAndStages.Screens.GameScreen;
import com.game.ScreensAndStages.Screens.MyScreen;
import com.game.Actors.Field;

public class ScreenController  {
    private static final String TAG = ScreenController.class.getName();

    private MyScreen gameScreen;
    private WorldController worldController;
    private Field field;

    public ScreenController(WorldController worldController, Field field){
        this.worldController=worldController;
        this.field=field;
        //gameScreen=new GameScreen(this.worldController, field);
    }

    public MyScreen getScreen(){
        if (gameScreen==null) gameScreen = new GameScreen(worldController, field);
        return gameScreen;
    }

}
