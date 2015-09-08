package com.game.Controllers;

import com.game.AI.StrategicAI;
import com.game.AI.TacticalAI;

public class AIController {
    private static final String TAG = AIController.class.getName();
    private WorldController worldController;
    private StrategicAI strategicAI;
    private TacticalAI tacticalAI;

    AIController(WorldController worldController){
        this.worldController=worldController;
        strategicAI = new StrategicAI(this); //TODO bug is there
        tacticalAI = new TacticalAI(this);
    }

    public TacticalAI getTacticalAI(){
        return tacticalAI;
    }
    public StrategicAI getStrategicAI(){
        return strategicAI;
    }

    public void startAITurn(){
        strategicAI.defineStrategy();
        tacticalAI.implementStrategy();
    }

    public void endAITurn(){
        worldController.getTurn().endAITurn();
        worldController.getTurn().startPlayerTurn();
    }

}
