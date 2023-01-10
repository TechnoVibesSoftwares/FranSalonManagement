package com.fsm.product;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsm.util.JsonUtil;

@RestController
@CrossOrigin
public class ProductController {
	
	private static final Logger LOGGER = LogManager.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;
	
	@PostMapping("/addProduct")
	public ResponseEntity<Object> addProduct(@RequestBody ProductForm productForm) {
		LOGGER.info("Inside addProduct Controller");
		ResponseEntity<Object> responseEntity = null;
		responseEntity = new ResponseEntity<>(
				JsonUtil.convertJavaObjectToJson(productService.addProduct(productForm)), HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("/updateProduct")
	public ResponseEntity<Object> updateProduct(@RequestBody ProductForm form) {
		LOGGER.info("Inside Update Product");

		if (!productService.existsByEmailId(form.getVendorEmail())) {
			return ResponseEntity.badRequest().body("Email id is Not exists");
		}

		ResponseEntity<Object> responseEntity = null;
		responseEntity = new ResponseEntity<>(JsonUtil.convertJavaObjectToJson(productService.updateProduct(form)),
				HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/getProductList", method = RequestMethod.GET)
	public ResponseEntity<Object> getProductList() {
		LOGGER.info("Inside get Product List");

		ResponseEntity<Object> responseEntity = null;
		responseEntity = new ResponseEntity<>(JsonUtil.convertJavaObjectToJson(productService.getProductList()),
				HttpStatus.OK);

		return responseEntity;
	}
}
