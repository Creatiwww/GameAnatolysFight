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
    private int actorCellIndexBeforeMovementX,actorCellIndexBeforeMovementY;

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
        super.touchDown(event, x, y, pointer, button);
        draggedActor.toFront();

        float actorPossitionX=event.getListenerActor().getX();
        float actorPossitionY=event.getListenerActor().getY();
        float actorCenterPossitionX=actorPossitionX+event.getListenerActor().getWidth()/2;
        float actorCenterPossitionY=actorPossitionY+event.getListenerActor().getWidth()/2;
        int IndexX=findXCellIndex(actorCenterPossitionX);
        int IndexY=findYCellIndex(actorCenterPossitionY);
        actorCellIndexBeforeMovementX=IndexX;
        actorCellIndexBeforeMovementY=IndexY;
        draggedActor.getPosition().CellIndexX=IndexX;
        draggedActor.getPosition().CellIndexY=IndexY;

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
        float actorPossitionX=event.getListenerActor().getX();
        float actorPossitionY=event.getListenerActor().getY();
        float actorCenterPossitionX=actorPossitionX+event.getListenerActor().getWidth()/2;
        float actorCenterPossitionY=actorPossitionY+event.getListenerActor().getWidth()/2;
        int IndexX=findXCellIndex(actorCenterPossitionX);
        int IndexY=findYCellIndex(actorCenterPossitionY);
        int cellIndex=field.getCoordinates().getCellIndexByXYIndexes(IndexX,IndexY);
        if (!movementFacilitiesCheck(IndexX,IndexY)){
            cellIndex=field.getCoordinates().getCellIndexByXYIndexes(actorCellIndexBeforeMovementX,actorCellIndexBeforeMovementY);
        }
        x = fitActorToCellCenterX(cellIndex);
        y = fitActorToCellCenterY(cellIndex);
        draggedActor.getPosition().CellIndexX=IndexX;
        draggedActor.getPosition().CellIndexY=IndexY;
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
        y =fitActorToTouchCenterY(y);
        return y;
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
        for (j = 1;j<=field.getFeildSizeY() ;j++ ){
            float cell0blY=field.getCellByIndex(0).getbLY();
            float lenth = field.getCellWidth()*(j-1);
            if (actorPossitionY > cell0blY+lenth);
            else break;
        }
        return j-1;
    }

    private boolean movementFacilitiesCheck(int IndexX,int IndexY){
        int oldPositionX=draggedActor.getPosition().CellIndexX;
        int oldPositionY=draggedActor.getPosition().CellIndexY;
        int newPositionX=IndexX;
        int newPositionY=IndexY;
        int R=draggedActor.getMovingFacilities().R;
        int T=draggedActor.getMovingFacilities().T;
        int B=draggedActor.getMovingFacilities().B;
        int L=draggedActor.getMovingFacilities().L;
        int TR=draggedActor.getMovingFacilities().TR;
        int TL=draggedActor.getMovingFacilities().TL;
        int BR=draggedActor.getMovingFacilities().BR;
        int BL=draggedActor.getMovingFacilities().BL;


        boolean X=false;
        boolean Y=false;
        boolean XY=false;
        boolean YX=false;
        boolean flag=false;
        if(((IndexX-oldPositionX>0)&&(IndexX-oldPositionX<=R))||((oldPositionX-IndexX>0)&&(oldPositionX-IndexX<=L)))X=true;
        if(((IndexY-oldPositionY>0)&&(IndexY-oldPositionY<=T))||((oldPositionY-IndexY>0)&&(oldPositionY-IndexY<=B)))Y=true;
        if ((((oldPositionX-IndexX>0)&&(oldPositionX-IndexX<=BL))&&((oldPositionY-IndexY>0)&&(oldPositionY-IndexY<=BL)))||(((IndexX-oldPositionX>0)&&(IndexX-oldPositionX<=TR))&&((IndexY-oldPositionY>0)&&(IndexY-oldPositionY<=TR))))XY=true;
        if ((((oldPositionX-IndexX>0)&&(oldPositionX-IndexX<=TL))&&((IndexY-oldPositionY>0)&&(IndexY-oldPositionY<=TL)))||(((IndexX-oldPositionX>0)&&(IndexX-oldPositionX<=BR))&&((oldPositionY-IndexY>0)&&(oldPositionY-IndexY<=BR))))YX=true;
        if(((X==true)&&(IndexY-oldPositionY==0))||((Y==true)&&(IndexX-oldPositionX==0))||((XY==true)&&(Math.abs(newPositionX-oldPositionX)==Math.abs(newPositionY-oldPositionY)))||((YX==true)&&(Math.abs(newPositionX-oldPositionX)==Math.abs(newPositionY-oldPositionY))))flag=true;

        // todo: implement if check

        return flag;
    }
    private void availableCellsShowing (float x, float y){
        int oldPositionX=draggedActor.getPosition().CellIndexX;
        int oldPositionY=draggedActor.getPosition().CellIndexY;
        int R=draggedActor.getMovingFacilities().R;
        int T=draggedActor.getMovingFacilities().T;
        int B=draggedActor.getMovingFacilities().B;
        int L=draggedActor.getMovingFacilities().L;
        int TR=draggedActor.getMovingFacilities().TR;
        int TL=draggedActor.getMovingFacilities().TL;
        int BR=draggedActor.getMovingFacilities().BR;
        int BL=draggedActor.getMovingFacilities().BL;
        if ((R!=0)&&(x<field.getCoordinates().getFieldWidth())){

        }
        if ((T!=0)&&(y<field.getCoordinates().getFieldHeight())){

        }
        if ((B!=0)&&(y>0)){

        }
        if ((L!=0)&&(x>0)){

        }
        if ((TR!=0)&&(x<field.getCoordinates().getFieldWidth())&&(y<field.getCoordinates().getFieldHeight())){

        }
        if ((TL!=0)&&(y<field.getCoordinates().getFieldHeight())&&(x>0)){

        }
        if ((BR!=0)&&(y>0)&&(x<field.getCoordinates().getFieldWidth())){

        }
        if ((BL!=0)&&(x>0)&&((y>0))){

        }

    }

}
