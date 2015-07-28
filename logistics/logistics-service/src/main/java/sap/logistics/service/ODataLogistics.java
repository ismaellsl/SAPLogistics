package sap.logistics.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.olingo.odata2.api.ODataCallback;
import org.apache.olingo.odata2.api.ODataDebugCallback;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;

public class ODataLogistics extends ODataJPAServiceFactory {
	private static final String PUNIT_NAME = "logistics";

	@Override
	public ODataJPAContext initializeODataJPAContext()
			throws ODataJPARuntimeException {
		ODataJPAContext oDataJPAContext = this.getODataJPAContext();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PUNIT_NAME);
		oDataJPAContext.setEntityManagerFactory(emf);
		oDataJPAContext.setPersistenceUnitName(PUNIT_NAME);
		return oDataJPAContext;

	}
	
	@SuppressWarnings("unchecked")
	public <T extends ODataCallback> T getCallback(final Class<? extends ODataCallback> callbackInterface)
	{ 
	  return (T) (callbackInterface.isAssignableFrom(ScenarioErrorCallback.class) ? 
	    new ScenarioErrorCallback() : 
	      callbackInterface.isAssignableFrom(ODataDebugCallback.class) ? 
	        new ScenarioDebugCallback() : 
	        super.getCallback(callbackInterface));
	}
}
