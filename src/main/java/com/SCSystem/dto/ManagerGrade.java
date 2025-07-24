package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ManagerGrade {
	private int idx;
	private String grade_name;
	private String create_dt;
	private String modify_dt;
}
