package com.game.Screens;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class GameStage extends Stage {
    private static final String TAG = GameStage.class.getName();

 public GameStage(StretchViewport viewport, Batch batch){
     super(viewport, batch);
     //Gdx.app.log("MyTag", "'constructor call end' method started @" + TAG);
 }
}