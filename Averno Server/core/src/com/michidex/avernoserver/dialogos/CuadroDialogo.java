package com.michidex.avernoserver.dialogos;

import com.badlogic.gdx.graphics.Color;
import com.michidex.avernoserver.utiles.*;
import com.michidex.avernoserver.elementos.Imagen;
import com.michidex.avernoserver.elementos.Texto;
import com.michidex.avernoserver.utiles.Recursos;

public abstract class CuadroDialogo {
	
	private Imagen cuadro;
	private Texto dialogo;
	
	public CuadroDialogo(String rutaCuadro, String dialogo) {
		
		cuadro = new Imagen(rutaCuadro);
		this.dialogo = new Texto(Recursos.FUENTEMENU,20,new Color((186/ 255f),(144/ 255f),(101/ 255f),1),true,dialogo);
	}
	
	public void dibujar() {
		cuadro.setPosicion(Config.DIALOGOX, Config.DIALOGOY);
		dialogo.setPosicion(697, 125);
		cuadro.dibujar();
		dialogo.dibujar();
		
	}
}
