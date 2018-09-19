package com.asistenciaComputadoras.view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import com.asistenciaComputadoras.control.AccesoriosControl;
import com.asistenciaComputadoras.control.ControlComputadora;
import com.asistenciaComputadoras.control.ControlCliente;
import com.asistenciaComputadoras.control.Conexion;
import com.asistenciaComputadoras.control.DueñoControl;
import com.asistenciaComputadoras.control.ControlReparacion;
import com.asistenciaComputadoras.control.ControlTecnico;
import com.asistenciaComputadoras.entity.Accesorios;
import com.asistenciaComputadoras.entity.Computadora;
import com.asistenciaComputadoras.entity.Cliente;
import com.asistenciaComputadoras.entity.Dueño;
import com.asistenciaComputadoras.entity.Reparacion;
import com.asistenciaComputadoras.entity.Tecnico;

public class Menu {
	public static void iniciarMenu(Conexion conexion, Scanner scanner) throws Throwable {
		System.out.println("\n-----------Servicio de Computadoras 'SerTecCom' ------------");
		System.out.println("1. Accesorios");
		System.out.println("2. Computadora");
		System.out.println("3. Cliente");
		System.out.println("4. Dueño");
		System.out.println("5. Tecnico");
		System.out.println("6. Reparacion");
		System.out.println("0. Salir");
		int opcion1 = ReadTypes.leerEntero(scanner, "Ingrese un Opcion: ");

		switch (opcion1) {
			case 0:
				System.exit(1);
				break;
			case 1:
				editarAccesorios(conexion, scanner);
				break;
			case 2:
				editarComputadora(conexion, scanner);
				break;
			case 3:
				editarCliente(conexion, scanner);
				break;
			case 4:
				editarDueño(conexion, scanner);
				break;
			case 5:
				editarTecnico(conexion, scanner);
				break;
			case 6:
				editarReparacion(conexion, scanner);
				break;
			default:
				System.err.println("Error");
				break;
		}
		System.out.println("\nListo!");
	}

	private static void editarAccesorios(Conexion conexion, Scanner scanner) throws Throwable {
		AccesoriosControl accesoriosControl = new AccesoriosControl(conexion);
 
		int opcion = pedirInformacion(scanner);

		switch (opcion) {
			case 1:
				System.out.println("\nListando accesorios...\n");
				ArrayList<Accesorios> lista = accesoriosControl.list();
				for (int i = 0; i < lista.size(); i++) {
					System.out.println(lista.get(i).toString());
				}
				break;
			case 2:
				System.out.println("\nInsertando un nuevo accesorio...");
				String nombre = ReadTypes.leerCadena(scanner, "Ingrese un nombre: ");
				int precio = ReadTypes.leerEntero(scanner, "Ingrese el precio: ");
				String modelo = ReadTypes.leerCadena(scanner, "Ingrese un modelo: ");

				accesoriosControl.insert(new Accesorios(nombre, precio, modelo));
				break;
			case 3:
				System.out.println("\nBuscando accesorio...");
				int codigo = ReadTypes.leerEntero(scanner, "Ingrese un codigo: ");
				Accesorios a = new Accesorios(codigo);
				accesoriosControl.search(a);
				System.out.println(a.toString());
				break;
			case 4:
				System.out.println("\nActualizando accesorio...");

				int codigoNuevo = ReadTypes.leerEntero(scanner, "Ingrese el codigo: ");
				String nombreNuevo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo nombre: ");
				int precioNuevo = ReadTypes.leerEntero(scanner, "Ingresa el nuevo precio: ");
				String modeloNuevo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo modelo: ");

				accesoriosControl.update(new Accesorios(codigoNuevo, nombreNuevo, precioNuevo, modeloNuevo));
				break;
			default:
				System.err.println("\nError");
				break;
		}
	}
	private static void editarComputadora(Conexion conexion, Scanner scanner) throws Throwable {
		ControlComputadora controlComputadora = new ControlComputadora(conexion);

		int opcion = pedirInformacion(scanner);

		switch (opcion) {
			case 1:
				System.out.println("\nListando computadoras...\n");
				ArrayList<Computadora> lista = controlComputadora.list();
				for (int i = 0; i < lista.size(); i++) {
					System.out.println(lista.get(i).toString());
				}
				break;
			case 2:
				System.out.println("\nInsertando una nueva computadora...\n");

				String marca = ReadTypes.leerCadena(scanner, "Ingrese la marca: ");
				String modelo = ReadTypes.leerCadena(scanner, "Ingrese el modelo: ");
				String codigoCliente = ReadTypes.leerCadena(scanner, "Ingrese el codigoCliente:");
				
				int codCliente = Integer.parseInt(codigoCliente);
				controlComputadora.insert(new Computadora(marca, modelo,codCliente));
				break;
			case 3:
				System.out.println("\nBuscando computadora...");
				int codigo = ReadTypes.leerEntero(scanner, "Ingrese un codigo: ");
				Computadora c = new Computadora(codigo);
				controlComputadora.search(c);
				System.out.println(c.toString());
				break;
			case 4:
				System.out.println("\nActualizando computadora...");

				int codigoNuevo = ReadTypes.leerEntero(scanner, "Ingrese el codigo: ");
				String marcaNuevo = ReadTypes.leerCadena(scanner, "Ingrese la nueva marca: ");
				String modeloNuevo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo modelo: ");

				controlComputadora.update(new Computadora(codigoNuevo, marcaNuevo, modeloNuevo));
				break;
			default:
				System.err.println("\nError");
				break;
		}
	}
	private static void editarCliente(Conexion conexion, Scanner scanner) throws Throwable {
		ControlCliente controlCliente = new ControlCliente(conexion);

		int opcion = pedirInformacion(scanner);

		switch (opcion) {
			case 1:
				System.out.println("\nListando clientes...\n");
				ArrayList<Cliente> lista = controlCliente.list();
				for (int i = 0; i < lista.size(); i++) {
					System.out.println(lista.get(i).toString());
				}
				break;
			case 2:
				System.out.println("\nInsertando un nuevo cliente...");

				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
				String apellido = ReadTypes.leerCadena(scanner, "Ingrese el apellido: ");
				int computadora = ReadTypes.leerEntero(scanner, "Ingrese el codigo de la computadora: ");

				controlCliente.insert(new Cliente(nombre, apellido, computadora));
				break;
			case 3:
				System.out.println("\nBuscando cliente...");
				int codigo = ReadTypes.leerEntero(scanner, "Ingrese un codigo: ");
				Cliente c = new Cliente(codigo);
				controlCliente.search(c);
				System.out.println(c.toString());
				break;
			case 4:
				System.out.println("\nActualizando cliente...");

				int codigoNuevo = ReadTypes.leerEntero(scanner, "Ingrese el codigo: ");
				String nombreNuevo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo nombre: ");
				String apellidoNuevo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo apellido: ");
				int computadoraNuevo = ReadTypes.leerEntero(scanner, "Ingrese la nueva computadora: ");

				controlCliente.update(new Cliente(codigoNuevo, nombreNuevo, apellidoNuevo, computadoraNuevo));
				break;
			default:
				System.err.println("\nError");
				break;
		}
	}

