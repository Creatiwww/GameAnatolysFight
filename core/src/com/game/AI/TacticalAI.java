package com.game.AI;

import com.game.Actors.AI.Products.AIActor;
import com.game.Controllers.AIController;
import java.util.Random;

public class TacticalAI {
    private AIController aiController;
    Random random;

    public TacticalAI(AIController aiController){
        this.aiController=aiController;
        random=new Random();
    }

    public void implementStrategy(){
        if (aiController.getStrategicAI().isObserveStrategy()) observeStrategyImplementation();
        if (aiController.getStrategicAI().isAttackStrategy()) attackStrategyImplementation();
        if (aiController.getStrategicAI().isDefendStrategy()) defendStrategyImplementation();
    }
    //TODO: the core of tactical AI logic should be there
    private void observeStrategyImplementation(){
        AIActor actor=choseRandomUnit();
        boolean flag = false;
        int fieldSizeX=(int)aiController.getWorldController().getActorsController().getField().getFeildSizeX();
        int fieldSizeY=(int)aiController.getWorldController().getActorsController().getField().getFeildSizeY();
        while (!flag){
            int randomDirection=random.nextInt(4);
            if (randomDirection==0&&actor.getPosition().cellIndexX+1<=fieldSizeX){
                actor.moveR();
                flag=true;
            }
            if (randomDirection==1&&actor.getPosition().cellIndexX-1>0){
                actor.moveL();
                flag=true;
            }
            if (randomDirection==2&&actor.getPosition().cellIndexY+1<=fieldSizeY){
                actor.moveT();
                flag=true;
            }
            if (randomDirection==3&&actor.getPosition().cellIndexY-1>0){
                actor.moveD();
                flag=true;
            }
        }
        aiController.endAITurn();
    }

    private void defendStrategyImplementation(){

    }

    private void attackStrategyImplementation(){

    }

    private AIActor choseRandomUnit(){
        int i = random.nextInt(aiController.getAiUnits().size());
        AIActor aiActor= (AIActor) aiController.getAiUnits().get(i);
        return aiActor;
    }
}

