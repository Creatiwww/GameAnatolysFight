package com.game.ScreensAndStages.Stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Field extends Actor {

    protected Texture field;
    private Coordinates coordinates;
    private Cell[] cell;

    public Field(){
        field=new Texture(Gdx.files.internal("Field.png"));
        coordinates=new Coordinates();
    }

    public Cell[] getCell() {
        return cell;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        //Gdx.app.log("MyTag", "'draw' method started @" + TAG);
        batch.draw(field, getX(), getY(), getWidth(), getHeight());
        //Gdx.app.log("MyTag", "'draw' method ended @" + TAG);
    }

    class Cell{
        private float bLX,bRX,tLX,tRX,bLY,bRY,tLY,tRY;
        private float cX,cY; //center coordinates X Y

        Cell(float x1, float x2, float y1, float y2){
            bLX=x1; bRX=x2; tLX=x1; tRX=x2;
            bLY=y1; bRY=y1; tLY=y2; tRY=y2;
            cX=(x2+x1)/2; cY=(y2+y1)/2;
        }

    }

    class Coordinates{

        private final int FIELD_SIZE_X=5;
        private final int FIELD_SIZE_Y=7;

        Coordinates(){
            int fieldSize=FIELD_SIZE_X*FIELD_SIZE_Y;
            cell=new Cell[fieldSize];

            float x1, x2, y1, y2;
            float paddingsXWidth=(Gdx.graphics.getWidth()/16);
            float cellWidth=(Gdx.graphics.getWidth()-2*paddingsXWidth)/FIELD_SIZE_X;
            int arrayIndexCounter=0;

            for (int i=0;i< FIELD_SIZE_X; i++){
                for (int j=0;j< FIELD_SIZE_Y; j++) {
                    x1 = paddingsXWidth + cellWidth * i;
                    y1 = ((Gdx.graphics.getHeight() / 2) - (FIELD_SIZE_Y / 2) * cellWidth) + cellWidth * j;
                    x2 = paddingsXWidth + cellWidth * (i + 1);
                    y2 = ((Gdx.graphics.getHeight() / 2) - (FIELD_SIZE_Y / 2) * cellWidth) + cellWidth * (j + 1);

                    cell[arrayIndexCounter] = new Cell(x1, x2, y1, y2);
                    arrayIndexCounter++;
                }
            }
        }
    }
}
