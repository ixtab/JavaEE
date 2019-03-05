

import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.Function;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Resultado
 */
@WebServlet("/en/un/pais/multicolor/nacio/una/abeja/bajo/el/sol")
public class Resultado extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private int contador = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Resultado() {
        super();
        System.out.println("Servlet iniciado");
    }
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("App Iniciada");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contador++;
		System.out.println(contador);
		String equipoLocal = request.getParameter("equipoLocal");
		String equipoVisitante = request.getParameter("equipoVisitante");
		int golesLocal = Integer.parseInt(request.getParameter("golesLocal"));
		int golesVisitante = Integer.parseInt(request.getParameter("golesVisitante"));
		
		Function<Integer, Function<Integer,String>> sumar = x -> y -> x + y +" goles."; // LAMBDA ?
		String total = sumar.apply(golesLocal).apply(golesVisitante);
		response.setContentType("text/html"); // tipo mime;
		PrintWriter salida=response.getWriter();
		salida.append("<!DOCTYPE html>");
		salida.append("<html lang=\"es\">");
		salida.append("<head>");
		salida.append("<meta charset='UTF-8'>");
		salida.append("<title>Servlet Resultado Partido</title>");
		salida.append("<style>"
				+ "h1 {"
				+ "width: 70%;"
				+ "margin-left: 15%;"
				+ "}"
				+ "</style>");
		salida.append("</head>");
		salida.append("<body>");
		
		if (golesLocal > golesVisitante) {
			salida.append("<h3>El equipo local " + equipoLocal + " ha ganado al " + equipoVisitante + " por " + golesLocal + " a " + golesVisitante+".</h3>");
		} else if (golesLocal < golesVisitante) {
			salida.append("<h3>EL equipo visitante " + equipoVisitante  + " ha ganado al " + equipoLocal +
					". El resultado: " + golesLocal + " goles del " + equipoLocal + " y " + golesVisitante + " goles del " + equipoVisitante+".</h3>");
		} else {
			response.getWriter().append("<h3>Empate entre el " + 
										equipoLocal + " y el " + equipoVisitante +
										" a " + golesLocal + " goles.</h3>");
		}
		salida.append("<h3> Total "+ total +"</h3>");
		salida.append("<a href='../../../../../../../../../'>Volver</a>");
		salida.append("<p>Contador " + contador+"</p>");
		
		salida.append("<pre>"+ request.getDateHeader(equipoLocal) +": " + "</pre>");
		salida.append("<pre>"+ request.getLocalAddr() +": " + "</pre>");
		salida.append("<pre>"+ request.getLocalName() +": " + "</pre>");
		salida.append("<pre>"+ response.getStatus() +": " + "</pre>");
		salida.append("<pre>"+ response.getLocale() +": " + "</pre>");
		
		salida.append("</body>");
		salida.append("</html>");
		
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("El server se está destruyendo");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
