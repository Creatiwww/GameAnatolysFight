package com.game.Controllers;

import com.game.AI.StrategicAI;
import com.game.AI.TacticalAI;
import com.game.Actors.Field;
import com.game.Actors.MyActor;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class AIController {
    private static final String TAG = AIController.class.getName();
    private WorldController worldController;
    private StrategicAI strategicAI;
    private TacticalAI tacticalAI;
    private ArrayList aiUnits;
    private int waveDifficulty;
    private final int INITIAL_WAVE_DIFFICULTY=2;

    AIController(WorldController worldController){
        this.worldController=worldController;
        strategicAI = new StrategicAI(this);
        tacticalAI = new TacticalAI(this);
        aiUnits = new ArrayList();
        //updateAIUnitsCoordinates();
        waveDifficulty=INITIAL_WAVE_DIFFICULTY;
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
        updateAIUnitsList();
        return aiUnits;

    }

    public void startAITurn(){
        strategicAI.defineStrategy();
        tacticalAI.implementStrategy();
    }

    public void endAITurn(){
        updateAIUnitsCoordinates();
        worldController.getTurn().endAITurn();
        worldController.getTurn().startPlayerTurn();
    }

    /**
     * Generates calls to summon enemy to produce squads on the beginning of each wave.
     * Randomly defines which enemy should be summoned.
     * Calls factory method for producing each types of units while total cost is less then
     * difficulty of current wave.
     */
    public void generateNextWavesEnemies(){
       // calculateNextWaveDifficulty();
        int squadCost = 0;
        int squadCostLimit = waveDifficulty;
        Random random = new Random();
        final int NUMBER_OF_ENEMY_TYPES = 3;
        int rndEnemyTypeCode;
        while (squadCost < squadCostLimit) {
            rndEnemyTypeCode = random.nextInt(NUMBER_OF_ENEMY_TYPES);
            squadCost=squadCost + worldController.getActorsController().spawnEnemyUnit(rndEnemyTypeCode);
        }
    }
    public void generateNextWavesPlayableUnits(){
        int squadCost = 0;
        int squadCostLimit = waveDifficulty;
        Random random = new Random();
        final int NUMBER_OF_PLAYABLE_UNITS_TYPES = 3; // except old lady and old men
        int rndPlayableUnitTypeCode;
        while (squadCost < squadCostLimit) {
            rndPlayableUnitTypeCode = random.nextInt(NUMBER_OF_PLAYABLE_UNITS_TYPES);
            squadCost=squadCost + worldController.getActorsController().spawnPlayableUnit(rndPlayableUnitTypeCode);
        }
    }

    /*
     * Calculates difficulty for current enemy wave based on its number and following logic:
     * +--------+--------+----------+
     * | Wave №|increase|difficulty|
     * +--------+--------+----------+
     * |  n=1   |   0    |     d=1  |
     * |  n+1   |  +1    |     d+1  |
     * |  n+2   |  +1    |     d+2  |
     * |  n+3   |  +1    |     d+3  |
     * |  n+4   |  -1    |     d+2  |
     * |  n+5   |  +1    |     d+3  |
     * |  n+6   |  +1    |     d+4  |
     * |  n+7   |  +1    |     d+5  |
     * |  n+8   |  -1    |     d+4  |
     * |   ...  |  ...   |     ...  |
     * +--------+--------+----------+
     */
    public void calculateNextWaveDifficulty(){
        int waveNumber = worldController.getEnemyWave().getWaveNumber();
        int difficultyIncrease;
        // difficulty decrease every 5 turn
        if (waveNumber%5==0)difficultyIncrease=-1;
            else difficultyIncrease=1;
        waveDifficulty = waveDifficulty + difficultyIncrease;
    }

    public void updateAIUnitsCoordinates(){
        updateAIUnitsList();
        for (int j=0; j<aiUnits.size(); j++) {
            MyActor aiActor=(MyActor) aiUnits.get(j);
            Field field=worldController.getActorsController().getField();
            int cellIndex=field.getCoordinates().getCellIndexByXYIndexes(aiActor.getPosition().cellIndexX, aiActor.getPosition().cellIndexY);
            float x = field.getCellByIndex(cellIndex).getcX() - aiActor.getWidth()/2;
            float y = field.getCellByIndex(cellIndex).getcY() - aiActor.getWidth()/2;
            aiActor.setPosition(x, y);
        }
    }

    private void updateAIUnitsList(){
        ArrayList myActors=worldController.getActorsController().getActors();
        aiUnits.clear();
        for (int i=0; i<myActors.size(); i++){
            MyActor myActor=(MyActor)myActors.get(i);
            if (myActor.isOwnedByAI()) aiUnits.add(myActor);
        }
    }
}
