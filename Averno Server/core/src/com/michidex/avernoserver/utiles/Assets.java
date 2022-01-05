package com.michidex.avernoserver.utiles;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
	public static final AssetManager manager = new AssetManager();	
		
		public static void load() {
			for (int i = 0; i < Recursos.ANIMACIONESE.length; i++) {
				manager.load(Recursos.ANIMACIONESE[i], Texture.class);
			}for (int i = 0; i < Recursos.ANIMACIONESM.length; i++) {
				manager.load(Recursos.ANIMACIONESM[i], Texture.class);
			}for (int i = 0; i < Recursos.ANIMACIONESMONS.length; i++) {
				manager.load(Recursos.ANIMACIONESMONS[i], Texture.class);
			}
			
		}
}
