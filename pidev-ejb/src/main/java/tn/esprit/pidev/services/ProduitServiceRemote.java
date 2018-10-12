package tn.esprit.pidev.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pidev.persistence.NGOs;
import tn.esprit.pidev.persistence.Product;

@Remote
public interface ProduitServiceRemote {

	public void addProduit(Product product);
	void delete(int prodID);
	List<Product> findAll();
	List<Product> afficher();
	List<Product> getProductRecherche();
	public void ModifierProduit(Product prod);
	List<Product> getByName(String name);
	public Product findProductById(int id);
	public NGOs getConnectedVolenteer();
}
