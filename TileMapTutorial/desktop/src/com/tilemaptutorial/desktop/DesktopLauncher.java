package com.tilemaptutorial.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tilemaptutorial.TileTutorial;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "TiledMapGame";
		config.useGL30 = true;
		config.width = 1280;
		config.height = 512;
		new LwjglApplication(new TileTutorial(), config);
	}
}
