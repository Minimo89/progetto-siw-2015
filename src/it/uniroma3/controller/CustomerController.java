package it.uniroma3.controller;

import it.uniroma3.facade.CustomerFacade;
import it.uniroma3.model.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class CustomerController {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String phoneNumber;
	private String dateOfBirth;
	private Customer customer;
	
	private String city;
	private String street;
	private String country;
	private String state;
	private String zipcode;
	
	@EJB(beanName = "cFacade")
	private CustomerFacade customerFacade;
	
	
	public String createCustomer() throws ParseException{
		Date date = dateConverter(this.dateOfBirth);
		if(date == null){
			this.firstName = null;
			this.lastName = null;
			this.username = null;
			this.password = null;
			this.phoneNumber = null;
			this.dateOfBirth = null;
			this.city = null;
			this.country = null;
			this.state = null;
			this.street = null;
			this.zipcode = null;
			return "faces/index.jsp";
		}
		else{
			this.customer = this.customerFacade.createCustomer(this.firstName, this.lastName, this.username, this.password, date, this.phoneNumber, this.street, this.city, this.country, this.state, this.zipcode);
			this.firstName = null;
			this.lastName = null;
			this.username = null;
			this.password = null;
			this.phoneNumber = null;
			this.dateOfBirth = null;
			this.city = null;
			this.country = null;
			this.state = null;
			this.street = null;
			this.zipcode = null;
			return "faces/registrationComplete.jsp";
		}
	}
	
	public Date dateConverter(String date) throws ParseException{
		Date dateOfBirth = null;
		try{
			SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
			dateOfBirth = formatter.parse(date);
			return dateOfBirth;
		} catch (ParseException e){
			e.printStackTrace();
		}
		return dateOfBirth;
	}
	
	public String logIn(){
		Customer customer = this.customerFacade.credentialCheck(this.username, this.password);
		//System.out.println(customer.getFirstName());
		if(customer != null){
			this.customer = customer;
			this.id = customer.getId();
			this.firstName = this.customer.getFirstName();
			this.lastName = this.customer.getLastName();
			this.username = this.customer.getUsername();
			this.password = this.customer.getPassword();
			this.phoneNumber = this.customer.getPhoneNumber();
			return "faces/customerIndex.jsp";
		}
		else
			return "faces/index.jsp";
	}
	
	public String logOut(){
		this.customer = null;
		this.id = null;
		this.firstName = null;
		this.lastName = null;
		this.username = null;
		this.password = null;
		this.phoneNumber = null;
		return "faces/index.jsp";
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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

	
	
	

}
