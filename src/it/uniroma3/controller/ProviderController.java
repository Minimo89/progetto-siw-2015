package it.uniroma3.controller;



import it.uniroma3.facade.ProductFacade;
import it.uniroma3.facade.ProviderFacade;

import it.uniroma3.model.Provider;

import javax.ejb.EJB;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class ProviderController {
	
	private String name;
	private String email;
	private String phoneNumber;
	private String vatin;
	private Provider provider;
	
	private String street;
	private String city;
	private String country;
	private String state;
	private String zipcode;
	
	
	
	@EJB(beanName = "providerFacade")
	private ProviderFacade providerFacade;
	
	@EJB(beanName = "pFacade")
	private ProductFacade productFacade;
	
	public String createProvider(){
		this.provider = this.providerFacade.createProvider(name, email, phoneNumber, vatin, street, city, country, state, zipcode);
		return "faces/providerAdded.jsp";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getVatin() {
		return vatin;
	}
	public void setVatin(String vatin) {
		this.vatin = vatin;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	
	
	
	
	

}
