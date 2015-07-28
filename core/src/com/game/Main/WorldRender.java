package com.game.Main;

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

    // constructor
    public WorldRender (WorldController worldController) {
        this.worldController = worldController;
        init();
    }
    public void render () {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for(Sprite sprite : worldController.getSprites()) sprite.draw(batch);
        batch.end();
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
