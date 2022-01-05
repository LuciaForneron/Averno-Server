package com.michidex.avernoserver.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.michidex.avernoserver.elementos.Acotacion;
import com.michidex.avernoserver.elementos.Escena;
import com.michidex.avernoserver.elementos.Imagen;
import com.michidex.avernoserver.escenas.AcotacionesSalaUnoDos;
import com.michidex.avernoserver.io.Entradas;
import com.michidex.avernoserver.personajes.Monstruo;
import com.michidex.avernoserver.utiles.Config;
import com.michidex.avernoserver.utiles.Global;
import com.michidex.avernoserver.utiles.Recursos;
import com.michidex.avernoserver.utiles.Render;

public class SalaUnoDos implements Screen {

	Entradas entradas = new Entradas();
	SpriteBatch b;
	Imagen fondo;
	
	private boolean flag,completado,adentro=false,bandera;
	private Monstruo m;
	private Escena[] acotaciones = new Acotacion[AcotacionesSalaUnoDos.values().length];
	private String[] rutas = new String[] {"Objetos/Puerta.png","Objetos/cuadro sala dos.png","Objetos/placa cuadro.png","Objetos/caja.png","Objetos/Caja de letras.png","Objetos/Armario.png ","Imagenes/imagen caja.png","Imagenes/Imagen placa.png","Imagenes/Imagen caja de letras.png","Imagenes/Imagen caja de letras error.png","Imagenes/Imagen caja de letras exito.png"};
	private Imagen[] objetos = new Imagen[rutas.length];
	private String[] rMichidex = new String[] {"Imagenes/m.png","Imagenes/mi.png","Imagenes/mic.png","Imagenes/mich.png","Imagenes/michi.png","Imagenes/michid.png","Imagenes/michide.png","Imagenes/michidex.png"};
	private Imagen[] objMichidex = new Imagen[rMichidex.length];
	
	@Override
	public void show() {
		b = Render.batch;
		Gdx.input.setInputProcessor(entradas);
		fondo = new Imagen(Recursos.SALAUNODOS);
		fondo.setPosicion((Config.ANCHO/2)-(fondo.getAncho()/2), 0);
		for (int i = 0; i < objetos.length; i++) {
			objetos[i] = new Imagen(rutas[i]);
		}
		for (int i = 0; i < objMichidex.length; i++) {
			objMichidex[i] = new Imagen(rMichidex[i]);
		}
		m = new Monstruo();
		objetos[0].setPosicion(400f,Recursos.ALTURAP);
		objetos[1].setPosicion(140f, 168f);
		objetos[2].setPosicion(206f, 150f);
		objetos[3].setPosicion(766f, 120f);
		objetos[4].setPosicion(1166f, 199f);
		objetos[5].setPosicion(1324, 12);
		objetos[6].setPosicion(100, 0);
		objetos[7].setPosicion(100, 0);
		objetos[8].setPosicion(100, 0);
		objetos[9].setPosicion(100, 0);
		objetos[10].setPosicion(100, 0);
		objMichidex[0].setPosicion(100, 0);
		objMichidex[1].setPosicion(100, 0);
		objMichidex[2].setPosicion(100, 0);
		objMichidex[3].setPosicion(100, 0);
		objMichidex[4].setPosicion(100, 0);
		objMichidex[5].setPosicion(100, 0);
		objMichidex[6].setPosicion(100, 0);
		objMichidex[7].setPosicion(100, 0);
		
		for (int i = 0; i < acotaciones.length; i++) {
			acotaciones[i] = new Acotacion(AcotacionesSalaUnoDos.values()[i].getDialogo(),AcotacionesSalaUnoDos.values()[i].isPersonaje());
		}
	}

