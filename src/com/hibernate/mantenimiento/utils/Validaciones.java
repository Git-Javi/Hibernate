package com.hibernate.mantenimiento.utils;

public enum Validaciones {

	CODIGO("^[1-9]\\d{0,3}$"),
	DNI("^[0-9]{8,8}[A-Za-z]$"),
	NOMBRE("^(?=.{2,15}$)[A-Z�����][a-z������]+(?: [A-Z�����][a-z������]+)?+(?: [A-Z�����][a-z������]+)?$"),
	APELLDIOS("^(?=.{2,30}$)[A-Z�����][a-z������]+(?: [A-Z�����][a-z������]+)?+(?: [A-Z�����][a-z������]+)?$"),
	SEXO("^[V]$|^[M]$"),
	NOTA("^[1-9]0?$"),
	FECHA("^(\\d{2})(\\/)(\\d{2})(\\/)(\\d{4})$");
	
	private final String expresion;

	private Validaciones(String expresion) {
		this.expresion = expresion;
	}
	
	public String devuleveExpresion() {
		return expresion;
	}
}
