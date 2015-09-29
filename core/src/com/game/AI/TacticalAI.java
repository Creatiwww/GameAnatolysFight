package com.game.AI;

import com.game.Actors.AI.Products.AIActor;
import com.game.Actors.Field;
import com.game.Actors.MyActor;
import com.game.Controllers.AIController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class TacticalAI {
    private AIController aiController;
    private Field field;
    private Random random;
    private int[] blockedUnites; //units with no ability to move
    private int chosenUnitIndex;
    private AIActor actor;
    private int counter2; //counter of ai units with no ability to move
    private ArrayList <ArrayPath> arrayPath;

    public TacticalAI(AIController aiController){
        this.aiController=aiController;
        this.field=aiController.getWorldController().getActorsController().getField();
        random=new Random();
    }

    public void implementStrategy(){
        if (aiController.getStrategicAI().isObserveStrategy()) observeStrategyImplementation();
        if (aiController.getStrategicAI().isAttackStrategy()) attackStrategyImplementation();
        if (aiController.getStrategicAI().isDefendStrategy()) defendStrategyImplementation();
    }

    private void observeStrategyImplementation(){
        blockedUnites = new int[aiController.getAiUnits().size()];
        boolean flag=false;
        int fieldSizeX=field.getFeildSizeX();
        int fieldSizeY=field.getFeildSizeY();
        int counter;
        counter2=0;
        while (!flag) {
            actor = choseRandomUnit();
            int oldPositionX = actor.getPosition().cellIndexX;
            int oldPositionY = actor.getPosition().cellIndexY;
            int oldCellIndex = field.getCoordinates().getCellIndexByXYIndexes(oldPositionX, oldPositionY);
            counter=0;
            int randomDirection = random.nextInt(4);
            while (!flag && counter != 4) { // while acceptable movement not found || not all variants assessed


                if (counter==4)break;
                if (randomDirection == 0) {
                    if(actor.getPosition().cellIndexX + 1 > fieldSizeX){
                        counter++;
                        randomDirection++;
                    }else {
                        if (!isCellEmpty(actor.getPosition().cellIndexX + 1, actor.getPosition().cellIndexY)) {
                            counter++;
                            randomDirection++;
                        } else {
                            actor.moveR();
                            flag = true;
                            field.getCellByIndex(oldCellIndex).setActorRef(null);
                        }
                    }
                }
                if (counter==4)break;
                if (randomDirection == 1 ) {
                    if(actor.getPosition().cellIndexX - 1 <= 0){
                        counter++;
                        randomDirection++;
                    }else {
                        if (!isCellEmpty(actor.getPosition().cellIndexX - 1, actor.getPosition().cellIndexY)) {
                            counter++;
                            randomDirection++;
                        } else {
                            actor.moveL();
                            flag = true;
                            field.getCellByIndex(oldCellIndex).setActorRef(null);
                        }
                    }
                }
                if (counter==4)break;
                if (randomDirection == 2 ) {
                    if(actor.getPosition().cellIndexY + 1 > fieldSizeY){
                        counter++;
                        randomDirection++;
                    }else {
                        if (!isCellEmpty(actor.getPosition().cellIndexX, actor.getPosition().cellIndexY + 1)) {
                            counter++;
                            randomDirection++;
                        } else {
                            actor.moveT();
                            flag = true;
                            field.getCellByIndex(oldCellIndex).setActorRef(null);
                        }
                    }
                }
                if (counter==4)break;
                if (randomDirection == 3) {
                    if (actor.getPosition().cellIndexY - 1 <= 0){
                        counter++;
                        randomDirection = 0;
                    }else {
                        if (!isCellEmpty(actor.getPosition().cellIndexX, actor.getPosition().cellIndexY - 1)) {
                            counter++;
                            randomDirection = 0;
                        } else {
                            actor.moveD();
                            flag = true;
                            field.getCellByIndex(oldCellIndex).setActorRef(null);
                        }
                    }
                }

            }
            if (counter == 4) {

                blockedUnites[counter2] = chosenUnitIndex;
                counter2++;
               // if(counter2==aiController.getAiUnits().size()) this.aiController.endAITurn();
            }
        }
        int newCellIndex=field.getCoordinates().getCellIndexByXYIndexes(actor.getPosition().cellIndexX,actor.getPosition().cellIndexY);
        field.getCellByIndex(newCellIndex).setActorRef(actor);
        aiController.endAITurn();
    }

    private void defendStrategyImplementation(){

    }

    private void attackStrategyImplementation(){
        // initiating an array of path between AI units and Playable units
        if (arrayPath==null) arrayPath=new ArrayList<ArrayPath>();
        waveTrace();
        ArrayPath bestPath = chosePath(); // which AI should attack which player
        defineCommand(bestPath);
    }

    private AIActor choseRandomUnit(){
        boolean flag=false;
        while (!flag) {
            chosenUnitIndex = random.nextInt(aiController.getAiUnits().size());
            if (counter2==0){
                flag=true;
            }
            for (int i = 0; i < counter2; i++) {
                if (chosenUnitIndex == blockedUnites[i]) {
                    break;
                }
                if (i == counter2--) {
                    flag = true;
                }
            }
        }
        return (AIActor) aiController.getAiUnits().get(chosenUnitIndex);
    }

    private boolean isCellEmpty(int cellIndexX, int cellIndexY){
        int cellIndex=field.getCoordinates().getCellIndexByXYIndexes(cellIndexX, cellIndexY);
        return field.getCellByIndex(cellIndex).isEpmty();
    }

    private void waveTrace(){
        //calculate array of path
        ArrayList <MyActor> aiUnits=aiController.getAiUnits();
        ArrayList <MyActor> pUnits=aiController.getWorldController().getActorsController().getPActors();
        for (int i=0;i<aiUnits.size();i++){
            for (int j=0; j<pUnits.size();j++){
                int stepsQuantity=stepsQuantity(aiUnits.get(i), pUnits.get(j));
                arrayPath.add(new ArrayPath (stepsQuantity, aiUnits.get(i), pUnits.get(j)));
            }
        }

    }
    private int stepsQuantity(MyActor aiUnit, MyActor pUnit){
        int sizeX=field.getFeildSizeX();
        int sizeY=field.getFeildSizeY();
        int array[][]=new int[sizeX][sizeY];
        createWaves(aiUnit, pUnit, array, sizeX, sizeY);
        return calcStepsQuantity(pUnit, array);
    }

    private void createWaves(MyActor aiUnit,MyActor pUnit,int[][]array, int sizeX, int sizeY){
        Arrays.fill(array,-1);
        int x=aiUnit.getPosition().cellIndexX;
        int y=aiUnit.getPosition().cellIndexY;
        int px=pUnit.getPosition().cellIndexX;
        int py=pUnit.getPosition().cellIndexY;
        array[x-1][y-1]=0; //put 0 in to array where aiUnit located
        int waveNo=1;
        boolean isPUnitFound=false;
        while (!isPUnitFound) {
            for (int h=0; h<sizeX; h++){
                for (int j=0; j<sizeY; j++){
                    if (array[h][j]==waveNo-1) {
                        if (h+1==px && j+1==py) {
                            isPUnitFound = true;   // if player unit founded
                            nextMovementCellIndex(waveNo, array, sizeX, sizeY, px, py, pUnit);
                            return;
                        }
                        calcWaveIteration(h, j, waveNo, array, pUnit);
                    }

                }
            }
            waveNo++;
        }

    }

    private int nextMovementCellIndex(int waveNo, int[][] array, int sizeX, int sizeY, int px, int py, MyActor pUnit){
        waveNo--;

        int h=px;
        int j=py;
        boolean prov;
        int x, y; // cells where we are looking for waveNo--
        while (waveNo!=1){
            prov=false;
            waveNo--;
            if (!prov) {
                x = h + 1;
                y = j;
                if (isCellAvailableForMovement(x, y, pUnit)) {
                    if (array[x - 1][y - 1] == waveNo) {
                        prov = true;
                        h = x;
                        j = y;
                    }
                }
            }
            if (!prov) {
                x = h - 1;
                y = j;
                if (isCellAvailableForMovement(x, y, pUnit)) {
                    if (array[x - 1][y - 1] == waveNo) {
                        prov = true;
                        h = x;
                        j = y;
                    }
                }
            }
            if (!prov) {
                x = h;
                y = j + 1;
                if (isCellAvailableForMovement(x, y, pUnit)) {
                    if (array[x - 1][y - 1] == waveNo) {
                        prov = true;
                        h = x;
                        j = y;
                    }
                }
            }
            if(!prov) {
                x = h;
                y = j - 1;
                if (isCellAvailableForMovement(x, y, pUnit)) {
                    if (array[x - 1][y - 1] == waveNo) {
                        prov = true;
                        h = x;
                        j = y;
                    }
                }
            }
        }
        return field.getCoordinates().getCellIndexByXYIndexes(h,j);
    }



    private int calcStepsQuantity(MyActor pUnit, int[][] array){
        int x = pUnit.getPosition().cellIndexX;
        int y = pUnit.getPosition().cellIndexY;
        return array[x-1][y-1];
    }

    private void calcWaveIteration(int h, int j, int waveNo, int[][] array, MyActor pUnit){
        int x, y; // cells where we potentially might move aiUnit
        h++; // we have array[h][j] started from 0 and cell indexes @field class started from 1
        j++;
        x=h+1; y=j;
        if (isCellAvailableForMovement(x,y,pUnit)) array [x-1][y-1]=waveNo;
        x=h-1; y=j;
        if (isCellAvailableForMovement(x,y,pUnit)) array [x-1][y-1]=waveNo;
        x=h; y=j+1;
        if (isCellAvailableForMovement(x,y,pUnit)) array [x-1][y-1]=waveNo;
        x=h; y=j-1;
        if (isCellAvailableForMovement(x,y,pUnit)) array [x-1][y-1]=waveNo;
    }

    private boolean isCellAvailableForMovement(int x,int y, MyActor pUnit){
        int cellIndex=field.getCoordinates().getCellIndexByXYIndexes(x,y);
        int px=pUnit.getPosition().cellIndexX;
        int py=pUnit.getPosition().cellIndexY;
        boolean isUnitWeAreLookingFor=false;
        if (px==x && py ==y) isUnitWeAreLookingFor=true;
        boolean isEmpty= field.getCellByIndex(cellIndex).isEpmty() || isUnitWeAreLookingFor;
        int sizeX=field.getFeildSizeX();
        int sizeY=field.getFeildSizeY();
        // if not outside of the edge X and Y and if is empty => return true
        return (x<=sizeX && y<=sizeY && x>0 && y>0 && isEmpty);
    }

    private ArrayPath chosePath(){
        final double K_HP=0.1;
        final double K_STEPS=0.9;
        double targetEstimation= arrayPath.get(0).playableUnitHP*K_HP+arrayPath.get(0).stepsQuantity*K_STEPS;
        ArrayPath bestPath = arrayPath.get(0);
        for (int i=0; i<arrayPath.size(); i++){
            if (targetEstimation>arrayPath.get(i).playableUnitHP*K_HP+arrayPath.get(i).stepsQuantity*K_STEPS){
                targetEstimation=arrayPath.get(i).playableUnitHP*K_HP+arrayPath.get(i).stepsQuantity*K_STEPS;
                bestPath = arrayPath.get(i);
            }
        }
        return bestPath;
    }

    private void defineCommand(ArrayPath path){

        //TODO: implement
    }

    public class ArrayPath {
        protected int stepsQuantity;
        protected MyActor aiUnitRef;
        protected MyActor playableUnitRef;
        protected int playableUnitHP;
        protected int nextMoveCellIndex;

        ArrayPath(int stepsQuantity, MyActor aiUnitRef, MyActor playableUnitRef){
            this.stepsQuantity=stepsQuantity;
            this.aiUnitRef=aiUnitRef;
            this.playableUnitRef=playableUnitRef;
            this.playableUnitHP=this.playableUnitRef.getHP();
        }

        public void setNextMoveCellIndex(int cellIndex){
            this.nextMoveCellIndex=cellIndex;
        }
    }
}

