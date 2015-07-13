package sap.logistics.persistence;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Bus implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 10)
	private String licensePlate;
	
	private int numberOfPassangers;

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public int getNumberOfPassangers() {
		return numberOfPassangers;
	}

	public void setNumberOfPassangers(int numberOfPassangers) {
		this.numberOfPassangers = numberOfPassangers;
	}
}
