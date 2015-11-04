package com.game.Actors.AI.Products;

public class HotDog extends AIActor {

     public HotDog() {
        texturePath = "hot_dog.png";
        super.init();
        this.maxHP=100;
        this.ATK=50;
        this.cost=3;
        super.initHP();
    }
}
