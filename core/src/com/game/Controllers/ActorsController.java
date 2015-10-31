package com.game.Controllers;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.game.Actors.AI.Creators.CreatorAIActor;
import com.game.Actors.AI.Creators.CreatorAIActor1;
import com.game.Actors.AI.Products.AIActor;
import com.game.Actors.AvailableForMovementCell;
import com.game.Actors.MergeableCell;
import com.game.Actors.MyActor;
import com.game.Actors.OccupiedByAICell;
import com.game.Actors.Playable.Creators.CreatorPlayableActor;
import com.game.Actors.Playable.Creators.CreatorPlayableActor1;
import com.game.Actors.Playable.Creators.CreatorPlayableActor2;
import com.game.Actors.Playable.Creators.CreatorPlayableActor3;
import com.game.Actors.Playable.Creators.CreatorPlayableActor4;
import com.game.Actors.Playable.Creators.CreatorPlayableActor5;
import com.game.Actors.Playable.Listeners.PlayableActorsListener;
import com.game.Actors.Field;
import com.game.Actors.Playable.Products.PlayableActor;

import java.util.ArrayList;
import java.util.Random;

public class ActorsController {
    private static final String TAG = ActorsController.class.getName();

    private CreatorPlayableActor creatorPlayableActor1;
    private CreatorPlayableActor creatorPlayableActor2;
    private CreatorPlayableActor creatorPlayableActor3;
    private CreatorPlayableActor creatorPlayableActor4;
    private CreatorPlayableActor creatorPlayableActor5;
    private CreatorAIActor creatorAIActor1;
    private ArrayList actors;
    private ArrayList <MyActor> pActors;
    private Field field;
    private WorldController worldController;
    private ArrayList availableCells;
    private ArrayList occupiedByAICells;
    private ArrayList mergeableCells;
    final double ACTOR_SIZE_MODIFICATOR=0.15;

    public ActorsController(WorldController worldController){
        field = new Field();
        actors =new ArrayList();
        this.worldController=worldController;
        field.setSize(field.getCoordinates().getFieldWidth(), field.getCoordinates().getFieldHeight());
        field.setPosition(field.getCellByIndex(0).getbLX(), field.getCellByIndex(0).getbLY());
        availableCells = new ArrayList();
        occupiedByAICells = new ArrayList();
        mergeableCells = new ArrayList();
        creatorPlayableActor1=new CreatorPlayableActor1();
        creatorPlayableActor2=new CreatorPlayableActor2();
        creatorPlayableActor3=new CreatorPlayableActor3();
        creatorPlayableActor4=new CreatorPlayableActor4();
        creatorPlayableActor5=new CreatorPlayableActor5();
        creatorAIActor1=new CreatorAIActor1();
        worldController.getTurn().startPlayerTurn();
    }

    public ArrayList getActors(){
        return actors;
    }
    public ArrayList getPActors(){
        pActors=new <MyActor>ArrayList(actors);
        int size=pActors.size();
        for (int i=size-1; i>-1; i--){
            MyActor actor=pActors.get(i);
            if(!actor.isOwnedByPlayer()) pActors.remove(i);
        }
        return pActors;
    }
    public Field getField(){
        return field;
    }
    public ArrayList getAvailableCell(){
        return availableCells;
    }
    public ArrayList getOccupiedByAICell(){
        return occupiedByAICells;
    }
    public ArrayList getMergeableCell(){
        return mergeableCells;
    }

    public void drawAvailableForMovementCells(float x, float y){
        AvailableForMovementCell availableForMovementCell = new AvailableForMovementCell();
        availableForMovementCell.setSize(field.getCellWidth() - (field.getCellWidth() * 1446/16933), field.getCellWidth()-(field.getCellWidth() * 1446/16933));
        x= x - availableForMovementCell.getWidth() / 2;
        y= y - availableForMovementCell.getWidth() / 2;
        availableForMovementCell.setPosition(x, y);
        availableCells.add(availableForMovementCell);
        //worldController.getScreen().drawAvailableForMovementCells();
    }

    public void drawOccupiedByAICells(float x, float y){
        OccupiedByAICell occupiedByAICell = new OccupiedByAICell();
        occupiedByAICell.setSize(field.getCellWidth() - (field.getCellWidth() * 1446/16933), field.getCellWidth()-(field.getCellWidth() * 1446/16933));
        x= x - occupiedByAICell.getWidth() / 2;
        y= y - occupiedByAICell.getWidth() / 2;
        occupiedByAICell.setPosition(x, y);
        occupiedByAICells.add(occupiedByAICell);
        //worldController.getScreen().drawAvailableForMovementCells();
    }

