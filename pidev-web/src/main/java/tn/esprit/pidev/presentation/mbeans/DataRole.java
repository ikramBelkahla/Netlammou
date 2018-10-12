package tn.esprit.pidev.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.pidev.persistence.Role;

@ManagedBean
@ApplicationScoped
public class DataRole {
	public Role [] getRoles(){
		
		return Role.values();
	}

}
