package com.michidex.avernoserver.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.michidex.avernoserver.utiles.*;
import com.michidex.avernoserver.elementos.Imagen;
import com.michidex.avernoserver.elementos.Texto;
import com.michidex.avernoserver.io.Entradas;
import com.michidex.avernoserver.utiles.Recursos;
import com.michidex.avernoserver.utiles.Render;
import com.michidex.avernoserver.utiles.*;

public class PantallaElegir implements Screen {

	Imagen elegir,espera;
	Texto marisaN,enzoN;
	private int opc=1;
	private float tiempo = 0;
	Entradas entradas = new Entradas();;
	SpriteBatch b;
	String[] rutas = new String[] {"Imagenes/Elegir Enzo.png","Imagenes/Elegir Marisa.png","Personajes/Parado izquierda Marisa2.png","Personajes/Parado izquierda Enzo2.png"};
	Imagen[] imgs = new Imagen[4];
	
	@Override
	public void show() {
		b = Render.batch;
		Gdx.input.setInputProcessor(entradas);
		for (int i = 0; i < imgs.length; i++) {
			imgs[i]=new Imagen(rutas[i]);
		}
		espera = new Imagen("Imagenes/hell.png");
		espera.setPosicion(0, 0);
		imgs[0].setPosicion((Config.ANCHO/2)-(imgs[0].getAncho()),0);	
		imgs[1].setPosicion((Config.ANCHO/2), 0);
		imgs[2].setPosicion((Config.ANCHO/2)+(imgs[1].getAncho()/2)-(imgs[2].getAncho()/2), (Config.ALTO/2)-(imgs[2].getAltura()/2));
		imgs[3].setPosicion((Config.ANCHO/2)-(imgs[0].getAncho()/2)-(imgs[3].getAncho()/2), (Config.ALTO/2)-(imgs[3].getAltura()/2));
		marisaN = new Texto(Recursos.FUENTEMENU,40,new Color((229f/255f),(96f/255f),0,1),true,"Marisa");
		marisaN.setPosicion((Config.ANCHO/2)+(imgs[1].getAncho()/2)-(marisaN.getAncho()/2), 70);
		enzoN = new Texto(Recursos.FUENTEMENU,40,new Color((47f/255f),(47f/255f),(121f/255f),1),true,"Enzo");
		enzoN.setPosicion((Config.ANCHO/2)-(imgs[0].getAncho()/2)-(enzoN.getAncho()/2), 70);
		elegir = new Imagen("Imagenes/ElegirChose.png");
	}

	@Override
	public void render(float delta) {

		Render.limpiarPantalla(0, 0, 0);
		b.begin();
		if(!Config.empieza){
			
			espera.dibujar();
		}else {
			
			Render.limpiarPantalla(0, 0, 0);
			for (int i = 0; i < imgs.length; i++) {
				imgs[i].dibujar();
			}
			marisaN.dibujar();
			enzoN.dibujar();
		
		
		tiempo+=delta;
		
		if(entradas.isFIzq()||entradas.isFDer()){
			if(tiempo>0.18f) {
				tiempo=0;
				opc++;
				if (opc>2) {
					opc=1;
				}
			}
		}
		elegir.dibujar();
		
		if(opc==1) {
			elegir.setPosicion((Config.ANCHO/2)-(imgs[0].getAncho()),0);
			enzoN.setColor(Color.WHITE);
			marisaN.setColor(new Color((229f/255f),(96f/255f),0,1));
			if(entradas.isEnter()) {
				Render.averno.setScreen(new SalaUno());
				Config.personaje = true;
			}
		}else {
			elegir.setPosicion((Config.ANCHO/2), 0);
			marisaN.setColor(Color.WHITE);
			enzoN.setColor(new Color((47f/255f),(47f/255f),(121f/255f),1));
			if(entradas.isEnter()) {
				Render.averno.setScreen(new SalaUno());
				Config.personaje = false;
			}
		}
		
	

		}	
		b.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
