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
	
	public Customer credentialCheck(String username, String password){
		Customer customer;
		try{
			customer = (Customer) this.em.createNamedQuery("getCustomerByUsername").setParameter("username", username).getSingleResult();
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
		if(customer.getPassword().equals(password))
			return customer;
		else{
			return null;
		}
	}

}
