package org.sid.dao;


import org.sid.entities.Ingrediant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIngrediantRepository  extends JpaRepository<Ingrediant, Long>{
	Page <Ingrediant> findBynameIngContains(String keyWord,Pageable pageable);
}
