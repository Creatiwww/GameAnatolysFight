package com.game.ScreensAndStages.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Actors.Playable.Products.MyActor;
import com.game.Controllers.WorldController;
import com.game.Actors.Field;
import com.game.ScreensAndStages.Stages.GameStage;

public class GameScreen extends MyScreen {

    private GameStage gameStage;
   // private Field field;

    public GameScreen(WorldController worldController, Field field){
        super(worldController);
        gameStage=new GameStage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), batch);
 /*       field = new Field();
        field.setSize(field.getCoordinates().getFieldWidth(),field.getCoordinates().getFieldHeight());
        field.setPosition(field.getCellByIndex(0).getbLX(),field.getCellByIndex(0).getbLY());*/
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

/*    @Override
    public Field getField(){
        return field;
    }*/

}
