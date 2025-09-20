package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ElectricalStability {
	private int idx;
	private int check_mst_idx;
	
	private String temperature;
	private String gas;
	private String openness;
	private String slip;
	private String ventilation;
	private String snowrain;
	private String flooding;
	private String vibration;
	
	private String modify_dt;
	private String create_dt;
}