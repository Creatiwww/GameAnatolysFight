package com.game.Actors.Playable.Creators;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.game.Actors.Playable.Products.PlayableActor1;

public class CreatorPlayableActor1 implements CreatorPlayableActor{
    private static final String TAG = CreatorPlayableActor1.class.getName();

    @Override
    public Actor factoryMethod() { return new PlayableActor1(); }
}
