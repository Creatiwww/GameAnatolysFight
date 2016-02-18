package com.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Actors.Field;
import com.game.Controllers.WorldController;
import com.game.Main.AssetLoader;

public class InfoScreen extends MyScreen {

    private Stage stage;
    private Field field;
    private SpriteBatch spriteBatch;
    private String strInfoScreenLabel = actorsController.getWorldController().getAndroidResInterface().getStrInfoScreenLabel();

    public InfoScreen(final WorldController worldController){
        super(worldController);
        spriteBatch = worldController.getBatch();
        field = worldController.getActorsController().getField();
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
        spriteBatch.draw(AssetLoader.infoImage, field.getCellByIndex(0).getbLX(),field.getCellByIndex(0).getbLY(), field.getCoordinates().getFieldWidth(), field.getCoordinates().getFieldHeight());
/*        AssetLoader.font.getData().setScale(1f);
        AssetLoader.font.draw(spriteBatch, strInfoScreenLabel,
                Gdx.graphics.getWidth() / 2 - (AssetLoader.font.draw(spriteBatch, strInfoScreenLabel, 0, 0).width) / 2,
                actorsController.getField().getCellByIndex(actorsController.getField().getFeildSizeY() - 1).gettLY() + actorsController.getField().getCellByIndex(actorsController.getField().getFeildSizeY() - 1).gettLY() / 13);*/
        spriteBatch.end();
    }

}
