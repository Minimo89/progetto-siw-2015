package it.uniroma3.controller;

import it.uniroma3.facade.ProductFacade;
import it.uniroma3.model.Product;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ProductController {
	
	private String description;
	private Integer depositQuantity;
	private String name;
	private Float price;
	private String code;
	private Product product;
	
	@EJB(beanName = "pFacade")
	private ProductFacade productFacade;
	
	public String createProduct(){
		this.product = this.productFacade.createProduct(this.name, this.code, this.description, this.depositQuantity, this.price);
		return "faces/productAdded.jsp";
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
