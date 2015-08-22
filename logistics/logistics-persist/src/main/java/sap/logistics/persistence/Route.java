package sap.logistics.persistence;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Route implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne
	private TripDefault tripDefault;	
	
	@OneToMany(mappedBy = "route")
	private List<Passenger> passagers;

	@OneToMany(mappedBy = "route")
	private List<Trip> trips;

	private String depertureLocation;
	private String arrivalLocation;
	private long distance;
	
	//must be like 1520 = 15:20
	private int departureTime;
	//must be like 1520 = 15:20
	private int arrivalTime;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	
	public int getId() {
		return id;
	}
	
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

	public TripDefault getTripDefault() {
		return tripDefault;
	}

	public void setTripDefault(TripDefault tripDefault) {
		this.tripDefault = tripDefault;
	}
	
	public int tripListSize(){
		return this.trips.size();
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public int getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(int departureTime) {
		this.departureTime = departureTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
}
