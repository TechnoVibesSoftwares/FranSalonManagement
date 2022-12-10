package com.fsm.customer;

import org.springframework.stereotype.Service;

import com.fsm.common.PasswordResetRequest;

@Service
public interface CustomerService {

	public CustomerEntity createOrSaveCustomer(CustomerForm form);
	public CustomerEntity findByMobileNo(String mobileNo);
	public CustomerEntity findByEmailId(String emailId);
	boolean existsByEmailId(String username);
	boolean existsByMobileNo(String mobileNo);
	public String forgetPassword(PasswordResetRequest passwordResetRequestObj);
}
