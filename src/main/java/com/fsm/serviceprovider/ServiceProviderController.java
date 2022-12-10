package com.fsm.serviceprovider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsm.user.UserService;
import com.fsm.util.JsonUtil;


@RestController
@CrossOrigin
public class ServiceProviderController {

	private static final Logger LOGGER = LogManager.getLogger(ServiceProviderController.class);
	
	@Autowired
	private ServiceProviderService serviceProviderService;
	
	@PostMapping("/registerServiceProvider")
	public ResponseEntity<Object> createOrSaveServiceProvider(@RequestBody ServiceProviderForm form) {
		LOGGER.info("Inside Create Or SaveServiceProvider");
		ResponseEntity<Object> responseEntity = null;
		responseEntity = new ResponseEntity<>(
				JsonUtil.convertJavaObjectToJson(serviceProviderService.createOrSaveServiceProvider(form)), HttpStatus.OK);
		return responseEntity;
	}
	
	
}
