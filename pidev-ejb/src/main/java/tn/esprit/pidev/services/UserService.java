package tn.esprit.pidev.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.pidev.persistence.Role;
import tn.esprit.pidev.persistence.User;

@LocalBean
@Stateless
public class UserService implements UserServiceRemote {

	@PersistenceContext
	private EntityManager em;


	@Override
	public boolean addUser(User user) {

		em.persist(user);
	return true;
	//	return user.getId();
	
		
	}
	
	@Override
	public boolean deleteUser(int id) {
		User user =em.find(User.class, id);
		em.remove(user);
		return true;
	}
	@Override
	public List<User> listVolunteer() {
		
		
		TypedQuery<User> query = em.createQuery("select * from user u where u.role='volunteer'",User.class);	
		 List<User> user = query.getResultList();
		 return user;
	}
	
	@Override
	public User getUserByEmailAndPassword(String mailAdress, String password) {
		System.out.println("user:");
		User user = null;

		TypedQuery<User> query = em.createQuery("select u from User u where u.mailAdress= :mailAdress and u.passWodrd= :password " ,User.class);
				query.setParameter("mailAdress",mailAdress);
				query.setParameter("password", password);
				System.out.println("user:");

				user=query.getSingleResult();
				System.out.println("user:"+user.getId());
				return user;
	}


	@Override
	public List<User> listUser() {

		TypedQuery<User> query = em.createQuery("SELECT u FROM User u ",User.class);	
		 List<User> users = query.getResultList();
		 return users;
	}
	
	@Override
	public List<User> listAssociation() {
	
		TypedQuery<User> query = em.createQuery("select u from User u where u.role='ngos'",User.class);	
		 List<User> user = query.getResultList();
		 return user;
	}

	@Override
	public boolean updateUser(User user) {
		em.merge(user);
		return true;
	
	}

	public void insertVolunteer(String adress, String mailAdress, String passWodrd, int phoneNumber, String Description, int age, String firstName,String lastName){
	Query query = em.createNativeQuery("INSERT INTO user (DTYPE, adress, mailAdress, passWodrd, phoneNumber, Description,name, age, firstName, lastName, potential, role) VALUES ('',?, ?, ?, ?, ?, '', ?, ?, ?, 1,'volunteer')");
	query.setParameter(1,adress);
	query.setParameter(2,mailAdress);
	query.setParameter(3,passWodrd);
	query.setParameter(4,phoneNumber);
	query.setParameter(5,Description);
	query.setParameter(6,age);
	query.setParameter(7,firstName);
	query.setParameter(8,lastName);
    query.executeUpdate();

	} 
	public void insertNgo(String adress, String mailAdress, String passWodrd, int phoneNumber, String Description, String name){
		Query query = em.createNativeQuery("INSERT INTO user (DTYPE, adress, mailAdress, passWodrd, phoneNumber, Description, name, age, firstName, lastName, potential, role) VALUES ('',?, ?, ?, ?, ?, ?,0, '', '', 1, 'ngos')");
		query.setParameter(1,adress);
		query.setParameter(2,mailAdress);
		query.setParameter(3,passWodrd);
		query.setParameter(4,phoneNumber);
		query.setParameter(5,Description);
		query.setParameter(6,name);
	    query.executeUpdate();

		} 
}



	




	
	

