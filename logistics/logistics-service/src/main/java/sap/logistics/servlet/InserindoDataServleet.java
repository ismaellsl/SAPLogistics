package sap.logistics.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sap.logistics.persistence.Driver;
import sap.logistics.persistence.Passenger;
import sap.logistics.persistence.Route;
import sap.logistics.persistence.Trip;
import sap.logistics.persistence.Vehicle;

public class InserindoDataServleet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
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
