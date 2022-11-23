package com.example.demo.SpringBoot;

import org.springframework.stereotype.Component;

@Component
public class PacienteCancerSB extends PacienteSB{
	protected Integer calcularDescuento() {
		System.out.println("Paciente Cancer con el 30% de descuento");
		return 30;
	}
}
