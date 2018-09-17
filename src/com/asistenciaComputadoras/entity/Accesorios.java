package com.asistenciaComputadoras.entity;

public class Accesorios {
 private int codigo;
 private String nombre;
 private int precio;
 private String modelo;
 
 public Accesorios(int codigo, String nombre, int precio, String modelo){
	 this.codigo = codigo;
	 this.nombre = nombre;
	 this.precio = precio;
	 this.modelo = modelo;
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

public int getPrecio() {
	return precio;
}

public void setPrecio(int precio) {
	this.precio = precio;
}

public String getModelo() {
	return modelo;
}

public void setModelo(String modelo) {
	this.modelo = modelo;
}

@Override
public String toString() {
	return "Accesorios [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", modelo=" + modelo + "]";
}
 
}
