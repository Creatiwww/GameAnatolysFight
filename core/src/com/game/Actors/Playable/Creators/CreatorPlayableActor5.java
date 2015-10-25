package com.game.Actors.Playable.Creators;

import com.game.Actors.Playable.Products.PlayableActor;
import com.game.Actors.Playable.Products.PlayableActor5;

public class CreatorPlayableActor5 implements CreatorPlayableActor{
    private static final String TAG = CreatorPlayableActor5.class.getName();

    @Override
    public PlayableActor factoryMethod() { return new PlayableActor5(); }
}