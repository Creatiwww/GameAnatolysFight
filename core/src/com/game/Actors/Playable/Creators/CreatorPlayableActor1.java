package com.game.Actors.Playable.Creators;

import com.game.Actors.Playable.Products.MyActor;
import com.game.Actors.Playable.Products.PlayableActor1;

public class CreatorPlayableActor1 implements CreatorPlayableActor{
    private static final String TAG = CreatorPlayableActor1.class.getName();

    @Override
    public MyActor factoryMethod() { return new PlayableActor1(); }
}