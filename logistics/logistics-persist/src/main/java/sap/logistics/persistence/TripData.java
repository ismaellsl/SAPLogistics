package sap.logistics.persistence;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
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
	
	private double engineRPM;
	private long x;
	private long y;
	private long z;
	private double speed;
	private long temperature;
	private double engineLoad;
	private double fuelLevel;
	private double latitude;
	private double longitude;
	private double distance;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "trip_id")
	private Trip trip;

	public Calendar getDateTime() {
		return dateTime;
	}

	public void setDateTime(Calendar dateTime) {
		this.dateTime = dateTime;
	}

	public double getEngineRPM() {
		return engineRPM;
	}

	public void setEngineRPM(double engineRPM) {
		this.engineRPM = engineRPM;
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

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public long getTemperature() {
		return temperature;
	}

	public void setTemperature(long temperature) {
		this.temperature = temperature;
	}

	public double getEngineLoad() {
		return engineLoad;
	}

	public void setEngineLoad(double engineLoad) {
		this.engineLoad = engineLoad;
	}

	public double getFuelLevel() {
		return fuelLevel;
	}

	public void setFuelLevel(double fuelLevel) {
		this.fuelLevel = fuelLevel;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public int getId() {
		return id;
	}
	
}
