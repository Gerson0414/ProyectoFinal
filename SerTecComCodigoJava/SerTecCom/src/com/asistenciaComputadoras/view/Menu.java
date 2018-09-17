package com.asistenciaComputadoras.view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import com.asistenciaComputadoras.control.AccesoriosControl;
import com.asistenciaComputadoras.control.CelularControl;
import com.asistenciaComputadoras.control.ClienteControl;
import com.asistenciaComputadoras.control.Conexion;
import com.asistenciaComputadoras.control.DueñoControl;
import com.asistenciaComputadoras.control.ReparacionControl;
import com.asistenciaComputadoras.control.TecnicoControl;
import com.asistenciaComputadoras.entity.Accesorios;
import com.asistenciaComputadoras.entity.Celular;
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

				accesoriosControl.insert(new Accesorios(nombre, precio, tipo));
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
		ComputadoraControl computadoraControl = new ComputadoraControl(conexion);

		int opcion = pedirInformacion(scanner);

		switch (opcion) {
			case 1:
				System.out.println("\nListando computadoras...\n");
				ArrayList<Computadora> lista = computadoraControl.list();
				for (int i = 0; i < lista.size(); i++) {
					System.out.println(lista.get(i).toString());
				}
				break;
			case 2:
				System.out.println("\nInsertando una nueva computadora...\n");

				String marca = ReadTypes.leerCadena(scanner, "Ingrese la marca: ");
				String modelo = ReadTypes.leerCadena(scanner, "Ingrese el modelo: ");
				String estadoComputadora = ReadTypes.leerCadena(scanner, "Ingrese el estado de la computadora: ");

				computadoraControl.insert(new Computadora(marca, modelo, estadoComputadora));
				break;
			case 3:
				System.out.println("\nBuscando computadora...");
				int codigo = ReadTypes.leerEntero(scanner, "Ingrese un codigo: ");
				Computadora c = new Computadora(codigo);
				computadoraControl.search(c);
				System.out.println(c.toString());
				break;
			case 4:
				System.out.println("\nActualizando computadora...");

				int codigoNuevo = ReadTypes.leerEntero(scanner, "Ingrese el codigo: ");
				String marcaNuevo = ReadTypes.leerCadena(scanner, "Ingrese la nueva marca: ");
				String modeloNuevo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo modelo: ");
				String estadoComputadoraNuevo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo estado de la computadora: ");

				computdoraControl.update(new Computadora(codigoNuevo, marcaNuevo, modeloNuevo, estadoComputadoraNuevo));
				break;
			default:
				System.err.println("\nError");
				break;
		}
	}
	private static void editarCliente(Conexion conexion, Scanner scanner) throws Throwable {
		ClienteControl clienteControl = new ClienteControl(conexion);

		int opcion = pedirInformacion(scanner);

		switch (opcion) {
			case 1:
				System.out.println("\nListando clientes...\n");
				ArrayList<Cliente> lista = clienteControl.list();
				for (int i = 0; i < lista.size(); i++) {
					System.out.println(lista.get(i).toString());
				}
				break;
			case 2:
				System.out.println("\nInsertando un nuevo cliente...");

				String nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
				String apellido = ReadTypes.leerCadena(scanner, "Ingrese el apellido: ");
				int computadora = ReadTypes.leerEntero(scanner, "Ingrese la computadora: ");

				clienteControl.insert(new Cliente(nombre, apellido, computadora));
				break;
			case 3:
				System.out.println("\nBuscando cliente...");
				int codigo = ReadTypes.leerEntero(scanner, "Ingrese un codigo: ");
				Cliente c = new Cliente(codigo);
				clienteControl.search(c);
				System.out.println(c.toString());
				break;
			case 4:
				System.out.println("\nActualizando cliente...");

				int codigoNuevo = ReadTypes.leerEntero(scanner, "Ingrese el codigo: ");
				String nombreNuevo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo nombre: ");
				String apellidoNuevo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo apellido: ");
				int computadoraNuevo = ReadTypes.leerEntero(scanner, "Ingrese la nueva computadora: ");

				clienteControl.update(new Cliente(codigoNuevo, nombreNuevo, apellidoNuevo, computadoraNuevo));
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
		ReparacionControl reparacionControl = new ReparacionControl(conexion);

		int opcion = pedirInformacion(scanner);

		switch (opcion) {
			case 1:
				System.out.println("\nListando reparaciones...\n");
				ArrayList<Reparacion> lista = reparacionControl.list();
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

				reparacionControl.insert(new Reparacion(problema, solucion, codigoComputadora, codigoTecnico, codigoCliente,
						fechaIngreso, fechaSalida));
				break;
			case 3:
				System.out.println("\nBuscando reparacion...");
				int codigo = ReadTypes.leerEntero(scanner, "Ingrese un codigo: ");
				Reparacion r = new Reparacion(codigo);
				reparacionControl.search(r);
				System.out.println(r.toString());
				break;
			case 4:
				System.out.println("\nActualizando reparacion...");

				int codigoNuevo = ReadTypes.leerEntero(scanner, "Ingrese el codigo: ");
				String problemaNuevo = ReadTypes.leerCadena(scanner, "Ingrese el problema: ");
				String solucionNuevo = ReadTypes.leerCadena(scanner, "Ingrese la solucionn: ");
				int codigoComputadoraNuevo = ReadTypes.leerEntero(scanner, "Ingrese el codigo de la computadora: ");
				int codigoTecnicoNuevo = ReadTypes.leerEntero(scanner, "Ingrese el codigo del tecnico: ");
				int codigoClienteNuevo = ReadTypes.leerEntero(scanner, "Ingrese el codigo del cliente: ");
				Date fechaIngresoNuevo = ReadTypes.leerFecha(scanner, "Ingrese la fecha de ingreso: ");
				Date fechaSalidaNuevo = ReadTypes.leerFecha(scanner, "Ingrese la fecha de salida: ");

				reparacionControl.update(new Reparacion(codigoNuevo, problemaNuevo, solucionNuevo, codigoComputadoraNuevo,
						codigoTecnicoNuevo, codigoClienteNuevo, fechaIngresoNuevo, fechaSalidaNuevo));
				break;
			default:
				System.err.println("\nError");
				break;
		}
	}

	private static void editarTecnico(Conexion conexion, Scanner scanner) throws Throwable {
		TecnicoControl tecnicoControl = new TecnicoControl(conexion);

		int opcion = pedirInformacion(scanner);

		switch (opcion) {
			case 1:
				System.out.println("\nListando tecnicos...\n");
				ArrayList<Tecnico> lista = tecnicoControl.list();
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

				tecnicoControl.insert(new Tecnico(nombre, apellido, usuario, contraseña));
				break;
			case 3:
				System.out.println("\nBuscando tecnico...");
				int codigo = ReadTypes.leerEntero(scanner, "Ingrese un codigo: ");
				Tecnico t = new Tecnico(codigo);
				tecnicoControl.search(t);
				System.out.println(t.toString());
				break;
			case 4:
				System.out.println("\nActualizando tecnico...");

				int codigoNuevo = ReadTypes.leerEntero(scanner, "Ingrese el codigo: ");
				String nombreNuevo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo nombre: ");
				String apellidoNuevo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo apellido: ");
				String usuarioNuevo = ReadTypes.leerCadena(scanner, "Ingrese el nuevo usuario: ");
				String contraseñaNuevo = ReadTypes.leerCadena(scanner, "Ingrese la nueva contraseña: ");

				tecnicoControl
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


