package sap.logistics.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQueries ({
	@NamedQuery(name="Driver.findOne", query="SELECT d FROM Driver d WHERE d.registration = :r") 
})
public class Driver implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@Column(unique = true)
	private String registration;
	
	private String picture;
	
	@OneToMany(mappedBy = "driver")
	private List<Trip> trips;
	
	public List<Trip> getTrips() {
		return trips;
	}
	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getId() {
		return id;
	}
}
