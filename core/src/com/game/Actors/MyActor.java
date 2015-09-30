package com.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class MyActor extends Actor {

    protected Texture texture;
    protected String texturePath;
    protected ActorPosition actorPosition;
    protected Boolean owner; //true - player; false - AI
    protected int HP;
    protected int maxHP;
    protected int ATK;

    public ActorPosition getPosition(){
        return this.actorPosition;
    }

    public int getHP(){
        return this.HP;
    }

    public void attack(MyActor actorRef){
        actorRef.HP=actorRef.HP-this.ATK;
    }

    public boolean isOwnedByAI(){
        return (!this.owner);
    }

    public boolean isOwnedByPlayer(){
        return (this.owner);
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
