package com.hibernate.mantenimiento.dao;

import java.io.Serializable;
import java.util.ArrayList;

public interface Dao<T, E extends Serializable> {

	public void create(T t);
	public T readById(E id);
	public void update(T t);
	public void deleteById(E id);
	public ArrayList<T> findAll();
	public T createAndRead(T t, E id);
	public T updateAndRead(T t, E id);


}


