package com.game.Main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;

import java.util.ArrayList;

public class AssetLoader {

    public static Sound dead, coin;
    public static BitmapFont font;
    public static Preferences prefs;
    public static ParticleEffect particleEffectAttack;

    public static void load(){
        particleEffectAttack = new ParticleEffect();
        // The first argument tells where the effect data is, the second tells where the base image is
        particleEffectAttack.load(Gdx.files.internal("effects/explosion.p"), Gdx.files.internal("effects"));
        dead = Gdx.audio.newSound(Gdx.files.internal("sounds/dead.wav"));
        font = new BitmapFont(Gdx.files.internal("font/text.fnt"));
        prefs = Gdx.app.getPreferences("MyGame");
        if (!prefs.contains("highScore")) {
            prefs.putInteger("highScore", 0);
        }
    }

    public static void startAttackEffect(float x, float y){
        particleEffectAttack.setPosition(x, y);
        particleEffectAttack.start();
    }

    public static void setHighScore (int val) {
        prefs.putInteger("highScore", val);
        prefs.flush();
    }

    public static int getHighScore ()  {
        return prefs.getInteger("highScore");
    }

    public static void dispose() {
        dead.dispose();
        coin.dispose();
        font.dispose();
        particleEffectAttack.dispose();
    }
}