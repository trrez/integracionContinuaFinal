package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.Conexion;

public class LoginDao {

	public static int validar(String nombreUsuario, String password) {
	    Connection con = null;
	    Conexion cn = new Conexion();
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    int resultado = 0; // 0: Credenciales incorrectas, -1: Error de base de datos, 1: Validación exitosa
	    String sql = "SELECT * FROM petsmile.usuario WHERE nombreUsuario = ? AND password = ?";

	    try {
	        con = cn.getConnection();
	        if (con != null) {
	            ps = con.prepareStatement(sql);
	            ps.setString(1, nombreUsuario);
	            ps.setString(2, password);
	            rs = ps.executeQuery();

	            // Verifica si hay al menos una fila en el conjunto de resultados
	            if (rs.next()) {
	                resultado = 1; // Validación exitosa
	            } else {
	                resultado = 0; // Credenciales incorrectas
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        resultado = -1; // Error de base de datos
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return resultado;
	}
}
