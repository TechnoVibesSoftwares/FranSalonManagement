package com.fsm.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsm.user.UserEntity;
import com.fsm.user.UserRepository;
import com.fsm.util.FormatUtil;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public ProductEntity addProduct(ProductForm form) {
		ProductEntity entity = new ProductEntity();
		
		entity.setIsActive(true);
		entity.setIsDeleted(false);
		entity.setVendorEmail(form.getVendorEmail());
		entity.setProductName(form.getProductName());
		entity.setPrice(form.getPrice());
		entity.setDiscount(form.getDiscount());
		entity.setNetAmount(calNetAmount(form.getPrice(), form.getDiscount()));
		
		return productRepository.saveAndFlush(entity);
	}
	
	private String calNetAmount(String price, String discount) {
		int a = Integer.parseInt(price);
		int b = Integer.parseInt(discount);
		int disc =  a*b/100;
		int amt = a - disc;
		return Integer.toString(amt);
	}

	@Override
	public ProductEntity updateProduct(ProductForm form) {
		ProductEntity product = productRepository.findByVendorEmail(form.getVendorEmail());

		if (!FormatUtil.isNullOrEmpty(product)) {
			if (!form.getProductName().equals("") && !form.getProductName().equals(null)) product.setProductName(form.getProductName()); else product.setProductName(product.getProductName());
			if (!form.getPrice().equals("") && !form.getPrice().equals(null)) product.setPrice(form.getPrice()); else product.setPrice(product.getPrice());
			if (!form.getDiscount().equals("") && !form.getDiscount().equals(null)) product.setDiscount(form.getDiscount()); else product.setDiscount(product.getDiscount());
			if (!form.getDiscount().equals("") && !form.getPrice().equals("")) {
				product.setNetAmount(calNetAmount(form.getPrice(), form.getDiscount()));
			}
		}
		return productRepository.saveAndFlush(product);
	}

	@Override
	public ProductEntity findByEmailId(String vendorEmail) {
		return productRepository.findByVendorEmail(vendorEmail);
	}

	@Override
	public boolean existsByEmailId(String vendorEmail) {
		return productRepository.existsByVendorEmail(vendorEmail);
	}

	@Override
	public List<ProductEntity> getProductList() {
		return productRepository.findAll();
	}

	@Override
	public String deleteByEmail(String vendorEmail) {
		
		ProductEntity entity = productRepository.findByVendorEmail(vendorEmail);
		entity.setIsDeleted(true);
		entity.setIsActive(false);
				
		productRepository.saveAndFlush(entity);
		return "Product deleted successfully";
	}
}