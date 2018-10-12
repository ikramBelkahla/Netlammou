package tn.esprit.pidev.persistence;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class BasketPk implements Serializable{

	private int idVolenteer;
	private int idProduct;
	

	public int getIdVolenteer() {
		return idVolenteer;
	}
	public void setIdVolenteer(int idVolenteer) {
		this.idVolenteer = idVolenteer;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProduct;
		result = prime * result + idVolenteer;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasketPk other = (BasketPk) obj;
		if (idProduct != other.idProduct)
			return false;
		if (idVolenteer != other.idVolenteer)
			return false;
		return true;
	}

	
	
}
