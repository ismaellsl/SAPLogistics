package sap.logistics.persistence;

import java.io.Serializable;
import java.util.Calendar;
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

	@Temporal(TemporalType.TIME)
	private Calendar dateTime;
	
	private long engineRPM;
	private long xAxis;
	private long yAxis;
	private long zAxis;
	private long speed;
	public long getxAxis() {
		return xAxis;
	}
	public void setxAxis(long xAxis) {
		this.xAxis = xAxis;
	}
	public long getyAxis() {
		return yAxis;
	}
	public void setyAxis(long yAxis) {
		this.yAxis = yAxis;
	}
	public long getzAxis() {
		return zAxis;
	}
	public void setzAxis(long zAxis) {
		this.zAxis = zAxis;
	}
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
	@Override
	public String toString() {
		return "TripData [id=" + id + ", dateTime=" + dateTime + ", engineRPM=" + engineRPM + ", xAxis=" + xAxis
				+ ", yAxis=" + yAxis + ", zAxis=" + zAxis + ", speed=" + speed + ", fuelLevel=" + fuelLevel + ", trip="
				+ trip + "]";
	}
}
