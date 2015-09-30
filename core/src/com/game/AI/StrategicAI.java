package com.game.AI;

import com.game.Controllers.AIController;

public class StrategicAI {
    private int strategyIndex;
    private AIController aiController;

    public StrategicAI(AIController aiController){
        this.aiController=aiController;
    }

    public void defineStrategy(){
        //TODO: the core of strategic AI logic should be there
        // setObserveStrategy();
        setAttackStrategy();
    }

    private void setDefendStrategy(){
        strategyIndex=1;
    }
    private void setAttackStrategy(){
        strategyIndex=2;
    }
    private void setObserveStrategy(){
        strategyIndex=0;
    }

    public boolean isObserveStrategy(){
        if (strategyIndex==0) return true;
        else return false;
    }
    public boolean isAttackStrategy(){
        if (strategyIndex==2) return true;
        else return false;
    }
    public boolean isDefendStrategy(){
        if (strategyIndex==1) return true;
        else return false;
    }

}
