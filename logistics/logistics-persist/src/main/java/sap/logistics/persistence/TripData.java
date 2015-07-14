package sap.logistics.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class TripData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	private Date dateTime;
	private long engineRPM;
	private long speed;
	private long fuelLevel;
	
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
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
	
}
