package com.fsm.vendor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fsm.admin.RoleEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;
	
	@CreationTimestamp
	private Timestamp createdOn;
	
	private Timestamp expirationDate;
	
	private Boolean isActive;
	
	private Boolean isDeleted;
	
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
	
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinTable(name = "user_roles", 
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//	@JoinColumn(name = "role")
//	private Set<RoleEntity> roles = new HashSet<>();
	
	

}
