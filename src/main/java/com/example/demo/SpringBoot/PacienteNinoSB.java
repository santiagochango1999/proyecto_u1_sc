package com.example.demo.SpringBoot;

import org.springframework.stereotype.Component;

@Component
public class PacienteNinoSB extends PacienteSB {
	private int pesonacimiento;

	public int getPesonacimiento() {
		return pesonacimiento;
	}

	public void setPesonacimiento(int pesonacimiento) {
		this.pesonacimiento = pesonacimiento;
	}
	

	protected Integer calcularDescuento() {
		System.out.println("Paciente Niño con el 10% de descuento");
		return 10;
	}

}
