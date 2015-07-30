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

import sap.logistics.persistence.*;



public class ContingencyTripDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("logistics");

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BufferedReader br = req.getReader();
		br.readLine();br.readLine();br.readLine();
		String line;
		String text = "";
		while((line = br.readLine()) != null){
			if(line.contains("WebKitFormBoundary"))
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
			try{
			  Event event = parser.next();
			  switch (event) {
				  case START_OBJECT: {
				  		counter++;
				    	break;
				    }
				  	case END_OBJECT: {
				  		counter--;
				  		if(counter == 0){ 
				
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
				    	switch (stack.pop()){
				    		case "engineRPM":{
				    			tripData.setEngineRPM(Long.parseLong(value));
				    			break;
				    		}
				    		case "speed":{
				    			tripData.setSpeed(Long.parseLong(value));
				    			break;
				    		}
				    		case "fuelLevel":{
				    			tripData.setFuelLevel(Long.parseLong(value));
				    			break;
				    		}
				    		case "id":{
				    			busId = value;
				    			break;
				    		}
				    		case "xAxis":{
				    			tripData.setX(Long.parseLong(value));
				    			break;
				    		}
				    		case "yAxis":{
				    			tripData.setY(Long.parseLong(value));
				    			break;
				    		}
				    		case "zAxis":{
				    			tripData.setZ(Long.parseLong(value));
				    			break;
				    		}
				    	} 
				    	break;
				    }
				    case VALUE_NUMBER: {
				    	String value = parser.getString(); 
				    	switch (stack.pop()){
					    	case "id":{
				    			busId = value;
				    			break;
				    		}
				    		case "engineRPM":{
				    			tripData.setEngineRPM(Long.parseLong(value));
				    			break;
				    		}
				    		case "speed":{
				    			tripData.setSpeed(Long.parseLong(value));
				    			break;
				    		}
				    		case "fuelLevel":{
				    			tripData.setFuelLevel(Long.parseLong(value));
				    			break;
				    		}
				    		case "xAxis":{
				    			tripData.setX(Long.parseLong(value));
				    			break;
				    		}
				    		case "yAxis":{
				    			tripData.setY(Long.parseLong(value));
				    			break;
				    		}
				    		case "zAxis":{
				    			tripData.setZ(Long.parseLong(value));
				    			break;
				    		}
				    	} 
				    break;
				    }
				  }
			}catch(Exception e){
				resp.getWriter().println("Some errors occured");
			}

		}
		List<Trip> tripList = new ArrayList();
		Trip trip = new Trip();
		Vehicle vehicle = new Vehicle();
		vehicle.setCapacity(5);
		vehicle.setChassi("ABC-213435464353");
		vehicle.setFuelType("Gasoline");
		vehicle.setPlate("IHC-8657");
		vehicle.setModel("Sandeiro");
		vehicle.setYear(2014);
		
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("Driver.findOne");
		query.setParameter("r", "653838949222");
		
		List<Driver> list = query.getResultList();
		Driver driver = null;
		
		if (list.isEmpty()){
			driver = new Driver();
			driver.setName("Rodrigo Buhler");
			driver.setRegistration("653838949222");
			driver.setTrips(tripList);
		}else if(list.size() == 1){
			driver = list.get(0);
		}else{
			resp.getWriter().println("Error! There are more than 1 entry in Driver for this registration number");
		}
		
		trip.setArrivalTime(tripArrivalDate);
		trip.setDistance(2000);
		trip.setDriver(driver);
		trip.setVehicle(vehicle);
		tripList.add(trip);
		vehicle.setTrips(tripList);
		

		for (TripData tripData2 : tripDataList) {
  			Calendar date = new GregorianCalendar();
  			tripData2.setDateTime(date);
			tripData2.setTrip(trip);
			em.getTransaction().begin();
			em.persist(tripData2);
			em.getTransaction().commit();
			
  			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Calendar departureDate = new GregorianCalendar();
		trip.setDepartureTime(departureDate);
		em.getTransaction().begin();
		em.persist(trip);
		em.persist(vehicle);
		em.persist(driver);
		em.getTransaction().commit();
		em.close();
	}
}
