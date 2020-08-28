package org.sid.dao;

import org.sid.entities.Orders;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Orders, Long>{
	 public Page<Orders> findById(Long id,Pageable pageable);
	
}
