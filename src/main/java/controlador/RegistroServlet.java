package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Registro;

/**
 * Servlet implementation class RegistroServlet
 */
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String nombreUsuario, password, msg = "";

	    nombreUsuario = request.getParameter("nombreUsuario");
	    password = request.getParameter("Password");

	    try {
	        int resultado = Registro.agregarUsuario(nombreUsuario, password);

	        if (resultado == 1) {
	            msg = "Bienvenid@, " + nombreUsuario;
	        } else {
	            msg = "Error al agregar el usuario. Revise su usuario o contraseña.";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        msg = "Error al agregar el usuario: " + e.getMessage();
	    }

	    System.out.println("Resultado de validar: " + msg);

	    RequestDispatcher despachador = request.getRequestDispatcher("/index.jsp");
	    request.setAttribute("mensaje", msg);
	    despachador.forward(request, response);
	}


}
