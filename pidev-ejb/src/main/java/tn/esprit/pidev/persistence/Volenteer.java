package tn.esprit.pidev.persistence;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity

public class Volenteer extends User implements Serializable{

	private int age;
	private String lastName;
	private String firstName;
	private boolean potential;
	
/** Ralations **/
	
	@OneToMany(mappedBy="volenteer")
    private List<Rate> rates;
	
	@OneToMany(mappedBy="volenteer")
    private List<Participate> participates;
	
	@OneToMany(mappedBy="volenteer")
    private List<Basket> baskets;
	
	@ManyToMany
	private List<Feedback> feedbacks;
	
	@ManyToMany
	private List<Preference> preferences ;
	
	@ManyToMany
	private List<Notification> notifications;
	
	@ManyToMany 
	private List<NGOs> ngos;

/*******/	
	

	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public boolean isPotential() {
		return potential;
	}


	public void setPotential(boolean potential) {
		this.potential = potential;
	}


	public List<Preference> getPreferences() {
		return preferences;
	}


	public void setPreferences(List<Preference> preferences) {
		this.preferences = preferences;
	}
//

	public List<Rate> getRates() {
		return rates;
	}


	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}


	public List<Participate> getParticipates() {
		return participates;
	}
//
//
	public void setParticipates(List<Participate> participates) {
		this.participates = participates;
	}


	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}


	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}


	public List<Notification> getNotifications() {
		return notifications;
	}


	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
//

	public List<NGOs> getNgos() {
		return ngos;
	}


	public void setNgos(List<NGOs> ngos) {
		this.ngos = ngos;
	}


	public Volenteer(String adress, String mailAdress, int phoneNumber, int age, String lastName, String firstName,
			boolean potential, List<Preference> preferences,String passWord) {
		super(adress, mailAdress, phoneNumber,passWord);
		this.age = age;
		this.lastName = lastName;
		this.firstName = firstName;
		this.potential = potential;
		this.preferences = preferences;
	}


	public Volenteer(String adress, String mailAdress, int phoneNumber, String passWodrd, List<Message> messages,
			List<Topic> topics, Localisation localisation, int age, String lastName, String firstName,
			boolean potential, List<Rate> rates, List<Participate> participates, List<Feedback> feedbacks,
			List<Preference> preferences, List<Notification> notifications, List<NGOs> ngos) {
		super(adress, mailAdress, phoneNumber, passWodrd, messages, topics, localisation);
		this.age = age;
		this.lastName = lastName;
		this.firstName = firstName;
		this.potential = potential;
		this.rates = rates;
		this.participates = participates;
		this.feedbacks = feedbacks;
		this.preferences = preferences;
		this.notifications = notifications;
		this.ngos = ngos;
	}


	public Volenteer() {
		super();
	}
	
	
	
}
