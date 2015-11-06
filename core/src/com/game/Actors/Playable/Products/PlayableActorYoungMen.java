package com.game.Actors.Playable.Products;

public class PlayableActorYoungMen extends PlayableActor {
    private static final String TAG = PlayableActorYoungMen.class.getName();

    public PlayableActorYoungMen(){
        texturePath = "test_actor_men.png";
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
