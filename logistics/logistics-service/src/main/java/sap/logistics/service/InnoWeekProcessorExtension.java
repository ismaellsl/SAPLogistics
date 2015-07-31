package sap.logistics.service;

import java.io.InputStream;

import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmExtension;
import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmSchemaView;

public class InnoWeekProcessorExtension implements JPAEdmExtension {

	@Override
	public void extendJPAEdmSchema(JPAEdmSchemaView arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void extendWithOperation(JPAEdmSchemaView arg0) {
		arg0.registerOperations(InnoWeekProcessor.class, null);

	}

	@Override
	public InputStream getJPAEdmMappingModelStream() {
		// TODO Auto-generated method stub
		return null;
	}

}
