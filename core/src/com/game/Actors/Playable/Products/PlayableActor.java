package com.game.Actors.Playable.Products;

import com.game.Actors.MyActor;

public class PlayableActor extends MyActor  {

    protected MovingFacilities movingFacilities;
    protected char gender;
    protected boolean reproduction;

    public MovingFacilities getMovingFacilities(){
        return this.movingFacilities;
    }

    protected void init(){
        super.init();
        movingFacilities=new MovingFacilities();
        this.owner=true;
    }

    public boolean isMan(){
        return (this.gender=='M');
    }
    public boolean isFemale(){
        return (this.gender=='F');
    }
    public boolean isReproductive(){
        return this.reproduction;
    }

    public class MovingFacilities{
        public int R, L, B, T, TR, TL, BR, BL; // ability to move to int cells at Right, Left ... direction
    }

}