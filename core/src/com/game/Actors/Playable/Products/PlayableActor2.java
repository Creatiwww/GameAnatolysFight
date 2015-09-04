package com.game.Actors.Playable.Products;

public class PlayableActor2 extends MyActor {
    private static final String TAG = PlayableActor2.class.getName();

    public PlayableActor2(){
        texturePath = "test_actor_men.png";
        textureInit();
        this.getMovingFacilities().R=2;
        this.getMovingFacilities().L=2;
        this.getMovingFacilities().T=2;
        this.getMovingFacilities().B=2;
        this.getMovingFacilities().TR=0;
        this.getMovingFacilities().BR=0;
        this.getMovingFacilities().TL=0;
        this.getMovingFacilities().BL=0;
    }
}
