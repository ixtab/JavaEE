

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaMundo
 */
public class HolaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaMundo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter salida=response.getWriter();
		salida.append("<!DOCTYPE html>");
		salida.append("<html>");
		salida.append("<head>");
		salida.append("<meta charset='UTF-8'>");
		salida.append("<title>Servlet HolaMundo</title>");
		salida.append("<style> "
				+ "body {"
				+ "background: black;\n"
				+ "color: white;\n"
				+ "text-align: center;\n"
				+ "margin-top: 200px\n;"
				+ "}\n" 
				+ "h1 {\n"
				+ "color: darkblue;\n"
				+ "transform: rotate(-25deg);\n"
				+ "text-shadow: 9px 10px 12px red, -1px -1px 2px white;\n"
				+ "}\n"
				+ "</style>");
		salida.append("</head>");
		salida.append("<body>");
		salida.append("<h1 onclick=\"alert('HOLA UNIVERSO')\">Hola Universo desde el servlet!</h1>");
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
