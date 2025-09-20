package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Compatibility {
	private int idx;
	private int check_mst_idx;
	
	private String open;
	private String access;
	private String milestone;
	private String rapid;
	private String space;
	private String free;
	
	private String modify_dt;
	private String create_dt;
}