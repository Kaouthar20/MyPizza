package org.sid.dao;

import org.sid.entities.Pizza;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPizzaRepository extends JpaRepository<Pizza, Long> {
	@Query("select p from Pizza p where p.name like %:x%")
	public Page<Pizza> search(@Param("x") String mc, Pageable pageable);

}
