package tn.esprit.pidev.persistence;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Basket implements Serializable{

	@EmbeddedId
	private BasketPk basketPk;
	private double totalPrice;
	private int quantity;
	private boolean validCommande;
	
	/** Relations **/
	@ManyToOne
	@JoinColumn(name="idProduct",
	referencedColumnName="id",insertable=false,updatable=false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="idVolenteer",
	referencedColumnName="id",insertable=false,updatable=false)
	private Volenteer volenteer;
	/**************/
	
	
	public BasketPk getBasketPk() {
		return basketPk;
	}
	public void setBasketPk(BasketPk basketPk) {
		this.basketPk = basketPk;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isValidCommande() {
		return validCommande;
	}
	public void setValidCommande(boolean validCommande) {
		this.validCommande = validCommande;
	}
	
}
