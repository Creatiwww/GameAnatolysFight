package com.game.Main;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.game.Controllers.WorldController;

public class Main extends ApplicationAdapter {
	private static final String TAG = Main.class.getName();

	private WorldRender worldRender;
	private WorldController worldController;
	private AssetsManager assetsManager;
	private boolean paused;

	@Override
	public void create () {
		//TODO: don't forget to change log level before publishing
		Gdx.app.setLogLevel(Application.LOG_DEBUG); // Set Libgdx log level to DEBUG
		//Gdx.app.log("MyTag", "'create' method started @"+TAG);
		worldController = new WorldController();
		worldRender = new WorldRender(worldController);
		paused = false; // Game world is active on start
		//Gdx.app.log("MyTag", "'create' method ended @"+TAG);
	}

	@Override
	public void render () {
		//Gdx.app.log("MyTag", "'render' method started @"+TAG);
		// Do not update game world when paused
		if (!paused) {
			worldController.update(Gdx.graphics.getDeltaTime());  // update game world
		}
		// Sets the clear screen color to:  wight
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clears the screen
		worldRender.render(); // Render game world to screen
		//Gdx.app.log("MyTag", "'render' method ended @" + TAG);

	}

	@Override
	public void resize (int width, int height) {
		//Gdx.app.log("MyTag", "'resize' method started @"+TAG);
		worldRender.resize(width, height);
		//Gdx.app.log("MyTag", "'resize' method ended @" + TAG);
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
