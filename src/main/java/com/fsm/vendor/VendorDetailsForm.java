package com.fsm.vendor;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorDetailsForm {

	private String storeRegistrationNo;
	private String storeName;
	private String storeAddress;
	private String emailId;
	private String name;
	private String dob;
	private String gender;
	private String homeAddress;
	private String password;
	private String mobileNo;
	private String alternateMobileNo;
	private String role;
	private String storePhotoUrl;
	private String displayPicUrl;
	
}
