package com.michidex.avernoserver.pantallas;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.michidex.avernoserver.elementos.Imagen;
import com.michidex.avernoserver.utiles.Render;

public class SalaDos implements Screen{

	SpriteBatch b;
	Imagen fondo;
	
	@Override
	public void show() {
		b = Render.batch;
		fondo = new Imagen("Salas/Sala 2.png");
		fondo.setPosicion(100, 0);
		
	}

	@Override
	public void render(float delta) {
		Render.limpiarPantalla(1,1,1);
		b.begin();
			fondo.dibujar();
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
