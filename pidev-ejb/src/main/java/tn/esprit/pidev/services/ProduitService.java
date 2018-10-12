package tn.esprit.pidev.services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


import tn.esprit.pidev.persistence.NGOs;
import tn.esprit.pidev.persistence.Product;

@Stateless
@LocalBean
public class ProduitService implements ProduitServiceRemote  {
	@PersistenceContext
	private EntityManager em;
	public static NGOs connected;
	
	private List<Product> product;
	
	@Override
	public void addProduit(Product product) {
		em.persist(product);	
		sendEmail("haithemabderrahmen.belhadj@esprit.tn");
	}
	
	public NGOs getConnectedVolenteer() {
		return connected = em.find(NGOs.class, 1);
	}

	@Override
	public void delete(int prodID) {
		
		em.remove(em.find(Product.class, prodID));
		
	}
	
	

	@Override
	public List<Product> afficher() {
		 TypedQuery<Product> querry=em.createQuery("Select p From Product p",Product.class);
		List<Product> results = querry.getResultList();
		return results;
		
		
		
	}

	

	@Override
	public List<Product> getProductRecherche() {

		return null;
	}

	@Override
	public List<Product> findAll() {
		
		Query jQuery = em.createQuery("Select  p From Product p");
		 
		return jQuery.getResultList();
		
	}

	@Override
	public void ModifierProduit(Product prod) {
		// TODO Auto-generated method stub
		/*Query query = em.createQuery("Update Product p set name=? , description=? , price=?,quantity=? where p.id=1 ");
		query.setParameter("name", prod.getName());
		query.setParameter("name", prod.getDescription());
		query.setParameter("name", prod.getPrice());
		query.setParameter("name", prod.getQuantity());
		
		int modi = query.executeUpdate();
		if (modi==1){
			System.out.println("succcccccc");
		}
		else 
		{
			System.out.println("echec");
		}
		}*/
		em.merge(prod);
	}

	@Override
	public List<Product> getByName(String name) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select p from Product p where p.name LIKE:n",Product.class);
		q.setParameter("n", "%" + name + "%");
		
		return q.getResultList();
		
		
	}
	private boolean sendEmail(String email) {
		String host = "smtp.gmail.com";
		String user = "haithemabderrahmenbelhadj@gmail.com";
		String pass = "Hajer2017@@@";
		String to = email;
		String from = "haithemabderrahmenbelhadj@gmail.com";
		String subject = "New task";
		String url ="";
		String messageText = "A new task has been assigned to you, check it out ! <br/> ";
		boolean sessionDebug = false;
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.required", "true");

		// java.security.Security.addProvider(new
		// com.sun.net.ssl.internal.ssl.Provider());
		Session mailSession = Session.getDefaultInstance(props, null);
		mailSession.setDebug(sessionDebug);
		Message msg = new MimeMessage(mailSession);
		try {
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			// msg.setText(messageText);
			msg.setContent(messageText, "text/html; charset=utf-8");
			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, user, pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Product findProductById(int id) {
		return em.find(Product.class, id);
		
	}
			
	
	
}
