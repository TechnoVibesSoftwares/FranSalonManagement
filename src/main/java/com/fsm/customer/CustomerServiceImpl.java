package com.fsm.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsm.admin.RoleRepository;
import com.fsm.common.PasswordResetRequest;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public CustomerEntity createOrSaveCustomer(CustomerForm form) {
		CustomerEntity entity = new CustomerEntity();
		
		entity.setIsActive(true);
		entity.setIsDeleted(false);
		entity.setRole(roleRepository.findByName("customer"));
		entity.setName(form.getName());
		entity.setDob(form.getDob());
		entity.setGender(form.getGender());
		entity.setMobileNo(form.getMobileNo());
		entity.setEmailId(form.getEmailId());
		entity.setPassword(bcryptEncoder.encode(form.getPassword()));
		entity.setDisplayPicUrl(form.getDisplayPicUrl());
		
		return customerRepository.saveAndFlush(entity);
	}

	@Override
	public CustomerEntity findByEmailId(String emailId) {
		return customerRepository.findByEmailId(emailId);
	}

	@Override
	public CustomerEntity findByMobileNo(String mobileNo) {
		return customerRepository.findByMobileNo(mobileNo);
	}
	
	@Override
	public boolean existsByEmailId(String customername) {
		return customerRepository.existsByEmailId(customername);
	}

	@Override
	public boolean existsByMobileNo(String mobileNo) {
		return customerRepository.existsByMobileNo(mobileNo);
	}
	@Override
	public String forgetPassword(PasswordResetRequest passwordResetRequestObj) {
		CustomerEntity customerEntity = customerRepository.findByEmailId(passwordResetRequestObj.getEmailId());
		if(customerEntity != null)
		{
//			customerEntity.setPassword(bcryptEncoder.encode(passwordResetRequestObj.getPassword()));
			customerEntity.setPassword(passwordResetRequestObj.getPassword());
			customerRepository.saveAndFlush(customerEntity);
			return "Password Reset Successfully!";
		}
		
		return "Password Cannot Reset ,Try Again!";
	}

}