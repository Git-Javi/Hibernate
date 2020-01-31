package com.hibernate.mantenimiento.input;

public class Conversor {
	public int convierteInt(String s) {
		int i = 0;
		try {
			i = Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			i = Integer.MIN_VALUE;
		}
		return i;
	}

	public char convierteChar(String s) {
		char c;
		if (s.equals("")) {
			c = Character.MIN_VALUE;
			return c;
		} else {
			c = s.charAt(0);
			return c;
		}
	}

	public Double convierteDouble(String s) {
		double d = 0;
		try {
			d = Double.parseDouble(s);
		} catch (NumberFormatException e) {
			d = Double.MIN_VALUE;
		}
		return d;
	}

	public Float convierteFloat(String s) {

		float f = 0;
		try {
			f = Float.parseFloat(s);
		} catch (NumberFormatException nfe) {
			f = Float.MIN_VALUE;
		}
		return f;
	}
}
