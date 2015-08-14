package com.game.Controllers;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.ScreensAndStages.Screens.MyScreen;

public class WorldController  {
    private static final String TAG = WorldController.class.getName();

    private ActorsController actorsController;
    private AIController aiController;
    private ScreenController screenController;
    private Batch batch;

    public WorldController () {
        //Gdx.app.log("MyTag", "'init' method started @" + TAG);
        batch = new SpriteBatch();
        actorsController = new ActorsController();
        actorsController.spawnActor();
        aiController = new AIController();
        screenController= new ScreenController(this);
        //Gdx.app.log("MyTag", "'init' method ended @" + TAG);
    }

    public Batch getBatch(){
        return batch;
    }

    public ActorsController getActorsController(){
        return actorsController;
    }

    public MyScreen getScreen(){
        return screenController.getScreen();
    }
}


