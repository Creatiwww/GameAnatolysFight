package com.game.Actors.Playable.Creators;

import com.game.Actors.Playable.Products.PlayableActor2;
import com.game.Actors.Playable.Products.ProductPlayableActor;

public class CreatorPlayableActor2 implements CreatorPlayableActor{
    private static final String TAG = CreatorPlayableActor2.class.getName();

    @Override
    public ProductPlayableActor factoryMethod() { return new PlayableActor2(); }
}
