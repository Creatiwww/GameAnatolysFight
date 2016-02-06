package com.game.Actors.Playable.Creators;

import com.game.Actors.Playable.Products.PlayableActor;
import com.game.Actors.Playable.Products.PlayableActorYoungMan;

public class CreatorPlayableActor2 implements CreatorPlayableActor{

    @Override
    public PlayableActor factoryMethod() { return new PlayableActorYoungMan(); }

    @Override
    public PlayableActor factoryMethod(String texturePath) {
        return new PlayableActorYoungMan (texturePath);
    }
}