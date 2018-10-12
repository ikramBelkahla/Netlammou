package tn.esprit.pidev.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.pidev.persistence.Role;
import tn.esprit.pidev.persistence.User;

import tn.esprit.pidev.services.UserService;

@ManagedBean
@SessionScoped
public class LoginBean {

	private String email;
	private String password;
	private User userr;
	
	

	public User getUserr() {
		return userr;
	}

	public void setUserr(User userr) {
		this.userr = userr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@EJB
	UserService userrService;
	
	public String doLogin()
	{
		String navigateTo="null";
		userr=null;
		userr = userrService.getUserByEmailAndPassword(email,password);
		
		if(userr != null )
		{
			if(userr.getRole() == Role.ngos)
			navigateTo = "/indexNgo?faces-redirect=true";
			else if(userr.getRole()==Role.volunteer )
			navigateTo = "/volunteer?faces-redirect=true";
		
			else
			return navigateTo;
			
			
		}
		return navigateTo;
	}

	public String doLogout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession(); 
		return "/login1?faces-redirect=true";
}
}
