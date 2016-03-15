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
import com.game.Actors.UI.QuestionMark;
import com.game.Controllers.WorldController;
import com.game.Main.AssetLoader;

import java.util.ArrayList;

public class AllUnitsScreen extends MyScreen {

    private Stage stage;
    private ArrayList <Float> neededScoreCoordinate;
    private ArrayList <Integer> neededScoce;
    private ArrayList <String> namesList;
    private Field field;
    private float scale;
    private SpriteBatch spriteBatch;
    private String strAllUnitsScreenLabel = actorsController.getWorldController().getAndroidResInterface().getStrAllUnitsScreenLabel();

    public AllUnitsScreen(final WorldController worldController){
        super(worldController);
        spriteBatch = worldController.getBatch();
        field = worldController.getActorsController().getField();
        scale = AssetLoader.scale;
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
        namesList.add("Katya");
        actors.add(new CreatorPlayableActor2().factoryMethod("youngMan"));
        neededScoce.add(0);
        namesList.add("Felix");
        actors.add(new CreatorPlayableActor3().factoryMethod("granny"));
        neededScoce.add(0);
        namesList.add("Raisa");
        actors.add(new CreatorPlayableActor4().factoryMethod("oldMan"));
        neededScoce.add(0);
        namesList.add("Anatoly");
        actors.add(new CreatorPlayableActor5().factoryMethod("newborn"));
        neededScoce.add(0);
        namesList.add("Maloy");

        if (gameHighScore < actorsController.SCORES_REQ_SKIN_YOUNGWOMAN_1) spawnQuestionMark(actors);
        else actors.add(new CreatorPlayableActor1().factoryMethod("youngWoman1"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_YOUNGWOMAN_1);
        namesList.add("Anyuta");

        if (gameHighScore < actorsController.SCORES_REQ_SKIN_YOUNGMAN_1) spawnQuestionMark(actors);
        else actors.add(new CreatorPlayableActor2().factoryMethod("youngMan1"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_YOUNGMAN_1);
        namesList.add("Alexey");

        if (gameHighScore < actorsController.SCORES_REQ_SKIN_GRANNY_1) spawnQuestionMark(actors);
        else actors.add(new CreatorPlayableActor3().factoryMethod("granny1"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_GRANNY_1);
        namesList.add("Olga");

        if (gameHighScore < actorsController.SCORES_REQ_SKIN_OLDMAN_1) spawnQuestionMark(actors);
        else actors.add(new CreatorPlayableActor4().factoryMethod("oldMan1"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_OLDMAN_1);
        namesList.add("Sergey");

        if (gameHighScore < actorsController.SCORES_REQ_SKIN_BABY_1) spawnQuestionMark(actors);
        else actors.add(new CreatorPlayableActor5().factoryMethod("baby1"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_BABY_1);
        namesList.add("Peach");

        if (gameHighScore < actorsController.SCORES_REQ_SKIN_YOUNWOMAN_2) spawnQuestionMark(actors);
        else actors.add(new CreatorPlayableActor1().factoryMethod("youngWoman2"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_YOUNWOMAN_2);
        namesList.add("Christina");

        if (gameHighScore < actorsController.SCORES_REQ_SKIN_YOUNGMAN_2) spawnQuestionMark(actors);
        else actors.add(new CreatorPlayableActor2().factoryMethod("youngMan2"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_YOUNGMAN_2);
        namesList.add("Valera");

        if (gameHighScore < actorsController.SCORES_REQ_SKIN_GRANNY_2) spawnQuestionMark(actors);
        else actors.add(new CreatorPlayableActor3().factoryMethod("granny2"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_GRANNY_2);
        namesList.add("Evgenia");

        if (gameHighScore < actorsController.SCORES_REQ_SKIN_OLDMAN_2) spawnQuestionMark(actors);
        else actors.add(new CreatorPlayableActor4().factoryMethod("oldMan2"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_OLDMAN_2);
        namesList.add("Sasha");

        if (gameHighScore < actorsController.SCORES_REQ_SKIN_BABY_2) spawnQuestionMark(actors);
        else actors.add(new CreatorPlayableActor5().factoryMethod("baby2"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_BABY_2);
        namesList.add("Honey");

        if (gameHighScore < actorsController.SCORES_REQ_SKIN_YOUNWOMAN_3) spawnQuestionMark(actors);
        else actors.add(new CreatorPlayableActor1().factoryMethod("youngWoman3"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_YOUNWOMAN_3);
        namesList.add("Alena");

        if (gameHighScore < actorsController.SCORES_REQ_SKIN_YOUNGMAN_3) spawnQuestionMark(actors);
        else actors.add(new CreatorPlayableActor2().factoryMethod("youngMan3"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_YOUNGMAN_3);
        namesList.add("Roma");

        if (gameHighScore < actorsController.SCORES_REQ_SKIN_GRANNY_3) spawnQuestionMark(actors);
        else actors.add(new CreatorPlayableActor3().factoryMethod("granny3"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_GRANNY_3);
        namesList.add("Irina");

        if (gameHighScore < actorsController.SCORES_REQ_SKIN_OLDMAN_3) spawnQuestionMark(actors);
        else actors.add(new CreatorPlayableActor4().factoryMethod("oldMan3"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_OLDMAN_3);
        namesList.add("Daniel");

        if (gameHighScore < actorsController.SCORES_REQ_SKIN_BABY_3) spawnQuestionMark(actors);
        else actors.add(new CreatorPlayableActor5().factoryMethod("baby3"));
        neededScoce.add(actorsController.SCORES_REQ_SKIN_BABY_3);
        namesList.add("Karapuz");

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

        for (MyActor actor : actors){
            stage.addActor(actor);
        }
    }

    private float getNamesFontWidth (String name){
        AssetLoader.font.getData().setScale(scale * 0.45f);
        return AssetLoader.font.draw(spriteBatch, name, 0, 0).width;
    }

    private float getNamesFontHeight (){
        AssetLoader.font.getData().setScale(scale * 0.45f);
        double multiplier = 1.5;
        return AssetLoader.font.draw(spriteBatch, "0", 0, 0).height * (float) multiplier;
    }

    private void spawnQuestionMark(ArrayList<MyActor> actors){
        actors.add(new QuestionMark());
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
    public void displayStoryPicture (){};

    @Override
    public void drawAvailableForMovementCells(){
    }

    @Override
    public void render(float delta){
        stage.act();
        stage.draw();
        spriteBatch.begin();
        AssetLoader.font.getData().setScale(scale);
        AssetLoader.font.draw(spriteBatch, strAllUnitsScreenLabel, Gdx.graphics.getWidth() / 2 - (AssetLoader.font.draw(spriteBatch, strAllUnitsScreenLabel, 0, 0).width) / 2, field.getCellByIndex(field.getFeildSizeY() - 1).gettLY() + field.getCellByIndex(field.getFeildSizeY() - 1).gettLY() / 13);
        AssetLoader.font.getData().setScale(scale * 0.45f);
        for (int i = 0; i< neededScoreCoordinate.size(); i=i+2){
            AssetLoader.font.draw(spriteBatch, scoreToString(neededScoce.get(neededScoce.size() - 1 - i / 2)), neededScoreCoordinate.get(i)-(getNamesFontWidth(scoreToString(neededScoce.get(neededScoce.size() - 1 - i / 2))))/2, neededScoreCoordinate.get(i + 1) - getNamesFontHeight());
            AssetLoader.font.draw(spriteBatch, namesList.get(neededScoce.size() - 1 - i / 2), neededScoreCoordinate.get(i)-(getNamesFontWidth(namesList.get(neededScoce.size() - 1 - i / 2))/2), neededScoreCoordinate.get(i + 1));
        }


        spriteBatch.end();
    }

}
