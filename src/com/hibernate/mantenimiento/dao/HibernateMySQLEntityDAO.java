package com.hibernate.mantenimiento.dao;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.PersistenceException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

public class HibernateMySQLEntityDAO<T, E extends Serializable> implements Dao<T,E> {

	private SessionFactory sessionFactory;
	private Transaction transaction;
	private Class<T> CLASE_ENTIDAD;

	public HibernateMySQLEntityDAO(Class<T> claseEntidad, SessionFactory sessionFactory) {
		CLASE_ENTIDAD = claseEntidad;
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(T t) {
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
		} catch (PersistenceException pex) {
			transaction.rollback();
			if (pex.getCause() instanceof ConstraintViolationException) {
				System.err.println("La clave primaria está duplicada!");
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T readById(E id) {
		Object t = new Object();
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			t = session.get(CLASE_ENTIDAD, id); // <-- Indico el tipo de clase recibido por parámetros en el constructor
			transaction.commit();
		} catch (HibernateException hex) {
			transaction.rollback();
		}
		return (T) t;
	}

	@Override
	public void update(T t) {
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(t);
			transaction.commit();
		} catch (PersistenceException pex) {
			transaction.rollback();
			if (pex.getCause() instanceof ConstraintViolationException) {
				System.err.println("La clave primaria está duplicada!");
			}
		}
	}

	@Override
	public void deleteById(E id) {
		try (Session session = sessionFactory.openSession()) {
			Object entidad = readById(id);
			if (entidad != null) {
				transaction = session.beginTransaction();
				session.delete(entidad);
				transaction.commit();
				System.out.println("Entidad borrada correctamente.");
			} else {
				System.out.println("No hay ninguna entidad con ese id.");
			}
		} catch (HibernateException hex) {
			transaction.rollback();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<T> findAll() {
		ArrayList<T> listaEntidades = new ArrayList<>();
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			listaEntidades = (ArrayList<T>) session.createQuery("from " + CLASE_ENTIDAD.getName()).getResultList();
			// Si hubiese grandes cantidades de datos
			// https://stackoverflow.com/questions/14581865/hibernate-flush-and-commit
			// session.flush();
			transaction.commit();
		} catch (HibernateException hex) {
			transaction.rollback();
		}
		return listaEntidades;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T createAndRead(T t, E id) {
		Object entidad = null;
		if (!entityExists(id)) {
			create(t);
			entidad = readById(id);
		}
		return (T) entidad;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T updateAndRead(T t, E id) {
		Object entidad = null;
		if (entityExists(id)) {
			update(t);
			entidad = readById(id);
		}
		return (T) entidad;
	}

	private boolean entityExists(E id) {
		boolean existe = false;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			Object t = session.get(CLASE_ENTIDAD, id);
			if (t != null) {
				existe = true;
			}
			transaction.commit();
		} catch (HibernateException hex) {
			transaction.rollback();
		}
		return existe;
	}
}
