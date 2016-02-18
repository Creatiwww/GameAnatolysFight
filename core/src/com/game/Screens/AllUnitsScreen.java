package com.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Actors.Field;
import com.game.Actors.MyActor;
import com.game.Actors.Playable.Creators.CreatorPlayableActor1;
import com.game.Actors.Playable.Creators.CreatorPlayableActor2;
import com.game.Actors.Playable.Creators.CreatorPlayableActor3;
import com.game.Actors.Playable.Creators.CreatorPlayableActor4;
import com.game.Actors.Playable.Creators.CreatorPlayableActor5;
import com.game.Controllers.WorldController;
import com.game.Main.AssetLoader;

import java.util.ArrayList;

public class AllUnitsScreen extends MyScreen {

    private Stage stage;
    private ArrayList <Float> neededScoreCoordinate;
    private ArrayList <Integer> neededScoce;
    private ArrayList <String> namesList;
    private Field field;
    private float namesFontHeight;
    private SpriteBatch spriteBatch;
    private String strAllUnitsScreenLabel = actorsController.getWorldController().getAndroidResInterface().getStrAllUnitsScreenLabel();

    public AllUnitsScreen(final WorldController worldController){
        super(worldController);
        spriteBatch = worldController.getBatch();
        field = worldController.getActorsController().getField();
        neededScoreCoordinate = new ArrayList();
        neededScoce = new ArrayList();
        namesList = new ArrayList();
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
        addActors();
        drawActors();
    }

