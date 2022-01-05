package com.michidex.avernoserver.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.michidex.avernoserver.elementos.Acotacion;
import com.michidex.avernoserver.elementos.Escena;
import com.michidex.avernoserver.elementos.Imagen;
import com.michidex.avernoserver.escenas.AcotacionesSalaUno;
import com.michidex.avernoserver.io.Entradas;
import com.michidex.avernoserver.objetos.Objetos;
import com.michidex.avernoserver.personajes.Enzo;
import com.michidex.avernoserver.personajes.Marisa;
import com.michidex.avernoserver.utiles.Config;
import com.michidex.avernoserver.utiles.Escenas;
import com.michidex.avernoserver.utiles.Global;
import com.michidex.avernoserver.utiles.Recursos;
import com.michidex.avernoserver.utiles.Render;

public class SalaUno implements Screen{
	private Entradas entradas = new Entradas();
	private SpriteBatch b;
	private Imagen fondo;
	private Escena escena;
	private int opc = 0;
	private boolean unaVez,flag=false;
	private Escena[] acotaciones = new Acotacion[AcotacionesSalaUno.values().length];
	private String[] rutasObj = new String[] {"Objetos/Boton de luz.png","Objetos/Florero mesa.png","Objetos/Puerta.png","Objetos/Escritorio computadora.png","Objetos/Ascensor.png"};
	private Imagen[] objetos = new Imagen[rutasObj.length];
	
	
	
	@Override
	public void show() {
		b = Render.batch;
		Gdx.input.setInputProcessor(entradas);
		fondo = new Imagen(Recursos.SALAUNO);
		fondo.setPosicion((Config.ANCHO/2)-(fondo.getAncho()/2), 0);
		for (int i = 0; i < objetos.length; i++) {
			objetos[i] = new Imagen(rutasObj[i]);
		}
		objetos[0].setPosicion(377f, 178f);
		objetos[1].setPosicion(446f, Recursos.ALTURAP);
		objetos[2].setPosicion(566f, Recursos.ALTURAP);
		objetos[3].setPosicion(1202f, Recursos.ALTURAP);
		objetos[4].setPosicion(143, Recursos.ALTURAP);
		if(Config.personaje) {
			Global.p = new Enzo();
			Global.p2 = new Marisa();
		}else{
			Global.p = new Marisa();
			Global.p2 = new Enzo();
		}
		escena = new Escena(Escenas.escena1,Escenas.escena1P);
		for (int i = 0; i < AcotacionesSalaUno.values().length; i++) {
			acotaciones[i] = new Acotacion(AcotacionesSalaUno.values()[i].getDialogo(),AcotacionesSalaUno.values()[i].isPersonaje());
		}
		for (int i = 0; i < Objetos.values().length; i++) {
			Recursos.inventario1.add(Objetos.values()[i]);
		}
		for (int i = 0; i < Objetos.values().length; i++) {
			Recursos.inventario2.add(Objetos.values()[i]);
		}
		
	}

