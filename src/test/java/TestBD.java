import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBD {
    private Connection conexion;
    private static final String URL_PRUEBA = "jdbc:mysql://localhost:3307/petsmile";
    private static final String USUARIO_PRUEBA = "root";
    private static final String CONTRASENA_PRUEBA = "12345";

    @Before
    public void setUp() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL_PRUEBA, USUARIO_PRUEBA, CONTRASENA_PRUEBA);
        } catch (Exception e) {
            fail("Error al configurar la conexión de prueba: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    @Test
    public void testConexionExitosa() {
        try {
            assertNotNull("La conexión a la base de datos debe ser exitosa", conexion);
            assertTrue("La conexión debe estar abierta", !conexion.isClosed());
            System.out.println("¡Conexión exitosa a la base de datos!");
        } catch (SQLException e) {
            fail("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}
