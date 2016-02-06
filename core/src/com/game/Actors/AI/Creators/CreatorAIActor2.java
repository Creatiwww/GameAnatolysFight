package com.game.Actors.AI.Creators;

import com.game.Actors.AI.Products.HotDog;
import com.game.Actors.AI.Products.AIActor;

public class CreatorAIActor2 implements CreatorAIActor {

    @Override
    public AIActor factoryMethod() { return new HotDog(); }

    @Override
    public AIActor factoryMethod(String texturePath) {
        return new HotDog (texturePath);
    }
}
