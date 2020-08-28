package org.sid.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Customer extends AbstractEntity {
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
	@Size(min = 5, max = 100)
	private String address;
	@NotNull
	@Size(min = 10, max = 20)
	private String email;
	@NotNull
	@Size(min = 10, max = 15)
	private String phoneNumber;
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Collection<Orders> orders;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String firstName, String lastName, String address, String email, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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