	private static void editarDueño(Conexion conexion, Scanner scanner) throws Throwable {
		DueñoControl dueñoControl = new DueñoControl(conexion);

		int opcion = pedirInformacion(scanner);

		switch (opcion) {
			case 1:
				System.out.println("\nListando dueños...\n");
				ArrayList<Dueño> lista = dueñoControl.list();
				for (int i = 0; i < lista.size(); i++) {
					System.out.println(lista.get(i).toString());
				}
				break;
			case 2:
				System.out.println("\nInsertando un nuevo dueño...");

				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
				String apellido = ReadTypes.leerCadena(scanner, "Ingrese el apellido: ");
				String usuario = ReadTypes.leerCadena(scanner, "Ingrese el usuario: ");
				String contraseña = ReadTypes.leerCadena(scanner, "Ingrese la contraseña: ");

				dueñoControl.insert(new Dueño(nombre, apellido, usuario, contraseña));
				break;
			case 3:
				System.out.println("\nBuscando dueño...");
				int codigo = ReadTypes.leerEntero(scanner, "Ingrese un codigo: ");
				Dueño d = new Dueño(codigo);
				dueñoControl.search(d);
				System.out.println(d.toString());
				break;
			case 4:
				System.out.println("\nActualizando dueño...");

				int codigoNuevo = ReadTypes.leerEntero(scanner, "Ingrese el codigo: ");
				String nombreNuevo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo nombre: ");
				String apellidoNuevo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo apellido: ");
				String usuarioNuevo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo usuario: ");
				String contraseñaNuevo = ReadTypes.leerCadena(scanner, "Ingrese la nueva contraseña: ");

				dueñoControl.update(new Dueño(codigoNuevo, nombreNuevo, apellidoNuevo, usuarioNuevo, contraseñaNuevo));
				break;
			default:
				System.err.println("\nError");
				break;
		}
	}
	private static void editarReparacion(Conexion conexion, Scanner scanner) throws Throwable {
		ControlReparacion controlReparacion = new ControlReparacion(conexion);

		int opcion = pedirInformacion(scanner);

		switch (opcion) {
			case 1:
				System.out.println("\nListando reparaciones...\n");
				ArrayList<Reparacion> lista = controlReparacion.list();
				for (int i = 0; i < lista.size(); i++) {
					System.out.println(lista.get(i).toString());
				}
				break;
			case 2:
				System.out.println("\nInsertando una reparacion...");

				String problema = ReadTypes.leerCadena(scanner, "Ingrese el problema: ");
				String solucion = ReadTypes.leerCadena(scanner, "Ingrese la solucion: ");
				int codigoComputadora = ReadTypes.leerEntero(scanner, "Ingrese el codigo de la computadora: ");
				int codigoTecnico = ReadTypes.leerEntero(scanner, "Ingrese el codigo del tecnico: ");
				int codigoCliente = ReadTypes.leerEntero(scanner, "Ingrese el codigo del cliente: ");
				Date fechaIngreso = ReadTypes.leerFecha(scanner, "Ingrese la fecha de ingreso: ");
				Date fechaSalida = ReadTypes.leerFecha(scanner, "Ingrese la fecha de salida: ");

				controlReparacion.insert(new Reparacion(problema, solucion, codigoComputadora, codigoTecnico, codigoCliente,
						fechaIngreso, fechaSalida));
				break;
			case 3:
				System.out.println("\nBuscando reparacion...");
				int codigo = ReadTypes.leerEntero(scanner, "Ingrese un codigo: ");
				Reparacion r = new Reparacion(codigo);
				controlReparacion.search(r);
				System.out.println(r.toString());
				break;
			case 4:
				System.out.println("\nActualizando reparacion...");

				int codNuevo = ReadTypes.leerEntero(scanner, "Ingrese el codigo:  ");
				int codComputadoraNuevo = ReadTypes.leerEntero(scanner, "Ingrese el codigo de la computadora:   ");
				int codTecnicoNuevo = ReadTypes.leerEntero(scanner, " Ingrese el codigo del tecnico:   " );
				int codClienteNuevo = ReadTypes.leerEntero(scanner, "Ingrese el codigo del cliente:   ");
				String problemaNuevo = ReadTypes.leerCadena(scanner, "Ingrese el problema:  " );
				String solucionNuevo = ReadTypes.leerCadena(scanner, " Ingrese la solucion:  ");
				Date fechaIngresoNuevo = ReadTypes.leerFecha(scanner, "Ingrese la fecha de ingreso:  ");
				Date fechaSalidaNuevo = ReadTypes.leerFecha(scanner, "Ingrese la fecha de salida:   ");
				
				controlReparacion.update(new Reparacion(codNuevo, codComputadoraNuevo, codTecnicoNuevo, codClienteNuevo, problemaNuevo, solucionNuevo, fechaIngresoNuevo, fechaSalidaNuevo));
				break;
			default:
				System.err.println("\nError");
				break;
		}
	}

