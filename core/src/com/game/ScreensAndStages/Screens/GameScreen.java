package com.game.ScreensAndStages.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Actors.Playable.Products.MyActor;
import com.game.Controllers.WorldController;
import com.game.Main.GameConstants;
import com.game.ScreensAndStages.Stages.Field;
import com.game.ScreensAndStages.Stages.GameStage;

public class GameScreen extends MyScreen {

    private GameStage gameStage;
    private Field field;

    public GameScreen(WorldController worldController){
        super(worldController);
        gameStage=new GameStage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), batch);
        field = new Field();
        field.setSize(Gdx.graphics.getWidth()-(Gdx.graphics.getWidth()/8),Gdx.graphics.getWidth()-(Gdx.graphics.getWidth()/8));
        field.setPosition((Gdx.graphics.getWidth() - (Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 8)) / 2, (Gdx.graphics.getHeight() - (Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 8)) / 2);
        gameStage.addActor(field);
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
