package com.fsm.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsm.admin.RoleRepository;
import com.fsm.common.PasswordResetForm;
import com.fsm.user.UserEntity;
import com.fsm.user.UserRepository;
import com.fsm.util.FormatUtil;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserEntity createOrSaveCustomer(CustomerForm form) {
		UserEntity entity = new UserEntity();
		
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
		
		return userRepository.saveAndFlush(entity);
	}

	@Override
	public UserEntity findByEmailId(String emailId) {
		return userRepository.findByEmailId(emailId);
	}

	@Override
	public UserEntity findByMobileNo(String mobileNo) {
		return userRepository.findByMobileNo(mobileNo);
	}
	
	@Override
	public boolean existsByEmailId(String customername) {
		return userRepository.existsByEmailId(customername);
	}

	@Override
	public boolean existsByMobileNo(String mobileNo) {
		return userRepository.existsByMobileNo(mobileNo);
	}
	@Override
	public String forgetPassword(PasswordResetForm passwordResetRequestObj) {
		UserEntity userEntity = userRepository.findByEmailId(passwordResetRequestObj.getEmailId());
		if(userEntity != null)
		{
//			userEntity.setPassword(bcryptEncoder.encode(passwordResetRequestObj.getPassword()));
			userEntity.setPassword(passwordResetRequestObj.getPassword());
			userRepository.saveAndFlush(userEntity);
			return "Password Reset Successfully!";
		}
		
		return "Password Cannot Reset ,Try Again!";
	}

	@Override
	public UserEntity updateCustomer(CustomerForm form) {
		UserEntity user = userRepository.findByEmailId(form.getEmailId());

		if (!FormatUtil.isNullOrEmpty(user)) {
			if (!form.getEmailId().equals("") && !form.getEmailId().equals("")) user.setEmailId(form.getEmailId()); else user.setEmailId(user.getEmailId());
			if (!form.getName().equals("") && !form.getName().equals("")) user.setName(form.getName()); else user.setName(user.getName());
			if (!form.getDob().equals("") && !form.getDob().equals("")) user.setDob(form.getDob()); else user.setDob(user.getDob());
			if (!form.getGender().equals("") && !form.getGender().equals("")) user.setGender(form.getGender()); else user.setGender(user.getGender());
			if (!form.getPassword().equals("") && !form.getPassword().equals("")) user.setPassword(form.getPassword()); else user.setPassword(user.getPassword());
			if (!form.getMobileNo().equals("") && !form.getMobileNo().equals("")) user.setMobileNo(form.getMobileNo()); else user.setMobileNo(user.getMobileNo());
		}
		return userRepository.saveAndFlush(user);
	}

}