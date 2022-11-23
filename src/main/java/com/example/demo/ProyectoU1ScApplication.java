package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.SpringBoot.CitaMedicaSB;
import com.example.demo.SpringBoot.MedicoSB;
import com.example.demo.SpringBoot.PacienteCancerSB;
import com.example.demo.SpringBoot.PacienteTerceraEdadSB;
import com.example.demo.herencia.PacienteCancerH;

@SpringBootApplication
public class ProyectoU1ScApplication implements CommandLineRunner{

	@Autowired
	private PacienteTerceraEdadSB pacientete;
	
	@Autowired
	private CitaMedicaSB citaMedicaSB;
	
	@Autowired
	private MedicoSB medicSB;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU1ScApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Spring BOOT");
		this.pacientete.setCodIess("sdfasfdgfdfh");
		this.pacientete.setNombre("Edison");
		this.pacientete.setTipo("");
		this.pacientete.setCedula("23123");
		
		System.out.println(pacientete);
		
		citaMedicaSB.agendar("123123",  LocalDateTime.of(2022, 12,2,8,30), pacientete, medicSB);


	}

}
