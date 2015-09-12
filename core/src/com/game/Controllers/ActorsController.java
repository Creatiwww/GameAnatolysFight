package com.game.Controllers;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.game.Actors.AI.Creators.CreatorAIActor;
import com.game.Actors.AI.Creators.CreatorAIActor1;
import com.game.Actors.AI.Products.AIActor;
import com.game.Actors.AvailableForMovementCell;
import com.game.Actors.Playable.Creators.CreatorPlayableActor;
import com.game.Actors.Playable.Creators.CreatorPlayableActor1;
import com.game.Actors.Playable.Creators.CreatorPlayableActor2;
import com.game.Actors.Playable.Creators.CreatorPlayableActor3;
import com.game.Actors.Playable.Creators.CreatorPlayableActor4;
import com.game.Actors.Playable.Listeners.PlayableActorsListener;
import com.game.Actors.Field;
import com.game.Actors.Playable.Products.PlayableActor;

import java.util.ArrayList;

public class ActorsController {
    private static final String TAG = ActorsController.class.getName();

    private CreatorPlayableActor creatorPlayableActor1;
    private CreatorPlayableActor creatorPlayableActor2;
    private CreatorPlayableActor creatorPlayableActor3;
    private CreatorPlayableActor creatorPlayableActor4;
    private CreatorAIActor creatorAIActor1;
    private ArrayList actors;
    private Field field;
    private WorldController worldController;
    private ArrayList availableCells;
    final double ACTOR_SIZE_MODIFICATOR=0.15;

    public ActorsController(WorldController worldController){
        field = new Field();
        actors =new ArrayList();
        this.worldController=worldController;
        field.setSize(field.getCoordinates().getFieldWidth(), field.getCoordinates().getFieldHeight());
        field.setPosition(field.getCellByIndex(0).getbLX(), field.getCellByIndex(0).getbLY());
        availableCells = new ArrayList();
        creatorPlayableActor1=new CreatorPlayableActor1();
        creatorPlayableActor2=new CreatorPlayableActor2();
        creatorPlayableActor3=new CreatorPlayableActor3();
        creatorPlayableActor4=new CreatorPlayableActor4();
        creatorAIActor1=new CreatorAIActor1();
        worldController.getTurn().startPlayerTurn();
    }

    public ArrayList getActors(){
        return actors;
    }
    public Field getField(){
        return field;
    }
    public ArrayList getAvailableCell(){
        return availableCells;
    }

    public void drawAvailableForMovementCells(float x, float y){
        AvailableForMovementCell availableForMovementCell = new AvailableForMovementCell();
        availableForMovementCell.setSize(field.getCellWidth() - (field.getCellWidth() * 1446/16933), field.getCellWidth()-(field.getCellWidth() * 1446/16933));
        x= x - availableForMovementCell.getWidth() / 2;
        y= y - availableForMovementCell.getWidth() / 2;
        availableForMovementCell.setPosition(x, y);
        availableCells.add(availableForMovementCell);
        worldController.getScreen().drawAvailableForMovementCells();
    }

    public void clearAvailableForMovementCellsArray(){
        for (int i=0; i<availableCells.size(); i++){
            Actor availableCell = (Actor) availableCells.get(i);
            availableCell.remove();
        }
        availableCells.clear();
    }

    public void spawnInitialSetOfPlayableActors(){
        for (int i=0; i<8; i++) {

            if (i==0) actors.add(creatorPlayableActor1.factoryMethod());
            if (i==1) actors.add(creatorPlayableActor2.factoryMethod());
            if (i==2) actors.add(creatorPlayableActor3.factoryMethod());
            if (i==3) actors.add(creatorPlayableActor4.factoryMethod());
            if (i==4) actors.add(creatorPlayableActor1.factoryMethod());

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
}
