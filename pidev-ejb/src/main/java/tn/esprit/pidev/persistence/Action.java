package tn.esprit.pidev.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Action implements Serializable {
	
	
	@Override
	public String toString() {
		return "Action [type=" + type + "]";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date date;
	private Localisation place;
	
	

	
/** Relations **/	
	@JsonIgnore
	@OneToMany(mappedBy="action")
    private List<Rate> rates;
	@JsonIgnore
	@OneToMany(mappedBy="action")
    private List<Participate> participates;
	@JsonIgnore
	@OneToOne(mappedBy="action")
	private Localisation localisation;
	@JsonIgnore
	@ManyToOne
	private NGOs ngos;
	@JsonIgnore
	@ManyToMany 
	private List<Feedback> feedbacks;
	
/*******************/	
	@Enumerated(EnumType.STRING)
	private ActionType type; 

	private String description;
	private boolean actif ;
	private int desiredVolenteers;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ActionType getType() {
		return type;
	}
	public void setType(ActionType type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Action() {
		super();
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	public int getDesiredVolenteers() {
		return desiredVolenteers;
	}
	public void setDesiredVolenteers(int desiredVolenteers) {
		this.desiredVolenteers = desiredVolenteers;
	}
		
	public List<Rate> getRates() {
		return rates;
	}
	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}
	public List<Participate> getParticipates() {
		return participates;
	}
	public void setParticipates(List<Participate> participates) {
		this.participates = participates;
	}
	public Localisation getLocalisation() {
		return localisation;
	}
	public void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}
	public NGOs getNgos() {
		return ngos;
	}
	public void setNgos(NGOs ngos) {
		this.ngos = ngos;
	}
	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
	public Action(String name, Date date, ActionType type, String description, boolean actif, int desiredVolenteers) {
		super();
		this.name = name;
		this.date = date;
		this.type = type;
		this.description = description;
		this.actif = actif;
		this.desiredVolenteers = desiredVolenteers;
	}
	public Action(String name, Date date, ActionType type, String description, boolean actif, int desiredVolenteers, int id) {
		super();
		this.name = name;
		this.date = date;
		this.type = type;
		this.description = description;
		this.actif = actif;
		this.desiredVolenteers = desiredVolenteers;
		this.id = id;
	}
	
	public Localisation getPlace() {
		return place;
	}
	public void setPlace(Localisation place) {
		this.place = place;
	}
	
	
	
	
}
