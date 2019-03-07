import javax.persistence.*;

import model.Cliente;



public class NuevoCliente {

	public static void main(String[] args) {
		System.out.println("Vamos a comprobar el funcionamiento de JPA");

		EntityManagerFactory factory = null;
		EntityManager em = null;

		try {
			factory = Persistence.createEntityManagerFactory("EjemploJPAFerreteria");
			System.out.println("Hemos creado en Entity Manager Factory");
			em = factory.createEntityManager();
			System.out.println("Hemos creado en Entity Manager");
			Cliente yo;
			yo = new Cliente("55666372R", "AMELIA GONZALEZ", "C/ CRISTOBAL, 54", "MADRID", "666886666");
			EntityTransaction tx = em.getTransaction();// el tx no es obligatoria, es para hacer varias transacciones y si da algún error no se hace ninguna
			System.out.println("Hemos iniciado la transacción");
			tx.begin(); // el tx no es obligatoria, es para hacer varias transacciones y si da algún error no se hace ninguna
			em.persist(yo);
			tx.commit(); // el tx no es obligatoria, es para hacer varias transacciones y si da algún error no se hace ninguna
			System.out.println("Hemos persistido el objeto en la BD");

		} catch (Exception err) {
			System.out.println("Algun error ha ocurrido");
			System.out.println(err.getMessage());
		}
	}
}
