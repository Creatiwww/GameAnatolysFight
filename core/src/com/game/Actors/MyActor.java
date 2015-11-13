package com.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.game.UI.AnimationController;

public abstract class MyActor extends Actor {

    protected Texture texture;
    protected String texturePath;
    protected ActorPosition actorPosition;
    protected Boolean owner; //true - player; false - AI
    protected double HP;
    protected double maxHP;
    protected int ATK;
    protected int cost;

    public ActorPosition getPosition(){return this.actorPosition;}

    public double getHP(){return this.HP;}

    public void setHP(double newHP){this.HP=newHP;}

    public void attack(MyActor actorRef){
        actorRef.HP=actorRef.HP - this.ATK;
        AnimationController.setAttackedActor(actorRef);
        AnimationController.setAttackingActor(this);
    }

    public boolean isOwnedByAI(){
        return (!this.owner);
    }

    public boolean isOwnedByPlayer(){
        return (this.owner);
    }

    public int getCost(){
        return this.cost;
    }

    protected void init(){
        texture=new Texture(Gdx.files.internal(texturePath));
        actorPosition= new ActorPosition();
    }

    protected void initHP(){
        this.HP=this.maxHP;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    public class ActorPosition{
        public int cellIndexX, cellIndexY;
    }

}
