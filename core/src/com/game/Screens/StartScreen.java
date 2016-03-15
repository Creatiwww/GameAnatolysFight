package com.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Controllers.WorldController;
import com.game.Main.AssetLoader;

public class StartScreen extends MyScreen {

    private Stage stage;
    private WorldController worldController;
    private SpriteBatch spriteBatch;
    private float imageSize;

    public StartScreen(final WorldController worldController){
        super(worldController);
        spriteBatch = worldController.getBatch();
        imageSize = worldController.getActorsController().getField().getCellWidth() * (float) (1 + 0.5);
        this.worldController = worldController;
        stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), worldController.getBatch());
        stage.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                worldController.getScreenController().setGameScreen();
            }
        });
    }

    @Override
    public Stage getStage(){
        return stage;
    }

    @Override
    public void drawActors(){
    }

    @Override
    public void displayStoryPicture (){};

    @Override
    public void drawAvailableForMovementCells(){
    }

    @Override
    public void render(float delta){
        stage.act();
        stage.draw();
        spriteBatch.begin();
        spriteBatch.draw(AssetLoader.startImage,
                Gdx.graphics.getWidth()/2 - imageSize/2,
                Gdx.graphics.getHeight()/2 - imageSize/2,
                imageSize,
                imageSize);
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
