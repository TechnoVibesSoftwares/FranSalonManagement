package com.fsm.user;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fsm.admin.RoleEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;
	
	@CreationTimestamp
	private Timestamp createdOn;
	
	private Timestamp expirationDate;
	
	private Boolean isActive;
	
	private Boolean isDeleted;
	
	private String gstNo;
	
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
	
	private String storePhotoUrl;
	
	private String displayPicUrl;
	
	@OneToOne
    private RoleEntity role;
	
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
	
	//SP data
    private String designation;
	private String doj; 
	private Long vendorId;
	private String vendorEmailId;
	private String Salary;
	
}
