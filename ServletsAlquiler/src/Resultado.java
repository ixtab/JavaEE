

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Resultado
 */
@WebServlet("/Resultado")
public class Resultado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Resultado() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html"); 
		response.setCharacterEncoding("UTF-8");
		
		double precio = 0;
		double mejoras = 0;
		
		DecimalFormat df = new DecimalFormat("#0.00"); 
		
		precio = Double.parseDouble(request.getParameter("sitio")) * Double.parseDouble(request.getParameter("metros"));
		if (request.getParameter("cale") != null) mejoras = mejoras + Double.parseDouble(request.getParameter("cale"));
		if (request.getParameter("pisci") != null) mejoras = mejoras + Double.parseDouble(request.getParameter("pisci"));
		if (request.getParameter("aire") != null) mejoras = mejoras + Double.parseDouble(request.getParameter("aire"));
		precio = precio + precio * mejoras / 100;
		if (request.getParameter("paro") != null) precio = precio - (precio * Double.parseDouble(request.getParameter("paro"))/100);
		
		PrintWriter salida=response.getWriter();
		
		salida.append("<!DOCTYPE html>");
		salida.append("<html lang=\"es\">");
		salida.append("<head>");
		salida.append("<meta charset=\"UTF-8\">");
		salida.append("<title>Servlet Alquiler de Viviendas</title>");
		salida.append("</head>");
		salida.append("<body>");
		salida.append("<h1> El precio total de la vivienda es de: " + df.format(precio) +"€</h1>");
		salida.append("</body>");
		salida.append("</html>");
		
		Cookie cookie1=new Cookie("Ultimo_precio",""+precio);
		cookie1.setMaxAge(3600); // Una hora
		response.addCookie(cookie1);
	} 

}
