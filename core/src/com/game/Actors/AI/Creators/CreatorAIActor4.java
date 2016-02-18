package com.game.Actors.AI.Creators;

import com.game.Actors.AI.Products.AIActor;
import com.game.Actors.AI.Products.Shawarma;

public class CreatorAIActor4 implements CreatorAIActor {

    @Override
    public AIActor factoryMethod() { return new Shawarma(); }

    @Override
    public AIActor factoryMethod(String texturePath) {
        return new Shawarma (texturePath);
    }
}

