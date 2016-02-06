package com.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Controllers.WorldController;
import com.game.Main.AssetLoader;

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
       // startStage.addActor(startButton);
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
        spriteBatch.draw(AssetLoader.startImage,
                Gdx.graphics.getWidth()/2-AssetLoader.startImage.getRegionWidth()/2,
                Gdx.graphics.getHeight()/2-AssetLoader.startImage.getRegionHeight()/2);
        spriteBatch.end();
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                worldController.getScreenController().setGameScreen();
            }
        }
                , 2       //    (delay)
        );
    }
}
