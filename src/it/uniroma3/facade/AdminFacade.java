package it.uniroma3.facade;

import it.uniroma3.model.Admin;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "aFacade")
public class AdminFacade {
	
	@PersistenceContext(unitName = "progetto-siw-2015")
	private EntityManager em;
	
	public Admin createAdmin(String username, String password){
		Admin admin = new Admin(username, password);
		this.em.persist(admin);
		return admin;
	}

}
