package tn.esprit.pidev.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Notification implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int description;
	private Date dateTime;
	
/** Relations **/
	
	@ManyToMany(mappedBy="notifications")
	private List<Volenteer > volenteers;
	
/*****************/
	
	public Notification() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDescription() {
		return description;
	}

	public void setDescription(int description) {
		this.description = description;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	

	public List<Volenteer> getVolenteers() {
		return volenteers;
	}

	public void setVolenteers(List<Volenteer> volenteers) {
		this.volenteers = volenteers;
	}

	public Notification(int description, Date dateTime) {
		super();
		this.description = description;
		this.dateTime = dateTime;
	}
//
	public Notification(int description, Date dateTime, List<Volenteer> volenteers) {
		super();
		this.description = description;
		this.dateTime = dateTime;
		this.volenteers = volenteers;
	}

}
