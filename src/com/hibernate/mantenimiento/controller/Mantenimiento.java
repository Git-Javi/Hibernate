package com.hibernate.mantenimiento.controller;

import java.util.ArrayList;
import org.hibernate.SessionFactory;
import com.hibernate.mantenimiento.dao.Dao;
import com.hibernate.mantenimiento.dao.HibernateMySQLEntityDAO;
import com.hibernate.mantenimiento.entidad.Alumno;
import com.hibernate.mantenimiento.operaciones.Operaciones;
import com.hibernate.mantenimiento.operaciones.OperacionesAlumno;
import com.hibernate.mantenimiento.session.SessionUtil;
import com.hibernate.mantenimiento.utils.Confirmaciones;
import com.hibernate.mantenimiento.utils.Impresion;

public class Mantenimiento {

	private SessionFactory sessionFactory;
	private Dao<Alumno,String> hibernateMySQLEntityDAO;
	private Operaciones<Alumno,String> operacionesEntidad;

	public Mantenimiento() {
		sessionFactory = SessionUtil.getSessionFactory();
		hibernateMySQLEntityDAO = new HibernateMySQLEntityDAO<Alumno,String>(Alumno.class, sessionFactory);
		operacionesEntidad = new OperacionesAlumno();
	}

	public void alta() {
		Alumno nuevaEntidad = operacionesEntidad.pideDatosDevuelveEntidad();
		if(Confirmaciones.confirmaOperacion()) {
			Alumno entidadDevuelta = hibernateMySQLEntityDAO.createAndRead(nuevaEntidad, operacionesEntidad.devuelveId(nuevaEntidad));
			Impresion.muestraEntidad(entidadDevuelta);
		}
	}

	public void baja() {
		Alumno entidadDevuelta = hibernateMySQLEntityDAO.readById(operacionesEntidad.pideId());
		Impresion.muestraEntidad(entidadDevuelta);
		if(entidadDevuelta!= null && Confirmaciones.confirmaOperacion()) {
			hibernateMySQLEntityDAO.deleteById(operacionesEntidad.devuelveId(entidadDevuelta));
		}
	}

	public void consulta() {
		Alumno entidadDevuelta = hibernateMySQLEntityDAO.readById(operacionesEntidad.pideId());
		Impresion.muestraEntidad(entidadDevuelta);
	}

	public void modificacion() {
		Alumno entidadTmp = hibernateMySQLEntityDAO.readById(operacionesEntidad.pideId());
		Impresion.muestraEntidad(entidadTmp);
		if (entidadTmp != null) {
			entidadTmp = operacionesEntidad.modificacionDatosEntidad(entidadTmp);
			if(Confirmaciones.confirmaOperacion()) {
				Alumno entidadDevuelta = hibernateMySQLEntityDAO.updateAndRead(entidadTmp, operacionesEntidad.devuelveId(entidadTmp));
				Impresion.muestraEntidad(entidadDevuelta);
			}
		}
	}

	public void listar() {
		ArrayList<Alumno> listaEntidades = hibernateMySQLEntityDAO.findAll();
		//Impresion.muestraEntidades(listaEntidades);
		Impresion.muestraAlumnosGeneral(listaEntidades);
	}
	
	// ----------------------------------------------------------------------------------
	public void listarCondicional() {
		ArrayList<Alumno> listaEntidades = hibernateMySQLEntityDAO.findAll();
		Impresion.muestraAlumnosCondicional(listaEntidades);
	}
	// ----------------------------------------------------------------------------------

	public void fin() {
		System.out.println("El programa finaliza.");
	}

}
