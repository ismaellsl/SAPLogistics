package sap.logistics.persistence;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

@Entity
public class Maintenance implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	

	private String type;
	private String description;
	
	@Temporal(TemporalType.TIME)
	private Calendar date;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
