package org.sid.entities;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Orders extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOrder;
	
	private int amount;

	
	@Transient
	private Long idPizza;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Pizza> pizzas;
	@ManyToOne
	@JoinColumn(name = "server_id")
	private Server server;
	@ManyToOne
	@JoinColumn(name = "deliveryMan_id")
	private DeliveryMan deliveryMan;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bill_id")
	private Bill bill;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(Date dateOrder,int amount, Collection<Pizza> pizzas,
			Server server, DeliveryMan deliveryMan, Customer customer, Bill bill) {
		super();
		this.dateOrder = dateOrder;
		this.amount=amount;
		
		this.pizzas = pizzas;
		this.server = server;
		this.deliveryMan = deliveryMan;
		this.customer = customer;
		this.bill = bill;
	}

	public Long getIdPizza() {
		return idPizza;
	}

	public void setIdPizza(Long idPizza) {
		this.idPizza = idPizza;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}



	public Collection<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(Collection<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public DeliveryMan getDeliveryMan() {
		return deliveryMan;
	}

	public void setDeliveryMan(DeliveryMan deliveryMan) {
		this.deliveryMan = deliveryMan;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

}
