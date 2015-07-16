package sap.logistics.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
public class Route implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	private int id;
	
	@OneToMany(mappedBy = "route")
	private List<Passenger> passagers;
	
	@OneToMany(mappedBy = "route")
	private List<Trip> trips;
	
	public List<Passenger> getPassagers() {
		return passagers;
	}
	public void setPassagers(List<Passenger> passagers) {
		this.passagers = passagers;
	}
	public List<Trip> getTrips() {
		return trips;
	}
	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}
	private String depertureLocation;
	private String arrivalLocation;
	private long distance;
	private Date departureTime;
	private Date arrivalTime;
	
	public String getDepertureLocation() {
		return depertureLocation;
	}
	public void setDepertureLocation(String depertureLocation) {
		this.depertureLocation = depertureLocation;
	}
	public String getArrivalLocation() {
		return arrivalLocation;
	}
	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}
	public long getDistance() {
		return distance;
	}
	public void setDistance(long distance) {
		this.distance = distance;
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

}