    private void addActors(){
        int gameHighScore = AssetLoader.getHighScore();
        ArrayList <MyActor> actors = new ArrayList();
        actors.add(new CreatorPlayableActor1().factoryMethod("youngWoman"));
        neededScoce.add(0);
        namesList.add("Maria");
        actors.add(new CreatorPlayableActor2().factoryMethod("youngMan"));
        neededScoce.add(0);
        namesList.add("Pepper");
        actors.add(new CreatorPlayableActor3().factoryMethod("granny"));
        neededScoce.add(0);
        namesList.add("Inga");
        actors.add(new CreatorPlayableActor4().factoryMethod("oldMan"));
        neededScoce.add(0);
        namesList.add("Ivan");
        actors.add(new CreatorPlayableActor5().factoryMethod("newborn"));
        neededScoce.add(0);
        namesList.add("Lump");

        actors.add(new CreatorPlayableActor1().factoryMethod("youngWoman1"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_YOUNGWOMAN_1);
        namesList.add("Catherine");
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_YOUNGWOMAN_1) colorActorToBlack(actors);
        
        actors.add(new CreatorPlayableActor2().factoryMethod("youngMan1"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_YOUNGMAN_1);
        namesList.add("Vitaly");
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_YOUNGMAN_1) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor3().factoryMethod("granny1"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_GRANNY_1);
        namesList.add("Leila");
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_GRANNY_1) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor4().factoryMethod("oldMan1"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_OLDMAN_1);
        namesList.add("Christian");
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_OLDMAN_1) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor5().factoryMethod("baby1"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_BABY_1);
        namesList.add("Fats");
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_BABY_1) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor1().factoryMethod("youngWoman2"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_YOUNWOMAN_2);
        namesList.add("Anastacia");
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_YOUNWOMAN_2) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor2().factoryMethod("youngMan2"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_YOUNGMAN_2);
        namesList.add("Qasim");
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_YOUNGMAN_2) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor3().factoryMethod("granny2"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_GRANNY_2);
        namesList.add("Jeanne");
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_GRANNY_2) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor4().factoryMethod("oldMan2"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_OLDMAN_2);
        namesList.add("Bun");
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_OLDMAN_2) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor5().factoryMethod("baby2"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_BABY_2);
        namesList.add("Buggy");
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_BABY_2) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor1().factoryMethod("youngWoman3"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_YOUNWOMAN_3);
        namesList.add("Snowflake");
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_YOUNWOMAN_3) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor2().factoryMethod("youngMan3"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_YOUNGMAN_3);
        namesList.add("Bagel");
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_YOUNGMAN_3) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor3().factoryMethod("granny3"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_GRANNY_3);
        namesList.add("Cheesecake");
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_GRANNY_3) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor4().factoryMethod("oldMan3"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_OLDMAN_3);
        namesList.add("Screw");
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_OLDMAN_3) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor5().factoryMethod("baby3"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_BABY_3);
        namesList.add("Droppy");
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_BABY_3) colorActorToBlack(actors);
        Field field = actorsController.getField();
        // calculate and set position for actors
        int c = actors.size()-1;
        Field.Cell tempCellObject;
        float actorSize = field.getCellWidth() * (1 - (float) actorsController.ACTOR_SIZE_MODIFICATOR);
        //float dfs = field.getCellByIndex(2).getcY()-field.getCellByIndex(1).getcY();
        float yAxisOffSet= -3 * ((field.getCellByIndex(2).getcY()-field.getCellByIndex(1).getcY())-actorSize)*(actors.size()/5);
        int step = 1;
        for (int j = field.getFeildSizeY()-(actors.size()/5)+1; j <field.getFeildSizeY()+1 ; j++) {
            int k = 1;
            for (int i = actors.size()/(actors.size()/5); i > 0; i-- ){
                tempCellObject = field.getCellByIndex(field.getCoordinates().getCellIndexByXYIndexes(i, j));
                actors.get(c - k + 1).setSize(actorSize, actorSize);
                actors.get(c - k + 1).setPosition(tempCellObject.getcX() - (actors.get(c - k + 1).getWidth() / 2), yAxisOffSet + tempCellObject.getcY() - (actors.get(c - k + 1).getHeight() / 2));
                neededScoreCoordinate.add(tempCellObject.getcX());
                neededScoreCoordinate.add(tempCellObject.getbLY() + yAxisOffSet);
                k++;
            }
            c = c - 5;
            yAxisOffSet = (yAxisOffSet / ((actors.size()/5)-(step-1)))*(actors.size()/5 - (step));
            step++;
        }

        /*for (int i = (actors.size()/5); i > 0; i-- ) {
            int k = 1;
            for (int j = field.getFeildSizeY()-actors.size()/(actors.size()/5)+1; j <field.getFeildSizeY()+1 ; j++){
                tempCellObject = field.getCellByIndex(field.getCoordinates().getCellIndexByXYIndexes(i, j));
                actors.get(c - k + 1).setSize(actorSize, actorSize);
                actors.get(c - k + 1).setPosition(tempCellObject.getcX() - (actors.get(c - k + 1).getWidth() / 2), tempCellObject.getcY() - (actors.get(c - k + 1).getHeight() / 2));
                k++;
            }
            c = c - 5;
        }*/
        // add actors to stage

        for (MyActor actor : actors){
            stage.addActor(actor);
        }
       // AssetLoader.font.getData().setScale(0.45f);
      //  namesFontHeight = AssetLoader.font.draw(spriteBatch, "Test", 0, 0).width;

    }

    private float getNamesFontWidth (String name){
        AssetLoader.font.getData().setScale(0.45f);
        return AssetLoader.font.draw(spriteBatch, name, 0, 0).width;
    }

    private float getNamesFontHeight (){
        AssetLoader.font.getData().setScale(0.45f);
        double multiplier = 1.5;
        return AssetLoader.font.draw(spriteBatch, "0", 0, 0).height * (float) multiplier;
    }

    private void colorActorToBlack(ArrayList <MyActor> actors){
        actors.get(actors.size() - 1).setColor(0f, 0f, 0f, 1);
    }

    private String scoreToString(int score){
        return String.valueOf(score);
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
        AssetLoader.font.getData().setScale(1f);
        AssetLoader.font.draw(spriteBatch, strAllUnitsScreenLabel, Gdx.graphics.getWidth() / 2 - (AssetLoader.font.draw(spriteBatch, strAllUnitsScreenLabel, 0, 0).width) / 2, field.getCellByIndex(field.getFeildSizeY() - 1).gettLY() + field.getCellByIndex(field.getFeildSizeY() - 1).gettLY() / 13);
        AssetLoader.font.getData().setScale(0.45f);
        for (int i = 0; i< neededScoreCoordinate.size(); i=i+2){
            AssetLoader.font.draw(spriteBatch, scoreToString(neededScoce.get(neededScoce.size() - 1 - i / 2)), neededScoreCoordinate.get(i)-(getNamesFontWidth(scoreToString(neededScoce.get(neededScoce.size() - 1 - i / 2))))/2, neededScoreCoordinate.get(i + 1) - getNamesFontHeight());
            AssetLoader.font.draw(spriteBatch, namesList.get(neededScoce.size() - 1 - i / 2), neededScoreCoordinate.get(i)-(getNamesFontWidth(namesList.get(neededScoce.size() - 1 - i / 2))/2), neededScoreCoordinate.get(i + 1));
        }


        spriteBatch.end();
    }

}
