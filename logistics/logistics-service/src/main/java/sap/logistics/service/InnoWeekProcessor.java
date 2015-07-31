package sap.logistics.service;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.ReturnType;
import org.apache.olingo.odata2.api.annotation.edm.EdmFunctionImport.ReturnType.Type;

import sap.logistics.service.types.MaintenanceAndReason;

public class InnoWeekProcessor {
	private EntityManager em;

	public InnoWeekProcessor() {
		em = Persistence.createEntityManagerFactory("logistics").createEntityManager();
	}

//	@SuppressWarnings("unchecked")
//	@EdmFunctionImport(name = "MaintenancesByReasons", entitySet = "Maintenance", returnType = @ReturnType(type = Type.COMPLEX, isCollection = true))
//	public Vector<String, Integer> maintenanceByReasons() {
//
//		Query q = em.createNamedQuery("Maintenance.countReason");
//		Vector<String, Integer> soList = (Vector<String, Integer>) q.getResultList();
//		return soList;
//	}
//	
//	public static void main (String args[]){
//		InnoWeekProcessor inwp = new InnoWeekProcessor();
//		Map<String, Integer> soList = inwp.maintenanceByReasons();
//		
//		
//		
//	}
}
