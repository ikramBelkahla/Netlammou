package tn.esprit.pidev.presentation.mbeans;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import org.primefaces.context.RequestContext;

import tn.esprit.pidev.persistence.Role;
import tn.esprit.pidev.persistence.User;
import tn.esprit.pidev.services.UserService;


@ManagedBean
@SessionScoped
public class UserBean  {

	private String lastName;
	private String firstName;
	private Date birthdate;
	private String adress;
	private String mailAdress;
	private int phoneNumber;
	private String Password;
	private boolean potential;
	private String nameAssociation;
	private String description;
	private Role role;
	private User selectuser;
	
	private Part file;
	private int userTobeUpdated;

	
	@EJB
	UserService userservice;
	private User userLoggedIN;
	private User userChoosen;
    private User user;
    private boolean loggedIN=false;
	List<User> user2;
	
	List<User> users;


	public Part getFile() {
		return file;
	}
	public void setFile(Part file) {
		this.file = file;
	}

	private boolean isVesitor = false;

	
	public List<User> getUser2() {
		return user2;
	}
	public void setUser2(List<User> user2) {
		this.user2 = user2;
	}
 
  
    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
    public boolean addNgo() throws IOException {
//    	System.out.println("aaaaaa"+lastName);
//    	file.write("C:\\wamp\\www\\Netlamou\\"+getFilename(file));
//    		  userservice.addUser(new User ("C:/wamp/www/Netlamou/"+getFilename(file),lastName,firstName,birthdate,adress,mailAdress,phoneNumber,Password,Role.volunteer));
    	
    	userservice.insertNgo(adress, mailAdress, Password, phoneNumber, description, nameAssociation);
    	return true;
    	}
    public boolean addVolunteer() throws IOException {
//	System.out.println("aaaaaa"+lastName);
//	file.write("C:\\wamp\\www\\Netlamou\\"+getFilename(file));
//		  userservice.addUser(new User ("C:/wamp/www/Netlamou/"+getFilename(file),lastName,firstName,birthdate,adress,mailAdress,phoneNumber,Password,Role.volunteer));
	userservice.insertVolunteer(adress, mailAdress, Password, phoneNumber, description,
			 11 , firstName,lastName);

	return true;
	}
//kent blch password w mail
//public boolean addAssociation(){
//	userservice.addUser(new User(nameAssociation,description,mailAdress,phoneNumber,Password,Role.ngos));
//	return true;
//}
public List<User> getVolunteer(){
	users= userservice.listVolunteer();
	return users;
}
public List<User> getAssociation(){
	users= userservice.listAssociation();
	return users;
}





public List<User> getUsers(){

	   users = userservice.listUser();
	   return users;
}

//
//
//public void updateUser(User user){
//	
//
//	
//		this.setFirstName(user.getFirstName());
//		this.setLastName(user.getLastName());
//		this.setAdress(user.getAdress());
//this.setMailAdress(user.getMailAdress());
//		this.setPhoneNumber(user.getPhoneNumber());
//		this.setPassword(user.getPassword());
//		this.setRole(user.getRole());
//		this.setUserTobeUpdated(user.getId());
//
//}
//
//public void metterajouruser(){
//	
//	
//	userservice.updateUser(new User( lastName,  firstName,  adress,  mailAdress,  role,  userTobeUpdated));
//}

	public Integer getUserTobeUpdated() {
	return userTobeUpdated;
}
	
	
	
	
	
public void setUserTobeUpdated(Integer userTobeUpdated) {
	this.userTobeUpdated = userTobeUpdated;
}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getMailAdress() {
		return mailAdress;
	}

	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}


	public boolean isPotential() {
		return potential;
	}

	public void setPotential(boolean potential) {
		this.potential = potential;
	}

	public String getNameAssociation() {
		return nameAssociation;
	}

	public void setNameAssociation(String nameAssociation) {
		this.nameAssociation = nameAssociation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public User getUserChoosen() {
		return userChoosen;
	}
	public void setUserChoosen(User userChoosen) {
		this.userChoosen = userChoosen;
	}
	

	public User getUserLoggedIN() {
		return userLoggedIN;
	}
	public void setUserLoggedIN(User userLoggedIN) {
		this.userLoggedIN = userLoggedIN;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isLoggedIN() {
		return loggedIN;
	}
	public void setLoggedIN(boolean loggedIN) {
		this.loggedIN = loggedIN;
	}

	public boolean isVesitor() {
		return isVesitor;
	}
	public void setVesitor(boolean isVesitor) {
		this.isVesitor = isVesitor;
	}
	
	

	public String viewMyOwnPage() {
		isVesitor= false;
		//userProfile = userLoggedIN;
		String navTo = "/pages/users/Profile?faces-redirect=true";
		return navTo;
	}
	public void delete (int id){
		userservice.deleteUser(id);
	}

	

	public void Open() {
		
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("showMyPage()");
	}
	public User getSelectuser() {
		return selectuser;
	}
	public void setSelectuser(User selectuser) {
		this.selectuser = selectuser;
	}	
	
	public void updauser(User user)
	{
		userservice.updateUser(user);
	}
	public void confirmDelete() {
        addMessage("Deleting success", "Your comment has been successfully deleted.");
    }
	public void confirmAjout() {
        addMessage("Welcome", "Welcome to Netlammou.");
    }
	public void addMessage(String summary, String detail) {
        FacesMessage messageDelete = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, messageDelete);
   
	}
	
}

