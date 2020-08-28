package org.sid.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Ingrediant extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@Size(min = 2, max = 100)
	private String nameIng;

	public Ingrediant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ingrediant(@NotNull @Size(min = 2, max = 100) String nameIng) {
		super();
		this.nameIng = nameIng;
	}

	public String getNameIng() {
		return nameIng;
	}

	public void setNameIng(String nameIng) {
		this.nameIng = nameIng;
	}

}
