package tn.esprit.pidev.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String object;
	private Date date;
	private boolean reported;
	
	
	/** Relations **/
	@ManyToOne
	private Topic topic;
	
	/*******************/
	
	public Comment(String object, Date date, boolean reported) {
		super();
		this.object = object;
		this.date = date;
		this.reported = reported;
	}
	
	public Comment() {
		super();
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
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

	public Comment(String object, Date date, boolean reported, Topic topic) {
		super();
		this.object = object;
		this.date = date;
		this.reported = reported;
		this.topic = topic;
	}
	
	
}
