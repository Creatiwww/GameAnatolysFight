package com.game.Actors.Playable.Creators;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.game.Actors.Playable.Products.PlayableActor2;

public class CreatorPlayableActor2 implements CreatorPlayableActor{
    private static final String TAG = CreatorPlayableActor2.class.getName();

    @Override
    public Actor factoryMethod() { return new PlayableActor2(); }
}
