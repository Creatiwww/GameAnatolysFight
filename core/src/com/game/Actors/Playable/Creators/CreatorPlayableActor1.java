package com.game.Actors.Playable.Creators;

import com.game.Actors.Playable.Products.PlayableActor1;
import com.game.Actors.Playable.Products.ProductPlayableActor;

public class CreatorPlayableActor1 implements CreatorPlayableActor{

    @Override
    public ProductPlayableActor factoryMethod() { return new PlayableActor1(); }
}
