package tn.esprit.pidev.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Rate implements Serializable {

	@EmbeddedId
	private RatePk ratePk;
	private float value;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="idAction",
	referencedColumnName="id",insertable=false,updatable=false)
	private Action action;
	
	@ManyToOne
	@JoinColumn(name="idVolenteer",
	referencedColumnName="id",insertable=false,updatable=false)
	private Volenteer volenteer;
	
	
	
	
	public Rate(float value, Date date, Action action, Volenteer volenteer) {
		super();
		this.value = value;
		this.date = date;
		this.action = action;
		this.volenteer = volenteer;
	}
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	public Volenteer getVolenteer() {
		return volenteer;
	}
	public void setVolenteer(Volenteer volenteer) {
		this.volenteer = volenteer;
	}
	public Rate(float value, Date date) {
		super();
		this.value = value;
		this.date = date;
	}
	public Rate() {
		super();
	}
	
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public RatePk getRatePk() {
		return ratePk;
	}
	public void setRatePk(RatePk ratePk) {
		this.ratePk = ratePk;
	}
	
	
	
}
