package com.fsm.serviceprovider;

import org.springframework.stereotype.Service;

import com.fsm.user.UserEntity;


@Service
public interface ServiceProviderService {

	public UserEntity createOrSaveServiceProvider(ServiceProviderForm form);
}
