package com.game.Actors.Playable.Products;

public class PlayableActorOldMan extends PlayableActor {
    private static final String TAG = PlayableActorOldMan.class.getName();

    public PlayableActorOldMan(){
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
        this.maxHP=60;
        this.ATK=80;
        this.reproduction=false;
        this.gender='M';
        this.age=OLD_START_AGE;
        this.reproductionPause=0;
        this.type='O';
        super.initHP();
    }
}
