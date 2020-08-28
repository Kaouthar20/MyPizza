package org.sid.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class DeliveryMan extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@Size(min = 2, max = 15)
	private String firstName;
	@NotNull
	@Size(min = 2, max = 15)
	private String lastName;
	@NotNull
	@Size(min = 10, max = 12)
	private String phoneNumber;
	@OneToMany(mappedBy = "deliveryMan", fetch = FetchType.LAZY)
	private Collection<Orders> orders;

	public DeliveryMan() {
		super();

	}

	public DeliveryMan(String firstName, String lastName, String phoneNumber, Collection<Orders> orders) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.orders = orders;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Collection<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Orders> orders) {
		this.orders = orders;
	}
}
