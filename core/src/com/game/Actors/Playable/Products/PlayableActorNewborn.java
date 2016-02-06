package com.game.Actors.Playable.Products;

public class PlayableActorNewborn extends PlayableActor {
    private static final String TAG = PlayableActorNewborn.class.getName();

    public PlayableActorNewborn(){
        texturePath = "newborn";
        init();
        this.getMovingFacilities().R=0;
        this.getMovingFacilities().L=0;
        this.getMovingFacilities().T=0;
        this.getMovingFacilities().B=0;
        this.getMovingFacilities().TR=1;
        this.getMovingFacilities().BR=1;
        this.getMovingFacilities().TL=1;
        this.getMovingFacilities().BL=1;
        this.maxHP=20;
        this.ATK=10;
        this.reproduction=false;
        this.gender='N';
        this.age=0;
        this.reproductionPause=0;
        this.type='N';
        this.cost=5;
        super.initHP();
    }

    public PlayableActorNewborn(String texturePath){
        this.texturePath = texturePath;
        init();
        this.getMovingFacilities().R=0;
        this.getMovingFacilities().L=0;
        this.getMovingFacilities().T=0;
        this.getMovingFacilities().B=0;
        this.getMovingFacilities().TR=1;
        this.getMovingFacilities().BR=1;
        this.getMovingFacilities().TL=1;
        this.getMovingFacilities().BL=1;
        this.maxHP=20;
        this.ATK=10;
        this.reproduction=false;
        this.gender='N';
        this.age=0;
        this.reproductionPause=0;
        this.type='N';
        this.cost=5;
        super.initHP();
    }
}
