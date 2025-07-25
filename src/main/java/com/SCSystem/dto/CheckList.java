package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CheckList {
	private int idx;
	private int company_idx;
	private int manager_idx;
	private String checking_name;
	private String photo_yn;
	private String create_dt;
	private String modify_dt;
}
