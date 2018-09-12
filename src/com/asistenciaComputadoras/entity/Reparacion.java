package com.asistenciaComputadoras.entity;

import java.util.Date;

public class Reparacion 

{
	private int codigo;
	private int codCliente;
	private int codComputadora;
	private int codTecnico;
	private String problema;
	private String solucion;
	private Date fechaIngreso;
	private Date fechaSalida;
	
	
	public Reparacion(int codigo, int codCliente, int codComputadora, int codTecnico, String problema, String solucion, Date fechaIngreso, Date fechaSalida )
	{
		this.codComputadora = codComputadora;
		this.codCliente = codCliente;
		this.codTecnico = codTecnico;
		this.codigo = codigo;
		this.problema = problema;
		this.solucion = solucion;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		
		
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getCodCliente() {
		return codCliente;
	}


	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}


	public int getCodComputadora() {
		return codComputadora;
	}


	public void setCodComputadora(int codComputadora) {
		this.codComputadora = codComputadora;
	}


	public int getCodTecnico() {
		return codTecnico;
	}


	public void setCodTecnico(int codTecnico) {
		this.codTecnico = codTecnico;
	}


	public String getProblema() {
		return problema;
	}


	public void setProblema(String problema) {
		this.problema = problema;
	}


	public String getSolucion() {
		return solucion;
	}


	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	public Date getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	

}
