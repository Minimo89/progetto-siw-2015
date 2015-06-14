package it.uniroma3.facade;


import it.uniroma3.model.Customer;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "cFacade")
public class CustomerFacade {
	
	@PersistenceContext(unitName = "progetto-siw-2015")
	private EntityManager em;
	
	public Customer createCustomer(String firstName, String lastName, String username, String password, Date dateOfBirth, String phoneNumber, String street, String city, String country, String state, String zipcode){
		Customer customer = new Customer(firstName, lastName, username, password, dateOfBirth, phoneNumber, street, city, country, state, zipcode);
		this.em.persist(customer);
		return customer;
	}

}
