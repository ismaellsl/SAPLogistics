package sap.logistics.persistence;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name = "Trip.countByRoute", query = "SELECT COUNT(t.id) FROM Trip t WHERE t.route = :r")
})
public class Trip implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int id;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "driver_id")
	private Driver driver;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "route_id")
	private Route route;
	
	@OneToMany(mappedBy = "trip", cascade = CascadeType.PERSIST)
	private List<TripData> tripDatas;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar departureTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar arrivalTime;
	private int passengerNr;
	private double distance;
	
	public int getPassengerNr() {
		return passengerNr;
	}
	public void setPassengerNr(int passengerNr) {
		this.passengerNr = passengerNr;
	}
	
	public int getId() {
		return id;
	}
	public List<TripData> getTripDatas() {
		return tripDatas;
	}
	public void setTripDatas(List<TripData> tripDatas) {
		this.tripDatas = tripDatas;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Calendar getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Calendar departureTime) {
		this.departureTime = departureTime;
	}
	public Calendar getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Calendar arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}

}
