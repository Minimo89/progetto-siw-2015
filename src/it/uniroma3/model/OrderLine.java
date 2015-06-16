package it.uniroma3.model;

import javax.persistence.*;


@Entity
@Table(name = "tb_order_line")
@NamedQuery(name = "getOrdersOrderLines", query = "SELECT ol FROM OrderLine ol WHERE ol.order = :order")
public class OrderLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Integer quantity;
	
	@Column(nullable = false)
	private Float price;
	
	@ManyToOne
	private Orders order;
	
	@ManyToOne
	private Product product;
	
	public OrderLine(){
		
	}
	
	public OrderLine(Product product, Integer quantity, Orders order){
		this.product = product;
		this.price = product.getPrice();
		this.quantity = quantity;
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Float getSubTotal(){
		return new Float(this.price.doubleValue() * this.quantity.doubleValue());
	}
	
	public int hashCode(){
		return this.quantity.hashCode() + this.price.hashCode() + this.order.hashCode() + this.product.hashCode();
	}
	
	public boolean equals(Object o){
		OrderLine ol = (OrderLine) o;
		return this.quantity.equals(ol.getQuantity()) && this.price.equals(ol.getPrice()) && this.order.equals(ol.getOrder())
				&& this.product.equals(ol.getProduct());
	}

}
