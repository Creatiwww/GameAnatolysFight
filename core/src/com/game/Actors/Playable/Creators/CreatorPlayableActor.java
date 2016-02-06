package com.game.Actors.Playable.Creators;

import com.game.Actors.Playable.Products.PlayableActor;

public interface CreatorPlayableActor {
    PlayableActor factoryMethod();
    PlayableActor factoryMethod(String texturePath);
}