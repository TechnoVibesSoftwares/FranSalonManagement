package com.fsm.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
	boolean existsByEmailId(String username);
	boolean existsByMobileNo(String mobileNo);
	CustomerEntity findByMobileNo(String mobileNo);
	CustomerEntity findByEmailId(String emailId);
}
