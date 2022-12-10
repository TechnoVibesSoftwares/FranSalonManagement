package com.fsm.customer;

import org.springframework.stereotype.Service;

import com.fsm.common.PasswordResetForm;
import com.fsm.user.UserEntity;

@Service
public interface CustomerService {

	public UserEntity createOrSaveCustomer(CustomerForm form);
	public UserEntity findByMobileNo(String mobileNo);
	public UserEntity findByEmailId(String emailId);
	boolean existsByEmailId(String username);
	boolean existsByMobileNo(String mobileNo);
	public String forgetPassword(PasswordResetForm passwordResetRequestObj);
}
