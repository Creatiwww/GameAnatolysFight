package com.game.Actors.AI.Creators;

import com.game.Actors.AI.Products.Hamburger;
import com.game.Actors.AI.Products.AIActor;

public class CreatorAIActor1 implements CreatorAIActor {

    @Override
    public AIActor factoryMethod() { return new Hamburger(); }

    @Override
    public AIActor factoryMethod(String texturePath) {
        return new Hamburger(texturePath);
    }
}
