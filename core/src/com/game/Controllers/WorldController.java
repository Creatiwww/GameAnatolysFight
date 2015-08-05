package com.game.Controllers;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class WorldController {
    private static final String TAG = WorldController.class.getName();

    private ActorsController actorsController;
    private AIController aiController;
    private ScreenController screenController;
    private Batch batch;

    public WorldController () {
        init();
    }

    public Batch getBatch(){
        return batch;
    }

    public Stage getActiveStage(){
        return screenController.getActiveStage();
    }

    private void init () {
        //Gdx.app.log("MyTag", "'init' method started @" + TAG);
        batch = new SpriteBatch();
        actorsController = new ActorsController();
        actorsController.spawnActor();
        aiController = new AIController();
        screenController = new ScreenController(batch, actorsController.getActors());
        //Gdx.app.log("MyTag", "'init' method ended @" + TAG);
    }

    public void update (float deltaTime) {
    }

}
