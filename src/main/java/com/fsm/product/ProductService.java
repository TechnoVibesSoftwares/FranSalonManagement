package com.fsm.product;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ProductService {

	public ProductEntity addProduct(ProductForm form);
	public ProductEntity updateProduct(ProductForm form);
	public ProductEntity findByEmailId(String vendorEmail);
	boolean existsByEmailId(String vendorEmail);
	public List<ProductEntity> getProductList();
	
}
