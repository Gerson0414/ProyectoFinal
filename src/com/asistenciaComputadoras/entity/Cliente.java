package com.asistenciaComputadoras.entity;

public class Cliente 
{
	private int codigo;
	private String nombre;
	private String apellido;

	private int computadora;
	
	public Cliente (int codigo, String nombre, String apellido, int computadora){
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.computadora = computadora;
	}
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getComputadora() {
		return computadora;
	}

	public void setComputadora(int computadora) {
		this.computadora = computadora;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", computadora="
				+ computadora + "]";
	}

	
	

}
