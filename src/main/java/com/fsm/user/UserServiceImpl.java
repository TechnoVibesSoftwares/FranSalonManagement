package com.fsm.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsm.admin.RoleEntity;
import com.fsm.admin.RoleRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserEntity getUserInformation(Long id) {
		return userRepository.getById(id);
	}

	

	@Override
	public UserEntity createOrSaveUser(UserForm form) {
		UserEntity entity = new UserEntity();
		entity.setAlternateMobileNo(form.getAlternateMobileNo());
		entity.setDisplayPicUrl(form.getDisplayPicUrl());
		entity.setDob(form.getDob());
		entity.setEmailId(form.getEmailId());
		entity.setHomeAddress(form.getHomeAddress());
		entity.setIsActive(true);
		entity.setIsDeleted(false);
		entity.setMobileNo(form.getMobileNo());
		entity.setName(form.getName());
		entity.setPassword(bcryptEncoder.encode(form.getPassword()));
		Optional<RoleEntity> findById = roleRepository.findById(2L);
		
		System.out.println("Role Name : " + findById.get().getName());
		
		entity.setRole(findById.get());
		entity.setStoreAddress(form.getStoreAddress());
		entity.setStoreName(form.getStoreName());
		entity.setStorePhotoUrl(form.getStorePhotoUrl());
		
		return userRepository.saveAndFlush(entity);
	}

	@Override
	public UserEntity updateUser(UserForm user, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity findByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
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
	public String forgetPassword(PasswordResetRequest passwordResetRequestObj) {
		UserEntity userEntity = userRepository.findByEmailId(passwordResetRequestObj.getEmailId());
		if(userEntity != null)
		{
			userEntity.setPassword(bcryptEncoder.encode(passwordResetRequestObj.getPassword()));
			userRepository.saveAndFlush(userEntity);
			return "Password Reset Successfully!";
		}
		
		return "Password Cannot Reset ,Try Again!";
	}

	@Override
	public List<UserEntity> getUserList() {
		
		
		return userRepository.findAll();
	}



	@Override
	public boolean existsByEmailId(String username) {
		// TODO Auto-generated method stub
		return userRepository.existsByEmailId(username);
	}



	@Override
	public boolean existsByMobileNo(String mobileNo) {
		// TODO Auto-generated method stub
		return userRepository.existsByMobileNo(mobileNo);
	}



	@Override
	public String softDeletebymail(String emailId) {
		
			UserEntity user = userRepository.findByEmailId(emailId);
			user.setIsDeleted(true);
			
			UserEntity savedUserEntity = userRepository.save(user);
			if(savedUserEntity!=null)
			{
				return emailId + " is Successfully Deleted!";
				
			}
			
			return null;
		
	}

	
	
	



	
}
