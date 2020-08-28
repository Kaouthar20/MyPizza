package org.sid.entities;

import javax.persistence.Entity;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
public class Bill extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@DecimalMin(value = "30")
	private double totalPrice;

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(double totalPrice) {
		super();
		this.totalPrice = totalPrice;

	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
