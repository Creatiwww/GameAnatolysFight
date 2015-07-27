package com.game.Actors.Playable.Creators;

import com.game.Actors.Playable.Products.PlayableActor1;
import com.game.Actors.Playable.Products.ProductPlayableActor;

public class CreatorPlayableActor1 implements CreatorPlayableActor{
    private static final String TAG = CreatorPlayableActor1.class.getName();

    @Override
    public ProductPlayableActor factoryMethod() { return new PlayableActor1(); }
}
