package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FireSafety {
	private int idx;
	private int check_mst_idx;
	
	private String facility;
	private String evacuation;
	
	private String modify_dt;
	private String create_dt;
}