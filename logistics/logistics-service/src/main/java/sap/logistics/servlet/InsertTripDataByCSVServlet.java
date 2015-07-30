package sap.logistics.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sap.logistics.persistence.Driver;

public class InsertTripDataByCSVServlet extends HttpServlet{
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("logistics"); 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String)req.getAttribute("id");
		String rpm = (String)req.getAttribute("rpm");
		String temperature = (String)req.getAttribute("temp");
		String speed = (String)req.getAttribute("speed");
		String egineLoad = (String)req.getAttribute("el");
		String x = (String)req.getAttribute("x");
		String y = (String)req.getAttribute("y");
		String z = (String)req.getAttribute("z");
		
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("Driver.findOne");
		query.setParameter("r", "653838949222");
		
		List<Driver> list = query.getResultList( );
		Driver driver = null;
		
		if (list.isEmpty()){
			driver = new Driver();
		}else if(true){
			
		}else{
			
		}
	}
}
