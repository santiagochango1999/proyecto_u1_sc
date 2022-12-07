package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.modelo.CuentaBancaria;
import com.example.demo.banco.modelo.Transferencia;
import com.example.demo.banco.repository.ITransferenciaRepository;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{

	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	
	@Autowired
	private ICuentaBancariaService bancariaService;

	@Override
	public List<Transferencia> buscarReporte() {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.buscarTodos();
	}

	@Override
	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		
		//ORIGEN
		//1.-BUSCAR LA CUENTA ORIGEN
		CuentaBancaria origen = this.bancariaService.buscarPorNUmero(numeroOrigen);
		//2.-CONSULTAR EL SALDO DE LA CUENTA ORIGEN
		BigDecimal saldoOrigen=origen.getSaldo();
		//3.-OPERACION RESTA EN EL ORIGEN
		BigDecimal nuevoSaldo= saldoOrigen.subtract(monto);
		//4.-ACTUALIZACION CUENTA ORIGEN
		origen.setSaldo(nuevoSaldo);
		this.bancariaService.actualizar(origen);
		
		//DESTINO
		//1.-BUSCAR LA CUENTA DESTINO
		CuentaBancaria destino = this.bancariaService.buscarPorNUmero(numeroDestino);
		//2.-CONSULTAR EL SALDO DE LA CUENTA DESTINO
		BigDecimal saldoDestino=destino.getSaldo();
		//3.-OPERACION SUMA EN EL DESTINO
		BigDecimal nuevoSaldoDestino= saldoDestino.add(monto);
		//4.-ACTUALIZACION CUENTA DESTINO
		destino.setSaldo(nuevoSaldoDestino);
		this.bancariaService.actualizar(destino);
		
		Transferencia trans = new Transferencia();
		trans.setCuentaDestino(numeroDestino);
		trans.setCuentaOrigen(numeroOrigen);
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
		trans.setNumero("123");
		this.iTransferenciaRepository.insertar(trans);
	}

}
