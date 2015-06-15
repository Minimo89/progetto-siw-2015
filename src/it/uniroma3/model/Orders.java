package it.uniroma3.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "tb_orders")
@NamedQueries({
				@NamedQuery(name = "getCart", query = "SELECT o FROM Orders o WHERE o.closeDate is null and o.customer = :customer"),
				@NamedQuery(name = "getCustomersOrders", query = "SELECT o FROM Orders o WHERE o.customer = :customer")
})
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date closeDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date evasionDate;
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST})
	private List<OrderLine> orderLines;
	
	public Orders(){
		this.orderLines = new LinkedList<OrderLine>();
		this.creationDate = new Date();
	}
	
	public Orders(Customer customer){
		this();
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public Date getEvasionDate() {
		return evasionDate;
	}

	public void setEvasionDate(Date evasionDate) {
		this.evasionDate = evasionDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	public void addOrderLine(OrderLine orderLine){
		this.orderLines.add(orderLine);
	}
	
	public int hashCode(){
		return this.creationDate.hashCode() + this.customer.hashCode();
	}
	
	public boolean equals(Object o){
		Orders order = (Orders) o;
		return this.creationDate.equals(order.getCreationDate()) && this.customer.equals(order.getCustomer());
	}

}
