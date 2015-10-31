package com.game.Actors.Playable.Products;

import com.game.Actors.MyActor;

public class PlayableActor extends MyActor  {

    protected MovingFacilities movingFacilities;
    protected char gender;
    protected boolean reproduction;
    protected int age;
    protected int reproductionPause;
    protected char type;

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
    public boolean isReproductive(){return this.reproduction;}
    public int getAge(){return this.age; }
    public int getReproductionPause(){return this.reproductionPause;}
    public double getMaxHP(){return this.maxHP;}
    public boolean isOld(){return (this.type=='O');}
    public boolean isYoung(){return (this.type=='Y');}
    public boolean isNewBorn(){return (this.type=='N');}

    public void setAge(int newAge){age = newAge;}
    public void setReproductionPause(int newReproductionPause){reproductionPause = newReproductionPause;}



    public class MovingFacilities{
        public int R, L, B, T, TR, TL, BR, BL; // ability to move to int cells at Right, Left ... direction
    }

}