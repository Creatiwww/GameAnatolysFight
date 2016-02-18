package com.game.Actors.AI.Products;

public class Shawarma extends AIActor {

    public Shawarma() {
        texturePath = "shawarma";
        super.init();
        this.aiType="shawarma";
        this.maxHP=60;
        this.ATK=90;
        this.cost=21;
        super.initHP();
    }

    public Shawarma(String texturePath) {
        this.texturePath = texturePath;
        super.init();
        this.aiType="shawarma";
        this.maxHP=60;
        this.ATK=90;
        this.cost=21;
        super.initHP();
    }
}
