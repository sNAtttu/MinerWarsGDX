package com.minerwars.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.minerwars.game.MinerWars;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "MinerWars";
		config.width = 800;
		config.height = 600;
		new LwjglApplication(new MinerWars(), config);
	}
}
