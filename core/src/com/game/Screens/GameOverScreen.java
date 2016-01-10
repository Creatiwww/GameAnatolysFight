package com.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Controllers.WorldController;

public class GameOverScreen extends MyScreen {

    private Stage gameOverStage;
    private ImageButton startNewGameButton;
    private WorldController worldController;
    private SpriteBatch spriteBatch;

    public GameOverScreen(WorldController worldController){
        super(worldController);
        spriteBatch = worldController.getBatch();
        this.worldController = worldController;
        startNewGameButton =  worldController.getActorsController().getStartNewGameButton();
        gameOverStage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), worldController.getBatch());
        //gameOverStage.clear();
        gameOverStage.addActor(startNewGameButton);
        drawActors();
    }

    @Override
    public Stage getStage(){
        return gameOverStage;
    }

    @Override
    public void drawActors(){

    }

    @Override
    public void drawAvailableForMovementCells(){

    }

    @Override
    public void render(float delta){
        gameOverStage.act();
        gameOverStage.draw();
        spriteBatch.begin();
        spriteBatch.end();
    }
}
