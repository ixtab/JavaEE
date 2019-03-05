import java.sql.*;

public class Principal {

	public static void main(String[] args) {
		
		// Paso 1: Cargar el Driver en memoria.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Se ha cargado el driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha podido cargar el Driver. Se finaliza el programa.");
			e.printStackTrace();
			return;
		}
		// Paso 2: Establecer conexión con la base de datos
		
		String cadenaConexion = "jdbc:mysql://localhost:3306/FERRETERIA?serverTimezone=UTC";
		//Se puede cambiar también la configuración en el servidor.
		String user = "root";
		String pass = "pipopipo"; 
		Connection con;
		try {
			con = DriverManager.getConnection(cadenaConexion, user, pass);
			System.out.println("Conexión establecida a la bd FERRERERIA");
		} catch (SQLException e) {
			System.out.println("Error en la conexión con la BD");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha establecido la conexión con la Base de datos");
		
		/*
		 * Paso 3
		 * Aquí es donde se trabaja con la base de datos.
		 * 
		 */
		
		//Añadir Cliente
		try {
			Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = sentencia.executeQuery("SELECT * FROM CLIENTE");
			
			rs.moveToInsertRow(); 
			rs.updateString("NIF", "12345678Z"); 
			rs.updateString("NOMBRE", "HIPOLITO DURAN CARLOS"); 
			rs.updateString("DOMICILIO", "C/ PEZ VOLADOR, 52"); 
			rs.updateString("TLF", "912222222"); 
			rs.updateString("CIUDAD", "MADRID"); 
			rs.insertRow(); 
			
		} catch (SQLException e) {
			System.out.println("Error al añadir el nuevo cliente");
			System.out.println(e.getMessage());
		}		

		//Recuperar Clientes
		try { 
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery("SELECT * FROM CLIENTE");
			System.out.println("-->");
			while (rs.next()) {
				System.out.print(rs.getString(1));
				System.out.print(" - "); 
				System.out.print(rs.getString("NOMBRE"));
				System.out.print(" - "); 
				System.out.print(rs.getString("tlf"));
				System.out.println(); // Retorno de carro
			}
		} catch (SQLException e) {
			System.out.println("Error al realizar el listado de productos");
			System.out.println(e.getMessage());
		}
		
		//Borrar Cliente
		try {
			Statement sentencia = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = sentencia.executeQuery("SELECT * FROM CLIENTE WHERE NIF = '12345678Z'");
			boolean existe = rs.next();
			if (existe) {
				rs.deleteRow();
			}
		} catch (SQLException e) {
			System.out.println("Error al eliminar al cliente");
			System.out.println(e.getMessage());
		}		

		
		//Recuperar Clientes
				try { 
					Statement sentencia = con.createStatement();
					ResultSet rs = sentencia.executeQuery("SELECT * FROM CLIENTE");
					System.out.println("-->");
					while (rs.next()) {
						System.out.print(rs.getString(1));
						System.out.print(" - "); 
						System.out.print(rs.getString("NOMBRE"));
						System.out.print(" - "); 
						System.out.print(rs.getString("tlf"));
						System.out.println(); // Retorno de carro
					}
				} catch (SQLException e) {
					System.out.println("Error al realizar el listado de productos");
					System.out.println(e.getMessage());
				}
		

	// Paso 4: Cerrar la conexión
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
