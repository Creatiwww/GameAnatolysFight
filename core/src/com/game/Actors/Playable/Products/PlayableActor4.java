package com.game.Actors.Playable.Products;

public class PlayableActor4 extends PlayableActor {
    private static final String TAG = PlayableActor4.class.getName();

    public PlayableActor4(){
        texturePath = "test_actor_old_man.png";
        init();
        this.getMovingFacilities().R=1;
        this.getMovingFacilities().L=1;
        this.getMovingFacilities().T=1;
        this.getMovingFacilities().B=1;
        this.getMovingFacilities().TR=1;
        this.getMovingFacilities().BR=1;
        this.getMovingFacilities().TL=1;
        this.getMovingFacilities().BL=1;
    }
}
