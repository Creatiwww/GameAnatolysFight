package com.game.ScreensAndStages.Stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class GameStage extends Stage {
    private static final String TAG = GameStage.class.getName();

 public GameStage(StretchViewport viewport, Batch batch){
     super(viewport, batch);
     Gdx.input.setInputProcessor(this);
     //Gdx.app.log("MyTag", "'constructor call end' method started @" + TAG);
 }
}