package it.uniroma3.controller;



import java.util.List;
import java.util.Map;

import it.uniroma3.facade.CustomerFacade;
import it.uniroma3.facade.OrderFacade;
import it.uniroma3.facade.OrderLineFacade;
import it.uniroma3.facade.ProductFacade;
import it.uniroma3.model.Customer;
import it.uniroma3.model.OrderLine;
import it.uniroma3.model.Orders;
import it.uniroma3.model.Product;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

@ManagedBean
public class ProductController {
	
	@ManagedProperty(value = "#{param.id}")
	private Long id;
	private String description;
	private Integer depositQuantity;
	private String name;
	private Float price;
	private String code;
	private Product product;
	
	private List<Product> products;
	
	private Long customerId;
	private Customer customer;
	
	private Integer quantity;
	
	private Orders order;
	private List<Orders> orders;
	private OrderLine orderLine;
	
	@EJB(beanName = "pFacade")
	private ProductFacade productFacade;
	
	@EJB(beanName = "cFacade")
	private CustomerFacade customerFacade;
	
	@EJB(beanName = "oFacade")
	private OrderFacade orderFacade;
	
	@EJB(beanName = "olFacade")
	private OrderLineFacade orderLineFacade;
	
	public String createProduct(){
		this.product = this.productFacade.createProduct(this.name, this.code, this.description, this.depositQuantity, this.price);
		return "faces/productAdded.jsp";
	}
	
	public String getAllProductsLogged(){
		this.products = this.productFacade.getAllProducts();
		return "faces/productsLogged.jsp";
		
	}
	
	
	
	public String buyProduct(){
		this.customerId = getCustomerIdParameter();
		this.customer = this.customerFacade.findCustomer(this.customerId);
		this.product = this.productFacade.findProduct(this.id);
		if(this.orderFacade.getCart(this.customer) == null){
			this.orderFacade.createOrder(this.customer);
			this.order = this.orderFacade.getCart(this.customer);
			this.orderLineFacade.createOrderLine(this.product, this.quantity, this.order);
		}
		else{
			this.order = this.orderFacade.getCart(this.customer);
			this.orderLineFacade.createOrderLine(this.product, this.quantity, this.order);
		}
		return "faces/added.jsp";
	}
	
	
	
	public String getAllProducts(){
		this.products = this.productFacade.getAllProducts();
		return "faces/products.jsp";
		
	}
	
	public String findProduct(){
		this.product = this.productFacade.findProduct(id);
		return "faces/product.jsp";
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	
	
	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
	
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

	public OrderLine getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine;
	}

	public Long getCustomerIdParameter(){
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		 return Long.valueOf(params.get("customerId")).longValue();
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	

}
