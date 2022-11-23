package com.example.demo.SpringBoot;

public class PacienteSB {
	
	private String nombre;
	private String cedula;
	private String tipo;
	
	protected Integer calcularDescuento() {
		System.out.println("Sin Descuento");
		return 0;
	}
	
	//GET Y SET
	public String getNombre() {
		return nombre;
	}
	public  void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public  String getCedula() {
		return cedula;
	}
	public  void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public  String getTipo() {
		return tipo;
	}
	public  void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Paciente [nombre=" + nombre + ", cedula=" + cedula + "]";
	}
	

}