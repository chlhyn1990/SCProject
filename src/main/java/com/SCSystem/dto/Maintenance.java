package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Maintenance {
	private int idx;
	private int check_mst_idx;
	
	private String contact;
	private String organize;
	private String ascenter;
	private String complaint;
	private String light;
	
	private String modify_dt;
	private String create_dt;
}