package com.game.Actors.Playable.Products;

public class PlayableActorOldMan extends PlayableActor {

    public PlayableActorOldMan(){
        texturePath = "oldMan";
        init();
        this.getMovingFacilities().R=1;
        this.getMovingFacilities().L=1;
        this.getMovingFacilities().T=1;
        this.getMovingFacilities().B=1;
        this.getMovingFacilities().TR=1;
        this.getMovingFacilities().BR=1;
        this.getMovingFacilities().TL=1;
        this.getMovingFacilities().BL=1;
        this.maxHP=30;
        this.ATK=30;
        this.reproduction=false;
        this.gender='M';
        this.age=OLD_START_AGE;
        this.reproductionPause=0;
        this.type='O';
        this.cost=9;
        super.initHP();
    }

    public PlayableActorOldMan(String texturePath){
        this.texturePath = texturePath;
        init();
        this.getMovingFacilities().R=1;
        this.getMovingFacilities().L=1;
        this.getMovingFacilities().T=1;
        this.getMovingFacilities().B=1;
        this.getMovingFacilities().TR=1;
        this.getMovingFacilities().BR=1;
        this.getMovingFacilities().TL=1;
        this.getMovingFacilities().BL=1;
        this.maxHP=30;
        this.ATK=30;
        this.reproduction=false;
        this.gender='M';
        this.age=OLD_START_AGE;
        this.reproductionPause=0;
        this.type='O';
        this.cost=9;
        super.initHP();
    }
}
