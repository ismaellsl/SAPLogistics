package sap.logistics.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Trip implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
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
