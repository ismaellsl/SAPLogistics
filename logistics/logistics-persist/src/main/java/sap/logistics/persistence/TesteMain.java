package sap.logistics.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteMain {

	public static void main(String[] args) {
		int numero = 1;
		
		EntityManagerFactory teste = Persistence
				.createEntityManagerFactory("Logistics");
		EntityManager entityManager = teste.createEntityManager();

		List<Trip> trips = new ArrayList<Trip>();
		List<Passenger> passenger = new ArrayList<Passenger>();
		Date data = new Date();
		
		
		while (numero != 4) {
			entityManager.getTransaction().begin();

		
			Driver drive = new Driver();
			Passenger pass = new Passenger();
			Route rout = new Route();
			Trip tri = new Trip();
			Vehicle veh = new Vehicle();
			
			trips.add(tri);
			passenger.add(pass);
			
			drive.setName("Motorista " + numero);
			drive.setRegistration("Registro " + numero);
			drive.setPicture("Foto " + numero);

			pass.setEmail("Email" + numero);
			pass.setMobileNumber(numero);
			pass.setName("Nome " + numero);
			pass.setRegistration("Registro" + numero);
			pass.setRoute(rout);

			rout.setArrivalLocation("Lugar de chegada " + numero);
			rout.setDepertureLocation("Lugar de saida " + numero);
			rout.setDistance(numero);
			rout.setTrips(trips);
			rout.setPassagers(passenger);
			rout.setArrivalTime(data);
			rout.setDepartureTime(data);
			
			veh.setCapacity(numero);
			veh.setChassi("Chassi" + numero);
			veh.setFiscalNumber("numero fiscal" + numero);
			veh.setFuelType("Tipo " + numero);
			veh.setModel("Modelo " + numero);
			veh.setPlate("Plate "+ numero);
			veh.setTrips(trips);
			veh.setVehicleInscription("Inscription" + numero);
			veh.setYear(numero);
			
			tri.setArrivalTime(data);
			tri.setDate(data);
			tri.setDepartureTime(data);
			tri.setDistance(numero);
			tri.setDriver(drive);
			tri.setPassengerNr(numero);
			tri.setRoute(rout);
			tri.setVehicle(veh);

			entityManager.persist(drive);
			entityManager.persist(rout);
			entityManager.persist(tri);
			entityManager.persist(veh);
			entityManager.persist(pass);
			
			entityManager.getTransaction().commit();
			
			numero++;
			

		}

	}
}