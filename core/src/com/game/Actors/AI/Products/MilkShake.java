package com.game.Actors.AI.Products;

public class MilkShake extends AIActor {

    public MilkShake() {
        texturePath = "milkshake";
        super.init();
        this.aiType="milkshake";
        this.maxHP=40;
        this.ATK=40;
        this.cost=12;
        super.initHP();
    }

    public MilkShake(String texturePath) {
        this.texturePath = texturePath;
        super.init();
        this.aiType="milkshake";
        this.maxHP=40;
        this.ATK=40;
        this.cost=12;
        super.initHP();
    }
}
