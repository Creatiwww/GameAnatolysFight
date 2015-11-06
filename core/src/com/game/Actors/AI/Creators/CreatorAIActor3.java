package com.game.Actors.AI.Creators;

import com.game.Actors.AI.Products.AIActor;
import com.game.Actors.AI.Products.MilkShake;

public class CreatorAIActor3 implements CreatorAIActor {

    @Override
    public AIActor factoryMethod() { return new MilkShake(); }
}

