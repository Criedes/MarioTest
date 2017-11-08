package com.gxiv.mario.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gxiv.mario.MarioBros;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//		config.title = "Title";
//		config.useGL30 = true;
//		config.height = 480;
//		config.width = 800;
		new LwjglApplication(new MarioBros(), config);
	}
}
