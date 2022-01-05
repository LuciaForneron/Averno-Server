package com.michidex.avernoserver;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.michidex.avernoserver.pantallas.PantallaElegir;
import com.michidex.avernoserver.pantallas.PantallaInicio;
import com.michidex.avernoserver.pantallas.SalaDos;
import com.michidex.avernoserver.pantallas.SalaUno;
import com.michidex.avernoserver.pantallas.SalaUnoDos;
import com.michidex.avernoserver.red.HiloServidor;
import com.michidex.avernoserver.utiles.Assets;
import com.michidex.avernoserver.utiles.Render;

public class AvernoServer extends Game {
	private HiloServidor servidor;
	private boolean elegir,uno,unoDos,dos;
	private PantallaElegir ele;
	private SalaUno s1;
	private SalaUnoDos s12;
	private SalaDos s2;
	@Override
	public void create () {
		Assets.load();
		Assets.manager.finishLoading();
		Render.averno = this;
		Render.batch = new SpriteBatch();
		this.setScreen(new PantallaInicio());
		servidor = new HiloServidor();
		servidor.start();
	}

	@Override
	public void render () {
		super.render();
		if(elegir) {
			elegir();
		}if(uno) {
			salaUno();
		}if(unoDos) {
			salaUnoDos();
		}if(dos) {
			salaDos();
		}
	}
	
	@Override
	public void dispose () {
		servidor=null;
		Render.batch.dispose();
	}
	public HiloServidor getServidor() {
		return servidor;
	}
	public void elegir() {
		screen.dispose();
		this.setScreen(ele = new PantallaElegir());
		elegir=false;
		super.render();
	}
	public void salaUno() {
		screen.dispose();
		this.setScreen(s1 = new SalaUno());
		uno=false;
		super.render();
	}
	public void salaUnoDos() {
		screen.dispose();
		this.setScreen(s12 = new SalaUnoDos());
		unoDos=false;
		super.render();
	}
	public void salaDos() {
		screen.dispose();
		this.setScreen(s2 = new SalaDos());
		dos=false;
		super.render();
	}
	public void setDos(boolean dos) {
		this.dos = dos;
	}public void setUno(boolean uno) {
		this.uno = uno;
	}public void setUnoDos(boolean unoDos) {
		this.unoDos = unoDos;
	}public void setElegir(boolean elegir) {
		this.elegir = elegir;
	}
}
