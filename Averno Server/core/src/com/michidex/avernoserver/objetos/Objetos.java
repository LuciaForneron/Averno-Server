package com.michidex.avernoserver.objetos;

public enum Objetos {
	
	LLAVE("Llave",false),DESTORNILLADOR("Destornillador",false);
	
	private String nombre;
	private boolean estado;
	
	Objetos(String nombre, boolean estado){
		this.nombre=nombre;
		this.estado=estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getNombre() {
		return nombre;
	}public boolean isEstado() {
		return estado;
	}
}
