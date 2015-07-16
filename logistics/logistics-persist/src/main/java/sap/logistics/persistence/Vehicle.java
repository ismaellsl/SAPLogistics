package sap.logistics.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;	

@Entity
public class Vehicle implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	private int id;
	
	private String plate;
	private String chassi;
	private String fuelType;
	private String fiscalNumber;
	private int capacity;
	
	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	private String model;
	private String vehicleInscription;
	private int year;
	
	@OneToMany(mappedBy = "vehicle")
	private List<Trip> trips;
	
	public String getPlate() {
		return plate;
	}
	
	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public String getChassi() {
		return chassi;
	}
	
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	
	public String getFuelType() {
		return fuelType;
	}
	
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
	public String getFiscalNumber() {
		return fiscalNumber;
	}
	
	public void setFiscalNumber(String fiscalNumber) {
		this.fiscalNumber = fiscalNumber;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getVehicleInscription() {
		return vehicleInscription;
	}
	
	public void setVehicleInscription(String vehicleInscription) {
		this.vehicleInscription = vehicleInscription;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
}
