package com.asistenciaComputadoras.entity;

public class Computadora 
{
	private String marca;
	private String modelo;
	private int codigo;
	private int codCliente;
	
	public Computadora(int codigo, String marca, String modelo)
	{
		this.marca = marca;
		this.modelo = modelo;
		this.codigo = codigo;
	}
	public Computadora(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}
	public Computadora(String marca, String modelo, int codCliente){

		this.marca = marca;
		this.modelo = modelo;
		this.codCliente = codCliente;
		
	}

	public Computadora(int codigo) {
		this.codigo = codigo;
	}
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodCliente(){
		return codCliente;
	}
	@Override
	public String toString() {
		return "Computadora [marca=" + marca + ", modelo=" + modelo + ", codigo=" + codigo + "]";
	}
	

}
