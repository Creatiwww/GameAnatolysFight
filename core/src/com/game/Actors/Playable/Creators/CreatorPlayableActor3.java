package com.game.Actors.Playable.Creators;

import com.game.Actors.Playable.Products.MyActor;
import com.game.Actors.Playable.Products.PlayableActor2;
import com.game.Actors.Playable.Products.PlayableActor3;

public class CreatorPlayableActor3 implements CreatorPlayableActor{
    private static final String TAG = CreatorPlayableActor3.class.getName();

    @Override
    public MyActor factoryMethod() { return new PlayableActor3(); }
}