package com.asistenciaComputadoras.control;


import java.sql.ResultSet;
import java.util.ArrayList;



import com.asistenciaComputadoras.entity.Tecnico;





public class ControlTecnico implements Control<Tecnico>
{
	private Conexion conexion; 
	public ControlTecnico(Conexion conexion)
	{
		this.conexion = conexion;
	}
	@Override
    public ArrayList<Tecnico> list() throws Throwable{
		ArrayList<Tecnico> lista_tecnicos = new ArrayList<>();
		ResultSet rs;
		conexion.SQL("Select * from tecnico");
		rs = conexion.resultSet();
		
		while(rs.next()){
			int codigo = rs.getInt("CodTecnico");
			String nombreTe = rs.getString("nombre");
			String apellidoTe = rs.getString("apellido");
			String usuarioTe = rs.getString("usuario");
			String contrase�aTe = rs.getString("contrase�a");
			lista_tecnicos.add(new Tecnico(codigo, nombreTe, apellidoTe, usuarioTe, contrase�aTe ));
			
		}
		return lista_tecnicos;
	}
	@Override
	public void insert (Tecnico tecnico) throws Throwable{
		System.out.println(tecnico.getContrase�aTe());
		conexion.SQL("Insert into tecnico (NombreTe, ApellidoTe, UsuarioTe, Contrase�aTe) VALUES(?,?,?,?) ");
		conexion.preparedStatement().setString(1, tecnico.getNombreTe());
		conexion.preparedStatement().setString(2, tecnico.getApellidoTe());
		conexion.preparedStatement().setString(3, tecnico.getUsuarioTe());
		conexion.preparedStatement().setString(4, tecnico.getContrase�aTe());
		conexion.CUD();
	}
	@Override
    public void search (Tecnico tecnico) throws Throwable {
    	ResultSet rs;
    	conexion.SQL("Select * from tecnico where CodTecnico");
    	conexion.preparedStatement().setInt(1, tecnico.getCodigo());
    	rs = conexion.resultSet();
    	while (rs.next())
    	{
    		tecnico.setNombreTe(rs.getString("Nombre"));
    		tecnico.setApellidoTe(rs.getString("Apellido"));
    		tecnico.setUsuarioTe(rs.getString("Usuario"));
    		tecnico.setContrase�aTe(rs.getString("Contrase�a"));
    		
    	}
    	rs.close();
    }
	@Override
    public void update(Tecnico tecnico) throws Throwable {
    	if (tecnico != null)
    	{
    		int codigo = tecnico.getCodigo();
    		String apellidoTe = tecnico.getApellidoTe();
    		String nombreTe = tecnico.getNombreTe();
    		String usuarioTe = tecnico.getUsuarioTe();
    		String contrase�aTe = tecnico.getContrase�aTe();
    		
    		
    		conexion.SQL(" Update tecnico set Nombre,Apellido,Usuario,Contrase�a where CodTecnico");
    		conexion.preparedStatement().setString(1, nombreTe);
    		conexion.preparedStatement().setString(2, apellidoTe);
    		conexion.preparedStatement().setString(3, usuarioTe);
    		conexion.preparedStatement().setString(4, contrase�aTe);
    		conexion.preparedStatement().setInt(5, codigo);
    		conexion.CUD();
    	}
    }
	
	
    
    
}
