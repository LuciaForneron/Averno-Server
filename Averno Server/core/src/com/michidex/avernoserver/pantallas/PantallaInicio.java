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

public class PantallaInicio implements Screen {

	private Imagen logo;
	private SpriteBatch b;
	private Texto saltear;
	private float a;
	private boolean fadeTerminado;
	private float tiempo,tiempoEspera=2;
	private float tiempoAuTermina, tiempoEspTermina = 2;
	private boolean termina;
	private Entradas entradas = new Entradas();
	@Override
	public void show() {
		b = Render.batch;
		logo = new Imagen(Recursos.INICIO);
		logo.setTransparencia(a);
		Gdx.input.setInputProcessor(entradas);
		logo.setPosicion((Config.ANCHO/2)-(logo.getAncho()/2),(Config.ALTO/2)-(logo.getAltura()/2));
		System.out.println((Config.ALTO/2)-(logo.getAltura()/2));
		System.out.println((Config.ANCHO/2)-(logo.getAncho()/2));
		saltear = new Texto(Recursos.FUENTEMENU,20,Color.WHITE,true,"Presione F para saltear");
		saltear.setPosicion((Config.ANCHO/2)+(saltear.getAncho()/2), 100);
	}

	@Override
	public void render(float delta) {
		
		b.begin();
			logo.dibujar();
			saltear.dibujar();
		b.end();

		procesarFade(tiempo);
		tiempo+=delta;
		
		if(entradas.isF()) {
			Render.averno.setScreen(new PantallaMenu());
		}
		
		
	}
	public void procesarFade(float tiempo) {
		if(!fadeTerminado) {
			a+=0.01f;
			if(a > 1) {
				a=1;
				fadeTerminado = true;
			}
		} else {
			if(tiempo>tiempoEspera) {
				a-=0.01f;
				if(a < 0) {
					a=0;
					termina = true;
				}
			}
		}
		logo.setTransparencia(a);
		if(termina) {
			tiempoAuTermina +=0.01f;
			if(tiempoAuTermina>tiempoEspTermina) {
				Render.averno.setScreen(new PantallaMenu());
			}
		}
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
