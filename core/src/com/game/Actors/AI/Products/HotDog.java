package com.game.Actors.AI.Products;

public class HotDog extends AIActor {

     public HotDog() {
         texturePath = "hotDog";
         super.init();
         this.aiType="hotdog";
         this.maxHP=60;
         this.ATK=30;
         this.cost=14;
         super.initHP();
    }

    public HotDog(String texturePath) {
        this.texturePath = texturePath;
        super.init();
        this.aiType="hotdog";
        this.maxHP=60;
        this.ATK=30;
        this.cost=14;
        super.initHP();
    }
}
