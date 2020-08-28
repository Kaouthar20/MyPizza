package org.sid.dao;

import org.sid.entities.DeliveryMan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeliveryManReporsitory  extends JpaRepository<DeliveryMan, Long>{
	Page <DeliveryMan> findByfirstNameContains(String keyWord,Pageable pageable);

}
