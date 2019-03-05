package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaUniverso
 */
@WebServlet(
		description = "Imprime Hola Universo", 
		urlPatterns = { 
				"/HolaUniverso", 
				"/hello"
		}, 
		initParams = { 
				@WebInitParam(name = "Author", value = "Jose Carlos Calzada")
		})
public class HolaUniverso extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private static String nombreAutor;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaUniverso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init");
		nombreAutor = config.getInitParameter("Author");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
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
				+ "margin-top: 200px;\n"
				+ "color: darkblue;\n"
				+ "animation: mymove 5s 1;\n"
				+ "}\n"
				+ "@keyframes mymove {\n"
				+ "0% {font-size: 0;}\n"
				+ "50% {font-size:100%;}\n"
				+ "100% {transform: rotate(1440deg);text-shadow: 9px 10px 12px red, -1px -1px 2px white;}\n"
				+ "}\n"
				+ "</style>");
		salida.append("</head>");
		salida.append("<body>");
		salida.append("<h1 onclick=\"alert('HOLA UNIVERSO')\">Hola Universo por "+ nombreAutor +"!</h1>");
		salida.append("</body>");
		salida.append("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doGet(request, response);
	}

}
