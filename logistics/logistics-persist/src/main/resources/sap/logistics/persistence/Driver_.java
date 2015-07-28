package sap.logistics.persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-27T20:34:24.280-0300")
@StaticMetamodel(Driver.class)
public class Driver_ {
	public static volatile SingularAttribute<Driver, Integer> id;
	public static volatile SingularAttribute<Driver, String> name;
	public static volatile SingularAttribute<Driver, String> registration;
	public static volatile SingularAttribute<Driver, String> picture;
	public static volatile ListAttribute<Driver, Trip> trips;
}
