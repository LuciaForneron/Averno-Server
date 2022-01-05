package com.michidex.avernoserver.personajes;

import com.michidex.avernoserver.elementos.Animacion;
import com.michidex.avernoserver.utiles.Config;
import com.michidex.avernoserver.utiles.Global;
import com.michidex.avernoserver.utiles.Recursos;

public abstract class Personaje{
	

	protected String nombre;
	protected Animacion[] animaciones;
	protected boolean direccion;
	protected float posicionX =101f;
	
	public Personaje(String nombre,String[]rutaA,int tamaño) {
		animaciones =  new Animacion[tamaño];
		this.nombre=nombre;
		crearAnimaciones(rutaA);
		
	}
	
//	public void dibujar() {
//		sprite.draw(Render.batch);
//	}
	public void crearAnimaciones(String[] rutaA) {
		for (int i = 0; i < animaciones.length; i++) {
			animaciones[i] = new Animacion(rutaA[i]);
		}
	}
	public void caminar(int p) {
		if(p==1) {
				if(Global.d1) {
					animaciones[2].dibujarAnimacion(posicionX, Recursos.ALTURAP);
					if(Config.SALA>posicionX) {
						posicionX += 75*Recursos.VELOCIDAD;
					}
					direccion = true;
				}else if(Global.i1) {
					animaciones[3].dibujarAnimacion(posicionX, Recursos.ALTURAP);
					if((Config.ANCHO-Config.SALA)/2 < posicionX) {
						posicionX -= 75*Recursos.VELOCIDAD;
					}
					direccion = false;
				}else if(direccion){
					animaciones[0].dibujarAnimacion(posicionX, Recursos.ALTURAP);
				}else {
					animaciones[1].dibujarAnimacion(posicionX, Recursos.ALTURAP);
				}
		}else if(p==2) {
				if(Global.d2) {
					animaciones[2].dibujarAnimacion(posicionX, Recursos.ALTURAP);
					if(Config.SALA>posicionX) {
						posicionX += 75*Recursos.VELOCIDAD;
					}
					direccion = true;
				}else if(Global.i2) {
					animaciones[3].dibujarAnimacion(posicionX, Recursos.ALTURAP);
					if((Config.ANCHO-Config.SALA)/2 < posicionX) {
						posicionX -= 75*Recursos.VELOCIDAD;
					}
					direccion = false;
				}else if(direccion){
					animaciones[0].dibujarAnimacion(posicionX, Recursos.ALTURAP);
				}else {
					animaciones[1].dibujarAnimacion(posicionX, Recursos.ALTURAP);
				}
			}
	}
	public float caminarDer() {
		if(Config.SALA>posicionX) {
			posicionX += 75*Recursos.VELOCIDAD;
		}
		direccion = true;
		return posicionX;
	}
	public float caminarIzq() {
		if((Config.ANCHO-Config.SALA)/2 < posicionX) {
			posicionX -= 75*Recursos.VELOCIDAD;
		}
		direccion = false;
		return posicionX;
	}
	
	public boolean parado() {
			return direccion;
	}
	public Animacion[] getAnimaciones() {
		return animaciones;
	}
	public float getPosicionX() {
		return posicionX;
	}
	public void setPosicionX(float posicionX) {
		this.posicionX = posicionX;
	}
	
	
	
}
