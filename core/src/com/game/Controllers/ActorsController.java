package com.game.Controllers;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.game.Actors.AI.Creators.CreatorAIActor;
import com.game.Actors.AI.Products.ProductAIActor;
import com.game.Actors.Playable.Creators.CreatorPlayableActor;
import com.game.Actors.Playable.Creators.CreatorPlayableActor1;
import com.game.Actors.Playable.Listeners.PlayableActorsListener;
import com.game.Actors.Playable.Products.MyActor;

public class ActorsController {
    private static final String TAG = ActorsController.class.getName();

    private CreatorPlayableActor creatorPlayableActor1;
    private CreatorPlayableActor creatorPlayableActor2;
    private MyActor[] myActors;

    public ActorsController(){
        myActors=new MyActor[1];
    }

    public MyActor[] getActors(){
        return myActors;
    }

    public void spawnActor(){
        //Gdx.app.log("MyTag", "'createTestActor' method started @" + TAG);
        creatorPlayableActor1 = new CreatorPlayableActor1();
        myActors[0] = creatorPlayableActor1.factoryMethod();
        myActors[0].setSize(300, 300);
        myActors[0].setPosition(100, 100);

//        myActors[0].addListener(new DragListener() {
//            public void drag(InputEvent event, float x, float y, int pointer) {
//                myActors[0].moveBy(x - myActors[0].getWidth() / 2, y - myActors[0].getHeight() / 2);
//            }
//        });

        myActors[0].addListener(new PlayableActorsListener(myActors[0]));

        //Gdx.app.log("MyTag", "'createTestActor' method ended @" + TAG);
    }

}
