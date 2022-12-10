package com.fsm.admin;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponseBody {
	private Long id;
	private Timestamp createdOn;
	private String name;
	private boolean isDeleted; 
	private String description;
	private String statusCode;
}
