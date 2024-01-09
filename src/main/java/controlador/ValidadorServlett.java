package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.LoginDao;

/**
 * Servlet implementation class ValidadorServlett
 */
public class ValidadorServlett extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidadorServlett() {
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
        password = request.getParameter("password");
        
        if (LoginDao.validar(nombreUsuario, password) == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("nombreUsuario", nombreUsuario);
            msg = "Bienvenid@, " + nombreUsuario;
        } else {
            msg = "Revise su usuario o contraseña";
            request.setAttribute("error", msg);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        System.out.println("Resultado de validar: " + LoginDao.validar(nombreUsuario, password));
        System.out.println("Mensaje: " + msg);
        
        RequestDispatcher despachador = request.getRequestDispatcher("/inicio.jsp");
        request.setAttribute("mensaje", msg);
        despachador.forward(request, response);
    }


}
