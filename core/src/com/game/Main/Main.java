package com.game.Main;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.game.Controllers.AIController;
import com.game.Controllers.WorldController;

public class Main extends ApplicationAdapter {
	private static final String TAG = Main.class.getName();

	private WorldRender worldRender;
	private WorldController worldController;
	private AssetsManager assetsManager;
	private boolean paused;

	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG); // Set Libgdx log level to DEBUG
		worldController = new WorldController();
		worldRender = new WorldRender(worldController);
		paused = false; // Game world is active on start
	}

	@Override
	public void render () {
		// Do not update game world when paused.
		if (!paused) {
			worldController.update(Gdx.graphics.getDeltaTime());
		}
		// Sets the clear screen color to: Cornflower Blue
		Gdx.gl.glClearColor(0x64/255.0f, 0x95/255.0f, 0xed/255.0f, 0xff/255.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clears the screen
		worldRender.render(); // Render game world to screen
	}

	@Override
	public void resize (int width, int height) {
		worldRender.resize(width, height);
	}

	@Override
	public void pause () {
		paused = true;
	}

	@Override
	public void resume () {
		paused = false;
	}

	@Override
	public void dispose () {
		worldRender.dispose();
	}
}
