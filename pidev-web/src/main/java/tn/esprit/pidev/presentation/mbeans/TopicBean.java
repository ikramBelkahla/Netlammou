package tn.esprit.pidev.presentation.mbeans;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.esprit.pidev.persistence.Comment;
import tn.esprit.pidev.persistence.Topic;
import tn.esprit.pidev.persistence.User;
import tn.esprit.pidev.persistence.Volenteer;
import tn.esprit.pidev.services.ComService;
import tn.esprit.pidev.services.TopicService;
import tn.esprit.pidev.services.UserService;


@ManagedBean
@ViewScoped
public class TopicBean {
	
	private String object;
	private String objet;
    @ManagedProperty(value="#{loginBean}") // this references the @ManagedBean named user
	private LoginBean loginBean;
    @ManagedProperty(value="#{comBean}") // this references the @ManagedBean named user
   	private ComBean comBean;
	

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}


	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	
	
	
	//private String objet;
	

	public ComBean getComBean() {
		return comBean;
	}

	public void setComBean(ComBean comBean) {
		this.comBean = comBean;
	}

	@EJB
	TopicService topicService;
	
	@EJB
	ComService comService;
	
	@EJB
	UserService userrService;
  	
		public List<Topic> getTopics()
		{
			
			return topicService.findAll();
			
		}
		
		

		public List<Comment> getComs()
		{
			
			return comService.getCommentByTopic(comBean.getTopic());
			
		}
			
		
		public void addTopic()
		
		
		{	

			
			String navigateTo="null";
			topicService.ajouterTopic(new Topic(objet));
			navigateTo = "/no-sidebar.jsf";
			
		}
		
		
		
		
		
	/*	public String doLogin()
		{
			String navigateTo="null";
			userr = userrService.getUserrByEmailAndPassword(email,password);
			if(userr != null )
			{
				navigateTo = "/no-sidebar?faces-redirect=true";
				
		
			}
			else
			{
				FacesContext.getCurrentInstance().addMessage("form:btn",new FacesMessage(" bad credentials"));
				
				
			}
			return navigateTo;
		}
		*/
		
		
        public void addCom()
		
		
		{	
        	
        	User current = loginBean.getUserr();
        	
			String navigateTo="null";
//			comService.ajouterCom(new Comment(object,comBean.getTopic(),current));
			navigateTo = "/no-sidebarr";
			
		}
        
        public String supprimer(Comment com)
    	{
    		comService.deleteCom(com);
    		return "/no-sidebarr";
    		
    	}
		
		
				
}

	

