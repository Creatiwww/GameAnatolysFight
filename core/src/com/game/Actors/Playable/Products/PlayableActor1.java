package com.game.Actors.Playable.Products;

public class PlayableActor1 extends PlayableActor {
    private static final String TAG = PlayableActor1.class.getName();

    public PlayableActor1(){
        texturePath = "test_actor_brown_hair.png";
        init();
        this.getMovingFacilities().R=0;
        this.getMovingFacilities().L=0;
        this.getMovingFacilities().T=0;
        this.getMovingFacilities().B=0;
        this.getMovingFacilities().TR=2;
        this.getMovingFacilities().BR=2;
        this.getMovingFacilities().TL=2;
        this.getMovingFacilities().BL=2;
        this.ATK=40;
        this.maxHP=100;
        this.reproduction=true;
        this.gender='F';
        this.age=3;
        this.reproductionPause=0;
        this.type='Y';
        super.initHP();
    }
}