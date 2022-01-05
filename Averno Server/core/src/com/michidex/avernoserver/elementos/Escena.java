package com.michidex.avernoserver.elementos;

import java.util.ArrayList;
import java.util.List;

import com.michidex.avernoserver.dialogos.CuadroDialogo;
import com.michidex.avernoserver.dialogos.EnzoDialogo;
import com.michidex.avernoserver.dialogos.MarisaDialogo;
import com.michidex.avernoserver.utiles.Recursos;

public class Escena {
	
	private List<CuadroDialogo> escena = new ArrayList<>();
	int opc;
	boolean fin = false;
	int tiempo;
	
	//1 Marisa
	public Escena(String[] textos, boolean[] personaje) {
		for (int i = 0; i < textos.length; i++) {
			escena.add((!personaje[i])?new MarisaDialogo(textos[i]):new EnzoDialogo(textos[i]));
		}
	}
	public Escena(String texto, boolean personaje) {
		escena.add((!personaje)?new MarisaDialogo(texto):new EnzoDialogo(texto));
	}
	
	public void mostrarDialogo(boolean f) {
		tiempo++;
		if(!fin) {
			escena.get(opc).dibujar();
			if(f) {
				if(tiempo>10) {
					opc+=1;
					tiempo=0;
					if(opc>escena.size()-1) {
						fin = true;
						opc=0;
						Recursos.escenaTerminada=true;
					}	
				}
			}
		}
	}
	public List<CuadroDialogo> getEscena() {
		return escena;
	}
}
