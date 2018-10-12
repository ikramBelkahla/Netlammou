package tn.esprit.pidev.presentation.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.pidev.persistence.Comment;
import tn.esprit.pidev.persistence.Topic;
import tn.esprit.pidev.services.ComService;

@ManagedBean
@SessionScoped
public class ComBean {

	
	private Topic topic;
	
	public Topic getTopic() {
		return topic;
	}


	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String commenter(Topic topicc)
	{
		String nav="null";
		topic=topicc;
		nav= "/no-sidebarr";
		return nav;
	}
	
/*	public String voter(Topic topicc)
	{
		String nav="null";
		topic=topicc;
		nav= "/no-sidebarrr";
		return nav;
	}
*/	
	
}
