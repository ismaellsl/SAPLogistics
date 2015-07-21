package sap.logistics.persistence;

import java.io.Serializable;
<<<<<<< HEAD
import java.util.Date;
=======
>>>>>>> 8b1f28f7529a5ab1487db7e2a1bd402865890cbc
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Trip implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	
	private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Driver driver;
	
	@ManyToOne
	@JoinColumn(name = "route_id")
	private Route route;
	
	@OneToMany(mappedBy = "trip")
	private List<TripData> tripDatas;

	@Temporal(TemporalType.DATE)
	private Calendar date;
	@Temporal(TemporalType.TIME)
	private Calendar departureTime;
	@Temporal(TemporalType.TIME)

	private Calendar arrivalTime;
	private int passengerNr;
	private long distance;
	
	
	public int getPassengerNr() {
		return passengerNr;
	}
	public void setPassengerNr(int passengerNr) {
		this.passengerNr = passengerNr;
	}
	public long getDistance() {
		return distance;
	}
	public void setDistance(long distance) {
		this.distance = distance;
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
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
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
	

}
