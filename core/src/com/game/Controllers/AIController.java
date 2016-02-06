package com.game.Controllers;

import com.game.AI.StrategicAI;
import com.game.AI.TacticalAI;
import com.game.Actors.Field;
import com.game.Actors.MyActor;
import java.util.ArrayList;
import java.util.Random;

public class AIController {
    private WorldController worldController;
    private StrategicAI strategicAI;
    private TacticalAI tacticalAI;
    private ArrayList aiUnits;
    private int waveDifficulty;
    private final int INITIAL_WAVE_DIFFICULTY = 20;
    private final int INITIAL_WAVE_DIFFICULTY_ENEMY = 10;
    private final int  WAVE_COST_INCREASE_FOR_PLAYABLE_UNITS = 5;

    AIController(WorldController worldController){
        this.worldController=worldController;
        strategicAI = new StrategicAI(this);
        tacticalAI = new TacticalAI(this);
        aiUnits = new ArrayList();
        waveDifficulty = INITIAL_WAVE_DIFFICULTY_ENEMY;
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

    /**
     * Generates calls to summon enemy to produce squads on the beginning of each wave.
     * Randomly defines which enemy should be summoned.
     * Calls factory method for producing each types of units while total cost is less then
     * difficulty of current wave.
     */
    public void generateNextWavesEnemies(){
        int squadCost = 0;
        int squadCostLimit = waveDifficulty;
        Random random = new Random();
        final int NUMBER_OF_ENEMY_TYPES = 3;
        int rndEnemyTypeCode;
        while (squadCost < squadCostLimit) {
            rndEnemyTypeCode = random.nextInt(NUMBER_OF_ENEMY_TYPES);
            squadCost = squadCost + worldController.getActorsController().spawnEnemyUnit(rndEnemyTypeCode);
        }
    }

    public void generateNextWavesPlayableUnits(){
        int squadCost = 0;
        int squadCostLimit = INITIAL_WAVE_DIFFICULTY + (worldController.getEnemyWave().getWaveNumber()-1) * WAVE_COST_INCREASE_FOR_PLAYABLE_UNITS;
        Random random = new Random();
        final int NUMBER_OF_PLAYABLE_UNITS_TYPES = 2; // except old lady and old men
        int rndPlayableUnitTypeCode;
        while (squadCost < squadCostLimit) {
            rndPlayableUnitTypeCode = random.nextInt(NUMBER_OF_PLAYABLE_UNITS_TYPES);
            squadCost = squadCost + worldController.getActorsController().spawnPlayableUnit(rndPlayableUnitTypeCode);
        }
    }

    /*
     * Calculates difficulty for current enemy wave based on its number and following logic:
     * +--------+--------+----------+
     * | Wave №|increase|difficulty|
     * +--------+--------+----------+
     * |  n=1   |   0    |     d=2  |
     * |  n=2   |  +2    |     4    |
     * |  n=3   |  +2    |     6    |
     * |  n=4   |  -1    |     5    |
     * |  n=5   |  +2    |     7    |
     * |  n=6   |  +2    |     9    |
     * |  n=7   |  +2    |     11   |
     * |  n=8   |  -1    |     10   |
     * |  n=9   |  +2    |     12   |
     * |   ...  |  ...   |     ...  |
     * +--------+--------+----------+
     */
    public void calculateNextWaveDifficulty(){
        int waveNumber = worldController.getEnemyWave().getWaveNumber();
        int difficultyIncrease;
        // difficulty decrease every 5 turn
        if (waveNumber % 4 == 0) difficultyIncrease =- 5;
            else difficultyIncrease = 10;
        waveDifficulty = waveDifficulty + difficultyIncrease;
    }

    public void updateAIUnitsCoordinates(){
        updateAIUnitsList();
        for (int j = 0; j<aiUnits.size(); j++) {
            MyActor aiActor = (MyActor) aiUnits.get(j);
            Field field = worldController.getActorsController().getField();
            int cellIndex = field.getCoordinates().getCellIndexByXYIndexes(aiActor.getPosition().cellIndexX, aiActor.getPosition().cellIndexY);
            float x = field.getCellByIndex(cellIndex).getcX() - aiActor.getWidth()/2;
            float y = field.getCellByIndex(cellIndex).getcY() - aiActor.getWidth()/2;
            aiActor.setPosition(x, y);
        }
    }

    public void updateAIUnitsList(){
        ArrayList myActors = worldController.getActorsController().getActors();
        aiUnits.clear();
        for (int i = 0; i < myActors.size(); i++){
            MyActor myActor = (MyActor)myActors.get(i);
            if (myActor.isOwnedByAI()) aiUnits.add(myActor);
        }
    }
}
