package com.fsm.userprofile;

import java.sql.Date;
import java.sql.Timestamp;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileForm {
	private Long userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String fullName;
	private String moblieNo;
	private String createdOn;
	private Timestamp expirationDate;
	private Timestamp lastAccessed;
	private Integer role;
	private String employeeId;
	private String gender;
	private Date dob;
	private Boolean isActive;
	private String roleName;
}
