package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Company {
	private int idx;
	private int company_grade_idx;;
	private String company_name;
	private String create_dt;
	private String modify_dt;
}
