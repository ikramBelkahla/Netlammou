package tn.esprit.pidev.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Article implements Serializable{
	
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   private String name;
   private String body;
   private String image;
   private Date date;
   private boolean favourite;
   private String other;

   @ManyToOne
   private User user;

      
   public Article() {
	   super();
   }

public Article(String name, String body, String image, Date date, boolean favourite, String other) {
	super();
	this.name = name;
	this.body = body;
	this.image = image;
	this.date = date;
	this.favourite = favourite;
	this.other = other;
}

public Article(String name, String body, String image, Date date, boolean favourite, String other, User user) {
	super();
	this.name = name;
	this.body = body;
	this.image = image;
	this.date = date;
	this.favourite = favourite;
	this.other = other;
	this.user = user;
}

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

public String getBody() {
	return body;
}

public void setBody(String body) {
	this.body = body;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public boolean isFavourite() {
	return favourite;
}

public void setFavourite(boolean favourite) {
	this.favourite = favourite;
}

public String getOther() {
	return other;
}

public void setOther(String other) {
	this.other = other;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}
   
   
}
