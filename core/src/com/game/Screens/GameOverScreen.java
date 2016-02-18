package com.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Actors.Field;
import com.game.Actors.MyActor;
import com.game.Controllers.WorldController;
import com.game.Main.AssetLoader;

public class GameOverScreen extends MyScreen {

    private Stage stage;
    private SpriteBatch spriteBatch;
    private String strScore = actorsController.getWorldController().getAndroidResInterface().getStrScore();
    private String strRecord = actorsController.getWorldController().getAndroidResInterface().getStrRecord();
    private String strLevel = actorsController.getWorldController().getAndroidResInterface().getStrLevel();
    private WorldController worldController = actorsController.getWorldController();
    private Field field = actorsController.getField();
    private float w, h, c1w, c1h, p1w, p1h, c2w, c3w, c4w, c5w, c6w, c7w, c2h, c5h;
    private boolean isElementsPositioningVariablesInitiated = false;

    public GameOverScreen(final WorldController worldController){
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
                for (Object actor:  worldController.getActorsController().getActors()){
                    MyActor myActor = (MyActor)actor;
                    myActor.setHP(-1);
                }
                actorsController.deleteDeadUnits(false);
                //actorsController.reproductionPauseRedaction();
                //actorsController.ageIncrease();
                //actorsController.maturation();
                worldController.nullScore();
                worldController.getEnemyWave().setWaveNumber(1);
                worldController.getAiController().nullWaveDifficulty();
                AssetLoader.clearPrefs();
                worldController.getGameCycle().setGameState("WAVE_GENERATING_STARTED");
                worldController.getScreenController().setGameScreen();
            }
        });
    }

    private void initiatePositioningVariables(){
        if (!isElementsPositioningVariablesInitiated) {
            w = Gdx.graphics.getWidth();
            h = Gdx.graphics.getHeight();
            AssetLoader.font.getData().setScale(1f);
            c1w = AssetLoader.font.draw(spriteBatch, "Game Over", 0, 0).width;
            c1h = AssetLoader.font.draw(spriteBatch, "Game Over", 0, 0).height;
            p1w = AssetLoader.gameOverImage.getRegionWidth();
            p1h = AssetLoader.gameOverImage.getRegionHeight();
            c2w = AssetLoader.font.draw(spriteBatch, "" + worldController.getEnemyWave().getWaveNumber(), 0, 0).width;
            c2h = AssetLoader.font.draw(spriteBatch, "" + worldController.getEnemyWave().getWaveNumber(), 0, 0).height;
            c3w = AssetLoader.font.draw(spriteBatch, "" + worldController.getScore(), 0, 0).width;
            c4w = AssetLoader.font.draw(spriteBatch, "" + AssetLoader.getHighScore(), 0, 0).width;
            AssetLoader.font.getData().setScale(0.6f);
            c5w = AssetLoader.font.draw(spriteBatch, strLevel, 0, 0).width;
            c5h = AssetLoader.font.draw(spriteBatch, strLevel, 0, 0).height;
            c6w = AssetLoader.font.draw(spriteBatch, strScore, 0, 0).width;
            c7w = AssetLoader.font.draw(spriteBatch, strRecord, 0, 0).width;
            isElementsPositioningVariablesInitiated = true;
        }
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
        initiatePositioningVariables();
        AssetLoader.font.getData().setScale(1f);
        // Draw Game Over capture
        AssetLoader.font.draw(spriteBatch, "Game Over", w/2 - c1w/2, h/2 + p1h + 2*c1h);
        // Draw level number
        AssetLoader.font.draw(spriteBatch, "" + worldController.getEnemyWave().getWaveNumber(), w/6 - c2w/2, h/2 - p1h);
        // Draw current score
        AssetLoader.font.draw(spriteBatch, "" + worldController.getScore(), w/2 - c3w/2, h/2 - p1h );
        // Draw high score
        float temp = 0.83333f*w;
        AssetLoader.font.draw(spriteBatch, "" + AssetLoader.getHighScore(), temp- c4w/2, h/2 - p1h );
        AssetLoader.font.getData().setScale(0.6f);
        // Draw level capture
        AssetLoader.font.draw(spriteBatch, strLevel, w/6 - c5w/2,  h/2 - p1h - 2*c5h);
        // Draw score capture
        AssetLoader.font.draw(spriteBatch, strScore, w/2 - c6w/2,  h/2 - p1h - 2*c5h);
        // Draw record capture
        AssetLoader.font.draw(spriteBatch, strRecord, temp - c7w/2,  h/2 - p1h - 2*c5h);
        // Draw evil warm picture
        spriteBatch.draw(AssetLoader.gameOverImage, w/2 - p1w/2, h/2 - p1h/4);
        spriteBatch.end();
    }
}
