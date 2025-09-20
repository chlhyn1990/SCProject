package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Opinion {
	private int idx;
	private int check_mst_idx;
	
	private String content;
	
	private String modify_dt;
	private String create_dt;
}