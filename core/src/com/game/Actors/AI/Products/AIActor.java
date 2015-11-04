package com.game.Actors.AI.Products;

import com.game.Actors.MyActor;

public class AIActor extends MyActor {

    protected int cost;

    protected void init(){
        super.init();
        this.owner=false;
    }

    public int getCost(){
        return this.cost;
    }
    public void moveR(){
        this.actorPosition.cellIndexX++;
    }
    public void moveL(){
        this.actorPosition.cellIndexX--;
    }
    public void moveT(){
        this.actorPosition.cellIndexY++;
    }
    public void moveD(){
        this.actorPosition.cellIndexY--;
    }
}
