package sap.logistics.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Trip implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	
	private Vehicle vehicle;
	
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
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Driver driver;
	
	@ManyToOne
	@JoinColumn(name = "route_id")
	private Route route;
	
	private Date date;
	private Date departureTime;
	private Date arrivalTime;
	private int passengerNr;
	private long distance;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
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

}
