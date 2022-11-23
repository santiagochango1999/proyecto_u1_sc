package com.example.demo.SpringBoot;

import org.springframework.stereotype.Component;

@Component
public class PacienteTerceraEdadSB  extends PacienteSB{
	private String codIess;

	public String getCodIess() {
		return codIess;
	}

	public void setCodIess(String codIess) {
		this.codIess = codIess;
	}
	
	protected Integer calcularDescuento() {
		System.out.println("Paciente con el 20% de descuento");
		return 20;
	}

}
