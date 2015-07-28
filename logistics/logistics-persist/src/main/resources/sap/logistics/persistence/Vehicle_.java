package sap.logistics.persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-27T20:34:24.375-0300")
@StaticMetamodel(Vehicle.class)
public class Vehicle_ {
	public static volatile SingularAttribute<Vehicle, Integer> id;
	public static volatile SingularAttribute<Vehicle, String> plate;
	public static volatile SingularAttribute<Vehicle, String> chassi;
	public static volatile SingularAttribute<Vehicle, String> fuelType;
	public static volatile SingularAttribute<Vehicle, String> fiscalNumber;
	public static volatile SingularAttribute<Vehicle, Integer> capacity;
	public static volatile SingularAttribute<Vehicle, String> model;
	public static volatile SingularAttribute<Vehicle, String> vehicleInscription;
	public static volatile SingularAttribute<Vehicle, Integer> year;
	public static volatile ListAttribute<Vehicle, Trip> trips;
}
