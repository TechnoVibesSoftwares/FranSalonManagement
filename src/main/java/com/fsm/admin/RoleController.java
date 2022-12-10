package com.fsm.admin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsm.util.JsonUtil;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RoleController {
	
	private static final Logger LOGGER = LogManager.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;
	
	@PostMapping("/saveRole")
	public ResponseEntity<Object> createOrSaveRole(@RequestBody RoleRequestBody requestBody) {
		LOGGER.info("Inside createOrSaveRole Controller");
		ResponseEntity<Object> responseEntity = null;
		responseEntity = new ResponseEntity<>(
				JsonUtil.convertJavaObjectToJson(roleService.createOrSaveUser(requestBody)), HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("/getRole")
	public ResponseEntity<Object> getRoleInformation(@RequestBody RoleRequestBody requestBody) {
		LOGGER.info("Inside getRoleInformation Controller");
		RoleResponseBody responseBody = new RoleResponseBody();
		ResponseEntity<Object> responseEntity = null;
		RoleEntity roleEntity = roleService.findById(requestBody.getId());
		if(roleEntity != null) {
			responseBody.setCreatedOn(roleEntity.getCreatedOn());
			responseBody.setDeleted(roleEntity.isDeleted());
			responseBody.setDescription("Success");
			responseBody.setId(roleEntity.getId());
			responseBody.setName(roleEntity.getName());
			responseBody.setStatusCode("7001");
		}else {
			responseBody.setDescription("Not Found");
			responseBody.setStatusCode("7003");
		}
		responseEntity = new ResponseEntity<>(
				JsonUtil.convertJavaObjectToJson(responseBody), HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("/sendemail")
	public ResponseEntity<Object> sendemail(@RequestBody Email requestBody) {
		LOGGER.info("Inside sendemail Controller");
		System.out.println("Data from angular server : "+requestBody);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		requestBody.setMessage("Success");
		ResponseEntity<Object> responseEntity = null;
		responseEntity = new ResponseEntity<>(
				JsonUtil.convertJavaObjectToJson(requestBody), HttpStatus.OK);
		return responseEntity;
	}
}
