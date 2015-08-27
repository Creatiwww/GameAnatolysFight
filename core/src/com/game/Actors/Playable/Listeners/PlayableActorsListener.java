package com.game.Actors.Playable.Listeners;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.game.Actors.Playable.Products.MyActor;

public class PlayableActorsListener extends DragListener {

    private MyActor draggedActor;

    public PlayableActorsListener(MyActor draggedActor){
        this.draggedActor=draggedActor;
    }

    @Override
    public void drag(InputEvent event, float x, float y, int pointer) {
        draggedActor.moveBy(x - draggedActor.getWidth() / 2, y - draggedActor.getHeight() / 2);
    }
}
