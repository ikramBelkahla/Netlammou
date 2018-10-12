package tn.esprit.pidev.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String adress;
	private String mailAdress;
	private int phoneNumber;
	private String passWodrd;

	
	/** Relations **/
	
	@OneToMany(mappedBy="user" ,cascade = CascadeType.PERSIST, fetch= FetchType.EAGER)
	private List<Article> articls;
	
	@OneToMany(mappedBy="user")
	private List<Message>messages;
	
	@OneToMany(mappedBy="user")
	private List<Topic> topics;

	@OneToOne(mappedBy="user"/*,cascade ={CascadeType.PERSIST},fetch=FetchType.EAGER*/)
	private Localisation localisation;
	
	@Enumerated(EnumType.STRING)
    private Role role;
	
/*************************/

	
	
	public String getPassWodrd() {
		return passWodrd;
	}
	public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
	public void setPassWodrd(String passWodrd) {
		this.passWodrd = passWodrd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getMailAdress() {
		return mailAdress;
	}
	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@JsonIgnore
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	@JsonIgnore
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	@JsonIgnore
	public Localisation getLocalisation() {
		return localisation;
	}
	public void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}
	public User(String adress, String mailAdress, int phoneNumber, String passWodrd, List<Message> messages,
			List<Topic> topics, Localisation localisation) {
		super();
		this.adress = adress;
		this.mailAdress = mailAdress;
		this.phoneNumber = phoneNumber;
		this.passWodrd = passWodrd;
		this.messages = messages;
		this.topics = topics;
		this.localisation = localisation;
	}
	
	public User(String adress, String mailAdress, int phoneNumber, String passWodrd) {
		super();
		this.adress = adress;
		this.mailAdress = mailAdress;
		this.phoneNumber = phoneNumber;
		this.passWodrd = passWodrd;
	}
	public User() {
		super();
}
	@JsonIgnore
	public List<Article> getArticls() {
		return articls;
	}
	public void setArticls(List<Article> articls) {
		this.articls = articls;
	}
	
}
