package tn.esprit.pidev.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class NGOs extends User implements Serializable {

private String name;
private String Description;

/** Realtions **/

	@OneToMany(mappedBy="ngos" )
	private List<Action> actions ;
	
	@OneToMany(mappedBy="ngo" )
	private List<Product> products  ;
	
	@ManyToMany(mappedBy="ngos" )
	private List<Volenteer> volenteers;
	
/******************/

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return Description;
}

public void setDescription(String description) {
	Description = description;
}
//
//public List<Action> getActions() {
//	return actions;
//}
//
//public void setActions(List<Action> actions) {
//	this.actions = actions;
//}
//
//public List<Volenteer> getVolenteers() {
//	return volenteers;
//}
//
//public void setVolenteers(List<Volenteer> volenteers) {
//	this.volenteers = volenteers;
//}
//
//public NGOs(String adress, String mailAdress, int phoneNumber, String passWodrd, String name, String description,
//		List<Action> actions, List<Volenteer> volenteers) {
//	super(adress, mailAdress, phoneNumber, passWodrd);
//	this.name = name;
//	Description = description;
//	this.actions = actions;
//	this.volenteers = volenteers;
//}

public NGOs(String adress, String mailAdress, int phoneNumber, String name, String description,String passWord) {
	super(adress, mailAdress, phoneNumber,passWord);
	this.name = name;
	Description = description;
}

public NGOs() {
	super();
}



	
	
}
