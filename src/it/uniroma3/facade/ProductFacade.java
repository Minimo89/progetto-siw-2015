package it.uniroma3.facade;

import it.uniroma3.model.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "pFacade")
public class ProductFacade {
	
	@PersistenceContext(unitName = "progetto-siw-2015")
	private EntityManager em;
	
	public Product createProduct(String name, String code, String description, Integer depositQuantity, Float price){
		Product product = new Product(name, code, description, depositQuantity, price);
		this.em.persist(product);
		return product;
	}

}
