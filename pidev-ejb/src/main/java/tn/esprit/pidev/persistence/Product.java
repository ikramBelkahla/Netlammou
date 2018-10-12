package tn.esprit.pidev.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int quantity;
	private Double price;
	private String description;
	private String picture;
	private String Categorie;
	
	public String getCategorie() {
		return Categorie;
	}
	public void setCategorie(String Categorie) {
		this.Categorie = Categorie;
	}
	
	/** Relations **/
	@ManyToOne
	private NGOs ngo;
	
	@OneToMany(mappedBy="product")
	private List<Basket> baskets;
	
	/***************/
	
	
	public Product(String name, int quantity, Double price, String description, String picture, String Categorie) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.picture = picture;
		this.Categorie =Categorie;
	}
	public Product(String name, int quantity, Double price, String description, String picture,int id) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.picture = picture;
	}
	public Product(String name, int quantity, Double price, String description, String picture, String Categorie,
			NGOs ngo) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.picture = picture;
		this.Categorie = Categorie;
		this.ngo = ngo;
	}
	public Product(String name, int quantity, Double price, String description,String picture,NGOs ngo,int id) {
		
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.picture = picture;

		this.ngo = ngo;
		this.id=id;
	}
	public Product() {
		super();
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
	

}
