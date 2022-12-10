package com.fsm.vendor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsm.user.UserController;


@RestController
@CrossOrigin
public class VendorController {
	
	private static final Logger LOGGER = LogManager.getLogger(UserController.class);
	
	@Autowired
	private VendorService vendorService;

	@PostMapping("/addVender")
	public ResponseEntity<Object> createOrSaveVendor(@RequestBody VendorDetailsForm venForm) throws Exception {
		LOGGER.info("Inside Create Or Save Vendor");
		return ResponseEntity.ok(vendorService.createOrSaveVendor(venForm));
	}
}
