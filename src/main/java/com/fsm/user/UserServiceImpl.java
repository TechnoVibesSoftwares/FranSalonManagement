package com.fsm.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsm.admin.RoleEntity;
import com.fsm.admin.RoleRepository;
import com.fsm.util.FormatUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService {

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
		if (userEntity != null) {
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
		return userRepository.existsByEmailId(username);
	}

	@Override
	public boolean existsByMobileNo(String mobileNo) {
		return userRepository.existsByMobileNo(mobileNo);
	}

	@Override
	public String softDeletebymail(String emailId) {

		UserEntity user = userRepository.findByEmailId(emailId);
		user.setIsDeleted(true);

		UserEntity savedUserEntity = userRepository.save(user);
		if (savedUserEntity != null) {
			return emailId + " is Successfully Deleted!";

		}

		return null;

	}

	@Override
	public UserEntity updateUser(UserForm form) {
		UserEntity user = userRepository.findByEmailId(form.getEmailId());

		if (!FormatUtil.isNullOrEmpty(user)) {
			if (!form.getGstNo().equals("") && !form.getGstNo().equals("")) user.setGstNo(form.getGstNo()); else user.setGstNo(user.getGstNo());
			if (!form.getStoreRegistrationNo().equals("") && !form.getStoreRegistrationNo().equals("")) user.setStoreRegistrationNo(form.getStoreRegistrationNo()); else user.setStoreRegistrationNo(user.getStoreRegistrationNo());
			if (!form.getStoreName().equals("") && !form.getStoreName().equals("")) user.setStoreName(form.getStoreName()); else user.setStoreName(user.getStoreName());
			if (!form.getStoreAddress().equals("") && !form.getStoreAddress().equals("")) user.setStoreAddress(form.getStoreAddress()); else user.setStoreAddress(user.getStoreAddress());
			if (!form.getEmailId().equals("") && !form.getEmailId().equals("")) user.setEmailId(form.getEmailId()); else user.setEmailId(user.getEmailId());
			if (!form.getName().equals("") && !form.getName().equals("")) user.setName(form.getName()); else user.setName(user.getName());
			if (!form.getDob().equals("") && !form.getDob().equals("")) user.setDob(form.getDob()); else user.setDob(user.getDob());
			if (!form.getGender().equals("") && !form.getGender().equals("")) user.setGender(form.getGender()); else user.setGender(user.getGender());
			if (!form.getHomeAddress().equals("") && !form.getHomeAddress().equals("")) user.setHomeAddress(form.getHomeAddress()); else user.setHomeAddress(user.getHomeAddress());
			if (!form.getPassword().equals("") && !form.getPassword().equals("")) user.setPassword(form.getPassword()); else user.setPassword(user.getPassword());
			if (!form.getMobileNo().equals("") && !form.getMobileNo().equals("")) user.setMobileNo(form.getMobileNo()); else user.setMobileNo(user.getMobileNo());
			if (!form.getAlternateMobileNo().equals("") && !form.getAlternateMobileNo().equals("")) user.setAlternateMobileNo(form.getAlternateMobileNo()); else user.setAlternateMobileNo(user.getAlternateMobileNo());
			if (!form.getStorePhotoUrl().equals("") && !form.getStorePhotoUrl().equals("")) user.setStorePhotoUrl(form.getStorePhotoUrl()); else user.setStorePhotoUrl(user.getStorePhotoUrl());
			if (!form.getDisplayPicUrl().equals("") && !form.getDisplayPicUrl().equals("")) user.setDisplayPicUrl(form.getDisplayPicUrl()); else user.setDisplayPicUrl(user.getDisplayPicUrl());
			if (!form.getStoreType().equals("") && !form.getStoreType().equals("")) user.setStoreType(form.getStoreType()); else user.setStoreType(user.getStoreType());
			if (!form.getStoreCategory().equals("") && !form.getStoreCategory().equals("")) user.setStoreCategory(form.getStoreCategory()); else user.setStoreCategory(user.getStoreCategory());
			if (!form.getAadharNo().equals("") && !form.getAadharNo().equals("")) user.setAadharNo(form.getAadharNo()); else user.setAadharNo(user.getAadharNo());
			if (!form.getPanNo().equals("") && !form.getPanNo().equals("")) user.setPanNo(form.getPanNo()); else user.setPanNo(user.getPanNo());
			if (!form.getSalesReportMonthly().equals("") && !form.getSalesReportMonthly().equals("")) user.setSalesReportMonthly(form.getSalesReportMonthly()); else user.setSalesReportMonthly(user.getSalesReportMonthly());
			if (!form.getSalesReportQuarterly().equals("") && !form.getSalesReportQuarterly().equals("")) user.setSalesReportQuarterly(form.getSalesReportQuarterly()); else user.setSalesReportQuarterly(user.getSalesReportQuarterly());
			if (!form.getSalesReportAnnually().equals("") && !form.getSalesReportAnnually().equals("")) user.setSalesReportAnnually(form.getSalesReportAnnually()); else user.setSalesReportAnnually(user.getSalesReportAnnually());
			if (!form.getRevenueReportMonthly().equals("") && !form.getRevenueReportMonthly().equals("")) user.setRevenueReportMonthly(form.getRevenueReportMonthly()); else user.setRevenueReportMonthly(user.getRevenueReportMonthly());
			if (!form.getRevenueReportQuarterly().equals("") && !form.getRevenueReportQuarterly().equals("")) user.setRevenueReportQuarterly(form.getRevenueReportQuarterly()); else user.setRevenueReportQuarterly(user.getRevenueReportQuarterly());
			if (!form.getRevenueReportAnnually().equals("") && !form.getRevenueReportAnnually().equals("")) user.setRevenueReportAnnually(form.getRevenueReportAnnually()); else user.setRevenueReportAnnually(user.getRevenueReportAnnually());
			if (!form.getBankName().equals("") && !form.getBankName().equals("")) user.setBankName(form.getBankName()); else user.setBankName(user.getBankName());
			if (!form.getAccountNo().equals("") && !form.getAccountNo().equals("")) user.setAccountNo(form.getAccountNo()); else user.setAccountNo(user.getAccountNo());
			if (!form.getIfscCode().equals("") && !form.getIfscCode().equals("")) user.setIfscCode(form.getIfscCode()); else user.setIfscCode(user.getIfscCode());
			if (!form.getBranch().equals("") && !form.getBranch().equals("")) user.setBranch(form.getBranch()); else user.setBranch(user.getBranch());
			
		}
		return userRepository.saveAndFlush(user);
	}

}
