package org.sid.dao;

import org.sid.entities.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long>{
	Page <Customer> findByfirstNameContains(String keyWord,Pageable pageable);
	        /*customer
			public void toOrder( );
			public void cancel();
			public void toRegister( );
			public void payOrder( );*/
}
