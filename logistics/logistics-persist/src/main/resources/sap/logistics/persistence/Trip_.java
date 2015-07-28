package sap.logistics.persistence;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-27T20:34:24.367-0300")
@StaticMetamodel(Trip.class)
public class Trip_ {
	public static volatile SingularAttribute<Trip, Integer> id;
	public static volatile SingularAttribute<Trip, Vehicle> vehicle;
	public static volatile SingularAttribute<Trip, Driver> driver;
	public static volatile SingularAttribute<Trip, Route> route;
	public static volatile ListAttribute<Trip, TripData> tripDatas;
	public static volatile SingularAttribute<Trip, Calendar> date;
	public static volatile SingularAttribute<Trip, Calendar> departureTime;
	public static volatile SingularAttribute<Trip, Calendar> arrivalTime;
	public static volatile SingularAttribute<Trip, Integer> passengerNr;
	public static volatile SingularAttribute<Trip, Long> distance;
}
