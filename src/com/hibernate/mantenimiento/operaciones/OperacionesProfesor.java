package com.hibernate.mantenimiento.operaciones;

import com.hibernate.mantenimiento.entidad.Profesor;
import com.hibernate.mantenimiento.input.Conversor;
import com.hibernate.mantenimiento.input.InputDatos;
import com.hibernate.mantenimiento.input.Teclado;
import com.hibernate.mantenimiento.utils.Validaciones;

public class OperacionesProfesor implements Operaciones<Profesor, Integer> {

	private Teclado teclado = new Teclado();
	private Conversor conversor = new Conversor();
	
	@Override
	public Integer pideId() {
		return InputDatos.pideInt("Introduce el Código (1-9999):", Validaciones.CODIGO.devuleveExpresion());
	}

	@Override
	public Integer devuelveId(Profesor t) {
		return t.getCodigo();
	}

	@Override
	public Profesor pideDatosDevuelveEntidad() {
		Profesor unProfesor = new Profesor();
		System.out.println("Introduce los datos del Profesor:");
		unProfesor.setCodigo(pideId());
		unProfesor.setNombre(InputDatos.pideString("Introduce el nombre (Max-15):", Validaciones.NOMBRE.devuleveExpresion()));
		unProfesor.setApellidos(InputDatos.pideString("Introduce los apellidos: (Max-30)", Validaciones.APELLDIOS.devuleveExpresion()));
		unProfesor.setSexo(InputDatos.pideChar("Introduce el sexo (V/M):", Validaciones.SEXO.devuleveExpresion()));
		unProfesor.setAntiguedad(InputDatos.pideDate("Introduce la antigüedad (dd/mm/aaaa):", Validaciones.FECHA.devuleveExpresion()));
		unProfesor.setRendimiento(InputDatos.pideInt("Introduce el rendimiento", Validaciones.NOTA.devuleveExpresion()));
		return unProfesor;
	}

	@Override
	public Profesor modificacionDatosEntidad(Profesor t) {
		int opcion;

		do {
			System.out.println("Selecciona el campo que deseas modificar:");
			System.out.println("1. Nombre / 2. Apellido / 3. Sexo / 4. Antiguedad / 5. Rendimiento");
			opcion = conversor.convierteInt(teclado.leerString());
		} while (opcion < 1 || opcion > 5);

		switch (opcion) {
		case 1:
			t.setNombre(InputDatos.pideString("Introduce el nombre (Max-15):", Validaciones.NOMBRE.devuleveExpresion()));
			return t;
		case 2:
			t.setApellidos(InputDatos.pideString("Introduce los apellidos: (Max-30)", Validaciones.APELLDIOS.devuleveExpresion()));
			return t;
		case 3:
			t.setSexo(InputDatos.pideChar("Introduce el sexo (V/M):", Validaciones.SEXO.devuleveExpresion()));
			return t;
		case 4:
			t.setAntiguedad(InputDatos.pideDate("Introduce la antigüedad (dd/mm/aaaa):", Validaciones.FECHA.devuleveExpresion()));
			return t;
		case 5:
			t.setRendimiento(InputDatos.pideInt("Introduce el rendimiento", Validaciones.NOTA.devuleveExpresion()));
			return t;
		default:
			return null;
		}
	}
}
