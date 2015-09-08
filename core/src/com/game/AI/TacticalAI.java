package com.game.AI;

import com.game.Controllers.AIController;

public class TacticalAI {
    private AIController aiController;

    public TacticalAI(AIController aiController){
        this.aiController=aiController;
    }

    public void implementStrategy(){
        if (aiController.getStrategicAI().isObserveStrategy()) observeStrategyImplementation();
        if (aiController.getStrategicAI().isAttackStrategy()) attackStrategyImplementation();
        if (aiController.getStrategicAI().isDefendStrategy()) defendStrategyImplementation();
    }
    //TODO: the core of tactical AI logic should be there
    private void observeStrategyImplementation(){
        aiController.endAITurn();
    }

    private void defendStrategyImplementation(){

    }

    private void attackStrategyImplementation(){

    }
}
