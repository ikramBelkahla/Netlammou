package tn.esprit.pidev.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Participate implements Serializable {

	@EmbeddedId
	private ParticipatePk participatePk;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="idAction",
	referencedColumnName="id",insertable=false,updatable=false)
	private Action action;
	
	@ManyToOne
	@JoinColumn(name="idVolenteer",
	referencedColumnName="id",insertable=false,updatable=false)
	private Volenteer volenteer;
	
	
	
	public ParticipatePk getParticipatePk() {
		return participatePk;
	}
	public void setParticipatePk(ParticipatePk participatePk) {
		this.participatePk = participatePk;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Participate(Date date) {
		super();
		this.date = date;
	}
	public Participate() {
		super();
	}
	public Participate(Date date, Action action, Volenteer volenteer) {
		super();
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
	

}
