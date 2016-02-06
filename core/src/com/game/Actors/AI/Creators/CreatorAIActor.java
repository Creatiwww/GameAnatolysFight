package com.game.Actors.AI.Creators;

import com.game.Actors.AI.Products.AIActor;

public interface CreatorAIActor {
    AIActor factoryMethod();
    AIActor factoryMethod(String texturePath);
}
