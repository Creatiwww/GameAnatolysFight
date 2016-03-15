package com.game.Main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.Actors.AI.Creators.CreatorAIActor;
import com.game.Actors.AI.Creators.CreatorAIActor1;
import com.game.Actors.AI.Creators.CreatorAIActor2;
import com.game.Actors.AI.Creators.CreatorAIActor3;
import com.game.Actors.AI.Creators.CreatorAIActor4;
import com.game.Actors.AI.Creators.CreatorAIActor5;
import com.game.Actors.AI.Creators.CreatorAIActor6;
import com.game.Actors.AI.Products.AIActor;
import com.game.Actors.Field;
import com.game.Actors.Playable.Creators.CreatorPlayableActor;
import com.game.Actors.Playable.Creators.CreatorPlayableActor1;
import com.game.Actors.Playable.Creators.CreatorPlayableActor2;
import com.game.Actors.Playable.Creators.CreatorPlayableActor3;
import com.game.Actors.Playable.Creators.CreatorPlayableActor4;
import com.game.Actors.Playable.Creators.CreatorPlayableActor5;
import com.game.Actors.Playable.Listeners.PlayableActorsListener;
import com.game.Actors.Playable.Products.PlayableActor;
import com.game.Controllers.ActorsController;
import com.game.Controllers.GameCycle;
import com.game.Controllers.WorldController;

import java.util.ArrayList;
import java.util.Random;

public class AssetLoader {

    public static Sound dead;
    public static Music gameMusic;
    public static BitmapFont font;
    public static TextureRegion startImage, gameOverImage;
    public static Texture infoImage;
    public static Preferences prefs;
    public static ParticleEffect particleEffectAttack;
    public static TextureAtlas textureAtlas;
    public static float scale;
    private static ArrayList musicList;
    private static CreatorPlayableActor creatorPlayableActor1;
    private static CreatorPlayableActor creatorPlayableActor2;
    private static CreatorPlayableActor creatorPlayableActor3;
    private static CreatorPlayableActor creatorPlayableActor4;
    private static CreatorPlayableActor creatorPlayableActor5;
    private static CreatorAIActor creatorAIActor1;
    private static CreatorAIActor creatorAIActor2;
    private static CreatorAIActor creatorAIActor3;
    private static CreatorAIActor creatorAIActor4;
    private static CreatorAIActor creatorAIActor5;
    private static CreatorAIActor creatorAIActor6;

    public static Music getRandomMusic(){
        Random random = new Random();
        int trackId = random.nextInt(musicList.size());
        return (Music) musicList.get(trackId);
    }

