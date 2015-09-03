package com.game.Controllers;

import com.game.Actors.Playable.Creators.CreatorPlayableActor;
import com.game.Actors.Playable.Creators.CreatorPlayableActor1;
import com.game.Actors.Playable.Creators.CreatorPlayableActor2;
import com.game.Actors.Playable.Listeners.PlayableActorsListener;
import com.game.Actors.Playable.Products.MyActor;
import com.game.Actors.Field;

import java.util.ArrayList;

public class ActorsController {
    private static final String TAG = ActorsController.class.getName();

    private CreatorPlayableActor creatorPlayableActor1;
    private CreatorPlayableActor creatorPlayableActor2;
    private ArrayList myActors;
    private Field field;

    public ActorsController(){
        field = new Field();
        myActors=new ArrayList();
        field.setSize(field.getCoordinates().getFieldWidth(),field.getCoordinates().getFieldHeight());
        field.setPosition(field.getCellByIndex(0).getbLX(), field.getCellByIndex(0).getbLY());
        creatorPlayableActor1=new CreatorPlayableActor1();
        creatorPlayableActor2=new CreatorPlayableActor2();
    }

    public ArrayList getActors(){
        return myActors;
    }
    public Field getField(){
        return field;
    }

    public void spawnInitialSetOfPlayableActors(){
        //Gdx.app.log("MyTag", "'createTestActor' method started @" + TAG);
        for (int i=0; i<2; i++) {

            if (i==0) myActors.add(creatorPlayableActor1.factoryMethod());
            else myActors.add(creatorPlayableActor2.factoryMethod());

            MyActor actor = (MyActor) myActors.get(i);
            final double ACTOR_SIZE_MODIFICATOR=0.15;
            float actorSize=field.getCellWidth()*(1-(float)ACTOR_SIZE_MODIFICATOR);
            actor.setSize(actorSize, actorSize);
            int cellIndexX=3-i;
            int cellindexY=5+i;
            int cellIndex=field.getCoordinates().getCellIndexByXYIndexes(cellIndexX, cellindexY);
            Field.Cell cell= field.getCellByIndex(cellIndex);
            actor.setPosition(cell.getcX()-actor.getWidth()/2, cell.getcY()-actor.getHeight()/2);
            actor.addListener(new PlayableActorsListener(actor, field));
        }
        //Gdx.app.log("MyTag", "'createTestActor' method ended @" + TAG);
    }
}
