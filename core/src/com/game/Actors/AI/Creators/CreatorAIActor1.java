package com.game.Actors.AI.Creators;

import com.game.Actors.AI.Products.AIActor1;
import com.game.Actors.AI.Products.ProductAIActor;

public class CreatorAIActor1 implements CreatorAIActor {
    private static final String TAG = CreatorAIActor1.class.getName();

    @Override
    public ProductAIActor factoryMethod() { return new AIActor1(); }
}
