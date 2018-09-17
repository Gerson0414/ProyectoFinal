package com.asistenciaComputadoras.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.asistenciaComputadoras.entity.Cliente;

public class ControlCliente 
{
	private Conexion conexion;
	
	public ControlCliente(Conexion conexion){
		this.conexion = conexion;
	}
	public ArrayList<Cliente>list() throws Throwable {
		ArrayList<Cliente> lista_clientes = new ArrayList<Cliente>();
		ResultSet rs;
		conexion.SQL("Select * from cliente");
		
		rs = conexion.resultSet();
		
		while(rs.next()) {
			int codigo = rs.getInt("Codigo_Cliente");
			int computadora = rs.getInt("computadora");
			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			
			lista_clientes.add(new Cliente(codigo, nombre, apellido, computadora ));
		}
		return lista_clientes;
	}
	
	public void insert(Cliente cliente) throws Throwable {
		conexion.SQL("Insert into cliente(nombre,apellido,computadora)VALUE(?,?,?)");
		conexion.preparedStatement().setString(1, cliente.getNombre());
		conexion.preparedStatement().setString(2, cliente.getApellido());
		conexion.preparedStatement().setInt(3, cliente.getComputadora());
		conexion.CUD();
	}
	
	public void search(Cliente cliente) throws Throwable {
		ResultSet rs;
		
		conexion.SQL("Select * from cliente where Codigo_Cliente=?");
		conexion.preparedStatement().setInt(1, cliente.getCodigo());
		rs = conexion.resultSet();
		
		while(rs.next())
		{
			cliente.setNombre(rs.getString("nombre"));
			cliente.setApellido(rs.getString("apellido"));
			cliente.setComputadora(rs.getInt("computadora"));
		}
		rs.close();
	}
	public void update(Cliente cliente) throws Throwable{
		if (cliente != null)
		{
			int codigo = cliente.getCodigo();
			int computadora = cliente.getComputadora();
			String nombre = cliente.getNombre();
			String apellido = cliente.getApellido();
			
			conexion.SQL("Update cliente set nombre=?,apellido=?,computadora=? where Codigo_Cliente=?");
			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setString(2, apellido);
			conexion.preparedStatement().setInt(3, computadora);
			conexion.preparedStatement().setInt(4, codigo);
			conexion.CUD();
			
		}
	}

}
