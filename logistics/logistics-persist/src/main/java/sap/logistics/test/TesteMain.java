package sap.logistics.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sap.logistics.persistence.Driver;
import sap.logistics.persistence.Passenger;
import sap.logistics.persistence.Route;
import sap.logistics.persistence.Trip;
import sap.logistics.persistence.TripData;
import sap.logistics.persistence.Vehicle;

public class TesteMain {

	public static void main(String[] args) {
		int numero = 1;

		EntityManagerFactory teste = Persistence
				.createEntityManagerFactory("logistics");
		EntityManager entityManager = teste.createEntityManager();

		List<Trip> trips = new ArrayList<Trip>();
		List<Passenger> passenger = new ArrayList<Passenger>();
		Calendar data = new GregorianCalendar();

		while (numero != 4) {
			entityManager.getTransaction().begin();

			Driver drive = new Driver();
			Passenger pass = new Passenger();
			Route rout = new Route();
			Trip tri = new Trip();
			Vehicle veh = new Vehicle();
			TripData tridata = new TripData();

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
			rout.setArrivalTime(12321);
			rout.setDepartureTime(123214);

			veh.setCapacity(numero);
			veh.setChassi("Chassi" + numero);
			veh.setFiscalNumber("numero fiscal" + numero);
			veh.setFuelType("Tipo " + numero);
			veh.setModel("Modelo " + numero);
			veh.setPlate("Plate " + numero);
			veh.setTrips(trips);
			veh.setVehicleInscription("Inscription" + numero);
			veh.setYear(numero);

			tri.setArrivalTime(data);
			tri.setDepartureTime(data);
			tri.setDistance(numero);
			tri.setDriver(drive);
			tri.setPassengerNr(numero);
			tri.setRoute(rout);
			tri.setVehicle(veh);
			
			//tridata.setDateTime(data);
			tridata.setEngineRPM((long) Math.random()*101);
			tridata.setFuelLevel((long) Math.random()*101);
			tridata.setSpeed((long) Math.random()*101);
			tridata.setTrip(tri);

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