package com.hibernate.mantenimiento.menu;

import com.hibernate.mantenimiento.controller.Mantenimiento;
import com.hibernate.mantenimiento.input.Conversor;
import com.hibernate.mantenimiento.input.Teclado;

public class MenuListado {
	
	Teclado teclado = new Teclado();
	Mantenimiento mantenimiento = new Mantenimiento();
	Conversor conversor = new Conversor();
	int opcion;
	boolean salir = false;
	
	public void muestraMenu() {

		do {
			System.out.println("\n-------------MENÚ LISTAR-------------");
			System.out.println(" 1. General \n 2. Por Sexo \n 3. Volver a menú ");
			opcion = conversor.convierteInt(teclado.leerString());
			switch (opcion) {
			case 1:
				// 1 general // sacar cuantos varones y cuantas mujeres se han visulaizado  
				mantenimiento.listar();
				break;
			case 2:
				// 2 por sexo // preguntar si queremos varones o mujeres
				mantenimiento.listarCondicional();
				break;
			case 3:
				// 3 volver al menú
				salir = true;
				break;
			default:
				System.out.println("\nNo has introducida una opción correcta!!\n");
			}
		} while (salir != true);
	}
}
