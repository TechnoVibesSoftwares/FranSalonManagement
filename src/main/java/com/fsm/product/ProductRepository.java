package com.fsm.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>
{
	ProductEntity findByVendorEmail(String vendorEmail);
	boolean existsByVendorEmail(String vendorEmail);
}
