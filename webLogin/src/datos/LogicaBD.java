package datos;

import java.sql.*;

public class LogicaBD {
	private String mensaje;
	private static Connection con;

	public LogicaBD() {
		//Establecer la conexión con la BD.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			mensaje = "No se ha encontrado el driver para MySQL: " + e;
			System.out.println(mensaje);
			return;
		}
		mensaje = "Se ha cargado el Driver de MySQL" ;
		System.out.println(mensaje);
		String cadenaConexion = "jdbc:mysql://jcctek.com:3306/FERRETERIA?serverTimezone=UTC";
		String user = "admin1";
		String pass = "cursojavaFT"; 
		try {
			con = DriverManager.getConnection(cadenaConexion, user, pass);
		} catch (SQLException e) {
			System.out.println("Error en la conexión con la BD");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha establecido la conexión con la Base de datos");

		
	}
		
	

	@Override
	public String toString() {
		return "LogicaBD [mensaje=" + mensaje + "]";
	}
	
	public static String tablaClientes() {
		// retorna tabla con los datos de todos los clientes
		String salida ="";
		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM CLIENTE");
			salida = "<table>\r\n" + 
					"	<caption><h1>Clientes</caption></h1>\r\n" + 
					"	<thead>\r\n" + 
					"		<tr>\r\n" + 
					"			<th>NIF</th>\r\n" + 
					"			<th>Nombre</th>\r\n" + 
					"			<th>Teléfono</th>\r\n" + 
					"			<th>Domicilio</th>\r\n" + 
					"			<th>Ciudad</th>\r\n" + 
					"		</tr>\r\n" + 
					"	</thead>\r\n" + 
					"	<tbody>\r\n"; 
					
			while (rs.next()) {
				salida += "		<tr>\r\n";
				salida = salida + "<td>" + rs.getString("NIF") + "</td>\r\n";
				salida = salida + "<td>" + rs.getString("NOMBRE") + "</td>\r\n";
				salida = salida + "<td>" + rs.getString("TLF") + "</td>\r\n";
				salida = salida + "<td>" + rs.getString("DOMICILIO") + "</td>\r\n";
				salida = salida + "<td>" + rs.getString("CIUDAD") + "</td>\r\n";
				salida += "		</tr>\r\n";
			}
			salida += "	</tbody>\r\n" + "</table>";
		} catch (SQLException e) {
			System.out.println("Error al realizar el listado de productos");
			System.out.println(e.getMessage());
		}
		return salida;
	}
	
	public ResultSet inventario() throws SQLException {
		
		Statement sentencia = con.createStatement();
		ResultSet rs = sentencia.executeQuery("SELECT * FROM PRODUCTO");
		
		return rs;
	}

	public static void cerrar() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("No se ha podido cerrar la conexión con la BD");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha cerrado la base de datos");
		
	}
	
	
}
