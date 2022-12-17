package com.fsm.iot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsm.util.JsonUtil;


@RestController
@CrossOrigin
public class IOTController {
	
	private static final Logger LOGGER = LogManager.getLogger(IOTController.class);
	
	@Autowired
    RFIDService rfidService;
	
	@GetMapping("/getData34")
	public ResponseEntity<Object> getData(){
		System.out.println("inside get data");
		ResponseEntity<Object> responseEntity = null;
		responseEntity = new ResponseEntity<>(
				JsonUtil.convertJavaObjectToJson("Hi I am Rakesh"), HttpStatus.OK);
		
		return responseEntity;
	}
	
	@PostMapping("/addCardId")
	public ResponseEntity<Object> getCardId(@RequestBody RFIDCard rfidCard){
		System.out.println("inside getCardId : " + rfidCard.getRf_id());
		ResponseEntity<Object> responseEntity = null;
		responseEntity = new ResponseEntity<>(
				JsonUtil.convertJavaObjectToJson(rfidService.addRFIDCard(rfidCard)), HttpStatus.OK);
		
		return responseEntity;
	}
	
	@GetMapping("/getProduct/{id}")
	public ResponseEntity<Object> findProductId(@PathVariable Long id) {
		System.out.println("findProductId ID is :"+ id);
		ResponseEntity<Object> responseEntity = null;
		responseEntity = new ResponseEntity<>(
				JsonUtil.convertJavaObjectToJson("RS0001"), HttpStatus.OK);
		
		return responseEntity;
    }
	
	 @PostMapping("/saveProduct")
	 public ResponseEntity<Object> saveProduct(@RequestBody SensorData sensorData) {
			System.out.println("ID : "+ sensorData.getId());
			System.out.println("NAME : "+ sensorData.getName());
			ResponseEntity<Object> responseEntity = null;
			responseEntity = new ResponseEntity<>(
					JsonUtil.convertJavaObjectToJson("Product Successfully Saved"), HttpStatus.OK);
			
			return responseEntity;
	    }

	 @GetMapping("/getRFIDCards")
		public ResponseEntity<Object> getRFIDCardList() {
			System.out.println("Inside getRFIDCardList");
			ResponseEntity<Object> responseEntity = null;
			responseEntity = new ResponseEntity<>(
					JsonUtil.convertJavaObjectToJson(rfidService.getRFIDCardList()), HttpStatus.OK);
			
			return responseEntity;
	    }
	 
}
