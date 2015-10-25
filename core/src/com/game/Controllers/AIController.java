package com.game.Controllers;

import com.badlogic.gdx.Gdx;
import com.game.AI.StrategicAI;
import com.game.AI.TacticalAI;
import com.game.Actors.Field;
import com.game.Actors.MyActor;

import java.util.ArrayList;

public class AIController {
    private static final String TAG = AIController.class.getName();
    private WorldController worldController;
    private StrategicAI strategicAI;
    private TacticalAI tacticalAI;
    private ArrayList aiUnits;

    AIController(WorldController worldController){
        this.worldController=worldController;
        strategicAI = new StrategicAI(this);
        tacticalAI = new TacticalAI(this);
        aiUnits = new ArrayList();
        updateAIUnitsCoordinates();
    }

    public TacticalAI getTacticalAI(){
        return tacticalAI;
    }
    public StrategicAI getStrategicAI(){
        return strategicAI;
    }
    public WorldController getWorldController(){
        return worldController;
    }
    public ArrayList getAiUnits(){
        return aiUnits;
    }

    public void startAITurn(){
        strategicAI.defineStrategy();
        tacticalAI.implementStrategy(); //TODO: bug is there!!!
    }

    public void endAITurn(){
        updateAIUnitsCoordinates();
        worldController.getTurn().endAITurn();
        worldController.getTurn().startPlayerTurn();
    }

    private void updateAIUnitsCoordinates(){
        createAIUnitsList();
        for (int j=0; j<aiUnits.size(); j++) {
            MyActor aiActor=(MyActor) aiUnits.get(j);
            Field field=worldController.getActorsController().getField();
            int cellIndex=field.getCoordinates().getCellIndexByXYIndexes(aiActor.getPosition().cellIndexX, aiActor.getPosition().cellIndexY);
            float x = field.getCellByIndex(cellIndex).getcX()-aiActor.getWidth()/2;
            float y = field.getCellByIndex(cellIndex).getcY()-aiActor.getWidth()/2;
            aiActor.setPosition(x, y);
        }
    }

    private void createAIUnitsList(){
        ArrayList myActors=worldController.getActorsController().getActors();
        aiUnits.clear();
        for (int i=0; i<myActors.size(); i++){
            MyActor myActor=(MyActor)myActors.get(i);
            if (myActor.isOwnedByAI()) aiUnits.add(myActor);
        }
    }
}
