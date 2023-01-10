package com.fsm.product;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@CreationTimestamp
	private Timestamp createdOn;	
	private Timestamp expirationDate;
	private Boolean isActive;	
	private Boolean isDeleted;
	
	private String vendorEmail;
	private String productName;
	private String price;
	private String discount;
	private String netAmount;
}
