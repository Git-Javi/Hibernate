package com.hibernate.mantenimiento.input;

import java.io.*;

public class Teclado {

	public String leerString() {
		String s = "";
		try { // No puedo meterlo en try WR o cerrar el stream al finalizar el método ya que en siguientes llamadas no lo abre (Stream closed)
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			s = br.readLine();
		} catch (IOException ioex) {
			System.err.println("Se ha producido un error de entrada-salida de datos." + ioex);
		}
		return s;
	}

	public void leerSalto() {
		try { // No puedo meterlo en try WR o cerrar el stream al finalizar el método ya que en siguientes llamadas no lo abre (Stream closed)
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br.readLine();
		} catch (IOException ioex) {
			System.err.println("Se ha producido un error de entrada-salida de datos." + ioex);
		}
	}

}
