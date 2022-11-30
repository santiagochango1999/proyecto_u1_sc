package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.SpringBoot.CitaMedicaSB;
import com.example.demo.SpringBoot.MedicoSB;
import com.example.demo.SpringBoot.PacienteCancerSB;
import com.example.demo.SpringBoot.PacienteTerceraEdadSB;
import com.example.demo.banco.modelo.CuentaBancaria;
import com.example.demo.banco.service.ICuentaBancariaService;
import com.example.demo.herencia.PacienteCancerH;

@SpringBootApplication
public class ProyectoU1ScApplication implements CommandLineRunner{

	@Autowired
	private ICuentaBancariaService bancariaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU1ScApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		CuentaBancaria cuenta1=new CuentaBancaria();
		cuenta1.setNumero("0001");
		cuenta1.setTipo("A");
		cuenta1.setTitular("Juan Perez");
		cuenta1.setSaldo(new BigDecimal(100));
		this.bancariaService.insertar(cuenta1);
		
		CuentaBancaria cuenta2=new CuentaBancaria();
		cuenta2.setNumero("0002");
		cuenta2.setTipo("A");
		cuenta2.setTitular("Maria Sanchez");
		cuenta2.setSaldo(new BigDecimal(150));
		this.bancariaService.insertar(cuenta2);
	}

}
