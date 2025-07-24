package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Manager {
	private int idx;
	private int company_idx;
	private int manager_grade_idx;
	private String id;
	private String password;
	private String name;
	private String phone;
	private float longitude;
	private float latitude;
	private String create_dt;
	private String modify_dt;
}
