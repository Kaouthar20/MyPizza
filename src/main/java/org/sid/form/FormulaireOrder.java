package org.sid.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FormulaireOrder {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOrder;
	private int amount;
	
	//private String status;

	private Long idPizza;

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


	/*
	 * public String getStatus() { return status; }
	 * 
	 * public void setStatus(String status) { this.status = status; }
	 */

	public Long getIdPizza() {
		return idPizza;
	}

	public void setIdPizza(Long idPizza) {
		this.idPizza = idPizza;
	}

}
