package sap.logistics.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sap.logistics.persistence.Passenger;

public class PersistenceTest {
	
	public static void main(String[] args){
		Passenger passanger = new Passenger();
		passanger.setEmail("test@test.com");
		passanger.setMobileNumber(99887766);
		passanger.setName("Tester");
		passanger.setRegistration("1234567890");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("logistics");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(passanger);
		em.getTransaction().commit();
		em.close(); 
	}
}
