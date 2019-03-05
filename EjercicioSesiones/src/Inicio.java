
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Inicio
 */
@WebServlet("/inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter salida = response.getWriter();
		
		HttpSession sesion = request.getSession(); 
		
		if(sesion.isNew()) {
			salida.append("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"	<meta charset=\"utf-8\">\r\n" + 
					"	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
					"	<title>Ejercicio Sesiones</title>\r\n" + 
					"	<style type=\"text/css\" media=\"screen\">\r\n" + 
					"		\r\n" + 
					"	</style>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<form method=\"get\" accept-charset=\"utf-8\">\r\n" + 
					"		<fieldset>\r\n" + 
					"			<legend>Pon tu nombre!!!!</legend>\r\n" + 
					"			<label><input type=\"text\" name=\"nombre\" placeholder=\"Pon aquí tu nombre\"></label>\r\n" + 
					"			<input type=\"submit\" value=\"Púlsame!\">\r\n" + 
					"		</fieldset>\r\n" + 
					"	</form>\r\n" + 
					"</body>\r\n" + 
					"</html>");
			
		} 
		else {
			if (sesion.getAttribute("nombre") == null) {
				salida.append("<!DOCTYPE html>\r\n" + 
						"<html>\r\n" + 
						"<head>\r\n" + 
						"	<meta charset=\"utf-8\">\r\n" + 
						"	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
						"	<title>Ejercicio Sesiones</title>\r\n" + 
						"</head>\r\n" + 
						"<body><h1>Hola " + request.getParameter("nombre")+
						"</h1></body>\r\n" + 
						"</html>");
				sesion.setAttribute("nombre", request.getParameter("nombre"));
			} 
			else {
				salida.append("<!DOCTYPE html>\r\n" + 
						"<html>\r\n" + 
						"<head>\r\n" + 
						"	<meta charset=\"utf-8\">\r\n" + 
						"	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
						"	<title>Ejercicio Sesiones</title>\r\n" + 
						"</head>\r\n" + 
						"<body><h1>Hola de nuevo " + sesion.getAttribute("nombre")+"</h1> </body>\r\n" + 
						"</html>");
			}
			
		}
		
	}

}
