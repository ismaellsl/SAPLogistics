package sap.logistics.persistence;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

@Entity
public class TripData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int id;
	
	private Calendar dateTime;
	private long engineRPM;
	private long speed;
	private long fuelLevel;
	
	@ManyToOne
	@JoinColumn(name = "trip_id")
	private Trip trip;
	
	public int getId() {
		return id;
	}
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public long getEngineRPM() {
		return engineRPM;
	}
	public void setEngineRPM(long engineRPM) {
		this.engineRPM = engineRPM;
	}
	public long getSpeed() {
		return speed;
	}
	public void setSpeed(long speed) {
		this.speed = speed;
	}
	public long getFuelLevel() {
		return fuelLevel;
	}
	public void setFuelLevel(long fuelLevel) {
		this.fuelLevel = fuelLevel;
	}
	public Calendar getDateTime() {
		return dateTime;
	}
	public void setDateTime(Calendar dateTime) {
		this.dateTime = dateTime;
	}
	
}
