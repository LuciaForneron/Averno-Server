package com.michidex.avernoserver.personajes;

import com.michidex.avernoserver.utiles.Recursos;
import com.michidex.avernoserver.utiles.Render;

public class Monstruo extends Personaje{
	
	private boolean ataque;
	private float tiempo;
	private boolean bandera;
	public Monstruo() {
		super("Monstruo", Recursos.ANIMACIONESMONS,Recursos.ANIMACIONESMONS.length);
		
	}
public void caminarMons(Personaje p, boolean estado,float delta,float x,float puerta) {
		tiempo+=delta;
		//Si es el ataque tengo que sumarle 153 porque el sprite del ataque es muy ancho y causa problemas, lo mismo con los otros
		// si la posicion en si p.x es mayor a m.x camina a la derecha ó p.x mayor a la mA.x+153 y ataque true
		if(p.getPosicionX()>(posicionX+this.animaciones[0].getAnimacion().getKeyFrame(0).getRegionWidth()/2)&&!estado||(p.getPosicionX()>(this.posicionX+153f))&&ataque&&!estado) {
			this.animaciones[2].dibujarAnimacion(this.posicionX, Recursos.ALTURAP);
			posicionX+=60*Recursos.VELOCIDAD;
			Render.averno.getServidor().enviarATodos("Mons"+"!"+"Der"+"!"+posicionX);
			ataque = false;
		} 
		else if(p.getPosicionX()<(posicionX+this.animaciones[0].getAnimacion().getKeyFrame(0).getRegionWidth()/2)&&!estado||(p.getPosicionX()<(this.posicionX-(this.animaciones[0].getAnimacion().getKeyFrame(0).getRegionWidth()/2)-149f))&&ataque&&!estado) {
			this.animaciones[3].dibujarAnimacion(this.posicionX, Recursos.ALTURAP);
			posicionX-=60*Recursos.VELOCIDAD;
			Render.averno.getServidor().enviarATodos("Mons"+"!"+"Izq"+"!"+posicionX);
			ataque = false;
		}
		 if((posicionX+this.animaciones[0].getAnimacion().getKeyFrame(0).getRegionWidth()/2)==p.getPosicionX()&&!estado||this.posicionX==(p.getPosicionX()+p.getAnimaciones()[0].getAnimacion().getKeyFrame(0).getRegionWidth()/2)&&!estado||p.getPosicionX()<(posicionX-(this.animaciones[0].getAnimacion().getKeyFrame(0).getRegionWidth())-149f)&&ataque&&tiempo==10&&!estado||(p.getPosicionX()>(posicionX+153f))&&ataque&&tiempo==10&&!estado) {
			this.animaciones[4].dibujarAnimacion(this.posicionX,Recursos.ALTURAP);
			Recursos.VELOCIDAD=0.025f;
			ataque = true;
			Render.averno.getServidor().enviarATodos("Mons"+"!"+"Ataque"+"!"+posicionX);
			
		}
		if(estado) {
			if(this.posicionX==x&&!bandera||this.posicionX<x&&this.posicionX!=puerta&&!bandera||posicionX>puerta&&!bandera) {
				this.animaciones[3].dibujarAnimacion(this.posicionX, Recursos.ALTURAP);
				posicionX-=60*Recursos.VELOCIDAD;
				Render.averno.getServidor().enviarATodos("Mons"+"!"+"AdentroDer"+"!"+posicionX);
			}if(posicionX==puerta) {
				bandera=true;
				Render.averno.getServidor().enviarATodos("Mons"+"!"+"Desaparece");
			}else if(posicionX==puerta){
				this.animaciones[2].dibujarAnimacion(this.posicionX, Recursos.ALTURAP);
				posicionX+=60*Recursos.VELOCIDAD;
				Render.averno.getServidor().enviarATodos("Mons"+"!"+"AdentroIzq"+"!"+posicionX);
			}
		}
	}
	public boolean isBandera() {
		return bandera;
	}
}
