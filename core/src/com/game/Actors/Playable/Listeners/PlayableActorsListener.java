package com.game.Actors.Playable.Listeners;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.game.Actors.Playable.Products.MyActor;
import com.game.Actors.Field;

public class PlayableActorsListener extends DragListener {

    private MyActor draggedActor;
    private float rightFieldEdge,leftFieldEdge,topFieldEdge,bottomFieldEdge;
    private Field field;
    private float originalActorsWidth, originalActorsHeight,actorsNewWidth,actorsNewHeight, actorsSizeIncrease;

    public PlayableActorsListener(MyActor draggedActor, Field field){
        this.draggedActor=draggedActor;
        this.field=field;
        rightFieldEdge=field.getCoordinates().getRightFieldEdge();
        leftFieldEdge=field.getCoordinates().getLeftFieldEdge();
        topFieldEdge=field.getCoordinates().getTopFieldEdge();
        bottomFieldEdge=field.getCoordinates().getBottomFieldEdge();
        originalActorsWidth=draggedActor.getWidth();
        originalActorsHeight=draggedActor.getHeight();
        actorsSizeIncrease=(float)0.3;
        actorsNewWidth = originalActorsWidth*(1+actorsSizeIncrease); // actor's size after increase
        actorsNewHeight = originalActorsHeight*(1+actorsSizeIncrease);
    }

    @Override
    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        super.touchDown(event,x,y,pointer,button);
        draggedActor.setSize(actorsNewWidth, actorsNewHeight);
        x= fitActorToTouchCenterX(x);
        y= fitActorToTouchCenterY(y);
        draggedActor.moveBy(x, y);
        return true;
    }

    @Override
    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
        super.touchUp(event, x, y, pointer, button);
        draggedActor.setSize(originalActorsWidth, originalActorsHeight);
        x=fieldEdgeCheckX(x, event.getListenerActor().getX(), event.getListenerActor().getWidth());
        y=fieldEdgeCheckY(y, event.getListenerActor().getY(), event.getListenerActor().getHeight());
        x= fitActorToCellCenterX(x);
        y= fitActorToCellCenterY(y);
        draggedActor.moveBy(x, y);
    }

    @Override
    public void dragStart (InputEvent event, float x, float y, int pointer) {
    }

    @Override
    public void dragStop (InputEvent event, float x, float y, int pointer) {
    }

    // x, y - coordinates delta
    @Override
    public void drag (InputEvent event, float x, float y, int pointer) {
        x=fieldEdgeCheckX(x, event.getListenerActor().getX(), event.getListenerActor().getWidth());
        y=fieldEdgeCheckY(y, event.getListenerActor().getY(), event.getListenerActor().getHeight());
        x= fitActorToTouchCenterX(x);
        y= fitActorToTouchCenterX(y);
        draggedActor.moveBy(x, y);
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

    private float fitActorToTouchCenterX(float x){
        x=x - draggedActor.getWidth() / 2;
        return x;
    }

    private float fitActorToTouchCenterY(float y){
        y=y - draggedActor.getWidth() / 2;
        return y;
    }

    private float fitActorToCellCenterX(float x){
        x= fitActorToTouchCenterX(x);
        return x; //TODO: implement aliment on field center
    }

    private float fitActorToCellCenterY(float y){
        y= fitActorToTouchCenterY(y);
        return y; //TODO: implement aliment on field center
    }
}
