package com.game.AI;

import com.game.Actors.AI.Products.AIActor;
import com.game.Actors.Field;
import com.game.Actors.MyActor;
import com.game.Controllers.AIController;

import java.util.ArrayList;
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
        int cellIndex=field.getCoordinates().getCellIndexByXYIndexes(cellIndexX,cellIndexY);
        return field.getCellByIndex(cellIndex).isEpmty();
    }

    private class ArrayPath {
        protected int stepsQuantity;
        protected MyActor aiUnitRef;
        protected MyActor playableUnitRef;
    }
}

