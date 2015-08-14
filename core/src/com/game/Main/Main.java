package com.game.Main;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.game.Controllers.WorldController;

public class Main extends Game {
	private static final String TAG = Main.class.getName();

	private WorldController worldController;
	private AssetsManager assetsManager;
	private boolean paused;

	@Override
	public void create () {
		//TODO: don't forget to change log level before publishing
		Gdx.app.setLogLevel(Application.LOG_DEBUG); // Set Libgdx log level to DEBUG

		//Gdx.app.log("MyTag", "'create' method started @"+TAG);
		worldController = new WorldController();
		paused = false; // Game world is active on start
		setScreen(worldController.getScreen());
		//Gdx.app.log("MyTag", "'create' method ended @"+TAG);
	}

	@Override
	public void render () {
		//Gdx.app.log("MyTag", "'render' method started @"+TAG);
		// Do not update game world when paused
		if (!paused) {
			// Sets the clear screen color
			Gdx.gl.glClearColor(255.0f, 255.0f, 255.0f, 1.0f);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clears the screen
			super.render();
			//Gdx.app.log("MyTag", "'render' method ended @" + TAG);
		}
	}

	@Override
	public void resize (int width, int height) {
		//Gdx.app.log("MyTag", "'resize' method started @"+TAG);
		super.resize(width, height);
		//Gdx.app.log("MyTag", "'resize' method ended @" + TAG);
	}

	@Override
	public void pause () {
		paused = true;
		super.pause();
	}

	@Override
	public void resume () {
		paused = false;
		super.resume();
	}

	@Override
	public void dispose () {
		super.dispose();
	}
}
