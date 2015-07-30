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
import sap.logistics.persistence.Maintenance;
import sap.logistics.persistence.Passenger;
import sap.logistics.persistence.Route;
import sap.logistics.persistence.Trip;
import sap.logistics.persistence.TripData;
import sap.logistics.persistence.Vehicle;
import sap.logistics.persistence.types.MaintenanceReason;
import sap.logistics.persistence.types.MaintenanceType;

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
		Calendar dataChegada = new GregorianCalendar();
		data.set(2015, 07, 28, 21, 00);
		dataChegada.set(2015, 07, 28, 23, 00);
			Driver drive = new Driver();
			Passenger pass = new Passenger();
			Route rout = new Route();
			Trip tri = new Trip();
			Vehicle veh = new Vehicle();
			TripData tridata = new TripData();

			trips.add(tri);
			passenger.add(pass);

			drive.setName("João");
			drive.setRegistration("2132142313" );
			drive.setPicture("");

			pass.setEmail("juca@gmail.com" );
			pass.setMobileNumber(123421342);
			pass.setName("Juca" );
			pass.setRegistration("32432223321321" );
			pass.setRoute(rout);

			rout.setArrivalLocation("SAP" );
			rout.setDepertureLocation("Av. Assis Brasil");
			rout.setDistance(80);
			rout.setTrips(trips);
			rout.setPassagers(passenger);
			rout.setArrivalTime(dataChegada);
			rout.setDepartureTime(data);

			veh.setCapacity(45);
			veh.setChassi("9WT2324232A33241" );
			veh.setFiscalNumber("23243213" );
			veh.setFuelType("Diesel" );
			veh.setModel("Mercedes" );
			veh.setPlate("ABC-1234" );
			veh.setTrips(trips);
			veh.setVehicleInscription("442" );
			veh.setYear(2014);

			tri.setArrivalTime(dataChegada);
			tri.setDepartureTime(data);
			tri.setDistance(80);
			tri.setDriver(drive);
			tri.setPassengerNr(45);
			tri.setRoute(rout);
			tri.setVehicle(veh);
			
			tridata.setDateTime(data);
			tridata.setEngineRPM((long) Math.random()*101);
			tridata.setFuelLevel((long) Math.random()*101);
			tridata.setSpeed((long) Math.random()*101);
			tridata.setTrip(tri);

			entityManager.getTransaction().begin();
			
			entityManager.persist(drive);
			entityManager.persist(rout);
			entityManager.persist(tri);
			entityManager.persist(tridata);
			entityManager.persist(veh);
			entityManager.persist(pass);

			entityManager.getTransaction().commit();

			//***************************************
			trips = new ArrayList<Trip>();
			passenger = new ArrayList<Passenger>();
			data = new GregorianCalendar();
			data.set(2015, 07, 29, 22, 00);
			dataChegada = new GregorianCalendar();
			dataChegada.set(2015, 07, 29, 00, 00);
			
			drive = new Driver();
			pass = new Passenger();
			rout = new Route();
			tri = new Trip();
			veh = new Vehicle();
			tridata = new TripData();

			trips.add(tri);
			passenger.add(pass);

			drive.setName("Pedro");
			drive.setRegistration("2123443343" );
			drive.setPicture("");

			pass.setEmail("geraldo@gmail.com" );
			pass.setMobileNumber(54457276232L);
			pass.setName("Geraldo" );
			pass.setRegistration("32432423324" );
			pass.setRoute(rout);

			rout.setArrivalLocation("SAP" );
			rout.setDepertureLocation("Av. Borges de Medeiros" );
			rout.setDistance(87);
			rout.setTrips(trips);
			rout.setPassagers(passenger);
			rout.setArrivalTime(dataChegada);
			rout.setDepartureTime(data);

			veh.setCapacity(45);
			veh.setChassi("1223YIOHS1SD876911" );
			veh.setFiscalNumber("132213133" );
			veh.setFuelType("Diesel" );
			veh.setModel("Scania" );
			veh.setPlate("CDE-4321" );
			veh.setTrips(trips);
			veh.setVehicleInscription("444" );
			veh.setYear(numero);

			tri.setArrivalTime(dataChegada);
			tri.setDepartureTime(data);
			tri.setDistance(numero);
			tri.setDriver(drive);
			tri.setPassengerNr(numero);
			tri.setRoute(rout);
			tri.setVehicle(veh);
			
			tridata.setDateTime(data);
			tridata.setEngineRPM((long) Math.random()*101);
			tridata.setFuelLevel((long) Math.random()*101);
			tridata.setSpeed((long) Math.random()*101);
			tridata.setTrip(tri);
			
			entityManager.getTransaction().begin();
			entityManager.persist(drive);
			entityManager.persist(rout);
			entityManager.persist(tri);
			entityManager.persist(tridata);
			entityManager.persist(veh);
			entityManager.persist(pass);

			entityManager.getTransaction().commit();
			
			
			//***************************************
			
			trips = new ArrayList<Trip>();
			passenger = new ArrayList<Passenger>();
			data = new GregorianCalendar();
			data.set(2015, 07, 30, 10, 00);
			dataChegada = new GregorianCalendar();
			dataChegada.set(2015, 07, 30, 00, 00);

			
			drive = new Driver();
			pass = new Passenger();
			rout = new Route();
			tri = new Trip();
			veh = new Vehicle();
			tridata = new TripData();

			trips.add(tri);
			passenger.add(pass);

			drive.setName("Paulo");
			drive.setRegistration("3213443343" );
			drive.setPicture("");

			pass.setEmail("joao2@gmail.com" );
			pass.setMobileNumber(21326232L);
			pass.setName("João" );
			pass.setRegistration("3332223124" );
			pass.setRoute(rout);

			rout.setArrivalLocation("SAP" );
			rout.setDepertureLocation("Av. Farrapos");
			rout.setDistance(89);
			rout.setTrips(trips);
			rout.setPassagers(passenger);
			rout.setArrivalTime(dataChegada);
			rout.setDepartureTime(data);

			veh.setCapacity(45);
			veh.setChassi("Y22HOHS1SD876922" );
			veh.setFiscalNumber("321435765532" );
			veh.setFuelType("Diesel" );
			veh.setModel("Volks" );
			veh.setPlate("FGH-6542" );
			veh.setTrips(trips);
			veh.setVehicleInscription("66" );
			veh.setYear(numero);

			tri.setArrivalTime(dataChegada);
			tri.setDepartureTime(data);
			tri.setDistance(numero);
			tri.setDriver(drive);
			tri.setPassengerNr(numero);
			tri.setRoute(rout);
			tri.setVehicle(veh);
			
			tridata.setDateTime(data);
			tridata.setEngineRPM((long) Math.random()*101);
			tridata.setFuelLevel((long) Math.random()*101);
			tridata.setSpeed((long) Math.random()*101);
			tridata.setTrip(tri);

			
			entityManager.getTransaction().begin();
			
			entityManager.persist(drive);
			entityManager.persist(rout);
			entityManager.persist(tri);
			entityManager.persist(tridata);
			entityManager.persist(veh);
			entityManager.persist(pass);

			entityManager.getTransaction().commit();
			
			//***************************************
			
			trips = new ArrayList<Trip>();
			passenger = new ArrayList<Passenger>();
			data = new GregorianCalendar();
			data.set(2015, 07, 30, 11, 00);
			dataChegada = new GregorianCalendar();
			dataChegada.set(2015, 07, 30, 13, 00);
			
			drive = new Driver();
			pass = new Passenger();
			rout = new Route();
			tri = new Trip();
			veh = new Vehicle();
			tridata = new TripData();

			trips.add(tri);
			passenger.add(pass);

			drive.setName("Lucas");
			drive.setRegistration("6576552223" );
			drive.setPicture("");

			pass.setEmail("ana@gmail.com" );
			pass.setMobileNumber(21326232L);
			pass.setName("Ana" );
			pass.setRegistration("23242567988" );
			pass.setRoute(rout);

			rout.setArrivalLocation("SAP" );
			rout.setDepertureLocation("Av. Osvaldo Aranha");
			rout.setDistance(81);
			rout.setTrips(trips);
			rout.setPassagers(passenger);
			rout.setArrivalTime(dataChegada);
			rout.setDepartureTime(data);

			veh.setCapacity(15);
			veh.setChassi("ZZ9879S1SD12345" );
			veh.setFiscalNumber("098767576745" );
			veh.setFuelType("Gasoline" );
			veh.setModel("Volks" );
			veh.setPlate("765-0987" );
			veh.setTrips(trips);
			veh.setVehicleInscription("066" );
			veh.setYear(numero);

			tri.setArrivalTime(dataChegada);
			tri.setDepartureTime(data);
			tri.setDistance(numero);
			tri.setDriver(drive);
			tri.setPassengerNr(numero);
			tri.setRoute(rout);
			tri.setVehicle(veh);
			
			tridata.setDateTime(data);
			tridata.setEngineRPM((long) Math.random()*101);
			tridata.setFuelLevel((long) Math.random()*101);
			tridata.setSpeed((long) Math.random()*101);
			tridata.setTrip(tri);
			
			entityManager.getTransaction().begin();
			
			entityManager.persist(drive);
			entityManager.persist(rout);
			entityManager.persist(tri);
			entityManager.persist(tridata);
			entityManager.persist(veh);
			entityManager.persist(pass);

			entityManager.getTransaction().commit();

			//***************************************
			
			trips = new ArrayList<Trip>();
			passenger = new ArrayList<Passenger>();
			data = new GregorianCalendar();
			data.set(2015, 07, 30, 13, 00);
			dataChegada = new GregorianCalendar();
			dataChegada.set(2015, 07, 30, 15, 00);
			
			drive = new Driver();
			pass = new Passenger();
			rout = new Route();
			tri = new Trip();
			veh = new Vehicle();
			tridata = new TripData();

			trips.add(tri);
			passenger.add(pass);

			drive.setName("Deise");
			drive.setRegistration("445760987972" );
			drive.setPicture("");

			pass.setEmail("fabiane@hotmail.com" );
			pass.setMobileNumber(21326232L);
			pass.setName("Fabiane" );
			pass.setRegistration("4678998887" );
			pass.setRoute(rout);

			rout.setArrivalLocation("SAP" );
			rout.setDepertureLocation("Av. Júlio de Castilhos");
			rout.setDistance(92);
			rout.setTrips(trips);
			rout.setPassagers(passenger);
			rout.setArrivalTime(dataChegada);
			rout.setDepartureTime(data);

			veh.setCapacity(15);
			veh.setChassi("ZZ9879S1SD12347" );
			veh.setFiscalNumber("098767576745" );
			veh.setFuelType("Gasoline" );
			veh.setModel("Mercedes" );
			veh.setPlate("IJX-6786" );
			veh.setTrips(trips);
			veh.setVehicleInscription("590" );
			veh.setYear(numero);
			
			
			ArrayList<Maintenance> maintenances = new ArrayList<Maintenance>();
			Maintenance main = new Maintenance();
			main.setDate(data);
			main.setDescription("disco de freio gasto");
			main.setType(MaintenanceType.Corretiva);
			main.setReason(MaintenanceReason.Constatação);
			main.setVehicle(veh);
			maintenances.add(main);
			

			Maintenance main2 = new Maintenance();
			main2.setDate(data);
			main2.setDescription("Parabrisa rachado");
			main2.setType(MaintenanceType.Corretiva);
			main2.setReason(MaintenanceReason.Quebra);
			main2.setVehicle(veh);
			maintenances.add(main2);
			

			Maintenance main3= new Maintenance();
			main3.setDate(data);
			main3.setDescription("Pneu furado");
			main3.setType(MaintenanceType.Corretiva);
			main3.setReason(MaintenanceReason.Quebra);
			main3.setVehicle(veh);
			maintenances.add(main3);
			
			
			Maintenance main4= new Maintenance();
			main4.setDate(data);
			main4.setDescription("Manutenção semestral");
			main4.setType(MaintenanceType.Preventiva);
			main4.setReason(MaintenanceReason.Previsto);
			main4.setVehicle(veh);
			maintenances.add(main4);
			
			Maintenance main5= new Maintenance();
			main5.setDate(data);
			main5.setDescription("Manutenção Semestral");
			main5.setType(MaintenanceType.Preventiva);
			main5.setReason(MaintenanceReason.Previsto);
			main5.setVehicle(veh);
			maintenances.add(main5);
			
			Maintenance main6= new Maintenance();
			main6.setDate(data);
			main6.setDescription("Manutenção Semestral");
			main6.setType(MaintenanceType.Preventiva);
			main6.setReason(MaintenanceReason.Previsto);
			main6.setVehicle(veh);
			maintenances.add(main6);
			
			Maintenance main7= new Maintenance();
			main7.setDate(data);
			main7.setDescription("Manutenção Semestral");
			main7.setType(MaintenanceType.Preventiva);
			main7.setReason(MaintenanceReason.Previsto);
			main7.setVehicle(veh);
			maintenances.add(main7);
			
			Maintenance main8= new Maintenance();
			main8.setDate(data);
			main8.setDescription("Borracha vedação desgastada");
			main8.setType(MaintenanceType.Preventiva);
			main8.setReason(MaintenanceReason.Extra);
			main8.setVehicle(veh);
			maintenances.add(main8);
			
			
			veh.setMaintenance(maintenances);
			tri.setArrivalTime(dataChegada);
			tri.setDepartureTime(data);
			tri.setDistance(numero);
			tri.setDriver(drive);
			tri.setPassengerNr(numero);
			tri.setRoute(rout);
			tri.setVehicle(veh);
			
			tridata.setDateTime(data);
			tridata.setEngineRPM((long) Math.random()*101);
			tridata.setFuelLevel((long) Math.random()*101);
			tridata.setSpeed((long) Math.random()*101);
			tridata.setTrip(tri);
			
			entityManager.getTransaction().begin();
			entityManager.persist(main);
			entityManager.persist(main2);
			entityManager.persist(main3);
			entityManager.persist(main4);
			entityManager.persist(main5);
			entityManager.persist(main6);
			entityManager.persist(main7);
			entityManager.persist(main8);
			entityManager.persist(drive);
			entityManager.persist(rout);
			entityManager.persist(tri);
			entityManager.persist(tridata);
			entityManager.persist(veh);
			entityManager.persist(pass);

			entityManager.getTransaction().commit();
			
			response.getWriter().println("Maven Funcionando 100%!");
	}
}
