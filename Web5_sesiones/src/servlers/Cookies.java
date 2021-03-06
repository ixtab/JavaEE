package servlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookies
 */
@WebServlet("/Cookies")
public class Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();
		Cookie cookie;
		String texto="";
		if(cookies != null) {
			for (int i=0; i<cookies.length; i++)	{
				cookie=cookies[i];
				texto=texto+cookie.getName()+": ";
				texto=texto+cookie.getValue();
				texto=texto+"<BR>";
		}
			PrintWriter ficheroHTML=response.getWriter();
			response.setContentType("text/html");
			ficheroHTML.println("<HTML>");
			ficheroHTML.println
	                   ("<HEAD><TITLE>PAGINA DIN�MICA</TITLE></HEAD>");
			ficheroHTML.println("<BODY>");
			ficheroHTML.println
	                   ("<H1>ESTA PAGINA BUSCA CUQUIS</H1>");
			ficheroHTML.println(texto);
			ficheroHTML.println("</BODY>");
			ficheroHTML.println("</HTML>");
		} else {
			PrintWriter ficheroHTML=response.getWriter();
			response.setContentType("text/html");
			ficheroHTML.println("<HTML>");
			ficheroHTML.println
	                   ("<HEAD><TITLE>PAGINA DIN�MICA</TITLE></HEAD>");
			ficheroHTML.println("<BODY>");
			ficheroHTML.println
	                   ("<H1>NO HAY CUQUIS</H1>");
			ficheroHTML.println("</BODY>");
			ficheroHTML.println("</HTML>");
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
