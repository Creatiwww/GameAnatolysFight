package com.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Controllers.WorldController;

public class InfoScreen extends MyScreen {

    private Stage infoStage;
    private ImageButton closeButton;
    private WorldController worldController;
    private SpriteBatch spriteBatch;

    public InfoScreen(WorldController worldController){
        super(worldController);
        spriteBatch = worldController.getBatch();
        this.worldController = worldController;
        closeButton= (ImageButton) worldController.getActorsController().getCloseButton();
        infoStage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), worldController.getBatch());
        infoStage.clear();
        infoStage.addActor(closeButton);
        drawActors();
    }

    @Override
    public Stage getStage(){
        return infoStage;
    }

    @Override
    public void drawActors(){
    }

    @Override
    public void drawAvailableForMovementCells(){
    }

    @Override
    public void render(float delta){
        infoStage.act();
        infoStage.draw();
        spriteBatch.begin();
        spriteBatch.end();
    }
}
