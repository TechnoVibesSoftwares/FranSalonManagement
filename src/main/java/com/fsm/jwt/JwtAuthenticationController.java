package com.fsm.jwt;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fsm.user.UserForm;
import com.fsm.user.UserService;


@RestController
@CrossOrigin
public class JwtAuthenticationController {

	private static final Logger LOGGER = LogManager.getLogger(JwtAuthenticationController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	UserService userService;
	
	

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<Object> saveUser(@RequestBody UserForm form) throws Exception {
		LOGGER.info("Inside Create Or Save Vender User Registration");
		System.out.println("Email Id : " +form.getEmailId());
		
		  if(userService.existsByEmailId(form.getEmailId())) { return
		  ResponseEntity.badRequest().body("Email id is already exists"); }
		  if(userService.existsByMobileNo(form.getMobileNo())) { return
		  ResponseEntity.badRequest().body("Mobile No. is already exists"); }
		 
		return ResponseEntity.ok(userDetailsService.save(form));
	}	
	
//	@PostMapping("/register")
//	public ResponseEntity<Object> saveUser(@RequestBody UserDTO user) throws Exception {
//		return ResponseEntity.ok(userDetailsService.save(user));
//	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}