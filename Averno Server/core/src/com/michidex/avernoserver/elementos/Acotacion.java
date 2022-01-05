package com.michidex.avernoserver.elementos;

import com.michidex.avernoserver.io.Entradas;

public class Acotacion extends Escena{

	public Acotacion(String texto, boolean personaje) {
		super(texto, personaje);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void mostrarDialogo(boolean f) {
		getEscena().get(opc).dibujar();
		if(f) {
			if(tiempo>10) {
				opc+=1;
				tiempo=0;
				if(opc>getEscena().size()-1) {
					fin = true;
					opc=0;
					}	
				}
			}
		}
	public boolean dibujarAcotacion(int i,Entradas entradas, boolean flag,Acotacion[] acotaciones) {
		if(entradas.isFDos()||flag) {
			flag = true;
			do {
			acotaciones[i].mostrarDialogo(flag);
			opc++;
			}while(opc<1000);
		}if(entradas.isG()) {
			flag=false;
			return true;
			}
		return false;
		}
	}

