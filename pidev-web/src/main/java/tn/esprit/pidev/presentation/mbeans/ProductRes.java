package tn.esprit.pidev.presentation.mbeans;


import java.util.Iterator;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.pidev.persistence.Product;
import tn.esprit.pidev.services.ProductLocal;

@Path("products")
@RequestScoped
public class ProductRes {
@EJB
ProductLocal PL;

@GET
@Produces(MediaType.APPLICATION_JSON)
public Response listProduct(){
	return Response.ok(PL.findAll()).build();
}


@POST
@Consumes(MediaType.APPLICATION_JSON)
public Response addProduct(Product prod){
	boolean p = PL.addProduit(prod);
	if(p){
		return Response.status(Status.CREATED).entity("ajoutavec").build();
	}
	
	return Response.status(Status.NOT_ACCEPTABLE).entity("Prod non ajoutée").build();	
}
@PUT 
@Path("/{id}")
@Consumes(MediaType.APPLICATION_JSON)
public Response ModifierProd(Product prod,@PathParam("id") Integer id){
	PL.ModifierProduit(prod);
	return Response.status(Status.ACCEPTED).entity("Prod non ajoutée").build();
	
}
@DELETE 
@Produces(MediaType.TEXT_PLAIN)
@Path("{id}")
public Response supprimerEmploye(@PathParam("id") int id) {
	
	if(PL.delete(id)){
		return Response.status(Status.OK).entity("Prod deleted").build();
	}
	return Response.status(Status.NOT_ACCEPTABLE).entity("Prod non supp").build();	
	
	
}






}
