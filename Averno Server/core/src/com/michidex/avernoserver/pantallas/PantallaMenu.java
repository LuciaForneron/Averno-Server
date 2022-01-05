package com.michidex.avernoserver.pantallas;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.michidex.avernoserver.elementos.Imagen;
import com.michidex.avernoserver.elementos.Texto;
import com.michidex.avernoserver.io.Entradas;
import com.michidex.avernoserver.utiles.Config;
import com.michidex.avernoserver.utiles.Recursos;
import com.michidex.avernoserver.utiles.Render;

	public class PantallaMenu implements Screen {
		
		Imagen fondo,espera;
		Texto averno;
		Texto[] opciones = new Texto[4];
		String[] textos = new String[] {"Comenzar","Multijugador","Opciones","Salir"};
		SpriteBatch b;
		Entradas entradas = new Entradas();
		private int opc = 1;
		public float tiempo = 0;
		public boolean flag;
		@Override
		public void show() {
			b = Render.batch;
			fondo = new Imagen(Recursos.FONDO);
			
			Gdx.input.setInputProcessor(entradas);
			espera = new Imagen("Imagenes/hell.png");
			espera.setPosicion(100, 0);
			averno = new Texto(Recursos.FUENTEAVERNO,120,Recursos.COLORMENU,true,"Averno");
			averno.setPosicion((Config.ANCHO/2)-(averno.getAncho()/2), 500);
			
			int espacio = 20;
			
			for (int i = 0; i < opciones.length; i++) {
				opciones[i] = new Texto(Recursos.FUENTEMENU,45,Recursos.COLORMENU,true,textos[i]);
				opciones[i].setPosicion((Config.ANCHO/2)-(opciones[i].getAncho()/2),(Config.ALTO/2)+(opciones[0].getAlto()/2)-((opciones[i].getAlto()*i)+(espacio*i)));
			}
				
		}

		@Override
		public void render(float delta) {
			Render.limpiarPantalla(86,77,60);
			b.begin();
			
				fondo.dibujar();
				averno.dibujar();
				for (int i = 0; i < opciones.length; i++) {
					opciones[i].dibujar();
				}
			
			if(Config.empieza) {
				Render.averno.setElegir(true);
			}else if(!Config.empieza&&flag){
				Render.limpiarPantalla(0,0,0);
				espera.dibujar();
			}
			b.end();
			tiempo+=delta;
			if(entradas.isAbajo()) {
				if(tiempo>0.1f) {
					tiempo=0;
					opc++;
					if (opc>4){
						opc=1;
					}
				}
			}
			if(entradas.isArriba()) {
				if(tiempo>0.1f) {
					tiempo=0;
					opc--;
					if (opc<1){
						opc=4;
					}
				}
			}
			
			
			for (int i = 0; i < opciones.length; i++) {
				if(i==(opc-1)) {
					opciones[i].setColor(Color.WHITE);
				}else {
					opciones[i].setColor(Recursos.COLORMENU);
				}
			}
//			if(entradas.isEnter()){
//				if(opc==2) {
//					Render.averno.setUno(true);
//				}
//			}
			
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
//			Render.batch.dispose();
		}

	}
