package com.game.android;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.game.Main.Main;
import com.game.UI.NotificationsInterface;

public class AndroidLauncher extends AndroidApplication implements NotificationsInterface {

	final AndroidLauncher context = this;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new Main(this), config);
	}

	@Override
	public void toast(final String text) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				LayoutInflater inflater = getLayoutInflater();
				View layout = inflater.inflate(R.layout.next_level_toast, (ViewGroup) findViewById(R.id.next_level_toast_root));
				TextView textT = (TextView) layout.findViewById(R.id.toast_text);
				textT.setText(text);
				Toast toast = new Toast(context);
				//Toast toast=Toast.makeText(context, text, Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);

				toast.show();
				//Toast.makeText(context, text, Toast.LENGTH_SHORT).show();

			}
		});
	}
}
