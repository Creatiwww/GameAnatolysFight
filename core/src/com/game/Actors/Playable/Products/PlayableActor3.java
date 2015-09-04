package com.game.Actors.Playable.Products;

public class PlayableActor3 extends MyActor {
    private static final String TAG = PlayableActor3.class.getName();

    public PlayableActor3(){
        texturePath = "test_actor_old_woman.png";
        textureInit();
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
