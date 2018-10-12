package tn.esprit.pidev.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Topic implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String object;
	private Date date;
	
/** Relations **/
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="topic" )
	private List<Comment> comments;
	
/***************/	
	
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
	public Topic(String object, Date date) {
		super();
		this.object = object;
		this.date = date;
	}
	public Topic() {
		super();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Topic(String object, Date date, User user, List<Comment> comments) {
		super();
		this.object = object;
		this.date = date;
		this.user = user;
		this.comments = comments;
	}
	public Topic(String object) {
		super();
		this.object = object;
	}
	

}
