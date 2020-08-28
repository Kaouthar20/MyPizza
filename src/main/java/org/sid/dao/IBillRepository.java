package org.sid.dao;

import org.sid.entities.Bill;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillRepository extends JpaRepository<Bill, Long>{
 public Page<Bill> findById(Long id,Pageable pageable);
}
