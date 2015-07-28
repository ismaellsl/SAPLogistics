package sap.logistics.persistence;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-27T20:34:24.363-0300")
@StaticMetamodel(Route.class)
public class Route_ {
	public static volatile SingularAttribute<Route, Integer> id;
	public static volatile ListAttribute<Route, Passenger> passagers;
	public static volatile ListAttribute<Route, Trip> trips;
	public static volatile SingularAttribute<Route, String> depertureLocation;
	public static volatile SingularAttribute<Route, String> arrivalLocation;
	public static volatile SingularAttribute<Route, Long> distance;
	public static volatile SingularAttribute<Route, Calendar> departureTime;
	public static volatile SingularAttribute<Route, Calendar> arrivalTime;
}