	@Override
	public void render(float delta) {
		Render.limpiarPantalla(0, 0, 0);
		b.begin();
		 	dibujarObjetos();
		 	if(completado&&!m.isBandera()) {
		 		if(Math.abs(m.getPosicionX()-Global.p.getPosicionX())>Math.abs(m.getPosicionX()-Global.p2.getPosicionX())){
		 			Render.averno.getServidor().enviarATodos("p2");
		 			m.caminarMons(Global.p2, adentro, delta,objetos[4].getX(),objetos[0].getX());	
		 		}else{
		 			Render.averno.getServidor().enviarATodos("p");
		 			m.caminarMons(Global.p, adentro, delta,objetos[4].getX(),objetos[0].getX());
		 		}
		 		Render.averno.getServidor().enviarATodos("Ascensor");
		 		Render.averno.getServidor().enviarATodos("Acotacion"+"!"+"3"+"!"+"2");
		 	}
			 		
			if(Global.clienteF&&Global.cliente2F) {
				if(Global.p.getPosicionX()<=(objetos[0].getX()+objetos[0].getAncho()) && Global.p.getPosicionX()>=objetos[0].getX()) {
					
					Render.averno.setUno(true);
					Render.averno.getServidor().enviarATodos("Sala"+"!"+"Uno");
				
		 		}
				
			}
			if(Global.clienteF) {
			 	if(Global.p.getPosicionX()<=(objetos[1].getX()+objetos[1].getAncho()) && Global.p.getPosicionX()>=objetos[1].getX()) {
//			 			Render.averno.getServidor().enviarMensaje("Placa"+"!"+"0", Render.averno.getServidor().getClientes()[0].getIp(), Render.averno.getServidor().getClientes()[0].getPuerto());
			 			Render.averno.getServidor().enviarATodos("Placa"+"!"+"0");
			 			Render.averno.getServidor().enviarATodos("FalseAfueraObjeto"+"!"+"0");
			 			objetos[7].dibujar();
			 	}
			 	else if(Global.p.getPosicionX()<=(objetos[3].getX()+objetos[3].getAncho()) && Global.p.getPosicionX()>=objetos[3].getX()) {
		 			if(Recursos.inventario1.get(0).isEstado()) {
//		 				Render.averno.getServidor().enviarMensaje("Destornillador"+"!"+"0", Render.averno.getServidor().getClientes()[0].getIp(), Render.averno.getServidor().getClientes()[0].getPuerto());
		 				Render.averno.getServidor().enviarATodos("Destornillador"+"!"+"0");
		 				Render.averno.getServidor().enviarATodos("FalseAfueraObjeto"+"!"+"0");
		 				objetos[6].dibujar();
		 			}
		 				
		 		} 
			 	else if(Global.p.getPosicionX()<=(objetos[4].getX()+objetos[4].getAncho()) && Global.p.getPosicionX()>=objetos[4].getX()) {
//		 				Render.averno.getServidor().enviarMensaje("CajaBotones"+"!"+"0", Render.averno.getServidor().getClientes()[0].getIp(), Render.averno.getServidor().getClientes()[0].getPuerto());
		 				Render.averno.getServidor().enviarATodos("CajaBotones"+"!"+"0");
		 				Render.averno.getServidor().enviarATodos("FalseAfueraObjeto"+"!"+"0");
		 				objetos[8].dibujar();
		 				comprobarLetras(entradas,delta);
		 		}
			 	else if(Global.p.getPosicionX()<=(objetos[5].getX()+objetos[5].getAncho()) && Global.p.getPosicionX()>=objetos[5].getX()) {
//			 		Render.averno.getServidor().enviarMensaje("Adentro"+"!"+"0", Render.averno.getServidor().getClientes()[0].getIp(), Render.averno.getServidor().getClientes()[0].getPuerto());
			 		Render.averno.getServidor().enviarATodos("Adentro");
			 		Render.averno.getServidor().enviarATodos("FalseAfueraObjeto"+"!"+"0");
			 		adentro=true;
		 			}
			 	else {
			 		Render.averno.getServidor().enviarATodos("AfueraObjeto"+"!"+"0");
			 	}
			} if(Global.cliente2F) {
				if(Global.p2.getPosicionX()<=(objetos[1].getX()+objetos[1].getAncho()) && Global.p2.getPosicionX()>=objetos[1].getX()) {
//		 			Render.averno.getServidor().enviarMensaje("Placa"+"!"+"1", Render.averno.getServidor().getClientes()[1].getIp(), Render.averno.getServidor().getClientes()[1].getPuerto());
		 			Render.averno.getServidor().enviarATodos("Placa"+"!"+"1");
					objetos[7].dibujar();
					Render.averno.getServidor().enviarATodos("FalseAfueraObjeto"+"!"+"1");
		 	}
				else if(Global.p2.getPosicionX()<=(objetos[3].getX()+objetos[3].getAncho()) && Global.p2.getPosicionX()>=objetos[3].getX()) {
					if(Recursos.inventario2.get(0).isEstado()) {
//	 				Render.averno.getServidor().enviarMensaje("Destornillador"+"!"+"1", Render.averno.getServidor().getClientes()[1].getIp(), Render.averno.getServidor().getClientes()[1].getPuerto());
	 				Render.averno.getServidor().enviarATodos("Destornillador"+"!"+"1");	
	 				objetos[6].dibujar();
	 				Render.averno.getServidor().enviarATodos("FalseAfueraObjeto"+"!"+"1");
	 			}
	 				
	 		} 
				else if(Global.p2.getPosicionX()<=(objetos[4].getX()+objetos[4].getAncho()) && Global.p2.getPosicionX()>=objetos[4].getX()) {
	//	 			Render.averno.getServidor().enviarMensaje("CajaBotones"+"!"+"1", Render.averno.getServidor().getClientes()[1].getIp(), Render.averno.getServidor().getClientes()[1].getPuerto());
		 			Render.averno.getServidor().enviarATodos("CajaBotones"+"!"+"1");	
			 		objetos[8].dibujar();
			 		Render.averno.getServidor().enviarATodos("FalseAfueraObjeto"+"!"+"1");
			 		if(!completado) {
		 				comprobarLetras(entradas,delta);
			 		}
				}
				else if(Global.p2.getPosicionX()<=(objetos[5].getX()+objetos[5].getAncho()) && Global.p2.getPosicionX()>=objetos[5].getX()) {
	//		 		Render.averno.getServidor().enviarMensaje("Adentro"+"!"+"1", Render.averno.getServidor().getClientes()[1].getIp(), Render.averno.getServidor().getClientes()[1].getPuerto());
		 			Render.averno.getServidor().enviarATodos("Adentro");	
			 		adentro=true;
			 		Render.averno.getServidor().enviarATodos("FalseAfueraObjeto"+"!"+"1");
		 			}
				else {
			 		Render.averno.getServidor().enviarATodos("AfueraObjeto"+"!"+"1");
			 	}
			}
			if(Global.cliente2G||Global.clienteG) {
				Render.averno.getServidor().enviarATodos(Global.cliente2G&&!Global.clienteG?"G"+"!"+"1":"G"+"!"+"0");
				if(Global.cliente2G&&!Global.clienteG?!Global.cliente2F:!Global.clienteF);
				if(adentro) {
					Render.averno.getServidor().enviarATodos("AdentroF");
					Render.averno.getServidor().enviarATodos("BanderaT");
					Render.averno.getServidor().enviarATodos(Global.cliente2G&&!Global.clienteG?"FalseAfueraObjeto"+"!"+"1":"FalseAfueraObjeto"+"!"+"0");
					bandera=true;
					adentro=false;
				}	
			}
//			if() {
//				Render.averno.getServidor().enviarATodos("G"+"!"+"0");
//				Global.clienteF=false;
//				if(adentro) {
//					Render.averno.getServidor().enviarATodos("AdentroF");
//					Render.averno.getServidor().enviarATodos("BanderaT");
//					Render.averno.getServidor().enviarATodos("FalseAfueraObjeto"+"!"+"0");
//					Render.averno.getServidor().enviarATodos("FalseAfueraObjeto"+"!"+"1");
//					bandera=true;
//					adentro=false;
//				}	
	
//		 	if(completado&&!bandera) {
//		 		m.caminarMons(p, adentro, delta,objetos[4].getX(),objetos[0].getX());
//		 	}
//		 	tiempo+=delta;
//			 		if(p.getPosicionX()<=(objetos[0].getX()+objetos[0].getAncho()) && p.getPosicionX()>=objetos[0].getX()) {
//					if(entradas.isF()) {
//						Render.averno.setScreen(new SalaUno());
//						}	
//			 		}
//			if(entradas.isFDos()) {
//			 		if(p.getPosicionX()<=(objetos[1].getX()+objetos[1].getAncho()) && p.getPosicionX()>=objetos[1].getX()) {
//			 			System.out.println("Placa");
//			 			objetos[7].dibujar();
//			 			acotaciones[0].mostrarDialogo(true);
//			 		}else if(p.getPosicionX()<=(objetos[3].getX()+objetos[3].getAncho()) && p.getPosicionX()>=objetos[3].getX()) {
//		 				System.out.println(Recursos.inventario.get(0).isEstado());
//		 				if(Recursos.inventario.get(0).isEstado()) {
//		 					objetos[6].dibujar();
//		 				}else{
//		 					acotaciones[2].mostrarDialogo(true);
//		 					}
//		 				
//		 			}else if(p.getPosicionX()<=(objetos[4].getX()+objetos[4].getAncho()) && p.getPosicionX()>=objetos[4].getX()) {
//		 				System.out.println("Caja botones");
//		 				objetos[8].dibujar();
//		 				acotaciones[1].mostrarDialogo(true);
//		 				comprobarLetras(entradas,delta);
//		 			}else if(p.getPosicionX()<=(objetos[5].getX()+objetos[5].getAncho()) && p.getPosicionX()>=objetos[5].getX()) {
//		 				adentro=true;
//		 			}
//			 		
//			}if(entradas.isG()) {
//				entradas.setFDos(false);
//				if(adentro)
//				bandera=true;
//				adentro=false;
//			}	
			
			b.end();
	}

