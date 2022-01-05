package com.michidex.avernoserver.desktop;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.michidex.avernoserver.AvernoServer;
import com.michidex.avernoserver.utiles.Config;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height=Config.ALTO;
		config.width=Config.ANCHO;
		new LwjglApplication(new AvernoServer(), config);
	}
}
