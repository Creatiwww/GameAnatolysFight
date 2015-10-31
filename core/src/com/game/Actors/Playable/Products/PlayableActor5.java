package com.game.Actors.Playable.Products;

public class PlayableActor5 extends PlayableActor {
    private static final String TAG = PlayableActor5.class.getName();

    public PlayableActor5(){
        texturePath = "test_actor_child.png";
        init();
        this.getMovingFacilities().R=0;
        this.getMovingFacilities().L=0;
        this.getMovingFacilities().T=0;
        this.getMovingFacilities().B=0;
        this.getMovingFacilities().TR=1;
        this.getMovingFacilities().BR=1;
        this.getMovingFacilities().TL=1;
        this.getMovingFacilities().BL=1;
        this.maxHP=50;
        this.ATK=0;
        this.reproduction=false;
        this.gender='N';
        this.age=0;
        this.reproductionPause=0;
        this.type='N';
        super.initHP();
    }
}
