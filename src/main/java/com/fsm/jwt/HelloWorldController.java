package com.fsm.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsm.user.UserService;
import com.fsm.util.JsonUtil;

@RestController
public class HelloWorldController {
	
	@Autowired
	UserService service;

	@GetMapping("/hello")
	@CrossOrigin(origins = "http://localhost:8100")
	public String firstPage() {
		boolean existsByEmailId = service.existsByEmailId("raeshshandilkar@gmail.com");
		System.out.println("existsByEmailId : " +existsByEmailId);
		return "{\"name\":\"Rakesh\"}";
		
	}
	
	@GetMapping("/getData")
	public ResponseEntity<Object> getData(){
		System.out.println("inside get data ID : ");
		ResponseEntity<Object> responseEntity = null;
		responseEntity = new ResponseEntity<>(
				JsonUtil.convertJavaObjectToJson("Hi I am Rakesh"), HttpStatus.OK);
		
		return responseEntity;
	}

}