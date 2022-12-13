package com.example.demo.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.tienda.modelo.Cliente;
import com.example.demo.tienda.modelo.Factura;
import com.example.demo.tienda.modelo.ItemTO;
import com.example.demo.tienda.repository.IClienteRepository;
import com.example.demo.tienda.repository.IFacturaRepository;

@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private IClienteRepository clienteRepository;
	@Autowired
	private IFacturaRepository facturaRepository;
	@Override
	public void generar(String cedulaCliente, List<ItemTO> detalles) {
		// TODO Auto-generated method stub
		
		Cliente cliente =this.clienteRepository.buscar(cedulaCliente);
		Factura miFactura=new Factura();
		miFactura.setCliente(cliente);
		this.facturaRepository.insertar(null);
	}

}
