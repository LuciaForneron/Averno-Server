package com.michidex.avernoserver.elementos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.michidex.avernoserver.utiles.Assets;
import com.michidex.avernoserver.utiles.Render;

public class Animacion{

	float stateTime;
	Texture texturaA;
	private TextureRegion[] framesA;
	private Animation<TextureRegion> animacion;
	private float tiempo = 0.1f;
	private String ruta;
	private float x,y;
	public Animacion(String ruta) {
		texturaA = (Assets.manager.get(ruta,Texture.class));
		TextureRegion[][] tmp = TextureRegion.split(texturaA,texturaA.getWidth() / 10,texturaA.getHeight());
		TextureRegion[] framesA = new TextureRegion[10];
		int index = 0;
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 10; j++) {
				framesA[index++] = tmp[i][j];
				
				if(framesA[i].equals(null)) {
					System.out.println("null");
				}
			}
		}
		
		animacion = new Animation<TextureRegion>(tiempo, framesA);
	}
	
	public void dibujarAnimacion(float x, float y) {
		stateTime += Gdx.graphics.getDeltaTime();
		TextureRegion currentFrame = animacion.getKeyFrame(stateTime, true);
		Render.batch.draw(currentFrame, x, y);
	}
	public Animation<TextureRegion> getAnimacion() {
		return animacion;
	}
}
