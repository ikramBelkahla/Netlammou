package tn.esprit.pidev.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Message implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String object;
	private Date date;
	private String content ;
	private boolean deleted;
	
	/** Relations **/
	@ManyToOne
	private User user;
	
	/*************/
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Message(String object, Date date, String content, boolean deleted) {
		super();
		this.object = object;
		this.date = date;
		this.content = content;
		this.deleted = deleted;
	}
	public Message() {
		super();
	}
	public Message(String object, Date date, String content, boolean deleted, User user) {
		super();
		this.object = object;
		this.date = date;
		this.content = content;
		this.deleted = deleted;
		this.user = user;
	}
	

}
