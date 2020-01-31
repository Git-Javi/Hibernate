package com.hibernate.mantenimiento.utils;

import com.hibernate.mantenimiento.input.Teclado;

public class Confirmaciones {

	private static Teclado teclado = new Teclado();

	public static boolean confirmaOperacion() {
		String respuesta;
		do {
			System.out.println("¿Confirma la operación? (S/N):");
			respuesta = teclado.leerString().toUpperCase();
		} while (respuesta.trim().equals("") || (!respuesta.equals("S") && !respuesta.equals("N")));
		if (respuesta.equals("S")) {
			return true;
		} else {
			return false;
		}

	}
}
