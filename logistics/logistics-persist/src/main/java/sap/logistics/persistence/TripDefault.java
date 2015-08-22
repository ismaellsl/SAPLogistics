package sap.logistics.persistence; 

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sap.logistics.comparator.LongComparator;

@Entity
public class TripDefault implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	private Route route;
	
	private double maxDistance;
	private double minDistance;
	private double maxFuelLevel;
	private double minFuelLevel;
	private double maxEngineRPM;
	private double minEngineRPM;
	private double maxSpeed;
	private double minSpeed;
	private long maxTemperature;
	private long minTemperature;
	private double maxEngineLoad;
	private double minEngineLoad;
	
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public double getMaxDistance() {
		return maxDistance;
	}
	public void setMaxDistance(double maxDistance) {
		this.maxDistance = maxDistance;
	}
	public double getMinDistance() {
		return minDistance;
	}
	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
	}
	public double getMaxFuelLevel() {
		return maxFuelLevel;
	}
	public void setMaxFuelLevel(double maxFuelLevel) {
		this.maxFuelLevel = maxFuelLevel;
	}
	public double getMinFuelLevel() {
		return minFuelLevel;
	}
	public void setMinFuelLevel(double minFuelLevel) {
		this.minFuelLevel = minFuelLevel;
	}
	public double getMaxEngineRPM() {
		return maxEngineRPM;
	}
	public void setMaxEngineRPM(double maxEngineRPM) {
		this.maxEngineRPM = maxEngineRPM;
	}
	public double getMinEngineRPM() {
		return minEngineRPM;
	}
	public void setMinEngineRPM(double minEngineRPM) {
		this.minEngineRPM = minEngineRPM;
	}
	public double getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public double getMinSpeed() {
		return minSpeed;
	}
	public void setMinSpeed(double minSpeed) {
		this.minSpeed = minSpeed;
	}
	public long getMaxTemperature() {
		return maxTemperature;
	}
	public void setMaxTemperature(long maxTemperature) {
		this.maxTemperature = maxTemperature;
	}
	public long getMinTemperature() {
		return minTemperature;
	}
	public void setMinTemperature(long minTemperature) {
		this.minTemperature = minTemperature;
	}
	public double getMaxEngineLoad() {
		return maxEngineLoad;
	}
	public void setMaxEngineLoad(double maxEngineLoad) {
		this.maxEngineLoad = maxEngineLoad;
	}
	public double getMinEngineLoad() {
		return minEngineLoad;
	}
	public void setMinEngineLoad(double minEngineLoad) {
		this.minEngineLoad = minEngineLoad;
	}
	public int getId() {
		return id;
	}
	public void setMaxAndMin(List<TripData> list){
		double maxDistance;
		double minDistance;
		double maxFuelLevel;
		double minFuelLevel;
		double maxEngineRPM;
		double minEngineRPM;
		double maxSpeed;
		double minSpeed;
		long maxTemperature;
		long minTemperature;
		double maxEngineLoad;
		double minEngineLoad;
		
		if(!list.isEmpty()){
			maxDistance = this.getMaxDistance();
			minDistance = this.getMinDistance();
			maxFuelLevel = this.getMaxFuelLevel();
			minFuelLevel = this.getMinFuelLevel();
			maxEngineRPM = this.getMaxEngineRPM();
			minEngineRPM = this.getMinEngineRPM();
			maxSpeed = this.getMaxSpeed();
			minSpeed = this.getMinSpeed();
			maxTemperature = this.getMaxTemperature();
			minTemperature = this.getMinTemperature();
			maxEngineLoad = this.getMaxEngineLoad();
			minEngineLoad = this.getMinEngineLoad();
			
			for (TripData tripData : list) {
				maxDistance = maxDistance < tripData.getDistance() ? tripData.getDistance() : maxDistance;
				minDistance = minDistance > tripData.getDistance() ? tripData.getDistance() : minDistance;
				
				maxEngineRPM = maxEngineRPM < tripData.getEngineRPM() ? tripData.getEngineRPM() : maxEngineRPM;
				minEngineRPM = minEngineRPM > tripData.getEngineRPM() ? tripData.getEngineRPM() : minEngineRPM;
				
				maxFuelLevel = maxFuelLevel < tripData.getFuelLevel() ? tripData.getFuelLevel() : maxFuelLevel;
				minFuelLevel = minFuelLevel > tripData.getFuelLevel() ? tripData.getFuelLevel() : minFuelLevel;
				
				maxSpeed = maxSpeed < tripData.getSpeed() ? tripData.getSpeed() : maxSpeed;
				minSpeed = minSpeed > tripData.getSpeed() ? tripData.getSpeed() : minSpeed;
				
				maxTemperature = maxTemperature < tripData.getTemperature() ? tripData.getTemperature() : maxTemperature;
				minTemperature = minTemperature > tripData.getTemperature() ? tripData.getTemperature() : minTemperature;
				
				maxEngineLoad = maxEngineLoad < tripData.getEngineLoad() ? tripData.getEngineLoad() : maxEngineLoad;
				minEngineLoad = minEngineLoad > tripData.getEngineLoad() ? tripData.getEngineLoad() : minEngineLoad;
			}
			
			this.maxDistance = maxDistance;
			this.minDistance = minDistance;
			this.maxFuelLevel = maxFuelLevel;
			this.minFuelLevel = minFuelLevel;
			this.maxEngineRPM = maxEngineRPM;
			this.minEngineRPM = minEngineRPM;  
			this.maxSpeed = maxSpeed;
			this.minSpeed = minSpeed;
			this.maxTemperature = maxTemperature;
			this.minTemperature = minTemperature; 
			this.maxEngineLoad = maxEngineLoad;
			this.minEngineLoad = minEngineLoad;
			
		}
	}
}