package com.fsm.serviceprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsm.admin.RoleRepository;
import com.fsm.user.UserEntity;
import com.fsm.user.UserRepository;
import com.fsm.user.UserService;


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
	

}