    public void drawMergeableCells(float x, float y){
        MergeableCell mergeableCell = new MergeableCell();
        mergeableCell.setSize(field.getCellWidth() - (field.getCellWidth() * 1446/16933), field.getCellWidth()-(field.getCellWidth() * 1446/16933));
        x= x - mergeableCell.getWidth() / 2;
        y= y - mergeableCell.getWidth() / 2;
        mergeableCell.setPosition(x, y);
        mergeableCells.add(mergeableCell);
        //worldController.getScreen().drawAvailableForMovementCells();
    }

    public void clearAvailableForMovementCellsArray(){
        for (int i=0; i<availableCells.size(); i++){
            Actor availableCell = (Actor) availableCells.get(i);
            availableCell.remove();
        }
        for (int i=0; i<mergeableCells.size(); i++){
            Actor mergeableCell = (Actor) mergeableCells.get(i);
            mergeableCell.remove();
        }
        for (int i=0; i<occupiedByAICells.size(); i++){
            Actor occupiedByAICell = (Actor) occupiedByAICells.get(i);
            occupiedByAICell.remove();
        }
        availableCells.clear();
        mergeableCells.clear();
        occupiedByAICells.clear();
    }

    public void spawnInitialSetOfPlayableActors(){
        for (int i=0; i<4; i++) {

            if (i==0) actors.add(creatorPlayableActor1.factoryMethod());
            if (i==1) actors.add(creatorPlayableActor2.factoryMethod());
            if (i==2) actors.add(creatorPlayableActor3.factoryMethod());
            if (i==3) actors.add(creatorPlayableActor4.factoryMethod());
           

            PlayableActor actor = (PlayableActor) actors.get(i);
            float actorSize=field.getCellWidth()*(1-(float)ACTOR_SIZE_MODIFICATOR);
            actor.setSize(actorSize, actorSize);
            int cellIndexX=4-i;
            int cellIndexY=4+i;
            if (i==2){
                cellIndexX=5;
                cellIndexY=5;
            }
            if (i==3){
                cellIndexX=4;
                cellIndexY=7;
            }
            actor.getPosition().cellIndexX =cellIndexX;
            actor.getPosition().cellIndexY =cellIndexY;
            int cellIndex=field.getCoordinates().getCellIndexByXYIndexes(cellIndexX, cellIndexY);
            Field.Cell cell= field.getCellByIndex(cellIndex);
            cell.setActorRef(actor);
            actor.setPosition(cell.getcX()-actor.getWidth()/2, cell.getcY()-actor.getHeight()/2);
            actor.addListener(new PlayableActorsListener(actor, worldController));
        }
    }

    public void spawnInitialSetOfAIActors(){
        actors.add(creatorAIActor1.factoryMethod());
        int index=actors.size();
        AIActor actor = (AIActor) actors.get(index-1);
        float actorSize=field.getCellWidth()*(1-(float)ACTOR_SIZE_MODIFICATOR);
        actor.setSize(actorSize, actorSize);
        int cellIndexX=1;
        int cellIndexY=1;
        actor.getPosition().cellIndexX =cellIndexX;
        actor.getPosition().cellIndexY =cellIndexY;
        int cellIndex=field.getCoordinates().getCellIndexByXYIndexes(cellIndexX, cellIndexY);
        Field.Cell cell= field.getCellByIndex(cellIndex);
        cell.setActorRef(actor);

        actors.add(creatorAIActor1.factoryMethod());
        index=actors.size();
        actor = (AIActor) actors.get(index-1);
        actor.setSize(actorSize, actorSize);
        cellIndexX=4;
        cellIndexY=5;
        actor.getPosition().cellIndexX =cellIndexX;
        actor.getPosition().cellIndexY =cellIndexY;
        cellIndex=field.getCoordinates().getCellIndexByXYIndexes(cellIndexX, cellIndexY);
        cell= field.getCellByIndex(cellIndex);
        cell.setActorRef(actor);

    }

    public void spawnChild(int spawnCellIndex){
        actors.add(creatorPlayableActor5.factoryMethod());
        int actorIndex=actors.size()-1;
        PlayableActor actor = (PlayableActor) actors.get(actorIndex);
        float actorSize=field.getCellWidth()*(1-(float)ACTOR_SIZE_MODIFICATOR);
        actor.setSize(actorSize, actorSize);
        //actor.toFront();
        Field.Cell spawnCell=field.getCellByIndex(spawnCellIndex);
        actor.getPosition().cellIndexX =spawnCell.getIndexX();
        actor.getPosition().cellIndexY =spawnCell.getIndexY();
        spawnCell.setActorRef(actor);
        actor.setPosition(spawnCell.getcX() - actor.getWidth() / 2, spawnCell.getcY() - actor.getHeight() / 2);
        actor.addListener(new PlayableActorsListener(actor, worldController));
        worldController.getScreen().drawActors();
    }

