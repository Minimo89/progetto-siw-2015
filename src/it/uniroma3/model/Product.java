package it.uniroma3.model;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "tb_product")
@NamedQuery(name = "getAllProducts", query = "SELECT p FROM Product p")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 2000)
	private String description;
	
	@Column(nullable = false)
	private Integer depositQuantity;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Float price;
	
	@Column(nullable = false)
	private String code;
	
	@ManyToMany(mappedBy = "products")
	private List<Provider> providers;
	
	public Product(){
		
	}
	
	public Product(String name, String code, String description, Integer depositQuantity, Float price){
		this.name = name;
		this.code = code;
		this.depositQuantity = depositQuantity;
		this.description = description;
		this.price = price;
		this.providers = new LinkedList<Provider>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDepositQuantity() {
		return depositQuantity;
	}

	public void setDepositQuantity(Integer depositQuantity) {
		this.depositQuantity = depositQuantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}
	
	public int hashCode(){
		return this.name.hashCode() + this.code.hashCode();
	}
	
	public boolean equals(Object o ){
		Product p = (Product) o;
		return this.name.equals(p.getName()) && this.code.equals(p.getCode());
	}

}
