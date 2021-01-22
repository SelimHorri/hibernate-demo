package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pack1.myEntities.Person;

public class App {
// Begin Class
	
	private SessionFactory sessionFactory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Person.class)
			.buildSessionFactory();
	private Session session = sessionFactory.getCurrentSession();
	
	public App() {
		
		try {
			/*System.out.println("Creating a Person Object : ");
			
			Person person = new Person("Hichem", "bouhaha", "hichem_bouhaha@gmail.com", "hichembouhaha");
			
			System.out.println("Begining transaction");
			session.beginTransaction();
			
			System.out.println("Saving the Object");
			session.save(person);
			
			System.out.println("Commit transaction");
			session.getTransaction().commit();
			
			System.out.println("Done !");
			
			System.out.println("\n\n");
			System.out.println("--------------------------------------");
			
			System.out.println("\nRetrieving Data : ");
			
			// session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Person p = session.get(Person.class,);
			System.out.println("\nGet complete : \n"+ p);
			session.getTransaction().commit();
			
			System.out.println("--------------------------------------");
			*/
			
			System.out.println("---------------------");
			
			session.beginTransaction();
			
			session.createQuery("UPDATE Person SET fname='Salim' WHERE fname = 'Salim' and lname='Horri'").executeUpdate();
			
			// session.getTransaction().commit();
			
			// session.beginTransaction();
			
			List<Person> list = session.createQuery("FROM Person").list();
			
			for (Person p : list)
				System.out.println("\n"+ p);
			
			session.getTransaction().commit();
			
		}
		finally {
			sessionFactory.close();
		}
		
	}
	
	private static void testConn() {
		
		String hostname = "localhost";
		String dbName = "person_db";
		String dbUsername = "Reese";
		String dbPassword = "Dashwood";
		
		Connection cnx = null;
		
		try {
			System.out.println("Connectiong to DB");
			
			Class.forName("com.mysql.jdbc.Driver");
			cnx = DriverManager.getConnection("jdbc:mysql://"+ hostname +"/"+ dbName, dbUsername, dbPassword);
			
			System.out.println("Successfull connection");
			System.out.println("conncection state : "+ cnx.isClosed());
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				cnx.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
	// Begin main()
		
		// testConn();
		
		new App();
		
	// End main()
	}
	
// End Class
}
