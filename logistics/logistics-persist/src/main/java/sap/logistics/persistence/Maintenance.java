package sap.logistics.persistence;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

import sap.logistics.persistence.types.MaintenanceReason;
import sap.logistics.persistence.types.MaintenanceType;

@Entity
@NamedQueries({ @NamedQuery(name = "Maintenance.countReason", query = "select m.reason, count(m) from Maintenance m group by m.reason") })
public class Maintenance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Enumerated(EnumType.STRING)
	private MaintenanceType type;
	@Enumerated(EnumType.STRING)
	private MaintenanceReason reason;
	private String description;

	@Temporal(TemporalType.TIME)
	private Calendar date;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;

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

	public MaintenanceType getType() {
		return type;
	}

	public void setType(MaintenanceType type) {
		this.type = type;
	}

	public MaintenanceReason getReason() {
		return reason;
	}

	public void setReason(MaintenanceReason reason) {
		this.reason = reason;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
