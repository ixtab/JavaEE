package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import datos.LogicaBD;

@WebServlet("/Ferreteria")
public class Ferreteria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ferreteria() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String n = request.getParameter("nombre");
		RequestDispatcher rd; // aq� se guarda a donde se va a enviar la p�gina

		HttpSession sesion = request.getSession(true);
		
		if (n==null && !sesion.isNew()) {
			n = (String) sesion.getAttribute("nombre");
		}
		
		if (n == null)
			rd = request.getRequestDispatcher("/login.jsp"); // indica donde se envia la p�gina.
		else if (n.equals("Pepe") || n.equals("Jose")) {
			rd = request.getRequestDispatcher("/home.jsp");
			sesion.setAttribute("nombre", n);			
		}
		else {
			rd = request.getRequestDispatcher("/denegado.jsp");
			sesion.invalidate(); // Importante para que se invalide la sesi�n y vuelva a cargar el login.
		}
		
		rd.forward(request, response);  // aqu� se ejecuta el envio de la p�gina-
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// L�gica de la conexi�n con la base de datos.
		ServletContext contextoAplicacion = this.getServletContext();
		LogicaBD lbd= new LogicaBD("Aqu� la l�gica de base de datos");
		contextoAplicacion.setAttribute("miLogicaBD", lbd);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
