package com.game.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.game.Actors.Playable.Products.PlayableActor1;

public class WorldController {
    private static final String TAG = WorldController.class.getName();

    private ActorsController actorsController;
    private AIController aiController;
    private ScreenController screenController;
    private Batch batch;
    private Stage activeStage;
    private PlayableActor1 testActor1; //TODO: remove testActor

    public WorldController () {
        createTestActor(); //TODO: remove testActor
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
        aiController = new AIController();
        screenController = new ScreenController(batch, testActor1);
        //Gdx.app.log("MyTag", "'init' method ended @" + TAG);
    }

    public void update (float deltaTime) {
    }

    //TODO: remove test actors creation
    private void createTestActor(){
        //Gdx.app.log("MyTag", "'createTestActor' method started @" + TAG);
        testActor1 = new PlayableActor1();
        testActor1.setSize(1,1);
        testActor1.setPosition(1, 1);
        //Gdx.app.log("MyTag", "'createTestActor' method ended @" + TAG);
    }

}
