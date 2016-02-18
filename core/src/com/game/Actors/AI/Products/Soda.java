package com.game.Actors.AI.Products;

public class Soda extends AIActor {

    public Soda() {
        texturePath = "soda";
        super.init();
        this.aiType="soda";
        this.maxHP=90;
        this.ATK=90;
        this.cost=24;
        super.initHP();
    }

    public Soda(String texturePath) {
        this.texturePath = texturePath;
        super.init();
        this.aiType="soda";
        this.maxHP=90;
        this.ATK=90;
        this.cost=24;
        super.initHP();
    }
}
