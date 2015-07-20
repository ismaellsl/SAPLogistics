package sap.logistics.servlet;

import java.io.*;
import java.util.GregorianCalendar;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.*;

import sap.logistics.persistence.TripData;

public class InsertTripDataServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		
		String line;
		String[] lineSplited;
		BufferedReader br = req.getReader();
		TripData tripData;
		GregorianCalendar gc;
		
		br.readLine();br.readLine();br.readLine();br.readLine();br.readLine();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Logistics");
		
	  	// TODO missing try and catch for parse and em.
		while ((line = br.readLine()) != null && 
				!line.equals("") && 
				!line.contains("WebKitFormBoundary")){
			lineSplited = line.split(";");
			tripData = new TripData();
			gc = new GregorianCalendar();
			gc.set(Integer.parseInt((lineSplited[1].substring(4, 8).trim())), 
					Integer.parseInt(lineSplited[1].substring(2, 4).trim()), 
					Integer.parseInt(lineSplited[1].substring(0, 2).trim()),
					Integer.parseInt(lineSplited[1].substring(8, 10).trim()),
					Integer.parseInt(lineSplited[1].substring(11, 13).trim()));
	
			tripData.setDateTime(gc);
			tripData.setEngineRPM(Integer.parseInt(lineSplited[2]));
			tripData.setSpeed(Integer.parseInt(lineSplited[3]));
			tripData.setFuelLevel(Integer.parseInt(lineSplited[4]));
			
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(tripData);
			em.getTransaction().commit();
			em.close();
		}
		emf.close();
	}
}
