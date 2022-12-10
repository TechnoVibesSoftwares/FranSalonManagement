package com.fsm.user;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
	
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
    private String storeType;
	private String storeCategory;
    private String aadharNo;
	private String panNo;
	
	private String salesReportMonthly;
	private String salesReportQuarterly;
	private String salesReportAnnually;
	
	private String revenueReportMonthly;
	private String revenueReportQuarterly;
	private String revenueReportAnnually;
	
	private String bankName;
	private String accountNo;
	private String ifscCode;
	private String branch;
	
	private String gstNo;

}
