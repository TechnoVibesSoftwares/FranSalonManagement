package com.fsm.customer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsm.common.PasswordResetForm;
import com.fsm.serviceprovider.ServiceProviderForm;
import com.fsm.util.JsonUtil;

@RestController
@CrossOrigin
public class CustomerController {

	private static final Logger LOGGER = LogManager.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/registerCustomer")
	public ResponseEntity<Object> createOrSaveCustomer(@RequestBody CustomerForm form) {
		LOGGER.info("Inside Create Or SaveCustomer");
		ResponseEntity<Object> responseEntity = null;
		responseEntity = new ResponseEntity<>(
				JsonUtil.convertJavaObjectToJson(customerService.createOrSaveCustomer(form)), HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("/getCustomerDetails")
	public ResponseEntity<Object> findByMobile(@RequestBody FindByEmailAndMobileForm findByEmail) {
		LOGGER.info("Inside find by mail");
		ResponseEntity<Object> responseEntity = null;
		System.out.println("Mobile :" +findByEmail.getMobileNo());
		
		if(findByEmail.getMobileNo()!=null)
		{
			if(!customerService.existsByMobileNo(findByEmail.getMobileNo())) {
				return ResponseEntity.badRequest().body("Email id is Not exists");
			}
			responseEntity = new ResponseEntity<>(
					JsonUtil.convertJavaObjectToJson(customerService.findByMobileNo(findByEmail.getMobileNo())), HttpStatus.OK);
			
		}
		else if(findByEmail.getMobileNo() != null)
		{
			if(!customerService.existsByMobileNo(findByEmail.getMobileNo())) {
				return ResponseEntity.badRequest().body("Mobile number is Not exists");
			}
			responseEntity = new ResponseEntity<>(
					JsonUtil.convertJavaObjectToJson(customerService.findByMobileNo(findByEmail.getMobileNo())), HttpStatus.OK);
		}
		
		return responseEntity;
	}
	
	@PostMapping("/cust/forgetPassword")
	public ResponseEntity<Object> forgetPassword(@RequestBody PasswordResetForm passwordResetForm) {
		LOGGER.info("Inside Forget Password");
		
		if(!customerService.existsByEmailId(passwordResetForm.getEmailId())) {
			return ResponseEntity.badRequest().body("Email id is Not exists");
		}
		
	ResponseEntity<Object> responseEntity = null;
		responseEntity = new ResponseEntity<>(
				JsonUtil.convertJavaObjectToJson(customerService.forgetPassword(passwordResetForm)), HttpStatus.OK);
		return responseEntity;
	}
	
//	@PostMapping("/updateServiceProvider")
//	public ResponseEntity<Object> updateServiceProvider(@RequestBody CustomerForm form) {
//		LOGGER.info("Inside Forget Password");
//
//		if (!customerService.existsByEmailId(form.getEmailId())) {
//			return ResponseEntity.badRequest().body("Email id is Not exists");
//		}
//
//		ResponseEntity<Object> responseEntity = null;
//		responseEntity = new ResponseEntity<>(JsonUtil.convertJavaObjectToJson(customerService.updateCustomer(form)),
//				HttpStatus.OK);
//		return responseEntity;
//	}

}
