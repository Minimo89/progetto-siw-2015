package it.uniroma3.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tb_provider")
@NamedQueries({
				@NamedQuery(name = "findAllProviders", query = "SELECT p FROM Provider p"),
				@NamedQuery(name = "findProvidersProducts", query = "SELECT p FROM Provider p JOIN FETCH p.products WHERE p.id = :id")
})
public class Provider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String phoneNumber;
	
	@Column(nullable = false)
	private String vatin;
	
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST})
	private Address address;
	
	@ManyToMany
	private List<Product> products;
	
	public Provider(){
		
	}
	
	public Provider(String name, String email, String phoneNumber, String vatin, String street, String city, String country, String state, String zipcode){
		this.address = new Address(street, city, country, state, zipcode);
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.vatin = vatin;
		this.products = new LinkedList<Product>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void addProduct(Product product){
		this.products.add(product);
	}
	
	
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int hashCode(){
		return this.name.hashCode() + this.vatin.hashCode();
	}
	
	public boolean equals(Object o){
		Provider p = (Provider) o;
		return this.name.equals(p.getName()) && this.vatin.equals(p.getVatin());
	}

}
