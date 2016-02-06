package com.game.android;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Picture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.game.Main.AssetLoader;
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
		/*handler.post(new Runnable() {
			@Override
			public void run() {
				LayoutInflater inflater = getLayoutInflater();

				View layout = inflater.inflate(R.layout.new_character_toast, (ViewGroup) findViewById(R.id.new_character_toast_root));
				//TextView textT = (TextView) layout.findViewById(R.id.toast_text);
				//textT.setText(path);
				ImageView imageView = (ImageView) layout.findViewById(R.id.new_character_toast_imageView);
				TextureRegion textureRegion = AssetLoader.textureAtlas.findRegion(path);
				//SpriteDrawable spriteDrawable = new SpriteDrawable(new Sprite(textureRegion));
				final TextureRegionDrawable textureRegionDrawable = new TextureRegionDrawable(textureRegion);
				Drawable drawable = new Drawable() {
					@Override
					public void draw(Canvas canvas) {
						canvas.drawText("уй",1f,1f,);
					}

					@Override
					public void setAlpha(int alpha) {

					}

					@Override
					public void setColorFilter(ColorFilter cf) {

					}

					@Override
					public int getOpacity() {
						return 0;
					}
				};

				Dr
				imageView.setImageDrawable(drawable);
				imageView.setImageBitmap(Bitmap.createBitmap());
				Toast toast = new Toast(context);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
			}
		});*/
	}
}
