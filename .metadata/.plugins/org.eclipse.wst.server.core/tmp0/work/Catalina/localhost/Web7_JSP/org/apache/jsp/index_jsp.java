/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.16
 * Generated at: 2019-02-27 12:49:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Random;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


	int contador = 0;  
	String frase;
	double aleatorio = Math.random();

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Random");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("  <!-- Esto es una directiva y lo de arriba también --> \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!--Declaración, lo que se declara aquí se mantiene para todas las sesiones (durante toda la sesion del servidor). No muestra nada-->\r\n");
      out.write('\r');
      out.write('\n');
 // Aquí se va a mantener siempre el valor de aleatorio para todas las sesiones

	if (aleatorio < 0.5){
		frase = "Adios";
	} else {
		frase = "Hola";
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<H1>EXPRESIONES JSP</H1> <!-- Muetra lo que se pone -->\r\n");
      out.write("<p>");
      out.print( 2*30*java.lang.Math.PI);
      out.write("</p>  \r\n");
      out.write("<p>");
      out.print( new java.util.Date());
      out.write("</p>\r\n");
      out.write("<p>");
      out.print( request.getRemoteHost());
      out.write("</p>\r\n");
      out.write("<p>");
      out.print( session.getId());
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<H1>Scriptlets</H1>  <!-- Se ejecuta una vez por cada requerimiento, no muestra nada -->\r\n");
      out.write("\t");

		double precio=10;
		int cantidad=5;
		String producto="Peras";
		double subtotal=precio*cantidad;
		double iva=subtotal*0.16;
		double total=subtotal+iva;
		contador ++;  // Se coge la variable de la declaración-
	
      out.write("\r\n");
      out.write("\t<p>Nombre artículo:");
      out.print( producto );
      out.write(" </p>\r\n");
      out.write("\t<p>Precio artículo:");
      out.print( precio );
      out.write(" </p>\r\n");
      out.write("\t<p>Subtotal: ");
      out.print( subtotal);
      out.write(" </p>\r\n");
      out.write("\t<p>Total IVA incluido: ");
      out.print( total );
      out.write(" </p>\r\n");
      out.write("\t<p> Acessos a la página: ");
      out.print( contador );
      out.write(" </p>\r\n");
      out.write("\t\r\n");
      out.write("<p>");
      out.print( aleatorio +": " +frase);
      out.write("</p>\r\n");
      out.write("\r\n");
 if (Math.random()<0.5) 
	{ 
      out.write("\r\n");
      out.write("\t\t<H2>VAS A TENER UN BUEN DIA</H2>\r\n");
      out.write("\t\t<H3>FELICIDADES</H3>\r\n");
      out.write("\t");
 }
	else
	{ 
      out.write("\r\n");
      out.write("\t\t<H2>VAS A TENER UN MAL DIA</H2>\r\n");
      out.write("\t\t<H2>PODRIA SER PEOR</H2>\r\n");
      out.write("\t");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
