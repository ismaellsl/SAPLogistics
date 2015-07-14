package sap.logistics.persistence;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Driver implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	private String name;
	private String registration;
	private String picture;
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
}
