package com.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Actors.AvailableForMovementCell;
import com.game.Actors.UI.HelpButton;
import com.game.Actors.MergeableCell;
import com.game.Actors.MyActor;
import com.game.Actors.OccupiedByAICell;
import com.game.Actors.UI.MusicButton;
import com.game.Actors.UI.RestartButton;
import com.game.Actors.UI.StoryPictures;
import com.game.Actors.UI.StoryPicturesListener;
import com.game.Actors.UI.UnitsButton;
import com.game.Controllers.WorldController;
import com.game.Actors.Field;
import com.game.Main.AssetLoader;

public class GameScreen extends MyScreen {

    private Stage gameStage;
    private Field field;
    private RestartButton restartButton;
    private HelpButton helpButton;
    private UnitsButton unitsButton;
    private MusicButton musicButton;
    private WorldController worldController;
    private SpriteBatch spriteBatch;
    private String strScore, strRecord, strLevel;
    private float scale;
    private StoryPictures storyPicturesActor;
    private boolean ifStorePictureExist;

    public GameScreen(WorldController worldController){
        super(worldController);
        spriteBatch = worldController.getBatch();
        ifStorePictureExist = false;
        this.worldController = worldController;
        field = worldController.getActorsController().getField();
        restartButton = worldController.getActorsController().getRestartButton();
        helpButton = worldController.getActorsController().getHelpButton();
        unitsButton = worldController.getActorsController().getUnitsButton();
        musicButton = worldController.getActorsController().getMusicButton();
        gameStage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), worldController.getBatch());
        gameStage.addActor(field);
        gameStage.addActor(restartButton);
        gameStage.addActor(helpButton);
        gameStage.addActor(unitsButton);
        gameStage.addActor(musicButton);
        strScore = worldController.getAndroidResInterface().getStrScore();
        strRecord = worldController.getAndroidResInterface().getStrRecord();
        strLevel = worldController.getAndroidResInterface().getStrLevel();
        scale = AssetLoader.scale;
        drawActors();
    }

    public void displayStoryPicture(){
        storyPicturesActor = actorsController.getStoryPictures();
        StoryPicturesListener storyPicturesActorListener = new StoryPicturesListener(storyPicturesActor);
        storyPicturesActor.addListener(storyPicturesActorListener);
        float IMG_WITH = Gdx.graphics.getWidth() * 0.80f;
        float IMG_HEIGHT = IMG_WITH * 1.197f;
        storyPicturesActor.setSize(IMG_WITH, IMG_HEIGHT);
        float possitionX = (Gdx.graphics.getWidth() - IMG_WITH) / 2;
        float possitionY = (Gdx.graphics.getHeight() - IMG_HEIGHT) / 2;
        storyPicturesActor.setPosition(possitionX, possitionY);
        gameStage.addActor(storyPicturesActor);
        ifStorePictureExist = true;
    }

    @Override
    public Stage getStage(){
        return gameStage;
    }

    @Override
    public void drawActors(){
        for(Object myActor:actorsController.getActors()) {
            gameStage.addActor((MyActor)myActor);
        }
            if (ifStorePictureExist) storyPicturesActor.toFront();
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
        worldController.getGameCycle().run();
        gameStage.act();
        gameStage.draw();
        spriteBatch.begin();
        // Draw level
        String strLevelNo = strLevel + " " + worldController.getEnemyWave().getWaveNumber();
        AssetLoader.font.getData().setScale(scale);
        float yCoorSmesh =  AssetLoader.font.draw(spriteBatch, "1", 0, 0).height;
        AssetLoader.font.draw(spriteBatch, strLevelNo,
                field.getCellByIndex(0).getbLX(),
                -field.getCellByIndex(0).getbLY() / 2 + field.getCellByIndex(0).getbLY() + (yCoorSmesh*13/40));
                //field.getCellByIndex(0).getbLY()-(field.getCellWidth()+field.getCellWidth()/2) +  AssetLoader.font.getCapHeight()*2);
                // Draw word "score"
        AssetLoader.font.getData().setScale(scale * 0.5f);
        AssetLoader.font.draw(spriteBatch, strScore,
                field.getCellByIndex(0).getbLX(),
                field.getCellByIndex(field.getFeildSizeY() - 1).gettLY() + field.getCellByIndex(field.getFeildSizeY() - 1).gettLY()/27);
        // Draw word "record"
        AssetLoader.font.draw(spriteBatch, strRecord, field.getCellByIndex(0).getbLX() + (field.getFeildSizeX() * field.getCellWidth())/2,
                field.getCellByIndex(field.getFeildSizeY() - 1).gettLY() + field.getCellByIndex(field.getFeildSizeY()-1).gettLY()/27);
        // Draw current score
        AssetLoader.font.getData().setScale(scale);
        AssetLoader.font.draw(spriteBatch, "" + worldController.getScore(),
                field.getCellByIndex(0).getbLX(),
                field.getCellByIndex(field.getFeildSizeY() - 1).gettLY() + field.getCellByIndex(field.getFeildSizeY() - 1).gettLY() / 13);
        // Draw high score
        AssetLoader.font.draw(spriteBatch, "" + AssetLoader.getHighScore(),
                field.getCellByIndex(0).getbLX()+(field.getFeildSizeX()*field.getCellWidth())/2,
                field.getCellByIndex(field.getFeildSizeY()-1).gettLY()+field.getCellByIndex(field.getFeildSizeY()-1).gettLY()/13);
        // Draw particles
        AssetLoader.particleEffectAttack.draw(spriteBatch, delta);
        spriteBatch.end();
    }
}
