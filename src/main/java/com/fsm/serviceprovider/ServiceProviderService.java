package com.fsm.serviceprovider;

import org.springframework.stereotype.Service;

import com.fsm.user.PasswordResetRequest;
import com.fsm.user.UserEntity;


@Service
public interface ServiceProviderService {

	public UserEntity createOrSaveServiceProvider(ServiceProviderForm form);
	public UserEntity updateServiceProvider(ServiceProviderForm form);	
	public UserEntity findByEmailId(String emailId);
	public UserEntity findByMobileNo(String mobileNo);
	boolean existsByEmailId(String username);
	boolean existsByMobileNo(String mobileNo);
	public String forgetPassword(PasswordResetRequest passwordResetRequestObj);
}
