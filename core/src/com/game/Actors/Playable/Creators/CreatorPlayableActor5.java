package com.game.Actors.Playable.Creators;

import com.game.Actors.Playable.Products.PlayableActor;
import com.game.Actors.Playable.Products.PlayableActorNewborn;

public class CreatorPlayableActor5 implements CreatorPlayableActor{
    private static final String TAG = CreatorPlayableActor5.class.getName();

    @Override
    public PlayableActor factoryMethod() { return new PlayableActorNewborn(); }

    @Override
    public PlayableActor factoryMethod(String texturePath) {
        return new PlayableActorNewborn (texturePath);
    }
}