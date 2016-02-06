package com.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Controllers.WorldController;
import com.game.Main.AssetLoader;

public class InfoScreen extends MyScreen {

    private Stage stage;
    private SpriteBatch spriteBatch;

    public InfoScreen(final WorldController worldController){
        super(worldController);
        spriteBatch = worldController.getBatch();
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
    public void drawAvailableForMovementCells(){
    }

    @Override
    public void render(float delta){
        stage.act();
        stage.draw();
        spriteBatch.begin();
        spriteBatch.draw(AssetLoader.infoImage, 0,
                (Gdx.graphics.getHeight()-(AssetLoader.infoImage.getHeight() * Gdx.graphics.getWidth() / AssetLoader.infoImage.getWidth()))/2,
                Gdx.graphics.getWidth(), AssetLoader.infoImage.getHeight() * Gdx.graphics.getWidth() / AssetLoader.infoImage.getWidth());
        spriteBatch.end();
    }

}
