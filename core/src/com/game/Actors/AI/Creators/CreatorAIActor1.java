package com.game.Actors.AI.Creators;

import com.game.Actors.AI.Products.AIActor1;
import com.game.Actors.AI.Products.ProductAIActor;

public class CreatorAIActor1 implements CreatorAIActor {
    @Override
    public ProductAIActor factoryMethod() { return new AIActor1(); }
}
