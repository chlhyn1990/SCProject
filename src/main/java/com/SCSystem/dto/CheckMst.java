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
	
	private String check_dt;	//점검일자
	private String temperature;	//주변 온도/습도
	private String adjustment;	//정산여부

	private String modify_dt;
	private String create_dt;
}