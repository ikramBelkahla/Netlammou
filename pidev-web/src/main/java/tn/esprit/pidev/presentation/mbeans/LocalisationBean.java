package tn.esprit.pidev.presentation.mbeans;


import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import tn.esprit.pidev.persistence.ActionType;
import tn.esprit.pidev.persistence.Localisation;
import tn.esprit.pidev.services.LocalisationService;

@ManagedBean
//@SessionScoped
public class LocalisationBean {
	
	private String altitude;
	private String longitude;
	private String type;
	private String name;
	private String address;
	private ActionType t; 
	
	private List<Localisation> localisation;
	private String description;
	private int desiredVolenteers;
	private Date date;
	private String s;
	
	@EJB
	LocalisationService localisationService;
	
	
	public void addLocalisation(String x,String d){
		type =x;
		s =d;
		localisationService.createLocalisation(
				new Localisation(altitude,longitude,type,d,address));
	}
	
	public void deleteLocalisation(Integer id){
		localisationService.deleteLocalisation(id);
	}
	
	public String getDescription() {
		description= localisationService.getActionDescripton(1);
		return description;
	}

	public int getDesiredVolenteers() {
		desiredVolenteers= localisationService.getActionDesiredVolenteers(1);
		return desiredVolenteers;
	}



	public void setDesiredVolenteers(int desiredVolenteers) {
		this.desiredVolenteers = desiredVolenteers;
	}



	public Date getDate() {
		date =  localisationService.getActionDate(1);
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public List<Localisation> getLocalisation() {
		localisation=localisationService.retriveAllLocalisation();
		return localisation;
	}


	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalisationService getLocalisationService() {
		return localisationService;
	}

	public void setLocalisationService(LocalisationService localisationService) {
		this.localisationService = localisationService;
	}
	
	public void setLocalisation(List<Localisation> localisation) {
		this.localisation = localisation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public ActionType getT() {
		return t;
	}

	public void setT(ActionType t) {
		this.t = t;
	}
	
}
