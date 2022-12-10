package com.fsm.vendor;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsm.admin.RoleEntity;
import com.fsm.admin.RoleRepository;

@Service
@Transactional
public class VendorServiceImpl implements VendorService{

	@Autowired
	private VendorRepository vendorRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public VendorEntity createOrSaveVendor(VendorDetailsForm form) {
		VendorEntity entity = new VendorEntity();
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
	//	Optional<RoleEntity> findById = roleRepository.findById(2L);
//		Set<RoleEntity> roles = new HashSet<>();
//		roles.add(findById.get());
//		entity.setRoles(roles);
		entity.setStoreAddress(form.getStoreAddress());
		entity.setStoreName(form.getStoreName());
		entity.setStorePhotoUrl(form.getStorePhotoUrl());
		entity.setStoreRegistrationNo(form.getStoreRegistrationNo());
		
		return vendorRepository.saveAndFlush(entity);
	}

}
