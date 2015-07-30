package sap.logistics.persistence;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TripData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateTime;
	
	private long engineRPM;
	private long x;
	private long y;
	private long z;
	private long speed;
	private long temperature;
	private long engineLoad;
	
	private long fuelLevel;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
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

	public long getX() {
		return x;
	}

	public void setX(long x) {
		this.x = x;
	}

	public long getY() {
		return y;
	}

	public void setY(long y) {
		this.y = y;
	}

	public long getZ() {
		return z;
	}

	public void setZ(long z) {
		this.z = z;
	}
	
	public long getTemperature() {
		return temperature;
	}

	public void setTemperature(long temperature) {
		this.temperature = temperature;
	}

	public long getEngineLoad() {
		return engineLoad;
	}

	public void setEngineLoad(long engineLoad) {
		this.engineLoad = engineLoad;
	}

}
