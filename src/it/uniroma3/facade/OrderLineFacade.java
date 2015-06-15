package it.uniroma3.facade;

import java.util.List;

import it.uniroma3.model.OrderLine;
import it.uniroma3.model.Orders;
import it.uniroma3.model.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "olFacade")
public class OrderLineFacade {
	
	@PersistenceContext(unitName = "progetto-siw-2015")
	private EntityManager em;
	
	public OrderLine createOrderLine(Product product, Integer quantity, Orders order){
		OrderLine orderLine = new OrderLine(product, quantity, order);
		this.em.persist(orderLine);
		return orderLine;
	}
	
	@SuppressWarnings("unchecked")
	public List<OrderLine> getOrdersOrderLines(Orders order){
		return this.em.createNamedQuery("getOrdersOrderLines").setParameter("order", order).getResultList();
	}
	
	

}
