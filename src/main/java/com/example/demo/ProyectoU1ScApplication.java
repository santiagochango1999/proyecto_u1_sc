package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.SpringBoot.CitaMedicaSB;
import com.example.demo.SpringBoot.MedicoSB;
import com.example.demo.SpringBoot.PacienteCancerSB;
import com.example.demo.SpringBoot.PacienteTerceraEdadSB;
import com.example.demo.banco.modelo.CuentaBancaria;
import com.example.demo.banco.modelo.Transferencia;
import com.example.demo.banco.service.ICuentaBancariaService;
import com.example.demo.banco.service.ITransferenciaService;
import com.example.demo.ejercicio1.modelo.Propietario;
import com.example.demo.ejercicio1.modelo.Vehiculo;
import com.example.demo.ejercicio1.service.IMatriculaNuevaService;
import com.example.demo.ejercicio1.service.IMatriculaService;
import com.example.demo.ejercicio1.service.IPropietarioService;
import com.example.demo.ejercicio1.service.IVehiculoService;
import com.example.demo.herencia.PacienteCancerH;

@SpringBootApplication
public class ProyectoU1ScApplication implements CommandLineRunner{

	@Autowired
	private IVehiculoService iVehiculoService;
	
	@Autowired
	private IPropietarioService iPropietarioService;
	
	@Autowired
	@Qualifier("pesado")
	private IMatriculaNuevaService iMatriculaService;
	
	@Autowired
	@Qualifier("liviano")
	private IMatriculaNuevaService iMatriculaServiceliviano;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU1ScApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Vehiculo vehi=new Vehiculo();
		vehi.setMarca("toyota");
		vehi.setPlaca("pds");
		vehi.setPrecio(new BigDecimal(20000));
		vehi.setTipo("l");
		
		this.iVehiculoService.crear(vehi);
		
		vehi.setPrecio(new BigDecimal(10000));
		vehi.setMarca("Toyota");
		
		this.iVehiculoService.modificar(vehi);
		
		Propietario propietario=new Propietario();
		propietario.setApellido("cayambe");
		propietario.setCedula("12147552");
		propietario.setFechaNacimiento(LocalDateTime.of(1989,7,7,12,35 ));
		propietario.setNombre("Edison");
		
		this.iPropietarioService.guardar(propietario);
		
		
		
		
//		CuentaBancaria cuenta1=new CuentaBancaria();
//		cuenta1.setNumero("0001");
//		cuenta1.setTipo("A");
//		cuenta1.setTitular("Juan Perez");
//		cuenta1.setSaldo(new BigDecimal(100));
//		this.bancariaService.insertar(cuenta1);
//		
//		CuentaBancaria cuenta2=new CuentaBancaria();
//		cuenta2.setNumero("0002");
//		cuenta2.setTipo("A");
//		cuenta2.setTitular("Maria Sanchez");
//		cuenta2.setSaldo(new BigDecimal(200));
//		this.bancariaService.insertar(cuenta2);
//		
//		
//		System.out.println("Saldos actuales:");
//		CuentaBancaria cuentaActual1=this.bancariaService.buscarPorNUmero("0001");
//		CuentaBancaria cuentaActual2=this.bancariaService.buscarPorNUmero("0002");
//		System.out.println("Saldo actual: "+cuentaActual1.getSaldo());
//		System.out.println("Saldo actual: "+cuentaActual2.getSaldo());
//
//		
//		System.out.println("Reporte 1");
//		for(Transferencia t:this.iTransferenciaService.buscarReporte()) {
//			System.out.println(t);
//		}
//		
//		this.iTransferenciaService.realizar("0001", "0002", new BigDecimal(10));
//		
//		System.out.println("Reporte 2");
//		for(Transferencia t:this.iTransferenciaService.buscarReporte()) {
//			System.out.println(t);
//		}
//		
//		System.out.println("Saldos nuevos:");
//		CuentaBancaria cuentaconsultada1=this.bancariaService.buscarPorNUmero("0001");
//		CuentaBancaria cuentaconsultada2=this.bancariaService.buscarPorNUmero("0002");
//		System.out.println("Nuevo saldo: "+cuentaconsultada1.getSaldo());
//		System.out.println("Nuevo saldo: "+cuentaconsultada2.getSaldo());

	}

}
