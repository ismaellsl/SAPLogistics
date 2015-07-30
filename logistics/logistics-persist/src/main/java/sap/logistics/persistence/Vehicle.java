package sap.logistics.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;	

@Entity
@NamedQueries ({
	@NamedQuery(name="Vehicle.findOne", query="SELECT v FROM Vehicle v WHERE v.chassi = :v") 
})
public class Vehicle implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int id;
	
	private String plate;
	
	@Column(unique = true)
	private String chassi;
	
	private String fuelType;
	private String fiscalNumber;
	private int capacity;
	private String model;
	private String vehicleInscription;
	private int year;
	
	@OneToMany(mappedBy = "vehicle")
	private List<Trip> trips;
	
	@OneToMany(mappedBy = "vehicle")
	private List<Maintenance> maintenances;
	
	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}
	
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
	public int getId() {
		return id;
	}

	public List<Maintenance> getMaintenances() {
		return maintenances;
	}

	public void setMaintenance(List<Maintenance> maintenances) {
		this.maintenances = maintenances;
	}
}
