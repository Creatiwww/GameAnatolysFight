package com.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Controllers.WorldController;

public class StartScreen extends MyScreen {

    private Stage startStage;
    private ImageButton startButton;
    private WorldController worldController;
    private SpriteBatch spriteBatch;

    public StartScreen(WorldController worldController){
        super(worldController);
        spriteBatch = worldController.getBatch();
        this.worldController = worldController;
        startButton= (ImageButton) worldController.getActorsController().getStartButton();
        startStage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), worldController.getBatch());
        startStage.clear();
        startStage.addActor(startButton);
        drawActors();
    }

    @Override
    public Stage getStage(){
        return startStage;
    }

    @Override
    public void drawActors(){

    }

    @Override
    public void drawAvailableForMovementCells(){
    }

    @Override
    public void render(float delta){
        startStage.act();
        startStage.draw();
        spriteBatch.begin();
        spriteBatch.end();
    }
}
