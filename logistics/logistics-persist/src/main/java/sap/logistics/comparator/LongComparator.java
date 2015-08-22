package sap.logistics.comparator;

import java.util.Comparator;

import sap.logistics.persistence.TripDefault;

public class LongComparator implements Comparator<Long>{

	@Override
	public int compare(Long num1, Long num2) {
		return (num1 < num2) ? -1 : (num1 == num2) ? 0 : 1;
	}
	
}


