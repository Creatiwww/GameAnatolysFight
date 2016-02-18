package com.game.Actors.AI.Creators;

import com.game.Actors.AI.Products.AIActor;
import com.game.Actors.AI.Products.Soda;

public class CreatorAIActor5 implements CreatorAIActor {

    @Override
    public AIActor factoryMethod() { return new Soda(); }

    @Override
    public AIActor factoryMethod(String texturePath) {
        return new Soda (texturePath);
    }
}

