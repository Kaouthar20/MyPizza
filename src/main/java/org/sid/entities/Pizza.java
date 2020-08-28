package org.sid.entities;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Pizza extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@Size(min = 5, max = 70)
	private String name;
	@DecimalMin("20")
	private double price;

	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Ingrediant> ingrediants;

	public Pizza() {
		super();

	}

	public Pizza(String name, double price, Collection<Ingrediant> ingrediants) {
		super();
		this.name = name;
		this.price = price;

		this.ingrediants = ingrediants;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Collection<Ingrediant> getIngrediants() {
		return ingrediants;
	}

	public void setIngrediants(Collection<Ingrediant> ingrediants) {
		this.ingrediants = ingrediants;
	}

}
