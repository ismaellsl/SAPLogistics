package sap.logistics.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Stack;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParserFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.json.stream.JsonParser.Event;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.lf5.Log4JLogRecord;

import sap.logistics.persistence.Driver;
import sap.logistics.persistence.Trip;
import sap.logistics.persistence.TripData;
import sap.logistics.persistence.Vehicle;

public class InsertTripDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("logistics");

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = req.getReader();
		br.readLine();
		br.readLine();
		br.readLine();
		String line;
		String text = "";
		while ((line = br.readLine()) != null) {
			if (line.contains("WebKitFormBoundary"))
				line = "";
			text = text.concat("\n" + line);
		}

		text = text.trim();
		JsonParserFactory factory = Json.createParserFactory(null);
		JsonParser parser = factory.createParser(new StringReader(text));
		Stack<String> stack = new Stack<>();
		TripData tripData = new TripData();
		List<TripData> tripDataList = new ArrayList<>();
		String busId = "";
		int counter = 0;
		Calendar tripArrivalDate = new GregorianCalendar();
		while (parser.hasNext()) {
			try {
				Event event = parser.next();
				switch (event) {
				case START_OBJECT: {
					counter++;
					break;
				}
				case END_OBJECT: {
					counter--;
					if (counter == 0) {
						tripDataList.add(tripData);
						tripData = new TripData();
					}
					break;
				}
				case KEY_NAME: {
					stack.push(parser.getString());
					break;
				}
				case VALUE_STRING: {
					String value = parser.getString();
					switch (stack.pop()) {
					case "timeStamp": {
						Calendar calendar = new GregorianCalendar();
						calendar.setTimeInMillis(Long.parseLong(value));
						tripData.setDateTime(calendar);
						break;
					}
					case "engineRPM": {
						tripData.setEngineRPM(Long.parseLong(value));
						break;
					}
					case "speed": {
						tripData.setSpeed(Long.parseLong(value));
						break;
					}
					case "fuelLevel": {
						tripData.setFuelLevel(Long.parseLong(value));
						break;
					}
					case "id": {
						busId = value;
						break;
					}
					case "xAxis": {
						tripData.setX(Long.parseLong(value));
						break;
					}
					case "yAxis": {
						tripData.setY(Long.parseLong(value));
						break;
					}
					case "zAxis": {
						tripData.setZ(Long.parseLong(value));
						break;
					}
					}
					break;
				}
				case VALUE_NUMBER: {
					String value = parser.getString();
					switch (stack.pop()) {
					case "id": {
						busId = value;
						break;
					}
					case "timeStamp": {
						Calendar calendar = new GregorianCalendar();
						calendar.setTimeInMillis(Long.parseLong(value));
						tripData.setDateTime(calendar);
						break;
					}
					case "engineRPM": {
						tripData.setEngineRPM(Long.parseLong(value));
						break;
					}
					case "speed": {
						tripData.setSpeed(Long.parseLong(value));
						break;
					}
					case "fuelLevel": {
						tripData.setFuelLevel(Long.parseLong(value));
						break;
					}
					case "xAxis": {
						tripData.setX(Long.parseLong(value));
						break;
					}
					case "yAxis": {
						tripData.setY(Long.parseLong(value));
						break;
					}
					case "zAxis": {
						tripData.setZ(Long.parseLong(value));
						break;
					}
					}
					break;
				}
				}
			} catch (Exception e) {
				resp.getWriter().println("Some errors occured");
			}

		}
		List<Trip> tripList = new ArrayList();
		Trip trip = new Trip();
		Vehicle vehicle = null;

		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("Driver.findOne");
		query.setParameter("r", "653838949222");

		List<Driver> list = query.getResultList();
		Driver driver = null;

		if (list.isEmpty()) {
			driver = new Driver();
			driver.setName("Rodrigo Buhler");
			driver.setRegistration("653838949222");
			driver.setTrips(tripList);
			em.getTransaction().begin();
			em.persist(driver);
			em.getTransaction().commit();
		} else if (list.size() == 1) {
			driver = list.get(0);
		} else {
			resp.getWriter().println("Error! There are more than 1 entry in Driver for this registration number");
		}

		query = em.createNamedQuery("Vehicle.findOne");
		query.setParameter("v", "ABC-213435464353");
		List<Vehicle> listV = query.getResultList();

		if (listV.isEmpty()) {
			vehicle = new Vehicle();
			vehicle.setCapacity(5);
			vehicle.setChassi("ABC-213435464353");
			vehicle.setFuelType("Gasoline");
			vehicle.setPlate("IHC-8657");
			vehicle.setModel("Sandeiro");
			vehicle.setYear(2014);
			em.getTransaction().begin();
			em.persist(vehicle);
			em.getTransaction().commit();
		} else if (list.size() == 1) {
			vehicle = listV.get(0);
		} else {
			resp.getWriter().println("Error! There are more than 1 entry in Vehicle for this registration number");
		}

		trip.setDistance(2000);
		trip.setDriver(driver);
		driver.setTrips(tripList);
		trip.setVehicle(vehicle);
		trip.setTripDatas(tripDataList);
		tripList.add(trip);
		vehicle.setTrips(tripList);
		
		int countTrip = 0;
		for (TripData tripData2 : tripDataList) {
			countTrip++;
		
			em.getTransaction().begin();
			if(countTrip == 1){
				trip.setArrivalTime(tripData2.getDateTime());
			}else if(countTrip == tripDataList.size()){				
				trip.setDepartureTime(tripData2.getDateTime());
			}
			tripData2.setTrip(trip);
			
			em.persist(tripData2);
			em.getTransaction().commit();

		}
		
		em.getTransaction().begin();
		
		em.persist(trip);

		em.getTransaction().commit();
		em.close();
		resp.getWriter().println("Success!");
	}
}
