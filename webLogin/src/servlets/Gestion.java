package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Gestion")
public class Gestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Gestion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		
		String accion = request.getParameter("accion");
		if (sesion.isNew() || accion==null) {
			response.sendRedirect("Ferreteria");
		} 
		else {
			RequestDispatcher rd=null;
			switch (accion) {
				case "Inventario": 
					rd = request.getRequestDispatcher("/inventario.jsp");
					break;
				case "Clientes":
					rd = request.getRequestDispatcher("/clientes.jsp");
					break;
				case "Facturas":
					rd = request.getRequestDispatcher("/facturas.jsp");
					break;
				case "Home":
					rd = request.getRequestDispatcher("/home.jsp");
					break;
			}
			
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
