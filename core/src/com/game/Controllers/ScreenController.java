package com.game.Controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.game.Screens.GameHelpStage;
import com.game.Screens.GameOverStage;
import com.game.Screens.GamePauseStage;
import com.game.Screens.GameStage;
import com.game.Screens.Stage;

public class ScreenController {
    private static final String TAG = ScreenController.class.getName();

    private Stage gameStage;
    private Stage gameHelpStage;
    private Stage gameOverStage;
    private Stage gamePauseStage;
    private Sprite[] sprites;

    public ScreenController(){
        init();
    }

    public Sprite[] getSprites(){
        //TODO: implement feature to returt sprites from active stage
        //Gdx.app.log("MyTag", "'getSprites' method started @" + TAG);
        return gameStage.getSprites();
    }

    //TODO: implement lazy initialization
    private void init(){
        //Gdx.app.log("MyTag", "'init' method started @" + TAG);
        gameStage=new GameStage();
        gameHelpStage=new GameHelpStage();
        gameOverStage=new GameOverStage();
        gamePauseStage=new GamePauseStage();
    }
}
