package com.game.Controllers;

import com.game.Actors.AI.Creators.CreatorAIActor;
import com.game.Actors.AI.Products.ProductAIActor;
import com.game.Actors.Playable.Creators.CreatorPlayableActor;
import com.game.Actors.Playable.Creators.CreatorPlayableActor1;
import com.game.Actors.Playable.Products.MyActor;

public class ActorsController {
    private static final String TAG = ActorsController.class.getName();

    private CreatorAIActor creatorAIActor1;
    private CreatorAIActor creatorAIActor2;
    private ProductAIActor AIActor1;
    private ProductAIActor AIActor2;
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
        myActors[0].setSize(1, 1);
        myActors[0].setPosition(1, 1);
        //Gdx.app.log("MyTag", "'createTestActor' method ended @" + TAG);
    }

}
