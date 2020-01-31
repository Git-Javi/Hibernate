package com.hibernate.mantenimiento.operaciones;

public interface Operaciones <T, E> { // El objeto y su tipo de identificador �nico

	public E pideId();
	public E devuelveId(T t);
	public T pideDatosDevuelveEntidad();
	public T modificacionDatosEntidad(T t);
}
