package tn.esprit.pidev.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.pidev.persistence.Comment;
import tn.esprit.pidev.persistence.Topic;
import tn.esprit.pidev.persistence.User;


@Stateless
@LocalBean
public class TopicService implements TopicServiceRemote {

	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<Topic> findAll()
	{	
		  List<Topic> query = em.createQuery("Select e from Topic e ", Topic.class).getResultList();
	
		  
		  
		  return query;
		  
		  
	}
	
	

	@Override
	public Topic getTopicById(int id) {
		TypedQuery<Topic> query = em.createQuery("Select e from Topic e "
	    + "where e.id=:id",Topic.class);
		query.setParameter("email",id);
		Topic topic = null;
		try 
		{topic = query.getSingleResult();}catch(NoResultException e)
		{
			//Logger.info("aucun employe trouve avec email : " + email);
			System.out.println("acces refus");
			}
		
		return topic;
	}
	
	@Override
	public int ajouterTopic(Topic e) {
		em.persist(e);
		return e.getId();
	}
	
	@Override
	public void deleteTopic(Topic e) {
		int a=e.getId();
		TypedQuery<Topic> query = em.createQuery("Select e from Topic e where e.id=:a",Topic.class);
		query.setParameter("a",a);
		Topic topic = null;
		topic = query.getSingleResult();
		em.remove(topic);
			
	}
	
	
	@Override
	public void deleteeTopic(int id) {
		TypedQuery<Topic> query = em.createQuery("Select e from Topic e where e.id=:a",Topic.class);
		query.setParameter("a",id);
		Topic topic = null;
		topic = query.getSingleResult();
		em.remove(topic);
			
	}
	
	
	@Override
	public void updateTopic(Topic topic)
	{
		em.merge(topic);
	}
	
	
	
	
	@Override
	public String a()
	{
		
		return "hahaha";
	}
}
