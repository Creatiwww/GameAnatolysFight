package com.game.Actors.AI.Products;

public class Cola extends AIActor {

     public Cola() {
         texturePath = "cola";
         super.init();
         this.aiType="cola";
         this.maxHP=60;
         this.ATK=110;
         this.cost=28;
         super.initHP();
    }

    public Cola(String texturePath) {
        this.texturePath = texturePath;
        super.init();
        this.aiType="cola";
        this.maxHP=60;
        this.ATK=110;
        this.cost=28;
        super.initHP();
    }
}
