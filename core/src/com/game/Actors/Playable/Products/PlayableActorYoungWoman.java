package com.game.Actors.Playable.Products;

public class PlayableActorYoungWoman extends PlayableActor {
    private static final String TAG = PlayableActorYoungWoman.class.getName();

    public PlayableActorYoungWoman(){
        texturePath = "youngWoman";
        init();
        this.getMovingFacilities().R=0;
        this.getMovingFacilities().L=0;
        this.getMovingFacilities().T=0;
        this.getMovingFacilities().B=0;
        this.getMovingFacilities().TR=2;
        this.getMovingFacilities().BR=2;
        this.getMovingFacilities().TL=2;
        this.getMovingFacilities().BL=2;
        this.ATK=40;
        this.maxHP=80;
        this.reproduction=true;
        this.gender='F';
        this.age=YOUNG_START_AGE;
        this.reproductionPause=0;
        this.type='Y';
        this.cost=18;
        super.initHP();
    }

    public PlayableActorYoungWoman(String texturePath){
        this.texturePath = texturePath;
        init();
        this.getMovingFacilities().R=0;
        this.getMovingFacilities().L=0;
        this.getMovingFacilities().T=0;
        this.getMovingFacilities().B=0;
        this.getMovingFacilities().TR=2;
        this.getMovingFacilities().BR=2;
        this.getMovingFacilities().TL=2;
        this.getMovingFacilities().BL=2;
        this.ATK=40;
        this.maxHP=80;
        this.reproduction=true;
        this.gender='F';
        this.age=YOUNG_START_AGE;
        this.reproductionPause=0;
        this.type='Y';
        this.cost=18;
        super.initHP();
    }
}