package com.game.Actors.AI.Products;

public class Hamburger extends AIActor {

    public Hamburger() {
        texturePath = "hamburger";
        super.init();
        this.aiType="hamburger";
        this.maxHP=100;
        this.ATK=20;
        this.cost=18;
        super.initHP();
    }

    public Hamburger(String texturePath) {
        this.texturePath = texturePath;
        super.init();
        this.aiType="hamburger";
        this.maxHP=100;
        this.ATK=20;
        this.cost=18;
        super.initHP();
    }
}
