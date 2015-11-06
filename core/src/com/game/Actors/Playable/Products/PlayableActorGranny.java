package com.game.Actors.Playable.Products;

public class PlayableActorGranny extends PlayableActor {
    private static final String TAG = PlayableActorGranny.class.getName();

    public PlayableActorGranny(){
        texturePath = "test_actor_old_woman.png";
        init();
        this.getMovingFacilities().R=1;
        this.getMovingFacilities().L=1;
        this.getMovingFacilities().T=1;
        this.getMovingFacilities().B=1;
        this.getMovingFacilities().TR=1;
        this.getMovingFacilities().BR=1;
        this.getMovingFacilities().TL=1;
        this.getMovingFacilities().BL=1;
        this.maxHP=80;
        this.ATK=70;
        this.reproduction=false;
        this.gender='F';
        this.age=OLD_START_AGE;
        this.reproductionPause=0;
        this.type='O';
        this.cost=1;
        super.initHP();
    }
}
