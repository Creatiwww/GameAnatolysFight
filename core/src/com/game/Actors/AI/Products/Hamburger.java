package com.game.Actors.AI.Products;

public class Hamburger extends AIActor {

    public Hamburger() {
        //texturePath = "hamburger.png";
        texturePath = "hamburger";
        super.init();
        this.aiType="hamburger";
        this.maxHP=60;
        this.ATK=30;
        this.cost=2;
        super.initHP();
    }
}
