package com.game.ScreensAndStages.Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.game.Controllers.ActorsController;
import com.game.Controllers.WorldController;

abstract public class MyScreen implements Screen {
    protected ActorsController actorsController;
    protected Batch batch;

    public MyScreen(WorldController worldController){
        batch=worldController.getBatch();
        actorsController = worldController.getActorsController();
    }

    abstract public void drawAvailableForMovementCells();

    @Override
    public void resize(int width, int height){
    }

    @Override
    public void resume(){
    }

    @Override
    public void pause(){
    }

    @Override
    public void show(){
    }

    @Override
    public void hide(){
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
