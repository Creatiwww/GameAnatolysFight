package com.game.Main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class AssetLoader {

    public static Sound dead, coin;
    public static BitmapFont font;
    public static Preferences prefs;

    public static void load(){
        dead = Gdx.audio.newSound(Gdx.files.internal("sounds/dead.wav"));
        font = new BitmapFont(Gdx.files.internal("font/text.fnt"));
        prefs = Gdx.app.getPreferences("MyGame");
        if (!prefs.contains("highScore")) {
            prefs.putInteger("highScore", 0);
        }
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
    }
}