package com.game.Controllers;

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
        return sprites;
    }

    private void init () {
        //TODO: Implement Sprites initialisation
    }

    public void update (float deltaTime) {
        //TODO: Implement Sprites
    }
}