    public static void load(){
        Music track1 = Gdx.audio.newMusic(Gdx.files.internal("music/music1.ogg"));
        Music track2 = Gdx.audio.newMusic(Gdx.files.internal("music/music2.ogg"));
        Music track3 = Gdx.audio.newMusic(Gdx.files.internal("music/music3.mp3"));
        Music track4 = Gdx.audio.newMusic(Gdx.files.internal("music/music4.mp3"));
        Music track5 = Gdx.audio.newMusic(Gdx.files.internal("music/music5.mp3"));
        musicList = new ArrayList();
        musicList.add(track1);
        musicList.add(track2);
        musicList.add(track3);
        musicList.add(track4);
        musicList.add(track5);
        gameMusic = getRandomMusic();
        gameMusic.setVolume(0.5f);
        gameMusic.setLooping(true);
        particleEffectAttack = new ParticleEffect();
        textureAtlas = new TextureAtlas(Gdx.files.internal("arts/pack.atlas"));
        // The first argument tells where the effect data is, the second tells where the base image is
        particleEffectAttack.load(Gdx.files.internal("effects/explosion.p"), Gdx.files.internal("effects"));
        dead = Gdx.audio.newSound(Gdx.files.internal("sounds/dead.wav"));
        font = new BitmapFont(Gdx.files.internal("font/font.fnt"));
        float DISPLAY_WITH_BASELINE = 1080;
        float displayWith = Gdx.graphics.getWidth();
        scale =  displayWith / DISPLAY_WITH_BASELINE;
        font.getData().setScale(scale);
        Random random = new Random();
        switch (random.nextInt(8)){
            case 0 : startImage = textureAtlas.findRegion("granny");
                break;
            case 1 : startImage = textureAtlas.findRegion("oldMan");
                break;
            case 2 : startImage = textureAtlas.findRegion("newborn");
                break;
            case 3 : startImage = textureAtlas.findRegion("youngWoman");
                break;
            case 4 : startImage = textureAtlas.findRegion("youngMan");
                break;
            case 5 : startImage = textureAtlas.findRegion("milkshake");
                break;
            case 6 : startImage = textureAtlas.findRegion("hotDog");
                break;
            case 7 : startImage = textureAtlas.findRegion("hamburger");
                break;
        }

        gameOverImage = textureAtlas.findRegion("gameOverPic");
        infoImage = new Texture(Gdx.files.internal("arts/helpScreen.png"));
        prefs = Gdx.app.getPreferences("MyGame");
        if (prefs.contains("isFirstGameRun")) {
            prefs.putBoolean("isFirstGameRun", false);
        }else {
            prefs.putBoolean("isFirstGameRun", true);
        }
        if (!prefs.contains("highScore")) {
            prefs.putInteger("highScore", 0);
        }
        creatorPlayableActor1 = new CreatorPlayableActor1();
        creatorPlayableActor2 = new CreatorPlayableActor2();
        creatorPlayableActor3 = new CreatorPlayableActor3();
        creatorPlayableActor4 = new CreatorPlayableActor4();
        creatorPlayableActor5 = new CreatorPlayableActor5();
        creatorAIActor1 = new CreatorAIActor1();
        creatorAIActor2 = new CreatorAIActor2();
        creatorAIActor3 = new CreatorAIActor3();
        creatorAIActor4 = new CreatorAIActor4();
        creatorAIActor5 = new CreatorAIActor5();
        creatorAIActor6 = new CreatorAIActor6();
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

    public static void saveGame  (Field field, int score, GameCycle gameCycle, WorldController worldController) {
        ArrayList <String> actorHP = new ArrayList<String>();
        ArrayList <String> actorOwner = new ArrayList<String>();
        ArrayList <String> actorGender = new ArrayList<String>();
        ArrayList <String> actorReproductionPause = new ArrayList<String>();
        ArrayList <String> actorAge = new ArrayList<String>();
        ArrayList <String> actorAIType = new ArrayList<String>();
        ArrayList <String> actorTexturePath = new ArrayList<String>();
        for (int i=0; i<field.getCoordinates().getFieldSize();i++){
            Field.Cell cell =  field.getCellByIndex(i);
            actorHP.add(String.valueOf(cell.getCellActorHP()));
            actorOwner.add(String.valueOf(cell.getCellActorOwner()));
            String gender = "-1";
            String reprodactionPause = "-1";
            String age = "-1";
            String aiType = "-1";
            String texturePath = "-1";
            if (cell.getActorRef() != null) {
                texturePath=cell.getActorRef().getTexturePath();
                if (cell.getActorRef().isOwnedByPlayer()) {
                    PlayableActor playableActor = (PlayableActor) cell.getActorRef();
                    if (playableActor.isFemale()) gender = "f";
                    if (playableActor.isMan()) gender = "m";
                    reprodactionPause = String.valueOf(playableActor.getReproductionPause());
                    age = String.valueOf(playableActor.getAge());
                } else {
                    AIActor aiActor = (AIActor) cell.getActorRef();
                    aiType = aiActor.getAiType();
                }
            }
            actorGender.add(gender);
            actorReproductionPause.add(reprodactionPause);
            actorAge.add(age);
            actorAIType.add(aiType);
            actorTexturePath.add(texturePath);
        }
        for (int i=0; i<actorAge.size(); i++){
            prefs.putString("cell"+i+"hp", actorHP.get(i));
            prefs.putString("cell"+i+"owner", actorOwner.get(i));
            prefs.putString("cell"+i+"gender", actorGender.get(i));
            prefs.putString("cell"+i+"reprodactionPause", actorReproductionPause.get(i));
            prefs.putString("cell"+i+"age", actorAge.get(i));
            prefs.putString("cell"+i+"aiType", actorAIType.get(i));
            prefs.putString("cell"+i+"texturePath", actorTexturePath.get(i));
        }
        String strScore =String.valueOf(score);
        prefs.putString("score", strScore);
        prefs.putString("gameState", gameCycle.getGameState());
        prefs.putString("enemyWave", String.valueOf(worldController.getEnemyWave().getWaveNumber() ));
        prefs.flush();
        actorHP.clear();
        actorOwner.clear();
        actorGender.clear();
        actorReproductionPause.clear();
        actorAge.clear();
        actorAIType.clear();
    }

    public static void restoreGame (Field field, ActorsController actorsController, GameCycle gameCycle)  {
        int score = Integer.parseInt(prefs.getString("score"));
        actorsController.getWorldController().addScore(score);
        Field.Cell cell;
        String actorOwner;
        for(int i=0; i<field.getCoordinates().getFieldSize(); i++){
            cell = field.getCellByIndex(i);
            actorOwner = prefs.getString("cell" + i + "owner");
            if (!actorOwner.equals("-1")) {
                int actorAge = Integer.parseInt(prefs.getString("cell" + i + "age"));
                double actorHP = Double.parseDouble(prefs.getString("cell" + i + "hp"));
                String actorGender = prefs.getString("cell" + i + "gender");
                int actorReproductionPause = Integer.parseInt(prefs.getString("cell" + i + "reprodactionPause"));
                String aiActorType = prefs.getString("cell" + i + "aiType");
                String texturePath = prefs.getString("cell" + i + "texturePath");
                if (actorOwner.equals("Playable")){
                    if (actorAge<PlayableActor.YOUNG_START_AGE) {
                        actorsController.getActors().add(creatorPlayableActor5.factoryMethod(texturePath));
                    }
                    if (actorAge>PlayableActor.YOUNG_START_AGE-1 && actorAge<PlayableActor.OLD_START_AGE){
                        if (actorGender.equals("m")){
                            actorsController.getActors().add(creatorPlayableActor2.factoryMethod(texturePath));
                        }else{
                            actorsController.getActors().add(creatorPlayableActor1.factoryMethod(texturePath));
                        }
                    }
                    if (actorAge>PlayableActor.OLD_START_AGE-1){
                        if (actorGender.equals("m")){
                            actorsController.getActors().add(creatorPlayableActor4.factoryMethod(texturePath));
                        }else{
                            actorsController.getActors().add(creatorPlayableActor3.factoryMethod(texturePath));
                        }
                    }
                    int ind = actorsController.getActors().size();
                    PlayableActor actor = (PlayableActor) actorsController.getActors().get(ind - 1);
                    float actorSize = field.getCellWidth() * (1 - (float) actorsController.getActorSizeModificator());
                    actor.setSize(actorSize, actorSize);
                    cell.setActorRef(actor);
                    actor.getPosition().cellIndexX = cell.getIndexX();
                    actor.getPosition().cellIndexY = cell.getIndexY();
                    actor.setPosition(cell.getcX() - actor.getWidth() / 2, cell.getcY() - actor.getHeight() / 2);
                    actor.addListener(new PlayableActorsListener(actor, actorsController.getWorldController()));
                    actor.setHP(actorHP);
                    actor.setAge(actorAge);
                    actor.setReproductionPause(actorReproductionPause);

                } else {
                    if (aiActorType.equals("hamburger")){
                        actorsController.getActors().add(creatorAIActor1.factoryMethod(texturePath));
                    }
                    if (aiActorType.equals("hotdog")){
                        actorsController.getActors().add(creatorAIActor2.factoryMethod(texturePath));
                    }
                    if (aiActorType.equals("milkshake")){
                        actorsController.getActors().add(creatorAIActor3.factoryMethod(texturePath));
                    }
                    if (aiActorType.equals("shawarma")){
                        actorsController.getActors().add(creatorAIActor4.factoryMethod(texturePath));
                    }
                    if (aiActorType.equals("cola")){
                        actorsController.getActors().add(creatorAIActor5.factoryMethod(texturePath));
                    }
                    if (aiActorType.equals("soda")){
                        actorsController.getActors().add(creatorAIActor6.factoryMethod(texturePath));
                    }
                    int ind = actorsController.getActors().size();
                    AIActor actor = (AIActor) actorsController.getActors().get(ind - 1);
                    float actorSize = field.getCellWidth() * (1 - (float) actorsController.getActorSizeModificator());
                    actor.setSize(actorSize, actorSize);
                    cell.setActorRef(actor);
                    actor.getPosition().cellIndexX = cell.getIndexX();
                    actor.getPosition().cellIndexY = cell.getIndexY();
                    actor.setPosition(cell.getcX() - actor.getWidth() / 2, cell.getcY() - actor.getHeight() / 2);
                    actor.setHP(actorHP);
                }
            } else {
                cell.setActorRef(null);
            }
        }
        gameCycle.setGameState(prefs.getString("gameState"));
        actorsController.getWorldController().getEnemyWave().setWaveNumber(Integer.parseInt(prefs.getString("enemyWave")));
    }

    public static boolean isFirstGameRun(){
        if (prefs.contains("isFirstGameRun")){
            return prefs.getBoolean("isFirstGameRun");
        } else {
            return true;
        }
    }

    public static void clearPrefs(){
        Integer hScore = prefs.getInteger("highScore");
        prefs.clear();
        prefs.remove("isFirstGameRun");
        prefs.putInteger("highScore", hScore);
        prefs.flush();
    }

    public static void dispose() {
        dead.dispose();
        font.dispose();
        particleEffectAttack.dispose();
        textureAtlas.dispose();
        gameMusic.dispose();
    }
}