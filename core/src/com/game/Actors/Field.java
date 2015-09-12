package com.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Field extends Actor {

    private Texture field;
    private Coordinates coordinates;
    private Cell[] cell;

    public Field(){
        field=new Texture(Gdx.files.internal("Field.png"));
        coordinates=new Coordinates();
    }

    public Cell getCellByIndex(int m) {
        return cell[m];
    }
    public float getCellWidth(){
        return coordinates.cellWidth;
    }
    public int getFeildSizeX(){
        return coordinates.FIELD_SIZE_X;
    }
    public int getFeildSizeY(){
        return coordinates.FIELD_SIZE_Y;
    }
    public Coordinates getCoordinates(){
        return coordinates;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(field, getX(), getY(), getWidth(), getHeight());
    }

    public class Cell{
        private float bLX,bRX,tLX,tRX,bLY,bRY,tLY,tRY;
        private float cX,cY; //center coordinates X Y
        private int indexX, indexY; //cell index from 1 to FIELD_SIZE_X
        private MyActor actorRef;

        Cell(float x1, float x2, float y1, float y2){
            bLX=x1; bRX=x2; tLX=x1; tRX=x2;
            bLY=y1; bRY=y1; tLY=y2; tRY=y2;
            cX=(x2+x1)/2; cY=(y2+y1)/2;
        }

        public float getbLX() {
            return bLX;
        }
        public float getbRX() {
            return bRX;
        }
        public float getbLY() {
            return bLY;
        }
        public float getbRY() {
            return bRY;
        }
        public float gettLX() {
            return tLX;
        }
        public float gettLY() {
            return tLY;
        }
        public float gettRX() {
            return tRX;
        }
        public float gettRY() {
            return tRY;
        }
        public float getcX() {
            return cX;
        }
        public float getcY() {
            return cY;
        }
        public int getIndexX(){
            return this.indexX;
        }
        public int getIndexY(){
            return this.indexY;
        }
        public MyActor getActorRef() {return this.actorRef;}

        public void setIndexX(int indexX){
            this.indexX =indexX;
        }
        public void setIndexY(int indexY){
            this.indexY =indexY;
        }
        public void setActorRef(MyActor actor){
            this.actorRef=actor;
        }

        public boolean isEpmty(){
            if (this.actorRef!=null) return false;
            return true;
        }
    }

    public class Coordinates{

        private final int FIELD_SIZE_X=5;
        private final int FIELD_SIZE_Y=7;
        private float cellWidth;
        private int fieldSize;

        Coordinates(){
            fieldSize=FIELD_SIZE_X*FIELD_SIZE_Y;
            cell=new Cell[fieldSize];

            float x1, x2, y1, y2;
            int indexX,indexY;
            float paddingsXWidth=(Gdx.graphics.getWidth()/16);
            cellWidth=(Gdx.graphics.getWidth()-2*paddingsXWidth)/FIELD_SIZE_X;
            int arrayIndexCounter=0;

            for (int i=0;i< FIELD_SIZE_X; i++){
                indexX=i+1;
                indexY=0;
                for (int j=0;j< FIELD_SIZE_Y; j++) {
                    x1 = paddingsXWidth + cellWidth * i;
                    y1 = ((Gdx.graphics.getHeight() / 2) - (FIELD_SIZE_Y / 2) * cellWidth) + cellWidth * j;
                    x2 = paddingsXWidth + cellWidth * (i + 1);
                    y2 = ((Gdx.graphics.getHeight() / 2) - (FIELD_SIZE_Y / 2) * cellWidth) + cellWidth * (j + 1);

                    cell[arrayIndexCounter] = new Cell(x1, x2, y1, y2);
                    indexY=j+1;
                    cell[arrayIndexCounter].setIndexX(indexX);
                    cell[arrayIndexCounter].setIndexY(indexY);
                    arrayIndexCounter++;
                }
            }
        }

        public int getFieldWidth(){
            return (int)cellWidth*FIELD_SIZE_X;
        }
        public int getFieldHeight(){
            return (int)cellWidth*FIELD_SIZE_Y;
        }
        public int getFieldSize(){
            return fieldSize;
        } // returns quantity of cells in cell array
        public float getRightFieldEdge(){
            return getCellByIndex(FIELD_SIZE_X*FIELD_SIZE_Y-1).tRX;
        }
        public float getLeftFieldEdge(){
            return getCellByIndex(0).bLX;
        }
        public float getTopFieldEdge(){
            return getCellByIndex(FIELD_SIZE_X*FIELD_SIZE_Y-1).tRY;
        }
        public float getBottomFieldEdge(){
            return getCellByIndex(0).bLY;
        }

        public int getCellIndexByXYIndexes(int IndexX, int IndexY){
            int i;
            for (i=0; i<fieldSize; i++ ){
                if (getCellByIndex(i).getIndexX()==IndexX && getCellByIndex(i).getIndexY()==IndexY) break;
            }
            return i;
        }

    }
}
