package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Procesar
 */
@WebServlet({"/Procesar", "/en/un/pais/multicolor/nacio/una/abeja/bajo/el/sol"})
public class Procesar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Procesar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String edad = request.getParameter("edad");
		
		response.setContentType("text/html"); // tipo mime;
		
		PrintWriter salida=response.getWriter();
		salida.append("<!DOCTYPE html>");
		salida.append("<html>");
		salida.append("<head>");
		salida.append("<meta charset='UTF-8'>");
		salida.append("<title>Servlet HolaMundo</title>");
		salida.append("<style> "
				+ "body {"
				+ "background: black;\n"
				+ "margin: 0;\n"
				+ "padding: 0;\n"
				+ "text-align: center;"
				+ "color: white;\n"
				+ "}\n" 
				+ "h1 {\n"
				+ "padding: 0;\n"
				+ "text-shadow: 9px 10px 12px red, -1px -1px 2px white;\n"
				+ "margin-top: 200px;\n"
				+ "color: darkblue;\n"
				+ "animation: mymove 5s 1;\n"
				+ "}\n"
				+ "@keyframes mymove {\n"
				+ "0% {font-size: 0; text-shadow: 0px 0px 0px black;}\n"
				+ "50% {font-size:200%;}\n"
				+ "100% {transform: rotate(1440deg);text-shadow: 9px 10px 12px red, -1px -1px 2px white;}\n"
				+ "}\n"
				+ "</style>");
		salida.append("</head>");
		salida.append("<body>");
		salida.append("<h1 onclick=\"alert('HOLA UNIVERSO')\">Hola "+ nombre + ", tienes " + edad + " años!</h1>");
		salida.append("</body>");
		salida.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
