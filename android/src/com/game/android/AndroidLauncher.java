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
import com.game.UI.GetAndroidResInterface;
import com.game.UI.NotificationsInterface;

public class AndroidLauncher extends AndroidApplication implements NotificationsInterface, GetAndroidResInterface {
	final AndroidLauncher context = this;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new Main(this, this), config);
	}
	@Override
	public String getStrLevel (){
		return getResources().getString(R.string.level);
	}

	@Override
	public String getStrRecord (){
		return getResources().getString(R.string.record);
	}

	@Override
	public String getStrScore (){
		return getResources().getString(R.string.score);
	}

	@Override
	public String getStrAllUnitsScreenLabel (){
		return getResources().getString(R.string.all_units_screen_label);
	}

	@Override
	public String getStrInfoScreenLabel (){
		return getResources().getString(R.string.info_screen_label);
	}

	@Override
	public void toastText(final String text) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				LayoutInflater inflater = getLayoutInflater();

				View layout = inflater.inflate(R.layout.next_level_toast, (ViewGroup) findViewById(R.id.next_level_toast_root));
				TextView textT = (TextView) layout.findViewById(R.id.toast_text);
				textT.setText(text);
				Toast toast = new Toast(context);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
			}
		});
	}

	@Override
	public void toastPicture(final String path) {

	}
}
