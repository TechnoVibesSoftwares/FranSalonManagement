package com.fsm.admin;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequestBody {
	private Long id;
	private String name;
	private boolean isDeleted;
}
