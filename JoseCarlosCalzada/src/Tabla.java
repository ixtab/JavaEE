
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Tabla
 */
@WebServlet("/Tabla")
public class Tabla extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tabla() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numero = Integer.parseInt(request.getParameter("numero"));
		PrintWriter ficheroHTML=response.getWriter();
		HttpSession sesion=request.getSession(true);
		response.setContentType("text/html");
		ficheroHTML.println("<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "<title>Tabla de Multiplicar del " + numero +"</title>\n"
				+ "<link href=\"https://fonts.googleapis.com/css?family=Special+Elite\" rel=\"stylesheet\">"
				+ "<link rel='stylesheet' type=\"text/css\" href='css/style.css'>"
				+ "</head>\n"
				+ "<body>\n"
				+ "<div class='tabla shadow muever'>"
				+ "<h1> Tabla del " + numero + "</h1>" 
				+ "<ul>\n");
		for(int i = 1; i <=10; i++) {
			ficheroHTML.println("<li>" + numero + " x " + i + " = " + numero * i + "</li>");
		}
		ficheroHTML.println("<p class =\"sesion\">Id de Sesión: " + sesion.getId() + "</p>");
		ficheroHTML.println("</ul>\n"
				+ "</div>"
				+ "</body>\n"
				+ "</html>\n");
	}

}
