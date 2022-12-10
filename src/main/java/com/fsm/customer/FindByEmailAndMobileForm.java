package com.fsm.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindByEmailAndMobileForm 
{
	private String emailId;
	private String mobileNo;

}
