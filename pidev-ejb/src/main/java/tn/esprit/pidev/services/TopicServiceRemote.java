package tn.esprit.pidev.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pidev.persistence.Topic;

@Remote
public interface TopicServiceRemote {

	List<Topic> findAll();

	int ajouterTopic(Topic e);

	String a();

	void deleteTopic(Topic e);

	void updateTopic(Topic topic);

	void deleteeTopic(int id);

	Topic getTopicById(int id);

	
	
	
}
