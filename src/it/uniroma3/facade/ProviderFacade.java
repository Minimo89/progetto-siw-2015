package it.uniroma3.facade;

import java.util.List;

import it.uniroma3.model.Product;
import it.uniroma3.model.Provider;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless(name = "providerFacade")
public class ProviderFacade {
	
	@PersistenceContext(unitName = "progetto-siw-2015")
	private EntityManager em;
	
	public Provider createProvider(String name, String email, String phoneNumber, String vatin, String street, String city, String country, String state, String zipcode){
		Provider provider = new Provider(name, email, phoneNumber, vatin, street, city, country, state, zipcode);
		this.em.persist(provider);
		return provider;
	}
	
	@SuppressWarnings("unchecked")
	public List<Provider> findAllProviders(){
		List<Provider> providers = this.em.createNamedQuery("findAllProviders").getResultList();
		return providers;
	}
	
	public List<Product> findProvidersProducts(Long id){
		Provider provider = (Provider) this.em.createNamedQuery("findProvidersProducts").setParameter("id", id).getSingleResult();
		if(provider == null){
			return null;
		}
		else{
			return provider.getProducts();
		}
	}
	
	public void updateProvider(Provider provider){
		this.em.merge(provider);
	}
	
	public Provider findProvider(Long id){
		return this.em.find(Provider.class, id);
	}

}
