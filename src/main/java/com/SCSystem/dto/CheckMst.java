package com.SCSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder 
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CheckMst {
	private int idx;
	private int company_idx;
	private int manager_idx;
	private int charger_station_idx;
	private int distribution_idx;
	
	private String check_dt;
	private String temperature;
	private String adjustment;

	private String modify_dt;
	private String create_dt;
}