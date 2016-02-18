package com.game.Main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.game.Controllers.WorldController;
import com.game.Screens.MyScreen;
import com.game.UI.GetAndroidResInterface;
import com.game.UI.NotificationsInterface;

public class Main extends Game {

	private boolean paused;
	private NotificationsInterface notificationsInterface;
	private GetAndroidResInterface getAndroidResInterface;

	public Main(NotificationsInterface notificationsInterface, GetAndroidResInterface getAndroidResInterface){
		this.notificationsInterface = notificationsInterface;
		this.getAndroidResInterface = getAndroidResInterface;
	}

	@Override
	public void create () {
		WorldController worldController = new WorldController(notificationsInterface, getAndroidResInterface, this);
		paused = false; // Game world is active on start
		setScreen(worldController.getScreen());
	}

	public void setRenderedScreen(MyScreen screen){
		setScreen(screen);
	}

	@Override
	public void render () {
		// Do not update game world when paused
		if (!paused) {
			// Sets the clear screen color
			Gdx.gl.glClearColor(255.0f, 255.0f, 255.0f, 1.0f);
			//Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clears the screen
			super.render();
		}
	}

	@Override
	public void resize (int width, int height) {
		super.resize(width, height);
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
