package tn.esprit.pidev.presentation.mbeans;


import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Part;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.primefaces.event.FileUploadEvent;

import tn.esprit.pidev.persistence.NGOs;
import tn.esprit.pidev.persistence.Product;
import tn.esprit.pidev.services.ProduitService;
import tn.esprit.pidev.services.ProduitServiceRemote;


@ManagedBean
@SessionScoped
@LocalBean
public class ProductBean  implements Serializable {

	@EJB
	ProduitService ps;
	
	private int id;
	
	private String name;
	private int quantity;
	private Double price;
	private String description;
	private String picture;
	private String categorie;
	private NGOs ngo;
	private NGOs connected;
	private int ProdModid;
	
	//Dés que le bean soit construit cette méthode s'executera directement
	@PostConstruct
	public void initBean() {
		this.connected = ps.getConnectedVolenteer();
	}
	
	public String upload() throws IOException{
		String nav = "";
		file.write("E:\\DSI\\"+getFileName(file));
		//
		ps.addProduit(new Product(name,
				quantity,
				price,
				description,
				"E:\\DSI\\"+getFileName(file),
				categorie,
				connected)
				);
		   viderChamp();
		   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info","Produit Ajouter."));
		   nav="/pages/afficherProduit?faces-redirect=true";
		   
		   
		   return nav;
	}
	
	


	private static String getFileName(Part part) {
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;
	}
	
	
	public void viderChamp(){
		setName("");
		setDescription("");
		setPrice(0.0);
		setQuantity(0);
		
	}
	
	
	public List<Product> getProducts(){
		products= ps.afficher();
		return products;
	}

	public void delete(int prodID,String path){
		File f = new File(path);
		f.delete();
		  // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "document supprimer."));
		ps.delete(prodID);
		
	}
	
	
	public void addMessage(String message) {
	    FacesContext context = FacesContext.getCurrentInstance();
	    
	    context.addMessage(null, new FacesMessage("Successful",  "Your message: " + message) );
	    context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
	}
	
	public void Update()throws IOException{
		file.write("E:\\DSI\\"+getFileName(file));
		ps.ModifierProduit(new Product(name, quantity, price, description,"E:\\DSI\\"+getFileName(file),connected,ProdModid));
		viderChamp();
	}
	
	 public void modifier(Product prod) {
		// TODO Auto-generated method stub
		 this.setName(prod.getName());
		 this.setDescription(prod.getDescription());
		 this.setQuantity(prod.getQuantity());
		 this.setPrice(prod.getPrice());
		 this.setPicture(prod.getPicture());
		 this.setProdModid(prod.getId());

	}
	
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}

public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	/*
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}*/
	public NGOs getNgo() {
		return ngo;
	}
	public void setNgo(NGOs ngo) {
		this.ngo = ngo;
	}
	public NGOs getConnected() {
		return connected;
	}
	public void setConnected(NGOs connected) {
		this.connected = connected;
	}
	public int getProdModid() {
		return ProdModid;
	}

	public void setProdModid(int prodModid) {
		ProdModid = prodModid;
	}


	private List<Product> products;


	public List<Product> getProduit() {
		return products;
	}

	public void setProduit(List<Product> products) {
		this.products = products;
	}
	
	
	private Part	 file;

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}
	
	
	
	public Response getEventsByNameOrDetails(String name) {
		List<Product> u = ps.getByName(name);
		if (u != null)
			return Response.status(Status.OK).entity(u).build();
		return Response.status(Status.NOT_FOUND).build();
	}
	/*public String Recherche (Product prod){
		int a = prod.getId();
		//id= ps.findProductById(a);
	}
	/*
	public String Details(Task tas) {

		int a = tas.getId();

		idtasktoupdate = taskservice.findtaskbyid(a);

		t = tas;
		nomtoupdate = t.getNomTache();

		return "update.jsf?faces-redirect=true";

	}
*/
	public List<Product> rechercherproductparname(String name){
		
	List<Product>p=	ps.getByName(name);
		
		return p;
	}
	
	public  String Detail(String s){
	
		
		System.out.println(s);
       
	return "";
	

}
	 
	

}
