package com.game.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Actors.Playable.Products.PlayableActor1;
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
    private PlayableActor1 testActor1; //TODO: remove test actor

    public ScreenController(Batch batch, PlayableActor1 testActor1){
        this.batch=batch;
        this.testActor1=testActor1; //TODO: should be an array
        init();
    }

    public Stage getActiveStage(){
        return gameStage;
    }

    private void init(){
        //Gdx.app.log("MyTag", "'init' method started @" + TAG);
        gameStage=new GameStage(new StretchViewport(GameConstants.VIEWPORT_WIDTH, GameConstants.VIEWPORT_HEIGHT), batch);
        gameStage.addActor(testActor1);
        //gameHelpStage=new GameHelpStage();
        //gameOverStage=new GameOverStage();
        //gamePauseStage=new GamePauseStage();
        //Gdx.app.log("MyTag", "'init' method ended @" + TAG);
    }
}
