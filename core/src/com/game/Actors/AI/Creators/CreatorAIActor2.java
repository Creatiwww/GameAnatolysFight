package com.game.Actors.AI.Creators;

import com.game.Actors.AI.Products.AIActor2;
import com.game.Actors.AI.Products.AIActor;

public class CreatorAIActor2 implements CreatorAIActor {
    private static final String TAG = CreatorAIActor2.class.getName();

    @Override
    public AIActor factoryMethod() { return new AIActor2(); }
}
