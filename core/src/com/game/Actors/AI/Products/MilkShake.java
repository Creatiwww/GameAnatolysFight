package com.game.Actors.AI.Products;

public class MilkShake extends AIActor {

    public MilkShake() {
        texturePath = "milkshake.png";
        super.init();
        this.maxHP=100;
        this.ATK=60;
        this.cost=4;
        super.initHP();
    }
}
