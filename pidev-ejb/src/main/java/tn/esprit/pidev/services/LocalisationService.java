package tn.esprit.pidev.services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.esprit.pidev.persistence.Action;
import tn.esprit.pidev.persistence.Localisation;

@Stateless
@LocalBean
@Path("/localisation")
public class LocalisationService implements LocalisationServiceRemote{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public int createLocalisation(Localisation localisation) {
		em.persist(localisation);
		em.flush();
		return localisation.getId();
	}

	@Override
	public void updateLocalisation(Localisation localisation, int id) {
		
		Localisation local =		
		em.find(Localisation.class, id);
		local.setLongitude(localisation.getLongitude());
		local.setAltitude(localisation.getAltitude());
		local.setType(localisation.getType());
		System.out.println("Localisation updated with success");
		
//		em.createQuery("Update Localisation");
		
	}

	@Override
	public void deleteLocalisation(int id) {
		em.remove(em.find(Localisation.class, id));
	}

	@Override
	public Localisation retriveLocalisationById(int id) {
		
		return null;
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{type}")
	public List<Localisation> searchLocalisationJPQL(@PathParam("type")String type/*,@PathParam("date") String date*/) {
//		TypedQuery<Localisation> query = em.createQuery(
//		"SELECT l from Localisation l join l.action a  where l.id = a.id and a.type= :type and a.date = :date ",Localisation.class);
		TypedQuery<Localisation> query = em.createQuery(
				"SELECT l from Localisation l where l.type = :type ",Localisation.class);
			
		query.setParameter("type", type);
//		query.setParameter("date", date);
		
	    return query.getResultList();
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Localisation> retriveAllLocalisation() {
		
		TypedQuery<Localisation> query = em.createQuery("select DISTINCT l from Localisation  l",Localisation.class);
//		TypedQuery<Localisation> query = em.createQuery("select DISTINCT l.id,l.altitude,l.longitude,l.type,l.action.id,l.user.id,l.address,l.name from Localisation  l",Localisation.class);
		
		return query.getResultList();

	}

	
	@Override
	public String getActionDescripton(int actionId) {
		TypedQuery<String> query = em.createQuery(
				"SELECT a.description from Action a join a.localisation l where l.id = :id ",String.class);
		query.setParameter("id", actionId);
//		return query.getSingleResult();
		return "the join request result";
	}

	@Override
	public String getActionName(int actionId) {
		TypedQuery<String> query = em.createQuery(
				"SELECT a.name from Action a join a.localisation l where l.id = :id ",String.class);
		query.setParameter("id", actionId);
		return query.getSingleResult();
	}
	@Override
	public Action getAction(int actionId) {
		TypedQuery<Action> query = em.createQuery(
				"l.action From Localisation l where  l.action.id = :id ",Action.class);
		query.setParameter("id", actionId);
		return query.getSingleResult();
	}
	@Override
	public int getActionDesiredVolenteers(int actionId) {
//		TypedQuery<Integer> query = em.createQuery(
//				"SELECT a.desiredVolenteers from Action a join a.localisation l where l.id = :id ",Integer.class);
//		query.setParameter("id", actionId);
		TypedQuery<Integer> query = em.createQuery(
				"SELECT l.action.id From Localisation l where  l.action.id = :id ",Integer.class);
		query.setParameter("id", actionId);
		return query.getSingleResult();
	}

	@Override
	public Date getActionDate(int actionId) {
		TypedQuery<Date> query = em.createQuery(
				"SELECT a.date from Action a join a.localisation l where l.id = :id ",Date.class);
		query.setParameter("id", actionId);
		
		return query.getSingleResult();
	}

//	@Override
//	public int createLoc( Action a) {
//		em.persist(a);
//		em.flush();
//		return a.getId() ;
//	
//	}

//	@Override
//	public void affectLocalisationToAction(int actionId, int localistionId) {
//		Localisation localisation=em.find(Localisation.class, localistionId);
//		Action  act =em.find(Action.class, actionId);
//		localisation.setAction(act);
//	}
}
