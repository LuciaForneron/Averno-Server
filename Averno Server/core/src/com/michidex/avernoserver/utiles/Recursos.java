package com.michidex.avernoserver.utiles;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.michidex.avernoserver.objetos.Objetos;

public class Recursos {

	public static final String FONDO = "Imagenes/Menu.png";
	public static final String INICIO = "Imagenes/Michidex Studios.png";
	public static final String FUENTEMENU = "Fuentes/alagard.ttf";
	public static final Color COLORMENU = new Color((102f / 255f), (85f / 255f), (71f / 255f),1);
	public static final String FUENTEAVERNO = "Fuentes/Incunitials.ttf";
	public static final String SALAUNO = "Salas/Sala 1.png";
	public static final String SALAUNODOS = "Salas/Sala 1-2.png";
	public static final String SALADOS = "Salas/Sala 2.png";
	public static boolean escenaTerminada;
	public static final float ALTURAP = 12f;
	public static float VELOCIDAD = 0.05f;
	public static float VELOCIDADM = 0.03f;
	public static final String[] ANIMACIONESE = new String[]{"Personajes/Parado derecha Enzo.png","Personajes/Parado izquierda Enzo.png","Personajes/Caminata Derecha Enzo.png","Personajes/Caminata izquierda Enzo.png"};
	public static final String[] ANIMACIONESM = new String[] {"Personajes/Parado derecha Marisa.png","Personajes/Parado izquierda Marisa.png","Personajes/Marisa caminata derecha.png","Personajes/Caminata izquierda Marisa.png"};
	public static final String[] ANIMACIONESMONS = new String[] {"Personajes/Parado monstruo.png","Personajes/Parado monstruo izq.png","Personajes/Caminata monstruo.png","Personajes/Caminata monstruo izqpng.png","Personajes/Ataque monstruo.png","Personajes/Ataque monstruo izq.png"};
	public static boolean derecha,izquierda;
	public static List<Objetos> inventario1 = new ArrayList<>();
	public static List<Objetos> inventario2 = new ArrayList<>();
}
