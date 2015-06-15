package it.uniroma3.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import it.uniroma3.facade.CustomerFacade;
import it.uniroma3.facade.OrderFacade;
import it.uniroma3.facade.OrderLineFacade;
import it.uniroma3.model.Customer;
import it.uniroma3.model.OrderLine;
import it.uniroma3.model.Orders;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class OrderController {
	
	private Customer customer;
	private Long customerId;
	private Orders order;
	private List<OrderLine> orderLines;
	
	@EJB(beanName = "cFacade")
	private CustomerFacade customerFacade;
	
	@EJB(beanName = "oFacade")
	private OrderFacade orderFacade;
	
	@EJB(beanName = "olFacade")
	private OrderLineFacade orderLineFacade;
	
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
	
	public String getCurrentOrder(){
		this.customerId = getCustomerIdParameter();
		this.customer = this.customerFacade.findCustomer(this.customerId);
		this.order = this.orderFacade.getCart(this.customer);
		this.orderLines = this.orderLineFacade.getOrdersOrderLines(this.order);
		return "faces/cart.jsp";
	}
	
	public Long getCustomerIdParameter(){
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		 return Long.valueOf(params.get("customerId")).longValue();
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
	
	
	
	

}