	public void dibujarObjetos() {
		fondo.dibujar();
		for (int i = 0; i < 4; i++) {
			objetos[i].dibujar();
		}
		if(!adentro) {
			Global.p.caminar(1);
			Global.p2.caminar(2);		
		}
	}
	public void dibujarAcotacion(int i) {
		if(entradas.isFDos()) {
			acotaciones[i].mostrarDialogo(flag);
		}if(entradas.isG()) {
			entradas.setFDos(false);
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
	public boolean comprobarLetras(Entradas entradas, float delta) {
			if(Global.clienteM) {	
				Render.averno.getServidor().enviarATodos("M");																	//M
					objMichidex[0].dibujar();
					if(Global.clienteI){      
						Render.averno.getServidor().enviarATodos("I");	//I
						objMichidex[1].dibujar();
						if(Global.clienteC) {     
							Render.averno.getServidor().enviarATodos("C");	//C
							objMichidex[2].dibujar();
							if(Global.clienteH) {		
								Render.averno.getServidor().enviarATodos("H");	//H
								objMichidex[3].dibujar();
								if(Global.clienteI) {
									Render.averno.getServidor().enviarATodos("I");	//I
									objMichidex[4].dibujar();  
									if(Global.clienteD) {		
										Render.averno.getServidor().enviarATodos("D");	//D
										objMichidex[5].dibujar();
										if(Global.clienteE) {		
											Render.averno.getServidor().enviarATodos("E");	//E
											objMichidex[6].dibujar();
											if(Global.clienteX) {
												Render.averno.getServidor().enviarATodos("X");	
												Render.averno.getServidor().enviarATodos("Exito");	
												Render.averno.getServidor().enviarATodos("Stop");	
												objMichidex[7].dibujar();
												objetos[10].dibujar();
												completado=true;
												Global.completado=true;
												return true;
											}if(entradas.isEnter2()) {
												Render.averno.getServidor().enviarATodos("Error");	
												objetos[9].dibujar();
												return false;
											}
										}if(entradas.isEnter2()) {
											Render.averno.getServidor().enviarATodos("Error");	
											objetos[9].dibujar();
										}
									}if(entradas.isEnter2()) {
										Render.averno.getServidor().enviarATodos("Error");	
										objetos[9].dibujar();
									}
								}if(entradas.isEnter2()) {
									Render.averno.getServidor().enviarATodos("Error");	
									objetos[9].dibujar();
								}
							}if(entradas.isEnter2()) {
								Render.averno.getServidor().enviarATodos("Error");	
								objetos[9].dibujar();
							}
						}if(entradas.isEnter2()) {
							Render.averno.getServidor().enviarATodos("Error");	
							objetos[9].dibujar();
						}
					}if(entradas.isEnter2()) {
						Render.averno.getServidor().enviarATodos("Error");	
						objetos[9].dibujar();
					}
				}if(entradas.isEnter2()) {
					Render.averno.getServidor().enviarATodos("Error");	
					objetos[9].dibujar();
				}
				return false;
	}
	
	
}
