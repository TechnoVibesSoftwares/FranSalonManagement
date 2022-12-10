package com.fsm.userprofile;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UserProfileEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long userId;

	private String firstName;
	
	private String lastName;

	private Timestamp lastAccessed;

//	@OneToOne
//    @JoinColumn(name = "role", nullable = false )
//    private RoleEntity role;

	private String displayPicUrl;
	
	private String employeeId ;

    private String gender;
	
	@Column(nullable = true)
	private Date dob;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getLastAccessed() {
		return lastAccessed;
	}

	public void setLastAccessed(Timestamp lastAccessed) {
		this.lastAccessed = lastAccessed;
	}

	public String getDisplayPicUrl() {
		return displayPicUrl;
	}

	public void setDisplayPicUrl(String displayPicUrl) {
		this.displayPicUrl = displayPicUrl;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
