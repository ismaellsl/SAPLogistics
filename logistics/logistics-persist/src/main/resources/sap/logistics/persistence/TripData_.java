package sap.logistics.persistence;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-27T20:34:24.371-0300")
@StaticMetamodel(TripData.class)
public class TripData_ {
	public static volatile SingularAttribute<TripData, Integer> id;
	public static volatile SingularAttribute<TripData, Calendar> dateTime;
	public static volatile SingularAttribute<TripData, Long> engineRPM;
	public static volatile SingularAttribute<TripData, Long> speed;
	public static volatile SingularAttribute<TripData, Long> fuelLevel;
	public static volatile SingularAttribute<TripData, Trip> trip;
}
