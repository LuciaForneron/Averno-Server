package com.michidex.avernoserver.escenas;

import com.michidex.avernoserver.utiles.*;

public enum AcotacionesSalaUno {

	BOTON("No funciona"),FLORERO("Hay algo dentro...Una llave"),ESCRITORIO("Esta apagada");
	
	private String dialogo;
	private boolean personaje;
	
	AcotacionesSalaUno(String dialogo) {
		this.dialogo=dialogo;
		this.personaje=Config.personaje;
	}
	public String getDialogo() {
		return dialogo;
	}
	public boolean isPersonaje() {
		return personaje;
	}
}
