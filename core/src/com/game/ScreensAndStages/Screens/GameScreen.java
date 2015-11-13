package com.game.ScreensAndStages.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Actors.AvailableForMovementCell;
import com.game.Actors.MergeableCell;
import com.game.Actors.MyActor;
import com.game.Actors.OccupiedByAICell;
import com.game.Controllers.WorldController;
import com.game.Actors.Field;
import com.game.Main.AssetLoader;
import com.game.ScreensAndStages.Stages.GameStage;

public class GameScreen extends MyScreen {

    private GameStage gameStage;
    private Field field;
    private WorldController worldController;
    private SpriteBatch spriteBatch;
    private String score;
    private String hiScore;

    public GameScreen(WorldController worldController){
        super(worldController);
        spriteBatch = worldController.getBatch();
        this.worldController=worldController;
        field=worldController.getActorsController().getField();
        gameStage=new GameStage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), batch);
        gameStage.addActor(field);
        drawActors();
    }

    @Override
    public GameStage getGameStage(){
        return gameStage;
    }

    @Override
    public void drawActors(){
        for(Object myActor:actorsController.getActors()) {
            gameStage.addActor((MyActor)myActor);
        }
    }

    @Override
    public void drawAvailableForMovementCells(){
        Actor cell;
        for(Object cellIterator:actorsController.getAvailableCell()) {
            gameStage.addActor((AvailableForMovementCell)cellIterator);
            cell=(Actor)cellIterator;
            cell.toBack();
        }
        for(Object cellIterator:actorsController.getMergeableCell()) {
            gameStage.addActor((MergeableCell)cellIterator);
            cell=(Actor)cellIterator;
            cell.toBack();
        }
        for(Object cellIterator:actorsController.getOccupiedByAICell()) {
            gameStage.addActor((OccupiedByAICell)cellIterator);
            cell=(Actor)cellIterator;
            cell.toBack();
        }
        field.toBack();
    }

    @Override
    public void render(float delta){
        worldController.runMainGameCycle();
        gameStage.act();
        score = worldController.getScore() + "";
        hiScore = AssetLoader.getHighScore() + "";
        spriteBatch.begin();
        AssetLoader.font.draw(spriteBatch, "" + worldController.getScore(), (136 / 2) - (3 * score.length() - 1), 111);
        AssetLoader.font.draw(spriteBatch, "" + AssetLoader.getHighScore(), (136 / 2) - (3 * hiScore.length() - 1), 311);
        spriteBatch.end();
        gameStage.draw();

    }
}
