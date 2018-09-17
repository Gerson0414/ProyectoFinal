package com.asistenciaComputadoras.view;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) 
	{
		Conexion conexion = new Conexion();
		Scanner scanner = new Scanner(System.in);
		
		try {
			Menu.iniciarMenu(conexion, scanner);
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		

	}

}