    public void reproductionPauseRedaction(){
        for (Object PActor: getPActors()){
            PlayableActor playableActor = (PlayableActor) PActor;
            if (playableActor.getReproductionPause()!=0)playableActor.setReproductionPause(playableActor.getReproductionPause() - 1);
        }
    }
    public void ageIncrease(){
        for (Object PActor: getPActors()){
            PlayableActor playableActor = (PlayableActor) PActor;
            playableActor.setAge(playableActor.getAge() + 1);
        }
    }
    public void maturation(){
        float actorSize=field.getCellWidth()*(1-(float)ACTOR_SIZE_MODIFICATOR);
        double bufHP;
        for (int i=0; i<actors.size(); i++){
            MyActor PActor = (MyActor)actors.get(i);
            if(PActor.isOwnedByPlayer()) {
                PlayableActor playableActor = (PlayableActor) PActor;
                if (playableActor.isOld() && playableActor.getAge() == 9) {
                    // remove ref from the cell
                    int IndexX = playableActor.getPosition().cellIndexX;
                    int IndexY = playableActor.getPosition().cellIndexY;
                    int cellIndex = field.getCoordinates().getCellIndexByXYIndexes(IndexX, IndexY);
                    field.getCellByIndex(cellIndex).setActorRef(null);
                    // remove from array of actors to be added to stage
                    this.actors.remove(i);
                    i--;
                    playableActor.remove();
                }
                if (playableActor.isYoung() && playableActor.getAge() == 6) {
                    if(playableActor.isFemale())actors.add(creatorPlayableActor3.factoryMethod());
                    if(playableActor.isMan())actors.add(creatorPlayableActor4.factoryMethod());
                    PlayableActor newPlayableActor = (PlayableActor) actors.get(actors.size()-1);
                    int IndexX = playableActor.getPosition().cellIndexX;
                    int IndexY = playableActor.getPosition().cellIndexY;
                    int cellIndex = field.getCoordinates().getCellIndexByXYIndexes(IndexX, IndexY);
                    Field.Cell cellForSpawn = field.getCellByIndex(cellIndex);
                    cellForSpawn.setActorRef(newPlayableActor);
                    bufHP = playableActor.getHP()/playableActor.getMaxHP();
                    playableActor.remove();
                    newPlayableActor.getPosition().cellIndexX =IndexX;
                    newPlayableActor.getPosition().cellIndexY =IndexY;
                    newPlayableActor.setSize(actorSize, actorSize);
                    newPlayableActor.setPosition(cellForSpawn.getcX() - newPlayableActor.getWidth() / 2, cellForSpawn.getcY()-newPlayableActor.getHeight() / 2);
                    newPlayableActor.addListener(new PlayableActorsListener(newPlayableActor, worldController));
                    newPlayableActor.setHP(bufHP * newPlayableActor.getHP());
                    this.actors.remove(i);
                    i--;


                }
                if (playableActor.isNewBorn() && playableActor.getAge() == 3) {
                    Random random = new Random();
                    int rndVal = random.nextInt(2);
                    if(rndVal==0)actors.add(creatorPlayableActor1.factoryMethod());
                    if(rndVal==1)actors.add(creatorPlayableActor2.factoryMethod());
                    PlayableActor newPlayableActor = (PlayableActor) actors.get(actors.size()-1);
                    int IndexX = playableActor.getPosition().cellIndexX;
                    int IndexY = playableActor.getPosition().cellIndexY;
                    int cellIndex = field.getCoordinates().getCellIndexByXYIndexes(IndexX, IndexY);
                    Field.Cell cell = field.getCellByIndex(cellIndex);
                    cell.setActorRef(newPlayableActor);
                    bufHP = playableActor.getHP()/playableActor.getMaxHP();
                    playableActor.remove();
                    newPlayableActor.getPosition().cellIndexX =IndexX;
                    newPlayableActor.getPosition().cellIndexY =IndexY;
                    newPlayableActor.setSize(actorSize, actorSize);
                    newPlayableActor.setPosition(cell.getcX() - newPlayableActor.getWidth() / 2, cell.getcY() - newPlayableActor.getHeight() / 2);
                    newPlayableActor.addListener(new PlayableActorsListener(newPlayableActor, worldController));
                    newPlayableActor.setHP(bufHP * newPlayableActor.getHP());
                    this.actors.remove(i);
                    i--;
                }
            }
        }
        worldController.getScreen().drawActors();
    }


   public void deleteDeadUnits(){
        for (int i=0; i<actors.size(); i++){
            MyActor actor=(MyActor)this.actors.get(i);
            if (actor.getHP()<=0) {
                // remove ref from the cell
                int IndexX=actor.getPosition().cellIndexX;
                int IndexY=actor.getPosition().cellIndexY;
                int cellIndex=field.getCoordinates().getCellIndexByXYIndexes(IndexX,IndexY);
                field.getCellByIndex(cellIndex).setActorRef(null);
                // remove from array of actors to be added to stage
                this.actors.remove(i);
                actor.remove();
            }
        }
    }
}
