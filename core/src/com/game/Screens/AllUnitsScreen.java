package com.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.Actors.AI.Creators.CreatorAIActor1;
import com.game.Actors.AI.Creators.CreatorAIActor2;
import com.game.Actors.AI.Creators.CreatorAIActor3;
import com.game.Actors.Field;
import com.game.Actors.MyActor;
import com.game.Actors.Playable.Creators.CreatorPlayableActor1;
import com.game.Actors.Playable.Creators.CreatorPlayableActor2;
import com.game.Actors.Playable.Creators.CreatorPlayableActor3;
import com.game.Actors.Playable.Creators.CreatorPlayableActor4;
import com.game.Actors.Playable.Creators.CreatorPlayableActor5;
import com.game.Controllers.ActorsController;
import com.game.Controllers.WorldController;
import com.game.Main.AssetLoader;

import java.util.ArrayList;

public class AllUnitsScreen extends MyScreen {

    private Stage stage;
    private SpriteBatch spriteBatch;

    public AllUnitsScreen(final WorldController worldController){
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
        addActors();
        drawActors();
    }

    private void addActors(){
        int gameHighScore = AssetLoader.getHighScore();
        ArrayList <MyActor> actors = new ArrayList();
        actors.add(new CreatorPlayableActor1().factoryMethod("youngWoman"));
        actors.add(new CreatorPlayableActor2().factoryMethod("youngMan"));
        actors.add(new CreatorPlayableActor3().factoryMethod("granny"));
        actors.add(new CreatorPlayableActor4().factoryMethod("oldMan"));
        actors.add(new CreatorPlayableActor5().factoryMethod("newborn"));
        actors.add(new CreatorPlayableActor1().factoryMethod("youngWoman1"));
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_YOUNGWOMAN_1) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor2().factoryMethod("youngMan1"));
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_YOUNGMAN_1) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor3().factoryMethod("granny1"));
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_GRANNY_1) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor4().factoryMethod("oldMan1"));
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_OLDMAN_1) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor5().factoryMethod("baby1"));
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_BABY_1) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor1().factoryMethod("youngWoman2"));
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_YOUNWOMAN_2) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor2().factoryMethod("youngMan2"));
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_YOUNGMAN_2) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor3().factoryMethod("granny2"));
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_GRANNY_2) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor4().factoryMethod("oldMan2"));
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_OLDMAN_2) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor5().factoryMethod("baby2"));
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_BABY_2) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor1().factoryMethod("youngWoman3"));
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_YOUNWOMAN_3) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor2().factoryMethod("youngMan3"));
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_YOUNGMAN_3) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor3().factoryMethod("granny3"));
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_GRANNY_3) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor4().factoryMethod("oldMan3"));
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_OLDMAN_3) colorActorToBlack(actors);
        actors.add(new CreatorPlayableActor5().factoryMethod("baby3"));
        if (gameHighScore < actorsController.SCORES_REQ_SKIN_BABY_3) colorActorToBlack(actors);
        Field field = actorsController.getField();
        // calculate and set position for actors
        int c = actors.size()-1;
        Field.Cell tempCellObject;
        for (int i = (actors.size()/5); i > 0; i-- ) {
            int k = 1;
            for (int j = field.getFeildSizeY()-actors.size()/(actors.size()/5)+1; j <field.getFeildSizeY()+1 ; j++){
                tempCellObject = field.getCellByIndex(field.getCoordinates().getCellIndexByXYIndexes(i, j));
                actors.get(c - k + 1).setPosition(tempCellObject.getbLX(), tempCellObject.getbLY());
                k++;
            }
            c = c - 5;
        }
        // add actors to stage
        float actorSize = field.getCellWidth() * (1 - (float) actorsController.ACTOR_SIZE_MODIFICATOR);
        for (MyActor actor : actors){
            actor.setSize(actorSize, actorSize);
            stage.addActor(actor);
        }

    }

    private void colorActorToBlack(ArrayList <MyActor> actors){
        actors.get(actors.size()-1).setColor(0f, 0f, 0f, 1);
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
       // float imgToScreenWidth = Gdx.graphics.getWidth() / AssetLoader.infoImage.getWidth();
        //spriteBatch.draw(AssetLoader.infoImage, 0, (Gdx.graphics.getHeight()-(AssetLoader.infoImage.getHeight() * Gdx.graphics.getWidth() / AssetLoader.infoImage.getWidth()))/2, Gdx.graphics.getWidth(), AssetLoader.infoImage.getHeight() * Gdx.graphics.getWidth() / AssetLoader.infoImage.getWidth());
        spriteBatch.end();
    }

}
