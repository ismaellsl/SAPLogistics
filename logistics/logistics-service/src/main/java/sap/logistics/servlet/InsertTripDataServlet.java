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
import javax.json.JsonException;
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

import sap.logistics.persistence.Driver;
import sap.logistics.persistence.Route;
import sap.logistics.persistence.Trip;
import sap.logistics.persistence.TripData;
import sap.logistics.persistence.TripDefault;
import sap.logistics.persistence.Vehicle;
import sap.logistics.persistence.types.TripStatus;

public class InsertTripDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("logistics");
	private static String obdId;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = req.getReader();
		br.readLine();
		br.readLine();
		br.readLine();
		String line;
		String text = "";
		while ((line = br.readLine()) != null) {
			text = text.concat("\n" + line);
		}
		text = text.substring(text.indexOf("["), (text.lastIndexOf("]"))+ 1 ).trim();			
		
		JsonParserFactory factory = Json.createParserFactory(null);
		JsonParser parser = factory.createParser(new StringReader(text));
		TripData tripData = new TripData();
		List<TripData> tripDataList = null;
		try{
			tripDataList = this.jsonParse(parser);
			if(tripDataList.isEmpty()){
				throw new JsonException("JSON is empty!");
			}
		}catch(JsonException e){
			e.printStackTrace();
		}
		
		List<Trip> tripList = new ArrayList();
		Trip trip = new Trip();

		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("Driver.findOne");
		//query.setParameter("r", "653838949222");
		//List<Driver> list = query.getResultList();
		
		query = em.createNamedQuery("Vehicle.findByOBD");
		query.setParameter("v", obdId);
		Vehicle vehicle = (Vehicle) query.getResultList().get(0);
		
		Driver driver = vehicle.getDriver();
		Route route = null;
		
		trip.setDriver(driver);
		
		tripList = driver.getTrips();
		tripList.add(trip);
		
		driver.setTrips(tripList);
		trip.setVehicle(vehicle);
		trip.setTripDatas(tripDataList);
		trip.setStatus(TripStatus.Success);
		tripList.add(trip);
		vehicle.setTrips(tripList);
		
		//find a route
		List<Route> routes = vehicle.getRoutes();
		if(routes.isEmpty())
			throw new RuntimeException("Routes not found for vehicle with the informed OBD id");
		else if(routes.size() == 1){
			route = routes.get(0);
		}else{
			
	
			for (Route route2 : routes) {
				
				if(route2.getDepartureTime() >= Integer.parseInt((tripDataList.get(0).getDateTime().get(Calendar.HOUR_OF_DAY)) + "" +
						tripDataList.get(0).getDateTime().get(Calendar.MINUTE)) && 
						route2.getArrivalTime() <= Integer.parseInt((tripDataList.get(0).getDateTime().get(Calendar.HOUR_OF_DAY)) + "" +
								tripDataList.get(0).getDateTime().get(Calendar.MINUTE))){
					route = route2;
					break;
				}
			}
			if(route == null){
				throw new RuntimeException("Routes not found for vehicle with the informed OBD id");
			}
		}
			
		trip.setRoute(route);
		
		
		
		int countTrip = 0;
		double beginDistance = 0;
		double endDistance = 0;
		
		for (TripData tripData2 : tripDataList) {
			countTrip++;
		
			em.getTransaction().begin();
			if(countTrip == 1){
				trip.setDepartureTime(tripData2.getDateTime());
				beginDistance = tripData2.getDistance();
			}
			if(countTrip == tripDataList.size()){				
				trip.setArrivalTime(tripData2.getDateTime());
				endDistance = tripData2.getDistance();
			}
			tripData2.setTrip(trip);
			
			em.persist(tripData2);
			em.getTransaction().commit();
		}
		
		if(endDistance == 0)
			trip.setDistance(beginDistance);
		else
			trip.setDistance(endDistance - beginDistance);
		
		TripDefault tripDef = route.getTripDefault();
		if(route.getTrips().size() <= 5){
			tripDef.setMaxAndMin(tripDataList);
			tripDef.setRoute(route);
			route.setTripDefault(tripDef);
		}
		trip.setRoute(route);
		
		em.getTransaction().begin();
		
		em.persist(trip);
		em.persist(route);
		em.persist(tripDef);
		
		em.getTransaction().commit();
		em.close();
		resp.getWriter().println("Success!");
	}
	
	
	private List<TripData> jsonParse(JsonParser parser) throws JsonException{
		int counter = 0;
	
		TripData tripData = new TripData();
		Stack<String> stack = new Stack<>();
		
		List<TripData> tripDataList = new ArrayList<>();
		
		if(!parser.hasNext()){
			throw new JsonException("JSON Parser is empty!");
		}
		
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
						tripData.setEngineRPM(Double.parseDouble(value));
						break;
					}
					case "speed": {
						tripData.setSpeed(Double.parseDouble(value));
						break;
					}
					case "fuelLevel": {
						tripData.setFuelLevel(Double.parseDouble(value));
						break;
					}
					case "engineLoad" :{
						tripData.setEngineLoad(Double.parseDouble(value));
						break;
					}
					case "id": {
						obdId = value;
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
					case "temp": {
						tripData.setTemperature(Long.parseLong(value));
						break;
					}
					case "lat": {
						tripData.setLatitude(Double.parseDouble(value));
					}
					case "lng": {
						tripData.setLongitude(Double.parseDouble(value));
					}
					case "distance": {
						tripData.setDistance(Double.parseDouble(value));
					}
					}
					break;
				}
				case VALUE_NUMBER: {
					String value = parser.getString();
					switch (stack.pop()) {
					case "timeStamp": {
						Calendar calendar = new GregorianCalendar();
						calendar.setTimeInMillis(Long.parseLong(value));
						tripData.setDateTime(calendar);
						break;
					}
					case "engineRPM": {
						tripData.setEngineRPM(Double.parseDouble(value));
						break;
					}
					case "engineLoad" :{
						tripData.setEngineLoad(Double.parseDouble(value));
						break;
					}
					case "speed": {
						tripData.setSpeed(Double.parseDouble(value));
						break;
					}
					case "fuelLevel": {
						tripData.setFuelLevel(Double.parseDouble(value));
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
					case "temp": {
						tripData.setTemperature(Long.parseLong(value));
						break;
					}
					case "lat": {
						tripData.setLatitude(Double.parseDouble(value));
					}
					case "lng": {
						tripData.setLongitude(Double.parseDouble(value));
					}
					case "distance": {
						tripData.setDistance(Double.parseDouble(value));
					}
				}
					break;
			}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return tripDataList;
	}
}
