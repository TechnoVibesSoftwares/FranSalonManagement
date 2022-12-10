package com.fsm.customer;

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
public class CustomerEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;
	
	@CreationTimestamp
	private Timestamp createdOn;	
	private Timestamp expirationDate;	
	private Boolean isActive;	
	private Boolean isDeleted;
			
	@OneToOne
    private RoleEntity role;	
	private String name;
	private String dob;
	private String gender;
	private String mobileNo;
	private String emailId;
	private String password;
	private String displayPicUrl;
	
}
