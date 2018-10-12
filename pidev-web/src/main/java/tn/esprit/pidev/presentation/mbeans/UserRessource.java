package tn.esprit.pidev.presentation.mbeans;



import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.ws.rs.core.Response.Status;

import tn.esprit.pidev.persistence.User;
import tn.esprit.pidev.services.UserServiceRemote;




@Path("/userss")
@RequestScoped
public class UserRessource {
	
	@EJB
	private UserServiceRemote usermetier;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{username}/{pwd}")
	public Response Login(User user ,@PathParam("username") String email, @PathParam("pwd")String password)
	{	
		return Response.status(Status.OK)
				.entity(usermetier.
				 getUserByEmailAndPassword(email, password)).build();
				
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
     public Response listAssociation(){
	
	
	return Response.ok(usermetier.listUser()).build();
}	
}
	

