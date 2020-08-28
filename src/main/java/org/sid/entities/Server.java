package org.sid.entities;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Server extends AbstractEntity {

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
	@OneToMany(mappedBy = "server", fetch = FetchType.LAZY)
	private Collection<Orders> orders;

	public Server() {
		super();
	}

	public Server(String firstName, String lastName, String phoneNumber, Collection<Orders> orders) {
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

	public void setPhoneNumber(String phonenumber) {
		this.phoneNumber = phonenumber;
	}

	public Collection<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Server [firstName=" + firstName + ", lastName=" + lastName + ", PhoneNumber=" + phoneNumber
				+ ", orders=" + orders + "]";
	}

}
