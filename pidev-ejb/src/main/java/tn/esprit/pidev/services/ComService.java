package tn.esprit.pidev.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.pidev.persistence.Comment;
import tn.esprit.pidev.persistence.Topic;
import tn.esprit.pidev.persistence.User;

@Stateless
@LocalBean
public class ComService implements ComServiceRemote {

	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public List<Comment> getCommentByTopic(Topic topic) {
		String sql = "SELECT e FROM Comment e WHERE e.topic=:annee";

        Query query = em.createQuery(sql);
        query.setParameter("annee", topic);

        List<Comment> coms = query.getResultList();

        return coms;
		
	}
	
	@Override
	public List<Comment> getCommentByTopicc(int id) {
		
		String sqll = "SELECT e FROM Topic e WHERE e.id=:annee";

		TypedQuery<Topic> queryy = em.createQuery(sqll,Topic.class);
        queryy.setParameter("annee", id);
        Topic top=null;
        top=queryy.getSingleResult();
		
		String sql = "SELECT e FROM Comment e WHERE e.topic=:annee";

        Query query = em.createQuery(sql);
        query.setParameter("annee", top);

        List<Comment> coms = query.getResultList();

        return coms;
		
	}
	
	
	

	@Override
	public int ajouterCom(Comment e) {
		em.persist(e);
		return e.getId();
	}
	
	@Override
	public void deleteCom(Comment com) {
		int a=com.getId();
		TypedQuery<Comment> query = em.createQuery("Select e from Comment e where e.id=:a",Comment.class);
		query.setParameter("a",a);
		Comment comm = null;
		comm = query.getSingleResult();
		em.remove(comm);
			
	}
	


	
	

}
