package sap.logistics.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceTest {
	
	public static void main(String[] args){
		Bus bus = new Bus();
		
		bus.setLicensePlate("ABC-1234");
		bus.setNumberOfPassangers(45);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Logistics");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(bus);
		em.getTransaction().commit();
		em.close();
		
	}
}
