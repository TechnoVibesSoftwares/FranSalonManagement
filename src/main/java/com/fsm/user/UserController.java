package com.fsm.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsm.util.JsonUtil;

@RestController
@CrossOrigin
public class UserController {

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	

	
	@PostMapping("/forgetPassword")
	public ResponseEntity<Object> createOrSaveUser(@RequestBody PasswordResetRequest passwordResetRequest) {
		LOGGER.info("Inside Forget Password");
		
		if(!userService.existsByEmailId(passwordResetRequest.getEmailId())) {
			return ResponseEntity.badRequest().body("Email id is Not exists");
		}
		
	ResponseEntity<Object> responseEntity = null;
		responseEntity = new ResponseEntity<>(
				JsonUtil.convertJavaObjectToJson(userService.forgetPassword(passwordResetRequest)), HttpStatus.OK);
		return responseEntity;
	}
	
	
	@RequestMapping(value="/getUserList", method = RequestMethod.GET)
	public ResponseEntity<Object> getUserList() {
		LOGGER.info("Inside get User List");
		
	ResponseEntity<Object> responseEntity = null;
		responseEntity = new ResponseEntity<>(
				JsonUtil.convertJavaObjectToJson(userService.getUserList()), HttpStatus.OK);
		
		return responseEntity;
	}
	
	/*
	 * @RequestMapping(value="/findByEmailId/{emailId}", method = RequestMethod.GET)
	 * public ResponseEntity<Object> existsByEmailId(@PathVariable("emailId") String
	 * emailId) { LOGGER.info("Inside Find by Email ID" +emailId); UserEntity
	 * userEntity = userService.findByEmailId(emailId); //return new
	 * ResponseEntity(userDetail, HttpStatus.OK); ResponseEntity<Object>
	 * responseEntity = null; responseEntity = new ResponseEntity<>(
	 * JsonUtil.convertJavaObjectToJson(userService.findByEmailId(emailId)),
	 * HttpStatus.OK); return responseEntity; }
	 * 
	 * 
	 * @RequestMapping(value="/findByMobileNo/{mobileNo}", method =
	 * RequestMethod.GET) public ResponseEntity<Object>
	 * existsByMobileNo(@PathVariable("mobileNo") String mobileNo) {
	 * LOGGER.info("Inside Find by Mobile Number" +mobileNo); //return
	 * repository.findById(id).get(); ResponseEntity<Object> responseEntity = null;
	 * responseEntity = new ResponseEntity<>(
	 * JsonUtil.convertJavaObjectToJson(userService.findByMobileNo(mobileNo)),
	 * HttpStatus.OK); return responseEntity; }
	 */
	
	@PostMapping("/findByMail")
	public ResponseEntity<Object> findByEmailId(@RequestBody FindByEmailAndMobileForm findByEmail) {
		LOGGER.info("Inside find by mail");
		ResponseEntity<Object> responseEntity = null;
		System.out.println("EmailId :" +findByEmail.getEmailId());
		
		if(findByEmail.getEmailId()!=null)
		{
			if(!userService.existsByEmailId(findByEmail.getEmailId())) {
				return ResponseEntity.badRequest().body("Email id is Not exists");
			}
			responseEntity = new ResponseEntity<>(
					JsonUtil.convertJavaObjectToJson(userService.findByEmailId(findByEmail.getEmailId())), HttpStatus.OK);
			
		}
		else if(findByEmail.getMobileNo() != null)
		{
			if(!userService.existsByMobileNo(findByEmail.getMobileNo())) {
				return ResponseEntity.badRequest().body("Mobile number is Not exists");
			}
			responseEntity = new ResponseEntity<>(
					JsonUtil.convertJavaObjectToJson(userService.findByMobileNo(findByEmail.getMobileNo())), HttpStatus.OK);
		}
		
		return responseEntity;
	}
	
	
	
	
	@PostMapping("/deleteByMail")
	public ResponseEntity<Object> softDeleteByMailId(@RequestBody FindByEmailAndMobileForm softDeletebymail) {
		LOGGER.info("Inside find by mail");
		ResponseEntity<Object> responseEntity = null;
		System.out.println("EmailId :" +softDeletebymail.getEmailId());
		
		if(softDeletebymail.getEmailId()!=null)
		{
			if(!userService.existsByEmailId(softDeletebymail.getEmailId())) {
				return ResponseEntity.badRequest().body("Email id is Not exists");
			}
			responseEntity = new ResponseEntity<>(
					JsonUtil.convertJavaObjectToJson(userService.softDeletebymail(softDeletebymail.getEmailId())), HttpStatus.OK);
			
		}
		
		
		return responseEntity;
	}
	
	
}
