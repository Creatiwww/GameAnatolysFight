package com.game.Actors.Playable.Listeners;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.game.Actors.Playable.Products.MyActor;
import com.game.Actors.Field;

public class PlayableActorsListener extends DragListener {

    private MyActor draggedActor;
    private float rightFieldEdge,leftFieldEdge,topFieldEdge,bottomFieldEdge;
    private Field field;

    public PlayableActorsListener(MyActor draggedActor, Field field){
        this.draggedActor=draggedActor;
        this.field=field;
        rightFieldEdge=field.getCoordinates().getRightFieldEdge();
        leftFieldEdge=field.getCoordinates().getLeftFieldEdge();
        topFieldEdge=field.getCoordinates().getTopFieldEdge();
        bottomFieldEdge=field.getCoordinates().getBottomFieldEdge();
    }

    // x, y - coordinates delta
    @Override
    public void drag(InputEvent event, float x, float y, int pointer) {
        x=fieldEdgeCheckX(x, event.getListenerActor().getX(), event.getListenerActor().getWidth());
        y=fieldEdgeCheckY(y, event.getListenerActor().getY(), event.getListenerActor().getHeight());
        draggedActor.moveBy(x - draggedActor.getWidth() / 2, y - draggedActor.getHeight() / 2);
    }
    // t - actor's coordinates before drag operation
    private float fieldEdgeCheckX(float x, float t, float width){
        if ((x+t)>rightFieldEdge-width/2) x=rightFieldEdge-t-width/2;
        if ((x+t)<leftFieldEdge+width/2) x=leftFieldEdge-t+width/2;
        return x;
    }

    private float fieldEdgeCheckY(float y, float t, float height){
        if ((y+t)>topFieldEdge-height/2) y=topFieldEdge-t-height/2;
        if ((y+t)<bottomFieldEdge+height/2) y=bottomFieldEdge-t+height/2;
        return y;
    }
}
