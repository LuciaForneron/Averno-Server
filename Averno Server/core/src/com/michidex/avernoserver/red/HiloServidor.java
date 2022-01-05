package com.michidex.avernoserver.red;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import com.michidex.avernoserver.pantallas.SalaUno;
import com.michidex.avernoserver.pantallas.SalaUnoDos;
import com.michidex.avernoserver.utiles.Config;
import com.michidex.avernoserver.utiles.Global;
import com.michidex.avernoserver.utiles.Render;

public class HiloServidor extends Thread{

	private DatagramSocket conexion;
	private boolean fin;
	private DireccionRed[] clientes = new DireccionRed[2];
	private int cantClientes  = 0;
	
	public HiloServidor() {
		try {
			conexion = new DatagramSocket(2008);
			System.out.println(conexion.isClosed());
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run(){
		do {
			byte[] data = new byte[1024];
			DatagramPacket dp = new DatagramPacket(data,data.length);
			try {
				conexion.receive(dp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			procesarMensaje(dp);
		}while(!fin);
	}
	private void procesarMensaje(DatagramPacket dp) {
		String msg = (new String(dp.getData())).trim();
		
		String mensaje[] = msg.split("!");
		
//		System.out.println(msg);
		
		
			if(mensaje[0].equals("Conexion")) {
				if(cantClientes<2) {
					clientes[cantClientes] = new DireccionRed(dp.getAddress(),dp.getPort());
					enviarMensaje("Ok"+"!"+cantClientes,clientes[cantClientes].getIp(),clientes[cantClientes].getPuerto());
					cantClientes++;
					if(cantClientes==2) {
						Config.empieza=true;
						for (int i = 0; i < clientes.length; i++) {
							enviarMensaje("Empieza",clientes[i].getIp(),clientes[i].getPuerto());
						}
					}
				}
			}
		
//				if(mensaje[0].equals("Cerro")) {
//					cantClientes--;
//					for (int i = 0; i < clientes.length; i++) {
//						enviarMensaje("Cerro",clientes[i].getIp(),clientes[i].getPuerto());
//					}
//					fin=true;
//				}
			
				if(mensaje[0].equals("Enzo")) {
					if(Integer.valueOf(mensaje[1])==0) {
					enviarMensaje("P"+"!"+"Enzo",clientes[0].getIp(),clientes[0].getPuerto());
					enviarMensaje("P"+"!"+"Marisa",clientes[1].getIp(),clientes[1].getPuerto());
					Config.personaje=true;
					Render.averno.setUno(true);
					}
				} 
				if(mensaje[0].equals("Marisa")) {
					if(Integer.valueOf(mensaje[1])==0) {
					enviarMensaje("P"+"!"+"Marisa",clientes[0].getIp(),clientes[0].getPuerto());
					enviarMensaje("P"+"!"+"Enzo",clientes[1].getIp(),clientes[1].getPuerto());
					Config.personaje=false;
					Render.averno.setUno(true);
					}
				} 
				
				
				if(Render.averno.getScreen().getClass() == SalaUno.class||Render.averno.getScreen().getClass() == SalaUnoDos.class) {
					if(mensaje[0].equals("ApreteDerecha")) {
						if(Integer.valueOf(mensaje[1])==0) {
							enviarATodos("CD"+"!"+Integer.valueOf(mensaje[1])+"!"+String.valueOf(Global.p.caminarDer()));
						}else {
							enviarATodos("CD"+"!"+Integer.valueOf(mensaje[1])+"!"+String.valueOf(Global.p2.caminarDer()));
						}
					} 
					if(mensaje[0].equals("ApreteIzquierda")) {
						if(Integer.valueOf(mensaje[1])==0) {
							enviarATodos("CI"+"!"+Integer.valueOf(mensaje[1])+"!"+String.valueOf(Global.p.caminarIzq()));
						}else {
							enviarATodos("CI"+"!"+Integer.valueOf(mensaje[1])+"!"+String.valueOf(Global.p2.caminarIzq()));
						}
					} 
					if(mensaje[0].equals("NoApreteDerecha")||mensaje[0].equals("NoApreteIzquierda")) {
						if(Integer.valueOf(mensaje[1])==0) {
							enviarATodos("CP"+"!"+Integer.valueOf(mensaje[1])+"!"+String.valueOf(Global.p.parado()));
						}else {
							enviarATodos("CP"+"!"+Integer.valueOf(mensaje[1])+"!"+String.valueOf(Global.p2.parado()));
						}
					}
					
					if(mensaje[0].equals("F")){
						if(Integer.valueOf(mensaje[1])==0) {
							Global.clienteF = true;
//							enviarATodos("F"+"!"+Integer.valueOf(mensaje[1]));
							enviarMensaje("F"+"!"+Integer.valueOf(mensaje[1]),getClientes()[0].getIp(),getClientes()[0].getPuerto());
						}else {
							Global.cliente2F = true;
//							enviarATodos("F"+"!"+Integer.valueOf(mensaje[1]));
							enviarMensaje("F"+"!"+Integer.valueOf(mensaje[1]),getClientes()[1].getIp(),getClientes()[1].getPuerto());
						}
					}
					if(mensaje[0].equals("NoF")){
						if(Integer.valueOf(mensaje[1])==0) {
							Global.clienteF = false;
//							enviarATodos("NoF"+"!"+Integer.valueOf(mensaje[1]));
							enviarMensaje("NoF"+"!"+Integer.valueOf(mensaje[1]),getClientes()[0].getIp(),getClientes()[0].getPuerto());
						}else {
							Global.cliente2F = false;
//							enviarATodos("NoF"+"!"+Integer.valueOf(mensaje[1]));
							enviarMensaje("NoF"+"!"+Integer.valueOf(mensaje[1]),getClientes()[1].getIp(),getClientes()[1].getPuerto());
							
						}
					}
					if(mensaje[0].equals("G")){
						if(Integer.valueOf(mensaje[1])==0) {
							Global.clienteG=true;
//							enviarATodos("G"+"!"+Integer.valueOf(mensaje[1]));
							enviarMensaje("G"+"!"+Integer.valueOf(mensaje[1]),getClientes()[0].getIp(),getClientes()[0].getPuerto());
						}else {
							Global.cliente2G =true;
//							enviarATodos("G"+"!"+Integer.valueOf(mensaje[1]));
							enviarMensaje("G"+"!"+Integer.valueOf(mensaje[1]),getClientes()[1].getIp(),getClientes()[1].getPuerto());
							
						}
					}
					if(mensaje[0].equals("NoG")){
						if(Integer.valueOf(mensaje[1])==0) {
							Global.clienteG=false;
//							enviarATodos("NoG"+"!"+Integer.valueOf(mensaje[1]));
							enviarMensaje("NoG"+"!"+Integer.valueOf(mensaje[1]),getClientes()[0].getIp(),getClientes()[0].getPuerto());
						}else {
							Global.cliente2G =false;
//							enviarATodos("NoG"+"!"+Integer.valueOf(mensaje[1]));
							enviarMensaje("NoG"+"!"+Integer.valueOf(mensaje[1]),getClientes()[1].getIp(),getClientes()[1].getPuerto());
						
						}
					}
					if(mensaje[0].equals("M")){
							Global.clienteM = true;
							enviarATodos("M");
					}
					if(mensaje[0].equals("I")){
							Global.clienteI = true;
							enviarATodos("I");
					}
					if(mensaje[0].equals("C")){
							Global.clienteC = true;
							enviarATodos("C");
					}
					if(mensaje[0].equals("H")){
							Global.clienteH = true;
							enviarATodos("H");
					}
					if(mensaje[0].equals("D")){
							Global.clienteD = true;
							enviarATodos("D");
					}
					if(mensaje[0].equals("E")){
							Global.clienteE = true;
							enviarATodos("E");
					}
					if(mensaje[0].equals("X")){
							Global.clienteX = true;
							enviarATodos("X");
					}
				}
				
			
			} 

	public void enviarATodos(String msg) {
		for (int i = 0; i < clientes.length; i++) {
			enviarMensaje(msg, clientes[i].getIp(), clientes[i].getPuerto());
		}
	}


	public void enviarMensaje(String msg, InetAddress ip, int puerto) {
		byte[] data = msg.getBytes();
		DatagramPacket paquete = new DatagramPacket(data, data.length, ip, puerto);
		try {
			conexion.send(paquete);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public DireccionRed[] getClientes() {
		return clientes;
	}
	public int getCantClientes() {
		return cantClientes;
	}
}
