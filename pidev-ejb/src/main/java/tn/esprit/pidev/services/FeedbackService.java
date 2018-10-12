package tn.esprit.pidev.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.pidev.persistence.Feedback;


@Stateless
@LocalBean
public class FeedbackService {
	
	
	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;
	
	
	public int ajouterFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		em.persist(feedback);
		return feedback.getId();
	}
	
	public List<Feedback> findAll()
	{	
		  TypedQuery<Feedback> query = em.createQuery("Select a from Feedback a ", Feedback.class);
		  return query.getResultList();
	}
	
	public List<Feedback> findAllPast()
	{	
		  List<Feedback> query = em.createQuery("Select a from feedback a ", Feedback.class).getResultList();
		  return query;
	}
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	
	public void deleteFeedbackById(int feedbackId)
	{
		Feedback feedback = em.find(Feedback.class, feedbackId);
		
		em.remove(feedback);
	}
	public void validerFeedback(int id){
		Feedback feed=em.find(Feedback.class, id);
		feed.setReported(true);
	}

	
	public void updateFeedback(Feedback feedback)
	{
		em.merge(feedback);
	}

}
