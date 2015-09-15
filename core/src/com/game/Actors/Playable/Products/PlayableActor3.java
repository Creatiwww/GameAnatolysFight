package com.game.Actors.Playable.Products;

public class PlayableActor3 extends PlayableActor {
    private static final String TAG = PlayableActor3.class.getName();

    public PlayableActor3(){
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
        super.initHP();
    }
}
