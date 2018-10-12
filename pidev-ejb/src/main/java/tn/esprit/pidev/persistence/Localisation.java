package tn.esprit.pidev.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Localisation implements Serializable  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String altitude;
	private String longitude;
	private String name;
	private String address;
	private String type;
	
	
/** Relations **/
	@OneToOne
	private User user;
	@OneToOne
	private Action action;
	
/***************/	
	
	public String getAltitude() {
		return altitude;
	}
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Localisation(String altitude, String longitude, String type,String name,String address) {
		super();
		this.altitude = altitude;
		this.longitude = longitude;
		this.type = type;
		this.name = name;
		this.address = address;
	}
	public Localisation() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	public Localisation(String altitude, String longitude, String name, String address, String type, User user,
			Action action) {
		super();
		this.altitude = altitude;
		this.longitude = longitude;
		this.name = name;
		this.address = address;
		this.type = type;
		this.user = user;
		this.action = action;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
