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
	
	private String facility;	//소화설비 비치
	private String evacuation;	//비상시 신속대피 가능
	
	private String modify_dt;
	private String create_dt;
}