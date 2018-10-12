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
public class Feedback implements Serializable  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String description;
	private Date date;
	private boolean reported;

/** Realtions **/
	
	@ManyToMany(mappedBy="feedbacks")
	private List<Action> actions;
	
	@ManyToMany(mappedBy="feedbacks")
	private List<Volenteer> volenteers;
	
/***************/	
	
	
	public Feedback(String description, Date date, boolean reported) {
		super();
		this.description = description;
		this.date = date;
		this.reported = reported;
	}
	public Feedback() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isReported() {
		return reported;
	}
	public void setReported(boolean reported) {
		this.reported = reported;
	}
	public Feedback(String description, Date date, boolean reported, List<Action> actions, List<Volenteer> volenteers) {
		super();
		this.description = description;
		this.date = date;
		this.reported = reported;
		this.actions = actions;
		this.volenteers = volenteers;
	}
	public List<Action> getActions() {
		return actions;
	}
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	public List<Volenteer> getVolenteers() {
		return volenteers;
	}
	public void setVolenteers(List<Volenteer> volenteers) {
		this.volenteers = volenteers;
	}
	

}
