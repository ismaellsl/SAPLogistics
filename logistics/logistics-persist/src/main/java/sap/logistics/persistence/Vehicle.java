package sap.logistics.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Vehicle.findOne", query = "SELECT v FROM Vehicle v WHERE v.chassi = :v"),
	@NamedQuery(name = "Vehicle.findByOBD", query = "SELECT v FROM Vehicle v WHERE v.obdId = :v") 
})
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(unique = true)
	private String obdId;

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
	
	@OneToMany(mappedBy = "vehicle")
	private List<Route> routes;
	
	@OneToOne
	private Driver driver;

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

	public String getObdId() {
		return obdId;
	}

	public void setObdId(String obdId) {
		this.obdId = obdId;
	}

	public void setMaintenances(List<Maintenance> maintenances) {
		this.maintenances = maintenances;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}



}
