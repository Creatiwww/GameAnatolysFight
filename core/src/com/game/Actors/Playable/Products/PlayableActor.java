package com.game.Actors.Playable.Products;

import com.game.Actors.MyActor;

public class PlayableActor extends MyActor  {

    protected MovingFacilities movingFacilities;

    public MovingFacilities getMovingFacilities(){
        return this.movingFacilities;
    }

    protected void init(){
        super.init();
        movingFacilities=new MovingFacilities();
    }

    public class MovingFacilities{
        public int R, L, B, T, TR, TL, BR, BL; // ability to move to int cells at Right, Left ... direction
    }



}