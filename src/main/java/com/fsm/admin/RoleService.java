package com.fsm.admin;

import org.springframework.stereotype.Service;

@Service
public interface RoleService {
	public RoleEntity createOrSaveUser(RoleRequestBody requestBody);
	public RoleEntity findById(Long id);
	public boolean deleteById(Long id);
	public boolean UpdateById(Long id,RoleForm role);
}
