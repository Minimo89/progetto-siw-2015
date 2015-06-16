package it.uniroma3.controller;

import java.util.Date;
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
public class OrderController {
	
	@ManagedProperty(value = "#{param.id}")
	private Long id;
	private Customer customer;
	private Long customerId;
	private Orders order;
	private Float total;
	private List<OrderLine> orderLines;
	private List<Orders> orders;
	
	
	@EJB(beanName = "cFacade")
	private CustomerFacade customerFacade;
	
	@EJB(beanName = "oFacade")
	private OrderFacade orderFacade;
	
	@EJB(beanName = "olFacade")
	private OrderLineFacade orderLineFacade;
	
	@EJB(beanName = "pFacade")
	private ProductFacade productFacade;
	
	public String validateOrder(){
		this.customerId = getCustomerIdParameter();
		this.customer = this.customerFacade.findCustomer(this.customerId);
		this.order = this.orderFacade.getCart(this.customer);
		this.orderLines = this.orderLineFacade.getOrdersOrderLines(this.order);
		this.order.setOrderLines(this.orderLines);
		this.order.setCloseDate(new Date());
		this.orderFacade.updateOrder(this.order);
		return "faces/confirmedOrder.jsp";
	}
	
	public String getCustomersOrders(){
		this.customerId = getCustomerIdParameter();
		this.customer = this.customerFacade.findCustomer(customerId);
		this.orders = this.orderFacade.getCustomersOrders(this.customer);
		return "faces/customersOrders.jsp";
		
	}
	
	public String findOrder(){
		this.order = this.orderFacade.findOrder(id);
		this.orderLines = this.orderLineFacade.getOrdersOrderLines(this.order);
		return "faces/ordersDetails.jsp";
	}
	
	public String getCurrentOrder(){
		this.customerId = getCustomerIdParameter();
		this.customer = this.customerFacade.findCustomer(this.customerId);
		this.order = this.orderFacade.getCart(this.customer);
		this.orderLines = this.orderLineFacade.getOrdersOrderLines(this.order);
		this.total = getTotal(this.orderLines);
		return "faces/cart.jsp";
	}
	
	public Long getCustomerIdParameter(){
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		 return Long.valueOf(params.get("customerId")).longValue();
	}
	
	public String getAllOrders(){
		this.orders = this.orderFacade.getAllOrders();
		return "faces/orders.jsp";
		
	}
	
	public String findCustomer(){
		this.order = this.orderFacade.findOrder(this.id);
		this.customer = this.order.getCustomer();
		System.out.println(this.customer.getAddress().getState());
		return "faces/customer.jsp";
	}
	
	public String processOrder(){
		this.order = this.orderFacade.findOrder(this.id);
		this.orderLines = this.orderLineFacade.getOrdersOrderLines(this.order);
		int lenght = this.orderLines.size();
		for(int i = 0; i<lenght; i++){
			OrderLine ol = this.orderLines.get(i);
			if(ol.getQuantity().intValue() > this.productFacade.findProduct(ol.getProduct().getId()).getDepositQuantity().intValue())
				return "faces/notProcessed.jsp";
			else{
				Product product = this.productFacade.findProduct(ol.getProduct().getId());
				product.setDepositQuantity(new Integer(product.getDepositQuantity().intValue() - ol.getQuantity().intValue()));
				this.productFacade.updateProduct(product);
			}
		}
		this.order.setEvasionDate(new Date());
		this.order.setOrderLines(this.orderLines);
		this.orderFacade.updateOrder(this.order);
		return "faces/processed.jsp";
	}
	
	public String findOrdersToBeFilled(){
		this.orders = this.orderFacade.getOrdersToBeFilled();
		return "faces/ordersToBeFilled.jsp";
	}
	
	public Float getTotal(List<OrderLine> orderLines){
		double total = 0;
		int lenght = orderLines.size();
		for(int i = 0; i<lenght; i++)
			total += orderLines.get(i).getSubTotal().doubleValue();
		return new Float(total);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	
	
	
	
	

}