	@Override
	public void render(float delta) {
		Render.limpiarPantalla(0,0,0);
		b.begin();
			dibujarObjetos(delta); 
			if(!Recursos.escenaTerminada) {
				escena.mostrarDialogo(entradas.isF());
			}else if(!unaVez){
				dibujarObjetos(delta);
				opc=0;
				unaVez=true;
			}
		
			// Aca tengo el punto x y le sumo el ancho para saber el area donde se encuentra el objeto (Colision muy trucha)
			//Posicion x personaje menor o igual x del objeto+ancho del objeto(area) && posicion personaje mayor o igual al punto x del objeto
			

			if(Global.clienteF&&Global.cliente2F) {
				if(Global.p.getPosicionX()<=(objetos[2].getX()+objetos[2].getAncho()) && Global.p.getPosicionX()>=objetos[2].getX()&&Global.p2.getPosicionX()<=(objetos[2].getX()+objetos[2].getAncho()) && Global.p2.getPosicionX()>=objetos[2].getX()) {
					System.out.println("Cambio de sala");
					Render.averno.getServidor().enviarATodos("Sala"+"!"+"UnoDos");
					Render.averno.setUnoDos(true);
				}
				if(Global.p.getPosicionX()<=(objetos[4].getX()+objetos[4].getAncho()) && Global.p.getPosicionX()>=objetos[4].getX()&&Global.p2.getPosicionX()<=(objetos[4].getX()+objetos[4].getAncho()) && Global.p2.getPosicionX()>=objetos[4].getX()&&Global.completado) {
					Render.averno.getServidor().enviarATodos("Ascensor");
					}
			}
			if(Global.clienteF) {
				if(Global.p.getPosicionX()<=(objetos[1].getX()+objetos[1].getAncho()) && Global.p.getPosicionX()>=objetos[1].getX()) {
					System.out.println("Cambio de estado");
					Recursos.inventario1.get(0).setEstado(true);
					Render.averno.getServidor().enviarATodos("Acotacion"+"!"+"1"+"!"+"0");
					Render.averno.getServidor().enviarATodos("Llave"+"!"+"0");
				} 
				if(Global.p.getPosicionX()<=(objetos[3].getX()+objetos[3].getAncho()) && Global.p.getPosicionX()>=objetos[3].getX()) {
					Render.averno.getServidor().enviarATodos("Acotacion"+"!"+"2"+"!"+"0");
				}
				if(Global.p.getPosicionX()<=(objetos[0].getX()+objetos[0].getAncho()) && Global.p.getPosicionX()>=objetos[0].getX()) {
					Render.averno.getServidor().enviarATodos("Acotacion"+"!"+"0"+"!"+"0");
				}
			}
			if(Global.cliente2F) {
				if(Global.p2.getPosicionX()<=(objetos[1].getX()+objetos[1].getAncho()) && Global.p2.getPosicionX()>=objetos[1].getX()) {
					System.out.println("Cambio de estado");
					Recursos.inventario2.get(0).setEstado(true);
					Render.averno.getServidor().enviarATodos("Acotacion"+"!"+"1"+"!"+"1");
					Render.averno.getServidor().enviarATodos("Llave"+"!"+"1");
				} 
				if(Global.p2.getPosicionX()<=(objetos[3].getX()+objetos[3].getAncho()) && Global.p2.getPosicionX()>=objetos[3].getX()) {
					Render.averno.getServidor().enviarATodos("Acotacion"+"!"+"2"+"!"+"1");
				}
				if(Global.p2.getPosicionX()<=(objetos[0].getX()+objetos[3].getAncho()) && Global.p2.getPosicionX()>=objetos[0].getX()) {
					Render.averno.getServidor().enviarATodos("Acotacion"+"!"+"0"+"!"+"1");
				}
			}
			
		
		
		
		b.end();
	}

	public void dibujarObjetos(float delta) {
		fondo.dibujar();
		for (int i = 0; i < objetos.length-1; i++) {
			objetos[i].dibujar();
		}
		Global.p.caminar(1);
		Global.p2.caminar(2);
//		//NO estoy segura si mandar el mejs aca o en hilo servidor, probar ambas cosas
//		//Le envio al servidor un mensaje si es el p1 o p2 el que se mueve con su posicion
//		if(Global.d1==true) {
//			Global.p.caminarDer();
//		} 
//		if(Global.d2==true) {
//			Global.p2.caminarDer();
//		}
//		if(Global.i1==true) {
//			Global.p.caminarIzq();
//		} 
//		if(Global.i2==true) {
//			Global.p2.caminarIzq();
//			
//		}
//		if(Global.d1==false&&Global.i1==false) {
//			Global.p.parado();
//		}
//		if(Global.d2==false&&Global.i2==false) {
//			Global.p2.parado();
//			
//		}
	
		
		objetos[objetos.length-1].dibujar();
	}
	public void dibujarAcotacion(int i,float delta) {
		if(Gdx.input.isKeyJustPressed(Keys.F)||flag) {
			flag = true;
			do {
			acotaciones[i].mostrarDialogo(flag);
			opc++;
			}while(opc<1000);
		}if(Gdx.input.isKeyJustPressed(Keys.G)) {
			flag=false;
			dibujarObjetos(delta);
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
