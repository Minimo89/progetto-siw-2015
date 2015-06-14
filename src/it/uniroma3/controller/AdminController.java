package it.uniroma3.controller;

import it.uniroma3.facade.AdminFacade;
import it.uniroma3.model.Admin;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AdminController {
	
	private Long id;
	private String username;
	private String password;
	private Admin admin;
	
	
	@EJB(beanName = "aFacade")
	private AdminFacade adminFacade;
	
	public String createAdmin(){
		this.admin = this.adminFacade.createAdmin(this.username, this.password);
		this.username = null;
		this.password = null;
		this.admin = null;
		return "faces/registrationComplete.jsp";
	}
	
	public String logIn(){
		Admin admin = this.adminFacade.credentialCheck(this.username, this.password);
		if(admin != null){
			this.id = admin.getId();
			this.admin = admin;
			return "faces/adminIndex.jsp";
		}
		else
			return "faces/index.jsp";
	}
	
	public String logOut(){
		this.admin = null;
		this.id = null;
		this.password = null;
		this.username = null;
		return "faces/index.jsp";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	

}
