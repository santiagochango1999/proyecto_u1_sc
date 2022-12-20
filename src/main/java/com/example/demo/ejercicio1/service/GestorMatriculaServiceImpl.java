package com.example.demo.ejercicio1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.ejercicio1.modelo.Vehiculo;

@Service
public class GestorMatriculaServiceImpl implements IGestorMatriculaService{

	@Autowired
	@Qualifier("pesado")
	private IMatriculaNuevaService iMatriculaService;
	
	@Autowired
	@Qualifier("liviano")
	private IMatriculaNuevaService iMatriculaServiceliviano;
	
	@Override
	public void matricular(String cedula, String placa) {
		// TODO Auto-generated method stub
		Vehiculo vehi=null;
		if(vehi.getTipo().equals("p")) {
			this.iMatriculaService.matricular("12147552", "pds");

		}else {
			this.iMatriculaServiceliviano.matricular("12147552", "pds");

		}
		//programas descuento
	}

}
