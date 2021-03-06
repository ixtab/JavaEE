package servlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HolaMundoSesiones
 */
@WebServlet("/HolaMundoSesiones")
public class HolaMundoSesiones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaMundoSesiones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();  // Se puede configurar el tiempo de la sesi�n en web.xml
		PrintWriter salida = response.getWriter();
		
		salida.append(sesion.getId());
		
		Integer contador = (Integer) sesion.getAttribute("contador");
		if (contador == null) {
			contador = 1;
		}
		else {
			contador++;
		}
		
		sesion.setAttribute("contador", contador);
		
		System.out.println(sesion.getAttribute("contador"));
		int cont = (int) sesion.getAttribute("contador");
		salida.append("\nAccesos a la p�gina: " + cont );
		
		if (cont == 10) {
			response.sendError(HttpServletResponse.SC_CONFLICT,
					"Fuera por pesadez");
			sesion.invalidate();
		}
		
		Cookie cookie1=new Cookie("Cookie1","Cookie-Una");
		Cookie cookie2=new Cookie("Cuqui","Cuqui");
		cookie1.setMaxAge(3600); // Una hora
		cookie2.setMaxAge(3600);
		response.addCookie(cookie1);
		response.addCookie(cookie2);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
