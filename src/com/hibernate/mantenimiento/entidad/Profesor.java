package com.hibernate.mantenimiento.entidad;
// Generated 29-ene-2020 15:54:29 by Hibernate Tools 5.4.7.Final

import java.util.Date;

/**
 * Profesor generated by hbm2java
 */
public class Profesor implements java.io.Serializable {

	private int codigo;
	private String nombre;
	private String apellidos;
	private Character sexo;
	private Date antiguedad;
	private Integer rendimiento;

	public Profesor() {
	}

	public Profesor(int codigo) {
		this.codigo = codigo;
	}

	public Profesor(int codigo, String nombre, String apellidos, Character sexo, Date antiguedad, Integer rendimiento) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.antiguedad = antiguedad;
		this.rendimiento = rendimiento;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Character getSexo() {
		return this.sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public Date getAntiguedad() {
		return this.antiguedad;
	}

	public void setAntiguedad(Date antiguedad) {
		this.antiguedad = antiguedad;
	}

	public Integer getRendimiento() {
		return this.rendimiento;
	}

	public void setRendimiento(Integer rendimiento) {
		this.rendimiento = rendimiento;
	}

	/**
	 * toString
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("codigo").append("='").append(getCodigo()).append("' ");
		buffer.append("nombre").append("='").append(getNombre()).append("' ");
		buffer.append("apellidos").append("='").append(getApellidos()).append("' ");
		buffer.append("sexo").append("='").append(getSexo()).append("' ");
		buffer.append("antiguedad").append("='").append(getAntiguedad()).append("' ");
		buffer.append("rendimiento").append("='").append(getRendimiento()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

}
