package com.game.Actors.Playable.Products;

public class PlayableActorGranny extends PlayableActor {

    public PlayableActorGranny(){
        texturePath = "granny";
        init();
        this.getMovingFacilities().R=1;
        this.getMovingFacilities().L=1;
        this.getMovingFacilities().T=1;
        this.getMovingFacilities().B=1;
        this.getMovingFacilities().TR=1;
        this.getMovingFacilities().BR=1;
        this.getMovingFacilities().TL=1;
        this.getMovingFacilities().BL=1;
        this.maxHP=40;
        this.ATK=20;
        this.reproduction=false;
        this.gender='F';
        this.age=OLD_START_AGE;
        this.reproductionPause=0;
        this.type='O';
        this.cost=9;
        super.initHP();
    }

    public PlayableActorGranny(String texturePath){
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
        this.maxHP=40;
        this.ATK=20;
        this.reproduction=false;
        this.gender='F';
        this.age=OLD_START_AGE;
        this.reproductionPause=0;
        this.type='O';
        this.cost=9;
        super.initHP();
    }
}
