package com.game.ScreensAndStages.Screens;

import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Actors.Playable.Products.MyActor;
import com.game.Controllers.WorldController;
import com.game.Main.GameConstants;
import com.game.ScreensAndStages.Stages.GameStage;

public class GameScreen extends MyScreen {

    private GameStage gameStage;

    public GameScreen(WorldController worldController){
        super(worldController);
        gameStage=new GameStage(new StretchViewport(GameConstants.VIEWPORT_WIDTH, GameConstants.VIEWPORT_HEIGHT), batch);
        for(MyActor myActor:actorsController.getActors()) {
            gameStage.addActor(myActor);
        }
    }

    @Override
    public void render(float delta){
        // gameStage.act(delta);
        gameStage.draw();
    }

}
