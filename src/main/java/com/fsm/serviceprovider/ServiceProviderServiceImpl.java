package com.fsm.serviceprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsm.admin.RoleRepository;
import com.fsm.user.PasswordResetRequest;
import com.fsm.user.UserEntity;
import com.fsm.user.UserRepository;
import com.fsm.util.FormatUtil;


@Service
@Transactional
public class ServiceProviderServiceImpl implements ServiceProviderService{
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity createOrSaveServiceProvider(ServiceProviderForm form) {
		
		UserEntity commonEntity = new UserEntity();
		commonEntity.setName(form.getName());
		commonEntity.setDob(form.getDob());
		commonEntity.setPassword(bcryptEncoder.encode(form.getPassword()));
		commonEntity.setAadharNo(form.getAadharNo());
		commonEntity.setHomeAddress(form.getAddress());
		commonEntity.setIsActive(true);
		commonEntity.setIsDeleted(false);
		commonEntity.setDesignation(form.getDesignation());
		commonEntity.setIsActive(true);
		commonEntity.setIsDeleted(false);
		commonEntity.setRole(roleRepository.findByName("service"));
		commonEntity.setVendorId(form.getVenderId());
		commonEntity.setVendorEmailId(form.getVendorEmailId());
		commonEntity.setSalary(form.getSalary());
		commonEntity.setEmailId(form.getEmailId());
		commonEntity.setGender(form.getGender());
		commonEntity.setMobileNo(form.getMobileNo());
		return userRepository.saveAndFlush(commonEntity);
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
	public boolean existsByEmailId(String username) {
		return userRepository.existsByEmailId(username);
	}

	@Override
	public boolean existsByMobileNo(String mobileNo) {
		return userRepository.existsByMobileNo(mobileNo);
	}

	@Override
	public String forgetPassword(PasswordResetRequest passwordResetRequestObj) {
		UserEntity userEntity = userRepository.findByEmailId(passwordResetRequestObj.getEmailId());
		if (userEntity != null) {
			userEntity.setPassword(bcryptEncoder.encode(passwordResetRequestObj.getPassword()));
			userRepository.saveAndFlush(userEntity);
			return "Password Reset Successfully!";
		}

		return "Password Cannot Reset ,Try Again!";
	}

	@Override
	public UserEntity updateServiceProvider(ServiceProviderForm form) {
		UserEntity user = userRepository.findByEmailId(form.getEmailId());

		if (!FormatUtil.isNullOrEmpty(user)) {
			if (!form.getEmailId().equals("") && !form.getEmailId().equals("")) user.setEmailId(form.getEmailId()); else user.setEmailId(user.getEmailId());
			if (!form.getName().equals("") && !form.getName().equals("")) user.setName(form.getName()); else user.setName(user.getName());
			if (!form.getDob().equals("") && !form.getDob().equals("")) user.setDob(form.getDob()); else user.setDob(user.getDob());
			if (!form.getGender().equals("") && !form.getGender().equals("")) user.setGender(form.getGender()); else user.setGender(user.getGender());
			if (!form.getPassword().equals("") && !form.getPassword().equals("")) user.setPassword(form.getPassword()); else user.setPassword(user.getPassword());
			if (!form.getMobileNo().equals("") && !form.getMobileNo().equals("")) user.setMobileNo(form.getMobileNo()); else user.setMobileNo(user.getMobileNo());
			if (!form.getAadharNo().equals("") && !form.getAadharNo().equals("")) user.setAadharNo(form.getAadharNo()); else user.setAadharNo(user.getAadharNo());
			if (!form.getPanNo().equals("") && !form.getPanNo().equals("")) user.setPanNo(form.getPanNo()); else user.setPanNo(user.getPanNo());
			if (!form.getDesignation().equals("") && !form.getDesignation().equals("")) user.setDesignation(form.getDesignation()); else user.setDesignation(user.getDesignation());
			if (!form.getDoj().equals("") && !form.getDoj().equals("")) user.setDoj(form.getDoj()); else user.setDoj(user.getDoj());
			if (!form.getVendorEmailId().equals("") && !form.getVendorEmailId().equals("")) user.setVendorEmailId(form.getVendorEmailId()); else user.setVendorEmailId(user.getVendorEmailId());
			if (!form.getSalary().equals("") && !form.getSalary().equals("")) user.setSalary(form.getSalary()); else user.setSalary(user.getSalary());			
		}
		return userRepository.saveAndFlush(user);
	}
	

}
