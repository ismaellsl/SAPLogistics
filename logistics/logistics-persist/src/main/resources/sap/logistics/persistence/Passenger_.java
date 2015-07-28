package sap.logistics.persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-27T20:34:24.358-0300")
@StaticMetamodel(Passenger.class)
public class Passenger_ {
	public static volatile SingularAttribute<Passenger, Integer> id;
	public static volatile SingularAttribute<Passenger, String> name;
	public static volatile SingularAttribute<Passenger, String> registration;
	public static volatile SingularAttribute<Passenger, Long> mobileNumber;
	public static volatile SingularAttribute<Passenger, String> email;
	public static volatile SingularAttribute<Passenger, Route> route;
}
