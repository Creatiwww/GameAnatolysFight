package com.game.Controllers;

import com.game.Actors.Playable.Creators.CreatorPlayableActor;
import com.game.Actors.Playable.Creators.CreatorPlayableActor1;
import com.game.Actors.Playable.Listeners.PlayableActorsListener;
import com.game.Actors.Playable.Products.MyActor;
import com.game.Actors.Field;

public class ActorsController {
    private static final String TAG = ActorsController.class.getName();

    private CreatorPlayableActor creatorPlayableActor1;
    private CreatorPlayableActor creatorPlayableActor2;
    private MyActor[] myActors;
    private Field field;

    public ActorsController(){
        myActors=new MyActor[1];
        field = new Field();
        field.setSize(field.getCoordinates().getFieldWidth(),field.getCoordinates().getFieldHeight());
        field.setPosition(field.getCellByIndex(0).getbLX(),field.getCellByIndex(0).getbLY());
    }

    public MyActor[] getActors(){
        return myActors;
    }

    public void spawnActor(){
        //Gdx.app.log("MyTag", "'createTestActor' method started @" + TAG);
        creatorPlayableActor1 = new CreatorPlayableActor1();
        myActors[0] = creatorPlayableActor1.factoryMethod();
        myActors[0].setSize(200, 200);
        myActors[0].setPosition(100, 400);
        myActors[0].addListener(new PlayableActorsListener(myActors[0],field));
        //Gdx.app.log("MyTag", "'createTestActor' method ended @" + TAG);
    }
    public Field getField(){
        return field;
    }
}
