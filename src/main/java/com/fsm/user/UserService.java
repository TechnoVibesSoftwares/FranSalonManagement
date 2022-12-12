package com.fsm.user;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

	public UserEntity getUserInformation(Long id);
	public List<UserEntity> getUserList();
	public UserEntity createOrSaveUser(UserForm form);
	public UserEntity updateUser(UserForm user);	
	public UserEntity findByUserName(String emailId);
	public UserEntity findByEmailId(String emailId);
	public UserEntity findByMobileNo(String mobileNo);
	boolean existsByEmailId(String username);
	boolean existsByMobileNo(String mobileNo);
	public String forgetPassword(PasswordResetRequest passwordResetRequestObj);
	public String softDeletebymail(String emailId);
	
}
