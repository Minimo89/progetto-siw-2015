package it.uniroma3.facade;

import it.uniroma3.model.Address;
import it.uniroma3.model.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "addressFacade")
public class AddressFacade {
	
	@PersistenceContext(unitName = "progetto-siw-2015")
	private EntityManager em;
	
	public Address getCustomersAddress(Customer customer){
		Address address = (Address) this.em.createNamedQuery("findCustomersAddress").setParameter("customer", customer).getSingleResult();
		return address;
	}

}
