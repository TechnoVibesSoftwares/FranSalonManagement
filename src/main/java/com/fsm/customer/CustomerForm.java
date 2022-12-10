package com.fsm.customer;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerForm {
	
	private String name;
	private String dob;
	private String gender;
	private String mobileNo;
	private String emailId;
	private String password;
	private String displayPicUrl;

}
