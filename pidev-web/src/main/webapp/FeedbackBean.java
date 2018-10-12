package tn.esprit.pidev.presentation.mbeans;


import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import tn.esprit.pidev.persistence.Feedback;

import tn.esprit.pidev.services.FeedbackService;

@ManagedBean
@ViewScoped
public class FeedbackBean {
	
	
	 private boolean value1;   
	    private boolean value2;
	 
	    public boolean isValue1() {
	        return value1;
	    }
	 
	    public void setValue1(boolean value1) {
	        this.value1 = value1;
	    }
	 
	    public boolean isValue2() {
	        return value2;
	    }
	 
	    public void setValue2(boolean value2) {
	        this.value2 = value2;
	    }
	
	
	
	
	
	private int id;
	private String description;
	private Date date;
	private boolean reported;
	
	public int getFeedbackIdToBeUpdate() {
		return feedbackIdToBeUpdate;
	}
	public void setFeedbackIdToBeUpdate(int feedbackIdToBeUpdate) {
		this.feedbackIdToBeUpdate = feedbackIdToBeUpdate;
	}
	public Feedback getFeedback() {
		return feedback;
	}
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	private int feedbackIdToBeUpdate;
	private Feedback feedback;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isReported() {
		return reported;
	}
	public void setReported(boolean reported) {
		this.reported = reported;
	}
	
	@EJB
	FeedbackService feedbackService;
	
	public FeedbackService getFeedbackService() {
		return feedbackService;
	}
	public void setFeedbackService(FeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}
	
	
//	@PostConstruct
//	public void init() {
//		
//		feedbacks = new ArrayList<>();
//		feedbacks = feedbackService.findAll();
//	}
	
	public void addFeedback()
	{
		Date d = new Date();
		feedbackService.ajouterFeedback(new Feedback(description, d, reported));
		System.out.println("done");
	}
	

	private List<Feedback> feedbacks;
	
	public List<Feedback> getFeedbacks() {
		feedbacks = feedbackService.findAll();
		return feedbacks;
	}
	
	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
	public Feedback getA() {
		return a;
	}
	public void setA(Feedback a) {
		this.a = a;
	}
	private Feedback a;
	
	
	
	public void supprimer(int feedbackID)
	{
		feedbackService.deleteFeedbackById(feedbackID);
	}
	
	public void valider(int id){
		feedbackService.validerFeedback(id);
	}
	
	public void modifier(Feedback feedback)
	{
		this.setReported(feedback.isReported());
		this.setDescription(feedback.getDescription());
		
		//this.setDate(action.getDate());
		this.setFeedbackIdToBeUpdate(feedback.getId());
		
	}
		
	
		public void mettreAjourFeedback()
		{
			feedbackService.updateFeedback(new Feedback(description, date, reported ));
		}
		
	
	
		public String rediretion(){
			
			return "/pages/ngos/crudAction?faces-redirect=true";
		}
	
	
	
	
	
	
	
	
	
}
