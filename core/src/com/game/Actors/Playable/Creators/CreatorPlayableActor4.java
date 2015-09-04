package com.game.Actors.Playable.Creators;

import com.game.Actors.Playable.Products.MyActor;
import com.game.Actors.Playable.Products.PlayableActor3;
import com.game.Actors.Playable.Products.PlayableActor4;

public class CreatorPlayableActor4 implements CreatorPlayableActor{
    private static final String TAG = CreatorPlayableActor4.class.getName();

    @Override
    public MyActor factoryMethod() { return new PlayableActor4(); }
}