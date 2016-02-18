package com.game.Actors.AI.Creators;

import com.game.Actors.AI.Products.AIActor;
import com.game.Actors.AI.Products.Cola;

public class CreatorAIActor6 implements CreatorAIActor {

    @Override
    public AIActor factoryMethod() { return new Cola(); }

    @Override
    public AIActor factoryMethod(String texturePath) {
        return new Cola (texturePath);
    }
}

