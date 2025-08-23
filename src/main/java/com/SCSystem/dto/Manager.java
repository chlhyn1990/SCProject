package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder 
@AllArgsConstructor
@Data
public class Manager {
	public Manager(){

	}

	private int idx;
	private int company_idx;
	private int manager_grade_idx;
	private String manager_grade_name;
	private String company_name;
	private String id;
	private String password;
	private String name;
	private String phone;
	private float longitude;
	private float latitude;
	private String create_dt;
	private String modify_dt;
}
