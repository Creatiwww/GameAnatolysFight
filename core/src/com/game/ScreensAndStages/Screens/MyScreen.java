package com.game.ScreensAndStages.Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.game.Actors.Playable.Products.MyActor;
import com.game.Controllers.ActorsController;
import com.game.Controllers.WorldController;
import com.game.Main.GameConstants;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.ScreensAndStages.Stages.GameStage;

abstract public class MyScreen implements Screen {
    private GameStage gameStage;
    private ActorsController actorsController;
    private OrthographicCamera camera;
    private Batch batch;

    public MyScreen(WorldController worldController){
        batch=worldController.getBatch();
        actorsController = worldController.getActorsController();
        //camera = new OrthographicCamera(GameConstants.VIEWPORT_WIDTH, GameConstants.VIEWPORT_HEIGHT);
        //camera.position.set(0, 0, 0);
        //camera.update();
        gameStage=new GameStage(new StretchViewport(GameConstants.VIEWPORT_WIDTH, GameConstants.VIEWPORT_HEIGHT), batch);
        for(MyActor myActor:actorsController.getActors()) {
            gameStage.addActor(myActor);
        }
    }

    @Override
    public void resize(int width, int height){
        //camera.viewportWidth = (GameConstants.VIEWPORT_HEIGHT / height) * width;
        //camera.update();
    }

    @Override
    public void resume(){
    }

    @Override
    public void pause(){
    }

    @Override
    public void render(float delta){
       // gameStage.act(delta);
       gameStage.draw();
    }

    @Override
    public void show(){
    }

    @Override
    public void hide(){
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
