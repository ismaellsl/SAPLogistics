package sap.logistics.persistence;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class Passenger implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	private String name;
	private String registration;
	private long mobileNumber;
	private String email;
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
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
