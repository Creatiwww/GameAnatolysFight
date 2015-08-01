package com.game.Main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.game.Controllers.WorldController;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public class WorldRender implements Disposable {
    private static final String TAG = WorldRender.class.getName();

    private WorldController worldController;
    private OrthographicCamera camera;
    private SpriteBatch batch;

    public WorldRender (WorldController worldController) {
        this.worldController = worldController;
        init();
    }

    public void render () {
        //Gdx.app.log("MyTag", "'render' method started @" + TAG);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for(Sprite sprite : worldController.getSprites()){
            //Gdx.app.log("MyTag", "'render' method, sprite.draw(bach) started @" + TAG);
            sprite.draw(batch);
            //Gdx.app.log("MyTag", "'render' method, sprite.draw(bach) ended @" + TAG);
        }
        batch.end();
        //Gdx.app.log("MyTag", "'render' method ended @" + TAG);
    }

    public void resize (int width, int height) {
        camera.viewportWidth = (GameConstants.VIEWPORT_HEIGHT / height) * width;
        camera.update();
    }

    private void init () {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(GameConstants.VIEWPORT_WIDTH, GameConstants.VIEWPORT_HEIGHT);
        camera.position.set(0, 0, 0);
        camera.update();
    }

    @Override
    public void dispose () {
        batch.dispose();
    }
}
