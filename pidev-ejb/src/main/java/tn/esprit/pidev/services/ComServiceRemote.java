package tn.esprit.pidev.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pidev.persistence.Comment;
import tn.esprit.pidev.persistence.Topic;

@Remote
public interface ComServiceRemote {

	List<Comment> getCommentByTopic(Topic topic);

	int ajouterCom(Comment e);

	void deleteCom(Comment com);

	List<Comment> getCommentByTopicc(int id);

	

}
