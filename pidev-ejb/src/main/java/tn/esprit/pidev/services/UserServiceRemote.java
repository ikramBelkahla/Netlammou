package tn.esprit.pidev.services;

import java.util.List;

import javax.ejb.Remote;


import tn.esprit.pidev.persistence.User;;


@Remote
public interface UserServiceRemote {
	
	public User getUserByEmailAndPassword (String email, String password);
	public List<User> listUser();
	public  boolean addUser(User user);
	public boolean deleteUser(int id);
	public List<User> listVolunteer();
	public List<User> listAssociation();
	public boolean updateUser(User user);


}
