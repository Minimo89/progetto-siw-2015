package it.uniroma3.facade;

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

}
