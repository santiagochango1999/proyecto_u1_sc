package com.example.demo.ejercicio1.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.ejercicio1.modelo.Matricula;
import com.example.demo.ejercicio1.modelo.Propietario;
import com.example.demo.ejercicio1.modelo.Vehiculo;
import com.example.demo.ejercicio1.repository.IMatriculaRepository;
import com.example.demo.ejercicio1.repository.IPropietarioRepository;
import com.example.demo.ejercicio1.repository.IVehiculoRepository;

@Service
public class GestorMatriculaServiceImpl implements IGestorMatriculaService {

	@Autowired
	@Qualifier("pesado")
	private IMatriculaNuevaService iMatriculaService;

	@Autowired
	@Qualifier("liviano")
	private IMatriculaNuevaService iMatriculaServiceliviano;

	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	@Autowired
	private IPropietarioRepository iPropietarioRepository;

	@Override
	public void matricular(String cedula, String placa) {
		// TODO Auto-generated method stub
		Propietario pro = this.iPropietarioRepository.buscar(cedula);

		Vehiculo vehiculo = this.iVehiculoRepository.buscar(placa);

		Matricula matricula = new Matricula();
		matricula.setFecha(LocalDateTime.now());
		matricula.setPropietario(pro);
		matricula.setVehiculo(vehiculo);

		BigDecimal valor = null;
		if (vehiculo.getTipo().equals("p")) {
			valor = this.iMatriculaService.matricular(vehiculo.getPrecio());
			System.out.println("Su vehiculo es PESADO");
		} else {
			valor = this.iMatriculaServiceliviano.matricular(vehiculo.getPrecio());
			System.out.println("Su vehiculo es LIVIANO");
		}

		// programas descuento

		if (valor.compareTo(new BigDecimal(2000)) > 1) {
			BigDecimal descuento = valor.multiply(new BigDecimal(0.07));
			valor = valor.subtract(descuento);
		}

		matricula.setValor(valor);

		this.iMatriculaRepository.insertar(matricula);
		System.out.println("Se matriculo el vehiculo: " + matricula);
		System.out.println("El valor fue: " + valor);
	}

}
