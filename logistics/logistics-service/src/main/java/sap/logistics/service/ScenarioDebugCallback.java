package sap.logistics.service;

import org.apache.olingo.odata2.api.ODataDebugCallback;

final class ScenarioDebugCallback implements ODataDebugCallback {
	  @Override
	  public boolean isDebugEnabled()
	  { 
	    return true; 
	  }
	}