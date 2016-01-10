package com.game.Actors.AI.Products;

public class HotDog extends AIActor {

     public HotDog() {
         //texturePath = "hotDog.png";
         texturePath = "hotDog";
         super.init();
         this.aiType="hotdog";
         this.maxHP=100;
         this.ATK=50;
         this.cost=3;
         super.initHP();
    }
}
