package tn.esprit.pidev.services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;

import tn.esprit.pidev.persistence.Action;
import tn.esprit.pidev.persistence.Localisation;

@Remote
public interface LocalisationServiceRemote {

	public int createLocalisation(Localisation localisation);
	public void updateLocalisation(Localisation localisation,int id);
	public void deleteLocalisation(int id); 
	// delete the action cause the delete of the localisation automaticaly (the same for user)
	public Localisation retriveLocalisationById (int id);
	public List<Localisation> retriveAllLocalisation ();
	public String getActionDescripton(int actionId);
	public String getActionName(int actionId);
	public int getActionDesiredVolenteers(int actionId);
	public Date getActionDate(int actionId);
	public List<Localisation> searchLocalisationJPQL(/* String type,*/String date);
	public Action getAction(int actionId);
//	public int createLoc(Action a);
//	/* ActionService */public void affectLocalisationToAction(int actionId, int localistionId);
//	/* UserService */public void affectLocalisationToUser(Localisation localisation);

}
