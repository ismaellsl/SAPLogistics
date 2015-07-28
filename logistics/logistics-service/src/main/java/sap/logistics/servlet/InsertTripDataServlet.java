package sap.logistics.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.GregorianCalendar;
import java.util.Stack;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParserFactory;
import javax.json.stream.JsonParser.Event;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sap.logistics.persistence.TripData;

public class InsertTripDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BufferedReader br = req.getReader();
		String line;
		String text = "";
		while((line = br.readLine()) != null){
			text = text.concat("\n" + line);
		}
		text = text.substring(text.indexOf('['), text.indexOf(']'));
		JsonParserFactory factory = Json.createParserFactory(null);
		JsonParser parser = factory.createParser(new StringReader(text));
		Stack<String> stack = new Stack<>();
		TripData tripData = new TripData();
		String busId = "";
		while (parser.hasNext()) {
		  Event event = parser.next();

		  switch (event) {
		    case KEY_NAME: {
		    	stack.push(parser.getString());
		    	break;
		    }
		    case VALUE_STRING: {
		    	String value = parser.getString(); 
		    	switch (stack.pop()){
		    		case "timeStamp":{
		    			tripData.setDateTime(
		    					new GregorianCalendar(
		    							Integer.parseInt(value.substring(0, 4).trim()), 
		    							Integer.parseInt(value.substring(4, 6).trim()), 
		    							Integer.parseInt(value.substring(6, 8).trim()), 
		    							Integer.parseInt(value.substring(8, 10).trim()), 
		    							Integer.parseInt(value.substring(10, 12).trim()), 
		    							Integer.parseInt(value.substring(12, 14).trim())
		    							)
		    					);
		    			break;
		    		}
		    		case "engineRPM":{
		    			tripData.setEngineRPM(Integer.parseInt(value));
		    			break;
		    		}
		    		case "speed":{
		    			tripData.setSpeed(Integer.parseInt(value));
		    			break;
		    		}
		    		case "fuelLevel":{
		    			tripData.setFuelLevel(Integer.parseInt(value));
		    			break;
		    		}
		    		case "id":{
		    			busId = value;
		    			break;
		    		}
		    	} 
		    	break;
		    }
		    case VALUE_NUMBER: {
		    	String value = parser.getString(); 
		    	switch (stack.pop()){
	    		case "timeStamp":{
	    			tripData.setDateTime(
	    					new GregorianCalendar(
	    							Integer.parseInt(value.substring(0, 4).trim()), 
	    							Integer.parseInt(value.substring(4, 6).trim()), 
	    							Integer.parseInt(value.substring(6, 8).trim()), 
	    							Integer.parseInt(value.substring(8, 10).trim()), 
	    							Integer.parseInt(value.substring(10, 12).trim()), 
	    							Integer.parseInt(value.substring(12, 14).trim())
	    							)
	    					);
	    			break;
	    		}
	    		case "engineRPM":{
	    			tripData.setEngineRPM(Integer.parseInt(value));
	    			break;
	    		}
	    		case "speed":{
	    			tripData.setSpeed(Integer.parseInt(value));
	    			break;
	    		}
	    		case "fuelLevel":{
	    			tripData.setFuelLevel(Integer.parseInt(value));
	    			break;
	    		}
	    		case "id":{
	    			busId = value;
	    			break;
	    		}
	    	} 
	    	break;
		    }
		  }
		}
		
	}
}
