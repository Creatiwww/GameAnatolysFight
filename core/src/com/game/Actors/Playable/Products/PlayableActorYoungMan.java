package com.game.Actors.Playable.Products;

public class PlayableActorYoungMan extends PlayableActor {
    private static final String TAG = PlayableActorYoungMan.class.getName();

    public PlayableActorYoungMan(){
        //texturePath = "youngMan.png";
        texturePath = "youngMan";
        init();
        this.getMovingFacilities().R=2;
        this.getMovingFacilities().L=2;
        this.getMovingFacilities().T=2;
        this.getMovingFacilities().B=2;
        this.getMovingFacilities().TR=0;
        this.getMovingFacilities().BR=0;
        this.getMovingFacilities().TL=0;
        this.getMovingFacilities().BL=0;
        this.maxHP=80;
        this.ATK=50;
        this.reproduction=true;
        this.gender='M';
        this.age=YOUNG_START_AGE;
        this.reproductionPause=0;
        this.type='Y';
        this.cost=2;
        super.initHP();
    }
}