	private static void editarTecnico(Conexion conexion, Scanner scanner) throws Throwable {
		ControlTecnico controlTecnico = new ControlTecnico(conexion);

		int opcion = pedirInformacion(scanner);

		switch (opcion) {
			case 1:
				System.out.println("\nListando tecnicos...\n");
				ArrayList<Tecnico> lista = controlTecnico.list();
				for (int i = 0; i < lista.size(); i++) {
					System.out.println(lista.get(i).toString());
				}
				break;
			case 2:
				System.out.println("\nInsertando un nuevo tecnico...");

				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
				String apellido = ReadTypes.leerCadena(scanner, "Ingrese el apellido: ");
				String usuario = ReadTypes.leerCadena(scanner, "Ingrese el usuario: ");
				String contraseña = ReadTypes.leerCadena(scanner, "Ingrese la contraseña: ");

				controlTecnico.insert(new Tecnico(nombre, apellido, usuario, contraseña));
				break;
			case 3:
				System.out.println("\nBuscando tecnico...");
				int codigo = ReadTypes.leerEntero(scanner, "Ingrese un codigo: ");
				Tecnico t = new Tecnico(codigo);
				controlTecnico.search(t);
				System.out.println(t.toString());
				break;
			case 4:
				System.out.println("\nActualizando tecnico...");

				int codigoNuevo = ReadTypes.leerEntero(scanner, "Ingrese el codigo: ");
				String nombreNuevo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo nombre: ");
				String apellidoNuevo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo apellido: ");
				String usuarioNuevo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo usuario: ");
				String contraseñaNuevo = ReadTypes.leerCadena(scanner, "Ingrese la nueva contraseña: ");

				controlTecnico
						.update(new Tecnico(codigoNuevo, nombreNuevo, apellidoNuevo, usuarioNuevo, contraseñaNuevo));
				break;
			default:
				System.err.println("\nError");
				break;
		}
	}

	private static int pedirInformacion(Scanner scanner) {
		System.out.println("\n1. Listar");
		System.out.println("2. Insertar");
		System.out.println("3. Buscar");
		System.out.println("4. Actualizar");

		int opcion = ReadTypes.leerEntero(scanner, "Opcion: ");

		return opcion;
	}

}


