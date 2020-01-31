package com.hibernate.mantenimiento.input;

import java.util.Date;

public class InputDatos {
	
	private static Teclado teclado = new Teclado();
	private static Conversor conversor = new Conversor();

	public static String pideString(String msg,String regex) {
		String cadena;
		do {
			System.out.println(msg);
			cadena = teclado.leerString();
		} while (!cadena.matches(regex));
		return cadena;
	}
	
	public static int pideInt(String msg,String regex) {
		int numero;
		do {
			System.out.println(msg);
			numero = conversor.convierteInt(teclado.leerString());
		} while (!String.valueOf(numero).matches(regex));
		return numero;
	}
	
	public static double pideDouble(String msg,String regex) {
		double decimal;
		do {
			System.out.println(msg);
			decimal = conversor.convierteDouble(teclado.leerString());
		} while (!String.valueOf(decimal).matches(regex));
		return decimal;
	}

	public static char pideChar(String msg,String regex) {
		String letra;
		do {
			System.out.println(msg);
			letra = teclado.leerString().toUpperCase();
		} while (!letra.matches(regex));
		return letra.charAt(0);
	}

	@SuppressWarnings("deprecation")
	public static Date pideDate(String msg,String regex) {
		String fecha;
		do {
			System.out.println(msg);
			fecha = teclado.leerString();
		} while (!fecha.matches(regex));
		return new Date(fecha);
	}
}
