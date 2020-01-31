package com.hibernate.mantenimiento.utils;

import java.util.ArrayList;
import com.hibernate.mantenimiento.entidad.Alumno;
import com.hibernate.mantenimiento.input.InputDatos;

public class Impresion {

	public static <T> void muestraEntidad(T t) {
		if (t != null) {
			System.out.println(t);
		} else {
			System.out.println("No se ha devuelto ningún registro...");
		}
	}

	public static <T> void muestraEntidades(ArrayList<T> entidades) {
		if (entidades.size() == 0) {
			System.out.println("No se ha devuelto ningún registro...");
		} else {
			System.out.println("Número de registros: " + entidades.size() + "\n");
			for (T t : entidades) {
				System.out.println(t);
			}
		}
	}

	// ----------------------------------------------------------------------------------

	public static void muestraAlumnosGeneral(ArrayList<Alumno> entidades) {
		int varones = 0;
		int mujeres = 0;
		if (entidades.size() == 0) {
			System.out.println("No se ha devuelto ningún registro...");
		} else {
			System.out.println("Número de registros: " + entidades.size() + "\n");
			for (Alumno a : entidades) {
				if (a.getSexo().equals('V')) {
					varones++;
				} else {
					mujeres++;
				}
				System.out.println(a);
			}
			System.out.println("\nSe han mostrado un total de: " + varones + " varones y " + mujeres + " mujeres.");
		}
	}

	public static void muestraAlumnosCondicional(ArrayList<Alumno> entidades) {
		char sexo;
		boolean flag = false;
		if (entidades.size() == 0) {
			System.out.println("No se ha devuelto ningún registro...");
		} else {
			sexo = InputDatos.pideChar("Introduce el sexo (V/M):", Validaciones.SEXO.devuleveExpresion());
			for (Alumno a : entidades) {
				if (a.getSexo().equals(sexo)) {
					System.out.println(a);
					flag = true;
				}
			}
		}
		if(!flag) {System.out.println("No se ha devuelto ningún registro.");}
	}
}
