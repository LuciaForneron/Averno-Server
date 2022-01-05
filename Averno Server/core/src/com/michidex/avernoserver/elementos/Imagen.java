package com.michidex.avernoserver.elementos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.michidex.avernoserver.utiles.Render;

public class Imagen {

	Texture t;
	Sprite s;
	public Imagen(String ruta) {
		t = new Texture(ruta);
		s = new Sprite(t);
	}
	public void setPosicion(float x, float y) {
		s.setX(x);
		s.setY(y);
	}
	public void setTransparencia(float a) {
		s.setAlpha(a);
	}
	public float getAltura() {
		return s.getHeight();
	}
	public float getAncho() {
		return s.getWidth();
	}
	public float getX() {
		return s.getX();
	}
	public float getY() {
		return s.getY();
	}
	public void dibujar() {
		s.draw(Render.batch);
	}
}
