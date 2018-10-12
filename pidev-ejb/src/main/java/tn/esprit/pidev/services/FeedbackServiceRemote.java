package tn.esprit.pidev.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pidev.persistence.Feedback;

@Remote
public interface FeedbackServiceRemote {
	
	public int ajouterFeedback(Feedback feedback);
	public List<Feedback> findAll();
	public List<Feedback> findAllPast();
	public void deleteFeedbackById(int feedbackId);
	public void updateFeedback(Feedback feedback);

}
