package com.fsm.serviceprovider;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProviderForm {

	private String name;
	private String address;
	private String emailId;
	private String dob;
	private String doj;
	private String gender;
	private String password;
	private String mobileNo;
	private String role;
    private String aadharNo;
	private String panNo;
	private String designation;
	private Long venderId;
	private String vendorEmailId;
	private String Salary;
}
