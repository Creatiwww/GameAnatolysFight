package com.game.Controllers;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Actors.Playable.Products.MyActor;
import com.game.Main.GameConstants;
import com.game.Screens.GameHelpStage;
import com.game.Screens.GameOverStage;
import com.game.Screens.GamePauseStage;
import com.game.Screens.GameStage;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class ScreenController  {
    private static final String TAG = ScreenController.class.getName();

    private Stage gameStage;
    private Stage gameHelpStage;
    private Stage gameOverStage;
    private Stage gamePauseStage;
    private Batch batch;
    private MyActor[] myActors;

    public ScreenController(Batch batch, MyActor[] myActors){
        this.batch=batch;
        this.myActors=myActors;
        init();
    }

    //TODO: implement switch between stages
    public Stage getActiveStage(){
        return gameStage;
    }

    //TODO: implement actors draw at active screen only
    private void init(){
        //Gdx.app.log("MyTag", "'init' method started @" + TAG);
        gameStage=new GameStage(new StretchViewport(GameConstants.VIEWPORT_WIDTH, GameConstants.VIEWPORT_HEIGHT), batch);
        for (MyActor myActor : myActors) {
            gameStage.addActor(myActor);
        }
        //gameHelpStage=new GameHelpStage();
        //gameOverStage=new GameOverStage();
        //gamePauseStage=new GamePauseStage();
        //Gdx.app.log("MyTag", "'init' method ended @" + TAG);
    }
}
