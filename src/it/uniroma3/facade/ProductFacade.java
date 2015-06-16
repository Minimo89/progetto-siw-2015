package it.uniroma3.facade;

import java.util.LinkedList;
import java.util.List;

import it.uniroma3.model.Product;
import it.uniroma3.model.Provider;

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
	
	public Product findProduct(String code){
		Product product = (Product) this.em.createNamedQuery("findProductByCode").setParameter("code", code).getSingleResult();
		return product;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts(){
		List<Product> products = new LinkedList<Product>();
		products = this.em.createNamedQuery("getAllProducts").getResultList();
		return products;
	}
	
	public List<Provider> findProductsProviders(Long id){
		Product product = (Product) this.em.createNamedQuery("getProductsProvider").setParameter("id", id).getSingleResult();
		if(product == null){
			return null;
		}
		else{
		return product.getProviders();
		}
	}
	
	public Product findProduct(Long id){
		Product product = this.em.find(Product.class, id);
		return product;
	}
	
	public void updateProduct(Product product){
		this.em.merge(product);
	}
	
	

}
