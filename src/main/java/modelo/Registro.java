package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.Conexion;

public class Registro {

	public static int agregarUsuario(String nombreUsuario, String password) {
	    Connection con = null;  
	    Conexion cn = new Conexion();

	    PreparedStatement ps = null;
	    int filasAfectadas = 0;
	    String sql = "INSERT INTO petsmile.usuario (nombreUsuario, password) VALUES (?, ?);";
	    
	    try {
	        con = cn.getConnection();

	        if (con != null) {  
	            ps = con.prepareStatement(sql);
	            ps.setString(1, nombreUsuario);
	            ps.setString(2, password);
	            filasAfectadas = ps.executeUpdate(); 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();  
	    } finally {
	        try {
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace(); 
	        }
	    }

	    return filasAfectadas;
	}
}
