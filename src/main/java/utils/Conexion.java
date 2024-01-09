package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	 Connection con;

	 public Connection getConnection() {
	     try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb?serverTimezone=UTC", "root", "12345");
	         System.out.println("Conexión a la base de datos establecida correctamente.");
	     } catch (Exception e) {
	         e.printStackTrace();
	         System.out.println("Error al establecer la conexión a la base de datos: " + e.getMessage());
	     }
	     return con;
	 }

}
