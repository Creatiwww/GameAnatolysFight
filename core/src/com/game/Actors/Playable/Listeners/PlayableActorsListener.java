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
    private int fieldSize;

    public PlayableActorsListener(MyActor draggedActor, Field field){
        this.draggedActor=draggedActor;
        this.field=field;
        rightFieldEdge=field.getCoordinates().getRightFieldEdge();
        leftFieldEdge=field.getCoordinates().getLeftFieldEdge();
        topFieldEdge=field.getCoordinates().getTopFieldEdge();
        bottomFieldEdge=field.getCoordinates().getBottomFieldEdge();
        fieldSize=field.getCoordinates().getFieldSize();
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
        //x=fieldEdgeCheckX(x, event.getListenerActor().getX(), event.getListenerActor().getWidth());
        //y=fieldEdgeCheckY(y, event.getListenerActor().getY(), event.getListenerActor().getHeight());
        float actorPossitionX=event.getListenerActor().getX();
        float actorPossitionY=event.getListenerActor().getY();
        float actorCenterPossitionX=actorPossitionX+event.getListenerActor().getWidth()/2;
        float actorCenterPossitionY=actorPossitionY+event.getListenerActor().getWidth()/2;
        int IndexX=findXCellIndex(actorCenterPossitionX);
        int IndexY=findYCellIndex(actorCenterPossitionY);
        int cellIndex=getCellIndexByXYIndexes(IndexX,IndexY);
        x= fitActorToCellCenterX(cellIndex);
        y= fitActorToCellCenterY(cellIndex);
        draggedActor.setPosition(x, y);
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
        y= fitActorToTouchCenterY(y);
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

    private float fitActorToCellCenterX(int cellIndex){
        float x=field.getCellByIndex(cellIndex).getcX();
        x=fitActorToTouchCenterX(x);
        return x;
    }

    private float fitActorToCellCenterY(int cellIndex){
        float y=field.getCellByIndex(cellIndex).getcY();
        y=fitActorToTouchCenterY(y);
        return y;
    }

    private int getCellIndexByXYIndexes(int IndexX, int IndexY){
        int i;
        for (i=0; i<fieldSize; i++ ){
           if (field.getCellByIndex(i).getIndexX()==IndexX && field.getCellByIndex(i).getIndexY()==IndexY) break;
        }
        return i;
    }

    private int findXCellIndex(float actorPossitionX){
        int i;
        for (i=1;i<=field.getFeildSizeX() ;i++ ){
            float cell0blX=field.getCellByIndex(0).getbLX();
            float lenth = field.getCellWidth()*(i-1);
            if (actorPossitionX>cell0blX+lenth) ;
            else break;
        }
        return i-1;
    }

    private int findYCellIndex(float actorPossitionY){
        int j;
        for (j=1;j<=field.getFeildSizeY() ;j++ ){
            float cell0blY=field.getCellByIndex(0).getbLY();
            float lenth = field.getCellWidth()*(j-1);
            if (actorPossitionY > cell0blY+lenth);
            else break;
        }
        return j-1;
    }

}
