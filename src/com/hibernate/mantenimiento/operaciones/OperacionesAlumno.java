package com.hibernate.mantenimiento.operaciones;

import com.hibernate.mantenimiento.entidad.Alumno;
import com.hibernate.mantenimiento.input.Conversor;
import com.hibernate.mantenimiento.input.InputDatos;
import com.hibernate.mantenimiento.input.Teclado;
import com.hibernate.mantenimiento.utils.Validaciones;

//El objeto y su tipo de identificador único
public class OperacionesAlumno implements Operaciones<Alumno, String> {

	private Teclado teclado = new Teclado();
	private Conversor conversor = new Conversor();

	@Override
	public String pideId() {
		return InputDatos.pideString("Introduce el NIF:", Validaciones.DNI.devuleveExpresion());
	}

	@Override	
	public String devuelveId(Alumno t) {
		return t.getNif();
	}

	@Override
	public Alumno pideDatosDevuelveEntidad() {
		Alumno unAlumno = new Alumno();
		System.out.println("Introduce los datos del Alumno:");
		unAlumno.setNif(pideId());
		unAlumno.setNombre(InputDatos.pideString("Introduce el nombre (Max-15):", Validaciones.NOMBRE.devuleveExpresion()));
		unAlumno.setApellidos(InputDatos.pideString("Introduce los apellidos: (Max-30)", Validaciones.APELLDIOS.devuleveExpresion()));
		unAlumno.setSexo(InputDatos.pideChar("Introduce el sexo (V/M):", Validaciones.SEXO.devuleveExpresion()));
		unAlumno.setNota1(InputDatos.pideInt("Introduce la nota 1 (1-10):", Validaciones.NOTA.devuleveExpresion()));
		unAlumno.setNota2(InputDatos.pideInt("Introduce la nota 2 (1-10):", Validaciones.NOTA.devuleveExpresion()));
		return unAlumno;
	}

	@Override
	public Alumno modificacionDatosEntidad(Alumno t) {
		int opcion;

		do {
			System.out.println("Selecciona el campo que deseas modificar:");
			System.out.println("1. Nombre / 2. Apellido / 3. Sexo / 4. Nota1 / 5. Nota2");
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
			t.setNota1(InputDatos.pideInt("Introduce la nota 1 (1-10):", Validaciones.NOTA.devuleveExpresion()));
			return t;
		case 5:
			t.setNota1(InputDatos.pideInt("Introduce la nota 2 (1-10):", Validaciones.NOTA.devuleveExpresion()));
			return t;
		default:
			return null;
		}
	}
}
