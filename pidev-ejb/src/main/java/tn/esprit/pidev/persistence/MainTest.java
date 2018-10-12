package tn.esprit.pidev.persistence;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



public class MainTest {

	 public static void main(String [] args) throws NamingException{
		 
	    String jndiNameForLocalisation="pidev-ear/pidev-ejb/LocalisationService!tn.esprit.pidev.services.LocalisationServiceRemote";
		Context context = new InitialContext();
//		LocalisationServiceRemote proxy = (LocalisationServiceRemote) context.lookup(jndiNameForLocalisation);
//
//		Localisation l = new Localisation(1.2f,2.4f,"rouge");
//		proxy.createLocalisation(l);
	 }
}
