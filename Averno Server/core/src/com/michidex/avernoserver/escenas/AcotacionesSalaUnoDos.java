package com.michidex.avernoserver.escenas;

import com.michidex.avernoserver.utiles.*;

public enum AcotacionesSalaUnoDos{
	CUADRO("Hay algo escrito aca."),CAJABOTONES("Mmm...Una caja con letras.\n Tendre  que escribir algo?"),CAJA("Esta cerrada, debe de haber \n una llave por ahi.");
	
	private String dialogo;
	private boolean personaje;
	
	AcotacionesSalaUnoDos(String dialogo){
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
