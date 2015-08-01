package com.game.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class WorldController {
    private static final String TAG = WorldController.class.getName();

    private ActorsController actorsController;
    private AIController aiController;
    private ScreenController screenController;
    private Sprite[] sprites;

    public WorldController () {
        init();
    }

    public Sprite[] getSprites (){
        //Gdx.app.log("MyTag", "'getSprites' method started @" + TAG);
        return screenController.getSprites();
    }

    private void init () {
        //Gdx.app.log("MyTag", "'init' method started @" + TAG);
        actorsController = new ActorsController();
        aiController = new AIController();
        screenController = new ScreenController();
    }

    public void update (float deltaTime) {
    }
}
