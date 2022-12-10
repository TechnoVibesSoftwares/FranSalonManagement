package com.fsm.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.mail.MessagingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fsm.admin.RoleRepository;
import com.fsm.common.EmailService;
import com.fsm.user.UserEntity;
import com.fsm.user.UserForm;
import com.fsm.user.UserRepository;



@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	private static final Logger LOGGER = LogManager.getLogger(JwtUserDetailsService.class);
	
	@Autowired
	private UserRepository userDao;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private EmailService emailService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userDao.findByEmailId(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(),
				new ArrayList<>());
	}
	
	public UserEntity save(UserForm form) {
		UserEntity entity = new UserEntity();
		entity.setAlternateMobileNo(form.getAlternateMobileNo());
		entity.setDisplayPicUrl(form.getDisplayPicUrl());
		entity.setDob(form.getDob());
		entity.setEmailId(form.getEmailId().trim());
		entity.setHomeAddress(form.getHomeAddress());
		entity.setIsActive(true);
		entity.setIsDeleted(false);
		entity.setMobileNo(form.getMobileNo().trim());
		entity.setName(form.getName());
		entity.setPassword(bcryptEncoder.encode(form.getPassword()));
		entity.setRole(roleRepository.findByName("vendor"));
		entity.setStoreAddress(form.getStoreAddress());
		entity.setStoreName(form.getStoreName());
		entity.setStorePhotoUrl(form.getStorePhotoUrl());
		entity.setGender(form.getGender());
		entity.setStoreCategory(form.getStoreCategory());
		entity.setStoreType(form.getStoreType());
		entity.setAadharNo(form.getAadharNo());
		entity.setPanNo(form.getPanNo());
		entity.setAccountNo(form.getAccountNo());
		entity.setBankName(form.getBankName());
		entity.setBranch(form.getBranch());
		entity.setGstNo(form.getGstNo());
		entity.setIfscCode(form.getIfscCode());
		entity.setRevenueReportAnnually(form.getRevenueReportAnnually());
		entity.setRevenueReportMonthly(form.getRevenueReportMonthly());
		entity.setRevenueReportQuarterly(form.getRevenueReportQuarterly());
		entity.setSalesReportAnnually(form.getSalesReportAnnually());
		entity.setSalesReportMonthly(form.getSalesReportMonthly());
		entity.setSalesReportQuarterly(form.getSalesReportQuarterly());
	
		int hashCode = UUID.randomUUID().hashCode();
		entity.setStoreRegistrationNo("FS"+hashCode);
		
		UserEntity saved = userDao.saveAndFlush(entity);
		
		if(saved!=null) {
		try {
			emailService.sendEmail(form.getEmailId(), "Vendor Registered ", "Vendor Registered Successfully Password is : " + form.getPassword());
		} catch (MessagingException e) {
			e.printStackTrace();
			LOGGER.debug(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.debug(e.getMessage());
		}
		}
		return saved;
	}

}