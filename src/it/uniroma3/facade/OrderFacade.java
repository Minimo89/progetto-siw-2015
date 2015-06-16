package it.uniroma3.facade;

import java.util.List;

import it.uniroma3.model.Customer;
import it.uniroma3.model.Orders;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless(name = "oFacade")
public class OrderFacade {
	
	@PersistenceContext(unitName = "progetto-siw-2015")
	private EntityManager em;
	
	public Orders getCart(Customer customer){
		Orders order = null;
		try{
			order = (Orders) this.em.createNamedQuery("getCart").setParameter("customer", customer).getSingleResult();
		} catch(Exception e){
			e.printStackTrace();
		}
		return order;
	}
	
	@SuppressWarnings("unchecked")
	public List<Orders> getCustomersOrders(Customer customer){
		List<Orders> orders;
		try{
			orders = this.em.createNamedQuery("getCustomersOrders").setParameter("customer", customer).getResultList();
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return orders;
	}
	
	public Orders createOrder(Customer customer){
		Orders order = new Orders(customer);
		this.em.persist(order);
		return order;
	}
	
	public void updateOrder(Orders order){
		this.em.merge(order);
	}
	
	@SuppressWarnings("unchecked")
	public List<Orders> getAllOrders(){
		List<Orders> orders;
		orders = this.em.createNamedQuery("getAllOrders").getResultList();
		return orders;
	}
	
	public Orders findOrder(Long id){
		Orders order = this.em.find(Orders.class, id);
		return order;
	}
	
	@SuppressWarnings("unchecked")
	public List<Orders> getOrdersToBeFilled(){
		List<Orders> orders = this.em.createNamedQuery("getOrdersToBeFilled").getResultList();
		return orders;
	}

}
