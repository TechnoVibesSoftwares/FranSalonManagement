package com.fsm.admin;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public RoleEntity createOrSaveUser(RoleRequestBody requestBody) {
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setName(requestBody.getName());
		roleEntity.setDeleted(false);
		roleRepository.saveAndFlush(roleEntity);
		return null;
	}

	@Override
	public RoleEntity findById(Long id) {
		Optional<RoleEntity> role= roleRepository.findById(id);
		if(role.isPresent()) {
			return role.get();
		}
		return null;
	}

	@Override
	public boolean deleteById(Long id) {
		roleRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean UpdateById(Long id, RoleForm role) {
		Optional<RoleEntity> roleOptional = roleRepository.findById(id);
		if(roleOptional.get() !=null) {
			RoleEntity roleEntity= roleOptional.get();
			roleEntity.setName(role.getRoleName());
			roleRepository.saveAndFlush(roleEntity);
			return true;
		}
		return false;
	}

}
