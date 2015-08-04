package com.game.Main;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.game.Controllers.WorldController;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Disposable;

public class WorldRender implements Disposable {
    private static final String TAG = WorldRender.class.getName();

    private WorldController worldController;
    private OrthographicCamera camera;
    private Batch batch;
    private Stage activeStage;

    public WorldRender (WorldController worldController) {
        this.worldController = worldController;
        this.batch=worldController.getBatch();
        init();
    }

    public void render () {
        //Gdx.app.log("MyTag", "'render' method started @" + TAG);
        batch.setProjectionMatrix(camera.combined);
        activeStage.draw();
    }

    public void resize (int width, int height) {
        camera.viewportWidth = (GameConstants.VIEWPORT_HEIGHT / height) * width;
        camera.update();
    }

    private void init () {
        camera = new OrthographicCamera(GameConstants.VIEWPORT_WIDTH, GameConstants.VIEWPORT_HEIGHT);
        camera.position.set(0, 0, 0);
        camera.update();
        activeStage = worldController.getActiveStage();
    }

    @Override
    public void dispose () {
        batch.dispose();
    }
}
